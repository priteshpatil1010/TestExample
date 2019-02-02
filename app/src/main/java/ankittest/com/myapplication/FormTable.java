package ankittest.com.myapplication;

public class FormTable {


    public static String TABLE_FORM = "FormTable";
    public static String COL_NAME = "name";
    public static String COL_MAIl = "mail";
    public static String COL_PWD = "password";
    public static String COL_GENDER = "gender";
    public static String COL_ABOUT = "about";

    public static String DB_STATEMENT = "CREATE TABLE "+FormTable.TABLE_FORM+"("
            +"'"+COL_NAME+"' TEXT,"
            +"'"+COL_MAIl+"' TEXT,"
            +"'"+COL_PWD+"' TEXT,"
            +"'"+COL_GENDER+"' TEXT,"
            +"'"+COL_ABOUT+"' TEXT"
            +")";


}
