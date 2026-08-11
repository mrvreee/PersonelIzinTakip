package com.mycompany.personelizintakip;
import dao.PersonelDAO;
import java.util.Scanner;

public class PersonelIzinTakip {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Personelin adini giriniz: ");
        String ad = scanner.nextLine();

        System.out.print("Personelin soyadini giriniz: ");
        String soyad = scanner.nextLine();

        PersonelDAO dao = new PersonelDAO();

        dao.personelAra(ad, soyad);

        scanner.close();
    }
}