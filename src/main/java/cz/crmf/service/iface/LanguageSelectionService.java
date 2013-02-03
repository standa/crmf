package cz.crmf.service.iface;

import java.util.List;
import java.util.Map;

/**
 * Used for getting the list of supported language translations,
 * and ability to set the current language locale.
 * 
 * @author standa
 */
public interface LanguageSelectionService {
    public Map<String, Object> getLanguages();
    public void setLanguage(String lang);
    public String getLanguage();
}
