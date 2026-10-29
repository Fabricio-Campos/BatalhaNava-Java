import java.util.Random;

public class Tabuleiro {

    private Random random = new Random();
    private int tamanho;
    private char [][] navios;
    private boolean[][] atirado;
    private int tirosRestantes;
    private int partesRestantes;

    public Tabuleiro (int tamanho, int[] quantidade, int tiros){
        this.tamanho = tamanho;
        this.tirosRestantes = tiros;
        this.partesRestantes = 0;
        this.navios = new char[tamanho][tamanho];
        this.atirado = new boolean[tamanho][tamanho];

        for (int i = 0; i < tamanho; i++){
            for(int j = 0; j < tamanho; j++){
                navios[i][j] = '~';
            }
        }
        char[] letras = {'S', 'D', 'C', 'E', 'P'};

        for(int tipo = quantidade.length - 1; tipo >= 0; tipo--){
            for (int k = 0; k < quantidade[tipo]; k++){
                posicionarNavio(tipo + 1, letras[tipo]);
            }
        }

        
    }

    public void imprimir (){
       for (int i = 0; i < tamanho; i++){
            for(int j = 0; j < tamanho; j++){
                System.out.print(navios[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void posicionarNavio (int tamanhoNavio, char letra){
        int linha, coluna;
        boolean livre;

        do{
            linha = random.nextInt(this.tamanho);
            coluna = random.nextInt(this.tamanho - tamanhoNavio + 1);
            
            livre = true;
            for(int i = 0; i < tamanhoNavio; i++){
                if (navios[linha][coluna + i] != '~'){
                    livre = false;
                    break;
                }
            }
        } while (!livre);

        for (int i = 0; i < tamanhoNavio; i++){
            navios[linha][coluna + i] = letra;
        }
        partesRestantes += tamanhoNavio;
    }
}