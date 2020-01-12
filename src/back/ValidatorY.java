package back;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import static jdk.nashorn.internal.runtime.JSType.isNumber;

@FacesValidator("validatorY")
public class ValidatorY implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        if (value == null) {
            System.out.println(1);
            throw new ValidatorException(new FacesMessage("Вы не заполнили поле Y!"));
        }
        if(!isNumber(value.toString().replace(",","."))){
            System.out.println(2);
            throw new ValidatorException(new FacesMessage("В поле Y должно быть написано число!"));
        }
        double newValue = ((Number) value).doubleValue();
        if (newValue >= 5.0 || newValue <= -3.0) {
            System.out.println(3);
            throw new ValidatorException(new FacesMessage("Y должно быть в диапозоне от -3.0 до 5.0"));

        }

    }
}
