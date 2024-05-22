import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instanciando os serviços e repositórios
        RepositorioDoacao repositorioDoacao = new RepositorioDoacaoImpl();
        ServicoDoacao servicoDoacao = new ServicoDoacaoImpl(repositorioDoacao);

        RepositorioInstituicao repositorioInstituicao = new RepositorioInstituicaoImpl();
        ServicoInstituicao servicoInstituicao = new ServicoInstituicaoImpl(repositorioInstituicao);

        RepositorioProjeto repositorioProjeto = new RepositorioProjetoImpl();
        ServicoProjeto servicoProjeto = new ServicoProjetoImpl(repositorioProjeto);

        RepositorioTransacao repositorioTransacao = new RepositorioTransacaoImpl();
        ServicoTransacao servicoTransacao = new ServicoTransacaoImpl(repositorioTransacao);

        int opcao;
        do {
            System.out.println("Painel da Igreja:");
            System.out.println("1. Registrar Dízimo");
            System.out.println("2. Ver Total de Dízimos");
            System.out.println("3. Ver Todos os Dizimistas");
            System.out.println("4. Cadastrar Instituição");
            System.out.println("5. Listar Instituições");
            System.out.println("6. Cadastrar Projeto");
            System.out.println("7. Listar Projetos");
            System.out.println("8. Registrar Outras Transações");
            System.out.println("9. Listar Transações");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    registrarDoacao(scanner, servicoDoacao);
                    break;
                case 2:
                    System.out.println("Total de Dízimos: R$" + servicoDoacao.calcularTotalDoacoes());
                    break;
                case 3:
                    System.out.println("Dizimistas:");
                    List<String> dizimistas = servicoDoacao.listarDoadores();
                    for (String nome : dizimistas) {
                        System.out.println(nome);
                    }
                    break;
                case 4:
                    cadastrarInstituicao(scanner, servicoInstituicao);
                    break;
                case 5:
                    listarInstituicoes(servicoInstituicao);
                    break;
                case 6:
                    cadastrarProjeto(scanner, servicoProjeto);
                    break;
                case 7:
                    listarProjetos(servicoProjeto);
                    break;
                case 8:
                    registrarTransacao(scanner, servicoTransacao);
                    break;
                case 9:
                    listarTransacoes(servicoTransacao);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close(); // Fechar o scanner após o término do loop
    }

    private static void registrarDoacao(Scanner scanner, ServicoDoacao servicoDoacao) {
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite o nome do dizimista: ");
        String nomeDoador = scanner.nextLine();
        System.out.print("Digite o papel do membro (ex: Fiél, Líder, etc.): ");
        String papel = scanner.nextLine();
        System.out.print("Digite o valor do dízimo: ");
        double valor = scanner.nextDouble();
        servicoDoacao.registrarDoacao(new Membro(nomeDoador, papel), valor);
    }

    private static void cadastrarInstituicao(Scanner scanner, ServicoInstituicao servicoInstituicao) {
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite o nome da instituição: ");
        String nome = scanner.nextLine();
        servicoInstituicao.cadastrarInstituicao(new Instituicao(nome));
    }

    private static void listarInstituicoes(ServicoInstituicao servicoInstituicao) {
        List<Instituicao> instituicoes = servicoInstituicao.listarInstituicoes();
        if (instituicoes.isEmpty()) {
            System.out.println("Nenhuma instituição cadastrada.");
        } else {
            System.out.println("Instituições cadastradas:");
            for (Instituicao instituicao : instituicoes) {
                System.out.println("- " + instituicao.getNome());
            }
        }
    }

    private static void cadastrarProjeto(Scanner scanner, ServicoProjeto servicoProjeto) {
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite o nome do projeto: ");
        String nome = scanner.nextLine();
        servicoProjeto.cadastrarProjeto(new Projeto(nome));
    }

    private static void listarProjetos(ServicoProjeto servicoProjeto) {
        List<Projeto> projetos = servicoProjeto.listarProjetos();
        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto cadastrado.");
        } else {
            System.out.println("Projetos cadastrados:");
            for (Projeto projeto : projetos) {
                System.out.println("- " + projeto.getNome());
            }
        }
    }

    private static void registrarTransacao(Scanner scanner, ServicoTransacao servicoTransacao) {
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite o tipo da transação: ");
        String tipo = scanner.nextLine();
        servicoTransacao.registrarTransacao(new Transacao(tipo));
    }

    private static void listarTransacoes(ServicoTransacao servicoTransacao) {
        List<Transacao> transacoes = servicoTransacao.listarTransacoes();
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
        } else {
            System.out.println("Transações registradas:");
            for (Transacao transacao : transacoes) {
                System.out.println("- " + transacao.getTipo());
            }
        }
    }
}
