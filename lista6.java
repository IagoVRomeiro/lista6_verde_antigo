import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileNotFoundException;

class ArquivoTextoLeitura {

    public BufferedReader entrada;

    ArquivoTextoLeitura(String nomeArquivo) {

        try {
            entrada = new BufferedReader(new FileReader(nomeArquivo));
        } catch (FileNotFoundException excecao) {
            System.out.println("Arquivo nao encontrado");
        }
    }

    public void fecharArquivo() {

        try {
            entrada.close();
        } catch (IOException excecao) {
            System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
        }
    }

    @SuppressWarnings("finally")
    public String ler() {

        String textoEntrada = null;

        try {
            textoEntrada = entrada.readLine();
        } catch (EOFException excecao) { // Excecao de final de arquivo.
            textoEntrada = null;
        } catch (IOException excecao) {
            System.out.println("Erro de leitura: " + excecao);
            textoEntrada = null;
        } finally {
            return textoEntrada;
        }
    }
}

class Jogo {
    private int rank;
    private String nomeJogo;
    private String plataforma;
    private int ano;
    private String genero;
    private String editora;
    private double NA_Vendas;
    private double EU_Vendas;
    private double JP_Vendas;
    private double Outras_Vendas;
    private double Vendas_Global;
    private static int comparacoes = 0;
    private static int movimentos = 0;

    public Jogo(int rank, String nomeJogo, String plataforma, int ano, String genero, String editora, double NA_Vendas,
            double EU_Vendas, double JP_Vendas, double Outras_Vendas, double Vendas_Global) {
        this.rank = rank;
        this.nomeJogo = nomeJogo;
        this.plataforma = plataforma;
        this.ano = ano;
        this.genero = genero;
        this.editora = editora;
        this.NA_Vendas = NA_Vendas;
        this.EU_Vendas = EU_Vendas;
        this.JP_Vendas = JP_Vendas;
        this.Outras_Vendas = Outras_Vendas;
        this.Vendas_Global = Vendas_Global;
    }

    public Jogo(String nomeJogo, String plataforma, int ano) {
        this.nomeJogo = nomeJogo;
        this.plataforma = plataforma;
        this.ano = ano;
    }

