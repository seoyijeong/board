package com.some.boardproject.entity;

import com.some.boardproject.type.member.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(
        name = "Board_Seq_Generator",
        sequenceName = "Board_Seq",
        initialValue = 1,
        allocationSize = 1
)

@Table(name = "Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Board_Seq_Generator")
    private int boardNum;

    @Column(nullable = false, length = 50)
    private String boardCat;

    @Column(nullable = false)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="userId")
    private User user;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 100)
    private String boardTitle;

    @Column(nullable = false, length = 2000)
    private String boardContent;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @CreationTimestamp
    private Timestamp writtenDate;

    @CreationTimestamp
    private Timestamp modifiedDate;

    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Board_Seq_Generator")
    private int imgTagCode;


}