import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> arr =new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        // For sorting pass age name or id.
        String x=sc.next();
        arr.add(new Student(22, "Anmol",  1));
        arr.add(new Student(23, "Shashwat",  2));
        arr.add(new Student(24, "Ashwani",  3));
        arr.add(new Student(23, "Kenneth",  4));
        Main s=new Main();
        s.sort(arr,x);
    }
    public static void sort(ArrayList<Student>arr,String x){

        switch (x.toLowerCase()){
            case "age":
                StudentSorter.sortStudents(arr, StudentSorter.sortByAge());
                arr.forEach(System.out::println);
                break;
            case "name":
                StudentSorter.sortStudents(arr, StudentSorter.sortByName());
                arr.forEach(System.out::println);
                break;
            case "id":
                StudentSorter.sortStudents(arr, StudentSorter.sortById());
                arr.forEach(System.out::println);
                break;
            default:
                System.out.println("Invalid input");
        }


    }
}

 class StudentSorter {
    // Generic sorting function
    public static <T> void sortStudents(List<Student> students, Comparator<Student> comparator) {
        Collections.sort(students, comparator);
    }

    // Comparator for sorting by age
    public static Comparator<Student> sortByAge() {
        return Comparator.comparingInt(Student::getAge);
    }

    // Comparator for sorting by name
    public static Comparator<Student> sortByName() {
        return Comparator.comparing(Student::getName);
    }

    // Comparator for sorting by id
    public static Comparator<Student> sortById() {
        return Comparator.comparingInt(Student::getstudentId);
    }
}


class Student<T>{
    String name;
    int age;
    int studentId;

    // Constructor
    public Student( int age,String name, int studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getstudentId() {
        return studentId;
    }

    // toString method for printing
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", id=" + studentId + '}';
    }
}
