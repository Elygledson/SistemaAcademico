import java.util.ArrayList;

public class ProducaoAcademica {
    public String Titulo,NomeConferencia,Projeto,Tipo;
    public int Ano;
    public ArrayList<Colaboradores> Autores;

    public ProducaoAcademica(String titulo,String nome,int ano,String projeto,String tipo)
    {
        this.Titulo = titulo;
        this.NomeConferencia = nome;
        this.Ano = ano;
        this.Projeto = projeto;
        this.Tipo  = tipo;
        this.Autores = new ArrayList<Colaboradores>();
    }
}
