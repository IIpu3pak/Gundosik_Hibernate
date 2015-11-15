import org.junit.Assert;
import org.junit.Test;
import sevices.HibernateUtil;


public class TestHibernateUtil {

    @Test
    public void getSessionFactoryTest(){

        Assert.assertNotNull(HibernateUtil.getSessionFactory());

    }
}
