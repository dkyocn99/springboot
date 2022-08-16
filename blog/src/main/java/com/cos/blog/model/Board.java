package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//suto-increment
    private int id;

    @Column(nullable = false,length = 100)
    private String title;

    @Lob
    private String content; //섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨

    @ColumnDefault("0")
    private int count;//조회수

    @ManyToOne // Many = Board, one = User
    @JoinColumn(name="userId")//필드값 userId로 들어감
    private User user; //DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.

    @CreationTimestamp
    private Timestamp createDate;
}
