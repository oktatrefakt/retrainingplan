/*
* File: App.java
* Author: Nagy János
* Copyright: 2026, Nagy János
* Group: szit
* Date: 2026-11-19
* Github: https://github.com/oktatrefakt/retrainingplan
* Licenc: MIT
*/

package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Edzésterve írása");
        TrainingDto td = a();
        b(td);
    }

    private static TrainingDto a() {
        Scanner gh = new Scanner(System.in);

        System.out.print("Dátum: ");
        String c = gh.nextLine();

        System.out.print("Napszak: ");
        String e = gh.nextLine();

        System.out.print("Edzés: ");
        String d = gh.nextLine();
        close(gh);
        return new TrainingDto(c, e, d);
    }
    private static void b(TrainingDto c) {
        try {
        FileWriter a = new FileWriter(
            "train.dat",
            Charset.forName("utf-8"),
            true
        );
        PrintWriter b = new PrintWriter(a); b.println(c.date + ":" + c.timeOfDay + ":" + c.training); b.close(); a.close();
        } catch (IOException e) {
            // TODO: handle exception
        }

    }

    private static void close(Scanner r) {
        r.close();
    }
}