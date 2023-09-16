import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

import static java.time.chrono.JapaneseEra.values;

public class Minion {
    //Свойства
    int age;
    String name;

    //Конструктор для ручного ввода
    public Minion(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Minion() {
        Random random = new Random();

        this.age = random.nextInt(1, 20);

        this.name = Collections.unmodifiableList(Arrays.asList(values())).get(random.nextInt(Collections.unmodifiableList(Arrays.asList(values())).size())).toString();
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Minion minion = (Minion) o;
        return age == minion.age && Objects.equals(name, minion.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "Minion{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}
