## **Getting Started**

This project contains a terminal **[TicTacToe]** game. You play against an 
AI, which uses the **[Minimax-Algorithmus]** to make a move.

<br/>

## **Folder Structure**
<br/>

- **`bin`**: the folder with compiled output files 
- **`lib`**: the folder to maintain dependencies
- **`doc`**: the folder contains the documentation and diagrams
- **`src`**: the folder to maintain sources
     - **`Tests`**
        - TestAi.java
        - TestGame.java
     - **`TicTacToeAI`**
        - Ai.java
        - Game.java
        - Main.java

<br/>

## **Change starting Player**
<br/>

On default the starting Player is the human, who going to play against the **AI** 
<br/>
Following code shows how to change it in the **`Game.java`** file:

<br/>
<br/>


```java
...

public class Game {

    public static String[][] board = {
            { " ", " ", " " },
            { " ", " ", " " },
            { " ", " ", " " }
    };
    public static final String human = "O";
    public static final String ai = "X";
    public static String currentPlayer = human; // ← change human to ai

    ...
}

```


[TicTacToe]:https://de.wikipedia.org/wiki/Tic-Tac-
[Minimax-Algorithmus]:https://de.wikipedia.org/wiki/Minimax-Algorithmus