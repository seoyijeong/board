package com.some.boardproject.member;

import com.some.boardproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    // SQL => JPQL => 쿼리메서드
    // find + 엔티티명 + By + 변수명 ==> findUserByUsername
    // 엔티티명은 생략가능 : findByUsername

    // SELECT * FROM users WHERE username = ?1;
    Optional<User> findById(String id);

    // admin 제외 user만
    @Query("SELECT u FROM User u WHERE u.role = 'USER'")
    List<User> findUserList();
}
