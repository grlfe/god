// Arquivo: Interfaces.java
import java.util.List;

interface ServicoDoacao {
    void registrarDoacao(Membro doador, double valor);
    double calcularTotalDoacoes();
    List<String> listarDoadores();
}

interface RepositorioDoacao {
    List<Doacao> listarDoacoes();
    void adicionarDoacao(Doacao doacao);
}

interface ServicoInstituicao {
    void cadastrarInstituicao(Instituicao instituicao);
    List<Instituicao> listarInstituicoes();
}

interface RepositorioInstituicao {
    void adicionarInstituicao(Instituicao instituicao);
    List<Instituicao> listarInstituicoes();
}

interface ServicoProjeto {
    void cadastrarProjeto(Projeto projeto);
    List<Projeto> listarProjetos();
}

interface RepositorioProjeto {
    void adicionarProjeto(Projeto projeto);
    List<Projeto> listarProjetos();
}

interface ServicoTransacao {
    void registrarTransacao(Transacao transacao);
    List<Transacao> listarTransacoes();
}

interface RepositorioTransacao {
    void adicionarTransacao(Transacao transacao);
    List<Transacao> listarTransacoes();
}
