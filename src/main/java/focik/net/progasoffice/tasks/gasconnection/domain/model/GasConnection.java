package focik.net.progasoffice.tasks.gasconnection.domain.model;

import focik.net.progasoffice.addresses.domain.Address;
import focik.net.progasoffice.customers.domain.model.Customer;
import focik.net.progasoffice.tasks.designers.domain.model.Designer;
import focik.net.progasoffice.tasks.inspectors.domain.model.Inspector;
import org.javamoney.moneta.Money;

import java.time.LocalDate;

public class GasConnection {
    private int IdPrzylacza;
    private Designer IdProjektanta;
    private Inspector IdInspektora ;
    private Customer IdKlienta;
    private Address address;
    //nrZadania==nr zlecenia
    private String NrZadania;
    private String NrUmowy;
    private LocalDate DataUmowy;
    private LocalDate TerminWykonania;
    private Money WartoscZadania ;
    private Money WartoscProjektu ;
    private Money WartoscWykonawstwa;
    private String NrWarunkow ;
    private LocalDate DataWarunkow;
    private String Uwagi ;
    private int IdRozdzieln;
    private boolean CzyPGN ;
    private LocalDate TerminProjektu;
    //10.11.2018 v.3.2.1.5 (radek)
    private String NrUmowyPrzylaczeniowej ;
    private String NrSAP_UP ;
    private boolean CzyZakonczone;
    private int IdCoordinator ;
    //v.4.1.0.0 prezes
    private int IdCoordinatorProject;

    //v4.1.4.0
    private LocalDate TerminOdbKoncowego;
    //v4.2.0.1
    private LocalDate DataPrzyspieszenia ;

    private int IdPrzylaczaSync;
}
