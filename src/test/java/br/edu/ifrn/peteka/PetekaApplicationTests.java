package br.edu.ifrn.peteka;

import br.edu.ifrn.peteka.PetekaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author duartemac
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PetekaApplication.class)
@WebAppConfiguration
public class PetekaApplicationTests {

	@Test
	public void contextLoads() {
	}

}
