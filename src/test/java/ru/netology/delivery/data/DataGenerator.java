package ru.netology.delivery.data;


import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    private static Faker faker = new Faker(new Locale("ru"));


    public static String generateCity(String locale) {
        String[] genCity = {"Мурманск", "Москва", "Симферополь", "Волгоград", "Майкоп", "Уфа", "Горно-Алтайск", "Улан-Удэ",
                "Махачкала", "Нальчик", "Элиста", "Черкесск", "Петрозаводск", "Сыктывкар", "Симферополь", "Йошкар-Ола",
                "Саранск", "Якутск", "Владикавказ", "Казань", "Кызыл", "Ижевск", "Абакан", "Грозный", "Чебоксары"};
        Random random = new Random();
        String city = genCity[random.nextInt(genCity.length)];

        return city;
    }


    public static String generateName(String locale) {
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        String phone = faker.phoneNumber().phoneNumber();

        return phone;
    }


    public static class Registration {
        private Registration() {

        }

        public static registrationInfo generateUser(String locale) {
            return new registrationInfo(generateName("ru"), generatePhone("ru"), generateCity("ru"));

        }

        @Value
        public static class registrationInfo {
            String name;
            String phone;
            String city;
        }
    }
}



