package cz.crmf.view.bb;

import java.util.*;
import javax.faces.application.Application;
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
@Service("languageSelectionService")
@Scope("session")

// @ManagedBean(name="languageSelectionService") // used @Service instead
// @FacesValidator is not necessary when using binding instead of validatorId in xhtml
public class LanguageSelectionBean {

//    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    private static Map<String, Object> locales;

    public LanguageSelectionBean() {
        locales = new LinkedHashMap<String, Object>();

        Application application = FacesContext.getCurrentInstance().getApplication();
        Iterator supportedLocales = application.getSupportedLocales();
        while (supportedLocales.hasNext()) {
            Locale loc = (Locale) supportedLocales.next();
            locales.put(loc.getDisplayName(), loc);
        }

    }

    public Locale getLocale() {
        return FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }

    public void setLocale(Locale locale) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    /**
     * get the list of available countries for translation
     *
     * @return
     */
    public Map<String, Object> getLanguages() {
        return locales;
    }

    /**
     * Sets the current {@code Locale} for each user session
     *
     * @param languageCode - ISO-639 language code
     */
    public void setLanguage(String language) {
        Locale locale = new Locale(language);
        setLocale(locale);
    }

    public String getLanguage() {
        return getLocale().toString();
    }

    /**
     * value changed event listener
     *
     * @param e
     */
    public void countryLocaleCodeChanged(ValueChangeEvent e) {

        String newLocaleValue = e.getNewValue().toString();

        // loop country map to compare the locale code
        for (Map.Entry<String, Object> entry : locales.entrySet()) {

//            System.out.println("Checking locale "+entry.getValue().toString());

            if (entry.getValue().toString().equalsIgnoreCase(newLocaleValue)) {

//                System.out.println("Setting new locale to "+newLocaleValue);

                setLocale((Locale) entry.getValue());

                break;

            }
        }

//        System.out.println("Current language is: "+getLanguage());
    }
}
