package focik.net.progasoffice.tasks.gasconnection.domain.model;

import focik.net.progasoffice.tasks.gasdistributions.domain.model.GasDistribution;

import java.time.LocalDate;

class GasConnectionBuild {
    private LocalDate ZawRozdzielniDataZlozenia;
    private LocalDate RealizacjaDataRozpoczecia;
    private LocalDate RealizacjaDataZakonczenia ;
    private LocalDate GeodezjaSzkice ;
    private LocalDate GeodezjaInwentaryzacja;

    private LocalDate OdbiorWsgTechniczny ;
    private String OdbiorWsgUwagi ;
    //10.11.2018 v.3.2.1.5 (radek)
    private float DlPrzylRzeczywista;
    //24.05.2019 v3224
    private String NrProtokoluOdbioruTech;
    private String NrInwentarzowyGazociagu;
    //16.06.2018  v.3.2.1.2
    private LocalDate OdbiorWsgKoncowy ;

    //monika to chciała - Radek Zajecie pasa podbite przez Gazownię
    private boolean ZajPasaPodbitePrzezGazownie;

    //Kuba v.4.1.7.0
    private LocalDate OdbiorWsgKoncowyDataWyslania;

    private GasDistribution gasDistribution;
}
