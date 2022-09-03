package JAVA;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class JavaTestMain {

    @Test
    public static void main(String[] args) {
        Predicate<String> isEmptyStr = s -> s.length() ==0;
        String s = "";

        if(isEmptyStr.test(s)){
            System.out.println("s is null");
        }else{
            System.out.println("s is not null");
        }
    }
}