package focik.net.progasoffice.finance.invoice.infastructure.dto;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class InvoiceId implements Serializable {
    private Integer idInvoiceNumber;
    private Integer idInvoiceYear;
}
