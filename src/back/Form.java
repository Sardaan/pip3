package back;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@ManagedBean(name = "formData")
@ApplicationScoped
public class Form implements Serializable {
    private double x;
    private double y;
    private double hiddenX;
    private double hiddenY;
    private double r;
    private boolean hit = checkArea(x, y, r);

    public Form(double x, double y, double r, boolean hit){
       this.x = x;
       this.y = y;
       this.r = r;
       this.hit = hit;
    }
    public Form(){}

    public static boolean validateX(double x){
       return x > -5 && x < 5;
   }
    public static boolean validateY(double y){
        return y > -3 && y < 5;
    }
    public static boolean validateR(double r){
        return r==1 || r==1.5 || r==2 || r==2.5 || r==3;
    }

    public static boolean checkArea(double x, double y, double r){
        if(x>=0 && y>=0 && x<=r && y<=r/2) return true;
        if(x<=0 && y>=0 && r*r>=x*x+y*y) return true;
        if(x<=0 && y<=0 && y>=-x-r/2) return true;
        return false;
    }
    public double getX() {
        return x;
   }
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
   }
    public void setY(double y) {
        this.y = y;
   }

    public double getHiddenX() {
        return hiddenX;
    }
    public void setHiddenX(double hiddenX) {
        this.hiddenX = hiddenX;
    }

    public double getHiddenY() {
        return hiddenY;
    }
    public void setHiddenY(double hiddenY) {
        this.hiddenY = hiddenY;
    }

    public double getR() {
        return r;
   }
    public void setR(double r) {
        this.r = r;
   }

    public boolean isHit() {
        return hit;
    }
    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public void updateData() throws SQLException {
        if(checkArea(x, y, r)){
            hit = true;
        }else hit = false;
        System.out.println(x + " " + y + " " + r);
        PreparedStatement preparedStatement = Bean.getConnection().prepareStatement("INSERT INTO form values(?, ?, ?, ?)");
        preparedStatement.setDouble(1, x);
        preparedStatement.setDouble(2, y);
        preparedStatement.setDouble(3, r);
        preparedStatement.setBoolean(4, hit);
        preparedStatement.executeUpdate();
    }
    public void updateDataHidden() throws SQLException {
        if(checkArea(hiddenX, hiddenY, r)){
            hit = true;
        }else hit = false;
        System.out.println(hiddenX + " " + hiddenY + " " + r);
        PreparedStatement preparedStatement = Bean.getConnection().prepareStatement("INSERT INTO form values(?, ?, ?, ?)");
        preparedStatement.setDouble(1, hiddenX);
        preparedStatement.setDouble(2, hiddenY);
        preparedStatement.setDouble(3, r);
        preparedStatement.setBoolean(4, hit);
        preparedStatement.executeUpdate();
    }
}
