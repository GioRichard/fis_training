package fis.basicauthentication.model;

import lombok.*;

@Data
@Getter@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String empNo;
    private String empName;
    private String position;

}
