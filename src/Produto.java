
public class Produto {
	private String nome;
	private double preco;
	private int quantidade;
	
	public Produto(String nome, double preco, int quantidade) {
		this.nome = nome;
		
		if (preco <= 0) {
			throw new IllegalArgumentException("[ERRO] > O preço informado é menor ou igual a zero");
			
		}else {
			this.preco = preco;
		}
		if (quantidade <= 0) {
			  throw new IllegalArgumentException("[ERRO] > Quantidade informada é menor ou igual a zero");
			
		}else {
			this.quantidade = quantidade;
		}
	}
	
	public String getNome() {
		return this.nome;
	}
	public double getPreco() {
		return this.preco;
	}
	public void setPreco(double preco) {
		if (preco <= 0) {
			System.out.println("[ERRO] > Preço informado é menor ou igual a zero.");
		}else {
			this.preco = preco;
		}
	}
	public int getQuantidade() {
		return this.quantidade;
	}
	public int alterarQuantidade(int quantidade){
		if(quantidade <= 0) {
			System.out.println("[ERRO] > (Quantidade a ser alterada) é menor ou igual a zero.");
		}else {
			this.quantidade = quantidade;
		}
		return this.quantidade;
	}
	public int removerQuantidade(int quantidade){
		if(this.quantidade >= quantidade) {
			this.quantidade -= quantidade;
			
		}else {
			System.out.println("[ERRO] > (Quantidade a ser removida) é menor ou igual em estoque");
		}
		return this.quantidade;
	}
	public int adicionarQuantidade(int quantidade) {
		if (quantidade >= 0) {
			this.quantidade += quantidade;
		}else {
			System.out.println("[ERRO] > (Quantidade adicionada) é menor ou igual a zero");
		}
		return this.quantidade;
	}
	public void exibirInformacoes() {
		System.out.println("\n--- INFORMAÇÕES DO PRODUTO ---");
        System.out.println("Nome do produto: " + this.nome);
        System.out.println("Preço do Produto: R$ " + this.preco);
        System.out.println("Quantidade: " + this.quantidade);
        System.out.println("--------------------------------");
	}
}
