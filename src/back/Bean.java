package back;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//todo отправление формы при нажатии на канвас и при нажатии на сабмит

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

    static Connection connection = connect();
    public static Connection getConnection(){
        return connection;
    }
    public static Connection connect() {
        String url = "jdbc:postgresql://pg:5432/studs";
        String user = "s";
        String password = "s";
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер загружен");
            connection = DriverManager.getConnection(url,user, password);
            System.out.println("Connected to the database");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot connect to database!");
        }
        return connection;
    }

    public List<Form> getDataFromDB() throws SQLException{
        PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT * FROM s264424.form");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Form> data = new ArrayList<>();
        while (resultSet.next()) {
            double x = resultSet.getDouble("x");
            double y = resultSet.getDouble("y");
            double r = resultSet.getDouble("r");
            boolean hit = resultSet.getBoolean("hit");
            double id = resultSet.getDouble("id");
            data.add(new Form(x, y, r, hit, id));
        }
        setHistory(data);
        return data;
    }
    public void deleteData() throws SQLException{
        if (!getConnection().createStatement().execute("DELETE from s264424.form")){
            System.out.println("deleted");
        }
    }
}
