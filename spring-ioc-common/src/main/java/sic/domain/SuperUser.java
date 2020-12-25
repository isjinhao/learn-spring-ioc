package sic.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuperUserAnnotation
@Setter
@Getter
@ToString
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

}
