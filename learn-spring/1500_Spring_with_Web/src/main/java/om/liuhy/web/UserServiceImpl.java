package om.liuhy.web;


/**
 * Created by liuhy on 2017/2/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    @Qualifier("userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser() {
        userDao.save();
    }

}
