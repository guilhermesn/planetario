/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetario;

import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Session;

/**
 *
 * @author guilherme
 */
public class Controle {

    public String selecionaWhereEstrela(String buscar, String valor) {
        if (valor != null) {
            if (!valor.trim().isEmpty()) {
                switch (buscar) {
                    case "ID":
                        return "where t.ra = " + valor;
                    case "Nome":
                        return "where t.nome = " + valor;
                    case "Distancia":
                        return "where t.distancia = " + valor;
                    case "Metalicidade":
                        return "where t.metalicidade = " + valor;
                    case "Massa":
                        return "where t.massa = " + valor;
                    case "Idade":
                        return "where t.idade = " + valor;
                    case "Temperatura":
                        return "where t.temperatura = " + valor;
                    case "Raio":
                        return "where t.raio = " + valor;
                    case "dec_2":
                        return "where t.dec_2 = " + valor;
                    default:
                        return "";
                }
            }
        }
        return "";
    }

    public String selecionaWherePlaneta(String buscar, String valor, boolean literal) {

        if (valor != null) {
            if (!valor.trim().isEmpty()) {
                if (literal) {
                    switch (buscar) {
                        case "ID":
                            return "where idPlaneta = '" + valor + "'";
                        case "Nome":
                            return "where nomePlaneta = '" + valor + "'";
                        case "Massa erro min":
                            return "where massaErroMin = '" + valor + "'";
                        case "Massa erro max":
                            return "where massaErroMax = '" + valor + "'";
                        case "Massa":
                            return "where massa = '" + valor + "'";
                        case "Raio":
                            return "where raio = '" + valor + "'";
                        case "Raio erro min":
                            return "where raioErroMin = '" + valor + "'";
                        case "Raio erro max":
                            return "where raioErroMax = '" + valor + "'";
                        case "Periodo orbital":
                            return "periodoOrbital = '" + valor + "'";
                        case "Periodo orbital erro min":
                            return "where periodoOrbitalErroMin = '" + valor + "'";
                        case "Periodo orbital erro max":
                            return "where nomePlaneta = '" + valor + "'";
                        case "periodoOrbitalErroMax":
                            return "where nomePlaneta = '" + valor + "'";
                        case "Inclinação":
                            return "where inclinacao = '" + valor + "'";
                        case "Inclinação erro min":
                            return "where inclinacaoErroMin = '" + valor + "'";
                        case "Inclinação erro max":
                            return "where inclinacaoErroMax = '" + valor + "'";
                        case "Distancia angular":
                            return "where distanciaAngular = '" + valor + "'";
                        case "Descoberta":
                            return "where descoberta = '" + valor + "'";
                        case "Atualização":
                            return "where atualizacao = '" + valor + "'";
                        case "Tempo calculado":
                            return "where tempoCalculado = '" + valor + "'";
                        case "Tempo médido":
                            return "where tempoMedido = '" + valor + "'";
                        case "Status da publição":
                            return "where statusPublicacao = '" + valor + "'";
                        case "Tipo de detecção":
                            return "where tipoDeteccao = '" + valor + "'";
                        case "Tipo de detecção de massa":
                            return "where tipoDeteccaoMassa = '" + valor + "'";
                        case "Tipo de detecção de raio":
                            return "where tipoDeteccaoRaio = '" + valor + "'";
                        case "Nome alternativo":
                            return "where nomeAlternativo = '" + valor + "'";
                        case "Moleculas encontradas":
                            return "where moleculas = '" + valor + "'";
                        default:
                            return "";
                    }
                }else{
                     switch (buscar) {
                        case "ID":
                            return "where idPlaneta LIKE '%" + valor + "%'";
                        case "Nome":
                            return "where nomePlaneta LIKE '%" + valor + "%'";
                        case "Massa erro min":
                            return "where massaErroMin LIKE '%" + valor + "%'";
                        case "Massa erro max":
                            return "where massaErroMax LIKE '%" + valor + "%'";
                        case "Massa":
                            return "where massa LIKE '%" + valor + "%'";
                        case "Raio":
                            return "where raio LIKE '%" + valor + "%'";
                        case "Raio erro min":
                            return "where raioErroMin LIKE '%" + valor + "%'";
                        case "Raio erro max":
                            return "where raioErroMax LIKE '%" + valor + "%'";
                        case "Periodo orbital":
                            return "periodoOrbital LIKE '%" + valor + "%'";
                        case "Periodo orbital erro min":
                            return "where periodoOrbitalErroMin LIKE '%" + valor + "%'";
                        case "Periodo orbital erro max":
                            return "where nomePlaneta LIKE '%" + valor + "%'";
                        case "periodoOrbitalErroMax":
                            return "where nomePlaneta LIKE '%" + valor + "%'";
                        case "Inclinação":
                            return "where inclinacao LIKE '%" + valor + "%'";
                        case "Inclinação erro min":
                            return "where inclinacaoErroMin LIKE '%" + valor + "%'";
                        case "Inclinação erro max":
                            return "where inclinacaoErroMax LIKE '%" + valor + "%'";
                        case "Distancia angular":
                            return "where distanciaAngular LIKE '%" + valor + "%'";
                        case "Descoberta":
                            return "where descoberta LIKE '%" + valor + "%'";
                        case "Atualização":
                            return "where atualizacao LIKE '%" + valor + "%'";
                        case "Tempo calculado":
                            return "where tempoCalculado LIKE '%" + valor + "%'";
                        case "Tempo médido":
                            return "where tempoMedido LIKE '%" + valor + "%'";
                        case "Status da publição":
                            return "where statusPublicacao LIKE '%" + valor + "%'";
                        case "Tipo de detecção":
                            return "where tipoDeteccao LIKE '%" + valor + "%'";
                        case "Tipo de detecção de massa":
                            return "where tipoDeteccaoMassa LIKE '%" + valor + "%'";
                        case "Tipo de detecção de raio":
                            return "where tipoDeteccaoRaio LIKE '%" + valor + "%'";
                        case "Nome alternativo":
                            return "where nomeAlternativo LIKE '%" + valor + "%'";
                        case "Moleculas encontradas":
                            return "where moleculas LIKE '%" + valor + "%'";
                        default:
                            return "";
                    }     
                }
            }
            return "";
        }
        return "";
    }

