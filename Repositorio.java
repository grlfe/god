// Arquivo: Repositorio.java
import java.util.ArrayList;
import java.util.List;

class RepositorioDoacaoImpl implements RepositorioDoacao {
    private List<Doacao> doacoes = new ArrayList<>();

    @Override
    public List<Doacao> listarDoacoes() {
        return new ArrayList<>(doacoes);
    }

    @Override
    public void adicionarDoacao(Doacao doacao) {
        doacoes.add(doacao);
    }
}

class RepositorioInstituicaoImpl implements RepositorioInstituicao {
    private List<Instituicao> instituicoes = new ArrayList<>();

    @Override
    public void adicionarInstituicao(Instituicao instituicao) {
        instituicoes.add(instituicao);
    }

    @Override
    public List<Instituicao> listarInstituicoes() {
        return new ArrayList<>(instituicoes);
    }
}

class RepositorioProjetoImpl implements RepositorioProjeto {
    private List<Projeto> projetos = new ArrayList<>();

    @Override
    public void adicionarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }

    @Override
    public List<Projeto> listarProjetos() {
        return new ArrayList<>(projetos);
    }
}

class RepositorioTransacaoImpl implements RepositorioTransacao {
    private List<Transacao> transacoes = new ArrayList<>();

    @Override
    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    @Override
    public List<Transacao> listarTransacoes() {
        return new ArrayList<>(transacoes);
    }
}
