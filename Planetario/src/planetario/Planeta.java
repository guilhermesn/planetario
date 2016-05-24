package planetario;
// Generated 09/05/2016 20:00:11 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Planeta generated by hbm2java
 */
public class Planeta  implements java.io.Serializable {


     private PlanetaId id;
     private Estrelas estrelas;
     private String nomePlaneta;
     private Float massa;
     private Float massaErroMin;
     private Float massaErroMax;
     private Float raio;
     private Float raioErroMin;
     private Float raioErroMax;
     private Float periodoOrbital;
     private Float periodoOrbitalErroMin;
     private Float periodoOrbitalErroMax;
     private Float inclinacao;
     private Float inclinacaoErroMin;
     private Float inclinacaoErroMax;
     private Float distanciaAngular;
     private Integer descoberta;
     private Date atualizacao;
     private Integer tempoCalculado;
     private Integer tempoMedido;
     private String statusPublicacao;
     private String tipoDeteccao;
     private String tipoDeteccaoMassa;
     private String tipoDeteccaoRaio;
     private String nomeAlternativo;
     private String moleculas;

    public Planeta() {
    }

	
    public Planeta(PlanetaId id, Estrelas estrelas, String nomePlaneta) {
        this.id = id;
        this.estrelas = estrelas;
        this.nomePlaneta = nomePlaneta;
    }
    public Planeta(PlanetaId id, Estrelas estrelas, String nomePlaneta, Float massa, Float massaErroMin, Float massaErroMax, Float raio, Float raioErroMin, Float raioErroMax, Float periodoOrbital, Float periodoOrbitalErroMin, Float periodoOrbitalErroMax, Float inclinacao, Float inclinacaoErroMin, Float inclinacaoErroMax, Float distanciaAngular, Integer descoberta, Date atualizacao, Integer tempoCalculado, Integer tempoMedido, String statusPublicacao, String tipoDeteccao, String tipoDeteccaoMassa, String tipoDeteccaoRaio, String nomeAlternativo, String moleculas) {
       this.id = id;
       this.estrelas = estrelas;
       this.nomePlaneta = nomePlaneta;
       this.massa = massa;
       this.massaErroMin = massaErroMin;
       this.massaErroMax = massaErroMax;
       this.raio = raio;
       this.raioErroMin = raioErroMin;
       this.raioErroMax = raioErroMax;
       this.periodoOrbital = periodoOrbital;
       this.periodoOrbitalErroMin = periodoOrbitalErroMin;
       this.periodoOrbitalErroMax = periodoOrbitalErroMax;
       this.inclinacao = inclinacao;
       this.inclinacaoErroMin = inclinacaoErroMin;
       this.inclinacaoErroMax = inclinacaoErroMax;
       this.distanciaAngular = distanciaAngular;
       this.descoberta = descoberta;
       this.atualizacao = atualizacao;
       this.tempoCalculado = tempoCalculado;
       this.tempoMedido = tempoMedido;
       this.statusPublicacao = statusPublicacao;
       this.tipoDeteccao = tipoDeteccao;
       this.tipoDeteccaoMassa = tipoDeteccaoMassa;
       this.tipoDeteccaoRaio = tipoDeteccaoRaio;
       this.nomeAlternativo = nomeAlternativo;
       this.moleculas = moleculas;
    }
   
    public PlanetaId getId() {
        return this.id;
    }
    
    public void setId(PlanetaId id) {
        this.id = id;
    }
    public Estrelas getEstrelas() {
        return this.estrelas;
    }
    
    public void setEstrelas(Estrelas estrelas) {
        this.estrelas = estrelas;
    }
    public String getNomePlaneta() {
        return this.nomePlaneta;
    }
    
    public void setNomePlaneta(String nomePlaneta) {
        this.nomePlaneta = nomePlaneta;
    }
    public Float getMassa() {
        return this.massa;
    }
    
    public void setMassa(Float massa) {
        this.massa = massa;
    }
    public Float getMassaErroMin() {
        return this.massaErroMin;
    }
    
    public void setMassaErroMin(Float massaErroMin) {
        this.massaErroMin = massaErroMin;
    }
    public Float getMassaErroMax() {
        return this.massaErroMax;
    }
    
