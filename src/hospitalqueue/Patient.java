package hospitalqueue;

import java.util.Random;

public class Patient {

    String name;
    String gender;
    String age;
    String disease;
    int patientNumber = counter;
    static int counter = 1;

    public Patient() {

        this.name = ("Patient " + patientNumber);
        this.gender = "Unknown";
        this.disease = "Unknown";
        this.age = "200";
        counter++;
    }

    public void generateRandomPatient() {
        Random r = new Random();
        int age = r.nextInt(100) + 1;
        int b = r.nextInt(2);
        int c = r.nextInt(4);

        if (age > 100) {
            age = 200;
        }
        switch (b) {
            case 0:
                gender = "Male";
                break;
            case 1:
                gender = "Female";
                break;

        }
        switch (c) {
            case 0:
                disease = "Fever";
                break;
            case 1:
                disease = "Flu";
                break;
            case 2:
                disease = "Smallpox";
                break;
            case 3:
                disease = "Injury";
                break;

        }
        this.age = Integer.toString(age);

    }


    public String toString() {
        return name + "-" + age + "," + gender + "-" + disease;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public String getDisease() {
        return disease;
    }

    public String getAge() {
        return age;
    }
}
