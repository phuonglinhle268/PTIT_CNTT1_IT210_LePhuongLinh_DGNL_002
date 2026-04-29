package org.example.java_web_dgnl1_002.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "artifacts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Artifact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 150, message = "Tiêu đề chỉ từ 5-150 kí tự")
    @NotBlank(message = "Tiêu đề không được để trống")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Nguồn gốc không được để trống")
    @Column(name = "origin")
    private String origin;

    @NotNull(message = "Thời điểm tiếp nhận không được để trống")
    @PastOrPresent(message = "Ngày không được là ngày trong tương lai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;
}
