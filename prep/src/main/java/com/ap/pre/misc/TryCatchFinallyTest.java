package com.ap.pre.misc;

public class TryCatchFinallyTest {

    public static void main(String[] args) {
        //test1();


        //test2(); //System.exit();
        //test3();  //infinite loop
        test4(new int[1024][1024]);    //stack overflow
    }

    //Finally will execute even if we put return
    static void test1(){
        try {
            System.out.println("In TRY Test1");
            //return;
            throw new RuntimeException("Test");
        } catch (Exception e) {
            System.out.println("In CATCH Test1");
            System.out.println(e);
            return;
        } finally {
            System.out.println("In Finallly Test1");
        }
    }

    //FInally will not execute if we do System.exit()
    static void test2(){
        try {
            System.out.println("In TRY Test2");
            System.exit(0);
            throw new RuntimeException("Test2");
        } catch (Exception e) {
            System.out.println("In CATCH Test2");
            System.out.println(e);
            return;
        } finally {
            System.out.println("In Finallly Test2");
        }
    }

    //FInally will not execute as we have infite loop
    static void test3(){
        try {
            System.out.println("In TRY Test3");
            while (true){

            }
        } catch (Exception e) {
            System.out.println("In CATCH Test3");
            System.out.println(e);
            return;
        } finally {
            System.out.println("In Finallly Test3");
        }
    }
    //FInally will not execute as we have infite loop
    static void test4(int[][] grid){
        try {
            int grid2[][] = new int[1024][1024];
            System.out.println("In TRY Test4");
            test4Helper(grid2);
            /*while (true){
                test4(grid2);   // finally of every previous iteration is executed
            }*/
        } catch (Exception e) {
            System.out.println("In CATCH Test4");
            System.out.println(e);
            return;
        } finally {
            System.out.println("In Finallly Test4");
        }
    }
    static void test4Helper(int[][] grid){
            int grid2[][] = new int[1024][1024];
            
                test4(grid2);
            
       
    }

}
