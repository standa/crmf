package cz.crmf.view.bb;

import cz.crmf.service.iface.LanguageSelectionService;
import java.util.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Implementation of the language selection service meant to be used with JSF
 * components.
 *
 * @author standa
 */
//@ManagedBean(name="languageSelectionService")
@Service("languageSelectionService")
@Scope("session")
public class LanguageSelectionServiceImpl implements LanguageSelectionService {

    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    private static Map<String, Object> countries;

    public LanguageSelectionServiceImpl() {
        countries = new LinkedHashMap<String, Object>();
        countries.put("English", Locale.ENGLISH); // label, value
        countries.put("Czech", new Locale("cs"));
    }

    public Locale getLocale() {
        return locale;
    }

    /**
     * get the list of available countries for translation
     * @return 
     */
    @Override
    public Map<String, Object> getLanguages() {
        return countries;
    }

    /**
     * Sets the current {@code Locale} for each user session
     *
     * @param languageCode - ISO-639 language code
     */
    @Override
    public void setLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    @Override
    public String getLanguage() {
        return locale.getLanguage();
    }

    /**
     * value changed event listener
     * @param e 
     */
    public void countryLocaleCodeChanged(ValueChangeEvent e) {

        String newLocaleValue = e.getNewValue().toString();

        //loop country map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if (entry.getValue().toString().equals(newLocaleValue)) {

                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());

            }
        }
    }
}
