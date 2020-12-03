import java.util.ArrayList;

public class ProducaoAcademica {
    public String Titulo,NomeConferencia,projeto;
    public int ano;
    public ArrayList<Colaboradores> Autores;

    public ProducaoAcademica(String titulo,String nome,int ano,String projeto)
    {
        this.Titulo = titulo;
        this.NomeConferencia = nome;
        this.ano = ano;
        this.projeto = projeto;
        this.Autores = new ArrayList<Colaboradores>();
    }
}
