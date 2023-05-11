import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JdbcAccessTest {

    public static void main(String[] args) {

        String databaseURL = "jdbc:ucanaccess://C:/Users/Lenovo/Desktop/בל/הדסים/Covid.19_DB.accdb";

        try (Connection connection = DriverManager.getConnection(databaseURL)) {  // הAPI עטוף בTRY כדי למנוע הימצאות של אי הימצאות הDB, ואז הוא זורק SQLException

            String sql;  //מחרוזת המכילה את שאילתות הSQL

            int choice = start("for the first time");
            while (choice != 3) {

                if (choice == 1) {
                    setValuesIntoDB(connection, "INSERT INTO Members ( id_number, first_name, last_name, city, address, birth_date, phone, cellular)" +
                            " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                } else if (choice == 2) {
                    List<Members> membersList = getValuesFromDB(connection, "SELECT * FROM Members");
                    for (Members m : membersList) {
                        System.out.println(m);
                        /*System.out.println(m.toString());*/
                    }
                }

                choice = start("again");  //return to the selection menu
            }

            System.out.println("Good luck!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //methods

    public static int start(String situation) {
        System.out.println("Hello " + situation + " dear user!\n" +
                "Here is a system for managing the Corona database for the health funds.\n" +
                "You are prompted to choose one of the options below:\n" +
                "option no.1- to set data\n" +
                "option no.2- to pull data");

        if (situation == "again") {  //just if the user return to the start menu, he will know to choose the third option- to exit
            System.out.println("option no.3- Stopping the program");
        }

        System.out.println("Your choice:");

        //the user input
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }


    /* פונקציה זו מכניסה ערכים לתוך הדאטה בייס.
     * אפשר לבחור להכניס לפונקציה ערכים שונים, לטבלאות שונות עם קשרים שונים.
     * פה התמקדתי בהכנסת נתוני חבר חדש לטבלת חברי הקופה, בערכים שכבר נתונים מראש.
     * תהיה אפשרות להוסיף פקודות קלט מצד הלקוח להוספת נתונים למערכת, וכמובן להתרחב לטבלאות אחרות.
     * */
    public static void setValuesIntoDB(Connection connection, String sql) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "20666666");
        preparedStatement.setString(2, "Moshe");
        preparedStatement.setString(3, "Cohen");
        preparedStatement.setString(4, "Lod");
        preparedStatement.setString(5, "Hanasi 1");
        preparedStatement.setDate(6, Date.valueOf("1996-02-08"));
        preparedStatement.setString(7, "03333333");
        preparedStatement.setString(8, "0533333");

        int row = preparedStatement.executeUpdate();

        if (row > 0) {
            System.out.println("A row has been inserted successfully.");
        }
    }

    //A method that get the details from the DB and set them into the arguments in our system
    //return a list with all the members that we asked
    public static List<Members> getValuesFromDB(Connection connection, String sql) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);  //מריץ את השאילתה שכתבנו בsql ומכניס את הפלט לתוך result
        List<Members> membersList = new ArrayList<>();

        while (result.next()) {  //רץ כל עוד יש לפניו רשומה נוספת. אם הגיע לסוף הטבלה ואין אחריו רשומות, יוצא

            membersList.add(new Members(result.getInt("id"), result.getString("id_number"),
                    result.getString("first_name"), result.getString("last_name"),
                    result.getString("city"), result.getString("address"),
                    result.getDate("birth_date"), result.getString("phone"),
                    result.getString("cellular")));
        }

        return membersList;
    }
}