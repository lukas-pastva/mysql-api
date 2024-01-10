package api.web.devopsterraform;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

@Data
public class DevopsTerraformDto {

	@ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, notes = "ID ")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String id;


			@ApiModelProperty(required = true, notes = "disk", example = "Foo Bar")
			@Length(max = 2048)
			private String disk;
		
			@ApiModelProperty(required = true, notes = "machine_type", example = "Foo Bar")
			@Length(max = 2048)
			private String machine_type;
		
			@ApiModelProperty(required = true, notes = "branch", example = "Foo Bar")
			@Length(max = 2048)
			private String branch;
		
			@ApiModelProperty(required = true, notes = "tags", example = "Foo Bar")
			@Length(max = 2048)
			private String tags;
		
			@ApiModelProperty(required = true, notes = "customer", example = "Foo Bar")
			@Length(max = 2048)
			private String customer;
		
			@ApiModelProperty(required = true, notes = "image", example = "Foo Bar")
			@Length(max = 2048)
			private String image;
		
			@ApiModelProperty(required = true, notes = "script", example = "Foo Bar")
			@Length(max = 2048)
			private String script;
		
			@ApiModelProperty(required = true, notes = "cloudflare_type", example = "Foo Bar")
			@Length(max = 2048)
			private String cloudflare_type;
		
			@ApiModelProperty(required = true, notes = "gl_token", example = "Foo Bar")
			@Length(max = 2048)
			private String gl_token;
		
			@ApiModelProperty(required = true, notes = "gl_project", example = "Foo Bar")
			@Length(max = 2048)
			private String gl_project;
		
			@ApiModelProperty(required = true, notes = "gl_trigger", example = "Foo Bar")
			@Length(max = 2048)
			private String gl_trigger;

			@ApiModelProperty(required = true, notes = "tf_workspace", example = "Foo Bar")
			@Length(max = 2048)
			private String tf_workspace;
		
}