    public String selecionaWherePlaneta(String buscar, String valor1,String valor2) {

        if (valor1 != null && valor2 != null) {
            if (!valor1.trim().isEmpty() && !valor2.trim().isEmpty()) {
                    switch (buscar) {
                        case "ID":
                            return "where idPlaneta >= '" + valor1 + "' and idPlaneta <= '" + valor2 + "'";
                        case "Massa erro min":
                            return "where massaErroMin >= '" + valor1 + "' and massaErroMin <= '" + valor2 + "'";
                        case "Massa erro max":
                            return "where massaErroMax >= '" + valor1 + "' and massaErroMax <= '" + valor2 + "'";
                        case "Massa":
                            return "where massa >= '" + valor1 + "' and massa <= '" + valor2 + "'";
                        case "Raio":
                            return "where raio >= '" + valor1 + "' and raio <= '" + valor2 + "'";
                        case "Raio erro min":
                            return "where raioErroMin >= '" + valor1 + "' and raioErroMin <= '" + valor2 + "'";
                        case "Raio erro max":
                            return "where raioErroMax >= '" + valor1 + "' and raioErroMax <= '" + valor2 + "'";
                        case "Periodo orbital":
                            return "periodoOrbital >= '" + valor1 + "' and periodoOrbital <= '" + valor2 + "'";
                        case "Periodo orbital erro min":
                            return "where periodoOrbitalErroMin >= '" + valor1 + "' and periodoOrbitalErroMin <= '" + valor2 + "'";
                        case "Periodo orbital erro max":
                            return "where nomePlaneta >= '" + valor1 + "' and nomePlaneta <= '" + valor2 + "'";
                        case "periodoOrbitalErroMax":
                            return "where nomePlaneta >= '" + valor1 + "' and nomePlaneta <= '" + valor2 + "'";
                        case "Inclinação":
                            return "where inclinacao >= '" + valor1 + "' and inclinacao <= '" + valor2 + "'";
                        case "Inclinação erro min":
                            return "where inclinacaoErroMin >= '" + valor1 + "' and inclinacaoErroMin <= '" + valor2 + "'";
                        case "Inclinação erro max":
                            return "where inclinacaoErroMax >= '" + valor1 + "' and inclinacaoErroMax <= '" + valor2 + "'";
                        case "Distancia angular":
                            return "where distanciaAngular >= '" + valor1 + "' and distanciaAngular <= '" + valor2 + "'";
                        case "Descoberta":
                            return "where descoberta >= '" + valor1 + "' and descoberta <= '" + valor2 + "'";
                        case "Atualização":
                            return "where atualizacao >= '" + valor1 + "' and atualizacao <= '" + valor2 + "'";
                        case "Tempo calculado":
                            return "where tempoCalculado >= '" + valor1 + "' and tempoCalculado <= '" + valor2 + "'";
                        case "Tempo médido":
                            return "where tempoMedido >= '" + valor1 + "' and tempoMedido <= '" + valor2 + "'";
                        case "Status da publição":
                            return "where statusPublicacao >= '" + valor1 + "' and statusPublicacao <= '" + valor2 + "'";
                        case "Tipo de detecção":
                            return "where tipoDeteccao >= '" + valor1 + "' and tipoDeteccao <= '" + valor2 + "'";
                        case "Tipo de detecção de massa":
                            return "where tipoDeteccaoMassa >= '" + valor1 + "' and tipoDeteccaoMassa <= '" + valor2 + "'";
                        case "Tipo de detecção de raio":
                            return "where tipoDeteccaoRaio >= '" + valor1 + "' and tipoDeteccaoRaio <= '" + valor2 + "'";
                        case "Nome alternativo":
                            return "where nomeAlternativo >= '" + valor1 + "' and nomeAlternativo <= '" + valor2 + "'";
                        case "Moleculas encontradas":
                            return "where moleculas >= '" + valor1 + "' and moleculas <= '" + valor2 + "'";
                        default:
                            return "";
                    }
            }
            return "";
        }
        return "";
    }
    
