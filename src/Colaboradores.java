import java.util.Scanner;

import java.util.ArrayList;

public class Colaboradores {
    public String nome,tipo,email,grau;

    private Integer SecretCode;
    /*projetos que está participando ou participou*/
    public ArrayList<Projetos> projetos; 
    /*publicações feitas*/
    public ArrayList<ProducaoAcademica> producao;

    public static Scanner input = new Scanner(System.in);

    public Colaboradores(String nome,String tipo,String email,String grau,Integer SecretCode){
        this.nome = nome;
        this.tipo = tipo;
        this.grau = grau;
        this.email = email;
        this.SecretCode = SecretCode;
        this.projetos= new ArrayList<Projetos>();
        this.producao = new ArrayList<ProducaoAcademica>();
    }

    public String getNome()
    {
        return this.nome;
    }   
    
    public Integer getSecretCode()
    {
        return this.SecretCode;
    }
    
    public String getEmail()
    {
        return this.email;
    }

    public static boolean VerificarEmail(String email,ArrayList<Colaboradores> colaboradores)
    {
        for (int i = 0;i < colaboradores.size();i++) {
            if(email.equals(colaboradores.get(i).email)){
                return true;
            }
        }
        return false;
    }


    public void AddProjeto(ArrayList<Projetos> ProjCadastrados,Colaboradores colaborador)
    {
        if(ProjCadastrados.size() == 0){
            System.out.println("\nNenhum projeto cadastrado!\n");
            return;
        }
        var getInput = Sistema.BuscarProjeto(ProjCadastrados);

        if(Projetos.Verificacao(colaborador,ProjCadastrados.get(getInput - 1).Titulo)){
            System.out.println("ERRO: você já está participando desse projeto!\n");
            return;
        }

        if(colaborador.grau.equals("GRADUAÇÂO"))
        {
            if(colaborador.projetos.size() < 2 && ProjCadastrados.get(getInput - 1).Status.equals("EM ELABORAÇÃO"))
            {
                this.projetos.add(ProjCadastrados.get(getInput - 1));
                ProjCadastrados.get(getInput - 1).participantes.add(colaborador);
                System.out.println("Colaborador(a) associado ao projeto!");
                return;
            }
            else{
              System.out.println("De acordo com as regras do sistema alunos de graduação não pode está em mais de dois projetos.");
              System.out.println("O cadastramento de alunos a projetos só é permitido quando o projeto está em elaboração.");
              return;
            }
        }
        else{
            if(ProjCadastrados.get(getInput - 1).Status.equals("EM ELABORAÇÃO")){
            this.projetos.add(ProjCadastrados.get(getInput - 1));
            ProjCadastrados.get(getInput - 1).participantes.add(colaborador);
            System.out.println("Colaborador(a) associado ao projeto!");
            }
            else{
                System.out.println("Aviso: a operação falhou pois esse projeto já está em andamento.");
            }
        }
    }

    public void ListarColaborador()
    {
        System.out.println("\nDados do colaborador:\n");
        System.out.printf("[NOME]  ->%s \n[TIPO]  ->[%s|%s]\n",this.nome,this.tipo,this.grau);
       
        if(this.projetos.isEmpty()){ 
            System.out.printf("AVISO: No momento  ''%s'' não está participando de nenhum projeto.\n",this.nome);
            return;
        }
        System.out.printf("\n %s está participando dos projetos abaixo:n\n",this.nome);
        for(int i = 0; i < this.projetos.size();i++){
            if(this.projetos.get(i).Status.equals("EM ELABORAÇÃO")){
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\nProjetos em elaboração\n");
            System.out.printf("[OPÇÃO]\n[%d] - [STATUS] -> ''%s'' [TÍTULO] -> %s [DATA INÍCIO] -> %s [DATA TERMINO] -> %s [FINANCIADORA] -> %s [VALOR] -> R$%.2f \n",
            i + 1,this.projetos.get(i).Status,this.projetos.get(i).Titulo,this.projetos.get(i).DataInicio,
            this.projetos.get(i).DataTermino,this.projetos.get(i).A_financiadora,this.projetos.get(i).Valor);
            }
            if(this.projetos.get(i).Status.equals("EM ANDAMENTO")){
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("\nProjetos em andamento\n");
                System.out.printf("[OPÇÃO]\n[%d] - [STATUS] -> ''%s'' [TÍTULO] -> %s [DATA INÍCIO] -> %s [DATA TERMINO] -> %s [FINANCIADORA] -> %s [VALOR] -> R$ %.2f \n",
                i + 1,this.projetos.get(i).Status,this.projetos.get(i).Titulo,this.projetos.get(i).DataInicio,
                this.projetos.get(i).DataTermino,this.projetos.get(i).A_financiadora,this.projetos.get(i).Valor);
            }
            if(this.projetos.get(i).Status.equals("CONCLUÍDO"))
            {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("\nProjetos concluídos\n");
                System.out.printf("[OPÇÃO]\n[%d] - [STATUS] -> ''%s'' [TÍTULO] -> %s [DATA INÍCIO] -> %s [DATA TERMINO] -> %s [FINANCIADORA] -> %s [VALOR] -> R$ %.2f \n",
                i + 1,this.projetos.get(i).Status,this.projetos.get(i).Titulo,this.projetos.get(i).DataInicio,
                this.projetos.get(i).DataTermino,this.projetos.get(i).A_financiadora,this.projetos.get(i).Valor);
            }
        }
    }

    public static void ListarColaboradores(ArrayList<Colaboradores> colaboradores)
    {

        if(colaboradores.isEmpty()){
            System.out.println("Ainda não há colaboradores cadastrados!");
            return;
        }

        for(int i = 0;i < colaboradores.size();i++)
        {

            System.out.println("\nDados do colaborador:\n");
            System.out.printf("[NOME]  ->%s \n[TIPO]  ->[%s|%s]\n",colaboradores.get(i).nome,colaboradores.get(i).tipo,colaboradores.get(i).grau);
           
            if(colaboradores.get(i).projetos.isEmpty()){ 
                System.out.printf("AVISO: No momento  ''%s'' não está participando de nenhum projeto.\n",colaboradores.get(i).nome); continue;
            }

            System.out.println("Participando dos projetos:");
            for(int j = 0; j < colaboradores.get(i).projetos.size(); j++){
                
                System.out.printf("[%d] [TITULO] -> %s \n  [DATA INÍCIO] -> %s [DATA TERMINO] -> %s \n  [FINANCIADOR] -> %s \n  [VALOR] ->R$ %.2f\n",j + 1,
                colaboradores.get(i).projetos.get(j).Titulo,colaboradores.get(i).projetos.get(j).DataInicio,colaboradores.get(i).projetos.get(j).DataTermino,
                colaboradores.get(i).projetos.get(j).A_financiadora,colaboradores.get(i).projetos.get(j).Valor);
            }

        }
    }
}
