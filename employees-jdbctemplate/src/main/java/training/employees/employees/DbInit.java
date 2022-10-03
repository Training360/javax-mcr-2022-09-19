package training.employees.employees;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Component
@AllArgsConstructor
public class DbInit implements CommandLineRunner {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.update("""
                create table employees (
                    id bigint auto_increment,
                    emp_name varchar(255),
                    year_of_birth bigint,
                    primary key (id)
                )
                """);
    }
}
