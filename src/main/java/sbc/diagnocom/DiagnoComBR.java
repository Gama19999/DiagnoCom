package sbc.diagnocom;

import Rule.*;

public class DiagnoComBR {
    // Declaracion BASE DE REGLAS
    BooleanRuleBase br = new BooleanRuleBase("diagnocom");
    
    // Declaracion variables de REGLAS
    RuleVariable temperatura;
    
    // Declaracion variables HECHOS
    RuleVariable enfermedad;
    
    // Declaracion variable enfermedad
    String diagnostico;
    
    
    
    // Metodos de ENCADENAMIETO
    public String getEnfermedad() {
        starterBR();
        
        this.temperatura.setValue(""); // Establece el valor de esa variable, obtenido de un atributo en el metodo
        
        br.forwardChain(); // Realiza el encadenamiento hacia adelante
        diagnostico = enfermedad.getValue(); // Obtiene el HECHO del encadenamiento
        
        return diagnostico;
    }
    
    
    
    /**
     * Inicializa los atributos de la clase
     */
    public void starterBR() {
        // Instancias de variables de regla
        temperatura = new RuleVariable(br, "Temperatura");
        
        // Definicion de operadores logicos (condicionales)
        Condition igual = new Condition("=");
        
        // Creacion de reglas de validacion (Base de Reglas)
        // ENFERMEDAD
        /*
        Rule ave = new Rule(br, "AVE",
                new Clause[]{new Clause(sangreCaliente, igual, "si"),
                    new Clause(plumas, igual, "si"),
                    new Clause(vidaSubmarina, igual, "no"),
                    new Clause(metamorfosis, igual, "no")},
                new Clause(v1, igual, "AVE"));
        */
    }
}
