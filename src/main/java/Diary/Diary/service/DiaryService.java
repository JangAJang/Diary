package Diary.Diary.service;

import Diary.Diary.entity.Diary;
import Diary.Diary.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {
    @Autowired
    private DiaryRepository diaryRepository;
    public void write(Diary diary){
        diaryRepository.save(diary);
    }

    public List<Diary> list(){
        return diaryRepository.findAll();
    }
}
