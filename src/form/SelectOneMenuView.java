package form;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="SelectOneMenuView")
@ApplicationScoped
public class SelectOneMenuView {
    private Double r;

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

}
