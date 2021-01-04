package com.learnreactivespring.repository;

import com.learnreactivespring.document.Item;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import java.util.List;

@DataMongoTest
@RunWith(SpringRunner.class)
@DirtiesContext
public class EmployeeRepositoryTest {


    public interface ItemReactiveRepository extends ReactiveMongoRepository<Employee,String> {

        Mono<Item> findByDescription(String description);
    }

    public class Employee {

        @Id
        private String employeeId;
        private String firstName;
        private String lastName;
        private List<EmployeeAddress> employeeAddressList;

        private class EmployeeAddress {
            @Id
            private String employeeAddressId;
            private String city;
            private String state;
            private String country;
            private String employeeId;

        }
    }

}