    public void setMassaErroMax(Float massaErroMax) {
        this.massaErroMax = massaErroMax;
    }
    public Float getRaio() {
        return this.raio;
    }
    
    public void setRaio(Float raio) {
        this.raio = raio;
    }
    public Float getRaioErroMin() {
        return this.raioErroMin;
    }
    
    public void setRaioErroMin(Float raioErroMin) {
        this.raioErroMin = raioErroMin;
    }
    public Float getRaioErroMax() {
        return this.raioErroMax;
    }
    
    public void setRaioErroMax(Float raioErroMax) {
        this.raioErroMax = raioErroMax;
    }
    public Float getPeriodoOrbital() {
        return this.periodoOrbital;
    }
    
    public void setPeriodoOrbital(Float periodoOrbital) {
        this.periodoOrbital = periodoOrbital;
    }
    public Float getPeriodoOrbitalErroMin() {
        return this.periodoOrbitalErroMin;
    }
    
    public void setPeriodoOrbitalErroMin(Float periodoOrbitalErroMin) {
        this.periodoOrbitalErroMin = periodoOrbitalErroMin;
    }
    public Float getPeriodoOrbitalErroMax() {
        return this.periodoOrbitalErroMax;
    }
    
    public void setPeriodoOrbitalErroMax(Float periodoOrbitalErroMax) {
        this.periodoOrbitalErroMax = periodoOrbitalErroMax;
    }
    public Float getInclinacao() {
        return this.inclinacao;
    }
    
    public void setInclinacao(Float inclinacao) {
        this.inclinacao = inclinacao;
    }
    public Float getInclinacaoErroMin() {
        return this.inclinacaoErroMin;
    }
    
    public void setInclinacaoErroMin(Float inclinacaoErroMin) {
        this.inclinacaoErroMin = inclinacaoErroMin;
    }
    public Float getInclinacaoErroMax() {
        return this.inclinacaoErroMax;
    }
    
    public void setInclinacaoErroMax(Float inclinacaoErroMax) {
        this.inclinacaoErroMax = inclinacaoErroMax;
    }
    public Float getDistanciaAngular() {
        return this.distanciaAngular;
    }
    
    public void setDistanciaAngular(Float distanciaAngular) {
        this.distanciaAngular = distanciaAngular;
    }
    public Integer getDescoberta() {
        return this.descoberta;
    }
    
    public void setDescoberta(Integer descoberta) {
        this.descoberta = descoberta;
    }
    public Date getAtualizacao() {
        return this.atualizacao;
    }
    
    public void setAtualizacao(Date atualizacao) {
        this.atualizacao = atualizacao;
    }
    public Integer getTempoCalculado() {
        return this.tempoCalculado;
    }
    
    public void setTempoCalculado(Integer tempoCalculado) {
        this.tempoCalculado = tempoCalculado;
    }
    public Integer getTempoMedido() {
        return this.tempoMedido;
    }
    
    public void setTempoMedido(Integer tempoMedido) {
        this.tempoMedido = tempoMedido;
    }
    public String getStatusPublicacao() {
        return this.statusPublicacao;
    }
    
    public void setStatusPublicacao(String statusPublicacao) {
        this.statusPublicacao = statusPublicacao;
    }
    public String getTipoDeteccao() {
        return this.tipoDeteccao;
    }
    
    public void setTipoDeteccao(String tipoDeteccao) {
        this.tipoDeteccao = tipoDeteccao;
    }
    public String getTipoDeteccaoMassa() {
        return this.tipoDeteccaoMassa;
    }
    
    public void setTipoDeteccaoMassa(String tipoDeteccaoMassa) {
        this.tipoDeteccaoMassa = tipoDeteccaoMassa;
    }
    public String getTipoDeteccaoRaio() {
        return this.tipoDeteccaoRaio;
    }
    
    public void setTipoDeteccaoRaio(String tipoDeteccaoRaio) {
        this.tipoDeteccaoRaio = tipoDeteccaoRaio;
    }
    public String getNomeAlternativo() {
        return this.nomeAlternativo;
    }
    
    public void setNomeAlternativo(String nomeAlternativo) {
        this.nomeAlternativo = nomeAlternativo;
    }
    public String getMoleculas() {
        return this.moleculas;
    }
    
    public void setMoleculas(String moleculas) {
        this.moleculas = moleculas;
    }




}

