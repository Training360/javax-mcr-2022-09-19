package training.employees.employees.dto;

import lombok.Data;

@Data
public class AddressDto {

    private Long id;

    private String zip;

    private String city;

    private String line1;
}
