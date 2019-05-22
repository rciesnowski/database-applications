package sample;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Menu;
import  javafx.scene.control.MenuItem;

public class Formularz extends Application {
    public void start(Stage stage) throws Exception {
        GridPane okno = new GridPane();
        okno.setId("okno");

        //wyłączenie przycisków min,max,close
        stage.initStyle(StageStyle.UNDECORATED);
        Button zamknij=new Button("Zamknij");
        zamknij.setOnAction(e->{stage.close();});
        Button minimum=new Button("Zwiń do paska");
        minimum.setOnAction(e->{stage.setIconified(true);});
        minimum.setId("minimum1");
        zamknij.setId("zamknij1");
        HBox przyciski = new HBox();
        przyciski.setMinSize(600,20);
        przyciski.setSpacing(10); //odległości w poziomie
        przyciski.setAlignment(Pos.TOP_RIGHT);
        przyciski.getChildren().addAll(minimum,zamknij);
        okno.add(przyciski, 0, 0, 1, 1);

        //----------------------------------------FORMULARZ+WYRAŻENIE REGULARNE
        //odpowiedź
        TextField odp1 = new TextField ();
        TextField odp2 = new TextField ();
        TextField odp3 = new TextField ();
        TextField odp4 = new TextField ();
        TextField odp5 = new TextField ();
        TextField odp6 = new TextField ();

        //
        //pierwsza litera A-Z, pozostałe znaki a-z
        Pattern szablon = Pattern.compile("[A-Z][a-z]*");
        //
        odp1.setMaxWidth(200);
        odp1.setPromptText("Wprowadź swoje imię");
        odp1.setOnMousePressed(odp1a->{odp1.clear();});
        odp2.setMaxWidth(200);
        odp2.setPromptText("Wprowadź swoje imię");
        odp2.setOnMousePressed(odp1a->{odp1.clear();});
        odp3.setMaxWidth(200);
        odp3.setPromptText("Wprowadź swoje imię");
        odp3.setOnMousePressed(odp1a->{odp1.clear();});
        odp4.setMaxWidth(200);
        odp4.setPromptText("Wprowadź swoje imię");
        odp4.setOnMousePressed(odp1a->{odp1.clear();});
        odp5.setMaxWidth(200);
        odp5.setPromptText("Wprowadź swoje imię");
        odp5.setOnMousePressed(odp1a->{odp1.clear();});
        odp6.setMaxWidth(200);
        odp6.setPromptText("Wprowadź swoje imię");
        odp6.setOnMousePressed(odp1a->{odp1.clear();});
        //wynik
        Label wynik=new Label();
        Button p1=new Button("Dalej");
        p1.setOnAction(e->
        {
            if (!odp1.getText().isEmpty())
            {
                Matcher test = szablon.matcher(odp1.getText());
                okno.getChildren().remove(wynik);//czyści poprzedni wynik
                wynik.setText(""+test.matches());
                okno.add(new Label(""),0,7,1,1);
                okno.add(wynik, 0, 5, 1, 1);
            }
            else
            {
                okno.getChildren().remove(wynik);//czyści poprzedni wynik
                wynik.setText("Nie podano imienia");
                okno.add(new Label(""),0,7,1,1);
                okno.add(wynik, 0, 5, 1, 1);
            }
        });
        //

        Scene scena= new Scene(okno, 600, 400);
        stage.setScene(scena);
        stage.show();

        okno.add(odp1, 0, 2, 1, 1);
        okno.add(odp2, 0, 3, 1, 1);
        okno.add(odp3, 0, 4, 1, 1);
        okno.add(odp4, 0, 5, 1, 1);
        okno.add(odp5, 0, 6, 1, 1);

        okno.add(p1, 0, 4, 1, 1);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}