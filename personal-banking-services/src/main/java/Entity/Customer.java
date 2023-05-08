package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Integer customerId;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private Date dateBecameCustomer;
    private String login;
    private String password;
    private String otherDetails;
    private String customerTypesCode;

}
