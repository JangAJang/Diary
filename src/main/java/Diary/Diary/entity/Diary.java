package Diary.Diary.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    public Diary() {}

    public Diary makeDiary(String title, String content){
        return Diary.builder()
                .title(title)
                .content(content)
                .build();
    }
}
