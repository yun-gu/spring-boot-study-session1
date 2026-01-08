package kr.co.userinsight.study.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.PostConstruct;
import kr.co.userinsight.study.dto.Board;

@Controller
@RequestMapping("/board")
public class BoardController {

  private final List<Board> boardList = new ArrayList();

  @PostConstruct
  private void onCreate() {
    boardList.add(new Board("공지사항입니다.", "관리자", LocalDateTime.of(LocalDate.now(), LocalTime.of(13, 0))));
    boardList.add(new Board("안녕하세요?", "관리자", LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 0))));
    boardList.add(new Board("반갑습니다.", "관리자", LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 30))));
  }

  @GetMapping("")
  public String board(Model model) {
    model.addAttribute("boardList", boardList);
    return "board/list";
  }

  @GetMapping("/write")
  public String write(Model model) {
    return "board/write";
  }

  @PostMapping("/save")
  public String save() {
    // TODO: 사용자가 등록한 게시글을 저장하는 로직을 구성해보세요.
    return "redirect:/board";
  }
}
