import java.util.Scanner;
import java.util.ArrayList;


public class Admin {
    public static void main(String[] args) {
        int comando = 0;
        Scanner input = new Scanner(System.in);
        ArrayList<Colaboradores> colaboradores = new ArrayList<Colaboradores>();
        ArrayList<Projetos> projetos = new ArrayList<Projetos>();

        while(comando != 6){
        System.out.println("\nSelecione uma opção:");
        System.out.println("[1] - Cadastrar projeto.");
        System.out.println("[2] - Cadastrar participante.");
        System.out.println("[3] - Alocar participante a projeto.");
        System.out.println("[4] - Projetos disponíveis");
        System.out.println("[5] - Colaboradores cadastrados");
        System.out.println("[6] - Sair.\n");
        comando = input.nextInt();
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
                Colaboradores.ListarColaboradores(colaboradores);
               break;
            case 6:
               break;
        
    }
}
input.close();
}
}
