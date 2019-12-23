package back;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.*;

@ManagedBean(name = "Bean")
@ApplicationScoped
public class Bean implements Serializable {

    private String url = "jdbc:postgresql://localhost:5432/dots";//Записываем url, в конце имя DB
    private String user = "postgres";
    private String password = "88dofodo";

    Connection connection;
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Cannot connect to database!");
        }
        return connection;
    }
}
