import java.util.Scanner;

public class MatrixMultiplication
{
    public void multiplyMatrix(int [][]matrix1,int [][]matrix2){
        int result[][]=new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j]=0;
                for (int k = 0; k < result.length; k++) {
                    result[i][j]+=matrix1[i][k]*matrix2[k][j];
                }
            }
        }

        System.out.println("\nResultant Matrix : ");
        PrintMatrix.printMatrix(result);
    }
}

class GenerateMatrix{
    public static int [][]matrix1 = new int[3][3];
    public static int [][]matrix2 = new int[3][3];

    public void buildMatrix(){
        System.out.println("Enter Matrix 1 Elements:");
        setElements(matrix1);
        System.out.println("\nEnter Matrix 2 Elements:");
        setElements(matrix2);
    }

    public void setElements(int[][]matrix)
    {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("element["+i+"]["+j+"] : ");
                matrix[i][j] = sc.nextInt();
            }
        }
    }
}

class PrintMatrix{
    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    
    }
}

class Main{
    public static void main(String[] args) 
    {
     GenerateMatrix generate = new GenerateMatrix();
     generate.buildMatrix();
     System.out.println("\nMatrix 1 :-");
     PrintMatrix.printMatrix(GenerateMatrix.matrix1);
     System.out.println("\nMatrix 2 :-");
     PrintMatrix.printMatrix(GenerateMatrix.matrix2);

     new MatrixMultiplication().multiplyMatrix(GenerateMatrix.matrix1, GenerateMatrix.matrix2);
    }
}