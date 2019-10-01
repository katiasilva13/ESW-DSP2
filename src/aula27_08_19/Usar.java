/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula27_08_19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author ktia-
 */
public class Usar {

    //criar um main
    public static void main(String[] args) throws IOException {
    teste();    
    // fileInputStream(); 
       //   fileOutpuStream();

    }

    public static void teste() throws IOException {
        String login;
        String host;
        String password;
        System.out.println("### Lendo propriedades do txt ###");
        Properties prop = getProp();
        login = prop.getProperty("prop.server.login");
        host = prop.getProperty("prop.server.host");
        password = prop.getProperty("prop.server.password");
        System.out.println("login " + login);
        System.out.println("host " + host);
        System.out.println("password " + password);
    }

    public static void fileInputStream() throws IOException {
        System.out.println("### Lendo propriedades ###");
        Properties prop = new Properties();
        try {
            prop = getProp();
            prop.load(new FileInputStream("src\\aula27_08_19\\arquivo.properties"));
            System.out.println(prop.getProperty("database")); 
            System.out.println(prop.getProperty("dbuser"));
            System.out.println(prop.getProperty("dbpassword"));
        } catch (Exception e) {
        }
    }

    public static void fileOutpuStream() {
        System.out.println("# Escrevendo em properties (parece estar lendo txt) #");
        Properties prop = new Properties();
        try {
            prop.setProperty("database", "localhost");
            prop.setProperty("dbuser", "adm");
            prop.setProperty("dbpassword", "pass");
           // prop.store(new FileOutputStream("src\\aula27_08_19\\amazonas.properties"), null);
            prop.store(new FileOutputStream("src\\aula27_08_19\\prayforamazonia.properties"), null);
            
        } catch (Exception e) {
        }

    }
    
    public static void usarDB() throws SQLException {
        Properties config = new Properties();
        config.setProperty("database.login", "nome");
        config.setProperty("database.password", "senha");
        config.setProperty("database.url", "jdbc:mysql://localhost");
        String login = config.getProperty("database.login");
        String password = config.getProperty("database.login");
        String url = config.getProperty("database.login");
        DriverManager.getConnection(url, login, password);
        
    }

    private static Properties getProp() throws FileNotFoundException, IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("src\\aula27_08_19\\arquivo.properties");
        props.load(file);
        return props;
    }

}
