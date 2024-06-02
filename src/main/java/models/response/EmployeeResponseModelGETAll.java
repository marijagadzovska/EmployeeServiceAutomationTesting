package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseModelGETAll {

    String status;
    List<EmployeeResponseModelGETAllData> data;
    String message;
}
