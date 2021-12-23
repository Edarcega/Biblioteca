package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    /*
     * Este é um método auxiliar para carregar as informações do arquivo properties
     *que por sua vez contem os dados de conexão com o banco de dados
     * */
    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);// load = Faz a leitura do arquivo properties apontado pelo fs e guarda no objeto props
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }

    }

    private static Connection conn = null;

    // Este metodo efetua a conexão com o banco de dados
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();// pega as propriedades do baco de dados utilizando o loadProperties
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);// Classe do jdbc
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

        }
        return conn;
    }

    public static void closeConection(){
        if (conn != null){
            try{
                conn.close();
            }
            catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

}
