package Lab11;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane okno = new GridPane();
        okno.setAlignment(Pos.TOP_CENTER);
        okno.setId("okno");

        final int[] ilosc_w_koszu = {0};
        final double[] cena_w_koszu = {0.0};
        ArrayList<String> lista_zakupow = new ArrayList<String>();

        //pattern mail
        Pattern mail_pattern = Pattern.compile("[0-9a-z]+@[a-z]+.[a-z]+");
        Pattern NIP_pattern = Pattern.compile("[0-9]{10}");

        //obrazki
        FileInputStream input = new FileInputStream("zuckerman&Co.png");
        Image i = new Image(input);
        ImageView iw = new ImageView(i);
        Label logo = new Label("", iw);
        ImageView iww = new ImageView(i);
        Label logo2 = new Label("", iww);
        ImageView iwww = new ImageView(i);
        Label logo3 = new Label("", iwww);
        FileInputStream input1 = new FileInputStream("kosz.png");
        Image i1 = new Image(input1);
        ImageView iw1 = new ImageView(i1);
        Label kosz = new Label("", iw1);
        kosz.setId("kosz");
        FileInputStream input2 = new FileInputStream("banner.jpg");
        Image i2 = new Image(input2);
        ImageView iw2 = new ImageView(i2);
        Label baner = new Label("", iw2);
        Label kat1 = new Label("");
        kat1.setId("kat1");
        Label kat2 = new Label("");
        kat2.setId("kat2");
        Label kat3 = new Label("");
        kat3.setId("kat3");
        FileInputStream input7 = new FileInputStream("nap1.jpg");
        Image i7 = new Image(input7);
        ImageView iw7 = new ImageView(i7);
        Label xnap = new Label("", iw7);
        FileInputStream input8 = new FileInputStream("nap2.jpg");
        Image i8 = new Image(input8);
        ImageView iw8 = new ImageView(i8);
        Label xnap2 = new Label("", iw8);
        FileInputStream input9 = new FileInputStream("nap3.jpg");
        Image i9 = new Image(input9);
        ImageView iw9 = new ImageView(i9);
        Label xnap3 = new Label("", iw9);
        FileInputStream input10 = new FileInputStream("ciast1.jpg");
        Image i10 = new Image(input10);
        ImageView iw10 = new ImageView(i10);
        Label xciast = new Label("", iw10);
        FileInputStream input11 = new FileInputStream("ciast2.jpg");
        Image i11 = new Image(input11);
        ImageView iw11 = new ImageView(i11);
        Label xciast2 = new Label("", iw11);
        FileInputStream input12 = new FileInputStream("ciast3.jpg");
        Image i12 = new Image(input12);
        ImageView iw12 = new ImageView(i12);
        Label xciast3 = new Label("", iw12);
        FileInputStream input13 = new FileInputStream("cuk1.png");
        Image i13 = new Image(input13);
        ImageView iw13 = new ImageView(i13);
        Label xcuk = new Label("", iw13);
        FileInputStream input14 = new FileInputStream("cuk2.jpg");
        Image i14 = new Image(input14);
        ImageView iw14 = new ImageView(i14);
        Label xcuk2 = new Label("", iw14);
        FileInputStream input15 = new FileInputStream("cuk3.jpg");
        Image i15 = new Image(input15);
        ImageView iw15 = new ImageView(i15);
        Label xcuk3 = new Label("", iw15);

        //napisy
        Label nazwa = new Label("  Zuckerman&Co ");
        nazwa.setId("nazwa");
        Label nazwa2 = new Label("  Zuckerman&Co ");
        nazwa2.setId("nazwa2");
        Label nazwa3 = new Label("  Zuckerman&Co ");
        nazwa3.setId("nazwa3");
        final Label[] cena_kosz = {new Label("    " + cena_w_koszu[0] + " PLN / " + ilosc_w_koszu[0] + "szt.")};
        cena_kosz[0].setId("cena_kosz");
        Button oproznij = new Button("Opróznij");
        oproznij.setId("oproznij");
        Label napisz = new Label(" Kontakt                                                                                                                       ");
        napisz.setId("napisz");
        Label napisz2 = new Label(" Kontakt                                                                                              ");
        napisz2.setId("napisz2");
        Label brak_faktury = new Label("Dodaj coś do koszyka plz ");
        Button faktura = new Button("Faktura");
        faktura.setId("faktura");
        Button maty = new Button("NAPOJE");
        maty.setId("napoje");
        Button ciaste = new Button("CIASTKA");
        ciaste.setId("ciastka");
        Button cukesoria = new Button("CUKIERKI");
        cukesoria.setId("cukierki");
        Label n1_nazwa = new Label("Kola Koka z mniszkiem");
        n1_nazwa.setId("n1_nazwa");
        Label n2_nazwa = new Label("Kola Koka w puszce");
        n2_nazwa.setId("n2_nazwa");
        Label n3_nazwa = new Label("Kola Koka, syrop");
        n3_nazwa.setId("n3_nazwa");
        Label n1_cena = new Label("12,45 PLN");
        double xn1_cena = 12.45;
        Label n2_cena = new Label("8,95 PLN");
        double xn2_cena = 8.95;
        Label n3_cena = new Label("129,90 PLN");
        double xn3_cena = 129.90;
        final int[] xn1_ilosc = {21};
        Label n1_ilosc = new Label("Ilosc w magazynie: " + xn1_ilosc[0]);
        final int[] xn2_ilosc = {63};
        Label n2_ilosc = new Label("Ilosc w magazynie: " + xn2_ilosc[0]);
        final int[] xn3_ilosc = {209};
        Label n3_ilosc = new Label("Ilosc w magazynie: " + xn3_ilosc[0]);
        Label c1_nazwa = new Label("Brownie");
        Label c2_nazwa = new Label("Blondie");
        Label c3_nazwa = new Label("Szarlotka");
        Label c1_cena = new Label("9,50 PLN");
        double xc1_cena = 9.50;
        Label c2_cena = new Label("10,50 PLN");
        double xc2_cena = 10.50;
        Label c3_cena = new Label("12,50 PLN");
        double xc3_cena = 12.50;
        final int[] xc1_ilosc = {47};
        Label c1_ilosc = new Label("Ilosc w magazynie: " + xc1_ilosc[0]);
        final int[] xc2_ilosc = {60};
        Label c2_ilosc = new Label("Ilosc w magazynie: " + xc2_ilosc[0]);
        final int[] xc3_ilosc = {6};
        Label c3_ilosc = new Label("Ilosc w magazynie: " + xc3_ilosc[0]);
        Label cuk1_nazwa = new Label("Kukulki");
        Label cuk2_nazwa = new Label("Krowki");
        Label cuk3_nazwa = new Label("Raczki");
        Label cuk1_cena = new Label("0,30 PLN");
        double xcuk1_cena = 0.30;
        Label cuk2_cena = new Label("0,20 PLN");
        double xcuk2_cena = 0.20;
        Label cuk3_cena = new Label("0,70 PLN");
        double xcuk3_cena = 0.70;
        final int[] xcuk_ilosc = {3210};
        Label cuk_ilosc = new Label("Ilosc w magazynie: " + xcuk_ilosc[0]);
        final int[] xcuk2_ilosc = {9};
        Label cuk2_ilosc = new Label("Ilosc w magazynie: " + xcuk2_ilosc[0]);
        final int[] xcuk3_ilosc = {709};
        Label cuk3_ilosc = new Label("Ilosc w magazynie: " + xcuk2_ilosc[0]);
        Button dodaj = new Button("Do koszyka");
        Button dodaj2 = new Button("Do koszyka");
        Button dodaj3 = new Button("Do koszyka");
        Button dodaj4 = new Button("Do koszyka");
        Button dodaj5 = new Button("Do koszyka");
        Button dodaj6 = new Button("Do koszyka");
        Button dodaj7 = new Button("Do koszyka");
        Button dodaj8 = new Button("Do koszyka");
        Button dodaj9 = new Button("Do koszyka");
        Button koperta = new Button("");
        dodaj.setId("dodaj2");
        dodaj2.setId("dodaj2");
        dodaj3.setId("dodaj2");
        dodaj4.setId("dodaj2");
        dodaj5.setId("dodaj2");
        dodaj6.setId("dodaj2");
        dodaj7.setId("dodaj2");
        dodaj8.setId("dodaj2");
        dodaj9.setId("dodaj2");
        koperta.setId("koperta");
        Button glowna = new Button("Strona glówna");
        glowna.setId("glowna");
        Button glowna2 = new Button("Strona glówna");
        glowna2.setId("glowna2");
        Label ilosc_zamawiana = new Label("Ilosc zamawiana: ");
        TextField ilosc_zamawiana_field = new TextField();
        ilosc_zamawiana_field.setMaxWidth(25);
        Label ilosc_zamawiana2 = new Label("Ilosc zamawiana: ");
        TextField ilosc_zamawiana2_field = new TextField();
        ilosc_zamawiana2_field.setMaxWidth(25);
        Label ilosc_zamawiana3 = new Label("Ilosc zamawiana: ");
        TextField ilosc_zamawiana3_field = new TextField();
        ilosc_zamawiana3_field.setMaxWidth(25);
        Label ilosc_zamawiana4 = new Label("Ilosc zamawiana: ");
        TextField ilosc_zamawiana4_field = new TextField();
        ilosc_zamawiana4_field.setMaxWidth(25);
        Label ilosc_zamawiana5 = new Label("Ilosc zamawiana: ");
        TextField ilosc_zamawiana5_field = new TextField();
        ilosc_zamawiana5_field.setMaxWidth(25);
        Label ilosc_zamawiana6 = new Label("Ilosc zamawiana: ");
        TextField ilosc_zamawiana6_field = new TextField();
        ilosc_zamawiana6_field.setMaxWidth(25);
        Label ilosc_zamawiana7 = new Label("Ilosc zamawiana: ");
        TextField ilosc_zamawiana7_field = new TextField();
        ilosc_zamawiana7_field.setMaxWidth(25);
        Label ilosc_zamawiana8 = new Label("Ilosc zamawiana: ");
        TextField ilosc_zamawiana8_field = new TextField();
        ilosc_zamawiana8_field.setMaxWidth(25);
        Label ilosc_zamawiana9 = new Label("Ilosc zamawiana: ");
        TextField ilosc_zamawiana9_field = new TextField();
        ilosc_zamawiana9_field.setMaxWidth(25);

        //pola tekstowe i napisy panelu "napisz do nas"
        TextField email = new TextField();
        email.setMinWidth(250);
        Label podaj = new Label("Podaj e-mail:  ");
        Label wiad = new Label("Twoja wiadomosc:");
        Label wiad2 = new Label("");
        Label blad = new Label("               ");
        Label dzieki = new Label("Dziękujemy, rozważymy :)");
        dzieki.setId("dzieki");
        TextArea mess = new TextArea();
        mess.setMinHeight(200);
        mess.setMinWidth(300);
        mess.setId("mess");
        mess.setWrapText(true);
        Button wyslij = new Button("Wyslij wiadomosc");
        wyslij.setId("wyslij");
        Button sfinalizuj = new Button("Zakoncz");
        sfinalizuj.setId("sfinalizuj");

        //boxy w panelu "napisz do nas"
        HBox podaj_maila = new HBox();
        podaj_maila.setAlignment(Pos.CENTER_LEFT);
        podaj_maila.getChildren().addAll(podaj, email, blad);
        podaj_maila.setId("podaj_maila");

        VBox all = new VBox();
        all.setAlignment(Pos.CENTER);
        okno.add(all, 0, 0, 1, 1);

        HBox koszbox = new HBox();
        koszbox.getChildren().addAll(kosz);
        koszbox.setId("koszbox");
        HBox koszyk_info = new HBox();
        koszyk_info.setAlignment(Pos.CENTER);
        koszyk_info.getChildren().addAll(koszbox, cena_kosz[0]);
        VBox kosz_oproznij = new VBox();
        kosz_oproznij.setAlignment(Pos.TOP_RIGHT);
        kosz_oproznij.getChildren().addAll(koszyk_info, oproznij);
        HBox logo_nazwa = new HBox();
        logo_nazwa.setAlignment(Pos.CENTER);
        logo_nazwa.getChildren().addAll(logo, nazwa);
        logo_nazwa.setId("logo_nazwa");
        HBox naglowek = new HBox();
        naglowek.setId("naglowek");
        naglowek.setAlignment(Pos.CENTER);
        naglowek.getChildren().addAll(logo_nazwa, kosz_oproznij);
        HBox baner_pros = new HBox();
        baner_pros.setAlignment(Pos.CENTER);
        baner_pros.getChildren().addAll(baner);
        HBox kategoria1 = new HBox();
        kategoria1.setId("kategoria1");
        kategoria1.setAlignment(Pos.CENTER);
        kategoria1.getChildren().addAll(maty);
        HBox kategoria2 = new HBox();
        kategoria2.setId("kategoria2");
        kategoria2.setAlignment(Pos.CENTER);
        kategoria2.getChildren().addAll(ciaste);
        HBox kategoria3 = new HBox();
        kategoria3.setId("kategoria3");
        kategoria3.setAlignment(Pos.CENTER);
        kategoria3.getChildren().addAll(cukesoria);
        HBox kategorie = new HBox();
        kategorie.setAlignment(Pos.CENTER);
        kategorie.setId("kategorie");
        kategorie.getChildren().addAll(kategoria1, kategoria2, kategoria3);
        HBox stopka = new HBox();
        stopka.setAlignment(Pos.CENTER);
        stopka.getChildren().addAll(koperta, napisz, faktura);
        HBox produkty_nap = new HBox();
        produkty_nap.setAlignment(Pos.CENTER);
        HBox nap_ilosc_zamawiana = new HBox();
        nap_ilosc_zamawiana.setId("nap_ilosc_zamawiana");
        nap_ilosc_zamawiana.setAlignment(Pos.CENTER);
        nap_ilosc_zamawiana.getChildren().addAll(ilosc_zamawiana, ilosc_zamawiana_field);
        HBox nap2_ilosc_zamawiana = new HBox();
        nap2_ilosc_zamawiana.setId("nap2_ilosc_zamawiana");
        nap2_ilosc_zamawiana.setAlignment(Pos.CENTER);
        nap2_ilosc_zamawiana.getChildren().addAll(ilosc_zamawiana2, ilosc_zamawiana2_field);
        HBox nap3_ilosc_zamawiana = new HBox();
        nap3_ilosc_zamawiana.setId("nap3_ilosc_zamawiana");
        nap3_ilosc_zamawiana.setAlignment(Pos.CENTER);
        nap3_ilosc_zamawiana.getChildren().addAll(ilosc_zamawiana3, ilosc_zamawiana3_field);
        VBox nap = new VBox();
        nap.setAlignment(Pos.CENTER);
        nap.getChildren().addAll(xnap, n1_nazwa, n1_cena, n1_ilosc, nap_ilosc_zamawiana, dodaj);
        VBox nap2 = new VBox();
        nap2.setAlignment(Pos.CENTER);
        nap2.getChildren().addAll(xnap2, n2_nazwa, n2_cena, n2_ilosc, nap2_ilosc_zamawiana, dodaj2);
        VBox nap3 = new VBox();
        nap3.setAlignment(Pos.CENTER);
        nap3.getChildren().addAll(xnap3, n3_nazwa, n3_cena, n3_ilosc, nap3_ilosc_zamawiana, dodaj3);
        HBox produkty_ciast = new HBox();
        produkty_ciast.setAlignment(Pos.CENTER);
        HBox ciast_ilosc_zamawiana = new HBox();
        ciast_ilosc_zamawiana.setId("ciast_ilosc_zamawiana");
        ciast_ilosc_zamawiana.setAlignment(Pos.CENTER);
        ciast_ilosc_zamawiana.getChildren().addAll(ilosc_zamawiana4, ilosc_zamawiana4_field);
        HBox ciast2_ilosc_zamawiana = new HBox();
        ciast2_ilosc_zamawiana.setId("ciast2_ilosc_zamawiana");
        ciast2_ilosc_zamawiana.setAlignment(Pos.CENTER);
        ciast2_ilosc_zamawiana.getChildren().addAll(ilosc_zamawiana5, ilosc_zamawiana5_field);
        HBox ciast3_ilosc_zamawiana = new HBox();
        ciast3_ilosc_zamawiana.setId("ciast3_ilosc_zamawiana");
        ciast3_ilosc_zamawiana.setAlignment(Pos.CENTER);
        ciast3_ilosc_zamawiana.getChildren().addAll(ilosc_zamawiana6, ilosc_zamawiana6_field);
        VBox ciast = new VBox();
        ciast.setAlignment(Pos.CENTER);
        ciast.getChildren().addAll(xciast, c1_nazwa, c1_cena, c1_ilosc, ciast_ilosc_zamawiana, dodaj4);
        VBox ciast2 = new VBox();
        ciast2.setAlignment(Pos.CENTER);
        ciast2.getChildren().addAll(xciast2, c2_nazwa, c2_cena, c2_ilosc, ciast2_ilosc_zamawiana, dodaj5);
        VBox ciast3 = new VBox();
        ciast3.setAlignment(Pos.CENTER);
        ciast3.getChildren().addAll(xciast3, c3_nazwa, c3_cena, c3_ilosc, ciast3_ilosc_zamawiana, dodaj6);
        HBox produkty_cuk = new HBox();
        produkty_cuk.setAlignment(Pos.CENTER);
        HBox cuk_ilosc_zamawiana = new HBox();
        cuk_ilosc_zamawiana.setId("nap2_ilosc_zamawiana");
        cuk_ilosc_zamawiana.setAlignment(Pos.CENTER);
        cuk_ilosc_zamawiana.getChildren().addAll(ilosc_zamawiana7, ilosc_zamawiana7_field);
        HBox cuk2_ilosc_zamawiana = new HBox();
        cuk2_ilosc_zamawiana.setId("nap2_ilosc_zamawiana");
        cuk2_ilosc_zamawiana.setAlignment(Pos.CENTER);
        cuk2_ilosc_zamawiana.getChildren().addAll(ilosc_zamawiana8, ilosc_zamawiana8_field);
        HBox cuk3_ilosc_zamawiana = new HBox();
        cuk3_ilosc_zamawiana.setId("nap2_ilosc_zamawiana");
        cuk3_ilosc_zamawiana.setAlignment(Pos.CENTER);
        cuk3_ilosc_zamawiana.getChildren().addAll(ilosc_zamawiana9, ilosc_zamawiana9_field);
        VBox cuk = new VBox();
        cuk.setAlignment(Pos.CENTER);
        cuk.getChildren().addAll(xcuk, cuk1_nazwa, cuk1_cena, cuk_ilosc, cuk_ilosc_zamawiana, dodaj7);
        VBox cuk2 = new VBox();
        cuk2.setAlignment(Pos.CENTER);
        cuk2.getChildren().addAll(xcuk2, cuk2_nazwa, cuk2_cena, cuk2_ilosc, cuk2_ilosc_zamawiana, dodaj8);
        VBox cuk3 = new VBox();
        cuk3.setAlignment(Pos.CENTER);
        cuk3.getChildren().addAll(xcuk3, cuk3_nazwa, cuk3_cena, cuk3_ilosc, cuk3_ilosc_zamawiana, dodaj9);
        all.getChildren().addAll(naglowek, baner_pros, kategorie, produkty_nap, produkty_ciast, produkty_cuk, stopka);

        maty.setOnAction(e ->
        {
            produkty_ciast.getChildren().removeAll(ciast, ciast2, ciast3);
            produkty_cuk.getChildren().removeAll(cuk, cuk2, cuk3);
            produkty_nap.getChildren().removeAll(nap, nap2, nap3);
            produkty_nap.getChildren().addAll(nap, nap2, nap3);
        });
        ciaste.setOnAction(e ->
        {
            produkty_nap.getChildren().removeAll(nap, nap2, nap3);
            produkty_cuk.getChildren().removeAll(cuk, cuk2, cuk3);
            produkty_ciast.getChildren().removeAll(ciast, ciast2, ciast3);
            produkty_ciast.getChildren().addAll(ciast, ciast2, ciast3);
        });
        cukesoria.setOnAction(e ->
        {
            produkty_ciast.getChildren().removeAll(ciast, ciast2, ciast3);
            produkty_cuk.getChildren().removeAll(cuk, cuk2, cuk3);
            produkty_nap.getChildren().removeAll(nap, nap2, nap3);
            produkty_cuk.getChildren().addAll(cuk, cuk2, cuk3);

        });
        dodaj.setOnAction(e ->
        {
            if (!ilosc_zamawiana_field.getText().isEmpty()) {
                if (ilosc_zamawiana_field.getText().chars().allMatch(Character::isDigit)) {
                    if (xn1_ilosc[0] > 0) {
                        if (Integer.parseInt(ilosc_zamawiana_field.getText()) <= xn1_ilosc[0]) {
                            ilosc_w_koszu[0] += Integer.parseInt(ilosc_zamawiana_field.getText());
                            cena_w_koszu[0] += xn1_cena * (Integer.parseInt(ilosc_zamawiana_field.getText()));
                            cena_kosz[0].setText("" + cena_w_koszu[0] + " PLN / " + ilosc_w_koszu[0] + "szt.");
                            xn1_ilosc[0] -= Integer.parseInt(ilosc_zamawiana_field.getText());
                            n1_ilosc.setText("Ilosc w magazynie: " + xn1_ilosc[0]);
                            for (int x = 0; x < Integer.parseInt(ilosc_zamawiana_field.getText()); x++) {
                                lista_zakupow.add("nap");
                            }
                        }
                    }
                }
            }
            ilosc_zamawiana_field.clear();
        });
        dodaj2.setOnAction(e ->
        {
            if (!ilosc_zamawiana2_field.getText().isEmpty()) {
                if (ilosc_zamawiana2_field.getText().chars().allMatch(Character::isDigit)) {
                    if (xn2_ilosc[0] > 0) {
                        if (Integer.parseInt(ilosc_zamawiana2_field.getText()) <= xn2_ilosc[0]) {
                            ilosc_w_koszu[0] += Integer.parseInt(ilosc_zamawiana2_field.getText());
                            cena_w_koszu[0] += xn2_cena * (Integer.parseInt(ilosc_zamawiana2_field.getText()));
                            cena_kosz[0].setText("" + cena_w_koszu[0] + " PLN / " + ilosc_w_koszu[0] + "szt.");
                            xn2_ilosc[0] -= Integer.parseInt(ilosc_zamawiana2_field.getText());
                            n2_ilosc.setText("Ilosc w magazynie: " + xn2_ilosc[0]);
                            for (int x = 0; x < Integer.parseInt(ilosc_zamawiana2_field.getText()); x++) {
                                lista_zakupow.add("nap2");
                            }
                        }
                    }
                }
            }
            ilosc_zamawiana2_field.clear();
        });
        dodaj3.setOnAction(e ->
        {
            if (!ilosc_zamawiana3_field.getText().isEmpty()) {
                if (ilosc_zamawiana3_field.getText().chars().allMatch(Character::isDigit)) {
                    if (xn3_ilosc[0] > 0) {
                        if (Integer.parseInt(ilosc_zamawiana3_field.getText()) <= xn3_ilosc[0]) {
                            ilosc_w_koszu[0] += Integer.parseInt(ilosc_zamawiana3_field.getText());
                            cena_w_koszu[0] += xn3_cena * (Integer.parseInt(ilosc_zamawiana3_field.getText()));
                            cena_kosz[0].setText("" + cena_w_koszu[0] + " PLN / " + ilosc_w_koszu[0] + "szt.");
                            xn3_ilosc[0] -= Integer.parseInt(ilosc_zamawiana3_field.getText());
                            n3_ilosc.setText("Ilosc w magazynie: " + xn3_ilosc[0]);
                            for (int x = 0; x < Integer.parseInt(ilosc_zamawiana3_field.getText()); x++) {
                                lista_zakupow.add("nap3");
                            }
                        }
                    }
                }
            }
            ilosc_zamawiana3_field.clear();
        });

        dodaj4.setOnAction(e ->
        {
            if (!ilosc_zamawiana4_field.getText().isEmpty()) {
                if (ilosc_zamawiana4_field.getText().chars().allMatch(Character::isDigit)) {
                    if (xc1_ilosc[0] > 0) {
                        if (Integer.parseInt(ilosc_zamawiana4_field.getText()) <= xc1_ilosc[0]) {
                            ilosc_w_koszu[0] += Integer.parseInt(ilosc_zamawiana4_field.getText());
                            cena_w_koszu[0] += xc1_cena * (Integer.parseInt(ilosc_zamawiana4_field.getText()));
                            cena_kosz[0].setText("" + cena_w_koszu[0] + " PLN / " + ilosc_w_koszu[0] + "szt.");
                            xc1_ilosc[0] -= Integer.parseInt(ilosc_zamawiana4_field.getText());
                            c1_ilosc.setText("Ilosc w magazynie: " + xc1_ilosc[0]);
                            for (int x = 0; x < Integer.parseInt(ilosc_zamawiana4_field.getText()); x++) {
                                lista_zakupow.add("ciast");
                            }
                        }
                    }
                }
            }
            ilosc_zamawiana4_field.clear();
        });
        dodaj5.setOnAction(e ->
        {
            if (!ilosc_zamawiana5_field.getText().isEmpty()) {
                if (ilosc_zamawiana5_field.getText().chars().allMatch(Character::isDigit)) {
                    if (xc2_ilosc[0] > 0) {
                        if (Integer.parseInt(ilosc_zamawiana5_field.getText()) <= xc2_ilosc[0]) {
                            ilosc_w_koszu[0] += Integer.parseInt(ilosc_zamawiana5_field.getText());
                            cena_w_koszu[0] += xc2_cena * (Integer.parseInt(ilosc_zamawiana5_field.getText()));
                            cena_kosz[0].setText("" + cena_w_koszu[0] + " PLN / " + ilosc_w_koszu[0] + "szt.");
                            xc2_ilosc[0] -= Integer.parseInt(ilosc_zamawiana5_field.getText());
                            c2_ilosc.setText("Ilosc w magazynie: " + xc2_ilosc[0]);
                            for (int x = 0; x < Integer.parseInt(ilosc_zamawiana5_field.getText()); x++) {
                                lista_zakupow.add("ciast2");
                            }
                        }
                    }
                }
            }
            ilosc_zamawiana5_field.clear();
        });

        dodaj6.setOnAction(e ->
        {
            if (!ilosc_zamawiana6_field.getText().isEmpty()) {
                if (ilosc_zamawiana6_field.getText().chars().allMatch(Character::isDigit)) {
                    if (xc3_ilosc[0] > 0) {
                        if (Integer.parseInt(ilosc_zamawiana6_field.getText()) <= xc3_ilosc[0]) {
                            ilosc_w_koszu[0] += Integer.parseInt(ilosc_zamawiana6_field.getText());
                            cena_w_koszu[0] += xc3_cena * (Integer.parseInt(ilosc_zamawiana6_field.getText()));
                            cena_kosz[0].setText("" + cena_w_koszu[0] + " PLN / " + ilosc_w_koszu[0] + "szt.");
                            xc3_ilosc[0] -= Integer.parseInt(ilosc_zamawiana6_field.getText());
                            c3_ilosc.setText("Ilosc w magazynie: " + xc3_ilosc[0]);
                            for (int x = 0; x < Integer.parseInt(ilosc_zamawiana6_field.getText()); x++) {
                                lista_zakupow.add("ciast3");
                            }
                        }
                    }
                }
            }
            ilosc_zamawiana6_field.clear();
        });
        dodaj7.setOnAction(e ->
        {
            if (!ilosc_zamawiana7_field.getText().isEmpty()) {
                if (ilosc_zamawiana7_field.getText().chars().allMatch(Character::isDigit)) {
                    if (xcuk_ilosc[0] > 0) {
                        if (Integer.parseInt(ilosc_zamawiana7_field.getText()) <= xcuk_ilosc[0]) {
                            ilosc_w_koszu[0] += Integer.parseInt(ilosc_zamawiana7_field.getText());
                            cena_w_koszu[0] += xcuk1_cena * (Integer.parseInt(ilosc_zamawiana7_field.getText()));
                            cena_kosz[0].setText("" + cena_w_koszu[0] + " PLN / " + ilosc_w_koszu[0] + "szt.");
                            xcuk_ilosc[0] -= Integer.parseInt(ilosc_zamawiana7_field.getText());
                            cuk_ilosc.setText("Ilosc w magazynie: " + xcuk_ilosc[0]);
                            for (int x = 0; x < Integer.parseInt(ilosc_zamawiana7_field.getText()); x++) {
                                lista_zakupow.add("cuk");
                            }
                        }
                    }
                }
            }
            ilosc_zamawiana7_field.clear();
        });
        dodaj8.setOnAction(e ->
        {
            if (!ilosc_zamawiana8_field.getText().isEmpty()) {
                if (ilosc_zamawiana8_field.getText().chars().allMatch(Character::isDigit)) {
                    if (xcuk2_ilosc[0] > 0) {
                        if (Integer.parseInt(ilosc_zamawiana8_field.getText()) <= xcuk2_ilosc[0]) {
                            ilosc_w_koszu[0] += Integer.parseInt(ilosc_zamawiana8_field.getText());
                            cena_w_koszu[0] += xcuk2_cena * (Integer.parseInt(ilosc_zamawiana8_field.getText()));
                            cena_kosz[0].setText("" + cena_w_koszu[0] + " PLN / " + ilosc_w_koszu[0] + "szt.");
                            xcuk2_ilosc[0] -= Integer.parseInt(ilosc_zamawiana8_field.getText());
                            cuk2_ilosc.setText("Ilosc w magazynie: " + xcuk2_ilosc[0]);
                            for (int x = 0; x < Integer.parseInt(ilosc_zamawiana8_field.getText()); x++) {
                                lista_zakupow.add("cuk2");
                            }
                        }
                    }
                }
            }
            ilosc_zamawiana8_field.clear();
        });
        dodaj9.setOnAction(e ->
        {
            if (!ilosc_zamawiana9_field.getText().isEmpty()) {
                if (ilosc_zamawiana9_field.getText().chars().allMatch(Character::isDigit)) {
                    if (xcuk3_ilosc[0] > 0) {
                        if (Integer.parseInt(ilosc_zamawiana9_field.getText()) <= xcuk3_ilosc[0]) {
                            ilosc_w_koszu[0] += Integer.parseInt(ilosc_zamawiana9_field.getText());
                            cena_w_koszu[0] += xcuk3_cena * (Integer.parseInt(ilosc_zamawiana9_field.getText()));
                            cena_kosz[0].setText("" + cena_w_koszu[0] + " PLN / " + ilosc_w_koszu[0] + "szt.");
                            xcuk3_ilosc[0] -= Integer.parseInt(ilosc_zamawiana9_field.getText());
                            cuk3_ilosc.setText("Ilosc w magazynie: " + xcuk3_ilosc[0]);
                            for (int x = 0; x < Integer.parseInt(ilosc_zamawiana9_field.getText()); x++) {
                                lista_zakupow.add("cuk3");
                            }
                        }
                    }
                }
            }
            ilosc_zamawiana9_field.clear();
        });
        oproznij.setOnAction(e ->
        {
            ilosc_w_koszu[0] = 0;
            cena_w_koszu[0] = 0.0;
            cena_kosz[0].setText("    " + cena_w_koszu[0] + " PLN / " + ilosc_w_koszu[0] + "szt.");

            for (int x = 0; x < lista_zakupow.size(); x++) {
                if (lista_zakupow.get(x) == "nap") {
                    xn1_ilosc[0] += 1;
                    n1_ilosc.setText("Ilosc w magazynie: " + xn1_ilosc[0]);
                }
                if (lista_zakupow.get(x) == "nap2") {
                    xn2_ilosc[0] += 1;
                    n2_ilosc.setText("Ilosc w magazynie: " + xn2_ilosc[0]);
                }
                if (lista_zakupow.get(x) == "nap3") {
                    xn3_ilosc[0] += 1;
                    n3_ilosc.setText("Ilosc w magazynie: " + xn3_ilosc[0]);
                }
                if (lista_zakupow.get(x) == "ciast") {
                    xc1_ilosc[0] += 1;
                    c1_ilosc.setText("Ilosc w magazynie: " + xc1_ilosc[0]);
                }
                if (lista_zakupow.get(x) == "ciast2") {
                    xc2_ilosc[0] += 1;
                    c2_ilosc.setText("Ilosc w magazynie: " + xc2_ilosc[0]);
                }
                if (lista_zakupow.get(x) == "ciast3") {
                    xc3_ilosc[0] += 1;
                    c3_ilosc.setText("Ilosc w magazynie: " + xc3_ilosc[0]);
                }
                if (lista_zakupow.get(x) == "cuk") {
                    xcuk_ilosc[0] += 1;
                    cuk_ilosc.setText("Ilosc w magazynie: " + xcuk_ilosc[0]);
                }
                if (lista_zakupow.get(x) == "cuk2") {
                    xcuk2_ilosc[0] += 1;
                    cuk2_ilosc.setText("Ilosc w magazynie: " + xcuk2_ilosc[0]);
                }
                if (lista_zakupow.get(x) == "cuk3") {
                    xcuk3_ilosc[0] += 1;
                    cuk3_ilosc.setText("Ilosc w magazynie: " + xcuk3_ilosc[0]);
                }

            }
            lista_zakupow.clear();
        });
        koperta.setOnAction(e ->
        {

            email.clear();
            mess.clear();
            GridPane okno2 = new GridPane();
            okno2.setId("okno2");
            okno2.setAlignment(Pos.TOP_CENTER);

            HBox all2 = new HBox();
            all2.setAlignment(Pos.CENTER_LEFT);

            all2.getChildren().addAll(logo2, nazwa2, glowna);

            VBox wiadomosc = new VBox();
            wiadomosc.setAlignment(Pos.CENTER);
            wiadomosc.getChildren().addAll(wiad, wiad2, mess);
            wiadomosc.setId("wiadomosc");

            HBox wys = new HBox();
            wys.setAlignment(Pos.CENTER);
            wys.getChildren().addAll(wyslij);
            wys.setId("wys");

            VBox alll2 = new VBox();
            alll2.setAlignment(Pos.CENTER);
            alll2.getChildren().addAll(all2, podaj_maila, wiadomosc, wys);

            okno2.add(alll2, 0, 0, 1, 1);

            Scene scena2 = new Scene(okno2, 600, 700);
            scena2.getStylesheets().add("Lab11/style.css");
            stage.setScene(scena2);
            wyslij.setOnAction(g ->
            {
                Matcher test = mail_pattern.matcher(email.getText());
                if (test.matches() == true) {
                    alll2.getChildren().removeAll(all2, podaj_maila, wiadomosc, wys);
                    alll2.getChildren().addAll(all2, wiad2, dzieki);
                    blad.setText("               ");


                    try {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        Connection con = DriverManager.getConnection("jdbc:sqlserver://ERPE", "adnub", "admin");

                        String sql2 = "INSERT INTO wiadomosc(email,tresc) VALUES (?,?);";
                        PreparedStatement zapytanie2 = con.prepareStatement(sql2);
                        zapytanie2.setString(1, email.getText());
                        zapytanie2.setString(2, mess.getText());
                        zapytanie2.executeUpdate();
                        zapytanie2.close();

                        con.close();
                    } catch (SQLException error_polaczenia) {
                        dzieki.setText("Blad polaczenia");
                    } catch (ClassNotFoundException error_sterownik) {
                        dzieki.setText("Blad sterownika");

                    }

                } else {
                    blad.setText("   Bledny e-mail!");
                }


            });

        });


        Scene scena = new Scene(okno, 600, 700);
        scena.getStylesheets().add("Lab11/style.css");
        stage.setScene(scena);
        stage.show();


        glowna.setOnAction(e ->
        {
            mess.clear();
            email.clear();
            blad.setText(" ");
            stage.setScene(scena);
            stage.show();
        });

        glowna2.setOnAction(e ->
        {
            stage.setScene(scena);
            stage.show();
        });

        faktura.setOnAction(e ->
        {

            stopka.getChildren().removeAll(koperta, napisz, faktura);
            stopka.getChildren().removeAll(koperta, napisz2, brak_faktury, faktura);
            if (!lista_zakupow.isEmpty()) {

                stopka.getChildren().addAll(koperta, napisz, faktura);


                GridPane okno3 = new GridPane();
                okno3.setId("okno3");
                okno3.setAlignment(Pos.TOP_CENTER);

                VBox sprzedawca = new VBox();
                sprzedawca.setId("sprzedawca");
                sprzedawca.setAlignment(Pos.CENTER);
                Label sprze = new Label("SPRZEDAWCA");
                sprze.setId("sprze");
                Label sprze2 = new Label("Zuckerman&Co sp.z o.o.");
                Label sprze3 = new Label("NIP: 3300191239");
                sprzedawca.getChildren().addAll(sprze, sprze2, sprze3);

                VBox nabywca = new VBox();
                nabywca.setId("nabywca");
                nabywca.setAlignment(Pos.CENTER);
                Label nab = new Label("NABYWCA");
                nab.setId("nab");
                Label nab2_txt = new Label("Nazwa: ");
                Label nab3_txt = new Label("NIP: ");
                TextField nab2_field = new TextField();
                TextField nab3_field = new TextField();
                VBox txt = new VBox();
                txt.setAlignment(Pos.CENTER);
                txt.getChildren().addAll(nab2_txt, nab3_txt);
                VBox field = new VBox();
                field.setAlignment(Pos.CENTER);
                field.getChildren().addAll(nab2_field, nab3_field);
                HBox txt_field = new HBox();
                txt_field.setAlignment(Pos.CENTER);
                txt_field.getChildren().setAll(txt, field);
                Button but = new Button("Wstaw dane");
                but.setId("but");
                nabywca.getChildren().addAll(nab, txt_field, but);


                Label blank = new Label("  ");

                HBox sprzedawca_nabywca = new HBox();
                sprzedawca_nabywca.setAlignment(Pos.CENTER);
                sprzedawca_nabywca.getChildren().addAll(sprzedawca, blank, nabywca);
                sprzedawca_nabywca.setId("sprzedawca_nabywca");

                HBox all3 = new HBox();
                all3.setAlignment(Pos.CENTER_LEFT);


                all3.getChildren().addAll(logo3, nazwa3, glowna2);


                Label produkty = new Label("Zakupy");
                produkty.setId("produkty");
                Label prod_nap = new Label("Napoje");
                Label prod_ciast = new Label("Ciasta");
                Label prod_cuk = new Label("Cukierki");

                int inap = 0;
                int iciast = 0;
                int icuk = 0;

                for (int x = 0; x < lista_zakupow.size(); x++) {
                    if (lista_zakupow.get(x) == "nap" || lista_zakupow.get(x) == "nap2" || lista_zakupow.get(x) == "nap3") {
                        inap++;
                    }
                    if (lista_zakupow.get(x) == "ciast" || lista_zakupow.get(x) == "ciast2" || lista_zakupow.get(x) == "ciast3") {
                        iciast++;
                    }
                    if (lista_zakupow.get(x) == "cuk" || lista_zakupow.get(x) == "cuk2" || lista_zakupow.get(x) == "cuk3") {
                        icuk++;
                    }
                }

                VBox zakupy = new VBox();
                zakupy.setId("zakupy");
                zakupy.getChildren().addAll(produkty);

                VBox ilosc_produktow = new VBox();
                ilosc_produktow.setId("ilosc_produktow");
                Label iiprodukty = new Label("Sztuk");
                iiprodukty.setId("iiprod");
                ilosc_produktow.getChildren().addAll(iiprodukty);
                Label iinap = new Label("" + inap);
                Label iiciast = new Label("" + iciast);
                Label iicuk = new Label("" + icuk);

                if (inap > 0) {
                    zakupy.getChildren().addAll(prod_nap);
                    ilosc_produktow.getChildren().addAll(iinap);
                }
                if (iciast > 0) {
                    zakupy.getChildren().addAll(prod_ciast);
                    ilosc_produktow.getChildren().addAll(iiciast);
                }
                if (icuk > 0) {
                    zakupy.getChildren().addAll(prod_cuk);
                    ilosc_produktow.getChildren().addAll(iicuk);
                }

                HBox zakupy_ilosc = new HBox();
                zakupy_ilosc.setId("zakupy_ilosc");
                zakupy_ilosc.setAlignment(Pos.CENTER);
                zakupy.setAlignment(Pos.CENTER);
                ilosc_produktow.setAlignment(Pos.CENTER);
                zakupy_ilosc.getChildren().addAll(zakupy, ilosc_produktow);

                Label blank2 = new Label("");

                VBox laczna_cena = new VBox();
                Label icena = new Label("Total");
                icena.setId("icena");
                Label iicena = new Label("" + cena_w_koszu[0] + " PLN");
                laczna_cena.setAlignment(Pos.CENTER);
                laczna_cena.getChildren().addAll(icena, iicena, blank2);


                VBox alll3 = new VBox();
                alll3.getChildren().addAll(all3, sprzedawca_nabywca, zakupy_ilosc, laczna_cena);

                but.setOnAction(f -> {
                    Matcher test = NIP_pattern.matcher(nab3_field.getText());
                    if (test.matches() && nab2_field.getText() != null && !nab2_field.getText().isEmpty()) {
                        laczna_cena.getChildren().addAll(sfinalizuj);
                        nabywca.getChildren().removeAll(nab, txt_field, but);
                        Label dane_nazwa = new Label(nab2_field.getText());
                        Label dane_NIP = new Label(nab3_field.getText());
                        field.getChildren().removeAll(nab2_field, nab3_field);
                        field.getChildren().addAll(dane_nazwa, dane_NIP);
                        nabywca.getChildren().addAll(nab, txt_field);
                    }
                });

                sfinalizuj.setOnAction(q -> {
                    ilosc_w_koszu[0] = 0;
                    cena_w_koszu[0] = 0.0;
                    cena_kosz[0].setText("    " + cena_w_koszu[0] + " PLN / " + ilosc_w_koszu[0] + "szt.");

                    stage.setScene(scena);
                    stage.show();
                });

                okno3.add(alll3, 0, 0, 1, 1);

                Scene scena3 = new Scene(okno3, 600, 700);
                scena3.getStylesheets().add("Lab11/style.css");
                stage.setScene(scena3);
                stage.show();
            } else {
                stopka.getChildren().addAll(koperta, napisz2, brak_faktury, faktura);
            }
        });
    }
}
