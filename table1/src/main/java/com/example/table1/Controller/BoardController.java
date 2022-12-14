package com.example.table1.Controller;

import com.example.table1.entity.Board;
import com.example.table1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller

public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    public String boardWriteForm() {

        return "boardwrite";

    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board, Model model, MultipartFile file)throws Exception {


        boardService.write(board,file);

        model.addAttribute("message","글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl","/board/list");




        return "message";
    }

    @GetMapping("/board/list")

    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList());
        // list라는 이름으로 넘길거야, 뭘 담아서? boardService의 boardList
        return "boardList";
    }

    @GetMapping("/board/view") // localhost:8080/board/view?id=1 (get방식) id 값으로 접근함
    public String boardView(Model model, Integer id) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelte(Integer id) {
        boardService.boardDelete(id);

        return "redirect:/board/list";
    }
    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id,
                              Model model){
        model.addAttribute("board",boardService.boardView(id));

        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id,Board board,MultipartFile file) throws Exception{

        Board boardTemp=boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp,file);

        return "redirect:/board/list";

    }




    @GetMapping("https://dongdongtest.run.goorm.io/")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        System.out.println("hihihihihihihihihihi");
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}