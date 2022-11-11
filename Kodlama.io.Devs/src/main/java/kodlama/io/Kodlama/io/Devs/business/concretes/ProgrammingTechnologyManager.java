package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingTechnologyRequest.CreateProgrammingTechnology;
import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingTechnologyRequest.DeleteProgrammingTechnology;
import kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingTechnologyRequest.UpdateProgrammingTechnology;
import kodlama.io.Kodlama.io.Devs.business.Responses.ProgrammingTechnologyResponse.GetListProgrammingTechnology;
import kodlama.io.Kodlama.io.Devs.business.Responses.ProgrammingTechnologyResponse.GetProgrammingTechnologyById;
import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingTechnologyService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingTechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.ProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.entities.ProgrammingTechnology;

@Service
public class ProgrammingTechnologyManager implements ProgrammingTechnologyService {

	@Autowired
	private ProgrammingTechnologyRepository programmingTechnologyRepository;
	
	@Autowired
	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Override
	public void add(CreateProgrammingTechnology createProgrammingTechnology) throws Exception {
		if(createProgrammingTechnology.getName().isBlank()) {
			throw new Exception("İsim alanı boş geçilemez");
		}
		if(isNameExist(createProgrammingTechnology.getName())) {
			throw new Exception("Bu isimde bir programlama teknolojisi mevcut");
		}
		ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
		
		ProgrammingLanguage language = programmingLanguageRepository.findById(createProgrammingTechnology.getProgrammingLanguageId());
		programmingTechnology.setName(createProgrammingTechnology.getName());
		programmingTechnology.setProgrammingLanguage(language);
	
		
		programmingTechnologyRepository.save(programmingTechnology);
		
	}

	@Override
	public void delete(DeleteProgrammingTechnology deleteProgrammingTechnology) throws Exception {
		if(!isIdExist(deleteProgrammingTechnology.getId())) {
			throw new Exception("Silinecek objenin id'si bulunamadı");
			}
		ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
		programmingTechnology.setId(deleteProgrammingTechnology.getId());
		
		programmingTechnologyRepository.delete(programmingTechnology);
		
	}
			
	

	@Override
	public void update(UpdateProgrammingTechnology updateProgrammingTechnology) throws Exception {
		if(isIdExist(updateProgrammingTechnology.getId())) {
			throw new Exception("Silinecek objenin id'si bulunamadı");
		}
		ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(updateProgrammingTechnology.getProgrammingLanguageId());
		programmingTechnology.setId(updateProgrammingTechnology.getId());
		programmingTechnology.setName(updateProgrammingTechnology.getName());
		programmingTechnology.setProgrammingLanguage(programmingLanguage);
		
		programmingTechnologyRepository.save(programmingTechnology);
	}

	@Override
	public List<GetListProgrammingTechnology> getAll() {
		List<ProgrammingTechnology> programmingTechnologies = programmingTechnologyRepository.findAll();
		List<GetListProgrammingTechnology> getListProgrammingTechnologiesResponse = new ArrayList<>();
		
		for (ProgrammingTechnology pt : programmingTechnologies) {
			GetListProgrammingTechnology programmingTechnologyResponseItem = new GetListProgrammingTechnology();
			programmingTechnologyResponseItem.setId(pt.getId());
			programmingTechnologyResponseItem.setName(pt.getName());
			
			getListProgrammingTechnologiesResponse.add(programmingTechnologyResponseItem);
		}
		
		return getListProgrammingTechnologiesResponse;
	}

	@Override
	public GetProgrammingTechnologyById getProgrammingTechnologyId(int id) throws Exception {
		if(!isIdExist(id)) {
			throw new Exception("Id bulunamadı");
		}
		
		ProgrammingTechnology result = programmingTechnologyRepository.findById(id);
		GetProgrammingTechnologyById getProgrammingTechnologyById = new GetProgrammingTechnologyById();
		
		getProgrammingTechnologyById.setName(result.getName());
		getProgrammingTechnologyById.setId(result.getId());
		getProgrammingTechnologyById.setProgrammingLanguageId(result.getProgrammingLanguage().getId());
		getProgrammingTechnologyById.setProgrammingLanguageName(result.getProgrammingLanguage().getName());
		
		return getProgrammingTechnologyById;
	}

	private boolean isNameExist(String name) {
		for (ProgrammingTechnology p1 : programmingTechnologyRepository.findAll()) {
			if (p1.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	private boolean isIdExist(int id) {
		for (ProgrammingTechnology p1 : programmingTechnologyRepository.findAll()) {
			if (p1.getId() == id) {
				return true;
			}
		}
		return false;
	}

	private boolean isIdNotExist(int id) {
		for (ProgrammingTechnology p1 : programmingTechnologyRepository.findAll()) {
			if (p1.getId() == id) {
				return false;
			}
		}
		return true;
	}

	
}
