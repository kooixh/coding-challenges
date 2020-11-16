# Coding-Challenges
A series of coding challenges questions and solution in various topics

Feel free to add new questions and solution to the project


## Instructions

1. Write your question in the appropriate docstring before the implementation method.

Example
```java
/**
  *
  * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
  *
  * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
  *
  * Ref: https://leetcode.com/problems/number-of-islands/
  */
public int numberOfIslands(int[][] map) {
}
        
```
2. Write a test method for the solution prefixed with "testXXX", this prefix is needed for the 
test to be run automatically.
3. Make sure tests pass by calling the verify result method.

Example
```java
static void testNumberOfIsland() {
    int[][] map1 = {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
    int expected1 = 1;
    int actual1 = graphSolution.numberOfIslands(map1);
    System.out.print("test 1: ");
    verify(expected1, actual1);
}
```

Feel free to improve any existing solutions
