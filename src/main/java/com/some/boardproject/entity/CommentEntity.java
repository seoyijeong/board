package com.some.boardproject.entity;


import com.some.boardproject.dto.CommentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "commnet_table")
@NoArgsConstructor
public class CommentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column
    private String commentContents;

    /* Board:Comment = 1:N */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board boardEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private CommentEntity parent;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<CommentEntity> children = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;




//    @Builder
//    public CommentEntity(Long id, String commentWriter, String commentContents, BoardEntity boardEntity){
//        this.id = id;
//        this.commentWriter = commentWriter;
//        this.commentContents = commentContents;
//        this.boardEntity = boardEntity;
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
