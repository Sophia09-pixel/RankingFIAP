package pastinha;

import java.util.Scanner;

public class sprint3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);
		int qtdEquipes = 0;
		int qtdCombate = 0;
		char resultados = 0;
		int pontos = 0;
		int notaDesign = 0;

		System.out.println("==== RANKING ROBOCUP ====");
		System.out.println("");
		System.out.println("Digite a quantidade de equipes: ");
		qtdEquipes = entrada.nextInt();

		int numEquipes[] = new int[qtdEquipes];
		int pontosEquipes[] = new int[qtdEquipes];
		int notaDesignEquipes[] = new int[qtdEquipes];

		for (int i = 0; i < qtdEquipes; i++) {
			System.out.println("");
			System.out.println("Digite o número da " + (1 + i) + "° equipe:");
			numEquipes[i] = entrada.nextInt();

			while (numEquipes[i] < 11 || numEquipes[i] > 99) {
				System.out.println("Digite um número entre 11 e 99!");
				numEquipes[i] = entrada.nextInt();
			}

			System.out.println("Digite a quantidade de combate realizada pela equipe:" + numEquipes[i]);
			qtdCombate = entrada.nextInt();

			System.out.println("");
			for (int j = 0; j < qtdCombate; j++) {
				System.out.println("Digite o resultado do " + (j + 1) + "° combate da equipe " + numEquipes[i]);
				resultados = entrada.next().toUpperCase().charAt(0);

				while (!(resultados == 'V' || resultados == 'E' || resultados == 'D')) {
					System.out.println("Digite uma opção válida: (V - vitória /D - derrota /E - empate)");
					resultados = entrada.next().toUpperCase().charAt(0);
				}

				switch (resultados) {
				case 'V':
					pontos += 5;
					break;
				case 'E':
					pontos += 3;
					break;
				case 'D':
					pontos += 0;
					break;
				}
			}
			System.out.println("Digite a nota do robô da equipe " + numEquipes[i] + ": ");
			notaDesign = entrada.nextInt();
			while (notaDesign < 0 || notaDesign > 10) {
				System.out.println("Digite uma nota válida entre 0 e 10: ");
				notaDesign = entrada.nextInt();
			}

			pontosEquipes[i] = pontos;
			notaDesignEquipes[i] = notaDesign;

			System.out.println("Pontos da Equipe " + numEquipes[i] + ": " + pontos);
			pontos = 0;
		}

		for (int i = 0; i < qtdEquipes - 1; i++) {
			for (int j = 0; j < qtdEquipes - i - 1; j++) {
				if (pontosEquipes[j] < pontosEquipes[j + 1] || (pontosEquipes[j] == pontosEquipes[j + 1]
						&& notaDesignEquipes[j] < notaDesignEquipes[j + 1])) {

					int Numero = numEquipes[j];
					int Pontos = pontosEquipes[j];
					int notaDesignE = notaDesignEquipes[j];

					numEquipes[j] = numEquipes[j + 1];
					pontosEquipes[j] = pontosEquipes[j + 1];
					notaDesignEquipes[j] = notaDesignEquipes[j + 1];

					numEquipes[j + 1] = Numero;
					pontosEquipes[j + 1] = Pontos;
					notaDesignEquipes[j + 1] = notaDesignE;
				}
			}
		}

		System.out.println("");
		System.out.println("====== RANKING ======");
		System.out.println("CLASSIFICAÇÃO:");
		for (int i = 0; i < qtdEquipes; i++) {
			System.out.println((i+1)+"° Lugar - Equipe " + numEquipes[i] + ": Pontuação = " + pontosEquipes[i] + " - Nota do Design = "
					+ notaDesignEquipes[i]);
		}
		System.out.println("======================");
	}

}
