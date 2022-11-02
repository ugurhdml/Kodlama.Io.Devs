package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	
	void save(ProgrammingLanguage programmingLanguage);
	void delete(int id);
	void modify(ProgrammingLanguage programmingLanguage);
	
	List<ProgrammingLanguage> getList();
	ProgrammingLanguage getById(int id);
}
