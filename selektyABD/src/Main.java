import java.sql.*;


public class Main {
    public static void main(String[] args) {
        Connection con;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://153.19.7.13:1401","rciesnowski","253982");
            System.out.println("Połączono z bazą danych");


            Statement zapytanie = con.createStatement();
            String sql1="select * from Tabela1";
            ResultSet wynik_zapytania = zapytanie.executeQuery(sql1);
            ResultSetMetaData wynik2 = wynik_zapytania.getMetaData();
            int ile_kolumn = wynik2.getColumnCount();
            while(wynik_zapytania.next()) {
                for (int i=1;i<=ile_kolumn;i++) System.out.print(wynik_zapytania.getString(i)+" | ");
                System.out.print("\n");
            }
            System.out.println();
            String sql2="select * from Tabela1";
            wynik_zapytania = zapytanie.executeQuery(sql2);
            wynik2 = wynik_zapytania.getMetaData();
            ile_kolumn = wynik2.getColumnCount();
            while(wynik_zapytania.next()) {
                for (int i=1;i<=ile_kolumn;i++) System.out.print(wynik_zapytania.getString(i)+" | ");
                System.out.print("\n");
            }
            System.out.println();
            String sql3="select Tabela1.nazwisko, year(getdate()) - year(Tabela1.data_urodzenia), Tabela2.miasto from Tabela1 join Tabela2 on Tabela1.nazwisko=Tabela2.nazwisko";
            wynik_zapytania = zapytanie.executeQuery(sql3);
            wynik2 = wynik_zapytania.getMetaData();
            ile_kolumn = wynik2.getColumnCount();
            while(wynik_zapytania.next()) {
                for (int i=1;i<=ile_kolumn;i++) System.out.print(wynik_zapytania.getString(i)+" | ");
                System.out.print("\n");
            }
            System.out.println();
            String sql4="select nazwisko from Tabela1 order by year(getdate()) - year(data_urodzenia) asc";
            wynik_zapytania = zapytanie.executeQuery(sql4);
            wynik2 = wynik_zapytania.getMetaData();
            ile_kolumn = wynik2.getColumnCount();
            wynik_zapytania.next();
            for (int i=1;i<=ile_kolumn;i++) System.out.print(wynik_zapytania.getString(i));
            System.out.print("\n");
            System.out.println();
            String sql5="select count(nazwisko) as ilosc_mieszkancow, miasto from Tabela2 group by miasto";
            wynik_zapytania = zapytanie.executeQuery(sql5);
            wynik2 = wynik_zapytania.getMetaData();
            ile_kolumn = wynik2.getColumnCount();
            while(wynik_zapytania.next()) {
                for (int i = 1; i <= ile_kolumn; i++) System.out.print(wynik_zapytania.getString(i) + " | ");
                System.out.print("\n");
            }
            con.close();
        }
        catch(SQLException error_polaczenie) {
            System.out.println("Błąd połączenia z bazą danych");}
        catch(ClassNotFoundException error_sterownik) {
            System.out.println("Brak sterownika");}

    }
}
