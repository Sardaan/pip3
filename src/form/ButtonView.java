package form;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="ButtonView")
@ApplicationScoped
public class ButtonView {

    private MenuModel model;
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

//        DefaultMenuItem item = DefaultMenuItem.builder()
//                .value("External")
//                .url("http://www.primefaces.org")
//                .icon("pi pi-home")
//                .build();
//
//
//        DefaultSubMenu firstSubmenu = DefaultSubMenu.builder()
//                .label("Dynamic Submenu")
//                .addElement(item)
//                .build();
//
//        model.getElements().add(firstSubmenu);
    }


}
