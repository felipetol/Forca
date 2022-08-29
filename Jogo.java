import java.util.Scanner;

public class Jogo {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Insira a palavra a ser adivinhada: ");
        String palavra = sc.nextLine().toLowerCase();
        int numeroCaracteres = palavra.length();
        
        String jogo[][] = new String [6][4 + numeroCaracteres];
        
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
        
        for (int i = 3; i < palavra.length() + 3; i++) {
        	jogo[5][i] = "_ ";
        }
        
        int tentativas = 10;
        boolean acabouJogo = false;
        boolean venceu = false;

        while (!acabouJogo) {
        	
            for (int i = 0; i < 6; i++) {
                System.out.println();
                for (int j = 0; j < 4 + numeroCaracteres; j++) {
                    System.out.print(jogo[i][j]);
                }
            }
            
            System.out.println();
            System.out.printf("\nVocê tem %d tentativas\n", tentativas);
            System.out.print("Insira um chute: ");
            String chuteString = sc.nextLine().toLowerCase();
            char chute = chuteString.charAt(0);
            
            if (palavra.contains(String.valueOf(chute))) {
            	for (int i = 0; i < palavra.length(); i++) {
                    if(chute == palavra.charAt(i)) {
                        jogo[5][i + 3] = String.valueOf(chute);
                    }
                }
            } else {
            	tentativas--;
            }
            
            String palavraEncontrada = "";
            for(int i = 3; i < palavra.length() + 3; i++) {
            	palavraEncontrada = palavraEncontrada + jogo[5][i];
            }
            
            if (!palavraEncontrada.contains("_")) {
            	for (int i = 0; i < 6; i++) {
                    System.out.println();
                    for (int j = 0; j < 4 + numeroCaracteres; j++) {
                        System.out.print(jogo[i][j]);
                    }
                }
            	acabouJogo = true;
            	venceu = true;
            } else if (tentativas == 0) {
            	acabouJogo = true;
            }
        }
        
        if (venceu) {
        	System.out.println("\n\nParabéns");
        } else {
        	System.out.println("\n\nVocê perdeu");
        }
        
        sc.close();
    }
}
