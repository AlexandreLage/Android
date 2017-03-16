package fiap.com.br.pizzaria;


public class PizzaBean {

    private String sabor;
    private double preco;
    private int imagem;

    public PizzaBean(){}

    public PizzaBean(String sabor, double preco, int imagem) {
        this.sabor = sabor;
        this.preco = preco;
        this.imagem = imagem;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }



    public String getSabor() {
        return sabor;
    }

    public double getPreco() {
        return preco;
    }

    public int getImagem() {
        return imagem;
    }
    @Override
    public String toString(){
        return getSabor()+" : R$" + this.getPreco();
    }
}
