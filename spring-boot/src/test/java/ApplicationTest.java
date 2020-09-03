import com.hujingli.Application;
import com.hujingli.spring.ioc.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author huh20
 * @since
 */
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private User user;

    @Test
    public void test(){
        System.out.println(user);
    }

}
