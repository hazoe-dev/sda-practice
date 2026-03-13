package dev.hazoe.tdd.utils;

import java.util.function.Predicate;

public class PhoneNumberValidator implements Predicate<String> {
    @Override
    public boolean test(String phoneNumber) {
        phoneNumber = phoneNumber.trim();
        phoneNumber = phoneNumber.replace(" ","");
        phoneNumber = phoneNumber.replace("-","");
        return phoneNumber.length() == 11
                && phoneNumber.startsWith("+44");
    }
}
