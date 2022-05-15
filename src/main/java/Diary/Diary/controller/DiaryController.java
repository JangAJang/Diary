package Diary.Diary.controller;

import Diary.Diary.entity.Diary;
import Diary.Diary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @GetMapping("/")
    public String getMain(){
        return "main";
    }

    @GetMapping("/write")
    public String getWritingForm(){
        return "write";
    }

    @PostMapping("/writePro")
    public String saveWriting(Diary diary){
        System.out.println(diary.getTitle());
        diaryService.write(diary);
        return "list";
    }

    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("list", diaryService.list());
        return "list";
    }


}
