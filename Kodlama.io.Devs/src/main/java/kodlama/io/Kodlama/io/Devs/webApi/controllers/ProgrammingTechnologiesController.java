package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingTechnologyRequest.CreateProgrammingTechnology;
import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingTechnologyRequest.DeleteProgrammingTechnology;
import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingTechnologyRequest.UpdateProgrammingTechnology;
import kodlama.io.Kodlama.io.Devs.business.Responses.ProgrammingTechnologyResponse.GetListProgrammingTechnology;
import kodlama.io.Kodlama.io.Devs.business.Responses.ProgrammingTechnologyResponse.GetProgrammingTechnologyById;
import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingTechnologyService;

@RestController
@RequestMapping("/api/programmingtechnologies")
public class ProgrammingTechnologiesController {
	@Autowired
	private ProgrammingTechnologyService programmingTechnologyService;
	
	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingTechnology createProgrammingTechnology) throws Exception {
		programmingTechnologyService.add(createProgrammingTechnology);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteProgrammingTechnology deleteProgrammingTechnology) throws Exception {
		programmingTechnologyService.delete(deleteProgrammingTechnology);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateProgrammingTechnology updateProgrammingTechnology) throws Exception {
		programmingTechnologyService.update(updateProgrammingTechnology);
	}
	
	@GetMapping("/getall")
	public List<GetListProgrammingTechnology> getAll(){
		return programmingTechnologyService.getAll();
	}
	
	@GetMapping("getbyid")
	public GetProgrammingTechnologyById getById(@RequestParam int id) throws Exception {
		return programmingTechnologyService.getProgrammingTechnologyId(id);
	}
}
