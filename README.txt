Overview
Create reports that show:
- Amount in USD settled incoming everyday
- Amount in USD settled outgoing everyday
- Ranking of entities based on incoming and outgoing amount, e.g.: if entity foo instructs the highest amount for a buy instruction, then foo is rank 1 for outgoing

Glossary of terms:
- Instruction: An instruction to buy or sell
- Entity: A financial entity whose shares are to be bought or sold
- Instruction Date: Date on which the instruction was sent to JP Morgan by various clients
- Settlement Date: The date on which the client wished for the instruction to be settled with respect to Instruction Date
- Buy/Sell flag:
    B - Buy - outgoing
    S - Sell - incoming
- Agreed Fx is the foreign exchange rate with respect to USD that was agreed
- Units: Number of shares to be bought or sold


Requires Java 8

Main Class:
com.domain.reporting.app.TradeReportingEngine - this class will run the application and generate the reports with a very minimal set of data.

More extensive test can be run via the JUnit test classes under test/src


