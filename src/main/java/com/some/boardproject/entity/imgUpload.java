package com.some.boardproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(
        name = "upload_Seq_Generator",
        sequenceName = "Board_Seq", // 시퀸스 명
        initialValue = 1, // 초기 값
        allocationSize = 1 // 미리 할당 받을 시퀸스 수
)
@Table(name = "imgUpload")
        public class imgUpload {

        @Id
        private int imgTagCode;

        @Column(nullable = false, length = 50)
        private String boardCat;

        @Column(nullable = false, length = 50)
        private String id;

        @Column(nullable = false, length = 50)
        private String username;

        @Column(nullable = false, length = 100)
        private String boardTitle;

        @Column
        private String img01;
        @Column
        private String img02;
        @Column
        private String img03;
        @Column
        private String img04;
        @Column
        private String img05;
        @Column
        private String img06;
        @Column
        private String img07;
        @Column
        private String img08;
        @Column
        private String img09;
        @Column
        private String img10;


        }