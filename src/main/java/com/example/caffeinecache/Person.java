package com.example.caffeinecache;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-03        koiw1       최초 생성
 */


public class Person {

    String name = "테스트" ;
    int age = 33 ;
    String weight = "76kg" ;
    String height = "173cm" ;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                '}';
    }

    public Person() {
    }

    public Person(String name, int age, String weight, String height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }
}
