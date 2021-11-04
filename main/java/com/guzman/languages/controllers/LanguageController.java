package com.guzman.languages.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.guzman.languages.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.guzman.languages.models.Language;
import com.guzman.languages.services.LanguageServices;

@Controller
public class LanguageController {
	    private final LanguageServices languageServices;
	    public LanguageController(LanguageServices languageServices){
	        this.languageServices = languageServices;
	    }
	    @RequestMapping("/")
	    public String index(Model model) {
	        List<Language> languages = languageServices.allLanguages();
	        model.addAttribute("languages", languages);
	        return "index.jsp";
	    }

	    
	    @RequestMapping( value = "/create/language", method = RequestMethod.POST )
		public String createLanguage( @Valid @ModelAttribute( "language" ) Language language, BindingResult result) {
	    	if ( result.hasErrors() )
				return "index.jsp";
				//redirectAttributes.addFlashAttribute( "errorMessage", "You need to provide the identifier. The name must be lesser than 100 characters long!" );
	    	else {	
	    	languageServices.createLanguage(language);
				return "redirect:/";
			}
	    }
	    @RequestMapping("/new")
	    	public String New(@ModelAttribute("language") Language language) {
	    		return "new.jsp";
	    	}
	    
	    @RequestMapping("/language/{id}")
	    public String Details(@PathVariable("id") Long id, Model model) {
	    	System.out.println(id);
			model.addAttribute("language", languageServices.findLanguage(id));
			return "details.jsp";
		}
	    
//		@RequestMapping( value = "/language/update", method = RequestMethod.POST )
//		public String updateHobby( @RequestParam( value = "id" ) Long id, 
//								   @RequestParam( value = "name" ) String name,
//								   RedirectAttributes redirectAttributes) {
//			
//			Language currentLanguage = languageServices.findLanguage( id );
//			if ( currentLanguage == null ) {
//				redirectAttributes.addFlashAttribute( "errorMessage", "That hobby identifier doesn't exist." );
//			}
//			else {
//				currentLanguage.setName( name );
//				languageServices.updateLanguage( currentLanguage );
//			}
//			
//			return "redirect:/hobbies";
//	    
//		}
	    
		@RequestMapping("/languages/{id}/edit")
		public String Edit(@PathVariable("id") Long id, Model model) {
			model.addAttribute("language", languageServices.findLanguage(id));
			return "edit.jsp";
		}
		
		@RequestMapping(value="language/{id}", method=RequestMethod.DELETE)
		public String Delete(@PathVariable("id") Long id) {
			languageServices.deleteLanguage(id);
			return "redirect:/";
		}
		
	    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	            languageServices.updateLanguage(language);
	            return "redirect:/";
	        }
	    }
		
	
}
