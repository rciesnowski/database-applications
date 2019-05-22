package Lab10;

import javafx.application.Application;
import java.io.FileInputStream;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane okno = new GridPane();
        okno.setId("okno");

        Label nagl = new Label("",new ImageView(new Image(new FileInputStream("t1.jpg"))));
        Label buttonPas = new Label("",new ImageView(new Image(new FileInputStream("t2.gif"))));
        buttonPas.setId("buttonPas");

        Label boczek1 = new Label("",new ImageView(new Image(new FileInputStream("bg.jpg"))));
        Label boczek2 = new Label("",new ImageView(new Image(new FileInputStream("bg.jpg"))));

        Label odstep1 = new Label("",new ImageView(new Image(new FileInputStream("msep.jpg"))));
        odstep1.setId("odstep1");
        Label odstep2 = new Label("",new ImageView(new Image(new FileInputStream("msep.jpg"))));
        odstep2.setId("odstep2");
        Label odstep3 = new Label("",new ImageView(new Image(new FileInputStream("msep.jpg"))));
        odstep3.setId("odstep3");
        Label odstep4 = new Label("",new ImageView(new Image(new FileInputStream("msep.jpg"))));
        odstep4.setId("odstep4");
        Label odstep5 = new Label("",new ImageView(new Image(new FileInputStream("msep.jpg"))));
        odstep5.setId("odstep5");

        Label folder = new Label("",new ImageView(new Image(new FileInputStream("path.jpg"))));

        Label tabGora1 = new Label("",new ImageView(new Image(new FileInputStream("m1.gif"))));
        Label tabGora2 = new Label("",new ImageView(new Image(new FileInputStream("m1.gif"))));

        Label tabDol1 = new Label("",new ImageView(new Image(new FileInputStream("m3.gif"))));
        Label tabDol2 = new Label("",new ImageView(new Image(new FileInputStream("m3.gif"))));

        Label nagGora = new Label("",new ImageView(new Image(new FileInputStream("s1.gif"))));
        Label nagDol = new Label("",new ImageView(new Image(new FileInputStream("s3.gif"))));

        Label strzalk1 = new Label("",new ImageView(new Image(new FileInputStream("arrow.jpg"))));
        strzalk1.setId("strzalk1");
        Label strzalk2 = new Label("",new ImageView(new Image(new FileInputStream("arrow.jpg"))));
        strzalk2.setId("strzalk2");
        Label strzalk3 = new Label("",new ImageView(new Image(new FileInputStream("arrow.jpg"))));
        strzalk3.setId("strzalk3");
        Label strzalk4 = new Label("",new ImageView(new Image(new FileInputStream("arrow.jpg"))));
        strzalk4.setId("strzalk4");
        Label strzalk5 = new Label("",new ImageView(new Image(new FileInputStream("arrow.jpg"))));
        strzalk5.setId("strzalk5");
        Label strzalk6 = new Label("",new ImageView(new Image(new FileInputStream("arrow.jpg"))));
        strzalk6.setId("strzalk6");

        Label folderStrzalk1 = new Label("",new ImageView(new Image(new FileInputStream("arrow.gif"))));
        folderStrzalk1.setId("folderStrzalk1");
        Label folderStrzalk2 = new Label("",new ImageView(new Image(new FileInputStream("arrow.gif"))));
        folderStrzalk2.setId("folderStrzalk2");

        Label stopka = new Label("",new ImageView(new Image(new FileInputStream("d.jpg"))));

        Label img1 = new Label("",new ImageView(new Image(new FileInputStream("img1.jpg"))));
        Label img2 = new Label("",new ImageView(new Image(new FileInputStream("img2.jpg"))));
        Label img3 = new Label("",new ImageView(new Image(new FileInputStream("img3.jpg"))));
        Label img4 = new Label("",new ImageView(new Image(new FileInputStream("img4.jpg"))));

        Label space = new Label("     ");
        Label strona_glowna = new Label("STRONA GLOWNA");
        strona_glowna.setId("strona_glowna");
        Label oferta = new Label("OFERTA");
        oferta.setId("oferta");
        Label cennik = new Label("CENNIK");
        cennik.setId("cennik");
        Label sklep_online = new Label("SKLEP ONLINE");
        sklep_online.setId("sklep_online");
        Label o_nas = new Label("O NAS");
        o_nas.setId("o_nas");
        Label kontakt = new Label("KONTAKT");
        kontakt.setId("kontakt");

        Label strona_glowna2 = new Label("  Strona glowna");
        strona_glowna2.setId("strona_glowna2");
        Label oferta2 = new Label("  Oferta");
        oferta2.setId("oferta2");
        Label cennik2 = new Label("  Cennik");
        cennik2.setId("cennik2");
        Label sklep_online2 = new Label("  Sklep online");
        sklep_online2.setId("sklep_online2");
        Label o_nas2 = new Label("  O nas");
        o_nas2.setId("o_nas2");
        Label kontakt2 = new Label("  Kontakt");
        kontakt2.setId("kontakt2");

        Label space2 = new Label("   ");
        space2.setId("space2");
        Label strona_glowna_path = new Label("strona glowna");
        strona_glowna_path.setId("strona_glowna_path");
        Label oferta_path = new Label("oferta");
        oferta_path.setId("oferta_path");
        Label cennik_path = new Label("cennik");
        cennik_path.setId("cennik_path");
        Label dalej_path = new Label("  >>  ");
        dalej_path.setId("dalej_path");
        Label dalej_path2 = new Label("  >>  ");
        dalej_path2.setId("dalej_path2");

        //inne potrzebne napisy
        Label nawigacja = new Label("NAWIGACJA");
        nawigacja.setId("nawigacja");
        Label szablon = new Label("Szablon zgodny z XHTML");
        szablon.setId("szablon");
        Label naglowek = new Label("         Naglowek podstrony");
        naglowek.setId("naglowek");
        Label zdjecia = new Label("         Przykladowe zdjecia");
        zdjecia.setId("zdjecia");
        Label txt1 = new Label("Donec hendrerit convallis felis, mollis volutpat enim semper non. Ut lacinia est in odio posuere non ultrices dui adipiscing. \n" +
                "Etiam eleifend tortor ac lorem tempor eget porta est imperdiet. Quisque a accumsan elit. Nam ut orci risus. Curabitur id \n" +
                "pellentesque mauris. Sed nulla mauris, imperdiet et sodales at, facilisis ac mauris. Lorem ipsum dolor sit amet, consectetur \n" +
                "adipiscing elit. Mauris semper, felis non volutpat pharetra, sem libero tincidunt orci, id pulvinar tortor eros quis orci. In \n" +
                "ullamcorper nisl et mauris laoreet egestas. Morbi venenatis venenatis nisi, et facilisis leo pulvinar in. Nullam consectetur \n" +
                "sagittis lorem.\n\n");
        txt1.setId("txt1");
        Label txt2 = new Label("Sed condimentum imperdiet est, a malesuada diam laoreet lacinia. Aenean hendrerit ornare nisl quis lacinia. Integer \n" +
                "iaculis bibendum neque nec tristique. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos \n" +
                "himenaeos. Suspendisse cursus iaculis elit eu suscipit. Donec enim lorem, imperdiet sed lacinia dictum, pulvinar at sem. \n" +
                "Curabitur nisi nisl, imperdiet non elementum sed, auctor cursus mauris.");
        txt2.setId("txt2");
        Label sp1 = new Label("    ");
        Label sp2 = new Label("    ");
        Label sp3 = new Label("    ");
        Label valid = new Label("Valid XHTML 1.0 Transitional");
        valid.setId("valid");

        //paseczki z bokow + naglowek + menu
        HBox blok1=new HBox();
        okno.add(blok1,0,0,1,1);

        //naglowek + menu
        VBox blok2=new VBox();
        blok1.getChildren().addAll(boczek1,blok2,boczek2);

        //przyciski w menu
        HBox blok3=new HBox();
        blok3.getChildren().addAll(space,strona_glowna,odstep1,oferta,odstep2,cennik,odstep3,sklep_online,odstep4,o_nas,odstep5,kontakt);
        HBox blok4=new HBox();
        blok4.setId("blok4");
        blok4.getChildren().addAll(blok3);

        //sciezka strona glowna >> oferta >> sciezka
        HBox blok5=new HBox();
        blok5.setId("blok5");
        blok5.getChildren().addAll(folder, space2, strona_glowna_path, dalej_path, oferta_path, dalej_path2, cennik_path);

        //blok z nawigacja i szablon + naglowek podstrony
        HBox blok6=new HBox();

        //blok z nawigacja + szablon
        VBox blok7=new VBox();

        //napis nawigacja
        VBox blok9=new VBox();
        blok9.setId("blok9");
        blok9.setAlignment(Pos.TOP_CENTER);
        blok9.getChildren().addAll(nawigacja);

        //napis szablon
        VBox blok13=new VBox();
        blok13.setId("blok13");
        blok13.setAlignment(Pos.TOP_CENTER);
        blok13.getChildren().addAll(szablon);

        //wypelnienie blok nawigacja
        VBox blok11=new VBox();
        blok11.setId("blok11");

        //wypelnienie blok szablon
        VBox blok14=new VBox();
        blok14.setId("blok14");

        //blok nawigacja
        VBox blok8=new VBox();
        blok8.setId("blok8");
        blok8.getChildren().addAll(tabGora1,blok11,tabDol1);

        //blok szablon
        VBox blok12 = new VBox();
        blok12.setId("blok12");
        blok12.getChildren().addAll(tabGora2,blok14,tabDol2);
        blok7.getChildren().addAll(blok8,blok12);
        blok2.getChildren().addAll(nagl,blok4,blok5,blok6,stopka);

        //bloki ze strzalkami i napisami do tabelki nawigacja
        HBox strgl = new HBox();
        strgl.getChildren().addAll(strzalk1,strona_glowna2);
        HBox ofe = new HBox();
        ofe.getChildren().addAll(strzalk2,oferta2);
        HBox cen = new HBox();
        cen.getChildren().addAll(strzalk3,cennik2);
        HBox skon = new HBox();
        skon.getChildren().addAll(strzalk4,sklep_online2);
        HBox onas = new HBox();
        onas.getChildren().addAll(strzalk5,o_nas2);
        HBox kont = new HBox();
        kont.getChildren().addAll(strzalk6,kontakt2);
        VBox all = new VBox();
        all.setId("all");
        all.getChildren().addAll(strgl,ofe,cen,skon,onas,kont);
        blok11.getChildren().addAll(blok9,all);

        //napis Valid XHTML
        HBox val = new HBox();
        val.setAlignment(Pos.TOP_CENTER);
        val.getChildren().addAll(valid);
        blok14.getChildren().addAll(blok13,val);

        //naglowek napis
        HBox naglowekbox = new HBox();
        naglowekbox.setId("naglowekbox");
        naglowekbox.getChildren().addAll(naglowek);

        //przykladowe zdjecia wstawione
        HBox foty = new HBox();
        foty.setAlignment(Pos.CENTER);
        foty.setId("foty");
        foty.getChildren().addAll(img1,sp1,img2,sp2,img3,sp3,img4);

        //zdjecia napis
        HBox zdjeciabox = new HBox();
        zdjeciabox.setId("zdjeciabox");
        zdjeciabox.getChildren().addAll(zdjecia);

        //wypelnienie bloku naglowek i zdjecia
        VBox inside = new VBox();
        inside.setAlignment(Pos.TOP_CENTER);
        inside.getChildren().addAll(naglowekbox,txt1);

        //wypelnienie bloku naglowek i zdjecia
        VBox inside2 = new VBox();
        inside2.setAlignment(Pos.TOP_CENTER);
        inside2.getChildren().addAll(zdjeciabox,foty,txt2);

        //wypelnienie blok naglowek i zdjecia
        VBox blok16=new VBox();
        blok16.setId("blok16");
        blok16.getChildren().addAll(inside,inside2);

        //blok naglowek i zdjecia
        VBox blok15=new VBox();
        blok15.setId("blok15");
        blok15.getChildren().addAll(nagGora,blok16,nagDol);
        blok6.getChildren().addAll(blok7, blok15);


        Scene scena = new Scene(okno, 1000, 700);
        scena.getStylesheets().add("Lab10/style.css");
        stage.setScene(scena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}