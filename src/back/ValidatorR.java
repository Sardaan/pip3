package back;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validatorR")
public class ValidatorR implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        if (!value.equals(1)&&!value.equals(1.5)&&!value.equals(2)&&!value.equals(2.5)&&!value.equals(3)) {
            throw new ValidatorException(new FacesMessage("Выберете значение радиуса"));
        }
    }

}