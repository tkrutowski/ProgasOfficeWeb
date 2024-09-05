package focik.net.progasoffice.finance.InvoiceCorrection.infastructure.dto;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class InvoiceCorrectionId implements Serializable {
    private Integer idInvoiceCorrectionNumber;
    private Integer idInvoiceCorrectionYear;
}