    public ArrayList<String[]> listaPlanetas(String busca, String valor, boolean literal) {
        ArrayList< String[]> ArrayPlanetas = new ArrayList< String[]>();
        Planeta planetas;
        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        Iterator i = sessao.createQuery("from Planeta " + selecionaWherePlaneta(busca, valor, literal)).list().iterator();
        while (i.hasNext()) {
            planetas = (Planeta) i.next();
            ArrayPlanetas.add(new String[]{
                planetas.getId().getIdPlaneta() + "",
                planetas.getNomePlaneta() + "",
                planetas.getEstrelas().getNome(),
                planetas.getMassa() + "",
                planetas.getMassaErroMin() + "",
                planetas.getMassaErroMax() + "",
                planetas.getPeriodoOrbital() + "",
                planetas.getMassaErroMin() + "",
                planetas.getMassaErroMax() + "",
                planetas.getInclinacao() + "",
                planetas.getInclinacaoErroMin() + "",
                planetas.getInclinacaoErroMax() + "",
                planetas.getDistanciaAngular() + "",
                planetas.getDescoberta() + "",
                planetas.getAtualizacao() + "",
                planetas.getTempoCalculado() + "",
                planetas.getTempoMedido() + "",
                planetas.getStatusPublicacao() + "",
                planetas.getTipoDeteccao() + "",
                planetas.getTipoDeteccaoMassa() + "",
                planetas.getTipoDeteccaoRaio() + "",
                planetas.getNomeAlternativo() + "",
                planetas.getMoleculas() + ""
            });
        }
        sessao.close();
        return ArrayPlanetas;
    }
    public void iniciarConexao(){
        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        sessao.close();
    }
    public ArrayList<String[]> listaPlanetas(String busca, String valor1, String valor2) {
        ArrayList< String[]> ArrayPlanetas = new ArrayList< String[]>();
        Planeta planetas;
        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        Iterator i = sessao.createQuery("from Planeta " + selecionaWherePlaneta(busca, valor1, valor2)).list().iterator();
        while (i.hasNext()) {
            planetas = (Planeta) i.next();
            ArrayPlanetas.add(new String[]{
                planetas.getId().getIdPlaneta() + "",
                planetas.getNomePlaneta() + "",
                planetas.getEstrelas().getNome(),
                planetas.getMassa() + "",
                planetas.getMassaErroMin() + "",
                planetas.getMassaErroMax() + "",
                planetas.getPeriodoOrbital() + "",
                planetas.getMassaErroMin() + "",
                planetas.getMassaErroMax() + "",
                planetas.getInclinacao() + "",
                planetas.getInclinacaoErroMin() + "",
                planetas.getInclinacaoErroMax() + "",
                planetas.getDistanciaAngular() + "",
                planetas.getDescoberta() + "",
                planetas.getAtualizacao() + "",
                planetas.getTempoCalculado() + "",
                planetas.getTempoMedido() + "",
                planetas.getStatusPublicacao() + "",
                planetas.getTipoDeteccao() + "",
                planetas.getTipoDeteccaoMassa() + "",
                planetas.getTipoDeteccaoRaio() + "",
                planetas.getNomeAlternativo() + "",
                planetas.getMoleculas() + ""
            });
        }
        sessao.close();
        return ArrayPlanetas;
    }
    
}
