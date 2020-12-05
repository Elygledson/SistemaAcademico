import java.util.Scanner;
import java.util.ArrayList;


public class Admin {
    public static void main(String[] args) {
        int comando = 0;
        Scanner input = new Scanner(System.in);
        ArrayList<Colaboradores> colaboradores = new ArrayList<Colaboradores>();
        ArrayList<Projetos> projetos = new ArrayList<Projetos>();

        while(comando != 7){
        System.out.println("\nSelecione uma opção:");
        System.out.println("[1] - Cadastrar projeto.");
        System.out.println("[2] - Cadastrar participante.");
        System.out.println("[3] - Cadastrar e associar publicação a um projeto.");
        System.out.println("[4] - Alocar participante a projeto.");
        System.out.println("[5] - Projetos disponíveis");
        System.out.println("[6] - Colaboradores cadastrados");
        System.out.println("[7] - Sair.\n");
        comando = input.nextInt();
        System.out.printf("Opção [%d]\n",comando);
        switch (comando){
            case 1:
                projetos.add(Projetos.CadastrarProjeto());
                System.out.println("\nProjeto adicionado!");
                break;
            case 2:
                colaboradores.add(Colaboradores.AdicionarColaborador());
                System.out.println("\nColaborador adicionado!");
                break;
            case 3:
               break;
            case 4:
               Colaboradores.BuscarColaborador(projetos,colaboradores);
               break;
            case 5:
                Projetos.ListarProjetos(projetos);
               break;
            case 6:
                Colaboradores.ListarColaboradores(colaboradores);
               break;
            case 7:
               break;
        
    }
}
input.close();
}
}
