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

import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingLanguageRequest.CreateProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingLanguageRequest.DeleteProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingLanguageRequest.UpdateProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.business.Responses.ProgrammingLanguageResponse.GetListProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.business.Responses.ProgrammingLanguageResponse.GetProgrammingLanguageById;
import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;

@RestController
@RequestMapping("/api/programminglanguges")
public class ProgrammingLanguagesController {
	
	private final ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}
	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingLanguage createProgrammingLanguage) throws Exception{
		programmingLanguageService.add(createProgrammingLanguage);	
	}
	@DeleteMapping("/delete")
	public void delete(@RequestParam DeleteProgrammingLanguage deleteProgrammingLanguage) throws Exception{
		programmingLanguageService.delete(deleteProgrammingLanguage);
	
	
	}
	@PutMapping("/update")
	public void update(@RequestBody UpdateProgrammingLanguage updateProgrammingLanguage)throws Exception{
		programmingLanguageService.update(updateProgrammingLanguage);
	}
	@GetMapping("/getall")
	public List<GetListProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	@GetMapping("/getbyid")
	
	public GetProgrammingLanguageById getById(@RequestParam int id) throws Exception{
		return programmingLanguageService.getProgrammingLanguageById(id);
	}

}
