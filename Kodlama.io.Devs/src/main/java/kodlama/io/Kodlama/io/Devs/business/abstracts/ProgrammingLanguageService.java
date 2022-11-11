package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingLanguageRequest.CreateProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingLanguageRequest.DeleteProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingLanguageRequest.UpdateProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.business.Responses.ProgrammingLanguageResponse.GetListProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.business.Responses.ProgrammingLanguageResponse.GetProgrammingLanguageById;

public interface ProgrammingLanguageService {

	void add(CreateProgrammingLanguage createProgrammingLanguage)throws Exception;
	void delete (DeleteProgrammingLanguage deleteProgrammingLanguage) throws Exception;
	void update(UpdateProgrammingLanguage updateProgrammingLanguage) throws Exception;
	List<GetListProgrammingLanguage> getAll();
	GetProgrammingLanguageById getProgrammingLanguageById(int id) throws Exception;
}
