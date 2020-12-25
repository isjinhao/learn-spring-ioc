package ab.holder;

import sic.domain.User;
import lombok.ToString;

/**
 * @Author ISJINHAO
 * @Date 2020/12/5 15:41
 */
@ToString
public class IgnoreInterfaceImpl implements IgnoreInterface {

    private User user;

    private User anotherUser;

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    public void setAnotherUser(User anotherUser) {
        this.anotherUser = anotherUser;
    }

    public User getUser() {
        return user;
    }

    public User getAnotherUser() {
        return anotherUser;
    }
}
