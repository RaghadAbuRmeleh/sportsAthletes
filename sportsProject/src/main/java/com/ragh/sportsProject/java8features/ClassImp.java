package com.ragh.sportsProject.java8features;

public class ClassImp implements InterfaceImp {
    @Override
    public String absMethod() {
        return "this is abstract method";
    }

//    @Override
//    public String convertSome(Integer integer) {
//        return InterfaceImp.super.convertSome(integer);
//    }
}
