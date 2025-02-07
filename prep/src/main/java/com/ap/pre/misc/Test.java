package com.ap.pre.misc;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class Test {

    private static int findGroup(int[][] grid) {
       int res = 0;

       if (grid == null ){
            return 0;
       }

       for (int i = 0; i < grid.length; i++){

        for (int j =0; j < grid[0].length; j++){

            if (grid[i][j] == 1){
                res++;

                anotherFucntion(grid, i, j);

            }
        }

       }

       return res;

    }
    private static void anotherFucntion(int[][] grid, int i, int j) {

        int len = grid.length;
        int len2= grid[0].length;


      if (i <0 || j<0 ){
        return;

      }
      if ( i > len -1){
        return;
      }
      if ( j > len2 -1 || grid [i][j] == 0){
        return;
      }

      grid[i][j] = 0;

      anotherFucntion(grid, i+1, j);
      anotherFucntion(grid, i-1, j);
      anotherFucntion(grid, i, j+1);
      anotherFucntion(grid, i, j-1);
      anotherFucntion(grid, i-1, j-1);
      anotherFucntion(grid, i-1, j+1);
      anotherFucntion(grid, i+1, j-1);
      anotherFucntion(grid, i+1, j+1);

    }


    public static void main(String[] args) {
        int [][] grid = {{1, 1, 0, 0, 0},
                         {0, 1, 0, 0, 1},
                         {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 1, 0}};
        

                //int res = findGroup(grid);
                System.err.println(findGroup(grid));
                                
                
                int[] numbers = IntStream.range(1, 1000000).toArray();
                      ForkJoinPool pool = new ForkJoinPool();
                      pool.invoke(anotherFucntion(grid, 0  , 0));
                       
                
                
                          }
                
                
                
                  
            

}



/*
 * 
 * 
 * {{1, 2, 3}, 
 {4, 5, 6}, 
  {7, 8, 9}}
 */