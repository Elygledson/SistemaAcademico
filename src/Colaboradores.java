import java.util.ArrayList;

public class Colaboradores {
    public String nome,tipo,email;
    /*projetos que está participando ou participou*/
    public ArrayList<String> projetos; 
    /*publicações feitas*/
    public ArrayList<ProducaoAcademica> producao;

    public Colaboradores(String nome,String tipo,String email)
    {
        this.nome = nome;
        this.tipo = tipo;
        this.email = email;
        this.projetos= new ArrayList<String>();
        this.producao = new ArrayList<ProducaoAcademica>();
    }
    public void Mostrar()
    {
        System.out.println(this.nome + this.tipo + this.email);
    }
    public void AdicionarProjetos(String NomedoProjeto)
    {
        this.projetos.add(NomedoProjeto);
    }
}
