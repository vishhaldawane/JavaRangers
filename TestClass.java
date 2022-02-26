package com.company.onetoone;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

class Kite
{
    static int kiteCount; //shared variable - since it is static, one copy maintained across all the objects of Kite
    int kiteLength;
    String kiteOwner;

    public Kite(int kiteLength, String kiteOwner) {
        ++kiteCount;
        this.kiteLength = kiteLength;
        this.kiteOwner = kiteOwner;
    }

    public Kite( String kiteOwner) {
        ++kiteCount;

        this.kiteOwner = kiteOwner;
    }

    public Kite(int kiteLength) {
        ++kiteCount;
        this.kiteLength = kiteLength;

    }
    public Kite(int kiteLength,int x, int y, float j, String k) {
        ++kiteCount;
        this.kiteLength = kiteLength;

    }

   public void fly() {

    }

    public void kiteFight() {

    }

    @Override
    public String toString() {
        return "Kite{" +
                "kiteLength=" + kiteLength +
                ", kiteOwner='" + kiteOwner + '\'' +
                '}';
    }
}
public class TestClass {
    public static void main(String[] args) {




       Class metadataHere = Kite.class;

        System.out.println("name is : "+metadataHere.getName());

        Constructor ctors[] = metadataHere.getConstructors();
        for (int i = 0; i < ctors.length; i++) {
            System.out.println("Kite constructor with "+ctors[i].getParameterCount()+" arguments");
            Parameter para[] = ctors[i].getParameters();
            for (int j = 0; j <para.length ; j++) {
                System.out.println("parameter type is : "+para[j].getType());
            }
            System.out.println("-------------");
        }

        Method allMethods[] = metadataHere.getMethods();
        for (int i = 0; i < allMethods.length; i++) {
            System.out.println("Method found is : "+allMethods[i].getName());
        }
    }
}
