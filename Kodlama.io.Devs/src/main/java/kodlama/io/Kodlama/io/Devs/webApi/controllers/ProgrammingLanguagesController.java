package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.entities.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguges")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}
	@PostMapping("/add")
	public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception{
		programmingLanguageService.add(programmingLanguage);		
	}
	@DeleteMapping("/delete")
	public void delete(@RequestParam int id) throws Exception{
		programmingLanguageService.delete(id);
	
	
	}
	@PutMapping("/update")
	public void update(@RequestBody ProgrammingLanguage programmingLanguage)throws Exception{
		programmingLanguageService.update(programmingLanguage);
	}
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	@GetMapping("/getbyid")
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageService.getProgrammingLanguageById(id);
	}

}
