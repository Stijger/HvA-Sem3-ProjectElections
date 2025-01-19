# Learnin Outcomes according to the study manual.

## expertmeeting
### Dependency injection
dependency injection is a technique whereby one object supplies the dependencies of another object. A dependency is an object that can be used (a service). An injection is the passing of a dependency to a dependent object (a client) that would use it. The service is made part of the client's state. Passing the service to the client, rather than allowing a client to build or find the service, is the fundamental requirement of the pattern.

### Logical architecture Diagram
A logical architecture diagram is a diagram that shows the logical components of a system and how they relate to each other. It is a high-level diagram that is used to communicate the structure of a system to stakeholders. Logical architecture diagrams are often used in the early stages of a project to help stakeholders understand the system and to guide the development process.

### lambda expressions
A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method. They are used extensively in Java 8 and later to provide a more concise way of implementing interfaces that have functional interfaces.

### complexity
Complexity is a measure of the number of possible paths through a program. It is a measure of how difficult it is to understand and maintain a program. Complexity is an important consideration when designing and developing software, as complex programs are more difficult to test, debug, and maintain.

## portfolio results
| Learning Outcome                       | Boven Niveau | Op Niveau | In Ontwikkeling | Niet beoordeeld |
|----------------------------------------|--------------|-----------|-----------------|-----------------|
| Product kwaliteit                      |              |           | x               |                 |
| Software analyseren                    |              |           | x               |                 |
| Software ontwerpen                     |              |           | x               |                 |
| Software realiseren                    |              | x         |                 |                 | 
| Software manage & control              |              |           | x               |                 |
| Infrastructuur ontwerpen en realiseren |              |           | x               |                 |
| Gebruikersinteractie realiseren        |              |           |                 | x               |
| organisatie                            |              | x         |                 |                 |
| Persoonlijk leiderschap                |              | x         |                 |                 |
| Toekomstgericht organiseren            |              |           | x               |                 |
| Doelgericht interacteren               |              |           | x               |                 |
| Onderzoekend vermogen                  |              |           | x               |                 |

# Proof for learning outcomes

## 9.2 Learning Outcome 1: Design, build, test and deploy a full-stack web application with a layered and scalable architecture

### 9.2.1 Design and develop modern front-end applications using modern frameworks.
#### Stijn
Ik ben aan de slag gegaan met het maken van de front-end van de applicatie. Ik heb gebruik gemaakt van Vue.js om de front-end te realiseren. Ik heb gebruik gemaakt van de vue router om de verschillende pagina's te navigeren. (/frontend-vue/src/src/router/index.js) Ik heb gebruik gemaakt van ChartJS framework om gebruik om de verkiezingsdata te tonen. Dit alles samen vormt dus de gevraagde single page application.

#### Tomas
Ik heb dit semester leren werken met Vue.js en Axios om zo een aantal paginas te maken voor onze frontend applicatie.
Ik heb gebruik gemaakt van vue router om zo mijn paginas te koppen aan de router zodat er naar te navigeren is.
Ik heb gebruik gemaakt van Axios om HTTP requesten te versturen naar de backend.

### 9.2.2 Design and develop modern backed-end applications using modern framework
#### Stijn
Ik heb de backend gemaakt in java, dit was compleet nieuw voor mij dit semester. Ik heb hierbij gebruik gemaakt van de springboot en hibernate als frameworks. Ook heb ik gebruik gemaakt van spring security om de JWT tokens te implementeren.

#### Tomas
Ik heb dit semester voor het eerst gewerkt met de Java programmeertaal, de Spring frameworks en Maven dependencies manager.
Ik heb delen van de backend geschreven met Java en Spring, Spring boot, Spring security en Spring validation.
Ik heb deel van het klassediagram gemaakt over onze backend.

### 9.2.3 Apply and understand Dependency Inversion and Dependency Injection
#### Stijn
Ik heb dependancy injection eigenlijk al toegepast toen ik begon te werken in de backend, dit gaat om het gebruik van de annotations voor bijvoorbeeld de models of entities. 

- We hebben gebruik gemaakt van de Spring & Hibernate annotations. (Te vinden in de backend, I.E. @RestController, @Requestmapping, @CrossOrigin)

#### Tomas
dependency injection is het invoegen van gedrag, functionaliteit en staat (in het geval van JAVA vaak instanties van klassen)
aan andere klassen. Dit zorgt ervoor dat de code beter aanpasbaar is doordat het de referenties tussen objecten beter centraliseerd.
Ook kan het geheugen besparen door te voorkomen dat er constant nieuwe objecten worden gemaakt.
Het bijhouden van al deze dependencies en ze waar nodig invoegen word geregeld door de Spring framework.

