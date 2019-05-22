package sample;
import java.sql.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import  javafx.scene.control.MenuItem;

public class Przychodnia extends Application {
    Connection con;
    int kolumny;
    public void start(Stage stage) throws Exception {
        Menu menu = new Menu("Menu");
        MenuItem polaczM = new MenuItem("Połącz");
        MenuItem lekarzeM = new MenuItem("Lista lekarzy");
        MenuItem szukajkaM = new MenuItem("Szukaj wizytę");
        menu.getItems().add(polaczM);
        menu.getItems().add(lekarzeM);
        menu.getItems().add(szukajkaM);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);
        Label wynik= new Label("Polaczono");
        Label err1= new Label("Blad polaczenia");
        Label err2= new Label("Blad sterownika");
        String lekarz= "select nazwisko, specjalizacja, nr_pokoju from lekarz";
        TextField tf= new TextField();
        GridPane okno= new GridPane();
        ScrollPane Sp = new ScrollPane();
        Sp.setPrefSize(600, 300);
        VBox lewy=new VBox();
        lewy.setAlignment(Pos.CENTER);
        lewy.setMinHeight(500);
        lewy.setMinWidth(170);
        lewy.setSpacing(10);
        okno.add(lewy, 0, 1, 1, 3);
        okno.add(menuBar, 0, 0, 2, 1);
        menuBar.setPrefHeight(20);
        HBox prawy= new HBox();
        prawy.setMinWidth(150);
        prawy.setAlignment(Pos.CENTER);
        Sp.setContent(prawy);
        okno.add(prawy,0, 1, 1, 1);
        Button polaczenie= new Button("Polacz");
        polaczenie.setMinSize(150, 30);
        Button lekarze= new Button("Lista lekarzy");
        lekarze.setMinSize(150, 30);
        Button wizyty= new Button("Znajdz");
        Button szukajka= new Button("Szukaj wizyte");
        szukajka.setMinSize(150, 30);
        wizyty.setMinSize(150, 30);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://"+
                    "153.19.7.13:1401;databaseName=rciesnowski;"+
                    "user=rciesnowski;password=253982;");
            Statement zap= con.createStatement();
            ResultSet wynik_zapytania = zap.executeQuery(lekarz);
            ResultSetMetaData ile_kol= wynik_zapytania.getMetaData();
            kolumny= ile_kol.getColumnCount();

            zap.close();
            con.close();
        }
        catch(SQLException error_polaczenie){}
        catch(ClassNotFoundException error_sterownik) {}
        VBox[] vBoxes=new VBox[kolumny];
        for (int i=0;i<vBoxes.length;i++) {
            vBoxes[i]= new VBox();
            vBoxes[i].setPrefSize(100, 200);
        }
        lewy.getChildren().addAll(polaczenie, lekarze, szukajka);
        szukajka.setOnAction(e->{
            prawy.getChildren().clear();
            okno.getChildren().remove(Sp);
            okno.add(Sp, 1, 1, 1, 1);
            prawy.getChildren().addAll(tf,wizyty);

        });
        szukajkaM.setOnAction(e->{
            prawy.getChildren().clear();
            okno.getChildren().remove(Sp);
            okno.add(Sp, 1, 1, 1, 1);
            prawy.getChildren().addAll(tf,wizyty);

        });
        wizyty.setOnAction(e -> {
            prawy.getChildren().clear();
            okno.getChildren().remove(Sp);
            okno.add(Sp, 1, 1, 1, 1);
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://"+
                        "153.19.7.13:1401;databaseName=rciesnowski;"+
                        "user=rciesnowski;password=253982;");
                Statement zap= con.createStatement();
                String nazw="SELECT  pacjent.nazwisko, wizyta.data_wizyty, lekarz.nazwisko, lekarz.specjalizacja, lekarz.nr_pokoju FROM wizyta LEFT JOIN pacjent on wizyta.id_pacjent = pacjent.id_pacjent LEFT JOIN lekarz on wizyta.id_lekarz = lekarz.id_lekarz where pacjent.nazwisko='"+tf.getText()+"'";
                ResultSet wynik_zapytania = zap.executeQuery(nazw);
                int i=1;
                String spr="";
                while(wynik_zapytania.next()) {
                    spr += wynik_zapytania.getString(1)+" "+wynik_zapytania.getString(2)+" "+wynik_zapytania.getString(3)
                            +" "+wynik_zapytania.getString(4)+" "+wynik_zapytania.getString(5)+"\n";

                    i++;
                }
                Label lab= new Label(spr);
                prawy.getChildren().addAll(lab);
                zap.close();
                con.close();
            }
            catch(SQLException error_polaczenie){
                System.out.println("pol");
            }
            catch(ClassNotFoundException error_sterownik) {}

        });
        polaczenie.setOnAction(e-> {
            prawy.getChildren().clear();
            okno.getChildren().remove(Sp);
            okno.add(Sp, 1, 1, 1, 1);

            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://"+
                        "153.19.7.13:1401;databaseName=rciesnowski;"+
                        "user=rciesnowski;password=253982;");
                prawy.getChildren().add(wynik);
            }
            catch(SQLException error_polaczenie) {
                prawy.getChildren().add(err1);
            }
            catch(ClassNotFoundException error_sterownik) {
                prawy.getChildren().add(err2);
            }
        });
        polaczM.setOnAction(e-> {
            prawy.getChildren().clear();
            okno.getChildren().remove(Sp);
            okno.add(Sp, 1, 1, 1, 1);

            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://"+
                        "153.19.7.13:1401;databaseName=rciesnowski;"+
                        "user=rciesnowski;password=253982;");
                prawy.getChildren().add(wynik);
            }
            catch(SQLException error_polaczenie) {
                prawy.getChildren().add(err1);
            }
            catch(ClassNotFoundException error_sterownik) {
                prawy.getChildren().add(err2);
            }
        });
        lekarze.setOnAction(e->{
            prawy.getChildren().clear();
            okno.getChildren().remove(Sp);
            prawy.getChildren().addAll(vBoxes);
            okno.add(Sp, 1, 1, 1, 1);
            for(int i=0;i<vBoxes.length;i++) {
                vBoxes[i].getChildren().clear();
            }
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://"+
                        "153.19.7.13:1401;databaseName=rciesnowski;"+
                        "user=rciesnowski;password=253982;");
                Statement zap= con.createStatement();

                ResultSet wynik_zapytania = zap.executeQuery(lekarz);
                while(wynik_zapytania.next())
                {
                    int i=1, j;
                    for(j=0;j<vBoxes.length;j++) {
                        Label col=new Label(wynik_zapytania.getString(i));
                        vBoxes[j].getChildren().add(col);
                        i++;
                    }
                }


                zap.close();
                con.close();
            }
            catch(SQLException error_polaczenie){}
            catch(ClassNotFoundException error_sterownik) {}
        });
        lekarzeM.setOnAction(e->{
            prawy.getChildren().clear();
            okno.getChildren().remove(Sp);
            prawy.getChildren().addAll(vBoxes);
            okno.add(Sp, 1, 1, 1, 1);
            for(int i=0;i<vBoxes.length;i++) {
                vBoxes[i].getChildren().clear();
            }
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://"+
                        "153.19.7.13:1401;databaseName=rciesnowski;"+
                        "user=rciesnowski;password=253982;");
                Statement zap= con.createStatement();

                ResultSet wynik_zapytania = zap.executeQuery(lekarz);
                while(wynik_zapytania.next())
                {
                    int i=1, j;
                    for(j=0;j<vBoxes.length;j++) {
                        Label col=new Label(wynik_zapytania.getString(i));
                        vBoxes[j].getChildren().add(col);
                        i++;
                    }
                }


                zap.close();
                con.close();
            }
            catch(SQLException error_polaczenie){}
            catch(ClassNotFoundException error_sterownik) {}
        });
        Scene scena= new Scene(okno, 600, 200);
        stage.setScene(scena);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}