package kodlama.io.Kodlama.io.Devs.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Programming_languages")
public class ProgrammingLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "programming_language_id")
	private int id;

	@Column(name = "programming_language_name")
	private String name;
	
	@OneToMany(mappedBy = "programmingLanguage")
	private List<ProgrammingTechnology> programmingTechnologies ;
}
