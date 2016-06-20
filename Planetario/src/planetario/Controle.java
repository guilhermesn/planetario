/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl.Work;
import org.hibernate.internal.SessionImpl;
import static org.hibernate.internal.util.collections.CollectionHelper.arrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;

/**
 *
 * @author guilherme
 */
public class Controle {

    private Object conn;

    public String selecionaWhereEstrela(String buscar, String valor, boolean literal) {
        if (valor != null) {
            if (!valor.trim().isEmpty()) {
                if (literal) {
                    switch (buscar) {
                        case "ID":
                            return "where ra = '" + valor + "'";
                        case "Nome":
                            return "where nome = '" + valor + "'";
                        case "Distancia":
                            return "where distancia = '" + valor + "'";
                        case "Metalicidade":
                            return "where metalicidade = '" + valor + "'";
                        case "Massa":
                            return "where massa = '" + valor + "'";
                        case "Idade":
                            return "where idade = '" + valor + "'";
                        case "Temperatura":
                            return "where temperatura = '" + valor + "'";
                        case "Raio":
                            return "where raio = '" + valor + "'";
                        case "dec_2":
                            return "where dec_2 = '" + valor + "'";
                        default:
                            return "";
                    }
                } else {
                    switch (buscar) {
                        case "ID":
                            return "where ra LIKE '%" + valor + "%'";
                        case "Nome":
                            return "where nome LIKE '%" + valor + "%'";
                        case "Distancia":
                            return "where distancia LIKE '%" + valor + "%'";
                        case "Metalicidade":
                            return "where metalicidade LIKE '%" + valor + "%'";
                        case "Massa":
                            return "where massa LIKE '%" + valor + "%'";
                        case "Idade":
                            return "where idade LIKE '%" + valor + "%'";
                        case "Temperatura":
                            return "where temperatura LIKE '%" + valor + "%'";
                        case "Raio":
                            return "where raio LIKE '%" + valor + "%'";
                        case "dec_2":
                            return "where dec_2 LIKE '%" + valor + "%'";
                        default:
                            return "";
                    }
                }
            }
        }
        return "";
    }

    public String selecionaWhereEstrela(String buscar, String valor, String valor2) {
        if (valor != null) {
            if (!valor.trim().isEmpty()) {
                switch (buscar) {
                    case "ID":
                        return "where ra >= '" + valor + "' and ra <= '" + valor2 + "'";
                    case "Nome":
                        return "where nome >= '" + valor + "' and nome <= '" + valor2 + "'";
                    case "Distancia":
                        return "where distancia >= '" + valor + "' and distancia <= '" + valor2 + "'";
                    case "Metalicidade":
                        return "where metalicidade >= '" + valor + "' and metalicidade <= '" + valor2 + "'";
                    case "Massa":
                        return "where massa >= '" + valor + "' and massa <= '" + valor2 + "'";
                    case "Idade":
                        return "where idade >= '" + valor + "' and idade <= '" + valor2 + "'";
                    case "Temperatura":
                        return "where temperatura >= '" + valor + "' and temperatura <= '" + valor2 + "'";
                    case "Raio":
                        return "where raio >= '" + valor + "' and raio <= '" + valor2 + "'";
                    case "dec_2":
                        return "where dec_2 >= '" + valor + "' and dec_2 <= '" + valor2 + "'";
                    default:
                        return "";
                }

            }
        }
        return "";
    }

