package com.ragh.sportsProject.java8features;

public interface InterfaceImp {


    public String absMethod();

    public default String convertSome(Integer integer){
        return String.valueOf(integer);
    }


}
