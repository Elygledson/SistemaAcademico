import java.util.ArrayList;

public class ProducaoAcademica {
    public String Titulo,NomeConferencia,Local,Tipo;
    public int Ano;
    public ArrayList<Colaboradores> Autores;
    /*projetos associados as publlicações*/
    public ArrayList<Projetos> projetos; 

    public ProducaoAcademica(String titulo,String nome,int ano,String tipo,String local)
    {
        this.Titulo = titulo;
        this.NomeConferencia = nome;
        this.Ano = ano;
        this.Tipo  = tipo;
        this.Local = local;
        this.Autores = new ArrayList<Colaboradores>();
        this.projetos = new ArrayList<Projetos>();
    }

    static void CadastrarProducao()
    {
        
    }
}
