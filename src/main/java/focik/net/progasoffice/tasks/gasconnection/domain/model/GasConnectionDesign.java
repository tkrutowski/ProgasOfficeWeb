package focik.net.progasoffice.tasks.gasconnection.domain.model;

import java.time.LocalDate;

class GasConnectionDesign {
    //ETAP 1
    private LocalDate ZlecenieProjektuDataZlozenia ;
    private LocalDate ZlecenieProjektuDataPotwierdzenia ;
    private LocalDate PelnomocnictwoDataZlozenia ;
    private LocalDate PelnomocnictwoDataOtrzymania;
    private LocalDate MapaDataZlozenia ;
    private LocalDate MapaDataOtrzymania;
    private int MapeDostarczyl;
    private LocalDate WypisDataZlozenia ;
    private LocalDate WypisDataOtrzymania;
    //22.05.2020 V4.0.5.1 monika
    private int MapaGeodeta;

    //ETAP 2
    private LocalDate ZudpDataZlozenia;
    private LocalDate ZudpDataOtrzymania;
    //10.05.2019 v 3223 (monika)
    private boolean BezZud;
    private LocalDate ZakładKomunalnyDataZlozenia;
    private LocalDate ZakladKomunalnyDataOtrzymania;
    //24.05.2019 v3224
    private int IdRodzajZakladuKom;

    //ETAP 3
    private LocalDate UzgodnienieWsgDataZlozenia;
    private LocalDate UzgodnienieWsgDataOtrzymania;
    //21.05.2019 v 3223 (radek)
    private LocalDate UzgodnienieWsgDataUzg ;
    private String UzgodnienieWsgNr;
    //24.05.2019 v3224       
    private LocalDate UzgSchematuPunktuWsgDataZlozenia;
    private LocalDate UzgSchematuPunktuWsgDataOtrzymani;


    //ETAP 4
    private int IdGeodetyProjekt;
    //zamiana checkboxa na date (radek)
    private LocalDate GeodezjaDataWyslania;
    //10.2016 RADEK
    private LocalDate ProjOrgRuchuDataZlozenia;
    private LocalDate ProjOrgRuchuDataOtrzymania;
    //24.05.2019 v3224
    private boolean ProjOrgRuchu;
    //11.2016 MONIKA
    private LocalDate ZajPasaDok_dataOtrzymaniaPSG;
    private LocalDate ZajPasaDok_dataPrzek ;
    //24.05.2019 v3224
    private LocalDate ZajPasaDok_dataZlozeniaPSG;
    //nie potrzebne
    private boolean WyslanoZudGeodecie ;
    private int Etap;
    private int IdTrafficDesigner ;
    //v 4.1.4.0
    private LocalDate PunktGazowy_dataZam;
    private LocalDate PunktGazowy_dataOdb ;
    private LocalDate PunktGazowy_dataOdbDok;
    private String PunktGazowy_nrZamowienia ;
    // 17.05.2023 v4195
    private boolean BezProjOrgRuchu;
}
