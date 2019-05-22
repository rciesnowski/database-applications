package pierwsze;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

class Controller {
    HBox h1;
    VBox text,insertText,bledy;
    Label pesel,miasto,kod_pocztowy,telefon,email;
    Label pesel2,miasto2,kod_pocztowy2,telefon2,email2;
    String pesel3,miasto3,kod_pocztowy3,telefon3,email3;
    Label pesel4,miasto4,kod_pocztowy4,telefon4,email4;
    Label err1,err2;
    TextField peselBox,miastoBox,kod_pocztowyBox,telefonBox,emailBox;
    Button dalej;
    Button wroc;

    public Controller(BorderPane okno) {
        this.h1 = new HBox();
        h1.setPadding(new Insets(100,10,10,10));
        this.text = new VBox();
        this.insertText=new VBox();
        this.insertText.setMinWidth(200);
        this.bledy = new VBox();

        this.text.setSpacing(20);
        this.pesel = new Label("PESEL ");
        this.miasto = new Label("Miasto ");
        this.kod_pocztowy = new Label("Kod pocztowy ");
        this.telefon = new Label("Telefon ");
        this.email = new Label("Adres email");
        this.err1 = new Label("Blad polaczenia");
        this.err2 = new Label("Brak sterownikow");

        this.pesel2 = new Label("***************");
        this.miasto2 = new Label("***************");
        this.kod_pocztowy2 = new Label("***************");
        this.telefon2 = new Label("***************");
        this.email2 = new Label("***************");
        this.insertText.setSpacing(10);
        this.peselBox = new TextField();
        this.peselBox.setMaxWidth(100);
        this.miastoBox = new TextField();
        this.miastoBox.setMaxWidth(100);
        this.kod_pocztowyBox = new TextField();
        this.kod_pocztowyBox.setMaxWidth(100);
        this.telefonBox = new TextField();
        this.telefonBox.setMaxWidth(100);
        this.emailBox = new TextField();
        this.emailBox.setMaxWidth(100);
        this.dalej =  new Button("Dalej");
        this.wroc = new Button("Wroc");

        this.bledy.setSpacing(20);
        this.pesel4 = new Label();
        this.miasto4 = new Label();
        this.kod_pocztowy4 = new Label();
        this.telefon4 = new Label();
        this.email4 = new Label();

        this.text.getChildren().addAll(this.pesel,this.miasto,this.kod_pocztowy,this.telefon,this.email,this.dalej);
        this.insertText.getChildren().addAll(this.peselBox,this.miastoBox,this.kod_pocztowyBox,this.telefonBox,this.emailBox,this.dalej);
        this.h1.getChildren().addAll(this.text,this.insertText,this.bledy);
        okno.setCenter(h1);

        dalej.setOnAction(e-> {
            this.pesel3 = this.peselBox.getText();
            this.miasto3 = this.miastoBox.getText();
            this.kod_pocztowy3 = this.kod_pocztowyBox.getText();
            this.telefon3 = this.telefonBox.getText();
            this.email3 = this.emailBox.getText();
            insertText.getChildren().clear();
            insertText.setSpacing(20);
            insertText.getChildren().addAll(this.pesel2,this.miasto2,this.kod_pocztowy2,this.telefon2,this.email2,this.wroc);

            if(this.pesel3.matches("[0-9]{11}")) this.bledy.getChildren().addAll(new Label("Poprawne"));
            else this.bledy.getChildren().addAll(new Label("Blad"));

            if(this.miasto3.matches("([a-z]|[A-Z])+")) this.bledy.getChildren().addAll(new Label("Poprawne"));
            else this.bledy.getChildren().addAll(new Label("Blad"));

            if(this.kod_pocztowy3.matches("[0-9]{2}-[0-9]{3}")) this.bledy.getChildren().addAll(new Label("Poprawne"));
            else this.bledy.getChildren().addAll(new Label("Blad"));

            if(this.telefon3.matches("[0-9]{9,}")) this.bledy.getChildren().addAll(new Label("Poprawne"));
            else this.bledy.getChildren().addAll(new Label("Blad"));

            if(this.email3.matches(".+@.+[.].{1,3}")) this.bledy.getChildren().addAll(new Label("Poprawne"));
            else this.bledy.getChildren().addAll(new Label("Blad"));
        });

        wroc.setOnAction(e-> {
                    this.insertText.getChildren().clear();
                    this.insertText.setSpacing(20);
                    this.bledy.getChildren().clear();
                    this.peselBox.setText(this.pesel3);
                    this.miastoBox.setText(this.miasto3);
                    this.kod_pocztowyBox.setText(this.kod_pocztowy3);
                    this.telefonBox.setText(this.telefon3);
                    this.emailBox.setText(this.email3);
                    this.insertText.getChildren().addAll(this.peselBox,this.miastoBox,this.kod_pocztowyBox,this.telefonBox,this.emailBox,this.dalej);
                }
        );
    }
}

public class Nara extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.initStyle(StageStyle.UNDECORATED);

        BorderPane okno = new BorderPane();
        okno.setPadding(new Insets(10,10,10,10));
        HBox buttons = new HBox();
        Button wyjscie = new Button("Wyjscie");
        Button zwin = new Button("Zwin");

        Controller controller = new Controller(okno);
        buttons.getChildren().addAll(zwin,wyjscie);
        buttons.setSpacing(10);
        okno.setRight(buttons);

        wyjscie.setOnAction(e-> { primaryStage.close(); });
        zwin.setOnAction(e-> { ((Stage)((Button)e.getSource()).getScene().getWindow()).setIconified(true); });
        primaryStage.setScene(new Scene(okno, 500, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
