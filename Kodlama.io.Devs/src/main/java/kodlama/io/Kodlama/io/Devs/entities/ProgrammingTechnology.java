package kodlama.io.Kodlama.io.Devs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Programming_technologies")
public class ProgrammingTechnology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Programming_technology_id")
	private int id;

	@Column(name = "programming_technology_name")
	private String name;

	@ManyToOne()
	@JoinColumn(name = "programming_language_id")
	private ProgrammingLanguage programmingLanguage;
	

	
}
