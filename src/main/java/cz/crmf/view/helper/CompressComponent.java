package cz.crmf.view.helper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.servlet.http.HttpServletRequest;
import com.granule.CompressTagHandler;
import com.granule.JSCompileException;
import com.granule.RealRequestProxy;


/**
 * JSF 2.0 Granule compress component.
 */
public class CompressComponent extends UIOutput {

    @Override
    public void encodeBegin(FacesContext context) throws IOException {

        // Pass through attributes.
        Map<String, Object> attributes = getAttributes();
        String method = (String) attributes.get("method");
        String options = (String) attributes.get("options");
        String basepath = (String) attributes.get("basepath");
        String enabledString = (String) attributes.get("enabled");
        boolean enabled = enabledString == null || Boolean.parseBoolean(enabledString);

        try {
            String oldTagBody = renderTagBody(context);
            String newTagBody;
            if (enabled) {
                HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
                RealRequestProxy runtimeRequest = new RealRequestProxy(request);
                CompressTagHandler compressor = new CompressTagHandler(getId(), method, options, basepath);
                newTagBody = compressor.handleTag(runtimeRequest, runtimeRequest, oldTagBody);
            } else {
                newTagBody = oldTagBody;
            }
            context.getResponseWriter().write(newTagBody);

        } catch (JSCompileException e) {
            throw new IOException(e);
        }
    }

    /**
     * Render children.
     *
     * @param context FacesContext
     * @return Tag body (children) as String
     * @throws IOException on write error
     */
    private String renderTagBody(FacesContext context) throws IOException {

        ResponseWriter originalResponseWriter = context.getResponseWriter();
        StringWriter tmpStringWriter = new StringWriter();
        String oldTagBody = "";

        try {
            context.setResponseWriter(originalResponseWriter.cloneWithWriter(tmpStringWriter));
            for (UIComponent comp : getChildren()) {
                comp.encodeAll(context);
            }
            oldTagBody = tmpStringWriter.toString();

        } finally {
            context.setResponseWriter(originalResponseWriter);
        }
        return oldTagBody;
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        // NOP
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }
}