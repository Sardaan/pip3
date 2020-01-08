package back;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name = "bean")
@ApplicationScoped
public class Bean implements Serializable {

    private List<Form> history;
    public List<Form> getHistory() {
        return history;
    }
    public void setHistory(List<Form> history) {
        this.history = history;
    }

    static Connection connection;
    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/studs";
        String user = "Sardaann";
        String password = "Sardaann";
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер загружен");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "зщыепкуы");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot connect to database!");
        }
        return connection;
    }

    public List<Form> getDataFromDB() throws SQLException{
        PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT * FROM form");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Form> data = new ArrayList<>();
        while (resultSet.next()) {
            double x = resultSet.getDouble("x");
            double y = resultSet.getDouble("y");
            double r = resultSet.getDouble("r");
            boolean hit = resultSet.getBoolean("hit");
            data.add(new Form(x, y, r, hit));
        }
        setHistory(data);
        return data;
    }
}
