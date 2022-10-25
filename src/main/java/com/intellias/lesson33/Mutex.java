package com.intellias.lesson33;

public class Mutex {
    private Object object;

    public static void main(String[] args) {

    }

    public void print(){
        synchronized (object){
            System.out.println("Hello");
        }
//
//        if (object.isBuzy()){
//            System.out.println("Hello");
//        }
    }
}
