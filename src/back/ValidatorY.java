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
        double newValue = ((Number) value).doubleValue();
        if (newValue >= 5.0 || newValue <= -3.0) {
            System.out.println(newValue);
            throw new ValidatorException(new FacesMessage("Y должно быть в диапозоне от -3.0 до 5.0"));

        }

    }
}
