package form;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="InputTextView")
@ApplicationScoped
public class InputTextView {
    private String y;

    public String getText() {
        return y;
    }
    public void setText(String y) {
        this.y = y;
    }
}
