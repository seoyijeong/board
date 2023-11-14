package com.some.boardproject.entity;



import com.some.boardproject.type.member.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Data // @Getter. @Setter, @ToString, @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {


    @Column(nullable = false, length = 50)
    private String userId;

    //primarykey는 nullable,length지정 안해줌
    @Id
    //null값이 들어올때 자동 increment해줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;


    @Column(nullable = false, length = 50)
    private String userName;

    @Column(nullable = false,length = 200)
    private String userPw;

    @Column(nullable = false, length = 100)
    private String userEmail;

    @Column(nullable = false, length = 50)
    private String userTel;

    @Column(nullable = true, length = 20)
    private String userGender;

    @Column
    private Date userBirthday;

    @Column
    private String userGrade;

    //enum 이름값을 DB에 저장
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @CreationTimestamp // 현재 시간이 기본값으로 등록되도록 설정(회원가입 날짜 자동등록)
    private Timestamp createDate;

    //랜덤채팅시 랜덤으로 id지정
    //랜덤으로 id지정
//    @Column(name = "user_uuid", nullable = false)
//    private String userUUID;
//
//    선택적 수명 주기 이벤트를 지정,새로운 Entity에 대해 persist가 호출되기 전
//    @PrePersist
//    public void generateUUID() {
//        if (userUUID == null) {
//            userUUID = UUID.randomUUID().toString();
//        }
//    }


}
