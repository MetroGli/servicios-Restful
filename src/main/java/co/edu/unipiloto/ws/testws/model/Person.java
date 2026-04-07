package co.edu.unipiloto.ws.testws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

    private int id;
    private String fullName;
    private int age;

    private static final double SALARIO_MINIMO = 1300000;

    public Person() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getSalario() {
        return (age * SALARIO_MINIMO) / 3;
    }
}
