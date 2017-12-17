package com.tzj.sanguo.appium.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by clint on 2017/12/16.
 */
@Entity
public class Version implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String version;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
