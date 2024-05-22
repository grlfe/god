// Arquivo: Entidades.java
class Pessoa {
    protected String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }
}

class Membro extends Pessoa {
    private String papel;

    public Membro(String nome, String papel) {
        super(nome);
        this.papel = papel;
    }

    public String getPapel() {
        return papel;
    }
}

class Doacao {
    private Membro doador;
    private double valor;

    public Doacao(Membro doador, double valor) {
        this.doador = doador;
        this.valor = valor;
    }

    public Membro getDoador() {
        return doador;
    }

    public double getValor() {
        return valor;
    }
}

class Instituicao {
    private String nome;

    public Instituicao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Projeto {
    private String nome;

    public Projeto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Transacao {
    private String tipo;

    public Transacao(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
