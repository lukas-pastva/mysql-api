package api.web.devopsterraform;

import api.exception.ApiRestException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/devopsterraform", produces = "application/json")
public class DevopsTerraformController {

	private final DevopsTerraformMapper mapper;
	private final DevopsTerraformService service;

	@Autowired
	public DevopsTerraformController(DevopsTerraformMapper mapper, DevopsTerraformService service) {
		this.mapper = mapper;
		this.service = service;
	}

	@ApiOperation(value = "Get list of items", response = DevopsTerraformDto.class)
	@GetMapping("/list")
	public ResponseEntity<List<DevopsTerraformDto>> getAllDevopsTerraform() {
		List<DevopsTerraformModel> itemList = service.getAll();
		List<DevopsTerraformDto> itemDtoList = mapper.mapAsList(itemList, DevopsTerraformDto.class);

		return new ResponseEntity<>(itemDtoList, HttpStatus.OK);
	}

	@ApiOperation(value = "Get item", response = DevopsTerraformDto.class)
	@GetMapping("/{id}")
	public ResponseEntity<DevopsTerraformDto> getDevopsTerraform(@ApiParam(value = "ID of item", example = "1", required = true)
																	 @PathVariable Long id) throws ApiRestException {

		DevopsTerraformModel item = service.findById(id);
		DevopsTerraformDto itemDto = mapper.map(item, DevopsTerraformDto.class);

		return new ResponseEntity<>(itemDto, HttpStatus.OK);
	}

	@ApiOperation(value = "Create item", response = DevopsTerraformDto.class)
	@PostMapping
	public ResponseEntity<DevopsTerraformDto> createDevopsTerraform(@ApiParam(value = "model", required = true)
																		@RequestBody @Valid DevopsTerraformDto dto) throws ApiRestException {

		DevopsTerraformModel item = mapper.map(dto, DevopsTerraformModel.class);
		DevopsTerraformDto itemDto = mapper.map(service.save(item), DevopsTerraformDto.class);

		return new ResponseEntity<>(itemDto, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Create list items", response = DevopsTerraformDto.class)
	@PostMapping("/list")
	public ResponseEntity<List<DevopsTerraformDto>> createDevopsTerraformList(@ApiParam(value = "List of models", required = true)
																				  @RequestBody @Valid List<DevopsTerraformDto> dtoList) throws ApiRestException {

		List<DevopsTerraformDto> itemDtoList = new ArrayList<>();

		dtoList.forEach(dto -> {
			DevopsTerraformModel item = mapper.map(dto, DevopsTerraformModel.class);
			DevopsTerraformDto itemDto = mapper.map(service.save(item), DevopsTerraformDto.class);
			itemDtoList.add(itemDto);
		});

		return new ResponseEntity<>(itemDtoList, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update item given a model", response = DevopsTerraformDto.class)
	@PutMapping("/{id}")
	public ResponseEntity<DevopsTerraformDto> updateDevopsTerraform(@ApiParam(value = "ID of item", example = "1", required = true)
																		@PathVariable Long id,
																		@ApiParam(value = "Updated model", required = true)
																		@RequestBody @Valid DevopsTerraformDto dto) throws ApiRestException {

		DevopsTerraformModel devopsTerraform = mapper.map(dto, DevopsTerraformModel.class);
		DevopsTerraformDto updatedDevopsTerraformDto = mapper.map(service.updateById(id, devopsTerraform), DevopsTerraformDto.class);

		return new ResponseEntity<>(updatedDevopsTerraformDto, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete item by given ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDevopsTerraform(@ApiParam(value = "ID of model", example = "1", required = true)
													 @PathVariable Long id) throws ApiRestException {

		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}