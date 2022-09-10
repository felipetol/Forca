import java.util.Scanner;

public class Jogo {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Insira a palavra a ser adivinhada: ");
        String palavra = sc.nextLine().toLowerCase();
        int numeroCaracteres = palavra.length();
        
        String[][] jogo = new String [6][4 + numeroCaracteres];
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4 + numeroCaracteres; j++) {
                jogo[i][j] = " ";
            }
        }
        
        jogo[1][1] = "*";
        jogo[2][1] = "|";
        jogo[3][1] = "|";
        jogo[4][1] = "|";
        jogo[5][1] = "|";
        jogo[1][2] = "-";
        jogo[1][3] = "-";
        jogo[1][4] = "*";
        jogo[2][4] = "|";
        
        for (int i = 3; i < numeroCaracteres + 3; i++) {
        	jogo[5][i] = "_ ";
        }
        
        
        String caracteresRepetidos[] = new String[26];
        for (int i = 0; i < caracteresRepetidos.length; i++) {
			caracteresRepetidos[i] = "";
		}
        
        int tentativas = 10;
        boolean acabouJogo = false;

        while (!acabouJogo) {
        	
        	System.out.print("\nCaracteres utilizados: ");
        	for(String caracter: caracteresRepetidos) {
        		System.out.print(caracter + " ");
        	}
        	
        	System.out.printf("\nVocê tem %d tentativas", tentativas);
        	
        	
            for (int i = 0; i < 6; i++) {
                System.out.println();
                for (int j = 0; j < 4 + numeroCaracteres; j++) {
                    System.out.print(jogo[i][j]);
                }
            }
            
            System.out.print("\nInsira um chute: ");
            String chuteString = sc.next().toLowerCase();
            char chute = chuteString.charAt(0);
            
            if (palavra.contains(String.valueOf(chute))) {
            	for (int i = 0; i < numeroCaracteres; i++) {
                    if(chute == palavra.charAt(i)) {
                        jogo[5][i + 3] = String.valueOf(chute + " ");
                    }
                }
            } else {
            	for (int i = 0; i < caracteresRepetidos.length; i++) {
					if(caracteresRepetidos[i].equals("")) {
						boolean achou = false; 
						for (int j = 0; j < caracteresRepetidos.length; j++) {
							if(caracteresRepetidos[j].equals(String.valueOf(chute))) {
								achou = true;
								System.out.print("\nCaracter já utilizado, tente outro.");
								break;
							}
						}
						if(!achou) {							
							caracteresRepetidos[i] = String.valueOf(chute);
						}
						break;
					}
				}
            	tentativas--;
            }
            
            String palavraEncontrada = "";
            for(int i = 3; i < numeroCaracteres + 3; i++) {
            	palavraEncontrada += jogo[5][i];
            }
            
            if (!palavraEncontrada.contains("_")) {
            	for (int i = 0; i < 6; i++) {
                    System.out.println();
                    for (int j = 0; j < 4 + numeroCaracteres; j++) {
                        System.out.print(jogo[i][j]);
                    }
                }
            	acabouJogo = true;
            	System.out.println("\n\nVocê acertou a resposta. Parabéns!");
            } else if (tentativas == 0) {
            	acabouJogo = true;
            	System.out.println("\n\nAcabaram suas tentativas. Você perdeu. A palavra era: " + palavra);
            }
        }
        sc.close();
    }
}
