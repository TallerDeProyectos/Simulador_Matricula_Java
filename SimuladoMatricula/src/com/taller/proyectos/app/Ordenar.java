package com.taller.proyectos.app;

import java.util.ArrayList;
import java.util.List;

import com.taller.proyectos.bean.CursoHabilBean;

public class Ordenar {

	List<CursoHabilBean> cHabiles;
	
	
	
	public void quicksort(List<CursoHabilBean> cHabiles, int a, int b){
		
		this.cHabiles = new ArrayList<CursoHabilBean>();
		CursoHabilBean buf;
		int from = a;
		int to = b;
		int pivot  = cHabiles.get((from+to)/2).getPrioridad();
		
		do{
			
			while(cHabiles.get(from).getPrioridad()<pivot){
				from++;
			}
			while(cHabiles.get(to).getPrioridad()>pivot){
				to--;
			}
			
			if(from <= to){
				CursoHabilBean temp =  cHabiles.get(from);
				pivot = cHabiles.get(from).getPrioridad();
				cHabiles.set(from, cHabiles.get(to));
				cHabiles.set(to, temp);
				from++;
				to--;
			}
			
		}while(from<=to);
		
		if(a < to){
			quicksort(cHabiles, a, to);
		}
		if(from <b){
			quicksort(cHabiles, from, b);
		}
		this.cHabiles = cHabiles;
	}
	
	
//	public static void main(String args[])
//    {
//        //Numbers which need to be sorted
//        int numbers[] = {23,5,23,1,7,12,3,34,0,-2,4,2,1222,2,0};
// 
//        //Displaying the numbers before sorting
//        System.out.print("Before sorting, numbers are ");
//        for(int i = 0; i < numbers.length; i++)
//        {
//            System.out.print(numbers[i]+" ");
//        }
//        System.out.println();
// 
//        //Sorting in ascending order using bubble sort
//        quickSortInAscendingOrder(numbers,0,numbers.length-1);
// 
//        //Displaying the numbers after sorting
//        System.out.print("Before sorting, numbers are ");
//        for(int i = 0; i < numbers.length; i++)
//        {
//            System.out.print(numbers[i]+" ");
//        }
// 
//    }
//    //This method sorts the input array in ascecnding order using quick sort
//    static void quickSortInAscendingOrder (int[] numbers, int low, int high)
//    {
// 
//        int i=low;
//        int j=high;
//        int temp;
//        int middle=numbers[(low+high)/2];
// 
//        while (i<j)
//        {
//            while (numbers[i]<middle)
//            {
//                i++;
//            }
//            while (numbers[j]>middle)
//            {
//                j--;
//            }
//            if (i<=j)
//            {
//                temp=numbers[i];
//                numbers[i]=numbers[j];
//                numbers[j]=temp;
//                i++;
//                j--;
//            }
//        }
// 
// 
//        if (low<j)
//        {
//            quickSortInAscendingOrder(numbers, low, j);
//        }
//        if (i<high)
//        {
//            quickSortInAscendingOrder(numbers, i, high);
//        }
//    }

}
