package kr.co.userinsight.study.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import kr.co.userinsight.study.dto.Board;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/board")
public class ApiBoardController {

  private final List<Board> boardList = new ArrayList();

  @PostConstruct
  private void onCreate() {
    boardList.add(new Board("공지사항입니다.", "관리자", LocalDateTime.of(LocalDate.now(), LocalTime.of(13, 0))));
    boardList.add(new Board("안녕하세요?", "관리자", LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 0))));
    boardList.add(new Board("반갑습니다.", "관리자", LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 30))));
  }

  @GetMapping("")
  public ResponseEntity list() {
    return ResponseEntity.ok(boardList);
  }

  @PostMapping("")
  public ResponseEntity save(@RequestBody Board board) {
    boardList.add(board);
    return ResponseEntity.ok().build();
  }

}
