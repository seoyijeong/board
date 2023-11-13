package com.some.boardproject.entity;


//import com.some.boardproject.dto.CommentDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "comment_table")
@NoArgsConstructor
public class CommentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column
    private String commentContents;

    /* Board:Comment = 1:N */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_num")
    private Board boardEntity;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "parent_id")
//    private CommentEntity parent;
//
//    @OneToMany(mappedBy = "parent", orphanRemoval = true)
//    private List<CommentEntity> children = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user;




//    @Builder
//    public CommentEntity(Long commentId, String commentContents, Board board){
//        this.commentId = commentId;
//        this.commentContents = commentContents;
//        this.boardEntity = board;
//    }
//
//    public CommentDTO toCommentDTO(){
//        return CommentDTO.builder()
//                .id(id)
//                .commentWriter(commentWriter)
//                .commentContents(commentContents)
//                .commentEntity(this)
//                .build();
//    }

}
