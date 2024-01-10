package api.web.devopsterraform;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DevopsTerraformMapper extends ConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(DevopsTerraformModel.class, DevopsTerraformDto.class)

				.customize(new CustomMapper<>() {
					@Override
					public void mapAtoB(DevopsTerraformModel a, DevopsTerraformDto b, MappingContext context) {

			b.setDisk(a.getDisk());
			b.setMachine_type(a.getMachine_type());
			b.setBranch(a.getBranch());
			b.setTags(a.getTags());
			b.setCustomer(a.getCustomer());
			b.setImage(a.getImage());
			b.setScript(a.getScript());
			b.setCloudflare_type(a.getCloudflare_type());
			b.setGl_token(a.getGl_token());
			b.setGl_project(a.getGl_project());
			b.setGl_trigger(a.getGl_trigger());
			b.setTf_workspace(a.getTf_workspace());
					}

					@Override
					public void mapBtoA(DevopsTerraformDto b, DevopsTerraformModel a, MappingContext context) {
						
			a.setDisk(b.getDisk());
			a.setMachine_type(b.getMachine_type());
			a.setBranch(b.getBranch());
			a.setTags(b.getTags());
			a.setCustomer(b.getCustomer());
			a.setImage(b.getImage());
			a.setScript(b.getScript());
			a.setCloudflare_type(b.getCloudflare_type());
			a.setGl_token(b.getGl_token());
			a.setGl_project(b.getGl_project());
			a.setGl_trigger(b.getGl_trigger());
			a.setTf_workspace(b.getTf_workspace());
					}
				})
				.byDefault().register();
	}

}