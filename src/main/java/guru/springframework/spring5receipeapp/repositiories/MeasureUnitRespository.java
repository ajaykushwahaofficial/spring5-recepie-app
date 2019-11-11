package guru.springframework.spring5receipeapp.repositiories;

import guru.springframework.spring5receipeapp.domain.MeasureUnit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MeasureUnitRespository extends CrudRepository<MeasureUnit,Long> {
    Optional<MeasureUnit> findByDescription(String description);
}
