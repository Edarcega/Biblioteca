package applications;

import db.DB;

import java.sql.Connection;

public class Program2 {

    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        DB.closeConection();
    }
}
