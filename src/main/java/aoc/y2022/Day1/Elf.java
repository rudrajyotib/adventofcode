package aoc.y2022.Day1;

@SuppressWarnings("rawtypes")
public class Elf implements Comparable {

    private int totalCalories = 0;

    public Elf() {
    }

    public void addCalorie(int calorie) {
        this.totalCalories += calorie;
    }

    public int getTotalCalories() {
        return this.totalCalories;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.totalCalories, ((Elf) o).getTotalCalories());
    }
}
