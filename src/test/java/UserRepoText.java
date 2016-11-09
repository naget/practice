import com.tf.Repository.UserRepo;
import com.tf.Springboot;
import com.tf.server.ServerImp.UserServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by t on 2016/10/24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Springboot.class)
@WebAppConfiguration
public class UserRepoText {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserServer userServer;
    @Test
    public void userRepoText() throws Exception
    {
        System.out.println(userRepo.findByName("tianf").toString());
       // userRepo.findAll();

//        userRepo.save(user);
        //user.setId(1);
    }
}
