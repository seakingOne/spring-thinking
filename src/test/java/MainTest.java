import com.ynhuang.thinking.ThinkingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ThinkingApplication.class)
@RunWith(SpringRunner.class)
public class MainTest {

    @InjectMocks
    private com.ynhuang.thinking.awire.Test test;

    @Test
    public void test1() {
        test.test1();
        int [] arr = new int[]{1};
    }

}
