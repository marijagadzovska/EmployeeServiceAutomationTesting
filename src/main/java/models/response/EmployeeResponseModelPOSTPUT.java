package models.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseModelPOSTPUT {

    String status;
    EmployeeResponseModelDataPOST data;
    String message;
}
