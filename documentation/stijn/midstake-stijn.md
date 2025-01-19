# Proof for learning outcomes

## 9.2 Learning Outcome 1: Design, build, test and deploy a full-stack web application with a layered and scalable architecture

### 9.2.1 Design and develop modern front-end applications using modern frameworks.
#### Stijn
Ik ben aan de slag gegaan met het maken van de front-end van de applicatie. Ik heb gebruik gemaakt van Vue.js om de front-end te realiseren. Ik heb gebruik gemaakt van de vue router om de verschillende pagina's te navigeren. (/frontend-vue/src/src/router/index.js) Ik heb gebruik gemaakt van ChartJS framework om gebruik om de verkiezingsdata te tonen. Dit alles samen vormt dus de gevraagde single page application.

### 9.2.2 Design and develop modern backed-end applications using modern framework
#### Stijn
Ik heb de backend gemaakt in java, dit was compleet nieuw voor mij dit semester. Ik heb hierbij gebruik gemaakt van de springboot en hibernate als frameworks. Ook heb ik gebruik gemaakt van spring security om de JWT tokens te implementeren.

### 9.2.3 Apply and understand Dependency Inversion and Dependency Injection
#### Stijn
Ik heb dependancy injection eigenlijk al toegepast toen ik begon te werken in de backend, dit gaat om het gebruik van de annotations voor bijvoorbeeld de models of entities.

- We hebben gebruik gemaakt van de Spring & Hibernate annotations. (Te vinden in de backend, I.E. @RestController, @Requestmapping, @CrossOrigin)

### 9.2.4 Explain and justify the layered, logical architecture of the design of an Enterprise Web Application
#### Stijn
We zijn dit project begonnen zonder kennis over hoe we het beste de applicatie konden opzetten, we hebben hiervoor een class diagram gemaakt en hier feedback op gevraagd. Hieruit bleek dat we al aardig goed op weg waren. Alleen hadden we dit nog niet goed gevisualiseerd in het diagram. We hebben deze feedback nu ook toegepast door de verschillende lagen onder elkaar neer te zetten, en het verkeer tussen deze lagen weer te geven. Hierdoor maken we nu goed gebruik van controllers, services en repositories, en maken deze een goede connectie met de frontend.

### 9.2.5.Design and develop the persistence layer in the back end of a web application, including an Object to Relational Mapper (ORM) that integrates a Relational Database
#### Stijn
Zoals in onze entities te zien is, geven wij hierin de tabel en kolomnamen aan die we willen gebruiken in de database. Dit is een voorbeeld van hoe we de database hebben uitgestippeld en hoe we deze hebben geimplementeerd in de backend. In onze repositories maken we ook gebruik van de custom queries in hibernate en spring. Het is de bedoeling dat we dit compleet SQL vrij kunnen doen, maar in een enkel geval kregen we dit helaas niet voor elkaar en hebben dus de spring JPA moeten gebruiken. Hieronder staan een aantal voorbeelden van hoe ik dit heb toegepast:
Voorbeeld van een custom query in de repository met gebruik van de hibernate JPA:
```java
@Query("SELECT v FROM VotesPerParty v WHERE v.regionCode = :regionCode")
    List<VotesPerParty> findAllByRegionCode(@Param("regionCode") String regionCode);
```
Voorbeeld van een custom query in de repository met gebruik van de spring JPA:
```java
@Query("SELECT new com.election.backendjava.models.region.RegionDTO(r.regionCode, r.name) " +
        "FROM Region r WHERE r.regionCode LIKE %:pattern% " +
        "ORDER BY r.name ASC")
List<RegionDTO> findRegionsWithPattern(@Param("pattern") String pattern);
```
### 9.2.6 Design and implement the security controls of authentication and authorisation in an Enterprise Web Application
#### Stijn
We hebben JWT tokens toegepast in de backend voor user authenticatie. Dit wordt gedaan in de JwtService bestand.

Een jwt token bestaad uit een header (de informatie over hoe de token is gemaakt), payload(de gegevens die moeten worden meegegeven) en signature(zorgt ervoor dat de token niet kan worden aangepast). De header bevat het type token en het algoritme dat gebruikt wordt om de signature te maken. De payload bevat de claims, dit zijn de gegevens die in de token worden opgeslagen. De signature is een hash van de header, payload en een secret key. Deze signature wordt gebruikt om te controleren of de token niet is aangepast.
Onze secret key staat nu nog hardcoded in de backend, maar we zijn ons er van bewust dat deze in een .env bestand moet komen, en dan ook nog eens in de git ignore moet worden gezet, zodat deze niet zomaar achterhaald kan worden.

Payload claims:
```java
return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + this.jwtExperation))
                .signWith(this.getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

```
### 9.2.7 Use functional interfaces and lambda expression
#### Stijn
Dit is de lambda functie die ik in de security config heb toegepast: ".csrf(csrf -> csrf.disable())"

1. .csrf(...):
   Deze methode opent de configuratie voor CSRF-instellingen in Spring Security.

2. (csrf -> csrf.disable()):
   Dit is een lambda-expressie. csrf is het object dat Spring aan de lambda doorgeeft. Dit object biedt methodes om CSRF-instellingen aan te passen.
   csrf.disable() schakelt de CSRF-bescherming volledig uit.

3. Resultaat:
   Door .csrf(csrf -> csrf.disable()) toe te voegen, geef je aan Spring Security dat het de CSRF-bescherming moet uitschakelen.

