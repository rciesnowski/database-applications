package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Controller extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button guzikdane = new Button("d a n e");
        Button guziktest = new Button("t e s t");
        Label labelka = new Label("");
        labelka.setLineSpacing(20);
        guzikdane.setOnAction(e -> labelka.setText("- - - - - - - - - - - - - -\n" +
                "Rafał Ciesnowski\n" +
                "- - - - - - - - - - - - - -"));
        guziktest.setOnAction(e -> labelka.setText(connect()));
        GridPane container = new GridPane();
        container.add(labelka,0,0);

        VBox wiboks = new VBox(100);
        wiboks.setMinWidth(200);
        wiboks.setAlignment(Pos.CENTER);
        guzikdane.setMinWidth(wiboks.getPrefWidth());
        guziktest.setMinWidth(wiboks.getPrefWidth());
        wiboks.getChildren().addAll(guzikdane, guziktest);
        container.add(wiboks,0,0);

        VBox info = new VBox(0);
        info.getChildren().add(labelka);
        info.setMinWidth(200);
        info.setMinHeight(300);
        info.setAlignment(Pos.CENTER);
        container.add(info,1,0);

        Scene scene = new Scene(container, 400, 300);
        primaryStage.setTitle("okienko");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    Connection con;
    public String connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://153.19.7.13:1401", "rciesnowski", "253982");
            con.close();
            return "- - - - - - - - - - - - - -\n" +
                    "Połączono z bazą danych\n" +
                    "- - - - - - - - - - - - - -";
        } catch (SQLException error_polaczenie) {
            return "- - - - - - - - - - - - - -\n" +
                    "błąd połączenia z bazą danych\n" +
                    "- - - - - - - - - - - - - -";
        } catch (ClassNotFoundException error_sterownik) {
            return "- - - - - - - - - - - - - -\n" +
                    "błąd sterownika\n" +
                    "- - - - - - - - - - - - - -";
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}