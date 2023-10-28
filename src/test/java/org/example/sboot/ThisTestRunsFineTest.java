package org.example.sboot;

import io.ebean.DB;
import io.ebean.test.UserContext;
import org.example.sboot.domain.MyEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThisTestRunsFineTest {

    @Test
    public void testSave() {
        UserContext.set("testUser", "1");
        DB.save(new MyEntity("Property"));
        Assertions.assertNotNull(DB.find(MyEntity.class, 1));
    }

}
