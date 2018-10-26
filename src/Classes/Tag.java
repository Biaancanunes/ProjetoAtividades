
package Classes;

/**
 *
 * @author Dani
 */
public class Tag {
    private String nome;
    private String cor;

    public Tag(String nomeTag, String cor) {
        this.nome = nomeTag;
        this.cor = cor;
    }

    public Tag(String nome) {
        this.nome = nome;
    }

    public Tag() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Tag{" + "nome=" + nome + ", cor=" + cor + '}';
    }
    
}
