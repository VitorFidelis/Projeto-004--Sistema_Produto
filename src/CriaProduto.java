import java.util.Scanner;
import java.util.Locale;

public class CriaProduto {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);// Configura para aceitar ponto como separador decimal
		
		System.out.println("=== SISTEMA PRODUTO ===");
		
		//Definindo que o Objeto começa sem valor nenhum
		Produto produtoUm = null;
		
		// Laço para garantir que o produto seja criado com valores válidos
		while (produtoUm == null) {
			
			System.out.print("Digite o nome do produto: ");
	        String nome = scanner.nextLine();
			
			System.out.print("Digite o preço do produto: R$ ");
	        double preco = scanner.nextDouble();
	        
	        System.out.print("Digite a quantidade do produto: ");
	        int quantidade = scanner.nextInt();
	        scanner.nextLine();// Limpar buffer para que não paareça a solcitação de duas informações oa mesmo tempo.
	        System.out.println("===========================");
	        
	        try {
	        	produtoUm = new Produto(nome, preco, quantidade);//tenta criar o produto com os parametros informado
	        	produtoUm.exibirInformacoes();//Exibiinformações do produto se der certo.
	        	
			} catch (IllegalArgumentException e) {
				System.out.println("INFORMAÇÃO DE ERRO: " + e.getMessage());//Apresenta as mensagens de erro, criadas detro da classe Produto
				System.out.println("Tente novamente. \n");
			}
		}
		
		//Pergunta se deseja fazer alterações na quantidade do produto
		System.out.print("\nDeseja fazer aletrações na quantidade do produto?[S/N]");
		String escolhaAdicionarRemover = scanner.next();
		
		if (escolhaAdicionarRemover.equalsIgnoreCase("S")){
			int opcaoAdicionarRemover;
			do {
				System.out.println("\n---ESCOLHA A OPÇÃO DESEJADA---");
				System.out.println("1 - Adicionar quantidade");
				System.out.println("2 - Remover quantidade");
				System.out.println("3 - Alterar quantidade");
				System.out.println("4 - Sair");
				System.out.println("---------------------------------");
				System.out.print("Opção:");
				opcaoAdicionarRemover = scanner.nextInt();
				
				switch (opcaoAdicionarRemover) {
						case 1:
							System.out.print("\nInforme quantidade a ser adicionada em estoque:");
					        int quantidadeAdicionada = scanner.nextInt();
					        produtoUm.adicionarQuantidade(quantidadeAdicionada);
					        produtoUm.exibirInformacoes();
							break;
							
						case 2:
							System.out.print("\nInforme quantidade a ser removida em estoque:");
					        int quantidadeRemovida = scanner.nextInt();
					        produtoUm.removerQuantidade(quantidadeRemovida);
					        produtoUm.exibirInformacoes();
					        break;
						case 3:
							System.out.println("\nInforme quantidade a ser alterado em estoque:");
							int quantidadeAlterada = scanner.nextInt();
							produtoUm.alterarQuantidade(quantidadeAlterada);
							produtoUm.exibirInformacoes();
							break;
						case 4:
							System.out.println("Confirme para sair: [S/N]");
							String confirmaSairouNao = scanner.nextLine();
							scanner.nextLine();
							break;
						default:
							System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX");
							System.out.println("XXX [!OPÇÃO INVALIDA!] XXX");
							System.out.println(">>Tente novamente");
							System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX");
							break;
					}
			} while (opcaoAdicionarRemover > 4);
			
		}else {
			System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(">>>Continuaremos sem alteração na quantidade<<<");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			}
			
		System.out.print("\nDeseja fazer alteração o preço ?[S/N]");
		String escolhaAlterar = scanner.next();
		
		if (escolhaAlterar.equalsIgnoreCase("S")) {
			System.out.println("\n---ALTERAÇÃO DE VALOR---");
			System.out.print("\nNovo Valor do produto: ");
	        double precoAlterado = scanner.nextDouble();
	        produtoUm.setPreco(precoAlterado);
			System.out.println("--------------------------");
			produtoUm.exibirInformacoes();
		}else {
			System.out.println(">>>Continuaremos sem alteração no preço<<<");
		}
	scanner.close(); // Fecha o scanner
	}
}
