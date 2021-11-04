package com.guzman.languages.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.guzman.languages.models.Language;
import com.guzman.languages.repositories.LanguageRepository;
@Service
public class LanguageServices {
	// adding the book repository as a dependency
    private final LanguageRepository languageRepository;
    
    public LanguageServices(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the books
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a book
    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
	public Language updateLanguage(Language lang) {
		return languageRepository.save(lang);
	}
//    // retrieves a book
//    public Language findLanguage(Long id) {
//        Optional<Language> optionalLanguage = languageRepository.findById(id);
//        if(optionalLanguage.isPresent()) {
//            return optionalLanguage.get();
//        } else {
//            return null;
//        }
//    }
	public Language findLanguage(Long id) {
		return languageRepository.findById(id).orElse(null);
	}
	
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
}
