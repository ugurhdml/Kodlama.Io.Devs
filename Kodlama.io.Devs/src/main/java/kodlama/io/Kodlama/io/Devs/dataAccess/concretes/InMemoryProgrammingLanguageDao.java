package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
//import kodlama.io.Kodlama.io.Devs.entities.ProgrammingLanguage;
//
//@Repository
//public class InMemoryProgrammingLanguageDao implements ProgrammingLanguageRepository {
//	List<ProgrammingLanguage> programmingLanguages;
//
//	public InMemoryProgrammingLanguageDao() {
//		programmingLanguages = new ArrayList<ProgrammingLanguage>();
//		programmingLanguages.add(new ProgrammingLanguage(1, "Python"));
//		programmingLanguages.add(new ProgrammingLanguage(2, "R"));
//		programmingLanguages.add(new ProgrammingLanguage(3, "C#"));
//	}
//
//	@Override
//	public void save(ProgrammingLanguage programmingLanguage) {
//
//		programmingLanguages.add(programmingLanguage);
//	}
//
//	@Override
//	public void delete(int id) {
//		programmingLanguages.removeIf(PL -> PL.getId() == id);
//
//	}
//
//	@Override
//	public void modify(ProgrammingLanguage programmingLanguage)  {
//
//		for (ProgrammingLanguage language : programmingLanguages) {
//			if (language.getId() == programmingLanguage.getId()) {
//				programmingLanguages.set(language.getId() - 1, programmingLanguage);
//			}
//		}
//	}
//
//	@Override
//	public List<ProgrammingLanguage> getList() {
//		return programmingLanguages;
//	}
//
//	@Override
//	public ProgrammingLanguage getById(int id) {
//		return programmingLanguages.get(id - 1);
//	}

//}