In het project heb ik in de backend gewerkt met Spring boot, Spring web, Spring security. 

Dependency inversion is het programmeren tegen abstracte functies en klassen in tegensteling tot concrete klassen en functies.
Hierdoor verwijst een andere klasse niet rechtstreeks naar een andere concrete klasse, maar naar een interface (technisch: virtual table)
die deze concrete functionalteit oproept. Dependency inversion zorgt ervoor dat code makkelijker te onderhouden is
omdat de onderliggende concrete code vervangen kan worden zonder dat de abstracte code aangepast hoeft te worden.

In het project heb ik constant gewerkt met interfaces gedefineerd door de Java standard library en Spring frameworks.

### 9.2.4 Explain and justify the layered, logical architecture of the design of an Enterprise Web Application
#### Stijn 
We zijn dit project begonnen zonder kennis over hoe we het beste de applicatie konden opzetten, we hebben hiervoor een class diagram gemaakt en hier feedback op gevraagd. Hieruit bleek dat we al aardig goed op weg waren. Alleen hadden we dit nog niet goed gevisualiseerd in het diagram. We hebben deze feedback nu ook toegepast door de verschillende lagen onder elkaar neer te zetten, en het verkeer tussen deze lagen weer te geven. Hierdoor maken we nu goed gebruik van controllers, services en repositories, en maken deze een goede connectie met de frontend.

#### Tomas
In het project hebben we Frontend van Backend gescheiden.
In de backend heb ik layers gemaakt zoals Controllers, Services, Repositories (eigenlijk alleen gedefineerd Hibernate deed de rest).
In de backend heb ik gebruik gemaakt van annotaties zodat Spring web de juiste paden in de router kon defineren.
Ik kan de lagen en hun relaties uitleggen,
- Zo is het de taak van de Router om de inkomende HTTP requesten naar de juiste controllers/methoden te leiden via de HTTP METHOD en PATH.
- Zo is het de taak van de Controller om de inkomende HTTP body naar de deserializers te sturen om de data daaruit op te halen en het resultaat van de service te sturen naar de serializers om vervolgens een HTTP response terug te sturen naar de gebruiker.    
- Zo is het de taak van de Service om met de verkregen gegevens van de Controller de bedrijfslogica op te lossen en eventueel aanvragen te doen naar de repository.
- Zo is het de taak van de Repository om (vaak via een database connector) aanvragen te doen naar de database en gegevens te serializen en deserializen voor en uit de database.

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

#### Tomas
Ik heb gebruik gemaakt van de annotations geleverd door de standaard Java JPA en Hibernate om zo
te kunnen defineren hoe de ORM van hibernate gegevens vanuit database tabellen moet omzetten (mapping)
naar instanties van bepaalde klassen zodat de Service layer van onze applicatie hiermee kan werken. 
Ook kan hierdoor hibernate met deze gegevens SQL queries naar de database versturen om ze erin te zetten. 

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

#### Tomas
Ik heb geleerd wat JWT Token zijn, hoe ze in elkaar zitten en wat de voordelen ervan zijn tenopzichte van sessies
om ze zo toe te passen in onze applicatie voor het verifieren van gebruikers.

Een JWT Token is een base 64 geëncodeerde tekst string van een Json object dat bestaat uit 3 delen gescheiden door een punt.
deze delen zijn in volgorde:
- De header, waar informatie in staat over welk encryptie algoritme er gebruikt is en nodig om te decrypten en het type (wat eigenlijk altijd JWT is).
- De payload, waar de gegevens in staan zoals die van de gebruiker. deze worden claims genoemd.
- De signiture, de andere twee secties geëncrypt met het beschreven algoritme in de header. Deze wordt gebruikt om te kijken of het token valide is. 

Door middel van JWT tokens te gebruiken hoeven er geen sessies meer in de backend te worden aangemaakt en bijgehouden.
De gegevens worden opgeslagen (meestal als cookie) in de browser van de gebruiker en meegegeven in het HTTP protocol naar aanvragen naar de backend.
Dit bespaart geheugen en tijd op de backend zonder dat de veiligheid van de gegevens minder word.

Ik heb JWT tokens toegepast in de backend en frontend bij het inloggen en registreren van gebruikers.
in de backend doormiddel van jjwt.

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

#### Tomas
Ik heb geleerd hoe java lambda's werken, wat anonymous classes (of inline classes) zijn en wat functional interfaces zijn, zo heb ik ook geleerd waarom de naam lambda eigenlijk misleidend is.
Een lambda IN JAVA is 'syntactic sugar' (speciale syntax) voor het defineren van een anonymous class dat een functional interface implementeerd.

