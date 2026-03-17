import java.util.Objects;

public class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // TODO: Task 4 — Обязательно переопредели (иначе HashMap не будет работать!)

    public boolean equals(Course o) {// заглушка

        // 1. Проверяем, не один ли это и тот же объект в памяти
        if (this == o) return true;
        // 2. Проверяем на null и на совпадение классов
        if (o == null || getClass() != o.getClass()) return false;
        // 3. Кастуем к типу Course и сравниваем значимые поля
        Course course = (Course) o;
        return Objects.equals(name, course.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name); // заглушка
    }
//    что здесь делать???

    @Override
    public String toString() {
        return "Course: " + name;
    }
}
