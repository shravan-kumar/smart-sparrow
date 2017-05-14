package com.smartsparrow.codingchallenge.resolution

import com.smartsparrow.codingchallenge.constants.Direction
import com.smartsparrow.codingchallenge.exception.EmptyStringException

/**
 * Spiral program to to resolve a way out algorithm in anticlockwise direction
 */
class Spiral {

    /**
     * The function to search all the values in anticlockwise direction starting from the given values
     * @return An array of values (Numbers from spiral) from a Matrix
     * @throws EmptyStringException if the input is not recognised
     */
    public static void wayOutAntiClockwise() {

        BufferedReader stdin = System.in.newReader()
        System.out.println("First we need to create a grid....")

        System.out.println("Please enter row of the grid ")
        int row = Integer.parseInt(stdin.readLine())

        System.out.println("Please enter column of the grid ")
        int column = Integer.parseInt(stdin.readLine())

        System.out.println("Please enter x position of the grid " +
                "from where you would like to start")
        int xPosition = Integer.parseInt(stdin.readLine())

        System.out.println("Please enter y position of the grid " +
                "from where you would like to start")
        int yPosition = Integer.parseInt(stdin.readLine())

        if (row == "" || row == null || column == "" || column == null || xPosition == "" || xPosition == null || yPosition == "" || yPosition == null ) {
            throw new EmptyStringException("Entered string is not valid!, Only Numbers/Digits are excepted in this " +
                    "resolution.")
        }

        int[][] spiralGrid = getGrid(row, column)

        def result = goThroughSpiral(row, column, xPosition, yPosition, spiralGrid)
        println(result)
    }

    /**
     * The function to check each and every value in spiral for the exit from give points
     * @param row Rows of the spiral
     * @param col Columns of the spiral
     * @param currentXPosition Current X position of the pointer
     * @param currentYPosition Current Y position of the pointer
     * @param grid Grid to check
     * @return An array of integers (Numbers from spiral) as a way out
     */
    private static Integer[] goThroughSpiral(int row, int col, int currentPositionX, int currentPositionY, int[][] grid) {
        ArrayList<Integer> wayOut = new ArrayList<Integer>()
        int nextX, nextY
        Direction nextDirection

        currentPositionX -= 1
        currentPositionY -= 1
        Direction currentDirection = Direction.UP

        wayOut.add(grid[currentPositionX][currentPositionY])
        grid[currentPositionX][currentPositionY] = -1

        while (wayOut.size() != row * col) {
            nextX = currentPositionX
            nextY = currentPositionY
            nextDirection = currentDirection
            switch (nextDirection) {
                case Direction.UP:
                    nextX -= 1
                    break
                case Direction.LEFT:
                    nextY -= 1
                    break
                case Direction.DOWN:
                    nextX += 1
                    break
                case Direction.RIGHT:
                    nextY += 1
                    break
            }

            if (checkValidPosition(nextX, nextY, grid)) {
                nextDirection = changeDirection(currentDirection)
            } else if (nextX < col && nextY < row && nextX > -1 && nextY > -1) {
                nextX = currentPositionX
                nextY = currentPositionY
                switch (nextDirection) {
                    case Direction.UP:
                        nextY += 1
                        break
                    case Direction.LEFT:
                        nextX -= 1
                        break
                    case Direction.DOWN:
                        nextY -= 1
                        break
                    case Direction.RIGHT:
                        nextX += 1
                        break
                }
            }

            if (!checkValidPosition(nextX, nextY, grid)) {
                Object[] value = getNextPosition(currentPositionX, currentPositionY, grid, nextDirection)
                nextX = value[0] as Integer
                nextY = value[1] as Integer
                nextDirection = value[2] as Direction
            }
            if (checkValidPosition(nextX, nextY, grid)){
                currentPositionX = nextX
                currentPositionY = nextY
                wayOut.add(grid[currentPositionX][currentPositionY])
                grid[currentPositionX][currentPositionY] = -1
                currentDirection = nextDirection
            }
        }
        return wayOut
    }
    /**
     * The function to get the next position from the matrix
     * @param tempDirection Current Direction of the pointer
     * @param currentXPosition Current X position of the pointer
     * @param currentYPosition Current Y position of the pointer
     * @param grid Grid to check
     * @return An Object containing current position and grid and direction
     */
    private static Object[] getNextPosition(int currentXPosition, int currentYPosition, int[][] grid, Direction tempDirection) {
        boolean check = false
        int xTemp, yTemp
        int i = 0
        while (!check) {
            if(i > 1000) System.exit(0);
            xTemp = currentXPosition
            yTemp = currentYPosition
            switch (tempDirection) {
                case Direction.UP:
                    xTemp -= xTemp
                    break
                case Direction.LEFT:
                    yTemp -= yTemp
                    break
                case Direction.DOWN:
                    xTemp += xTemp
                    break
                case Direction.RIGHT:
                    yTemp += yTemp
                    break
            }

            try {
                if (grid[xTemp][yTemp] != -1) { check = true }
                currentXPosition = xTemp
                currentYPosition = yTemp
            }
            catch (Exception e) {
                tempDirection = changeDirection(tempDirection)
            }
            i += 1
        }
        def rtnValue = [currentXPosition, currentYPosition, changeDirection(tempDirection)]
        return rtnValue
    }

    /**
     * The function to get the next direction in the spiral to move to
     * @param currentDirection Current Direction of the pointer
     * @return Direction enum
     */
    private static Direction changeDirection(Direction currentDirection) {
        Direction newDirection = null
        switch (currentDirection) {
            case Direction.UP:
                newDirection = Direction.LEFT
                break
            case Direction.RIGHT:
                newDirection = Direction.UP
                break
            case Direction.LEFT:
                newDirection = Direction.DOWN
                break
            case Direction.DOWN:
                newDirection = Direction.RIGHT
                break
        }
        return newDirection
    }

    /**
     * The function to check the next position whether the next position is valid or nor
     * * @param currentXPosition Current X position of the pointer
     * * @param currentYPosition Current Y position of the pointer
     * * @param grid Grid to check
     * @return Boolean value of whether current position is valid or not
     */
    private static boolean checkValidPosition(int currentXPosition, int currentYPosition, int[][] grid) {
        try {
            return (grid[currentXPosition][currentYPosition] != -1)
        }
        catch (Exception e) {
            return false
        }
    }

    /**
     * The function to create a grid from the given parameters
     * * @param row Rows of the spiral
     * * @param column Columns of the spiral
     * @return 2D array (forming a spiral)
     */
    private static int[][] getGrid(int row, int column) {
        int[][] grid = new int[row][column]
        int k = 1
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j] = k++
            }
        }
        return grid
    }
}
