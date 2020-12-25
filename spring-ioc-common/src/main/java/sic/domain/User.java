package sic.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.core.io.Resource;

import java.util.List;

/**
* @Author ISJINHAO
* @Date 2020/11/29 12:39
*/
@Setter
@Getter
@ToString
public class User {

    private Long id;

    private String name;

    private City city;

    private City[] workCities;

    private List<City> lifeCities;

    private Resource configFileLocation;

    public User(Long id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public User() {
    }

}
