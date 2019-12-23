package back;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

public class Form implements Serializable {
   private double x;
   private double y;
   private int r;
   private boolean hit;

   public Form(double x, double y, int r, boolean hit){
       this.x = x;
       this.y = y;
       this.r = r;
       this.hit = hit;
   }
   public Form(){}

   public static boolean check(double x, double y, int r){
       if(x>=0 && y>=0 && x<=r && y<=r/2) return true;
       if(x<=0 && y>=0 && r*r<=x*x+y*y) return true;
       if(x<=0 && y<=0 && y>=-x-r/2) return true;
       return false;
   }

   public Double getX() {
        return x;
   }
   public void setX(Double x) {
        this.x = x;
    }

   public Double getY() {
        return y;
   }
   public void setY(Double y) {
        this.y = y;
   }

   public Integer getR() {
        return r;
   }
   public void setR(Integer r) {
        this.r = r;
   }

    public boolean isHit() {
        return hit;
    }
    public void setHit(boolean hit) {
        this.hit = hit;
    }

}
