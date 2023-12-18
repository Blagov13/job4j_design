package ru.job4j.map;

import java.util.*;

public class Person {
    private final String name;
    private final int personCode;

    public Person(String name, int personCode) {
        this.name = name;
        this.personCode = personCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return personCode == person.personCode && Objects.equals(name, person.name);
    }
/* Возможно использовать метод hash класса Object. Не подойдет в случае высоких
требований к производительности.
 */
   /* @Override
    public int hashCode() {
        return Objects.hash(name, personCode);
    }*/

    /* Для остального используем свою реализацию, используя следующий алгоритм: */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Integer.hashCode(personCode);
        return result;
    }

    /* Дальше пример, если мы не правильно реализуем hashCode, например
    @Override
        public int hashCode() {
            return (int) (this.phone * Math.random());
        }
        То при вызове метода get() вместо ожидаемого "1" получим "null"
        Потому что в данной реализации для каждого новго объекта мы будем генерировать
        уникальный hash-код.
     */
    public static void main(String[] args) {
        Person aleks = new Person("Aleksandr", 9889);
        Person daria = new Person("Daria", 9890);
        Person vova = new Person("Vladimir", 1010);
        Map<Person, Integer> persons = new HashMap<>();
        persons.put(aleks, 1);
        persons.put(daria, 2);
        persons.put(vova, 3);
        for (int i = 0; i < 10; i++) {
            System.out.println(persons.get(new Person("Aleksandr", 9889)));
        }
    }
}

