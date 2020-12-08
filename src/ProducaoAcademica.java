import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ProducaoAcademica implements Comparable<ProducaoAcademica>{

    public String Titulo,NomeConferencia,Local,Tipo;

    public Integer Ano;

    public ArrayList<String> Autores = new ArrayList<String>();
    /*projetos associados as publlicações*/
    public ArrayList<String> Projetos = new ArrayList<String>();
    /*nomes dos alunos orientados*/
    public ArrayList<String> Alunos = new ArrayList<String>();
    /*texto publicaçõe*/
    public ArrayList<String> publicacao =  new ArrayList<String>();
     /*texto orientacao*/
    public ArrayList<String> orientacao = new ArrayList<String>();

    public String getAluno(int i)
    {
        if(this.Alunos.get(i) != null)
            return this.Alunos.get(i);

        return "Não há aluno(a) associado(a).";
    }

    public String getProjeto(int i)
    {
        if(this.Projetos.get(i) != null)
            return this.Projetos.get(i);

        return "Não há projeto associado.";
    }

    public String getAutores(int i)
    {
        if(this.Autores.get(i) != null)
            return this.Autores.get(i);

        return "Não há autor(es) associado(s).";
    }

    public static void Sort(ArrayList<ProducaoAcademica> producoes) {
        Collections.sort(producoes);
    }

    public Date getDateTime() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy"); 
        var ano = Integer.toString(this.Ano);
        Date data = (Date) formato.parse(ano);
        return data;
    }

    @Override
    public int compareTo(ProducaoAcademica producao) {
        try {
            return getDateTime().compareTo(producao.getDateTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getTitulo()
    {
        return this.Titulo;
    }
    public String getTipo()
    {
        return (this.Tipo != null ) ? this.Tipo : "Não há produções";
    }

    public String getLocal()
    {
        return this.Local;
    }

    public String getNome()
    {
        return this.NomeConferencia;
    }

    public Integer getAno()
    {
        return this.Ano;
    }

    public void setTitulo(String get)
    {
        this.Titulo = get;
    }

    public void setTipo(String get)
    {
        this.Tipo = get;
    }

    public void setNome(String get)
    {
        this.NomeConferencia = get;
    }

    public void setLocal(String get)
    {
        this.Local = get;
    }

    public void setAno(Integer ano)
    {
        this.Ano = ano;
    }

}

