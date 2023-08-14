import java.util.Objects;

public class Compare2Obj {
    public static void main(String[] args) {
        Student s1 = new Student("nrr", 51);
        Student s2 = new Student("nrr", 51);

        s1.showStudent();
        s2.showStudent();

        System.out.println("S1 is equals to s2: " + s1.equals(s2));
    }
    public static class Student{
        private String name;
        private int id;
        public Student(String name, int id){
            this.name = name;
            this.id = id;
        }
        public void showStudent(){
            System.out.println("Name: " + this.name + "\nId: " + this.id);
        }

//        @Override
        public boolean equals(Student st) {
            return this.id == st.id && this.name == st.name;
        }
    }
}
