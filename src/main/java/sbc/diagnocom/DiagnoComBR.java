package sbc.diagnocom;

import Rule.*;

public class DiagnoComBR {
    // Declaracion BASE DE REGLAS
    BooleanRuleBase br = new BooleanRuleBase("diagnocom");
    
    
    // Declaracion variables HECHOS (CONCLUSIONES)
    RuleVariable afeccion;
    RuleVariable enfermedad;
    String nameHecho;
    
    // Declaracion variables de REGLAS (1-6)
    RuleVariable afeccionCabeza;
    RuleVariable afeccionRespiratoria;
    RuleVariable afeccionDigestiva;
    RuleVariable afeccionInterna;
    RuleVariable afeccionUrinaria;
    RuleVariable afeccionPiel;
    
    // Declaracion variables de REGLAS (7-8)
    RuleVariable dolorCabeza;
    RuleVariable presionArterialAlta;
    RuleVariable fiebre;
    RuleVariable zumbidoOidos;
    
    // Declaracion variables de REGLAS (9-14)
    RuleVariable tos;
    RuleVariable dolorGarganta;
    RuleVariable dolorPecho;
    RuleVariable escurrimientoNasal;
    RuleVariable fatiga;
    RuleVariable congestionNasal;
    RuleVariable dolorCorporal;
    RuleVariable dificultadRespiratoria;
    
    // Declaracion variables de REGLAS (15-20)
    RuleVariable dolorAbdominal;
    RuleVariable evacuacionesConstantes;
    RuleVariable nauseas;
    RuleVariable acidezEstomacal;
    RuleVariable vomito;
    RuleVariable hemorragiaRectal;
    RuleVariable gases;
    
    // Declaracion variables de REGLAS (21-24)
    RuleVariable dolorEspalda;

    // Declaracion variables de REGLAS (25)
    RuleVariable dolorAlOrinar;
    RuleVariable sangradoAlOrinar;
    
    // Declaracion variables de REGLAS (26)
    RuleVariable pielEnrogecida;
    RuleVariable inflamacionZona;
    RuleVariable altaSensibilidadZona;
    
    
    // Metodos de ENCADENAMIETO
    public String getAfeccion(String afCabeza, String afResp, String afDigest,
            String afInter, String afUri, String afPiel) {
        
        starterBR(); // Inicializa la base de reglas
        
        afeccionCabeza.setValue(afCabeza); // Establece el valor de esa variable, obtenido de un parametro en el metodo
        afeccionRespiratoria.setValue(afResp);
        afeccionDigestiva.setValue(afDigest);
        afeccionInterna.setValue(afInter);
        afeccionUrinaria.setValue(afUri);
        afeccionPiel.setValue(afPiel);
        
        br.forwardChain(); // Realiza el encadenamiento hacia adelante
        nameHecho = afeccion.getValue(); // Obtiene el HECHO del 1er encadenamiento
        
        return nameHecho;
    }
    
    public String getD_Cabeza(String afeccion, String dolCabeza, String presArtAlta,
            String fiebre, String zumbOidos) {
        
        starterBR();
        
        this.afeccion.setValue(afeccion);
        dolorCabeza.setValue(dolCabeza);
        presionArterialAlta.setValue(presArtAlta);
        this.fiebre.setValue(fiebre);
        zumbidoOidos.setValue(zumbOidos);
        
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        
        return nameHecho;
    }
    
    public String getD_Respiratorio(String tos, String fiebre, String dolGarg,
            String dolPecho, String escurrNas, String fatiga, String congNas,
            String dolCabeza, String dolCorpo, String dificResp) {
        
        starterBR();
        
        this.tos.setValue(tos);
        this.fiebre.setValue(fiebre);
        dolorGarganta.setValue(dolGarg);
        dolorPecho.setValue(dolPecho);
        escurrimientoNasal.setValue(escurrNas);
        this.fatiga.setValue(fatiga);
        congestionNasal.setValue(congNas);
        dolorCabeza.setValue(dolCabeza);
        dolorCorporal.setValue(dolCorpo);
        dificultadRespiratoria.setValue(dificResp);
        
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        
        return nameHecho;
    }
    
    public String getD_Digestivo() {
        return nameHecho;
    }
    
    public String getD_Interno() {
        return nameHecho;
    }
    
    public String getD_Urinario() {
        return nameHecho;
    }
    
