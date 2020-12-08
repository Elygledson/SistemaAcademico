import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Projetos implements Comparable<Projetos> {
    public String Titulo, A_financiadora, Objetivo, Descricao, Status;
    public String DataInicio, DataTermino;
    public double Valor;
    public int q_professor; /* Quantidade de professores associados */
    public ArrayList<Colaboradores> participantes;
    public ArrayList<ProducaoAcademica> producao; /* publicações ou orientações associadas ao projeto */
    static Scanner input = new Scanner(System.in);

    public Projetos(String titulo, String DataInicio, String DataTermino, String a_financiadora, double valor,
            String objetivo, String descricao, String status) {
        this.Titulo = titulo;
        this.DataInicio = DataInicio;
        this.DataTermino = DataTermino;
        this.A_financiadora = a_financiadora;
        this.Valor = valor;
        this.Objetivo = objetivo;
        this.Descricao = descricao;
        this.Status = status;
        this.participantes = new ArrayList<Colaboradores>();
        this.producao = new ArrayList<ProducaoAcademica>();
    }

    public String getDataInicio() {
        return this.DataInicio;
    }

    public String getDataTermino() {
        return this.DataTermino;
    }

    public String getStatus() {
        return this.Status;
    }

    public int getNumeroParticipantes() {
        return this.participantes.size();
    }

    public int getPublicacoes() {
        return this.producao.size();
    }

    public static boolean Verificacao(Colaboradores colaborador, String Titulo) {
        for (int i = 0; i < colaborador.projetos.size(); i++) {
            if (colaborador.projetos.get(i).Titulo.equals(Titulo)) {
                return true;
            }
        }
        return false;
    }

    public static void Sort(ArrayList<Projetos> projetos) {
        Collections.sort(projetos);
    }

    public Date getDateTime() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        Date data = (Date) formato.parse(this.DataTermino);
        return data;
    }

    @Override
    public int compareTo(Projetos projeto) {
        try {
            return getDateTime().compareTo(projeto.getDateTime());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
      }

    public void setStatus() {
        int i, q_professor, q_geral;
        System.out.println("\nAlterar status para:");
        System.out.println("[1] - Em andamento");
        System.out.println("[2] - Concluído\n");
        var opcao = Integer.parseInt(input.nextLine());
        /* Entrar na fase de desenvolvimento */
        if (opcao == 1) {
            for (i = 0, q_professor = 0, q_geral = 0; i < this.participantes.size(); i++) {
                if (this.participantes.get(i).tipo.equals("PROFESSOR"))
                    q_professor++;
                else if (this.participantes.get(i).tipo.equals("ALUNO") || this.participantes.get(i).tipo.equals("PARTICIPANTES"))
                    q_geral++;
            }

            if (q_professor >= 1 && q_geral >= 1) {
                    this.Status = "EM ANDAMENTO";
                System.out.println("Status alterado para ''EM ANDAMENTO''.");
            } else {
                System.out.println("ERRO: não foi possível alterar status para ''EM ANDAMENTO''.");
            }
        }
        /* Entrar na fase final */
        else {
            if (!this.producao.isEmpty()) {
                  this.Status = "CONCLUÍDO";
                System.out.println("Status alterado para ''CONCLUÍDO''.");
            } else {
                System.out.println("ERRO: não foi possível alterar status para ''CONCLUÍDO''.");
            }
        }
        System.out.println("\nVocê deseja alterar o status de outro projeto?\nSelecione a opção:\n[1] - SIM\n[2] - NÃO");
        var response = Integer.parseInt(input.nextLine());
        while(response > 2 || response <= 0)
        {
            System.out.println("Comando inválido!Tente novamente");
            response = Integer.parseInt(input.nextLine());
        }
         if(response == 1){
            setStatus();
         }
         return;
    }

    public void ListarProjeto() {
        System.out.println("\nInformações do projeto:\n");
        System.out.printf(
                "[STATUS] -> ''%s'' [TÍTULO] -> %s [DATA INÍCIO] -> %s [DATA TERMINO] -> %s [FINANCIADORA] -> %s [VALOR] -> R$ %.2f \n",
                this.Status, this.Titulo, this.DataInicio, this.DataTermino, this.A_financiadora, this.Valor);
        System.out.printf("[DESCRIÇÃO]\n%s\n[OBJETIVO]\n%s\n", this.Descricao, this.Objetivo);

        if (getNumeroParticipantes() == 0) {
            System.out.println("\nNão há colaboradores associados ao projeto.");
        }

        for (int i = 0; i < this.participantes.size(); i++) {
            System.out.println("\nDados do colaborador:\n");
            System.out.printf("[NOME]  ->%s \n[TIPO]  ->[%s|%s]\n", this.participantes.get(i).nome,
                    this.participantes.get(i).tipo, this.participantes.get(i).grau);
        }

        if (getPublicacoes() == 0) {
            System.out.println("\nNão há publicações associadas ao projeto.");
        }

        for (int i = 0; i < this.producao.size(); i++) {
            System.out.println("\nInformações sobre as publicações:\n");
            System.out.printf("[TÍTULO] -> %s [CONFERÊNCIA] -> %s [LOCAL] -> %s [ANO] -> %s \n",
                    this.producao.get(i).Titulo, this.producao.get(i).NomeConferencia, this.producao.get(i).Local,
                    this.producao.get(i).Ano);
            System.out.printf("[PROJETO ASSOCIADO] -> %s \n", this.Titulo);
        }

    }
}
