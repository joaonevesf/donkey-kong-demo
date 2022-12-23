# L00T01G09 - Donkey Kong<PROJECT NAME>


> The project is based on an arcade game of 1981 the 'Donkey Kong'. The monkey (Donkey Kong) is the main enemy who Mario (the jumpman) has to fight against. An important characteristic is the ability to jump, since it was the first arcade game to incorporate it. Therefore, the goal of the game is for Mario to reach the princess, in the highest floor. But he will have to face Donkey Kong that is on rampage throwing barrels, and climb some dangerous stairs.

>The authors of the project are Nils Rothamel (202203004@fe.up.pt), João Fernandes (202108867@fe.up.pt) and Sara Santos (202108675@fe.up.pt) for LDTS 2022/2023

## INDEX

- [Implemented Features](#implemented-features)
  - [Screenshots](#screenshots)
    - [Level 1](#level-1)
    - [Level 2](#level-2)
    - [Menus](#menus)
    - [Between Levels](#between-levels)
    - [Others](#others)
- [Design](#design)
  - [UML](#uml)
  - [Design Patterns](#design-patterns)
  - [Known Code Smells and Refactoring Suggestions](#known-code-smells-and-refactoring-suggestions)
- [Better Code Hub](#better-code-hub)
- [Testing](#testing)



## IMPLEMENTED FEATURES

**Features:**

- **Mario Movement** - The player can control the directions that Mario moves. But there are restrictions, you only move to right and left on the floor, and the stairs are the only way to move vertically.

- **Jumping** - Mario will jump when the space bar is pressed.

- **Climbing stairs** - To move to the higher floor it's needed to climb the stairs. Therefore, if the character is in the same position as the stairs, it can climb. But if the stairs are broken, the action can't be completed.

- **Gravity** - Gravity is very important in Donkey Kong, and it helps in some functions. For example, if Mario isn't standing on the floor, he automatically falls.

- **Moving Barrels according to the floor** - The barrels are an important feature in the original game. In this project, they move according to the floor. When they fall to the lower floor, they change the direction. In other words, if they were moving to the right side, in the next floor, they will move to the left side. Sometimes, they can also roll down the ladders.

- **Random Barrels move  down the stairs** - Another important feature is the ability to some barrels move down the stairs. The decision of the barrel go down the stair or continue in the floor is random, so every time the level 1 is played is a different level.

- **Two Different Levels** - The game has two different levels, with different rules, and goals. Because of the new elements added and more complex design.

- **Two Different Levels Map** - Besides the different monsters and conditions, there are also two different maps. They differ in the location of the stairs and floor, and also the inclusion of switches.

- **Losing through a barrel hit** - When a barrel is in the same place as Mario, the game automatically ends, and the player can try again.

- **Losing when face to face with Donkey Kong** - This feature is similar to the previous, when Mario touches Donkey Kong, the player looses.

- **Fire element** - They are different ´monsters´ than the barrels because of the way they move: slower, up and down the stairs, and just one part of the floor. 

- **Switch element** - These elements are important because of the final winning condition, where the Mario touches them, and they change the color from yellow to green.

- **Jump Score** - Which time that Mario jump a fire element or a barrel, is added to the jump score 100 points.

- **Time Score** - The time score starts with 5000 each level, when it passes 3 seconds these reduce 100 points of the initial score. 

- **Ranking** - After the gameplay, winning or losing, the player can register his name, and will update the scoreboard if he is one of the best players.  

- **Visuals** - The game uses a font that was made by the group. Where the mario has different visuals when is running to the left, or right or climbing the stairs. Also, the Donkey Kong, the Princess, the Fires, the Barrels, the Stairs has a more real view.

- **Instructions** - In the initial menu, the player can see some instructions, where see what which character means and they job.

- **Between Levels** - Before each level starts, it appears a window that is similar to the original game.

- **Menu** - There are different menu's, and it depends on losing or winning, or if it is the initial one.

- **Winning conditions** - Usually, the game ends when Mario is in the same level as the princess. Unless in the second level, where the goal is to touch the switchers and make the Donkey Kong fall.

- **Donkey Kong Falls** - When the player wins the game, it appears another window that shows the Donkey Kong in the last floor, like the original game. So it was used a different map to obtain the image.

### Screenshots 


### Level 1

<p>
  <img src="img/originalgame_nivel1.png" alt="">
</p>
<p align="center">
  <b><i>Img 1. Original Level 1</i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="img/stairs_screenshot.png" alt="">
</p>

<p align="center">
  <b><i>Img 2. Level 1 - First Deliver</i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="img/level1ClimbingStairs.png" alt="">
</p>

<p align="center">
  <b><i>Img 3. Level 1 - Second Deliver</i></b>
</p>
<br>
<br />

### Level 2

<p align="center" justify="center">
  <img src="img/originalgame_nivel2_lastfloor.png" alt="" >
</p>

<p align="center">
  <b><i>Img 4. Level 2 - Original Game</i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="img/level2Switches.png" alt="" >
</p>

<p align="center">
  <b><i>Img 5. Level 2 - Gameplay</i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="img/originalgame_nivel2_end.png" alt="" >
</p>

<p align="center">
  <b><i>Img 6. Level 2 - End - Original Game</i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="img/level2End.png" alt="" >
</p>

<p align="center">
  <b><i>Img 7. Level 2 - End</i></b>
</p>
<br>
<br />

### Between Levels

<p align="center" justify="center">
  <img src="img/originalgame_between12.png" alt="" >
</p>

<p align="center">
  <b><i>Img 8. Between Levels - Original Game</i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="img/betweenLevels12.png" alt="" >
</p>

<p align="center">
  <b><i>Img 9. Between Levels - End</i></b>
</p>
<br>
<br />


### Menus

<p align="center" justify="center">
  <img src="img/menuInitial.png" alt="" >
</p>

<p align="center">
  <b><i>Img 10. Initial Menu</i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="img/menuLost.png" alt="" >
</p>

<p align="center">
  <b><i>Img 11. Lost Menu</i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="img/menuWin.png" alt="" >
</p>

<p align="center">
  <b><i>Img 12. Win Menu</i></b>
</p>
<br>
<br />


### Others
<p align="center" justify="center">
  <img src="img/instructions.png" alt="" >
</p>

<p align="center">
  <b><i>Img 13. Instructions </i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="img/playerNameRanking.png" alt="" >
</p>

<p align="center">
  <b><i>Img 14. Player Name</i></b>
</p>
<br>
<br />

<p align="center" justify="center">
  <img src="img/scoreboard.png" alt="" >
</p>

<p align="center">
  <b><i>Img 15. Ranking</i></b>
</p>
<br>
<br />





## DESIGN

### UML

<p align="center">
  <img src="img/uml.png" alt="">
</p>

<p align="center">
  <b><i>Img 16. UML</i></b>
</p>
<br>
<br />

### DESIGN PATTERNS 

#### MVC (Model–View–Controller)

**Problem in Context**

From a beginner's point of view, it's difficult to create a game and connect all the dots. 
Because the user wants to have his commands interpreted, stored, easily viewable, and being logical for them. 
This Design Pattern is a solution that puts it all together in a easy way.


**The Pattern**

The whole game is based on the MVC architecture. Therefore, the View is a representation of the input data by the user, 
the Controller manipulates the Model according to the users input, and the Model represents the logical part of the backend data in the game.

<p align="center">
  <img src="img/mvc.png" alt="">
</p>

<p align="center">
  <b><i>Img 17. MVC </i></b>
</p>
<br>


**Implementation**

In the game it's visible where which component is implemented:

- [Controller](../src/main/java/com/aor/DK/controller)
- [Viewer](../src/main/java/com/aor/DK/viewer)
- [Model](../src/main/java/com/aor/DK/model)

**Consequences**

_Benefits:_

- Easy to test independently and to maintain
- Features are reusable
- Can be easily extended
- Facilitates collaborative work
- Separation of these three different components, separate responsibilities, and independence between input and output

_Disadvantages:_

- High complexity
- Difficult to understand

### Factory Method
**Problem in Context**

The problem is based on the high count of components that need to be represented and also the resemblances between the components. 
So, the game must have a Design Pattern to not implement the same code twice or more. 
The Menu, Game, between Levels and Ranking are similar because they need a view (a representation of the data). 
Some elements are the same, for instance: 'the between levels' (Img. 9) has a Donkey Kong and the gameplay also has. 
And which element is similar, for example, Mario and the Princess are both chars, they differ in their color and the chosen char, 
but the method to draw is the same.

**The Pattern**

The Pattern creates objects without exposing the instantiation logic to the client.
So, the creator can create a standard way to create objects, but it can be easily overridden/customized.

<p align="center">
  <img src="img/factory.png" alt="">
</p>

<p align="center">
  <b><i>Img 18. Factory Method </i></b>
</p>
<br>

**Implementation**

In the game it's visible where which component is implemented:

_Creator_:
- [Viewer](../src/main/java/com/aor/DK/viewer/Viewer.java)

_Concrete Creator (examples):_
- [Level Viewer](../src/main/java/com/aor/DK/viewer/GameViewer.java)
- [Game Viewer](../src/main/java/com/aor/DK/viewer/MenuViewer.java)

_Product:_
- [GenericViewer](../src/main/java/com/aor/DK/viewer/GenericViewer.java)

_Concrete Product (examples):_
- [BarrelViewer](../src/main/java/com/aor/DK/viewer/elements/BarrelViewer.java)
- [DonkeyKongViewer](../src/main/java/com/aor/DK/viewer/elements/DonkeyKongViewer.java)

**Consequences**

_Benefits:_

- Easy to test and maintain
- Create a design more customizable
- Polymorphic creation is possible
- Subclasses are proliferate
- Single Responsibility Principle

_Disadvantage:_
- High complexity because of the many subclasses that need to implement

### State

**Problem in Context**

Actually, the game has some states (Examples: Menu and Gameplay) on the graphic interface, and on controller. 
For each state, has a different way to behave: it represents different views; different actions has different consequences. 
Because, all the states need these, is needed a design to make the code is easier to implement and comprehend.

**The Pattern**

State Pattern is a Behavioral software design pattern, it's a way to solve similar recurring issues. 
When the internal state changes, alters its behavior. Within any unique state, the program behaves differently, and 
the program can be switched from one state to another instantaneously.

<p align="center">
  <img src="img/state.png" alt="">
</p>

<p align="center">
  <b><i>Img 19. State Pattern </i></b>
</p>
<br>

**Implementation**

In the game it's visible where which component is implemented:

_State:_
- [State](../src/main/java/com/aor/DK/states/State.java)

_Concrete States (examples):_
- [GameState](../src/main/java/com/aor/DK/states/GameState.java)
- [MenuState](../src/main/java/com/aor/DK/states/MenuState.java)


**Consequences**

_Benefits_:

- Single Responsibility Principle
- Simplify the code
- Open/Closed Principle

_Disadvantage_:
- Finite number of states

### Game Loop Pattern

**Problem in Context**

A situation that occurs frequently is what happened previously in MVC. So the user makes an action, and then the 
controller handles the input, the model updates the game and in the end it is visible because of the updated viewer.
This happens always the same way, so the game needs to handle this sequence of events without using a 'while' or a 'for' loop.

**The Pattern**

It's used in almost every game, and it's considered one of the basics of programming, avoiding inserting repeated data. 
It tracks the passage of time and with each turn of the loop, it processes user input without being blocked. For example, 
this could've been used to define that Donkey Kong throws barrels until Mario reaches the top floor.

**Implementation**

In the game it's visible where which component is implemented:

- [Controller](../src/main/java/com/aor/DK/controller)
- [Viewer](../src/main/java/com/aor/DK/viewer)
- [Model](../src/main/java/com/aor/DK/model)


**Consequences**

_Benefits:_
- A very common tool in games
- Easy to use and define
- Easy to understand when it can be used

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

**Bloaters**
- **Large Class**

  An example of a large Class is MarioController. This happens because Mario is a very important element and controls the winning and 
- losing condition, the ranking, and others... Because of that, it is easier to put all in the same class. Where other classes are called, but the flow of data always starts here. A way to solve this is to extract some subclasses.

<p align="center">
  <img src="img/largeClass.png" alt="">
</p>

<p align="center">
  <b><i>Img 20. Large Class </i></b>
</p>
<br>


**Object-Orientation Abusers**
- **Switch Statements**

  In menuController, there is an example of a switch. It's not the only one, and inside that switch there are a sequence of if statements. 
The code can change using design Patterns like the state or strategy. In the previous example (MarioController), can exist a Mario loose 
- and a Mario win... Or it can  Replace Conditional with Polymorphism. 

<p align="center">
  <img src="img/switch.png" alt="">
</p>

<p align="center">
  <b><i>Img 21. Switch Statement </i></b>
</p>
<br>



**Dispensables**
  - **Comments**

    Along the code some comments to justify why things are done like that. Besides being a smell, it's necessary because it can help other 
  - person that did not make the code.
    A class that contains this smell is in FireController.
    Using comments is an indication that the code is to complicated, and to make it simpler, can extract the method or introduce assertion.  


  - **Data Class**

    In Arena there are a lot of classes, many of them are Data Classes like getWidth, setMario and setBarrels (getters and setters). 
  - They can be a 'Self Encapsulate Field' and should remove the setting methods.

### BETTER CODE HUB

There are 4 parameters that needs to improve. The architecture balance happens because most of the code is in arena and the game. 
Also, the interfaces aren't small because of code smells that we talked about. 

Automate test doesn't apply to all the code and isn't simple because some methods, 
like the step() method, need a lot of information to act in the right way since a lot of methods 
are private and can only be tested through the step method. We also tried to reach 100% line coverage, which caused a lot of tests to expand.

<p align="center">
  <img src="img/Better Code Hub.png" alt="">
</p>

<p align="center">
  <b><i>Img 20. Better Code Hub </i></b>
</p>
<br>

### TESTING


![test coverage on final delivery](img/testcoveragefinal.png)



![mutation results on final delivery](img/mutation-results-print-final.png)


- [mutation test results](mutation-test-results-final)

### SELF-EVALUATION

Every element worked on the project in different ways. Also, we did some important meetings that helped to solve problems, and create the necessary solutions. So, we believe that everybody deserves the same percentage(33%).
