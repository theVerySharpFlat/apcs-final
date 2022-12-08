public class Student {
    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return o.getClass() == Student.class && ((Student)o).getName().equals(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