    public String getD_Cutaneo() {
        return nameHecho;
    }
    
    
    /**
     * Inicializa los atributos de la clase
     */
    public void starterBR() {
        // Instancias de VARIABLES de regla
        afeccionCabeza = new RuleVariable(br, "AfeccionCabeza");
        afeccionRespiratoria = new RuleVariable(br, "AfeccioRespiratoria");
        afeccionDigestiva = new RuleVariable(br, "AfeccionDigestiva");
        afeccionInterna = new RuleVariable(br, "AfeccionInterna");
        afeccionUrinaria = new RuleVariable(br, "AfeccionUrinaria");
        afeccionPiel = new RuleVariable(br, "AfeccionPiel");
        
        dolorCabeza = new RuleVariable(br, "DolorCabeza");
        presionArterialAlta = new RuleVariable(br, "PresionArterialAlta");
        fiebre = new RuleVariable(br, "Fiebre");
        zumbidoOidos = new RuleVariable(br, "ZumbidoOidos");
        
        tos = new RuleVariable(br, "Tos");
        dolorGarganta = new RuleVariable(br, "DolorGarganta");
        dolorPecho = new RuleVariable(br, "DolorPecho");
        escurrimientoNasal = new RuleVariable(br, "EscurrimientoNasal");
        fatiga = new RuleVariable(br, "Fatiga");
        congestionNasal = new RuleVariable(br, "CongestionNasal");
        dolorCorporal = new RuleVariable(br, "DolorCorporal");
        dificultadRespiratoria = new RuleVariable(br, "DificultadRespiratoria");
        
        dolorAbdominal = new RuleVariable(br, "DolorAbdominal");
        evacuacionesConstantes = new RuleVariable(br, "EvacuacionesConstantes");
        nauseas = new RuleVariable(br, "Nauseas");
        acidezEstomacal = new RuleVariable(br, "AcidezEstomacal");
        vomito = new RuleVariable(br, "Vomito");
        hemorragiaRectal = new RuleVariable(br, "HemorragiaRectal");
        gases = new RuleVariable(br, "Gases");
        
        dolorEspalda = new RuleVariable(br, "DolorEspalda");
        
        dolorAlOrinar = new RuleVariable(br, "DolorAlOrinar");
        sangradoAlOrinar = new RuleVariable(br, "SangradoAlOrinar");
        
        pielEnrogecida = new RuleVariable(br, "PielEnrogecida");
        inflamacionZona = new RuleVariable(br, "InflamacionZona");
        altaSensibilidadZona = new RuleVariable(br, "AltaSensibilidadZona");
        
        // Instancias de CONSECUENTES de regla
        afeccion = new RuleVariable(br, "Afeccion");
        enfermedad = new RuleVariable(br, "Enfermedad");
        
        
        // Definicion de operadores logicos (condicionales)
        Condition igual = new Condition("=");
        
        // Creacion de reglas de validacion (Base de Reglas)
        // AFECCION
        Rule dCabeza = new Rule(br, "D.CABEZA",
                new Clause[]{new Clause(afeccionCabeza, igual, "si"),
                    new Clause(afeccionRespiratoria, igual, "no"),
                    new Clause(afeccionDigestiva, igual, "no"),
                    new Clause(afeccionInterna, igual, "no"),
                    new Clause(afeccionUrinaria, igual, "no"),
                    new Clause(afeccionPiel, igual, "no")},
                new Clause(afeccion, igual, "D.CABEZA"));
        Rule dRespiratorio = new Rule(br, "D.RESPIRATORIO",
                new Clause[]{new Clause(afeccionCabeza, igual, "no"),
                    new Clause(afeccionRespiratoria, igual, "si"),
                    new Clause(afeccionDigestiva, igual, "no"),
                    new Clause(afeccionInterna, igual, "no"),
                    new Clause(afeccionUrinaria, igual, "no"),
                    new Clause(afeccionPiel, igual, "no")},
                new Clause(afeccion, igual, "D.RESPIRATORIO"));
        Rule dDigestivo = new Rule(br, "D.DIGESTIVO",
                new Clause[]{new Clause(afeccionCabeza, igual, "no"),
                    new Clause(afeccionRespiratoria, igual, "no"),
                    new Clause(afeccionDigestiva, igual, "si"),
                    new Clause(afeccionInterna, igual, "no"),
                    new Clause(afeccionUrinaria, igual, "no"),
                    new Clause(afeccionPiel, igual, "no")},
                new Clause(afeccion, igual, "D.DIGESTIVO"));
        Rule dInterno = new Rule(br, "D.INTERNO",
                new Clause[]{new Clause(afeccionCabeza, igual, "no"),
                    new Clause(afeccionRespiratoria, igual, "no"),
                    new Clause(afeccionDigestiva, igual, "no"),
                    new Clause(afeccionInterna, igual, "si"),
                    new Clause(afeccionUrinaria, igual, "no"),
                    new Clause(afeccionPiel, igual, "no")},
                new Clause(afeccion, igual, "D.INTERNO"));
        Rule dUrinario= new Rule(br, "D.URINARIO",
                new Clause[]{new Clause(afeccionCabeza, igual, "no"),
                    new Clause(afeccionRespiratoria, igual, "no"),
                    new Clause(afeccionDigestiva, igual, "no"),
                    new Clause(afeccionInterna, igual, "no"),
                    new Clause(afeccionUrinaria, igual, "si"),
                    new Clause(afeccionPiel, igual, "no")},
                new Clause(afeccion, igual, "D.URINARIO"));
        Rule dCutaneo = new Rule(br, "D.CUTANEO",
                new Clause[]{new Clause(afeccionCabeza, igual, "no"),
                    new Clause(afeccionRespiratoria, igual, "no"),
                    new Clause(afeccionDigestiva, igual, "no"),
                    new Clause(afeccionInterna, igual, "no"),
                    new Clause(afeccionUrinaria, igual, "no"),
                    new Clause(afeccionPiel, igual, "si")},
                new Clause(afeccion, igual, "D.CUTANEO"));
        
        // ENFERMEDAD CON D.CABEZA
        Rule migrania = new Rule(br, "MIGRANIA",
                new Clause[]{new Clause(afeccion, igual, "D.CABEZA"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(presionArterialAlta, igual, "si"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(zumbidoOidos, igual, "si")},
                new Clause(enfermedad, igual, "MIGRANIA"));
        Rule infeccionOido = new Rule(br, "INFECCIONOIDO",
                new Clause[]{new Clause(afeccion, igual, "D.CABEZA"),
                    new Clause(dolorCabeza, igual, "no"),
                    new Clause(presionArterialAlta, igual, "no"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(zumbidoOidos, igual, "si")},
                new Clause(enfermedad, igual, "INFECCIONOIDO"));
        
        // ENFERMEDAD CON D.RESPIRATORIO
        Rule gripeComun = new Rule(br, "GRIPECOMUN",
                new Clause[]{new Clause(afeccion, igual, "D.RESPIRATORIO"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(congestionNasal, igual, "no"),
                    new Clause(dolorCabeza, igual, "no"),
                    new Clause(dolorCorporal, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no")},
                new Clause(enfermedad, igual, "GRIPECOMUN"));
        Rule bronquitis = new Rule(br, "BRONQUITIS",
                new Clause[]{new Clause(afeccion, igual, "D.RESPIRATORIO"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "si"),
                    new Clause(escurrimientoNasal, igual, "si"),
                    new Clause(fatiga, igual, "si"),
                    new Clause(congestionNasal, igual, "no"),
                    new Clause(dolorCabeza, igual, "no"),
                    new Clause(dolorCorporal, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no")},
                new Clause(enfermedad, igual, "BRONQUITIS"));
        Rule tosConFlema = new Rule(br, "TOSCONFLEMA",
                new Clause[]{new Clause(afeccion, igual, "D.RESPIRATORIO"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(congestionNasal, igual, "si"),
                    new Clause(dolorCabeza, igual, "no"),
                    new Clause(dolorCorporal, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no")},
                new Clause(enfermedad, igual, "TOSCONFLEMA"));
        Rule sinusitis = new Rule(br, "SINUSITIS",
                new Clause[]{new Clause(afeccion, igual, "D.RESPIRATORIO"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(congestionNasal, igual, "si"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(dolorCorporal, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no")},
                new Clause(enfermedad, igual, "SINUSITIS"));
        Rule influenza = new Rule(br, "INFLUENZA",
                new Clause[]{new Clause(afeccion, igual, "D.RESPIRATORIO"),
                    new Clause(tos, igual, "no"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(congestionNasal, igual, "si"),
                    new Clause(dolorCabeza, igual, "no"),
                    new Clause(dolorCorporal, igual, "si"),
                    new Clause(dificultadRespiratoria, igual, "no")},
                new Clause(enfermedad, igual, "INFLUENZA"));
        Rule neumonia = new Rule(br, "NEUMONIA",
                new Clause[]{new Clause(afeccion, igual, "D.RESPIRATORIO"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorGarganta, igual, "no"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "no"),
                    new Clause(fatiga, igual, "si"),
                    new Clause(congestionNasal, igual, "no"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(dolorCorporal, igual, "si"),
                    new Clause(dificultadRespiratoria, igual, "si")},
                new Clause(enfermedad, igual, "NEUMONIA"));
        
        // ENFERMEDAD CON D.DIGESTIVO
        Rule infeccionEstomago = new Rule(br, "INFECCIONESTOMAGO",
                new Clause[]{new Clause(afeccion, igual, "D.DIGESTIVO"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(vomito, igual, "si"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(gases, igual, "no")},
                new Clause(enfermedad, igual, "INFECCIONESTOMAGO"));
        Rule diarrea = new Rule(br, "DIARREA",
                new Clause[]{new Clause(afeccion, igual, "D.DIGESTIVO"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "si"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(vomito, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(gases, igual, "si")},
                new Clause(enfermedad, igual, "DIARREA"));
        Rule estrenimiento = new Rule(br, "ESTRENIMIENTO",
                new Clause[]{new Clause(afeccion, igual, "D.DIGESTIVO"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(vomito, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(gases, igual, "no")},
                new Clause(enfermedad, igual, "ESTRENIMIENTO"));
        Rule indigestion = new Rule(br, "INDIGESTION",
                new Clause[]{new Clause(afeccion, igual, "D.DIGESTIVO"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(acidezEstomacal, igual, "si"),
                    new Clause(vomito, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(gases, igual, "no")},
                new Clause(enfermedad, igual, "INDIGESTION"));
        Rule gastritis = new Rule(br, "GASTRITIS",
                new Clause[]{new Clause(afeccion, igual, "D.DIGESTIVO"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(acidezEstomacal, igual, "si"),
                    new Clause(vomito, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(gases, igual, "no")},
                new Clause(enfermedad, igual, "GASTRITIS"));
        Rule colitis = new Rule(br, "COLITIS",
                new Clause[]{new Clause(afeccion, igual, "D.DIGESTIVO"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(vomito, igual, "no"),
                    new Clause(fatiga, igual, "si"),
                    new Clause(hemorragiaRectal, igual, "si"),
                    new Clause(gases, igual, "si")},
                new Clause(enfermedad, igual, "COLITIS"));
        
        // ENFERMEDAD CON D.INTERNO
        Rule apendicitis = new Rule(br, "APENDICITIS",
                new Clause[]{new Clause(afeccion, igual, "D.INTERNO"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(vomito, igual, "si"),
                    new Clause(tos, igual, "no"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(dolorEspalda, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(fatiga, igual, "no")},
                new Clause(enfermedad, igual, "APENDICITIS"));
        Rule esofagitis = new Rule(br, "ESOFAGITIS",
                new Clause[]{new Clause(afeccion, igual, "D.INTERNO"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(vomito, igual, "si"),
                    new Clause(tos, igual, "si"),
                    new Clause(dolorPecho, igual, "si"),
                    new Clause(acidezEstomacal, igual, "si"),
                    new Clause(dolorEspalda, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(fatiga, igual, "no")},
                new Clause(enfermedad, igual, "ESOFAGITIS"));
        Rule pancreatitis = new Rule(br, "PANCREATITIS",
                new Clause[]{new Clause(afeccion, igual, "D.INTERNO"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(vomito, igual, "si"),
                    new Clause(tos, igual, "no"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(dolorEspalda, igual, "si"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(fatiga, igual, "no")},
                new Clause(enfermedad, igual, "PANCREATITIS"));
        Rule anemia = new Rule(br, "ANEMIA",
                new Clause[]{new Clause(afeccion, igual, "D.INTERNO"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "no"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(vomito, igual, "no"),
                    new Clause(tos, igual, "no"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(dolorEspalda, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "si"),
                    new Clause(fatiga, igual, "si")},
                new Clause(enfermedad, igual, "ANEMIA"));
        
        // ENFERMEDAD CON D.URINARIO
        Rule infeccionUrinaria = new Rule(br, "INFECCIONURINARIA",
                new Clause[]{new Clause(afeccion, igual, "D.URINARIO"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(dolorAlOrinar, igual, "si"),
                    new Clause(sangradoAlOrinar, igual, "si"),
                    new Clause(dolorEspalda, igual, "si")},
                new Clause(enfermedad, igual, "INFECCIONURINARIA"));
        
        // ENFERMEDAD CON D.CUTANEO
        Rule infeccionPiel = new Rule(br, "INFECCIONPIEL",
                new Clause[]{new Clause(afeccion, igual, "D.CUTANEO"),
                    new Clause(pielEnrogecida, igual, "si"),
                    new Clause(inflamacionZona, igual, "si"),
                    new Clause(altaSensibilidadZona, igual, "si")},
                new Clause(enfermedad, igual, "INFECCIONPIEL"));
    }
}
