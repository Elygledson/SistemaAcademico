import java.util.ArrayList;

public class Colaboradores {
    public String nome,tipo;
    public ArrayList<String> Projetos;

    public Colaboradores(String nome,String tipo)
    {
        this.nome = nome;
        this.tipo = tipo;
        Projetos = new ArrayList<String>();
    }
    public void AdicionarProjetos(String NomedoProjeto)
    {
        this.Projetos.add(NomedoProjeto);
    }
    public void MostraParticipante()
    {
        System.out.printf("%s  %s  %s ",this.nome,this.tipo,this.Projetos.get(0));
        System.out.println(this.Projetos.size());
    }
}
