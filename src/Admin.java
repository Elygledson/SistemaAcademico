import java.util.Scanner;
import java.util.ArrayList;


public class Admin {
    public static void main(String[] args) {
        
        boolean flag = true;

        Scanner input = new Scanner(System.in);

        ArrayList<Colaboradores> colaboradores = new ArrayList<Colaboradores>();

        ArrayList<Projetos> projetos = new ArrayList<Projetos>();
        while(flag){
        System.out.println("\nSelecione uma opção:");
        System.out.println("[1] - Cadastrar projeto.");
        System.out.println("[2] - Cadastrar participante.");
        System.out.println("[3] - Alocar participante a projeto.");
        System.out.println("[4] - Projetos disponíveis");
        System.out.println("[5] - Alterar status de projeto");
        System.out.println("[6] - Colaboradores cadastrados");
        System.out.println("[7] - Sair.\n");
        var comando = input.nextInt();
        System.out.printf("Opção [%d]\n",comando);
        switch (comando){
            case 1:
                projetos.add(Projetos.CadastrarProjeto());
                System.out.println("\nProjeto adicionado!");
                break;
            case 2:
                colaboradores.add(Colaboradores.AdicionarColaborador(colaboradores));
                System.out.println("\nColaborador(a) adicionado!");
                break;
            case 3:
               Colaboradores.BuscarColaborador(projetos,colaboradores);
               break;
            case 4:
                Projetos.ListarProjetos(projetos);
               break;
            case 5:
                Projetos.setStatus(projetos);
               break;
            case 6:
                Colaboradores.ListarColaboradores(colaboradores);
                break;
            case 7:
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
