package kodlama.io.Kodlama.io.Devs.business.Responses.ProgrammingTechnologyResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProgrammingTechnologyById {
	private int id;
	private String name;
	private int programmingLanguageId;
	private String programmingLanguageName;
}
