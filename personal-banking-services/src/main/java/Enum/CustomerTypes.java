package Enum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum CustomerTypes {

    Minors("MN"),
    Illitrates("ILT"),
    Married_Women("MRDW"),
    Joint_Account_Holder("JAH"),
    PartnerShips("PS");
    String value;

    CustomerTypes(String value){
        this.value = value;
    }


}
