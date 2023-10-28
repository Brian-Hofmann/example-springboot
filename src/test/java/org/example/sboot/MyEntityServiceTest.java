package org.example.sboot;

import io.ebean.test.UserContext;
import org.example.sboot.domain.MyEntity;
import org.example.sboot.service.MyEntityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyEntityServiceTest {

    @Autowired
    MyEntityService myEntityService;

    @Test
    public void testSave() {
        UserContext.set("testUser", "1");
        /* This will fail because the user context is not set right. Instead of pulling from test application properties,
           it pulls from the application properties which has a different property set for "testing". Also, this test runs the
           Ebean Configuration file which seems to be caused by the @SpringBootTest annotation. The other test "ThisTestRunsFineTest" does not.

           I would expect this to run on the docker container like the working test does, but instead I see it trying to pull values from the
           application.properties file which causes it to save to try and save to my local DB.
         */
        MyEntity savedEntity = this.myEntityService.saveEntity(new MyEntity("Test Property"));
        Assertions.assertNotNull(savedEntity.getWhoCreated());
    }

}
