public class Colaboradores {
    public String nome,tipo;
    public String[] participando = new String[1000];

    public Colaboradores(String nome,String tipo)
    {
        this.nome = nome;
        this.tipo = tipo;
    }
    public void AdicionarProjetos(String NomedoProjeto)
    {
        var size = this.participando.length;
        this.participando[0] = NomedoProjeto;
        size = size+1;
    }
    public void MostraParticipante()
    {
        var size = this.participando.length;
        System.out.printf("%s\n%s\n%s ",this.nome,this.tipo,this.participando[size - 1]);
    }

}
