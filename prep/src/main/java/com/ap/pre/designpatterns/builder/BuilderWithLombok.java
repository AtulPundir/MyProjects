package com.ap.pre.designpatterns.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BuilderWithLombok {

    private final String name;

    private final String surname;

    public static void main(String[] args) {
        BuilderWithLombok obj = BuilderWithLombok.builder().name("Atul").build();

        System.out.println("Name : "+ obj.name);
        

    }

}
