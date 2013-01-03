/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author standa
 */
@Controller
@RequestMapping("/restTest")
public class RestTest {
    
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getMovie(@PathVariable String name, ModelMap model) {

            model.addAttribute("movie", name);
            return "list";

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getDefaultMovie(ModelMap model) {

            model.addAttribute("movie", "this is default movie");
            return "list";

    }    
    
}
