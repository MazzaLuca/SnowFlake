1. [Introduzione](#introduzione)

  - [Informazioni sul progetto](#informazioni-sul-progetto)

  - [Abstract](#abstract)

  - [Scopo](#scopo)

1. [Analisi](#analisi)

  - [Analisi del dominio](#analisi-del-dominio)
  
  - [Analisi dei mezzi](#analisi-dei-mezzi)

  - [Analisi e specifica dei requisiti](#analisi-e-specifica-dei-requisiti)

  - [Use case](#use-case)

  - [Pianificazione](#pianificazione)

1. [Progettazione](#progettazione)

  - [Design dell’architettura del sistema](#design-dell’architettura-del-sistema)

  - [Design dei dati e database](#design-dei-dati-e-database)

1. [Implementazione](#implementazione)

1. [Test](#test)

  - [Protocollo di test](#protocollo-di-test)

  - [Risultati test](#risultati-test)

  - [Mancanze/limitazioni conosciute](#mancanze/limitazioni-conosciute)

1. [Consuntivo](#consuntivo)

1. [Conclusioni](#conclusioni)

  - [Sviluppi futuri](#sviluppi-futuri)

  - [Considerazioni personali](#considerazioni-personali)

1. [Sitografia](#sitografia)

1. [Allegati](#allegati)


## Introduzione

### Informazioni sul progetto
Progetto individuale del primo semestre del terzo anno della ***SAMT*** (Scuola d'Arti e Mestieri di Trevano), 2019 - 2020.
Sono coinvolte le classi *I3AA* e *I3AC*; tutti gli allievi hanno lo stesso progetto da svolgere.

I professori ***Luca Muggiasca***  e ***Geo Petrini*** sono i richiedenti del progetto SnowFlake.

### Abstract
 
Prima di avere a disposizione il software **SnowFlake** ogni fiocco di neve doveva essere creato sulla carta con un paio di forbici; in alternativa si sarebbe potuto utilizzare software simili a quello creato, ma nessuno di essi era completo di tutte le funzionalità che si hanno a disposizione.

Senza il supporto di un software di autogenerazione non era possibile progettare uno schema di taglio per creare un fiocco di neve; prima si sarebbe dovuto disegnare precedentemente sul foglio di carta per poi piegarlo e trovare lo schema di taglio. Un lavoro infinito.

Con questo software è possibile provare vari schemi di taglio senza sprecare carta, in modo più **veloce**, **pratico** e **intuitivo**, in quantità illimitata


## Analisi

### Analisi del dominio

Il prodotto verrà utilizzato principalmente da utenti dalla medio-bassa conoscenza informatica, perciò l'interfaccia utente dovrà essere intuitiva ed il prodotto dovrà equipaggiare una piccola guida di utilizzo.
Gli utenti che utilizzeranno tale software sono persone che esercitano hobby di manualità e di bricolage.


### Analisi e specifica dei requisiti

|**ID**|**Nome**|**Priorità**|**Versione**|**Note**|
|---|---|---|---|-----|
| 001 | Dev'essere creato un sito adibito al download e alla descrizione/guida del progetto | 1 | 1.0 |...|
| 002 | I punti di taglio sono inseriti con un semplice click| 1 | 1.0 |...|
| 003 | Il percorso deve avere le funzioni: "Inserisci"/"Reset" I punti si possono rimuovere con il click destro, mentre cliccando su un punto già esistente lo si può spostare. | 1 | 1.0 |...|
| 004 |Il fiocco di neve viene generato in tempo reale | 1 | 1.0 |...|
| 005 | L'utente può salvare il fiocco di neve in un file SVG o in un file PNG (per l'ultimo può scegliere la dimensione) e può scegliere la cartella nella quale immagazzinarli | 1 | 1.0 |...|
| 006 | L'utente può salvare i punti di taglio in un file serializzato; al momento del salvataggio può scegliere il path nel quale salvarlo | 1 | 1.0 |...|
| 007 | Nella schermata deve esserci un tasto “Download” | 1 | 1.0 |...|
| 008 | La finestra deve avere dimensioni minime di 1024x768 e dev'essere ridimensionabile | 1 | 1.0 |...|
| 009 | L'utente può caricare un percorso di taglio precedentemente salvato. | 1 | 1.0 |...|
| 010 | All'avvio del programma viene mostrata una maschera dove si può scegliere se creare un nuovo fiocco di neve oppure aprire un file con un percorso di taglio già esistente, dove sono presenti i crediti e i link al sito web e a github | 1 | 1.0 |...|
| 011 | Il triangolo deve occupare il 50% della finestra | 1 | 1.0 |...|

### Use case

I casi d’uso rappresentano l’interazione tra i vari attori e le
funzionalità del prodotto.

### Pianificazione

![](/Users/lucamazza/Documents/GitHub/SnowFlake/docs/SnowFlakeGantt.png)


### Analisi dei mezzi
I mezzi che abbiamo a disposizione per la creazione del progetto sono:

|Nome|Versione|Fase|
|---|---|---|
|Microsoft Project®|?|Analisi|
|Oracle Java®|12.0|Sviluppo|
|Apache NetBeans®|11.1|Sviluppo|
|MacDown®|0.7.1|Documentazione|
|Java API JavaDoc|12.1|Informazione|
|Apache Batik Libraries|2.0|Tools programmazione|


L'applicazione verrà sviluppata su piattaforma **macOS** 10.14 ma sarà utilizzabile su qualsiasi macchina abbia installata la ***JRE*** (*Java Runtime Environment*).

## Progettazione

Questo capitolo descrive esaustivamente come deve essere realizzato il
prodotto fin nei suoi dettagli. Una buona progettazione permette
all’esecutore di evitare fraintendimenti e imprecisioni
nell’implementazione del prodotto.

### Design procedurale

Descrive i concetti dettagliati dell’architettura/sviluppo utilizzando
ad esempio:

-   Diagrammi di flusso e Nassi.

-   Tabelle.

-   Classi e metodi.

-   Tabelle di routing

-   Diritti di accesso a condivisioni…

Questi documenti permetteranno di rappresentare i dettagli procedurali
per la realizzazione del prodotto.

## Implementazione


## Test

### Protocollo di test

Definire in modo accurato tutti i test che devono essere realizzati per
garantire l’adempimento delle richieste formulate nei requisiti. I test
fungono da garanzia di qualità del prodotto. Ogni test deve essere
ripetibile alle stesse condizioni.


|Test Case      | TC-001                               |
|---------------|--------------------------------------|
|**Nome**       |Import a card, but not shown with the GUI |
|**Riferimento**|REQ-012                               |
|**Descrizione**|Import a card with KIC, KID and KIK keys with no obfuscation, but not shown with the GUI |
|**Prerequisiti**|Store on local PC: Profile\_1.2.001.xml (appendix n\_n) and Cards\_1.2.001.txt (appendix n\_n) |
|**Procedura**     | - Go to “Cards manager” menu, in main page click “Import Profiles” link, Select the “1.2.001.xml” file, Import the Profile - Go to “Cards manager” menu, in main page click “Import Cards” link, Select the “1.2.001.txt” file, Delete the cards, Select the “1.2.001.txt” file, Import the cards |
|**Risultati attesi** |Keys visible in the DB (OtaCardKey) but not visible in the GUI (Card details) |


### Risultati test

Tabella riassuntiva in cui si inseriscono i test riusciti e non del
prodotto finale. Se un test non riesce e viene corretto l’errore, questo
dovrà risultare nel documento finale come riuscito (la procedura della
correzione apparirà nel diario), altrimenti dovrà essere descritto
l’errore con eventuali ipotesi di correzione.

### Mancanze/limitazioni conosciute

Descrizione con motivazione di eventuali elementi mancanti o non
completamente implementati, al di fuori dei test case. Non devono essere
riportati gli errori e i problemi riscontrati e poi risolti durante il
progetto.

## Consuntivo

Consuntivo del tempo di lavoro effettivo e considerazioni riguardo le
differenze rispetto alla pianificazione (cap 1.7) (ad esempio Gannt
consuntivo).

## Conclusioni

Quali sono le implicazioni della mia soluzione? Che impatto avrà?
Cambierà il mondo? È un successo importante? È solo un’aggiunta
marginale o è semplicemente servita per scoprire che questo percorso è
stato una perdita di tempo? I risultati ottenuti sono generali,
facilmente generalizzabili o sono specifici di un caso particolare? ecc

### Sviluppi futuri
  Migliorie o estensioni che possono essere sviluppate sul prodotto.

### Considerazioni personali
  Cosa ho imparato in questo progetto? ecc

## Bibliografia


### Sitografia

1.  URL del sito (se troppo lungo solo dominio, evt completo nel
    diario),

2.  Eventuale titolo della pagina (in italico),

3.  Data di consultazione (GG-MM-AAAA).

**Esempio:**

-   http://standards.ieee.org/guides/style/section7.html, *IEEE
    Standards Style Manual*, 07-06-2008.

## Allegati

Elenco degli allegati, esempio:

-   Diari di lavoro

-   Codici sorgente/documentazione macchine virtuali

-   Istruzioni di installazione del prodotto (con credenziali
    di accesso) e/o di eventuali prodotti terzi

-   Documentazione di prodotti di terzi

-   Eventuali guide utente / Manuali di utilizzo

-   Mandato e/o Qdc

-   Prodotto

-   …
