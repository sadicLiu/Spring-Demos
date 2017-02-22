import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by liuhy on 2017/2/22.
 */
public class Test {
    PlatformTransactionManager ptm;
    DataSourceTransactionManager dtm;
    HibernateTransactionManager htm;
}
