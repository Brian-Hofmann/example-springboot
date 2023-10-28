package org.example.sboot.domain;

import io.ebean.annotation.History;
import io.ebean.annotation.NotNull;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@History
@Table(name = "my_entity")
public class MyEntity extends BaseModel {

    @NotNull
    private String stringProperty;

    public MyEntity(String stringProperty) {
        this.stringProperty = stringProperty;
    }

    public String getStringProperty() {
        return stringProperty;
    }

    public void setStringProperty(String stringProperty) {
        this.stringProperty = stringProperty;
    }
}
