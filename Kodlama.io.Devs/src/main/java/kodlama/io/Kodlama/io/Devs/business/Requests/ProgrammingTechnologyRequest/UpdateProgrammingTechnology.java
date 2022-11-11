package kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingTechnologyRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UpdateProgrammingTechnology {
	
	private int id;
	private String name;
	private int programmingLanguageId;
}