In tegenstelling tot het maken van een aparte class en dan een instantie ervan, kan dit ook allemaal gedaan worden
in een java expressie, dit is natuurlijk niet voor alles handig.
Het maken van anonymous classes is erg handig voor bijvoorbeeld het maken van één instantie van een concrete class van een interface.
Een interface in Java met maar één methode is een functional interface, en voor het implementeren van een concrete instantie van deze soort interfaces kan de speciale lambda syntax gebruikt worden.

De naam lambda komt van de lambda calculus, waarin een lambda eigenlijk een functie is.
lambda zijn dan ook in de informatica functies die gedefineerd zijn zonder naam (deze kunnen wel aan een symbool gekoppeld worden, bijvoorbeeld een functie parameter).
De lambdas in java zijn geen functies, het is een class die een lambda nabootst.

een kort voorbeeld met wat psudocode.
```java
@FunctionalInterface
interface Logger {
    String log(String msg);
}

String dump_time(Logger logger) {
    Time time = getTimeStamp();
    return logger.log(time.toString());
}

void main() {
    final String prefix = "[Time]: "; 
    System.out.println(dump_time(msg -> prefix.concat(msg)));
}
```

In het project heb ik zelf geen functionele interfaces gedefineerd, wel heb ik een aantal lambdas geschreven.

### 9.2.8 Write maintainable code avoiding cyclomatic and cognitive complexity
#### Stijn
Ik heb tijdens het coderen rekening gehouden met het zo klein en leesbaar mogelijke functies maken. Hierbij dus rekening gehouden met if statements die 2 statements diep gaan, functies echt maar op 1 functionaliteit laten focussen, en anders opdelen in subfuncties. Ook heb ik als norm genomen dat mijn functies maximaal tussen de 15/20 regels code uitkomen.

#### Tomas
Doordat ik voor het eerste moest werken met Spring en Java vond ik het moeilijk om goeie code te schrijven.
Het was vooral heel veel leren en constant aanpassen.
Wel probeer ik altijd de hoeveelheid branches en vooral nested statements te vermijden en wil ik zoveel mogelijk
mijn code opsplitsen in functies die allen verandwoordelijk zijn voor een specifieke taak.

Echter ben ik ook een erg groot fan van efficiënte code schrijven en dit botst vaak met de netheid van code.
Zo is mijn code soms op het eerste oog moeilijk te lezen, dit kan voor kleine problemen zorgen in samenwerkingsverband
maar wil ik niet leesbaarder maken omdat dat de efficiëntheid van de code verslechterd. 
Daarom probeer ik vaak code op te splitsen in zoveel mogelijk functies.

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

#### Tomas
In het project heb ik niet zoveel gebruik gemaakt van de standaard java functies en datastructuren en meer van die van Spring,
die hoogstwaarschijnlijk toch weer die van java oproept. Wel heb ik in de controllers en services gebruik gemaakt
van de List<T> interface en de ArrayList<T> class.

Echter ben ik wel erg bekend met alle standaard datastructuren en hoe ze werken vanuit andere programmeertalen
zoals: Python, Rust en C (waar je ze vooral zelf eerst moet implementeren).

### 9.2.10 Solve computational problems from chaining operators on data streams.
#### Tomas
In het project werken we niet direct met Streams, dat word voornamelijk gedaan door zowel Spring en hibrnate als Java zelf.
Wel maken we veel gebruik van de door Spring en jjwt geleverde builder classes waarmee methoden aan een stuk door
achter elkaar oproepen om zo complexere datatypen zoals een JWT token maken of de configuratie voor CORS wijzigen.

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

Als je in deze code bijvoorbeeld zegt dat n = 5, wordt de factorial net zolang aangeroepen totdat n = 1. Dit gebeurt dus in totaal 5x.

#### Tomas
Net als met de datastructuren was ik al bekend met recursive functies voor dit semester. En met goeie manieren om ze te maken zoals
tail call recursion, waarin de call naar de functie als laatste pas gedaan word en eventuele staat meegegeven word.

Een voorbeeld in java van de faculteit in de wiskunde
```java
int _factorial(int a, int n) {
    return (n < 2) ? a : factorial(a*n, n-1);
}

int factorial(int n) { return _factorial(1, n); }
```

de _factorial functie is de recursive functie die zichzelf steeds oproept todat n kleiner is dan twee.
de factorial functie is voor het gemak om de accumulator te zetten naar 1, de beginwaarde.

## 9.3 Apply, understand and compare complex algorithms and data structures
- Artikel geschreven over algoritmes en / of data structuren.

