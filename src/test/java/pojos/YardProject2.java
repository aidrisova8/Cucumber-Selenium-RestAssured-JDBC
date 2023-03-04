package pojos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class YardProject2 {


    private Integer id;
    private String location;
    private String name;
    private String status;
    private String address;
    private Integer apt_suite_company_co;
    private String city;
    private String state;
    private Integer zip_code;
    private Integer spots;
    private Object [] contacts;
}
