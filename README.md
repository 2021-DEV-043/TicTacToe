# TicTacToe Game

Tic Tac Toe is a game played between 2 Players with moves 'X' and 'O'. It consist of a board with 9 squares and each player proceeds with the game by making moves with either 'X' or 'O'. The player completely occupying either of the row or column or any of the two diagonals with there moves wins the game.

## Rules

The rules are described below :

- X always goes first.
- Players cannot play on a played position.
- Players alternate placing X’s and O’s on the board until either:
	- One player has three in a row, horizontally, vertically or diagonally
	- All nine squares are filled.
- If a player is able to draw three X’s or three O’s in a row, that player wins.
- If all nine squares are filled and neither player has three in a row, the game is a draw.

## Prerequisites

- Java - Version 1.8 or higher
- Maven - Dependency management
- JUnit - Version 5.7 or higher(added dependency in pom.xml)
- IDE - Eclipse or STS or any other IDE which supports Java

## Code commit guidelines

Inspired from Udacity

- feat: a new feature
- refactor: refactoring production code
- test: adding tests, refactoring test; no production code change
- chore: updating build tasks, package manager configs, etc; no production code change

## Setup application

### IDE
```
1) Download project as zip file and unzip the same to a folder. 
2) Then in eclipse/sts IDE,  Go to the below path
   File -> Import -> select Existing Maven Project option -> Next -> 
   Browse extracted folder and Finish
3) Then, Right click on the project in Project Explorer window and 
   select Run As -> Maven install
```

### Command Prompt
```
1) Download project as zip file and unzip the same to a folder.
2) Open terminal at the project root folder location.
3) Run the command `mvn clean install`.
```

## Steps to run the test cases

### IDE
```
1) Once application setup is completed, Right click on the project in Project explorer window and
   select Run as --> Run Configurations.
2) Under configuration wizard from the left window, right click on Maven Build and
   select New Configuration.
3) Select Base directory as your project root folder and under Goals mention `clean test`
4) Apply and Run the same. This will execute all test cases.
```

### Command Prompt
```
1) Go to the directory where you have setup the application.
2) Run `mvn clean test` to execute test cases.
```

## Jacoco code coverage Report using JaCoCo Maven plugin

### IDE
```
1) Setup application as per steps mentioned above. 
2) Right click on the project in Project explorer window and
   select Run as --> Run Configurations.
3) Under configuration wizard from the left window right click on Maven Build and
   select New Configuration.
4) Select Base directory as your project root folder and under Goals mention `clean test`.
5) The JaCoCo code coverage report will be generated at target/site/jacoco/*
6) Open the target/site/jacoco/index.html file, review the code coverage report
```

### Command Prompt
```
1) Go to the directory where you have setup the application.
2) Run the command `mvn clean test`.
3) The JaCoCo code coverage report will be generated at target/site/jacoco/*
4) Open the target/site/jacoco/index.html file, review the code coverage report
```

## Steps to run the application in command prompt
```
1) Setup application as per above instructions.
2) Once application setup is completed,
   open command prompt at location <ProjectDirectory>\target
   and execute below command
   java -jar TicTacToe-0.0.1-SNAPSHOT.jar
```
