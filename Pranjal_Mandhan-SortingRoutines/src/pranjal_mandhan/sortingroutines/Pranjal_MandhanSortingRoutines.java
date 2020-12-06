/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pranjal_mandhan.sortingroutines;


import java.util.Arrays;
import java.util.Scanner;

/** Programmer: Pranjal Mandhan
 * Date: Halloween 2020!
 * Description: a number sorter that allows you to sort numbers in different ways !
 */
public class Pranjal_MandhanSortingRoutines {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       
        // gaining the user value of how many numbers they want
        Scanner input = new Scanner(System.in);
        System.out.println("----Welcome to the number sorting program----");
        System.out.println(" ");
        System.out.println("How many numbers would you like to sort?");
        int rndNumTotal = Integer.parseInt(input.nextLine());
        Integer [] rndNums = new Integer[rndNumTotal];
        
        //randomizing and displying them
        for (int i = 0; i < rndNumTotal; i++) {
            rndNums[i] = ((int)((Math.random() * 2000) + (-1000)));
            System.out.println((i+1) + ". " + rndNums[i]);
        }
        
        //asking the user how they would like the numbers sorted
        System.out.println(" in what order would you like to sort your values \n Type 'A' for Ascending \n Type 'D' for Deceding");
        String order = input.nextLine();
        System.out.println("in what way would you like your numbers sorted \n Type 'S' for Selection Sort \n Type 'B' for Bubble Sort \n Type 'I' for Insertion Sort \n Type 'Q' for Quick Sort");
        String type = input.nextLine();
        
        //excuting a diffrent sorting algorithm based on user choice
        if (order.equalsIgnoreCase("A")) {
            if (type.equalsIgnoreCase("S")){
                System.out.println("Selection Sort Low to High");
                System.out.println(Arrays.toString(selectionSortLtH(rndNums)));
          } else if (type.equalsIgnoreCase("B")) {
                System.out.println("Bubble Sort Low to High");
                System.out.println(Arrays.toString(bubbleSortLtH(rndNums)));
          } else if (type.equalsIgnoreCase("I")) {
                System.out.println("Insertion Sort Low to High");
                System.out.println(Arrays.toString(insertionSortLtH(rndNums)));
          }  else if (type.equalsIgnoreCase("Q")) {
                System.out.println("Quick Sort Low to High");
                System.out.println(Arrays.toString(quickSortLtH(rndNums, 0, rndNums.length-1)));
          }  else 
                System.out.println("Invalid Sort Type please restart program");
        } else if (order.equalsIgnoreCase("D")){
            if (type.equalsIgnoreCase("S")) {
                System.out.println("Selection Sort High to Low");
                System.out.println(Arrays.toString(selectionSortHtL(rndNums)));
          } else if (type.equalsIgnoreCase("B")) {
                System.out.println("Bubble Sort High to Low");
                System.out.println(Arrays.toString(bubbleSortHtL(rndNums)));
          } else if (type.equalsIgnoreCase("I")) {
                System.out.println("Insertion Sort High to Low");
                System.out.println(Arrays.toString(insertionSortHtL(rndNums)));
          } else if (type.equalsIgnoreCase("Q")) {
                System.out.println("Quick Sort High to Low");
                System.out.println(Arrays.toString(quickSortHtL(rndNums, 0, rndNums.length-1)));
         }  else 
                System.out.println("Invalid Sort Type please restart program");
            
        } else 
            System.out.println("Incompatable order type please restart program");
        
    }
    public static Integer[] selectionSortLtH (Integer [] A){
        
        int Temp;
        for (int i = 0; i < (A.length - 1); i++)
            for (int j = i+1; j < A.length; j++)
                if (A[i] > A[j]) {
                    Temp = A[i];
                    A[i] = A[j];
                    A[j] = Temp;
                 }         
                         
        return A;
    }
    public static Integer[] bubbleSortLtH (Integer [] B) {
        int Temp;
        for (int j = 0; j < B.length; j++)   { 
            for (int i = 0; i < B.length-1; i++) {
               
                if (B[i] > B[i+1]) {
                    Temp = B[i];
                    B[i] = B[i+1];
                    B[i+1] = Temp;
                }
            }
        }

        
        return B;  
    }
    public static Integer[] insertionSortLtH(Integer [] C) {
        int Temp;
        int j;
        for (int i = 1; i < C.length; i++){
            Temp = C[i];
            j = i - 1;
            while (j >= 0 && C[j] > Temp) {
                C[j+1] = C[j];
                j = j-1;
            }
            C[j+1] = Temp;
        }
        return C;
    }
    public static Integer[] quickSortLtH (Integer [] H, int begin, int end) {
        if (end > begin) {
            int j;
            j = divideLtH(H, begin, end);
            quickSortLtH(H, begin, j-1);
            quickSortLtH(H, j+1, end);
        }

        return H;
    }
    public static Integer[] selectionSortHtL (Integer [] E) {
        int Temp;
        for (int i = 0; i < (E.length - 1); i++)
            for (int j = i+1; j < E.length; j++)
                if (E[i] < E[j]) {
                    Temp = E[i];
                    E[i] = E[j];
                    E[j] = Temp;
                 }         
                         
        return E;
        
    }
    public static Integer[] bubbleSortHtL (Integer [] F) {
        int Temp;
        for (int j = 0; j < F.length; j++)   { 
            for (int i = 0; i < F.length-1; i++) {
               
                if (F[i] < F[i+1]) {
                    Temp = F[i];
                    F[i] = F[i+1];
                    F[i+1] = Temp;
                }
            }
        }
        return F;
    }
    public static Integer[] insertionSortHtL (Integer [] G) {
        int Temp;
        int j;
        for (int i = 1; i < G.length; i++){
            Temp = G[i];
            j = i - 1;
            while (j >= 0 && G[j] < Temp) {
                G[j+1] = G[j];
                j = j-1;
            }
            G[j+1] = Temp;
        }
        return G;
        
    }
    public static Integer[] quickSortHtL (Integer [] D, int begin, int end) {
        if (begin < end){
            int j;
            j = divideHtL(D, begin, end);
            quickSortHtL(D, begin, j-1);
     	    quickSortHtL(D, j+1, end);
        }

       
            
        return D;
    }
    
   
    public static Integer divideHtL(Integer[]D, int begin, int end) {

        int Temp;
        int i = (begin-1);
        int pivot = D[end];
        
        for (int j = begin; j < end; j++) {
            if (D[j] >= pivot) {
                
            
                i++;
                
                Temp = D[i]; 
                D[i] = D[j]; 
                D[j] = Temp;
                        
            }
            }
        int temp = D[i+1]; 
        D[i+1] = D[end]; 
        D[end] = temp; 
  
        return i+1; 
    }        
    public static Integer divideLtH(Integer[]H, int begin, int end) {
        int Temp;
        int i = (begin-1);
        int pivot = H[end];
        
        for (int j = begin; j < end; j++) {
            if (H[j] <= pivot) {
                
            
                i++;
                
                Temp = H[i]; 
                H[i] = H[j]; 
                H[j] = Temp;
                        
            }
            }
        int temp = H[i+1]; 
        H[i+1] = H[end]; 
        H[end] = temp; 
  
        return i+1; 

     }


    }
 
