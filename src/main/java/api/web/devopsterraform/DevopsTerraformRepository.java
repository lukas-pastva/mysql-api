package api.web.devopsterraform;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevopsTerraformRepository extends JpaRepository<DevopsTerraformModel, Long> {

}