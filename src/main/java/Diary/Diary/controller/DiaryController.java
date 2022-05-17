package Diary.Diary.controller;

import Diary.Diary.entity.Diary;
import Diary.Diary.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @GetMapping("/")
    public String getMain(){
        return "main";
    }

    @GetMapping("/messageUpdate")
    public String getUpdateAlert(Model model){
        model.addAttribute("message", "게시글의 수정은 게시글 상세 페이지에서 이용할 수 있습니다.");
        model.addAttribute("searchUrl", "/");
        return "message";
    }

    @GetMapping("/messageDelete")
    public String getDeleteAlert(Model model){
        model.addAttribute("message", "게시글의 삭제는 게시글 상세 페이지에서 이용할 수 있습니다.");
        model.addAttribute("searchUrl", "/");
        return "message";
    }

    @GetMapping("/write")
    public String getWritingForm(){
        return "write";
    }

    @PostMapping("/writePro")
    public String saveWriting(Diary diary, Model model){
        diaryService.write(diary);
        model.addAttribute("message", "글 작성이 완료되었습니다. ");
        model.addAttribute("searchUrl", "/list");
        return "message";
    }

    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("list", diaryService.list());
        return "list";
    }

    @GetMapping("/view/{id}")
    public String diaryView(Model model, @PathVariable("id") Integer id){
        model.addAttribute("diary", diaryService.diaryView(id));
        return "view";
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(Model model, @PathVariable("id") Integer id){
        model.addAttribute("diary", diaryService.diaryView(id));
        return "update";
    }

    @PostMapping("/updatePro/{id}")
    public String saveUpdate(Model model, Diary diary, @PathVariable("id") Integer id){
        Diary tmp = diaryService.diaryView(id);
        tmp.setTitle(diary.getTitle());
        tmp.setContent(diary.getContent());
        diaryService.write(tmp);
        model.addAttribute("message", "글 수정이 완료되었습니다. ");
        model.addAttribute("searchUrl", "/list");
        return "message";
    }

    @GetMapping("/delete")
    public String deleteDiary(Model model, Integer id){
        diaryService.delete(id);
        model.addAttribute("message", "글 삭제가 완료되었습니다. ");
        model.addAttribute("searchUrl", "/list");
        return "message";
    }





}
