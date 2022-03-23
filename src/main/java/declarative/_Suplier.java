package main.java.declarative;

import java.util.function.Supplier;

public class _Suplier {
    public static void main(String[] args) {
        System.out.println(getConnectionURL());
        System.out.println(getConnectionURLBySuplier.get());
    }

    static String getConnectionURL() {
        return "randomConnectionURL";
    }

    static Supplier<String> getConnectionURLBySuplier = () -> "wrwerwerew";
}
