package models.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseModelDataPOST {

    String name;
    String salary;
    String age;
    String id;
}
