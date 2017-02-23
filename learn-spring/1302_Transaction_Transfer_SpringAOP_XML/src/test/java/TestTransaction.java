import com.liuhy.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuhy on 2017/2/22.
 */
public class TestTransaction {

    @Test
    public void testTransfer() {
        String path = "beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);

        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.transfer("liu", "ma", 1000);
    }
}
