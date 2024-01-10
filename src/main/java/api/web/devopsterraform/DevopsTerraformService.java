package api.web.devopsterraform;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DevopsTerraformService {

	private final DevopsTerraformRepository repository;

	@Autowired
	public DevopsTerraformService(DevopsTerraformRepository repository) {
		this.repository = repository;
	}

	public DevopsTerraformModel findById(Long id) throws DevopsTerraformNotFoundException {
		return repository.findById(id).orElseThrow(() -> new DevopsTerraformNotFoundException(String.format("No data found for given id: %s", id)));
	}

	public List<DevopsTerraformModel> getAll() {
		return repository.findAll();
	}

	public DevopsTerraformModel save(DevopsTerraformModel model) {
		return repository.save(model);
	}

	public void delete(Long id) throws DevopsTerraformNotFoundException {
		DevopsTerraformModel model = repository.findById(id).orElseThrow(() -> new DevopsTerraformNotFoundException(String.format("No data found for given id: %s", id)));
		repository.delete(model);
	}

	public DevopsTerraformModel updateById(Long id, DevopsTerraformModel modelData) throws DevopsTerraformNotFoundException {

		DevopsTerraformModel model = repository.findById(id).orElseThrow(() -> new DevopsTerraformNotFoundException(String.format("No data found for given id: %s", id)));
		 
		

			model.setDisk(modelData.getDisk());
			model.setMachine_type(modelData.getMachine_type());
			model.setBranch(modelData.getBranch());
			model.setTags(modelData.getTags());
			model.setCustomer(modelData.getCustomer());
			model.setImage(modelData.getImage());
			model.setScript(modelData.getScript());
			model.setCloudflare_type(modelData.getCloudflare_type());
			model.setGl_token(modelData.getGl_token());
			model.setGl_project(modelData.getGl_project());
			model.setGl_trigger(modelData.getGl_trigger());
			model.setTf_workspace(modelData.getTf_workspace());
		
		repository.save(model);
		return model;
	}
}