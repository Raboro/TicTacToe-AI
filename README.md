## <pre>                 **\~_TicTacToeAI_\~**<pre>

This project contains a terminal **[TicTacToe]** game. You play against an 
AI, which uses the <br/>
 **[Minimax-Algorithmus]** to make a move.

This project contains the three java files:
   - Ai.java
   - Game.java
   - Main.java

These files are necessary to run the game and are in **`src/TicTacToeAI`**.
In addition to that I also added two Test files, which are in **`src/Tests`**. These two files are writen with JUnit-4. I also created a class diagram and a documentation, both are in **`doc/`**.

<br/>

## **Folder Structure**
<br/>

- **`.vscode`: settings for vscode**
     > - settings.json 
- **`bin`: the folder with compiled output files**
     > - **`Tests`**
     >   - TestAi.class
     >   - TestGame.class  
     > - **`TicTacToeAI`**
     >   - Ai.java
     >   - Game.java
     >   - Main.java
- **`doc`: the folder contains the documentation and diagrams**
     > - class diagram.md
     > - documentation.docx
- **`lib`: the folder to maintain dependencies**
     > - hamcrest-core-1.3.jar 
     > - juni-4.13.2.jar
- **`src`: the folder to maintain sources**
     > - **`Tests`**
     >   - TestAi.java
     >   - TestGame.java
     > - **`TicTacToeAI`**
     >   - Ai.java
     >   - Game.java
     >   - Main.java

<br/>

## **Change starting Player**
<br/>

On default the starting Player is the human, who going to play against the **AI**.
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