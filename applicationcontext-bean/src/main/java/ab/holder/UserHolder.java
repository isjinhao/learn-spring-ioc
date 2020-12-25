package ab.holder;

import sic.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author ISJINHAO
 * @Date 2020/12/6 19:05
 */
@Getter
@Setter
@ToString
public class UserHolder {

    private String id;

    private User user;

    private User anotherUser;

    public UserHolder(User user) {
        this.user = user;
    }

}
