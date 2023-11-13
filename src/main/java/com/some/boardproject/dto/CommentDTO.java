package com.some.boardproject.dto;



import com.some.boardproject.entity.Board;
import com.some.boardproject.entity.CommentEntity;
import com.some.boardproject.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CommentDTO {
    private Long commentId;
    private String commentContents;
    private LocalDateTime commentCreatedTime;
    private LocalDateTime commentUpdatedTime;
    private Board boardEntity;
    private Long boardId;
    private Long userNo;
    private CommentEntity parent;
    private List<CommentEntity> children;

//    @Builder
//    public CommentDTO(Long id, String commentWriter, String commentContents, CommentEntity commentEntity){
//        this.id = id;
//        this.commentWriter = commentWriter;
//        this.commentContents = commentContents;
//        this.boardId = commentEntity.getBoardEntity().getId();
//        this.commentCreatedTime =  commentEntity.getCreatedTime();
//    }
//
//    public CommentEntity toCommentEntity(){
//        return CommentEntity.builder()
//                .id(id)
//                .commentWriter(commentWriter)
//                .commentContents(commentContents)
//                .boardEntity(boardEntity)
//                .build();
//    }

    public static CommentDTO toCommentDTO(CommentEntity commentEntity, Long boardId, Long userNo) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentId(commentEntity.getCommentId());
        commentDTO.setCommentContents(commentEntity.getCommentContents());
        commentDTO.setCommentCreatedTime(commentEntity.getCreatedTime());
        commentDTO.setCommentUpdatedTime(commentEntity.getUpdatedTime());
//        commentDTO.setBoardId(commentEntity.getBoardEntity().getId()); // 이 경우 Service 메소드에 @Transactional
        commentDTO.setBoardId(boardId);
//        commentDTO.setUserNo(userNo);
        commentDTO.setUserNo(commentEntity.getUser().getUserNo());
        return commentDTO;
    }

    public static CommentEntity toSaveEntity(CommentDTO commentDTO, Board boardEntity, User user) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentContents(commentDTO.getCommentContents());
        commentEntity.setBoardEntity(boardEntity);
        commentEntity.setUser(user);
        return commentEntity;
    }
}
