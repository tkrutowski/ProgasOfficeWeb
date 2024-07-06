package focik.net.progasoffice.customers.domain.model;

import focik.net.progasoffice.addresses.domain.Address;
import focik.net.progasoffice.share.ActiveStatus;

public class Customer {
    private int id;
    private String Name;
    private Address address;
    private String Nip;
    private String Phone;
    private String Fax;
    private String Mail;
    private String Info;
    private ActiveStatus activeStatus;
    private String firstName;
}
