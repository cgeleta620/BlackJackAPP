# Assignment 04:  asgn04-482f17-blackjack
A Simplified Blackjack Game
Assigned: Tue, Oct 24, 2017
Due (extended): Tue, Nov 14, before 5pm.	CS 482: Software Engineering
Loyola University Maryland

The Program:  This program is aimed at involving everyone in the class to get started on app development using android studio. Another objective is to take stock of and revitalize some of your coding practices including your program design and coding habits. Special attention will be given to identifier naming, commenting etc. You are going to write javadoc style comments and generate javadoc of your program as well. Follow the coding-convention and commenting guidelines that I have made available in Moodle. 
You will develop ‘’SimpleBlackJack” as an Android App in Java that allows the users to play a game of simplified BlackJack. The player of the SimpleBlackJack will try to get as close to 21 as possible, without going over (called bust). The BlackJack player’s objective is to beat the dealer by either outscoring the dealer or having the dealer go bust. Blackjack may be played with one or two decks of 52-card decks. Here are some more details of the requirements.
1.	SimpleBlackJack will be played by the dealer (the computer) and one player.
2.	Ace will be counted as 1 or 11; King, Queen, and Jack will all be counted as 10. The other cards will be counted at pip value. 
3.	The value of a hand is the sum of the point values of the individual cards. 
4.	A "blackjack" is the highest hand, consisting of an ace and any 10-point card (Queen, King, or Jack), and it outranks all other 21-point hand.
5.	The dealer will give two cards to the player and two cards to herself. Both the player’s and the dealer’s card-pair will be shown face-up.
..*	If the player has a blackjack, then the player wins the game. 
..*	If the dealer has a blackjack, then the player looses the game. 
..*	If both the player and the dealer have blackjacks, then it is a tie. 
6.	The player will have the first turn.  He can go for Hit or Stop. 
7.	Hit: Player touches a button title Hit, which draws another card. If this card causes the player's total points to exceed 21 (known as "breaking" or "busting") then he loses. A player can at most push Hit 3 times after the first two cards that were drawn. Thus there will be at most 5 cards drawn by the player.
8.	After 3 Hits, the Hit button should be disabled for the Player.
9.	Stop: The player may choose to stop at any point after the initial two cards and before the three Hits i.e. before the drawing of the three new cards. When the 3 cards are drawn, it will become the dealer’s (i.e., the Computer’s) round. 
10.	Dealer can also draw up-to three new cards. Dealer’s drawing will be automatic (no pressing of Hit is needed). Once the dealer has either gone bust, stopped or have drawn all three cards, the app will show result of the game, which will be one of the following three scenarios:
..*	The Player has won
..*	The Dealer has won
..*	The round is a Tie
11.	SimpleBlackJack will have a “New Game” button that starts a new game. The player can hit the “New Game” Button at any time. If this button is hit in the middle of the game, it will cancel the current game and start a new one.

1.	Extra Credit (10 pts): 
 ..*	The New Game button is replaced with a swipe feature. If the user swipes left to right across the screen the New Game is displayed. 
 ..*	The Dealer’s decision to draw new card is based on some statistical probabilities based on the cards that have been drawn so far.  

# What you will need to do:
1.	Think about the program before starting to code. What will be the underlying model of your App. This includes identifying the classes you will need and how they will relate to each other. 
2.	Document your program with Javadoc style comments for field names, methods and classes.  
3.	Use descriptive and meaningful identifier names (variables, methods and classes).
4.	Draw a UML class diagram and write a short description of your design. Submit the design description as a pdf. The design description will identify your classes, their responsibilities (i.e., what does each class do), and which class uses which other class for carrying out its work. 
5.	Use the model-view-controller (MVC) design pattern.
6.	Commit your code, Javadoc and design description (as a pdf file) in the git repository.
7.	Demo your working program to me in your laptop.
Notes: This is an individual assignment. Each one of you should complete the assignment independently. 

# Grading Breakdown
1.	Working program that supports the feature list:		50
2.	Following strong coding convention, use of meaningful 
and descriptive identifier, class, method names etc.:  	15
3.	Javadoc style comments:  			                	15
4.	Class diagram and description of your design:		20
