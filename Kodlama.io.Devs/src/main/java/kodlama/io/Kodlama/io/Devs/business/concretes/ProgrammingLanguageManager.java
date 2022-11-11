package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingLanguageRequest.CreateProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingLanguageRequest.DeleteProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingLanguageRequest.UpdateProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.business.Responses.ProgrammingLanguageResponse.GetListProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.business.Responses.ProgrammingLanguageResponse.GetProgrammingLanguageById;
import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(CreateProgrammingLanguage createProgrammingLanguage) throws Exception {
		if (createProgrammingLanguage.getName().isBlank()) {
			throw new Exception("Programlama dili ismi boş geçilemez!!");
		}
		if (isNameExist(createProgrammingLanguage.getName())) {
			throw new Exception("Bu isimde bir programlama dili mevcut");
		}
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguage.getName());
		programmingLanguageRepository.save(programmingLanguage);

	}

	@Override
	public void delete(DeleteProgrammingLanguage deleteProgrammingLanguage) throws Exception {
		if (!isIdExist(deleteProgrammingLanguage.getId())) {
			throw new Exception("Bu idye sahip bir kayıt bulunamadı.");
		}
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setId(deleteProgrammingLanguage.getId());
		programmingLanguageRepository.delete(programmingLanguage);
	}

	@Override
	public void update(UpdateProgrammingLanguage updateProgrammingLanguage) throws Exception {
		if (isNameExist(updateProgrammingLanguage.getName())) {
			throw new Exception("Güncellemeye çalıştığınız isimde bir kayıt zaten mevcut!!");

		}
		if (isIdNotExist(updateProgrammingLanguage.getId())) {
			throw new Exception("Girdiğiniz id'ye sahip bir kayıt bulunamadı.");
		}
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setId(updateProgrammingLanguage.getId());
		programmingLanguage.setName(updateProgrammingLanguage.getName());
		programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public List<GetListProgrammingLanguage> getAll() {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetListProgrammingLanguage> getListProgrammingLanguagesResponse = new ArrayList<>();

		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetListProgrammingLanguage programingLanguageResponseItem = new GetListProgrammingLanguage();
			programingLanguageResponseItem.setId(programmingLanguage.getId());
			programingLanguageResponseItem.setName(programmingLanguage.getName());
			getListProgrammingLanguagesResponse.add(programingLanguageResponseItem);

		}

		return getListProgrammingLanguagesResponse;
	}

	@Override
	public GetProgrammingLanguageById getProgrammingLanguageById(int id) throws Exception {
		if (!isIdExist(id)) {
			throw new Exception("Id bulunamadı");

		}
			ProgrammingLanguage result = programmingLanguageRepository.findById(id);
			GetProgrammingLanguageById getProgrammingLanguageById = new GetProgrammingLanguageById();
			getProgrammingLanguageById.setId(result.getId());
			getProgrammingLanguageById.setName(result.getName());
			
		return getProgrammingLanguageById;
	}

	private boolean isNameExist(String name) {
		for (ProgrammingLanguage p1 : programmingLanguageRepository.findAll()) {
			if (p1.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	private boolean isIdExist(int id) {
		for (ProgrammingLanguage p1 : programmingLanguageRepository.findAll()) {
			if (p1.getId() == id) {
				return true;
			}
		}
		return false;
	}

	private boolean isIdNotExist(int id) {
		for (ProgrammingLanguage p1 : programmingLanguageRepository.findAll()) {
			if (p1.getId() == id) {
				return false;
			}
		}
		return true;
	}
}