    public void salvarPDF(String camilho, ArrayList dados) throws Exception {
        PDF doc = new PDF();
        try {
            doc.criarPDF(camilho, dados);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                } else {
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

    public String selecionaWherePlaneta(String buscar, String valor1, String valor2) {

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

    public ArrayList<String[]> listaEstrelas(String busca, String valor, boolean literal) {
        ArrayList< String[]> ArrayEstrelas = new ArrayList< String[]>();
        Estrelas listaEstrela;
        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        Iterator i = sessao.createQuery("from Estrelas " + selecionaWhereEstrela(busca, valor, literal)).list().iterator();
        while (i.hasNext()) {
            listaEstrela = (Estrelas) i.next();
            ArrayEstrelas.add(new String[]{
                listaEstrela.getRa() + "",
                listaEstrela.getNome() + "",
                listaEstrela.getRaio() + "",
                listaEstrela.getDec2() + "",
                listaEstrela.getDistancia() + "",
                listaEstrela.getMetalicidade() + "",
                listaEstrela.getMassa() + "",
                listaEstrela.getIdade() + "",
                listaEstrela.getTemperatura() + ""
            });
        }
        sessao.close();
        return ArrayEstrelas;
    }

    public ArrayList<String[]> listaEstrelas(String busca, String valor, String valor2) {
        ArrayList< String[]> ArrayEstrelas = new ArrayList< String[]>();
        Estrelas listaEstrela;
        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        Iterator i = sessao.createQuery("from Estrelas " + selecionaWhereEstrela(busca, valor, valor2)).list().iterator();
        while (i.hasNext()) {
            listaEstrela = (Estrelas) i.next();
            ArrayEstrelas.add(new String[]{
                listaEstrela.getRa() + "",
                listaEstrela.getNome() + "",
                listaEstrela.getRaio() + "",
                listaEstrela.getDec2() + "",
                listaEstrela.getDistancia() + "",
                listaEstrela.getMetalicidade() + "",
                listaEstrela.getMassa() + "",
                listaEstrela.getIdade() + "",
                listaEstrela.getTemperatura() + ""
            });
        }
        sessao.close();
        return ArrayEstrelas;
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
                planetas.getMoleculas() + "",
                planetas.getRaio() + "",
                planetas.getRaioErroMin() + "",
                planetas.getRaioErroMax() + ""
            });
        }
        sessao.close();
        return ArrayPlanetas;
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
                planetas.getMoleculas() + "",
                planetas.getRaio() + "",
                planetas.getRaioErroMin() + "",
                planetas.getRaioErroMax() + ""
            });
        }
        sessao.close();
        return ArrayPlanetas;
    }

    public Estrelas getEstrela(String valor) {
        Estrelas estrela;
        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        Iterator i = sessao.createQuery("from Estrelas " + "where nome = '" + valor + "'").list().iterator();
        estrela = (Estrelas) i.next();
        sessao.close();
        return estrela;
    }

    public Planeta getPlaneta(String valor) {
        Planeta planetas;
        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        Iterator i = sessao.createQuery("from Planeta " + "where idPlaneta = '" + valor + "'").list().iterator();
        planetas = (Planeta) i.next();
        sessao.close();
        return planetas;
    }

    public void cadastrarPlaneta(String[] planeta) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatterMYSQL = new SimpleDateFormat("yyyy/MM/dd");

        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        Planeta planetas = new Planeta();
        PlanetaId planetaid = new PlanetaId();

        planetaid.setEstrelasNome(planeta[25]);
        planetaid.setIdPlaneta(1);

        planetas.setId(planetaid);

        if (!planeta[1].trim().isEmpty()) {
            planetas.setNomePlaneta(planeta[1].toString());
        }
        if (!planeta[2].trim().isEmpty()) {
            planetas.setNomeAlternativo(planeta[2].toString());
        }
        if (!planeta[3].trim().isEmpty()) {
            planetas.setMassa(Float.parseFloat(planeta[3]));
        }
        if (!planeta[4].trim().isEmpty()) {
            planetas.setMassaErroMin(Float.parseFloat(planeta[4]));
        }
        if (!planeta[5].trim().isEmpty()) {
            planetas.setMassaErroMax(Float.parseFloat(planeta[5]));
        }
        if (!planeta[6].trim().isEmpty()) {
            planetas.setRaio(Float.parseFloat(planeta[6]));
        }
        if (!planeta[7].trim().isEmpty()) {
            planetas.setRaioErroMin(Float.parseFloat(planeta[7]));
        }
        if (!planeta[8].trim().isEmpty()) {
            planetas.setRaioErroMax(Float.parseFloat(planeta[8]));
        }
        if (!planeta[9].trim().isEmpty()) {
            planetas.setPeriodoOrbital(Float.parseFloat(planeta[9]));
        }
        if (!planeta[10].trim().isEmpty()) {
            planetas.setPeriodoOrbitalErroMin(Float.parseFloat(planeta[10]));
        }
        if (!planeta[11].trim().isEmpty()) {
            planetas.setPeriodoOrbitalErroMax(Float.parseFloat(planeta[11]));
        }
        if (!planeta[12].trim().isEmpty()) {
            planetas.setInclinacao(Float.parseFloat(planeta[12]));
        }
        if (!planeta[13].trim().isEmpty()) {
            planetas.setInclinacaoErroMin(Float.parseFloat(planeta[13]));
        }
        if (!planeta[14].trim().isEmpty()) {
            planetas.setInclinacaoErroMax(Float.parseFloat(planeta[14]));
        }
        if (!planeta[15].trim().isEmpty()) {
            java.util.Date date = formatter.parse(planeta[15]);
            String data2 = formatterMYSQL.format(date);
            planetas.setAtualizacao(formatterMYSQL.parse(data2));
        }
        if (!planeta[16].trim().isEmpty()) {
            planetas.setDescoberta(Integer.parseInt(planeta[16]));
        }
        if (!planeta[17].trim().isEmpty()) {
            planetas.setTempoCalculado(Integer.parseInt(planeta[17]));
        }
        if (!planeta[18].trim().isEmpty()) {
            planetas.setDistanciaAngular(Float.parseFloat(planeta[18]));
        }
        if (!planeta[19].trim().isEmpty()) {
            planetas.setStatusPublicacao(planeta[19].toString());
        }
        if (!planeta[20].trim().isEmpty()) {
            planetas.setTipoDeteccao(planeta[20].toString());
        }
        if (!planeta[21].trim().isEmpty()) {
            planetas.setTipoDeteccaoMassa(planeta[21].toString());
        }
        if (!planeta[22].trim().isEmpty()) {
            planetas.setTipoDeteccaoMassa(planeta[22].toString());
        }
        if (!planeta[23].trim().isEmpty()) {
            planetas.setTipoDeteccaoRaio(planeta[23].toString());
        }
        if (!planeta[24].trim().isEmpty()) {
            planetas.setTempoMedido(Integer.parseInt(planeta[24]));
        }

        sessao.save(planetas);

        Transaction tr = sessao.beginTransaction();

        tr.commit();
        sessao.close();

    }

    public void cadastrarEstrela(String[] estrelaExluir) throws ParseException {

        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        Estrelas estrela = new Estrelas();

        if (!estrelaExluir[0].trim().isEmpty()) {
            estrela.setRa(Float.parseFloat(estrelaExluir[0]));
        }

        if (!estrelaExluir[2].trim().isEmpty()) {
            estrela.setDec2(Float.parseFloat(estrelaExluir[2]));
        }
        if (!estrelaExluir[3].trim().isEmpty()) {
            estrela.setMetalicidade(Float.parseFloat(estrelaExluir[3]));
        }
        if (!estrelaExluir[4].trim().isEmpty()) {
            estrela.setDistancia(Float.parseFloat(estrelaExluir[4]));
        }
        if (!estrelaExluir[5].trim().isEmpty()) {
            estrela.setRaio(Float.parseFloat(estrelaExluir[5]));
        }
        if (!estrelaExluir[6].trim().isEmpty()) {
            estrela.setMassa(Float.parseFloat(estrelaExluir[6]));
        }
        if (!estrelaExluir[7].trim().isEmpty()) {
            estrela.setTemperatura(Float.parseFloat(estrelaExluir[7]));
        }
        if (!estrelaExluir[8].trim().isEmpty()) {
            estrela.setIdade(Float.parseFloat(estrelaExluir[8]));
        }

        sessao.save(estrela);

        Transaction tr = sessao.beginTransaction();

        tr.commit();
        sessao.close();

    }

    public void excluirPlaneta(String valor) {

        Planeta planetas = new Planeta();
        planetas = getPlaneta(valor);
        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        sessao.delete(planetas);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
        sessao.close();
    }

    public void excluirEstrela(String valor) {

        Estrelas estrela = new Estrelas();
        estrela = getEstrela(valor);
        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        sessao.delete(estrela);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
        sessao.close();
    }

    public void iniciarConexao() {
        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        sessao.close();
    }

    public void editarEstrela(String[] estrelaEdit) throws ParseException {

        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        Estrelas estrela = getEstrela(estrelaEdit[1]);

        if (!estrelaEdit[0].trim().isEmpty()) {
            estrela.setRa(Float.parseFloat(estrelaEdit[0]));
        }

        if (!estrelaEdit[2].trim().isEmpty()) {
            estrela.setDec2(Float.parseFloat(estrelaEdit[2]));
        }
        if (!estrelaEdit[3].trim().isEmpty()) {
            estrela.setMetalicidade(Float.parseFloat(estrelaEdit[3]));
        }
        if (!estrelaEdit[4].trim().isEmpty()) {
            estrela.setDistancia(Float.parseFloat(estrelaEdit[4]));
        }
        if (!estrelaEdit[5].trim().isEmpty()) {
            estrela.setRaio(Float.parseFloat(estrelaEdit[5]));
        }
        if (!estrelaEdit[6].trim().isEmpty()) {
            estrela.setMassa(Float.parseFloat(estrelaEdit[6]));
        }
        if (!estrelaEdit[7].trim().isEmpty()) {
            estrela.setTemperatura(Float.parseFloat(estrelaEdit[7]));
        }
        if (!estrelaEdit[8].trim().isEmpty()) {
            estrela.setIdade(Float.parseFloat(estrelaEdit[8]));
        }

        sessao.update(estrela);
        Transaction tr = sessao.beginTransaction();

        tr.commit();
        sessao.close();

    }

    public void editarPlaneta(String[] planeta) throws ParseException {

        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        Planeta planetas = getPlaneta(planeta[0]);

        //System.out.print(planetas.getNomePlaneta());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatterMYSQL = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date date = formatter.parse(planeta[15]);
        String data2 = formatterMYSQL.format(date).toString();

        //planetas.setId(id);
        if (!planeta[1].trim().isEmpty()) {
            planetas.setNomePlaneta(planeta[1].toString());
        }
        if (!planeta[2].trim().isEmpty()) {
            planetas.setNomeAlternativo(planeta[2].toString());
        }
        if (!planeta[3].trim().isEmpty()) {
            planetas.setMassa(Float.parseFloat(planeta[3]));
        }
        if (!planeta[4].trim().isEmpty()) {
            planetas.setMassaErroMin(Float.parseFloat(planeta[4]));
        }
        if (!planeta[5].trim().isEmpty()) {
            planetas.setMassaErroMax(Float.parseFloat(planeta[5]));
        }
        if (!planeta[6].trim().isEmpty()) {
            planetas.setRaio(Float.parseFloat(planeta[6]));
        }
        if (!planeta[7].trim().isEmpty()) {
            planetas.setRaioErroMin(Float.parseFloat(planeta[7]));
        }
        if (!planeta[8].trim().isEmpty()) {
            planetas.setRaioErroMax(Float.parseFloat(planeta[8]));
        }
        if (!planeta[9].trim().isEmpty()) {
            planetas.setPeriodoOrbital(Float.parseFloat(planeta[9]));
        }
        if (!planeta[10].trim().isEmpty()) {
            planetas.setPeriodoOrbitalErroMin(Float.parseFloat(planeta[10]));
        }
        if (!planeta[11].trim().isEmpty()) {
            planetas.setPeriodoOrbitalErroMax(Float.parseFloat(planeta[11]));
        }
        if (!planeta[12].trim().isEmpty()) {
            planetas.setInclinacao(Float.parseFloat(planeta[12]));
        }
        if (!planeta[13].trim().isEmpty()) {
            planetas.setInclinacaoErroMin(Float.parseFloat(planeta[13]));
        }
        if (!planeta[14].trim().isEmpty()) {
            planetas.setInclinacaoErroMax(Float.parseFloat(planeta[14]));
        }
        if (!planeta[15].trim().isEmpty()) {
            planetas.setAtualizacao(formatterMYSQL.parse(data2));
        }
        if (!planeta[16].trim().isEmpty()) {
            planetas.setDescoberta(Integer.parseInt(planeta[16]));
        }
        if (!planeta[17].trim().isEmpty()) {
            planetas.setTempoCalculado(Integer.parseInt(planeta[17]));
        }
        if (!planeta[18].trim().isEmpty()) {
            planetas.setDistanciaAngular(Float.parseFloat(planeta[18]));
        }
        if (!planeta[19].trim().isEmpty()) {
            planetas.setStatusPublicacao(planeta[19].toString());
        }
        if (!planeta[20].trim().isEmpty()) {
            planetas.setTipoDeteccao(planeta[20].toString());
        }
        if (!planeta[21].trim().isEmpty()) {
            planetas.setTipoDeteccaoMassa(planeta[21].toString());
        }
        if (!planeta[22].trim().isEmpty()) {
            planetas.setTipoDeteccaoMassa(planeta[22].toString());
        }
        if (!planeta[23].trim().isEmpty()) {
            planetas.setTipoDeteccaoRaio(planeta[23].toString());
        }
        if (!planeta[24].trim().isEmpty()) {
            planetas.setTempoMedido(Integer.parseInt(planeta[24]));
        }

        sessao.update(planetas);
        Transaction tr = sessao.beginTransaction();

        tr.commit();
        sessao.close();

    }

    public JFreeChart graficoRelacaoTamanhoCores2(float min, float max, float faixa, boolean ordem, boolean comparar) throws FileNotFoundException, IOException {

        CallableStatement cs = null;
        int planeta;
        if (comparar) {
            min = min / 317;
            max = max / 317;
        }
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        
        try {

            Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
            SessionImpl sessionImpl = (SessionImpl) sessao;
            Connection connection = sessionImpl.connection();
            
            cs = connection.prepareCall("{call selecionaporDTPlanetas(?,?,?,?,?,?,?,?,?,?,?)}");

            cs.setFloat(1, min);
            cs.setFloat(2, max);
            cs.registerOutParameter(3, java.sql.Types.INTEGER);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.registerOutParameter(5, java.sql.Types.INTEGER);
            cs.registerOutParameter(6, java.sql.Types.INTEGER);
            cs.registerOutParameter(7, java.sql.Types.INTEGER);
            cs.registerOutParameter(8, java.sql.Types.INTEGER);
            cs.registerOutParameter(9, java.sql.Types.INTEGER);
            cs.registerOutParameter(10, java.sql.Types.INTEGER);
            cs.registerOutParameter(11, java.sql.Types.INTEGER);

            cs.executeUpdate();
            

            if (ordem) {
                for (int i = 0; i < 9; i++) {

                    planeta = cs.getInt(i + 3);
                    if (comparar) {
                        ds.addValue(planeta, "maximo", String.format("%.1f", ((((max - min) / (9)) * (i + 1)) + min) * 317));
                    } else {
                        ds.addValue(planeta, "maximo", String.format("%.1f", ((((max - min) / (9)) * (i + 1)) + min)));
                    }
                }
            } else {
                for (int i = 8; i >= 0; i--) {
                    planeta = cs.getInt(i + 3);
                    if (comparar) {
                        ds.addValue(planeta, "maximo", String.format("%.1f", ((((max - min) / (9)) * (i + 1)) + min) * 317));
                    } else {
                        ds.addValue(planeta, "maximo", String.format("%.1f", ((((max - min) / (9)) * (i + 1)) + min)));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        JFreeChart grafico = ChartFactory.createBarChart("Relação de massa de planetas com a massa da Jupter", "tamanho", "Quantidade", ds, PlotOrientation.VERTICAL, true, true, false);
        if (comparar) {
            grafico = ChartFactory.createBarChart("Relação de massa de planetas com a massa da Terra", "tamanho", "Quantidade", ds, PlotOrientation.VERTICAL, true, true, false);
        }
        return grafico;

    }

    public void graficoRelacaoTamanhoCres() throws FileNotFoundException, IOException {

        // cria o conjunto de dados
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        /*Jupiter tem 317 a mais do que a massa da terra
         jupiter massa = 1
         Planetas com tamanho da terra 1/317 = 0.0031*/

        Planeta planeta = new Planeta();
        long planeta1, planeta2, planeta3, planeta4, planeta5, planeta6, planeta7, planeta8, planeta9;

        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        Query p1 = sessao.createQuery(" select count(massa) from Planeta where massa < 0.0031");
        Query p2 = sessao.createQuery(" select count(massa) from Planeta where massa < 0.15");
        Query p3 = sessao.createQuery(" select count(massa) from Planeta where massa < 0.07");
        Query p4 = sessao.createQuery(" select count(massa) from Planeta where massa < 1");
        Query p5 = sessao.createQuery(" select count(massa) from Planeta where massa < 5");
        Query p6 = sessao.createQuery(" select count(massa) from Planeta where massa < 10");
        Query p7 = sessao.createQuery(" select count(massa) from Planeta where massa < 25");
        Query p8 = sessao.createQuery(" select count(massa) from Planeta where massa < 50");
        Query p9 = sessao.createQuery(" select count(massa) from Planeta where massa < 100");

        planeta1 = (long) p1.uniqueResult();
        planeta2 = (long) p2.uniqueResult();
        planeta3 = (long) p3.uniqueResult();
        planeta4 = (long) p4.uniqueResult();
        planeta5 = (long) p5.uniqueResult();
        planeta6 = (long) p6.uniqueResult();
        planeta7 = (long) p7.uniqueResult();
        planeta8 = (long) p8.uniqueResult();
        planeta9 = (long) p9.uniqueResult();

        ds.addValue(planeta1, "maximo", "0.0031");
        ds.addValue(planeta2, "maximo", "0.15");
        ds.addValue(planeta3, "maximo", "0.07");
        ds.addValue(planeta4, "maximo", "1");
        ds.addValue(planeta5, "maximo", "5");
        ds.addValue(planeta6, "maximo", "10");
        ds.addValue(planeta7, "maximo", "25");
        ds.addValue(planeta8, "maximo", "50");
        ds.addValue(planeta9, "maximo", "100");

        JFreeChart grafico = ChartFactory.createBarChart("Relação de tamanho de planetas", "tamanho", "Quantidade", ds, PlotOrientation.VERTICAL, true, true, false);

        OutputStream arquivo = new FileOutputStream("grafico.png");
        ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
        arquivo.close();

    }

    public void graficoRelacaoTamanhoDecres() throws FileNotFoundException, IOException {

        // cria o conjunto de dados
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        /*Jupiter tem 317 a mais do que a massa da terra
         jupiter massa = 1
         Planetas com tamanho da terra 1/317 = 0.0031*/

        Planeta planeta = new Planeta();
        long planeta1, planeta2, planeta3, planeta4, planeta5, planeta6, planeta7, planeta8, planeta9;

        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();
        Query p1 = sessao.createQuery(" select count(massa) from Planeta where massa < 0.0031");
        Query p2 = sessao.createQuery(" select count(massa) from Planeta where massa < 0.15");
        Query p3 = sessao.createQuery(" select count(massa) from Planeta where massa < 0.07");
        Query p4 = sessao.createQuery(" select count(massa) from Planeta where massa < 1");
        Query p5 = sessao.createQuery(" select count(massa) from Planeta where massa < 5");
        Query p6 = sessao.createQuery(" select count(massa) from Planeta where massa < 10");
        Query p7 = sessao.createQuery(" select count(massa) from Planeta where massa < 25");
        Query p8 = sessao.createQuery(" select count(massa) from Planeta where massa < 50");
        Query p9 = sessao.createQuery(" select count(massa) from Planeta where massa < 100");

        planeta1 = (long) p1.uniqueResult();
        planeta2 = (long) p2.uniqueResult();
        planeta3 = (long) p3.uniqueResult();
        planeta4 = (long) p4.uniqueResult();
        planeta5 = (long) p5.uniqueResult();
        planeta6 = (long) p6.uniqueResult();
        planeta7 = (long) p7.uniqueResult();
        planeta8 = (long) p8.uniqueResult();
        planeta9 = (long) p9.uniqueResult();

        ds.addValue(planeta9, "maximo", "100");
        ds.addValue(planeta8, "maximo", "50");
        ds.addValue(planeta7, "maximo", "25");
        ds.addValue(planeta6, "maximo", "10");
        ds.addValue(planeta5, "maximo", "5");
        ds.addValue(planeta4, "maximo", "1");
        ds.addValue(planeta3, "maximo", "0.07");
        ds.addValue(planeta2, "maximo", "0.15");
        ds.addValue(planeta1, "maximo", "0.0031");

        JFreeChart grafico = ChartFactory.createBarChart("Relação de tamanho de planetas", "tamanho", "Quantidade", ds, PlotOrientation.VERTICAL, true, true, false);

        OutputStream arquivo = new FileOutputStream("grafico.png");
        ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
        arquivo.close();

    }

    public JFreeChart darkholeLikelihood(int cor, int disIni, int disFin) throws SQLException {

        JFreeChart grafico = null;
        long estrela1, estrela2;

        CallableStatement cs = null;

        DefaultPieDataset pieDataset = new DefaultPieDataset();

        Session sessao = PlanetarioHibernateUtil.getSessionFactory().openSession();

        try {
            SessionImpl sessionImpl = (SessionImpl) sessao;
            Connection connection = sessionImpl.connection();
            String sql = "{call selecionaEstrelasSize(?,?,?,?)}";
            cs = connection.prepareCall(sql);

            cs.setInt(1, disIni);
            cs.setInt(2, disFin);
            cs.registerOutParameter(3, java.sql.Types.INTEGER);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);

            cs.executeUpdate();

            int estrelaValor1 = cs.getInt(3);
            int estrelaValor2 = cs.getInt(4);

            /*  Query p1 = sessao.createQuery(" select count(massa) from Estrelas where massa < 2 and distancia between " + disIni + " and " + disFin);

             Query p2 = sessao.createQuery(" select count(massa) from Estrelas where massa >= 2 and massa < 10 and distancia between " + disIni + " and " + disFin); // Planetas que podem virar buracos negros

             estrela1 = (long) p1.uniqueResult();
             estrela2 = (long) p2.uniqueResult();*/
            String ESTRELA_STRING1 = "" + estrelaValor1 + " são até 2 vezes maiores que o sol";
            String ESTRELA_STRING2 = "" + estrelaValor2 + " são 2 vezes maiores que o sol";

            pieDataset.setValue(ESTRELA_STRING1, estrelaValor1);

            pieDataset.setValue(ESTRELA_STRING2, estrelaValor2);

            grafico = ChartFactory.createPieChart3D("Comparação de tamanhos de estrelas", pieDataset, true, true, false);

            PiePlot plot = (PiePlot) grafico.getPlot();

            if (cor == 1) {

                plot.setSectionPaint(ESTRELA_STRING1, Color.blue);
                plot.setSectionPaint(ESTRELA_STRING2, Color.black);
            }
            if (cor == 2) {
                plot.setSectionPaint(ESTRELA_STRING1, Color.red);
                plot.setSectionPaint(ESTRELA_STRING2, Color.yellow);
            }
            if (cor == 3) {
                plot.setSectionPaint(ESTRELA_STRING1, Color.black);
                plot.setSectionPaint(ESTRELA_STRING2, Color.red);
            }
            if (cor == 4) {
                plot.setSectionPaint(ESTRELA_STRING1, Color.green);
                plot.setSectionPaint(ESTRELA_STRING2, Color.yellow);
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
        return grafico;
    }

}
