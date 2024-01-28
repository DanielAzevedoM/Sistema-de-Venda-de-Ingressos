import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	static Scanner scanner = new Scanner(System.in);
	static Boolean sair = false;
	static Boolean autenticado = false;

	public static class Ipessoa {
		Integer Id;
		String Nome;
		String Cpf;
		String Idade;

		public Ipessoa(String Nome, String Cpf, String Idade) {
			this.Nome = Nome;
			this.Cpf = Cpf;
			this.Idade = Idade;
		}
	}

	public static class Ipoltronas {

		String poltrona;
		String ocupante;

		public Ipoltronas(String poltrona, String ocupante) {
			this.poltrona = poltrona;
			this.ocupante = ocupante;
		}
	}

	public class Metodos {

		public static String ExibirMenu() {

			System.out.println("1- Cadastro de usuarios");
			System.out.println("2- Login de usuario");
			System.out.println("3- Comprar Ingresso");
			System.out.println("4- Verificar poltronas");
			System.out.println("5- Pesquisar ocupante poltrona");
			System.out.println("6- Verificar usuarios do sistema");
			System.out.println("7- Apagar usuario do sistema");
			System.out.println("8- Sair");
			System.out.println();
			String opMenu = scanner.nextLine();

			return opMenu;
		}

		public static void OpcaoMenu(String opcao, Ipessoa[] pessoas, Ipoltronas[][] poltronas, Ipessoa[] usuario) {
			switch (opcao) {
				case "1":
					System.out.println();
					System.out.println("1- Cadastro de usuarios: ");
					System.out.println();
					CadastrarPessoas(pessoas);
					break;
				case "2":
					System.out.println("2- Login de usuario: ");
					LoginUsuario(pessoas, usuario);
					System.out.println();
					break;
				case "3":
					System.out.println();
					System.out.println("3- Comprar ingresso: ");
					ComprarIngresso(poltronas, usuario);
					System.out.println();
					break;
				case "4":
					System.out.println();
					System.out.println("4- Verificar poltronas: ");
					System.out.println();
					VerificarPoltronas(poltronas);
					System.out.println();
					break;
				case "5":
					System.out.println();
					System.out.println("5- Verificar ocupante poltrona: ");
					PesquisarOcupantePoltrona(poltronas, pessoas);
					System.out.println();
					break;
				case "6":
					System.out.println();
					System.out.println("6- Verificar usuarios do sistema:");
					ExibirPessoas(pessoas);
					System.out.println();
					break;
				case "7":
					System.out.println();
					System.out.println("7- Apagar usuario do sistema: ");
					ApagarUsuario(pessoas);
					System.out.println();
					break;
				default:
					sair = true;
					break;
			}
		}

		public static void ApagarUsuario(Ipessoa[] pessoas) {
			Boolean usuarioExiste = false;
			try {
				System.out.println();
				System.out.println("Digite o id do usuario que voce quer apagar: ");
				System.out.println();
				Integer id = scanner.nextInt();
				scanner.nextLine();

				for (int i = 0; i < pessoas.length; i++) {
					if (pessoas[i].Id.equals(id)) {
						pessoas[i] = null;
						System.out.println();
						System.out.println("Usuario deletado com sucesso!");
						usuarioExiste = true;
						break;
					}
				}
			} catch (InputMismatchException | NullPointerException e) {
			}

			if (!usuarioExiste) {
				System.out.println();
				System.out.println("Id de usuario nao existe");
				System.out.println();

				return;
			}
		}

		public static void CadastrarPessoas(Ipessoa[] pessoas) {
			System.out.println("Digite o seu nome: ");
			String Nome = scanner.nextLine();
			if (!VerificaoNome(Nome)) return;
			System.out.println();

			System.out.println("Digite o seu Cpf: ");
			String Cpf = scanner.nextLine();
			if(!VerificaoNumeroCpf(Cpf)) return;
			if(!VerificarCpfExiste(Cpf, pessoas)) return;
			System.out.println();
			
			System.out.println("Digite o seu idade: ");
			String Idade = scanner.nextLine();
			if(!VerificaoIdade(Idade)) return;
			Ipessoa novaPessoa = new Ipessoa(Nome, Cpf, Idade);

			for (int i = 0; i < pessoas.length; i++) {
				if (pessoas[i] == null) {
					novaPessoa.Id = (i + 1);
					pessoas[i] = novaPessoa;
					break;
				}
			}

		}

		public static boolean verificarNumero(String str) {
			return str.matches("\\d+");
		}

		
		public static Boolean VerificaoNome(String Nome){
			if (Nome.length() < 4 || verificarNumero(Nome)) {
				System.out.println();
				System.out.println("O nome deve conter pelo menos 4 letras, sem numeros!");
				System.out.println();
				return false;
			}	
			return true;
		}

		public static Boolean VerificarCpfExiste(String Cpf, Ipessoa[] pessoas){
			for (int i = 0; i < pessoas.length; i++) {
				try{
					if (pessoas[i].Cpf.equals(Cpf)){
						System.out.println();
						System.out.println("Cpf ja existe!");
						System.out.println();
						return false;
					} 
				} catch(NullPointerException e){}
			}
			return true;
		}

		public static Boolean VerificaoNumeroCpf(String Cpf){
			if (Cpf.length() < 11 || !verificarNumero(Cpf)) {
				System.out.println();
				System.out.println("Cpf deve ter 11 numeros!");
				System.out.println();
				return false;
			}	
			return true;
		}

		public static Boolean VerificaoIdade(String Idade){
			if (Idade.length() > 3 || !verificarNumero(Idade)) {
				System.out.println();
				System.out.println("Idade deve conter apenas numeros! Insira uma idade valida de ate 3 digitos!");
				System.out.println();
				return false;
			}	
			return true;
		}

		public static void ExibirPessoas(Ipessoa[] pessoa) {
			for (int i = 0; i < pessoa.length; i++) {
				try {
					System.out.println();
					System.out.println("Id: " + pessoa[i].Id);
					System.out.println("Nome: " + pessoa[i].Nome);
					System.out.println("Cpf: " + pessoa[i].Cpf);
					System.out.println("Idade: " + pessoa[i].Idade);
					System.out.println("------------------------");
				} catch (NullPointerException e) {
				}
			}

		}

		public static void PesquisarOcupantePoltrona(Ipoltronas[][] poltronas, Ipessoa[] pessoas){

			System.out.println();
			for (int i = 0; i < pessoas.length; i++) {
				System.out.print("Fileira " + (i + 1) + ": ");
				for (int j = 0; j < pessoas.length; j++) {
					System.out.print(poltronas[i][j].poltrona + " ");
				}
				System.out.println();
			}

			System.out.println();
			System.out.println("Digite a fileira da poltrona que pretende verificar: ");
			Integer Vfileira = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Digite o numero da poltrona que pretende verificar: ");
			Integer Vpoltrona = scanner.nextInt();
			scanner.nextLine();

			if (!poltronas[Vfileira - 1][Vpoltrona - 1].poltrona.equals("0")) {
				for (int i = 0; i < pessoas.length; i++) {
					try {
						if (pessoas[i].Cpf.equals(poltronas[Vfileira - 1][Vpoltrona - 1].ocupante)) {

							System.out.println("Poltrona ocupada por: ");
							System.out.println();
							System.out.println("Nome: " + pessoas[i].Nome);
							System.out.println("Cpf: " + pessoas[i].Cpf);
							System.out.println("Idade: " + pessoas[i].Idade);
							System.out.println();
						}
					} catch (NullPointerException e) {}

				}
			} 

		}

		public static void LoginUsuario(Ipessoa[] pessoas, Ipessoa[] usuario) {
			System.out.println("Digite o seu cpf para se autenticar no sistema: ");
			String usuariocpf = scanner.nextLine();
			if(!VerificaoNumeroCpf(usuariocpf)) return;	

			for (int i = 0; i < pessoas.length; i++) {
				try {
					if(usuariocpf.equals(pessoas[i].Cpf)){
						autenticado = true;
						Ipessoa logarUsuario = new Ipessoa(pessoas[i].Nome, pessoas[i].Cpf, pessoas[i].Idade);
						for (int j = 0; j < usuario.length; j++) {
							usuario[j] = logarUsuario;
							usuario[j].Id = pessoas[i].Id;		
						}
					}
				} catch (NullPointerException e) {}	
			}
		}

		public static void ComprarIngresso(Ipoltronas[][] poltronas, Ipessoa[] usuario) {
			if(autenticado.equals(true)){
				System.out.println();
				System.out.println("Digite a fileira desejada: ");
				Integer fileira = scanner.nextInt();
				scanner.nextLine();
				System.out.println();
				System.out.println("Digite a poltrona desejada: ");
				Integer Cpoltrona = scanner.nextInt();
				scanner.nextLine();
				System.out.println();
	
				if (poltronas[fileira - 1][Cpoltrona - 1].poltrona.equals("0")) {
					poltronas[fileira - 1][Cpoltrona - 1].poltrona = "x";
					poltronas[fileira - 1][Cpoltrona - 1].ocupante = usuario[0].Cpf;
					
					System.out.println("Compra concluida com sucesso, sua fileira: " + (fileira -1) + " e sua poltrona" + (Cpoltrona - 1));
					

				} else {
					System.out.println("Esta poltrona ja esta alugada!");
				}
			} else {
				System.out.println();
				System.out.println("Usuario nao autenticado! Faca o login!");
			}
		}

		public static void GerarPoltronas(Ipoltronas[][] poltronas) {
			for (int i = 0; i < poltronas.length; i++) {
				for (int j = 0; j < poltronas.length; j++) {
					poltronas[i][j] = new Ipoltronas("0", "vazio");
				}
			}
		}

		public static void VerificarPoltronas(Ipoltronas[][] poltronas) {
			for (int i = 0; i < poltronas.length; i++) {
				System.out.print("Fileira " + (i + 1) + ": ");
				for (int j = 0; j < poltronas.length; j++) {
					System.out.print(poltronas[i][j].poltrona + " ");
				}
				System.out.println();
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Ipessoa[] pessoas = new Ipessoa[5];
		Ipessoa[] usuario = new Ipessoa[1];
		Ipoltronas[][] poltronas = new Ipoltronas[5][5];
		Metodos.GerarPoltronas(poltronas);
		while (!sair.equals(true)) {
			String menu = Metodos.ExibirMenu();
			Metodos.OpcaoMenu(menu, pessoas, poltronas, usuario);
		}

	}

}
