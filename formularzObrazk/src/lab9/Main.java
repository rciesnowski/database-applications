package lab9;

import javafx.application.Application;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        GridPane okno = new GridPane();

        // stopka
        Label stopka = new Label("",new ImageView(new Image(new FileInputStream("stopka.png"))));

        HBox blok3=new HBox();
        blok3.setMinWidth(200);
        blok3.setAlignment(Pos.TOP_LEFT);
        blok3.setPadding(new Insets(98,0,0,0));
        okno.add(blok3,0,4,1,1);

        HBox blok9=new HBox();
        blok9.setMinWidth(200);
        blok9.setAlignment(Pos.TOP_LEFT);
        blok9.setPadding(new Insets(122,0,0,0));
        okno.add(blok9,0,4,1,1);
        blok9.getChildren().addAll(stopka);

        // brak danych
        Label brak = new Label();
        brak.setText("Brak wprowadzonych danych");

        VBox blok10=new VBox();
        blok10.setMinWidth(380);
        blok10.setAlignment(Pos.TOP_CENTER);
        blok10.setSpacing(25);
        blok10.setPadding(new Insets(45,130,0,0));
        okno.add(blok10,1,2,1,1);

        // naglowek i logo
        Label nagl = new Label("",new ImageView(new Image(new FileInputStream("naglowek.png"))));
        Label logo = new Label("", new ImageView(new Image(new FileInputStream("logo.png"))));
        HBox blok1=new HBox();
        blok1.setMinWidth(200);
        blok1.setAlignment(Pos.TOP_LEFT);

        okno.add(blok1,0,0,1,1);
        blok1.getChildren().addAll(logo,nagl);

        // menu poz
        Label menuPoz = new Label("",new ImageView(new Image(new FileInputStream("menu_poz.png"))));
        HBox blok2=new HBox();
        blok2.setMinWidth(200);
        blok2.setAlignment(Pos.TOP_LEFT);
        okno.add(blok2,0,1, 1,1);
        blok2.getChildren().addAll(menuPoz);

        // box do wynikow
        Pattern pesel = Pattern.compile("[0-9]{11}");
        Pattern miasto = Pattern.compile("[A-Z][a-z]{1,}");
        Label wynik=new Label();
        Label wynik2=new Label();
        VBox blok7=new VBox();
        blok7.setMinWidth(60);
        blok7.setAlignment(Pos.TOP_RIGHT);
        blok7.setSpacing(40);
        blok7.setPadding(new Insets(45,40,0,0));
        okno.add(blok7,1,2,1,1);

        // box do kropek
        Label dots = new Label();
        Label dots2 = new Label();
        dots.setText("..............................");
        dots2.setText("..............................");
        VBox blok8=new VBox();
        blok8.setMinWidth(380);
        blok8.setAlignment(Pos.TOP_CENTER);
        blok8.setSpacing(40);
        blok8.setPadding(new Insets(45,90,0,0));
        okno.add(blok8,1,2,1,1);

        // pola do wpisywania i przycisk zapisz
        TextField odp1 = new TextField ();
        TextField odp2 = new TextField ();
        odp1.setMaxWidth(280);
        odp2.setMaxWidth(280);
        Button zapisz=new Button("Zapisz");

        VBox blok5=new VBox();
        blok5.setMinWidth(380);
        blok5.setAlignment(Pos.TOP_CENTER);
        blok5.setSpacing(25);
        blok5.setPadding(new Insets(45,130,0,0));
        okno.add(blok5,1,2,1,1);

        // napisy PESEL i miasto
        Label p = new Label();
        Label m = new Label();
        p.setText("PESEL");
        m.setText("miasto");
        VBox blok6=new VBox();
        blok6.setMinWidth(320);
        blok6.setAlignment(Pos.TOP_CENTER);
        blok6.setSpacing(40);
        blok6.setPadding(new Insets(45,0,0,160));
        okno.add(blok6,0,2,1,1);

        // przyciski wprowadz dane i pokaz dane
        VBox blok4=new VBox();
        blok4.setMinWidth(200);
        blok4.setAlignment(Pos.TOP_LEFT);
        blok4.setSpacing(30);
        blok4.setPadding(new Insets(40,0,0,20));
        okno.add(blok4,0,2,1,1);
        Button wprowadz=new Button("");
        wprowadz.setMinSize(159,38);
        Button pokaz=new Button("");
        pokaz.setMinSize(159,38);
        wprowadz.setId("wprowadz");
        wprowadz.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        pokaz.setId("pokaz");
        pokaz.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        blok4.getChildren().addAll(wprowadz,pokaz);

        zapisz.setOnAction(e->
        {
            blok3.getChildren().remove(stopka);
            blok5.getChildren().removeAll(odp1,odp2,zapisz);
            blok8.getChildren().addAll(dots, dots2);
            blok9.getChildren().remove(stopka);
            blok9.getChildren().add(stopka);
            blok10.getChildren().remove(brak);

            if (!odp1.getText().isEmpty()) {
                Matcher test = pesel.matcher(odp1.getText());
                blok7.getChildren().remove(wynik);
                if (test.matches()) wynik.setText("Dane poprawne");
                else wynik.setText("Blad");
                blok7.getChildren().addAll(wynik);
            }
            else {
                blok7.getChildren().remove(wynik);
                wynik.setText("Blad");
                blok7.getChildren().addAll(wynik);
            }

            if (!odp2.getText().isEmpty()) {
                Matcher test = miasto.matcher(odp2.getText());
                blok7.getChildren().remove(wynik2);
                if (test.matches()) wynik2.setText("Dane poprawne");
                else wynik2.setText("Blad");
                blok7.getChildren().addAll(wynik2);
            }
            else {
                blok7.getChildren().remove(wynik2);
                wynik2.setText("Blad");
                blok7.getChildren().addAll(wynik2);
            }
        });

        pokaz.setOnAction(e-> {
            if (wynik.getText()=="Blad" | wynik.getText()=="Dane poprawne") {
            blok3.getChildren().remove(stopka);
            blok3.getChildren().add(stopka);
            blok5.getChildren().removeAll(odp1,odp2,zapisz);

            blok5.getChildren().addAll(odp1,odp2,zapisz);
            blok8.getChildren().removeAll(dots, dots2);
            blok9.getChildren().remove(stopka);
        }
        else {
            blok3.getChildren().remove(stopka);
            blok5.getChildren().removeAll(odp1,odp2,zapisz);
            blok9.getChildren().remove(stopka);
            blok9.getChildren().add(stopka);

            blok10.getChildren().remove(brak);
            blok10.getChildren().add(brak);
        }
        }
        );

        wprowadz.setOnAction(e->{odp1.clear();odp2.clear();
            wynik.setText("");wynik2.setText("");
            blok3.getChildren().remove(stopka);
            blok3.getChildren().add(stopka);
            blok5.getChildren().removeAll(odp1,odp2,zapisz);
            blok5.getChildren().addAll(odp1,odp2,zapisz);
            blok6.getChildren().removeAll(p,m);
            blok6.getChildren().addAll(p,m);
            blok7.getChildren().removeAll(wynik,wynik2);
            blok8.getChildren().removeAll(dots,dots2);
            blok9.getChildren().remove(stopka);
            blok10.getChildren().remove(brak);});

        Scene scena = new Scene(okno, 755, 590);
        stage.setScene(scena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}