package guru.springframework.spring5receipeapp.repositiories;

import guru.springframework.spring5receipeapp.domain.MeasureUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MeasureUnitRespositoryIT {

    @Autowired
    MeasureUnitRespository measureUnitRespository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() {
        Optional<MeasureUnit> measureunit=measureUnitRespository.findByDescription("TEASPOON");
        assertEquals("TEASPOON",measureunit.get().getDescription());
    }
}