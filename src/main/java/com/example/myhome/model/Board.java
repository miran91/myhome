package com.example.myhome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2, max=30, message = "제목은 2-30 자 사이입니다.")
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore // json 데이터에 해당 프로퍼티는 null로 들어가게 된다. 즉, 데이터에 아예 포함이 안되게 된다.
    private User user;
}
