## **\~_TicTacToeAI_\~**

This project contains a terminal **[TicTacToe]** game. You play against an 
AI, which uses the <br/>
 **[Minimax-Algorithmus]** to make a move.

This project contains the three java files:
   - [Ai.java]
   - [Game.java]
   - [Main.java]

These files are necessary to run the game and are in **`src/TicTacToeAI`**.
In addition to that I also added two Test files, which are in **`src/Tests`**. These two files are writen with JUnit-4. I also created a class diagram and a documentation, both are in **`doc/`**.

<br/>

## **Folder Structure**
<br/>

- **`.vscode`: settings for vscode**
     > - [settings.json] 
- **`bin`: the folder with compiled output files**
     > - **`Tests`**
     >   - [TestAi.class]
     >   - [TestGame.class]  
     > - **`TicTacToeAI`**
     >   - [Ai.class]
     >   - [Game.class]
     >   - [Main.class]
- **`doc`: the folder contains the documentation and diagrams**
     > - [classdiagram.md]
     > - [documentation.docx]
- **`lib`: the folder to maintain dependencies**
     > - [hamcrest-core-1.3.jar]
     > - [junit-4.13.2.jar]
- **`src`: the folder to maintain sources**
     > - **`Tests`**
     >   - [TestAi.java]
     >   - [TestGame.java]
     > - **`TicTacToeAI`**
     >   - [Ai.java]
     >   - [Game.java]
     >   - [Main.java]

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
[Ai.java]:https://github.com/Raboro/TicTacToe-AI/blob/master/src/TicTacToeAI/Ai.java
[Game.java]:https://github.com/Raboro/TicTacToe-AI/blob/master/src/TicTacToeAI/Game.java
[Main.java]:https://github.com/Raboro/TicTacToe-AI/blob/master/src/TicTacToeAI/Ai.java
[TestAi.java]:https://github.com/Raboro/TicTacToe-AI/blob/master/src/Tests/TestAi.java
[TestGame.java]:https://github.com/Raboro/TicTacToe-AI/blob/master/src/Tests/TestGame.java
[classdiagram.md]:https://github.com/Raboro/TicTacToe-AI/blob/master/doc/classdiagram.md
[documentation.docx]:https://github.com/Raboro/TicTacToe-AI/blob/master/doc/documentation.docx
[settings.json]:https://github.com/Raboro/TicTacToe-AI/blob/master/.vscode/settings.json
[TestAI.class]:https://github.com/Raboro/TicTacToe-AI/blob/master/bin/Tests/TestAi.class
[TestGame.class]:https://github.com/Raboro/TicTacToe-AI/blob/master/bin/Tests/TestGame.class
[Ai.class]:https://github.com/Raboro/TicTacToe-AI/blob/master/bin/TicTacToeAI/Ai.class
[Game.class]:https://github.com/Raboro/TicTacToe-AI/blob/master/bin/TicTacToeAI/Game.class
[Main.class]:https://github.com/Raboro/TicTacToe-AI/blob/master/bin/TicTacToeAI/Main.class
[hamcrest-core-1.3.jar]:https://github.com/Raboro/TicTacToe-AI/blob/master/lib/hamcrest-core-1.3.jar
[junit-4.13.2.jar]:https://github.com/Raboro/TicTacToe-AI/blob/master/lib/junit-4.13.2.jar