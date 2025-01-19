<template>
  <div>
<!--    Main select dropdown to select the desired voting results-->
    <h1>Select the desired voting results down below!</h1>
    <select v-model="selectedType">
      <option disabled value="">Select a type</option>
      <option value="party">Party</option>
      <option value="region">Region</option>
    </select>

<!--    Sub-select dropdowns for party option-->
    <div v-if="selectedType === 'party'">
      <select v-model="selectedParty">
        <option disabled value="">Select a party</option>
        <option v-for="party in parties" :key="party.id" :value="party.id">{{ party.name }}</option>
      </select>

      <select v-model="selectedRegion">
        <option disabled value="">Select a region</option>
        <option v-for="region in regions" :key="region.regionCode" :value="region.regionCode">{{ region.name }}</option>
      </select>

      <button @click="applyFilters">Apply</button>
    </div>

<!--    Sub-select dropdowns for region option-->
    <div v-else-if="selectedType === 'region'">
      <select v-model="selectedRegion" @change="loadCities">
        <option disabled value="">Select a province</option>
        <option v-for="region in regions" :key="region.regionCode" :value="region.regionCode">{{ region.name }}</option>
      </select>

      <select v-if="selectedRegion" v-model="selectedCity" @change="">
        <option disabled value="">Select a city</option>
        <option value="all">All cities</option>
        <option v-for="city in cities" :key="city.regionCode" :value="city.regionCode">{{ city.name }}</option>
      </select>

      <button v-if="selectedCity" @click="applyCities">Apply</button>
    </div>

    <canvas id="electionChart" width="600" height="180"></canvas>
  </div>
</template>

<script>
import axios from 'axios';
import { Chart, BarController, BarElement, CategoryScale, LinearScale, Title } from 'chart.js';
import ChartDataLabels from 'chartjs-plugin-datalabels';

Chart.register(BarController, BarElement, CategoryScale, LinearScale, Title, ChartDataLabels);

export default {
  data() {
    return {
      selectedType: "",
      selectedParty: '',
      selectedRegion: '',
      selectedCity: '',
      selectedProvince: '',
      data: [],
      parties: [],
      regions: [],
      cities: [],
      chart: null
    };
  },

  /**
   * Lifecycle hook to initialize data and create the chart on component mount.
   */
  mounted() {
    axios
        .all([
          axios.get('/votesperparty/votesperregion?regionCode=L528'),
          axios.get('/party/all'),
          axios.get('/region/province')
        ])
        .then(responses => {
          const dataResponse = responses[0].data;
          const partyResponse = responses[1].data;
          const regionResponse = responses[2].data;

          const enrichedData = dataResponse.map(item => {
            const matchingParty = partyResponse.find(party => party.id === item.partyId);
            return {
              ...item,
              partyName: matchingParty ? matchingParty.name : null
            };
          });

          this.data = enrichedData;
          this.parties = partyResponse;
          this.regions = regionResponse;
          this.createChart(this.data);
        })
        .catch(error => {
          console.error("An error occurred while fetching data:", error);
        });
  },

  methods: {
    /**
     * Applies selected filters and updates the chart data based on the user selection.
     */
    applyFilters() {
      const url = 'http://stijngerkema.nl:8080/votesperparty/partyvotesperregion';

      const params = {
        ...(this.selectedParty && { partyId: parseInt(this.selectedParty) }),
        ...(this.selectedRegion && { regionCode: this.selectedRegion }),
        ...(this.selectedCity && { cityCode: this.selectedCity })
      };

      axios
          .get(url, { params })
          .then(response => {
            const fetchedData = response.data.map(item => ({
              ...item,
              partyName: this.parties.find(party => party.id === item.partyId)?.name || 'Unknown'
            }));

            this.updateChart(fetchedData);
          })
          .catch(error => {
            console.error("Error fetching filtered data:", error);
          });
    },

    /**
     * Loads cities based on the selected region.
     */
    applyCities() {
      if (!this.selectedRegion) {
        this.cities = [];
        return;
      }

      axios
          .get(`http://stijngerkema.nl:8080/votesperparty/allvotesperregion/${this.selectedCity}`)
          .then(response => {
            const fetchedCities = response.data.map(item => ({
              ...item,
              partyName: this.parties.find(party => party.id === item.partyId)?.name || 'Unknown'
            }));

            this.updateChart(fetchedCities);
            console.log(this.selectedCity);
          })
          .catch(error => {
            console.error("Error fetching cities:", error);
          });
    },

    loadCities() {
      if (!this.selectedRegion) {
        this.cities = [];
        return;
      }
      axios
          .get(`http://stijngerkema.nl:8080/region/greatParent/${this.selectedRegion}`)
          .then(response => {
            this.cities = response.data;
            console.log(this.selectedRegion);
          })
          .catch(error => {
            console.error("Error fetching cities:", error);
          });
    },

    /**
     * Creates a bar chart using the provided data.
     * @param {Array} data - Data to be visualized in the chart.
     */
    createChart(data) {
      const ctx = document.getElementById('electionChart').getContext('2d');
      const labels = data.map(item => item.partyName || 'Unknown');
      const votes = data.map(item => item.value);

      const selectedPartyName = this.parties.find(party => party.id === parseInt(this.selectedParty))?.name || 'All';
      const selectedRegionName = this.regions.find(region => region.regionCode === this.selectedRegion)?.name || 'All Regions';

      const chartTitle = `Votes for ${selectedPartyName} in ${selectedRegionName}`;

      this.chart = new Chart(ctx, {
        type: 'bar',
        data: {
          labels: labels,
          datasets: [{
            label: `Number of Votes`,
            data: votes,
            backgroundColor: 'rgba(75, 192, 192, 0.2)',
            borderColor: 'rgba(75, 192, 192, 1)',
            borderWidth: 1
          }]
        },
        options: {
          scales: {
            y: {
              beginAtZero: true
            }
          },
          plugins: {
            title: {
              padding: 30,
              display: true,
              text: chartTitle,
              font: {
                size: 20,
              }
            },
            datalabels: {
              anchor: 'end',
              align: 'end',
              color: '#000',
              font: {
                weight: 'bold',
                size: 12
              },
              formatter: value => value
            }
          }
        }
      });
    },

    /**
     * Updates the existing chart with new data.
     * @param {Array} data - New data to update the chart.
     */
    updateChart(data) {
      if (this.chart) {
        this.chart.destroy();
      }
      this.createChart(data);
    }
  }
};
</script>

<style scoped>
canvas {
  margin-top: 6vw;
  margin-left: 2vw;
  margin-right: 2vw;
}

h1 {
  margin-top: 2vw;
  margin-left: 2vw;
}

select {
  margin-top: 2vw;
  padding: 0.5vw;
  margin-left: 2vw;
  font-size: 1.2em;
  border-radius: 5px;
  border: 1px solid #ccc;
  background-color: #f8f8f8;
  color: #333;
  cursor: pointer;
}

button {
  margin-top: 2vw;
  padding: 0.5vw;
  margin-left: 2vw;
  font-size: 1.2em;
  border-radius: 5px;
  border: 1px solid #ccc;
  background-color: #f8f8f8;
  color: #333;
  cursor: pointer;
}
</style>
