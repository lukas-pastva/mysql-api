package api.web.devopsterraform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "devopsTerraform")
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor

public class DevopsTerraformModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

			@Length(max = 2048)
			@NotBlank
			private String disk;
		
			@Length(max = 2048)
			@NotBlank
			private String machine_type;
		
			@Length(max = 2048)
			@NotBlank
			private String branch;
		
			@Length(max = 2048)
			@NotBlank
			private String tags;
		
			@Length(max = 2048)
			@NotBlank
			private String customer;
		
			@Length(max = 2048)
			@NotBlank
			private String image;
		
			@Length(max = 2048)
			@NotBlank
			private String script;
		
			@Length(max = 2048)
			@NotBlank
			private String cloudflare_type;
		
			@Length(max = 2048)
			@NotBlank
			private String gl_token;
		
			@Length(max = 2048)
			@NotBlank
			private String gl_project;
		
			@Length(max = 2048)
			@NotBlank
			private String gl_trigger;

			@Length(max = 2048)
			@NotBlank
			private String tf_workspace;
}