package api.web.devopsterraform;

import api.exception.ApiRestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DevopsTerraformNotFoundException extends ApiRestException {

	public DevopsTerraformNotFoundException(String message) {
		super(message);
	}

}