package com.example.demo.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BeerRequestModel {
    @NotBlank
    @Length(min = 3,max = 14,message = "name must be between 3 to 14 char long")
    private  String beerName;
    @Range(min = 9,max = 100,message = "Rate Per Unit Must between 9 to 100")
    private Double ratePerUnit;
}
