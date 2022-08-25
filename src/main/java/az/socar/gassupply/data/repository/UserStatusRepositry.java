package az.socar.gassupply.data.repository;


import az.socar.gassupply.data.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatusRepositry extends JpaRepository<UserStatus,Long> {
    UserStatus findUserStatusById(Long id);
}
