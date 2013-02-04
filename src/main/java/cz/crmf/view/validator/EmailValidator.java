package cz.crmf.view.validator;

import cz.crmf.view.helper.FacesUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * This validates input fields that should contain email addresses.
 *
 * @author standa
 */
@Component("emailValidator")
@Scope("request")
// @FacesValidator("EmailValidator") // not used in Spring 
public class EmailValidator implements Validator {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\."
            + "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*"
            + "(\\.[A-Za-z]{2,})$";
    private Pattern pattern;
    private Matcher matcher;

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object value) throws ValidatorException {

        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {

            FacesMessage msg =
                    new FacesMessage(
                        FacesUtil.getMessage("cz.crmf.server", "register.emailValidationFailed"),
                        FacesUtil.getMessage("cz.crmf.server", "register.invalidEmailFormat"));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        }

    }
}
