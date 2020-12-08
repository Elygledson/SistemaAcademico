import java.util.Scanner;
import java.util.ArrayList;


public class Admin {
    public static void main(String[] args) {
        
        boolean flag = true;

        Scanner input = new Scanner(System.in);

        Sistema sistema = new Sistema();

        ArrayList<Colaboradores> colaboradores = new ArrayList<Colaboradores>();

        ArrayList<Projetos> projetos = new ArrayList<Projetos>();
        while(flag){
        System.out.println("\nSelecione uma opção:");
        System.out.println("[1] - Cadastrar projeto.");
        System.out.println("[2] - Cadastrar participante.");
        System.out.println("[3] - Cadastrar produção academica");
        System.out.println("[4] - Alocar participante a projeto.");
        System.out.println("[5] - Alterar status de projeto");
        System.out.println("[6] - Consultar projeto");
        System.out.println("[7] - Consultar colaborador");
        System.out.println("[8] - Listar projetos");
        System.out.println("[9] - Sair.\n");

        var comando = Integer.parseInt(input.nextLine());

        int index,getResponse;

        System.out.printf("Opção [%d]\n",comando);
        switch (comando){
            case 1:
                projetos.add(Sistema.CadastrarProjeto());
                Projetos.Sort(projetos);
                System.out.println("\nProjeto adicionado!");
                break;
            case 2:
                colaboradores.add(Sistema.AdicionarColaborador(colaboradores));
                System.out.println("\nColaborador(a) adicionado!");
                break;
            case 3:
                getResponse = Sistema.BuscarColaborador(colaboradores);
                if(getResponse == -1)break;
                colaboradores.get(getResponse).producao.add(Sistema.CadastrarProducao(colaboradores.get(getResponse).getNome()));
                break;
            case 4:
                 index = Sistema.BuscarColaborador(colaboradores);
                if(index == -1)break;
                colaboradores.get(index).AddProjeto(projetos,colaboradores.get(index));
                break;
            case 5:
                getResponse = Sistema.PainelGerencia(colaboradores,projetos);
                if(getResponse == -1)break;
                projetos.get(getResponse - 1).setStatus();
               break;
            case 6:
                index = Sistema.BuscarProjeto(projetos);
                if(index == -1)break;
                projetos.get(index - 1).ListarProjeto();
                break;
            case 7:
                index = Sistema.BuscarColaborador(colaboradores);
                if(index == -1)break;
                colaboradores.get(index).ListarColaborador();
                break;
            case 8:
                Sistema.ListarProjetos(projetos);
            case 9:
                flag = false;
                break;
            default:
             System.out.println("Opção inválida!Tente novamente.");
             break;
    }
}
input.close();
}
}
