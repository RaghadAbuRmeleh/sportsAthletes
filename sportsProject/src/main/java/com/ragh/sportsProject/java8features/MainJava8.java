package com.ragh.sportsProject.java8features;

import com.ragh.sportsProject.layers.domain.Sport;

import java.util.Optional;
import java.util.function.Function;

public class MainJava8 {
    public static void main (String[] args){
        ClassImp instance = new ClassImp();
        String result = instance.convertSome(55);
        System.out.println(result);


        Calculator sum = new SumCalculate();
        Calculator multi = new MultiplyCalculator();


        Calculator divide = (a,b) -> a/b;
        Calculator sumLambda = (a,b) -> a + b;

        System.out.println("Divide JAVA8 " +divide.calculate(5,8));
        System.out.println("Sum JAVA8 " + sumLambda.calculate(5.5,6.7));

        System.out.println("Multiply " +multi.calculate(5,8));
        System.out.println("Sum " + sum.calculate(5.5,6.7));

        AnotherFunctionalInterface price = (cost, tax, prefix, someObj) -> {
            if (Optional.ofNullable(someObj).isEmpty()) {
                return prefix + (cost * tax);
            }
            return prefix + (cost * tax) + someObj.toString();
        };

        System.out.println(price.doSom(100,5,"tax",new Object()));

        String s = "HI";
        Sport sport = new Sport();
        sport.setSportTime(90.0);
        System.out.println(halfTime(new Sport()));

    }

    public static Double halfTime (Sport sport){

        return Optional.ofNullable(sport)
                .map((s) -> s.getSportTime())
                .map((sportTime) -> sportTime / 2)
             //   .orElseGet(() -> returnValue());
               // .orElseThrow(() -> new RuntimeException())
               .orElse(returnValue() );
              //  .get();
    }


    public static Double returnValue (){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return 90.0;
    }

}
