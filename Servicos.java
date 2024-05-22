// Arquivo: Servicos.java
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class ServicoDoacaoImpl implements ServicoDoacao {
    private RepositorioDoacao repositorioDoacao;

    public ServicoDoacaoImpl(RepositorioDoacao repositorioDoacao) {
        this.repositorioDoacao = repositorioDoacao;
    }

    @Override
    public void registrarDoacao(Membro doador, double valor) {
        Doacao doacao = new Doacao(doador, valor);
        repositorioDoacao.adicionarDoacao(doacao);
        salvarDoacaoArquivo(doacao);
        System.out.println("Doação registrada com sucesso!");
    }

    private void salvarDoacaoArquivo(Doacao doacao) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("doadores.csv", true))) {
            writer.println(doacao.getDoador().nome + "," + doacao.getValor());
        } catch (IOException e) {
            System.out.println("Erro ao salvar doação no arquivo: " + e.getMessage());
        }
    }

    @Override
    public double calcularTotalDoacoes() {
        return repositorioDoacao.listarDoacoes().stream().mapToDouble(Doacao::getValor).sum();
    }

    @Override
    public List<String> listarDoadores() {
        List<String> doadores = new ArrayList<>();
        for (Doacao doacao : repositorioDoacao.listarDoacoes()) {
            doadores.add(doacao.getDoador().nome);
        }
        return doadores; // Adicionei essa linha para retornar a lista de doadores
    }
} // Faltava fechar a classe ServicoDoacaoImpl

class ServicoInstituicaoImpl implements ServicoInstituicao {
    private RepositorioInstituicao repositorioInstituicao;

    public ServicoInstituicaoImpl(RepositorioInstituicao repositorioInstituicao) {
        this.repositorioInstituicao = repositorioInstituicao;
    }

    @Override
    public void cadastrarInstituicao(Instituicao instituicao) {
        repositorioInstituicao.adicionarInstituicao(instituicao);
        System.out.println("Instituição cadastrada com sucesso!");
    }

    @Override
    public List<Instituicao> listarInstituicoes() {
        return repositorioInstituicao.listarInstituicoes();
    }
} // Faltava fechar a classe ServicoInstituicaoImpl

class ServicoProjetoImpl implements ServicoProjeto {
    private RepositorioProjeto repositorioProjeto;

    public ServicoProjetoImpl(RepositorioProjeto repositorioProjeto) {
        this.repositorioProjeto = repositorioProjeto;
    }

    @Override
    public void cadastrarProjeto(Projeto projeto) {
        repositorioProjeto.adicionarProjeto(projeto);
        System.out.println("Projeto cadastrado com sucesso!");
    }

    @Override
    public List<Projeto> listarProjetos() {
        return repositorioProjeto.listarProjetos();
    }
} // Faltava fechar a classe ServicoProjetoImpl

class ServicoTransacaoImpl implements ServicoTransacao {
    private RepositorioTransacao repositorioTransacao;

    public ServicoTransacaoImpl(RepositorioTransacao repositorioTransacao) {
        this.repositorioTransacao = repositorioTransacao;
    }

    @Override
    public void registrarTransacao(Transacao transacao) {
        repositorioTransacao.adicionarTransacao(transacao);
        System.out.println("Transação registrada com sucesso!");
    }

    @Override
    public List<Transacao> listarTransacoes() {
        return repositorioTransacao.listarTransacoes();
    }
} // Faltava fechar a classe ServicoTransacaoImpl
