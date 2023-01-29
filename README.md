# A1 - Piraten Karpen

  * Author: < Omar >
  * Email: < o.k.elaref@gmail.com >

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 
* To run the project in development mode:
    * `mvn -q exec:java ` (here, `-q` tells maven to be _quiet_)

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < Your DoD goes here >

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| MVP   | F01 | Roll a dice |  D | 01/15/23 | 01/17/23 | 
| MVP   | F02 | Roll eight dices  |  D | 01/15/23  | 01/17/23 |
| MVP   | F03 | Skull count function  |  D  | 01/15/23  | 01/17/23 |
| MVP   | F04 | Gold and diamond points | D | 01/16/23 | 01/17/23 |
| MVP   | F05 | Random strategy | D | 01/16/23 | 01/17/23 |
| MVP   | F06 | Making two player objects | D | 01/16/23 | 01/17/23 |
| MVP   | F07 | Implementing the 2 players | D | 01/17/23 | 01/17/23 |
| MVP   | F08 | Play game until 42 game or one player has 6000 points | D | 01/17/23 | 01/17/23 |
| MVP   | F09 | Extra game after win condition | D | 01/17/23 | 01/17/23 |
| Business Value   | F10 | Proper point system (Including number of a kind) | D | 01/19/23 | 01/24/23 |
| Business Value   | F11 | Combo strategy | D | 01/20/23 | 01/24/23 |
| Business Value   | F12 | Using the strategies through the command line | D | 01/23/23 | 01/24/23 |
| Card Deck   | F13 | Build a Card interface with the necessary methods | D | 01/25/23 | 01/25/23 |
| Card Deck   | F14 | Build a deck class that has shuffle, draw, add card methods | D | 01/25/23 | 01/25/23 |
| Card Deck   | F15 | Sea Battle class that had getter for card info and play card method | D | 01/25/23 | 01/25/23 |
| Card Deck   | F16 | Updated Game class and point function to incorporate sea battle card | D | 01/25/23 | 01/25/23 |
| Card Deck   | F17 | New strategy for sea battle card | D | 01/28/23 | 01/28/23 |
| Card Deck   | F18 | Make and implement MonkeyBusiness class | D | 01/28/23 | 01/28/23 |

