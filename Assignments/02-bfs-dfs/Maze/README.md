# DFS & BFS Traversals

This is my solutions for DFS and BFS maze traversals. This project is broken up into 4 packages which each handle a portion.

## App.java

App.java is the main entry point, it's function is to handle setting up the maze, building the maze, running the traversals, and cleaning up when done. It calls on the other packages to achieve that goal. 

## MazeBuilder

The MazeBuilder package, like its name suggests, handles information related to actually building the maze to be solved. It contains 3 files, `Builder.java`, `CellState.java` and `CellType.java`

### Builder.java

The builder classes is the main maze object, it stores the 2D array as well as all of the cell states. It also contains the definition for the Point class which is used to reference locations in the maze. 

The builder class also contains the logic for verifying seeds, and the toString method handles the creation of the printable maze object.

### CellState.java

The CellState class is a very simple class that just handles the storage of that current cells information. It includes the cells type, distance, and if it has been visited. 

Cell distance defaults to the MAX_INTEGER value so that the path finding algorithm based on distance will not try to path to walls.

### CellType.java

The CellType file is a simple enum that just stores what type of cell the current one is. The possible types are `empty`, `wall`, `start`, `end`, and `path`. Its toString method is used during printing to correctly represent what the cell type is.

## Structures

This package just contains the structures needed to make the DFS and BFS work. It employs a LinkedList based solution for both the Stack structure and Queue structure.

## Traverser

This package contains one file, it handles the stack-based DFS traversal, the queue-based BFS traversal, and the back tracking to build the final path.

Each iteration of the traversal loops print out a version of the maze on a 100ms delay so you are able to watch it being solved. 

#### DFS

The DFS traversal employs a stack-based solution. When the method is called it resets the provided builder object, gets the starting point, and initializes a stack of points. 

The main loop runs until either all points have been visited and no endpoint was found, or an endpoint was found. In the case that no endpoint was found it simply returns out of the function and prints an error. In the case of an endpoint being found, it calls on the backtracking method to build a path and then returns out of the function.

#### BFS

The BFS traversal employs a queue-based solution. When the method is called it resets the provided builder object, gets the starting point, and initializes a queue of points. 

The main loop will run until all points have been visited and no endpoint was found or an endpoint was found. In the case where an endpoint is found it will call the backtrack method to build a path and return out. In the case that no endpoint was found, it will print an error and return out.

#### Backtrack

The backtrack method takes in a endpoint, while the points types are either empty or the end, it will look at each adjacent north, south, east, and west point for the one with the minimum distance value. Once it finds the next point it updates the state currently being checked and loops until it finds a point with a type of start.

## Utils

The utils package holds 3 files, `CLR.java`, `Menu.java`, and `Print.java`. These provide simple functions to help with printing the maze and getting user input. 

### CLR.java

The CLR enum contains the ANSI code of each color used during printing. They were assembled into an easier to read enum instead of having to remember what each ANSI code was when doing a print.

### Print.java

The Print class handles all the logic for printing over previous lines in the console. It makes use of ANSI codes to move the cursor back lines in the terminal and clear lines in the terminal.

It also contains a helper function to handle sleeping so each area sleep was used did not need a try/catch block.

### Menu.java

The Menu class just handles getting the user input for config on startup.