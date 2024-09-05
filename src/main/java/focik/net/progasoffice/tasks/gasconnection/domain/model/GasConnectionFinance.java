package focik.net.progasoffice.tasks.gasconnection.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import focik.net.progasoffice.tasks.finance.domain.model.Cost;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GasConnectionFinance {

    private BigDecimal financeInventoryAmount;//finanse_inwentaryzacja_kwota
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate financeInventoryDate;//finanse_inwentaryzacja_data

    private BigDecimal financeProjectAmount;//finanse_projekt_kwota
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate financeProjectDate;//finanse_projekt_data

    private BigDecimal financeRoadPastureAmount;//finanse_pas_drogowy_kwota
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate financeRoadPastureDate;//finanse_pas_drogowy_data

    private List<Cost> costList;
}
