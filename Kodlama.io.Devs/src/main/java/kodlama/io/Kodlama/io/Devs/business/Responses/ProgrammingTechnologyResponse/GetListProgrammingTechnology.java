package kodlama.io.Kodlama.io.Devs.business.Responses.ProgrammingTechnologyResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetListProgrammingTechnology {
	private int id;	
	private String name;
	private int programmingLanguageId;
	private String programmingLanguageName;
}
