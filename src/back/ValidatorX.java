package back;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validatorX")
public class ValidatorX implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        if (!value.equals(-5)&&!value.equals(-4)&&!value.equals(-3)&&!value.equals(-2)&&!value.equals(-1)
                &&!value.equals(0)&&!value.equals(1)&&!value.equals(2)&&!value.equals(3)&&!value.equals(4)&&!value.equals(5)) {
            throw new ValidatorException(new FacesMessage("Выберете значение X"));
        }
    }

}