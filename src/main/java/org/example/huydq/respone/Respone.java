package org.example.huydq.respone;

import lombok.*;
import org.example.huydq.entity.Student;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Respone {
    private String message;

    private Student student;
}
