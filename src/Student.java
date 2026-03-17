public class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    private int age;

    // TODO: Task 1 — Создай конструктор, который принимает имя, GPA и возраст
    public Student(String nam, double gp, int ag) {
        // заглушка
        name=nam;
        gpa=gp;
        age=ag;
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public int getAge() { return age; }

    // TODO: Task 1 — Добавь возможность изменить GPA
    public void setGpa(double newGpa) {
        // заглушка
        gpa=newGpa;
    }

    // TODO: Task 1 (Sorting) — Реализуй Comparable по GPA (по возрастанию)
    @Override
    public int compareTo(Student other) {
        // заглушка — верни правильное значение сравнения
        return Double.compare(this.gpa, other.gpa);
    }

    @Override
    public String toString() {
        // TODO: Сделай красивый вывод
        return "student name:  " +name+",  gpa:  "+gpa+"  , age: "+age;
    }
}