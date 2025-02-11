package com.ap.pre.interfaces;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
 interface MyFunction<T, U, R> {
    R operate(T t, U u);

}


public class FunctionalInterfaceTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Runnable task = () -> System.out.println("Running a task!");
        new Thread(task).start();

        Callable<Integer> callableTask = () -> {
                Thread.sleep(1000);
                return 42;
                };
                
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //Future<Integer> future = Executors.newSingleThreadExecutor().submit(callableTask);
        Future<Integer> future = executor.submit(callableTask);
        System.out.println("Result: " + future.get());

        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length: " + stringLength.apply("Hello, world!"));  

        Function<String, String> fun2 = new Function<String,String>() {
            @Override
            public String apply(String s){
                return "World !!!";
            }
        };
        System.out.println("Hello: " + fun2.apply("Hello!"));  

        Function<String, String> fun3 =  r -> "World2!!!!"; 
        System.err.println("r " + fun3.apply("Hello"));

        Consumer<String> printConsumer = s -> System.out.println("Consumed: " + s);
        printConsumer.accept("Hello, consumer!");

        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random number: " + randomSupplier.get());

        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Sum: " + add.apply(5, 7));

        MyFunction<Integer, Integer, Integer> substract = (a,b) -> a - b;
        System.out.println("MyFunction substract:"+substract.operate(4, 1));

        MyFunction<String, String, Integer> myFun2 = (a,b) -> a.length() - b.length();
        System.out.println("MyFunction substract2:" + myFun2.operate("Hellooooo", "World"));

        MyFunction<Integer, Integer, Integer> myFunAdd = (a, b) -> a + b;
        System.out.println("MyFunction Add:" + myFunAdd.operate(15,7));

        //executor.shutdown(); 
     
    }

}
