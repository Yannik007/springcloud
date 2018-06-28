package appConfig.springCloudDao;
/*
* @Description :
* @Date : 2018/6/26  9:25  
* */

import appConfig.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
