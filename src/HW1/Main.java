package HW1;

import java.util.ArrayList;
import java.util.Arrays;

/*
1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
3. Большая задача:
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку
нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока
- 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут
в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем
сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
а в другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.
*/
    public class Main {

            public static void main(String[] args) {
                //Exercise 1
                String[] arr1 = {"One", "Two", "Three", "Four", "Five", "Six", "Seven"};
                System.out.println("Exercise 1.1: "+Arrays.toString(arr1));
                swapPlaces(arr1,1,4);
                System.out.println("The result of the replacement: "+Arrays.toString(arr1)+"\n================================");

                Double[] arr2 = {1.0, 2.0, 3.0} ;
                System.out.println("Exercise 1.2: "+Arrays.toString(arr2));
                swapPlaces(arr2,0,2);
                System.out.println("The result of the replacement: "+Arrays.toString(arr2)+"\n================================");

                //Exercise 2
                String[] arrayOfStrings = {"A", "B", "C", "D"};
                System.out.println("Exercise 2. The result of the transformation : "+ toList(arrayOfStrings) +"\n================================");

                //Exercise 3

                Box<Orange> orangeBox = new Box<>();
                Box<Apple> greenAppleBox = new Box<>();
                Box<Apple> allAppleBox = new Box<>();

                orangeBox.addFruit(new Orange() ,10);
                greenAppleBox.addFruit(new Apple(),8);
                System.out.println("Exercise 3.\n'g' - addFruit: Orange on Orange Box, and Apple on AppleBox ");


                System.out.println("'d' - getWeight(): ");
                System.out.println("OrangeBox Weight: "+orangeBox.getWeight());
                System.out.println("GreenAppleBox Weight: "+greenAppleBox.getWeight());

                System.out.println("'e' - compare(): ");
                System.out.println("GreenAppleBox equals OrangeBox: "+greenAppleBox.compare(orangeBox));



                System.out.println("'f' - GreenAppleBox pourTo(allAppleBox) result: ");
                greenAppleBox.pourTo(allAppleBox);
                System.out.println("GreenAppleBox Weight: " + greenAppleBox.getWeight() + " AllAppleBox: " + allAppleBox.getWeight());
            }

            public static void swapPlaces(Object[] arr, int n1, int n2){
                Object sw = arr[n1];
                arr[n1]=arr[n2];
                arr[n2]=sw;
            }
            public static <T> ArrayList<T> toList(T[]arr){
                return new ArrayList<>(Arrays.asList(arr));
            }

        }

