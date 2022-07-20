# **\~_Documentation_\~**

1. Project overview 
2. Solution Idea
3. Class Diagram
4. Implementation

<br/>
<br/>
<br/>


## **1. Project Overview**

In this project the user/human can play TicTacToe against an AI. It is a terminal game, that means there is no GUI. The implementation is in Java with JUnit4 for testing. 

<br/>
<br/>


### `Rules for TicTacToe`:
Two playeers are playing against each other. There is a game board with three rows and three colums:

```
                                                         | |
                                                        -----
                                                         | |
                                                        -----
                                                         | |
```

That means that there a nine free fields. Both player have their own Symbol: **`X`** or **`O`**. One after another select a empty field and fills it with his own Symbol. <br />

Both players can win by have three of there symbols horizontal/vertical or diagonal side by side and not blocking by the symbol of the other player. 

For example:

```
                X|X|X                       |       X| |                      |         X| |
                -----                       |       -----                     |         -----
                O| |O  ← X wins             |       X|O|O ← X wins            |         O|X| ← X wins
                -----                       |       -----                     |         -----
                 |O|                        |       X|O|                      |         O|O|X
```

When there is no more empty space and none of the two players won, the game is over and it´s a tie.

<br/>

## **2. Solution Idea**

The game concept is clear. But how does the AI works?
Because after the player makes a move the AI needs to eveluate the best possible move. 
For this problem I use the Minimax-Algorithmus. This algorithmus has two players. The **`Min`** and **`Max`**. <br />
The **`Max`** player tries to max his score and the **`Min`** player tries to min his score. The algorithmus goes through all possible combinations up to a terminal state. A terminal state is a state in which the board is completly filled or one player wins. Then it gives each possible combinations a score. <br />
<br />
These scores are possible:

- 1  -> **`Max`** player wins
- -1 -> **`Min`** player wins
- 0  -> tie

The AI is the max player so it tries to maximaze his score. So the AI select the move which leads to a win for the AI. Or if this is not possible the AI tries to get a tie. <br />
For the AI it´s allways possible to get a tie, that means that the human, which plays against the AI, can´t win, even if he starts.

<br/>


## **3. Class diagram**

<br />
<br />


```plantuml

@startuml

Main <|-- Game
Ai <|-- Game
Game <|-- Ai

class Ai {
    + static void bestMove()
    - private static int miniMax(isMaximasing: boolean)
}

class Game {
    + static board: String[][]
    + static final human: String
    + static final ai: String
    + static currentPlayer: String

    - void getHumanPosition
    + void loop()
    + static boolean isValidPosition(x: int, y: int)
    + static void printBoard()
    + static String isTerminalState()
}

class Main {
    + static void main(String[] agrs)
}

@enduml

```

<br />
<br />
<br />


## **4. Implementation**

First I start by creating in the **`main method`** a new game. 

```java
package TicTacToeAI;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.loop();
    }

}
```

### **`Game`** contains the following attributes:

<br />

The 2d Array board, which contains the symbols by the players and the emtpy spaces. By default the whole board is empty
```java
public static String[][] board = {
            { " ", " ", " " },
            { " ", " ", " " },
            { " ", " ", " " }
    };
```

<br />

The symbol for the human as a not changeable constante
```java
public static final String HUMAN = "O";
```
<br />

The symbol for the AI as a not changeable constante
```java
public static final String AI = "X";
```
<br />

The symbol for the current player, which also mean the player, which stats the game
```java
public static String currentPlayer = HUMAN;
```
<br />

This Array stores the position the human gives as a input for his symbol in the board
```java
private int[] humanPosition;
```

<br />

All of them except for the **`humanPosition`** are static. This is needed because the AI uses all of them and implement all of them as parameters would not be that clean.

<br />

After that in the **`main method`** the object **`game`** uses the method **`loop`**
to launch the game.

<br />
The while loop stops when there is a terminal. If not in a terminal state the human or the KI makes their move

<br />

```java
public void loop() {

        while (true) {
            ...
        }
    }
```

<br />

But first the board gets printed by usiung the method **`printBoard`**

<br />

```java
...
    while (true) {
        printBoard();
    ...      
    }
...
```

<br />
This is the method for printing out the board: 

<br />

```java
public static void printBoard() {
        System.out.println("\n");
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("---------");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("---------");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
        System.out.println("\n");

    }
```

<br />

After printing the board, it needs to be checked if the game is over. 
To accomplish that the method **`isTerminalState`** checks if there is a terminal state.
If there is a terminal state the winner or tie gets printed and the loop stops and the game is over.

<br />

```java
...
    while (true) {
        printBoard();

        // check if game if over
        String state = isTerminalState();
        if (state != null) {
            if (state == "tie") {
                System.out.println(state);
                break;
            }
            System.out.println(state + " wins");
            break;
        }
        ...
    }
...    

```

<br />

First the method **`isTerminalState`** loops over the the rows and checks if in the rows are only the same symbols. If this is true, the symbol of the winner gets returned.

<br />

```java
public static String isTerminalState() {
        // check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][1] != " ") {
                return board[row][0];
            }
        }
        ...
}

```

