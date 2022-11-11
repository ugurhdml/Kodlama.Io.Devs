package kodlama.io.Kodlama.io.Devs.business.Requests.ProgrammingTechnologyRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProgrammingTechnology {
	private int programmingLanguageId;
	private String name;
}
