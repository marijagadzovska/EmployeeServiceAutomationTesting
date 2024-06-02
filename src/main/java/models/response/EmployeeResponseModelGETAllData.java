package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseModelGETAllData {

    int id;
    String employee_name;
    int employee_salary;
    int employee_age;
    String profile_image;
    String status;
}
