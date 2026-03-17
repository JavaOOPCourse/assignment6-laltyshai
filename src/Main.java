import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        // Сделай минимум два студента с одинаковым GPA (для Task 3)
        Student s1=new Student("aaaalana", 2.0, 11);
        Student s2=new Student("lana2", 2.0, 11);
        Student s3=new Student("xxxlana3", 1.8, 11);
        Student s4=new Student("zzzzzzzlana4", 3.9, 11);
        Student s5=new Student("lana5", 4.0, 11);

        students.put("121", s1);
        students.put("122", s2);
        students.put("123", s3);
        students.put("124", s4);
        students.put("125", s5);

        // TODO: Напечатай всех студентов (ID + объект) +++
        Iterator<Map.Entry<String, Student>> it1 = students.entrySet().iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
        // TODO: Найди студента по ID и выведи его ++
        System.out.println("found student: "+ students.get("123"));
        // TODO: Удали одного студента по ID ++++
        System.out.println(students.remove("125"));
        // TODO: Обнови GPA у одного студента +++
        students.get("124").setGpa(3.8);

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values()) +++
        ArrayList<Student> arr = new ArrayList<>(students.values());
        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи

        Collections.sort(arr);
        System.out.println(arr);

        // TODO 6b: Отсортируй по имени (Comparator) и выведи

        arr.sort(new NameComparator());
        System.out.println(arr);

        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3

        ArrayList<Student> arr2 = new ArrayList<>(students.values());
        arr2.sort(new GPAubivanie());
        for (int i=0;i<3;i++) System.out.println(arr2.get(i));

        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        HashMap<Double, ArrayList<Student>> grouping = new HashMap<>();
        for (Student s : arr2) {
            if (!grouping.containsKey(s.getGpa())) {
                grouping.put(s.getGpa(), new ArrayList<>());
            }
            grouping.get(s.getGpa()).add(s);
        }
        Iterator<Map.Entry<Double, ArrayList<Student>>> it2 = grouping.entrySet().iterator();
        while ((it2.hasNext())) {
            Map.Entry<Double, ArrayList<Student>> i = it2.next();
            if (i.getValue().size()>1) {
                System.out.println(i);
            }
        }


        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё.
        Course o1 = new Course("cs");
        Course o2 = new Course("pl");
        Course o3 = new Course("algebra");

        courseMap.put(o1,Arrays.asList(s1,s2,s3));
        courseMap.put(o2,Arrays.asList(s1,s4));
        courseMap.put(o3,Arrays.asList(s4,s5));

        Iterator<Map.Entry<Course,List<Student>>> it3 = courseMap.entrySet().iterator();
        while (it3.hasNext()) {
            System.out.println(it3.next());
        }
        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
        arr.sort(new BothComparator());
        System.out.println(arr);
    }
}



class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class GPAubivanie implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o2.getGpa(), o1.getGpa());
    }
}

class BothComparator implements  Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int res= Double.compare(o2.getGpa(), o1.getGpa());
        if (res!=0 )return res;
        else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}