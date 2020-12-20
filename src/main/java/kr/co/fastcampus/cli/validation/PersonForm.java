package kr.co.fastcampus.cli.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
public class PersonForm {

    @NotBlank
    @Size(max=10)
    private String name;

    @Min(0)
    @Max(110)
    private int age;
}