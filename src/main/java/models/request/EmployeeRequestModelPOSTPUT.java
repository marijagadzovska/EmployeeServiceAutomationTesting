package models.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeRequestModelPOSTPUT {
    String name;
    String salary;
    String age;
}