<br />

The same prinzip is used for the colums.

<br />

```java
        ...
        // check columns
        for (int column = 0; column < 3; column++) {
            if (board[0][column] == board[1][column] && board[1][column] == board[2][column]
                    && board[1][column] != " ") {
                return board[0][column];
            }
        }
        ...
```

<br />

After the rows and colums the diagonals needs to be checked.

<br />

```java
        ...
        if (((board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2] == board[1][1] && board[1][1] == board[2][0])) && board[1][1] != " ") {
            return board[1][1];
        }
        ...
```

<br />


And finally the check for a tie. It loops over the field and if one field is empty, the method returns null, which means the game is not over. Else the method returns a tie.

<br />

```java
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (board[row][column] == " ") {
                    return null;
                }
            }
        }
        return "tie";
        ...
 
```

<br />

If the game is not over the human or the AI can make a move. If the human is the current player the method **`getHumanPositions`** gets called. After that on the correct positon the symbol of the human is set and the **`currentPlayer`** gets the new value of **`AI`**. <br />
If it´s AI´s turn the static method of the AI class gets called and after that the **`currentPlayer`** gets the new value of **`HUMAN`**.

<br />

```java
public void loop() {

        while (true) {
            ...
            // human and KI make a move
            if (currentPlayer == HUMAN) {
                getHumanPosition();
                board[humanPosition[0]][humanPosition[1]] = HUMAN;
                currentPlayer = AI;
            } else {
                Ai.bestMove();
                currentPlayer = HUMAN;
            }
        }
    }
```

<br />

This is the **`getHumanPositions`** method. In a while loop the human select a **row** and **column** cordinate for his symbol. This position on the board gets checked by the **`isValidPosition`** method. If the position is valid the while loop stops.

<br />

```java
private void getHumanPosition() {
    while (true) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nrow:");
        int row = userInput.nextInt() - 1;
        System.out.println("column:");
        int column = userInput.nextInt() - 1;
        if (isValidPosition(row, column)) {
            humanPosition = new int[] { row, column };
            break;
        }
    }
}

```

<br />

The **`isValidPosition`** method checks if the positon by the user input is empty, that means free and not out of the board range. If that is true the method return true, else it returns false.

<br />

```java
public static boolean isValidPosition(int row, int column) {
        if (row < 3 && column < 3 && row >= 0 && column >= 0) {
            if (board[row][column] == " ") {
                return true;
            }
        }
        return false;
    }
```

<br />

That was the human turn. But what if the AI needs to pick a move. <br />
The static method **`bestMove`** gets called. <br />
First the method initialized **`bestScore`** and **`move`**. **`bestScore`** is set to negative infitiy. Every time a new score is greater than **`bestScore`**, the value gets overried. <br />
**`move`** is used at the end to make the final move for the AI. It contains the row and column value.

<br />

```java
public static void bestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] move = new int[2];
        ...
    }
```

<br />

After that the method iterate over the board and finds all empty slots. For this empty slots it calles the **`miniMax`** method and eveluate a score for this move. If the score is greater than the **`bestScore`**, the value gets overried and the array **`move`** gets their row and column value. <br />
At the end the best possible move gets selected and the AI set the symbol on this position.

<br />

```java
        ...

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (Game.board[row][column] == " ") {
                    Game.board[row][column] = Game.AI;
                    int score = miniMax(false);
                    Game.board[row][column] = " ";

                    // new best move
                    if (score > bestScore) { 
                        bestScore = score;
                        move[0] = row;
                        move[1] = column;
                    }
                }
            }
        }
        Game.board[move[0]][move[1]] = Game.AI; // AI do the move
```

<br />

So the **`miniMax`** method eveluate the score. But how? <br />
By iterate through all the possible next moves up to a terminal state. It switches between the all moves of the human and the AI. Then all of this possible future outcomes gets one of the scores: 1, -1 or 0. <br />
1 means KI wins, -1 human wins and 0 tie. 
The **`miniMax`** method returns the score of the best possible outcome. 

```java
private static int miniMax(boolean isMaximasing) {
        // is game over
        if (Game.isTerminalState() != null) {
            return scores(Game.isTerminalState());
        }
        
        if (isMaximasing) {
            int bestScoreMax = Integer.MIN_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    if (Game.board[row][column] == " ") {
                        Game.board[row][column] = Game.AI;
                        int scoreMax = miniMax(false);
                        Game.board[row][column] = " ";
                        bestScoreMax = Math.max(scoreMax, bestScoreMax);
                    }
                }
            }
            return bestScoreMax;
        } else {
            int bestScoreMin = Integer.MAX_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    if (Game.board[row][column] == " ") {
                        Game.board[row][column] = Game.HUMAN;
                        int scoreMin = miniMax(true);
                        Game.board[row][column] = " ";
                        bestScoreMin = Math.min(scoreMin, bestScoreMin);
                    }
                }
            }
            return bestScoreMin;
        }
    }

    private static int scores(String result) {
        if (result == "X") {
            return 1;
        } else if (result == "O") {
            return -1;
        } else {
            return 0;
        }
    }
```