#### Tomas
Dit semester heb ik ietsjes meer geleerd van de Big O notatie.
De Big O natatie geeft aan hoe een ascpect veranderd zodra de invoer groote oneindigheid nadert.
dit is vaak tijd, dus hoe veel trager, of beter gezegd hoe veel meer stappen het algoritme moet nemen als de invoergrote toeneemt.
Het word echter ook vaak gebruik voor Geheugengebruik.

Big O word weergegeven als een wiskundige natatie, zonder termen omdat die geen toeevoegde waarde meer hebben zodra de formule oneindigheid nadert.
Big O geeft niet alles aan over een algoritme, puur alleen Big O gebruiken om algoritmen te vergelijken kan een erg vertekend beeld geven.

## 9.4 Realize professional design and ease of use in a user interface

### 9.4.1 The interface must provide timely feedback and reactiveness to the user input
#### Stijn
Ik heb op de que ryelection pagina verwerkt dat zodra de tabel niet geladen wordt, er een tekst op het beeld komt met "Onze excuses, deze data kan op dit moment niet worden geladen.". Ook hebben we gedubbelcheckt of iedere knop ook daadwerkelijk iets doet en nuttige functionaliteit heeft. 

#### Tomas
Ik heb op mijn gemaakte pagina's een speciaal tekstveld boven de invoervelden gemaakt die aangeeft (bij success of fout), dat het goed of fout ging.

### 9.4.2 The interface must have a responsive design
#### Stijn
Ik ben bezig geweest met het responsive maken van de website. Dit is gedaan met flexbox. De homepage is dan ook volledig responsive, maar de electionspagina helaas nog niet. Ik heb nog geen goede uitvoering kunnen bedenken hoe ik deze mooi weer ga geven op een telefoon.

#### Tomas
Ik heb geprobeerd te zorgen dat mijn componenten op de website responsive en zichtbaar zijn. Echter heb ik hier niet de focus op
gelegd en geen rekening gehouden met mobile apparaten.

### 9.4.3 The interface must be simple and easy of use
#### Stijn
Ik ben vanaf begin dit semester gaan werken met het 4 kliks principe, dit houd in dat de gebruiker een actie moet kunnen ondernemen door niet meer dan 4 kliks te gebruiken. Bijvoorbeeld op de elections pagina, je kan direct selecteren of je een regio of partij wilt, daarna direct bijvoorbeeld de partij, en hij laat direct de data zien.

Ook heb ik rekening gehouden met de wat oudere generatie die meer geintereseerd zijn in verkiezingsdata. Mijn opa bijvoorbeeld, is kleurenblind. Hij gaf aan dat onze kleurencombinatie erg duidelijk is voor hem, en de rest van de website ook nog eens erg zichtbaar.

Uit ons google forms gebruikersondezoek is ook nog eens gebleken dat het ontwerp er netjes uit zag, wel kwam hier uit dat er erg veel witruimte is, dit zouden we nog kunnen aanpassen.

#### Tomas
In het eerste/tweede semester hebben we wireframes van onze website gemaakt en nagedacht over hoe de ervaring voor de user is.
Zo hebben we de website geprobeerd zo simpel mogelijk te houden zodat juist de focus ligt op de belangrijke features en niet onbelangerijke zaken.

In de login pagina zie je dit ook terug, de pagina heeft alleen het logo van de website (waar je op kan klikken om terug te gaan naar de home-page).
en 2 forum componenten met de invoervelden en titels om de gegevens in te voeren.

De profile page bestaat ook uit zo min mogelijk overbodige dingen, het heeft alleen de invoervelden van de gegevens,
ook worden de gegevens na het aanpassen meteen opgeslagen, waardoor er niet eerst nog naar een opslaan knop hoeft worden gezocht.

### 9.4.4 The interface must be consistent in its design
- We maken gebruik van een unaniem kleuren schema en lettertype. Dit zorgt ervoor dat de interface consistent is.
- Doordat we gebruik maken van componenten, is de interface consistent in zijn design en hoeven we niet individueel elke pagina aan te passen.

#### Tomas
In het eerste semester hebben we een wireframe gemaakt om te zorgen dat de website een constistent design heeft.
Ik heb de pagina's gemaakt zoals ze erin het wireframe uitzien.
Ik heb gebruik gemaakt van de menu component die op alle pagina's staat.

## 9.5  Realize an integrated ICT solution according to the agile, interactive process of the SCRUM method within a small development team
#### Tomas
We hebben dit project proberen volgens de SCRUM methode, dit is niet helemaal gelukt omdat de datum van de sprints (met tussensprints)
rond eind oktober een beetje vaag liepen. Wel hebben we elke sprint user stories gemaakt, in de planning gezet en vaak die ook afgemaakt.
en aan het einde een retrospective gehouden om terug te blikken op de sprint en wat we de volgende sprint hetzelfde willen houden
of anders willen doen.
