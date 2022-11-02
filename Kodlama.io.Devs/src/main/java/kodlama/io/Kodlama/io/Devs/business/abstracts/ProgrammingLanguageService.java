package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	void add(ProgrammingLanguage programmingLanguage)throws Exception;
	void delete (int id) throws Exception;
	void update(ProgrammingLanguage programmingLanguage) throws Exception;
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getProgrammingLanguageById(int id);
}
