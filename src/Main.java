import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Kullanıcıdan alınan matris elemanları
        int[][] matris = promptMatris();

        // Matris
        printMatris(matris,"A");

        // Matrisin devriği yani transpozu
        printMatris(transposeMatris(matris),"A^T");
    }
    // Transpoz metotu
    public static int[][] transposeMatris(int[][] matris){
        int rowIndex = matris.length;
        int colIndex = matris[0].length;
        int[][] transposeMatris = new int[colIndex][rowIndex];

        // Transpoz işleminin gerçekleştirilmesi
        for(int row=0; row < rowIndex; row++){
            for(int col = 0; col < colIndex; col++){
                transposeMatris[col][row] = matris[row][col];
            }
        }
        return transposeMatris;
    }

    // Kullanıcıdan matris boyutunu alma
    public static int[][] promptMatris(){
        Scanner inp = new Scanner(System.in);
        int rowIndex;
        int colIndex;

        do {
            // Satır ve sütün sayıları
            System.out.print("Matrisin satır indexini giriniz: ");
            rowIndex = inp.nextInt();
            System.out.print("Matrisin sütun indexini giriniz: ");
            colIndex = inp.nextInt();

            if (rowIndex > 0 && colIndex > 0) {
                break;
            } else {
                System.out.println("Satır ve sütun indexleri 0 dan büyük olmalı. Lütfen tekrar deneyiniz.");
            }
        } while (true);

        // Belirtilen boyutta matris oluşturma
        int[][] matris = new int[rowIndex][colIndex];

        // Matrisin elemanlarını kullanıcıdan istiyoruz
        for(int row=0; row < rowIndex; row++){
            for(int col = 0; col < colIndex; col++){
                System.out.print("Lütfen " + (row+1) + ".satır ve "+ (col+1) + ".sütün değerini giriniz: ");
                matris[row][col]= inp.nextInt();
            }
        }
        System.out.println();
        return matris;
    }

    // Matrisi ekrana yazdırıyoruz
    public static void printMatris(int[][] matris,String name ) {
        System.out.println(name +" Matris" + " : ");

        for (int[] row : matris) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}