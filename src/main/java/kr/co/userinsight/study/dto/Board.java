package kr.co.userinsight.study.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {

  private String title;

  private String writer;

  private LocalDateTime createDateTime = LocalDateTime.now();
}