### 9.2.8 Write maintainable code avoiding cyclomatic and cognitive complexity
#### Stijn
Ik heb tijdens het coderen rekening gehouden met het zo klein en leesbaar mogelijke functies maken. Hierbij dus rekening gehouden met if statements die 2 statements diep gaan, functies echt maar op 1 functionaliteit laten focussen, en anders opdelen in subfuncties. Ook heb ik als norm genomen dat mijn functies maximaal tussen de 15/20 regels code uitkomen.


### 9.2.9 Use the classes and interfaces of the Java Collection Framework efficiently
#### Stijn
eigenlijk hebben we alleen maar gebruik gemaakt van de volgende collection:
- list, gebruik ik in de controllers om de data op te halen en te returnen. Je ziet hieronder een voorbeeld waar ik dit heb toegepast. De list wordt gevuld met de data die ik uit de service haal.
```java
@GetMapping("/all")
    public ResponseEntity<List<Party>> getAllParties() {
        List<Party> parties = partyService.getAllParties();
        return ResponseEntity.ok(parties);
    }
```

Ik heb niet bewust gebruik gemaakt van:
- queue, Een Queue is een wachtrij waarin elementen in een FIFO-volgorde (First In, First Out) worden verwerkt. Je gebruikt het vaak als een wachtlijst.
  Waarom niet? We hebben geen wachtrijen nodig gehad, het gaat vooral om het filteren van de data.

- deque, Een Deque (Double-Ended Queue) is een wachtrij waarbij je zowel aan het begin als het einde elementen kunt toevoegen en verwijderen.
  Waarom niet? Dit project draaide vooral om het ophalen van één homp bulkdata. Hierdoor is het achteraf niet nodig om dingen bij te voegen.

- map, Een Map is een verzameling van sleutel-waarde-paren. Elke sleutel moet uniek zijn, maar meerdere waarden kunnen hetzelfde zijn.
  Waarom niet? Er is geen noodzaak voor een snelle lookup van data, we hebben de data al in de backend staan en halen deze op wanneer nodig.

- set, Een Set is een verzameling unieke elementen. Duplicaten worden automatisch verwijderd.
  Waarom niet? De data die we ophalen bevat geen duplicaten, omdat we deze genormaliseerd opslaan in de database. Ook is de alfabetische volgorde belangrijk, die een set niet altijd aahoud.

### 9.2.10 Solve computational problems from chaining operators on data streams.

### 9.2.11 Write recursive methods
#### Stijn
Ik ben niet met recursive methods bezig geweest, omdat ik nergens een noodzaak vond om deze te kunnen implementeren. Wel wil ik hier graag uitleggen wat dit is zodat ik deze outcome toch kan aantonen.

Een recursive method is een method die zichzelf aanroept door een probleem op te splitsen. Een recursive method heeft altijd een base, deze zorgt ervoor dat de methode niet oneindig wordt aangeroepen en dus een loop weet te voorkomen. En het heeft een recursive stap, waar de methode aangeroepen wordt om zichzelf te verkleinen. Hieronder staat een klein voorbeelde van een recursive method:
```java
int factorial(int n) {
    if (n == 1) { // Basisgeval
        return 1;
    }
    return n * factorial(n - 1); // Recursieve stap
}
```
## 9.3 Apply, understand and compare complex algorithms and data structures
- Artikel geschreven over algoritmes en / of data structuren.

## 9.4 Realize professional design and ease of use in a user interface

### 9.4.1 The interface must provide timely feedback and reactiveness to the user input
#### Stijn
Ik heb op de queryelection pagina verwerkt dat zodra de tabel niet geladen wordt, er een tekst op het beeld komt met "Onze excuses, deze data kan op dit moment niet worden geladen.". Ook hebben we gedubbelcheckt of iedere knop ook daadwerkelijk iets doet en nuttige functionaliteit heeft.

### 9.4.2 The interface must have a responsive design
#### Stijn
Ik ben bezig geweest met het responsive maken van de website. Dit is gedaan met flexbox. De homepage is dan ook volledig responsive, maar de electionspagina helaas nog niet. Ik heb nog geen goede uitvoering kunnen bedenken hoe ik deze mooi weer ga geven op een telefoon.

### 9.4.3 The interface must be simple and easy of use
#### Stijn
Ik ben vanaf begin dit semester gaan werken met het 4 kliks principe, dit houd in dat de gebruiker een actie moet kunnen ondernemen door niet meer dan 4 kliks te gebruiken. Bijvoorbeeld op de elections pagina, je kan direct selecteren of je een regio of partij wilt, daarna direct bijvoorbeeld de partij, en hij laat direct de data zien.

Ook heb ik rekening gehouden met de wat oudere generatie die meer geintereseerd zijn in verkiezingsdata. Mijn opa bijvoorbeeld, is kleurenblind. Hij gaf aan dat onze kleurencombinatie erg duidelijk is voor hem, en de rest van de website ook nog eens erg zichtbaar.

Uit ons google forms gebruikersondezoek is ook nog eens gebleken dat het ontwerp er netjes uit zag, wel kwam hier uit dat er erg veel witruimte is, dit zouden we nog kunnen aanpassen.

### 9.4.4 The interface must be consistent in its design
- We maken gebruik van een unaniem kleuren schema en lettertype. Dit zorgt ervoor dat de interface consistent is.
- Doordat we gebruik maken van componenten, is de interface consistent in zijn design en hoeven we niet individueel elke pagina aan te passen.

## 9.5  Realize an integrated ICT solution according to the agile, interactive process of the SCRUM method within a small development team