    public Jogo() {
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getNomeDoJogo() {
        return nomeJogo;
    }

    public void setNomeDoJogo(String nomeDoJogo) {
        this.nomeJogo = nomeDoJogo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public double getNA_Vendas() {
        return NA_Vendas;
    }

    public void setNA_Vendas(double NA_Vendas) {
        this.NA_Vendas = NA_Vendas;
    }

    public double getEU_Vendas() {
        return EU_Vendas;
    }

    public void setEU_Vendas(double EU_Vendas) {
        this.EU_Vendas = EU_Vendas;
    }

    public double getJP_Vendas() {
        return JP_Vendas;
    }

    public void setJP_Vendas(double JP_Vendas) {
        this.JP_Vendas = JP_Vendas;
    }

    public double getOutras_Vendas() {
        return Outras_Vendas;
    }

    public void setOutras_Vendas(double Outras_Vendas) {
        this.Outras_Vendas = Outras_Vendas;
    }

    public double getVendas_Global() {
        return Vendas_Global;
    }

    public void setVendas_Global(double Vendas_Global) {
        this.Vendas_Global = Vendas_Global;
    }

    public Jogo clone() {
        return new Jogo(this.rank, this.nomeJogo, this.plataforma, this.ano, this.genero, this.editora, this.NA_Vendas,
                this.EU_Vendas, this.JP_Vendas, this.Outras_Vendas, this.Vendas_Global);
    }

    public void lerTxt(String Dados) {
        String[] dados = Dados.split("\\|");
        this.rank = Integer.parseInt(dados[0]);
        this.nomeJogo = dados[1];
        this.plataforma = dados[2];
        this.ano = Integer.parseInt(dados[3]);
        this.genero = dados[4];
        this.editora = dados[5];
        this.NA_Vendas = Double.parseDouble(dados[6]);
        this.EU_Vendas = Double.parseDouble(dados[7]);
        this.JP_Vendas = Double.parseDouble(dados[8]);
        this.Outras_Vendas = Double.parseDouble(dados[9]);
        this.Vendas_Global = Double.parseDouble(dados[10]);

    }

    public void lerIN(String Dados) {
        String[] dados = Dados.split(";");
        this.nomeJogo = dados[0];
        this.ano = Integer.parseInt(dados[1]);
        this.editora = dados[2];
        this.plataforma = dados[3];
    }

    public void imprimir() {
        System.out.println(this);
    }

    public String toString(String maisVendido) {
        return "[" + nomeJogo + "] [" + plataforma + "] [" + Vendas_Global + "] " + rank + ". " + genero + ". "
                + editora
                + ". Mais vendido: " + maisVendido + ".";
    }




    public int compararBubble(Jogo jogo) {
        comparacoes++;
        if (this.nomeJogo.compareTo(jogo.nomeJogo) != 0) {
            return this.nomeJogo.compareTo(jogo.nomeJogo);
        } else if (this.plataforma.compareTo(jogo.plataforma) != 0) {
            return this.plataforma.compareTo(jogo.plataforma);
        } else {
            movimentos++; 
            return Double.compare(jogo.Vendas_Global, this.Vendas_Global);
        }
    }
    
    public int compararSelecao(Jogo jogo) {
        comparacoes++;
        if (this.nomeJogo.compareTo(jogo.nomeJogo) != 0) {
            return this.nomeJogo.compareTo(jogo.nomeJogo);
        } else if (this.plataforma.compareTo(jogo.plataforma) != 0) {
            return this.plataforma.compareTo(jogo.plataforma);
        } else {
            movimentos++; 
            return Double.compare(this.Vendas_Global, jogo.Vendas_Global);
        }
    }
    
    public int compararInsercao(Jogo jogo) {
        comparacoes++;
        if (this.nomeJogo.compareTo(jogo.nomeJogo) != 0) {
            return this.nomeJogo.compareTo(jogo.nomeJogo);
        } else if (this.plataforma.compareTo(jogo.plataforma) != 0) {
            return this.plataforma.compareTo(jogo.plataforma);
        } else {
            movimentos++; 
            return Double.compare(jogo.Vendas_Global, this.Vendas_Global);
        }
    }
    

    public static int getComparacao() {
        return comparacoes;
    }

    public static int getMovementos() {
        return movimentos;
    }
    

}

class Ordenacao {
    public static void bubble(ArrayList<Jogo> vetor) {
        int n = vetor.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {

                if (vetor.get(j).compararBubble(vetor.get(j + 1)) > 0) {
                    // trocar
                    Jogo temp = vetor.get(j);
                    vetor.set(j, vetor.get(j + 1));
                    vetor.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public static void selecao(ArrayList<Jogo> vetor) {
        int n = vetor.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndice = i;
            for (int j = i + 1; j < n; j++) {
                // comparar
                if (vetor.get(j).compararSelecao(vetor.get(minIndice)) < 0) {
                    minIndice = j;
                }
            }
            // trocar
            Jogo temp = vetor.get(minIndice);
            vetor.set(minIndice, vetor.get(i));
            vetor.set(i, temp);
        }
    }

    public static void insercao(ArrayList<Jogo> vetor) {
        int n = vetor.size();
        for (int i = 1; i < n; ++i) {
            Jogo key = vetor.get(i);
            int j = i - 1;
            while (j >= 0 && vetor.get(j).compararInsercao(key) > 0) {
                vetor.set(j + 1, vetor.get(j));
                j = j - 1;
            }
            vetor.set(j + 1, key);
        }
    }
}

public class lista6 {

    public static String maiorVenda(Double NA_Vendas, Double EU_Vendas, Double JP_Vendas) {
        if (NA_Vendas > EU_Vendas && NA_Vendas > JP_Vendas) {
            return "NA_Vendas";
        } else if (EU_Vendas > NA_Vendas && EU_Vendas > JP_Vendas) {
            return "EU_Vendas";
        } else {
            return "JP_Vendas";
        }

    }

    public static void main(String[] args) {

        int totalJogosEncontrados = 0;

        // ler jogos.txt
        ArrayList<Jogo> jogosTxt = new ArrayList<>();
        ArquivoTextoLeitura txt = new ArquivoTextoLeitura("/tmp/jogos.txt");
        String linha = txt.ler();
        while (linha != null) {

            Jogo jogo = new Jogo();
            jogo.lerTxt(linha);
            jogosTxt.add(jogo);
            linha = txt.ler();
        }


        // ler input pub.in
        ArrayList<Jogo> encontrados = new ArrayList<>();

        linha = MyIO.readLine();
        while (!linha.equals("FIM")) {
            Jogo jogoIN = new Jogo();
            jogoIN.lerIN(linha);

            for (Jogo jogoTxt : jogosTxt) {
                if (jogoIN.getNomeDoJogo().equals(jogoTxt.getNomeDoJogo())
                        && jogoIN.getAno() == jogoTxt.getAno()
                        && jogoIN.getEditora().equals(jogoTxt.getEditora())
                        && jogoIN.getPlataforma().equals(jogoTxt.getPlataforma())) {
                    totalJogosEncontrados++;
                    encontrados.add(jogoIN);
                        break;
                }
            }
            linha = MyIO.readLine();
        }


        ArrayList<Jogo> cloneBubble = new ArrayList<>(encontrados);
        ArrayList<Jogo> cloneSelecao = new ArrayList<>(encontrados);
        ArrayList<Jogo> cloneinsercao = new ArrayList<>(encontrados);

        Ordenacao.bubble(cloneBubble);
        Ordenacao.selecao(cloneSelecao);
        Ordenacao.insercao(cloneinsercao);


        MyIO.println("Quantidade de jogos encontrados: " + totalJogosEncontrados);

        // printar jogos

        MyIO.println("## " + "BUBBLE" + " [COMPARACOES] [" + (Jogo.getComparacao() / 1000) + "k] [MOVIMENTACOES] ["
        + (Jogo.getMovementos() / 1000) + "k]");
        for(Jogo jogo : cloneBubble){
            jogo.toString(maiorVenda(jogo.getNA_Vendas(), jogo.getEU_Vendas(), jogo.getJP_Vendas()));
            MyIO.println();
        }

        MyIO.println("## " + "INSERTION" + " [COMPARACOES] [" + (Jogo.getComparacao() / 1000) + "k] [MOVIMENTACOES] ["
        + (Jogo.getMovementos() / 1000) + "k]");
        for(Jogo jogo : cloneSelecao){
            jogo.toString(maiorVenda(jogo.getNA_Vendas(), jogo.getEU_Vendas(), jogo.getJP_Vendas()));
            MyIO.println();
        }

        MyIO.println("## " + "SELECTION" + " [COMPARACOES] [" + (Jogo.getComparacao() / 1000) + "k] [MOVIMENTACOES] ["
        + (Jogo.getMovementos() / 1000) + "k]");
        for(Jogo jogo : cloneinsercao){
            jogo.toString(maiorVenda(jogo.getNA_Vendas(), jogo.getEU_Vendas(), jogo.getJP_Vendas()));
            MyIO.println();
        }

    }

 

}