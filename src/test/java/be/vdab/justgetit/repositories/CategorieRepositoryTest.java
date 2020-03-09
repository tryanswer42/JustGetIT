package be.vdab.justgetit.repositories;

import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

@JdbcTest
@Import(CategorieRepository.class)
public class CategorieRepositoryTest {

}
