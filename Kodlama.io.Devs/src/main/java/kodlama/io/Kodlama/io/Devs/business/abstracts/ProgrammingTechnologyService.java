package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingTechnologyRequest.CreateProgrammingTechnology;
import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingTechnologyRequest.DeleteProgrammingTechnology;
import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingTechnologyRequest.UpdateProgrammingTechnology;
import kodlama.io.Kodlama.io.Devs.business.Responses.ProgrammingTechnologyResponse.GetListProgrammingTechnology;
import kodlama.io.Kodlama.io.Devs.business.Responses.ProgrammingTechnologyResponse.GetProgrammingTechnologyById;

public interface ProgrammingTechnologyService {
	void add(CreateProgrammingTechnology createProgrammingTechnology) throws Exception;
	void delete(DeleteProgrammingTechnology deleteProgrammingTechnology) throws Exception;
	void update(UpdateProgrammingTechnology updateProgrammingTechnology) throws Exception;
	
	List<GetListProgrammingTechnology> getAll();
	GetProgrammingTechnologyById getProgrammingTechnologyId(int id) throws Exception;
	
}
