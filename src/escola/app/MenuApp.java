package escola.app;

import java.util.Scanner;
import escola.dominio.Disciplina;
import escola.dominio.Serie;
import escola.dominio.Turma;
import escola.dominio.Aluno;

public class MenuApp {
    public static void main(String[] args) {
        Disciplina mat = new Disciplina("Matematica", 40);
        Disciplina port = new Disciplina("Portugues", 40);
        Serie primeiroAno = new Serie("1º Ano do Ensino Médio", new Disciplina[]{mat, port});
        Turma turma1A = new Turma("1A", primeiroAno, 30);

        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;
        while (rodando) {
            System.out.println("=== SISTEMA ESCOLAR ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar ALunos");
            System.out.println("3. Imprimir Boletim");
            System.out.println("4. Lançar Notas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o nextInt()

            switch (opcao) {
                case 1:
                    try {
                        System.out.print("Digite o nome do aluno: ");
                        String nomeAluno = scanner.nextLine();
                        Aluno aluno = new Aluno(nomeAluno);
                        turma1A.matricular(aluno);
                        System.out.println("Sucesso: " + aluno.toString() + " matriculado na turma");
                    } catch (IllegalArgumentException | IllegalStateException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("ALunos matriculados na turma:");
                    System.out.println(turma1A);
                    break;
                case 3:
                    System.out.println("Digite a matrícula do aluno: ");
                    int matricula = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o nextInt()
                    try {
                        System.out.println(turma1A.gerarBoletim(matricula));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Digite a matrícula do aluno: ");
                    int matriculaNota = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após o nextInt()
                    System.out.println("Digite o nome da disciplina: ");
                    String disciplina = scanner.nextLine().trim();
                    System.out.println("Digite o trimestre (1, 2 ou 3): ");
                    int trimestre = scanner.nextInt();
                    System.out.println("Digite a nota (0 a 10): ");
                    double nota = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha após o nextDouble()
                    try {
                        turma1A.lancarNota(matriculaNota, disciplina, trimestre, nota);
                        System.out.println("Nota lançada com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 5:
                    rodando = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
