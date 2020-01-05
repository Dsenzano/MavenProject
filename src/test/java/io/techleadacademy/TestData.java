package io.techleadacademy;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class TestData {
    Faker faker = new Faker();
    public static void main(String[] args) {
    }

    public String firstNames() {
        return faker.name().firstName();
    }
    public String lastNames() {
        return faker.name().lastName();
    }
    public String phoneNumber() {
        return faker.phoneNumber().phoneNumber().substring(2);
    }
    public String address(){
        return faker.address().fullAddress();
    }
}
