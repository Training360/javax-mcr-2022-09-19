package training.employees.employees.dto;

import lombok.Data;

@Data
public class CreateAddressCommand {

    private String zip;

    private String city;

    private String line1;
}
