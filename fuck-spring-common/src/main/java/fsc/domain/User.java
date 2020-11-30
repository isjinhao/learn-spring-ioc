package fsc.domain;

import fsc.domain.City;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author ISJINHAO
 * @Date 2020/11/29 12:39
 */
@Component
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

}
