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
    RuleVariable nauseas;
    RuleVariable dolorGarganta;
    RuleVariable dolorOido;
    
    // Declaracion variables de REGLAS (9-17)
    RuleVariable tos;
    RuleVariable estornudos;
    RuleVariable dolorArticulaciones;
    RuleVariable dolorEspalda;
    RuleVariable dolorPecho;
    RuleVariable escurrimientoNasal;
    RuleVariable fatiga;
    RuleVariable congestionNasal;
    RuleVariable dolorCorporal;
    RuleVariable dificultadRespiratoria;
    
    // Declaracion variables de REGLAS (18-22)
    RuleVariable dolorAbdominal;
    RuleVariable evacuacionesConstantes;
    RuleVariable acidezEstomacal;
    RuleVariable vomito;
    RuleVariable hemorragiaRectal;
    RuleVariable diarrea;
    RuleVariable evacuacionesConDolor;
    
    // Declaracion variables de REGLAS (23-26)
    
    // Declaracion variables de REGLAS (27)
    RuleVariable dolorAlOrinar;
    RuleVariable sangradoAlOrinar;
    
    // Declaracion variables de REGLAS (28)
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
            String fiebre, String zumbOidos, String nauseas, String dolGarg, String dolOido) {
        
        starterBR();
        
        this.afeccion.setValue(afeccion);
        dolorCabeza.setValue(dolCabeza);
        presionArterialAlta.setValue(presArtAlta);
        this.fiebre.setValue(fiebre);
        zumbidoOidos.setValue(zumbOidos);
        this.nauseas.setValue(nauseas);
        dolorGarganta.setValue(dolGarg);
        dolorOido.setValue(dolOido);
        
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        
        return nameHecho;
    }
    
    public String getD_Respiratorio(String tos, String fiebre, String dolGarg,
            String dolPecho, String escurrNas, String fatiga, String congNas,
            String dolCabeza, String dolCorpo, String dificResp, String estorn,
            String doloArtic, String doloEspal) {
        
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
        estornudos.setValue(estorn);
        dolorArticulaciones.setValue(doloArtic);
        dolorEspalda.setValue(doloEspal);
        
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        
        return nameHecho;
    }
    
    public String getD_Digestivo(String fiebre, String doloAbdo, String evaConst,
            String nauseas, String acidEsto, String vomito, String fatiga,
            String hemoRec, String diarrea, String evaConDolo, String doloPecho) {
        
        starterBR();
        
        this.fiebre.setValue(fiebre);
        dolorAbdominal.setValue(doloAbdo);
        evacuacionesConstantes.setValue(evaConst);
        this.nauseas.setValue(nauseas);
        acidezEstomacal.setValue(acidEsto);
        this.vomito.setValue(vomito);
        this.fatiga.setValue(fatiga);
        hemorragiaRectal.setValue(hemoRec);
        this.diarrea.setValue(diarrea);
        evacuacionesConDolor.setValue(evaConDolo);
        dolorPecho.setValue(doloPecho);
        
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        
        return nameHecho;
    }
    
    public String getD_Interno(String fiebre, String doloAbdo, String nauseas,
            String vomito, String tos, String dolPech, String acidEst,
            String dolEspa, String difRes, String fatiga, String evaConst,
            String dolGarg, String hemoRec, String diarrea) {
        
        starterBR();
        
        this.fiebre.setValue(fiebre);
        dolorAbdominal.setValue(doloAbdo);
        this.nauseas.setValue(nauseas);
        this.vomito.setValue(vomito);
        this.tos.setValue(tos);
        dolorPecho.setValue(dolPech);
        acidezEstomacal.setValue(acidEst);
        dolorEspalda.setValue(dolEspa);
        dificultadRespiratoria.setValue(difRes);
        this.fatiga.setValue(fatiga);
        evacuacionesConstantes.setValue(evaConst);
        dolorGarganta.setValue(dolGarg);
        hemorragiaRectal.setValue(hemoRec);
        this.diarrea.setValue(diarrea);
        
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        
        return nameHecho;
    }
    
    public String getD_Urinario(String nauseas, String doloAOri, String sangAOri,
            String doloEsp, String fiebre) {
        
        starterBR();
        
        this.nauseas.setValue(nauseas);
        dolorAlOrinar.setValue(doloAOri);
        sangradoAlOrinar.setValue(sangAOri);
        dolorEspalda.setValue(doloEsp);
        this.fiebre.setValue(fiebre);
        
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        
        return nameHecho;
    }
    
    public String getD_Cutaneo(String pielEnr, String inflama, String altaSensi) {
        starterBR();
        
        pielEnrogecida.setValue(pielEnr);
        inflamacionZona.setValue(inflama);
        altaSensibilidadZona.setValue(altaSensi);
        
        br.forwardChain();
        nameHecho = enfermedad.getValue();
        
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
        nauseas = new RuleVariable(br, "Nauseas");
        dolorGarganta = new RuleVariable(br, "DolorGarganta");
        dolorOido = new RuleVariable(br, "DolorOido");
        
        tos = new RuleVariable(br, "Tos");
        estornudos = new RuleVariable(br, "Estornudos");
        dolorArticulaciones = new RuleVariable(br, "DolorArticulaciones");
        dolorEspalda = new RuleVariable(br, "DolorEspalda");
        dolorPecho = new RuleVariable(br, "DolorPecho");
        escurrimientoNasal = new RuleVariable(br, "EscurrimientoNasal");
        fatiga = new RuleVariable(br, "Fatiga");
        congestionNasal = new RuleVariable(br, "CongestionNasal");
        dolorCorporal = new RuleVariable(br, "DolorCorporal");
        dificultadRespiratoria = new RuleVariable(br, "DificultadRespiratoria");
        
        dolorAbdominal = new RuleVariable(br, "DolorAbdominal");
        evacuacionesConstantes = new RuleVariable(br, "EvacuacionesConstantes");
        acidezEstomacal = new RuleVariable(br, "AcidezEstomacal");
        vomito = new RuleVariable(br, "Vomito");
        hemorragiaRectal = new RuleVariable(br, "HemorragiaRectal");
        diarrea = new RuleVariable(br, "Diarrea");
        evacuacionesConDolor = new RuleVariable(br, "EvacuacionesConDolor");
        
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
                    new Clause(zumbidoOidos, igual, "si"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(dolorGarganta, igual, "no"),
                    new Clause(dolorOido, igual, "no")},
                new Clause(enfermedad, igual, "MIGRANIA"));
        Rule infeccionOido = new Rule(br, "INFECCION DE OIDO",
                new Clause[]{new Clause(afeccion, igual, "D.CABEZA"),
                    new Clause(dolorCabeza, igual, "no"),
                    new Clause(presionArterialAlta, igual, "no"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(zumbidoOidos, igual, "si"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorOido, igual, "si")},
                new Clause(enfermedad, igual, "INFECCION DE OIDO"));
        
        // ENFERMEDAD CON D.RESPIRATORIO
        Rule gripeComun = new Rule(br, "GRIPE COMUN",
                new Clause[]{new Clause(afeccion, igual, "D.RESPIRATORIO"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "si"),
                    new Clause(fatiga, igual, "si"),
                    new Clause(congestionNasal, igual, "si"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(dolorCorporal, igual, "si"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(estornudos, igual, "si"),
                    new Clause(dolorArticulaciones, igual, "si"),
                    new Clause(dolorEspalda, igual, "si")},
                new Clause(enfermedad, igual, "GRIPE COMUN"));
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
                    new Clause(dificultadRespiratoria, igual, "si"),
                    new Clause(estornudos, igual, "no"),
                    new Clause(dolorArticulaciones, igual, "no"),
                    new Clause(dolorEspalda, igual, "si")},
                new Clause(enfermedad, igual, "BRONQUITIS"));
        Rule tosConFlema = new Rule(br, "TOS CON FLEMA",
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
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(estornudos, igual, "no"),
                    new Clause(dolorArticulaciones, igual, "no"),
                    new Clause(dolorEspalda, igual, "no")},
                new Clause(enfermedad, igual, "TOS CON FLEMA"));
        Rule sinusitis = new Rule(br, "SINUSITIS",
                new Clause[]{new Clause(afeccion, igual, "D.RESPIRATORIO"),
                    new Clause(tos, igual, "no"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "si"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(congestionNasal, igual, "si"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(dolorCorporal, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(estornudos, igual, "si"),
                    new Clause(dolorArticulaciones, igual, "no"),
                    new Clause(dolorEspalda, igual, "no")},
                new Clause(enfermedad, igual, "SINUSITIS"));
        Rule influenza = new Rule(br, "INFLUENZA",
                new Clause[]{new Clause(afeccion, igual, "D.RESPIRATORIO"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "si"),
                    new Clause(fatiga, igual, "si"),
                    new Clause(congestionNasal, igual, "si"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(dolorCorporal, igual, "si"),
                    new Clause(dificultadRespiratoria, igual, "si"),
                    new Clause(estornudos, igual, "si"),
                    new Clause(dolorArticulaciones, igual, "si"),
                    new Clause(dolorEspalda, igual, "si")},
                new Clause(enfermedad, igual, "INFLUENZA"));
        Rule sinusitisBacteriana = new Rule(br, "SINUSITIS BACTERIANA",
                new Clause[]{new Clause(afeccion, igual, "D.RESPIRATORIO"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "si"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(congestionNasal, igual, "si"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(dolorCorporal, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(estornudos, igual, "si"),
                    new Clause(dolorArticulaciones, igual, "no"),
                    new Clause(dolorEspalda, igual, "no")},
                new Clause(enfermedad, igual, "SINUSITIS BACERIANA"));
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
                    new Clause(dificultadRespiratoria, igual, "si"),
                    new Clause(estornudos, igual, "no"),
                    new Clause(dolorArticulaciones, igual, "si"),
                    new Clause(dolorEspalda, igual, "si")},
                new Clause(enfermedad, igual, "NEUMONIA"));
        Rule fibrosisPulmonar = new Rule(br, "FIBROSIS PULMONAR",
                new Clause[]{new Clause(afeccion, igual, "D.RESPIRATORIO"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorGarganta, igual, "no"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "no"),
                    new Clause(fatiga, igual, "si"),
                    new Clause(congestionNasal, igual, "no"),
                    new Clause(dolorCabeza, igual, "no"),
                    new Clause(dolorCorporal, igual, "si"),
                    new Clause(dificultadRespiratoria, igual, "si"),
                    new Clause(estornudos, igual, "no"),
                    new Clause(dolorArticulaciones, igual, "si"),
                    new Clause(dolorEspalda, igual, "si")},
                new Clause(enfermedad, igual, "FIBROSIS PULMONAR"));
        Rule bronquiolitis = new Rule(br, "BRONQUIOLITIS",
                new Clause[]{new Clause(afeccion, igual, "D.RESPIRATORIO"),
                    new Clause(tos, igual, "si"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorGarganta, igual, "no"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(escurrimientoNasal, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(congestionNasal, igual, "no"),
                    new Clause(dolorCabeza, igual, "si"),
                    new Clause(dolorCorporal, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "si"),
                    new Clause(estornudos, igual, "no"),
                    new Clause(dolorArticulaciones, igual, "no"),
                    new Clause(dolorEspalda, igual, "no")},
                new Clause(enfermedad, igual, "BRONQUIOLITIS"));
        
        // ENFERMEDAD CON D.DIGESTIVO
        Rule infeccionEstomago = new Rule(br, "INFECCIONESTOMAGO",
                new Clause[]{new Clause(afeccion, igual, "D.DIGESTIVO"),
                    new Clause(fiebre, igual, "si"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "si"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(vomito, igual, "si"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(diarrea, igual, "si"),
                    new Clause(evacuacionesConDolor, igual, "no"),
                    new Clause(dolorPecho, igual, "no")},
                new Clause(enfermedad, igual, "INFECCIONESTOMAGO"));
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
                    new Clause(diarrea, igual, "no"),
                    new Clause(evacuacionesConDolor, igual, "si"),
                    new Clause(dolorPecho, igual, "no")},
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
                    new Clause(diarrea, igual, "no"),
                    new Clause(evacuacionesConDolor, igual, "no"),
                    new Clause(dolorPecho, igual, "no")},
                new Clause(enfermedad, igual, "INDIGESTION"));
        Rule gastritis = new Rule(br, "GASTRITIS",
                new Clause[]{new Clause(afeccion, igual, "D.DIGESTIVO"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(acidezEstomacal, igual, "si"),
                    new Clause(vomito, igual, "si"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "si"),
                    new Clause(diarrea, igual, "no"),
                    new Clause(evacuacionesConDolor, igual, "si"),
                    new Clause(dolorPecho, igual, "si")},
                new Clause(enfermedad, igual, "GASTRITIS"));
        Rule colitis = new Rule(br, "COLITIS",
                new Clause[]{new Clause(afeccion, igual, "D.DIGESTIVO"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(vomito, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "si"),
                    new Clause(diarrea, igual, "si"),
                    new Clause(evacuacionesConDolor, igual, "no"),
                    new Clause(dolorPecho, igual, "no")},
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
                    new Clause(fatiga, igual, "no"),
                    new Clause(evacuacionesConstantes, igual, "si"),
                    new Clause(dolorGarganta, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(diarrea, igual, "no")},
                new Clause(enfermedad, igual, "APENDICITIS"));
        Rule esofagitis = new Rule(br, "ESOFAGITIS",
                new Clause[]{new Clause(afeccion, igual, "D.INTERNO"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(vomito, igual, "si"),
                    new Clause(tos, igual, "no"),
                    new Clause(dolorPecho, igual, "si"),
                    new Clause(acidezEstomacal, igual, "si"),
                    new Clause(dolorEspalda, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(dolorGarganta, igual, "si"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(diarrea, igual, "no")},
                new Clause(enfermedad, igual, "ESOFAGITIS"));
        Rule pancreatitis = new Rule(br, "PANCREATITIS",
                new Clause[]{new Clause(afeccion, igual, "D.INTERNO"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "si"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(vomito, igual, "si"),
                    new Clause(tos, igual, "no"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(dolorEspalda, igual, "si"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(fatiga, igual, "no"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(dolorGarganta, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "si"),
                    new Clause(diarrea, igual, "si")},
                new Clause(enfermedad, igual, "PANCREATITIS"));
        Rule anemia = new Rule(br, "ANEMIA",
                new Clause[]{new Clause(afeccion, igual, "D.INTERNO"),
                    new Clause(fiebre, igual, "no"),
                    new Clause(dolorAbdominal, igual, "no"),
                    new Clause(nauseas, igual, "no"),
                    new Clause(vomito, igual, "si"),
                    new Clause(tos, igual, "no"),
                    new Clause(dolorPecho, igual, "no"),
                    new Clause(acidezEstomacal, igual, "no"),
                    new Clause(dolorEspalda, igual, "no"),
                    new Clause(dificultadRespiratoria, igual, "no"),
                    new Clause(fatiga, igual, "si"),
                    new Clause(evacuacionesConstantes, igual, "no"),
                    new Clause(dolorGarganta, igual, "no"),
                    new Clause(hemorragiaRectal, igual, "no"),
                    new Clause(diarrea, igual, "no")},
                new Clause(enfermedad, igual, "ANEMIA"));
        
        // ENFERMEDAD CON D.URINARIO
        Rule infeccionUrinaria = new Rule(br, "INFECCIONURINARIA",
                new Clause[]{new Clause(afeccion, igual, "D.URINARIO"),
                    new Clause(nauseas, igual, "si"),
                    new Clause(dolorAlOrinar, igual, "si"),
                    new Clause(sangradoAlOrinar, igual, "si"),
                    new Clause(dolorEspalda, igual, "si"),
                    new Clause(fiebre, igual, "si")},
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
