# Game of Life

_The Game of Life_ takes place on a two-dimensional, finite, and 2D square grid of cells. Each `Cell` is in one of two possible states: _alive_ or _dead_.   
Once the grid is initialized, the game progresses in discrete steps called `ticks`.   
At each tick the existing snapshot of the grid is used for each cell to interact with its neighbors based on four basic rules to determine the next state of the grid.  
The state of the grid is a representation of the dead and alive cells in a grid of a fixed size.   
The following rules are applied for the `Grid` to move towards a new state:

1. Any live cell with fewer than two live neighbors dies.
2. Any live cell with two or three live neighbors lives.
3. Any live cell with more than three live neighbors dies.
4. Any dead cell with exactly three live neighbors becomes alive.

Requirements
- A cell shall be in two possible states: dead or alive
- The grid shall be of any size that is composed of a square arrangement of cells in 2D, e.g. 10x10, 50x50 etc. Therefore, each cell shall be accessible by a unique (x, y) coordinate.
- The states of the cells in the grid shall be initialized uniformly at the beginning, i.e. number of alive cells should be roughly equal to the number of dead cells.
- Neighbors of a cell are defined as the ones, which are in the immediate vicinity that surround the cell (including the diagonals). E.g. any cell inside the grid has 8 neighbors, whereas cells in the borders have 5 and cells in the corners have 3 neighbors. A cell is not its own neighbor.
- At each tick, the state of the grid shall be updated according to the four neighborhood-based rules above. These rules shall be applied to all cells simultaneously, i.e. the order of cells to which the rules are applied should not affect the outcome.
- The state of the grid shall be represented as a string, where dead cells are represented with a “-” (dash) and alive cells are represented with a “*” (star) character. When printed, this string should be displayed in N lines (rows of the grid), each consisting of N characters (columns of the grid), where NxN is the size of the grid.
- You shall throw a `NegativeCoordinateException` when a cell receives negative coordinates, a `CellCoordinateOutOfBoundariesException` when the `Grid` contains cell outside its limits, and a `CustomLifeException` for all other error cases.

**PLEASE COMPLETE QUESTIONNAIRE AT**: https://goo.gl/forms/aTJkjkXITHwMD3xB3
