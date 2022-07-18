## **Getting Started**

This project contains a terminal **[TicTacToe]** game. You play against an 
ai, which uses the **[Minimax-Algorithmus]** to make a move.

<br/>

## **Folder Structure**
<br/>

- **`bin`**  the folder with compiled output files 
- **`lib`**: the folder to maintain dependencies
- **`src`**: the folder to maintain sources
     - **`Tests`**
        - TestAi.java
        - TestGame.java
     - **`TicTacToeAI`**
        - Ai.java
        - Game.java
        - Main.java

<br/>

<!--
```java
    public void main(String[] args) {
        System.out.print("Hello");
    }
```

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

-->

## **Change starting Player**
<br/>

> On default the starting Player is the human, who going to play against the **AI** 
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