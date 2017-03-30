package fiap.com.br.votacao;

/**
 * Created by logonrm on 30/03/2017.
 */

public class VotacaoBean {

    private String nome;
    private String sigla;

    public VotacaoBean() {}

    public VotacaoBean(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }
}
