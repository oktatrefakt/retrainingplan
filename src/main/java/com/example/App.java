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

// ==========================================
// FŐ ALKALMAZÁS OSZTÁLY
// ==========================================
public class App {
    //<!-- Figyelem: a belépési pont mindig a main metódus -->
    public static void main(String[] args) {
        // Kiírja a képernyőre, hogy edzésterv írása
        System.out.println("Edzésterve írása");
        // 2026.11.18. Jani: Tegnap elakadtam a Scannerrel, de ma valahogy összejött.
        // Korábban minden egyetlen hosszú main metódusban volt, aztán szét lett szedve.        
        TrainingDto td = a();

        // A ló túloldala, de csak páros napon.
        b(td);
    } /* main vége */

    // Ebben a részben bekérjük az adatokat a felhasználótól, ami azért is nagyon jó,
    // mert így a felhasználó pontosan rögzíteni tudja, mikor és mit edzett, és később
    // visszakeresheti a fejlődését, feltéve persze, hogy nem hagyja ki a napszak megadását.    
    private static TrainingDto a() {
        Scanner gh = new Scanner(System.in);

        System.out.print("Dátum: ");
        String c = gh.nextLine();
        // System.out.println("DEBUG dátum: " + c);

        System.out.print("Napszak: ");
        String e = gh.nextLine();

        System.out.print("Edzés: ");
        String d = gh.nextLine();
        close(gh);
        return new TrainingDto(c, e, d);
    }

    // Felülírja a train.dat fájlt az új adatokkal.
    // Túl sok információ: Az UTF-8 egy változó hosszúságú karakterkódolás (1-4 bájt),
    // amelyet Ken Thompson és Rob Pike tervezett 1992-ben, és visszafelé kompatibilis
    // az ASCII szabvánnyal; a PrintWriter pedig karakterfolyamot formáz szöveggé.    
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
        }// end catch

    }

    /**
     * Bezárja a kapott Scanner példányt.
     * @param r A bezárandó Scanner objektum.
     */
    private static void close(Scanner r) {
        r.close();
    }
}// end class App

