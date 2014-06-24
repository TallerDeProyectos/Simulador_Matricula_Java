package com.taller.proyectos.app;

/**
*
* @author Alv4reX David
*/
public class Mochila {

int cantItems;
int item[];
double reward[];
int weight[];
int nCombinations;
int binaryArray[][];
//String binaryArray[][];
boolean res[];
int maxWeight[];
double maxReward[];
int maxSize;
  
   public Mochila(int cantItems, int maxSize, int item[], double reward[], int weight[]){
   
       this.cantItems = cantItems;
       nCombinations = getNCombinations(this.cantItems);
       binaryArray = new int[nCombinations][this.cantItems];
       //binaryArray = new String[nCombinations][this.cantItems];
       res = new boolean[nCombinations];
       maxWeight = new int[nCombinations];
       maxReward = new double[nCombinations];
               
       this.item = new int[this.cantItems];
       this.reward = new double[this.cantItems];
       this.weight = new int[this.cantItems];
       this.maxSize = maxSize;
       
       this.item = item;
       this.reward = reward;
       this.weight = weight;
       
       this.maxSize = maxSize;
       
       for(int i=0; i<nCombinations; i++){
           res[i]=true;
       }
   
   }
   
   public int[] execMochila(){
       
       String bin="";
       String answer="";
       int totalWeight=0;
       double totalReward=0;
       double higherReward=0;
       int index=-1;
       int cursosId[] = new int[cantItems];
       
       for(int i=0; i<nCombinations; i++){
           bin=Integer.toBinaryString(i);
           while(bin.length()<this.cantItems){
               bin="0"+bin;
           }
           
           for(int j=0; j<cantItems; j++){
           binaryArray[i][j]=Integer.parseInt(String.valueOf(bin.charAt(j)));
           totalWeight+=binaryArray[i][j]*weight[j];
           totalReward+=binaryArray[i][j]*reward[j];
           answer+=("["+binaryArray[i][j]+"]");
           }
           maxWeight[i]=totalWeight;
           maxReward[i]=totalReward;
           if(maxWeight[i]>maxSize){
               res[i]=false;
           }
           
           if(higherReward<maxReward[i] && res[i]){
               higherReward=maxReward[i];
               index=i;
           }
           answer+=( "\t peso:["+maxWeight[i]+"]\t beneficio:["+maxReward[i]+"]\t ["+res[i]+"]\t");
           answer+="\n";
           
           bin="";
           totalWeight=0;
           totalReward=0;
       }
       answer+="\n";
       answer+="Se llevara "+maxWeight[index]+" créditos con una prioridad de "+maxReward[index]+", los cursos son:\n";
       
       
       for(int j=0; j<cantItems; j++){
               cursosId[j] =  -1;
       }
       
       for(int j=0; j<cantItems; j++){
           if(binaryArray[index][j]==1){
               answer+="-> "+item[j]+"\n";
               cursosId[j] =  item[j];
           }
       }
       System.out.println(answer);
   
       return cursosId;
   }
   
   private int getNCombinations(int cantItems){
       return (int) Math.pow(2, cantItems);
   }
   
//   public static void main(String[] args){
//       
//       double reward[]=new double[4];
//       reward[0]=200;
//       reward[1]=100;
//       reward[2]=400;
//       reward[3]=300;
//       int weight[]=new int[4];
//       weight[0]=50;
//       weight[1]=100;
//       weight[2]=80;
//       weight[3]=20;
//       String items[]=new String[4];
//       items[0]="Laton";
//       items[1]="Aluminio";
//       items[2]="Acero";
//       items[3]="Bronce";
//       
//       Mochila obj=new Mochila(4, 200, items, reward, weight);
//       System.out.println(obj.execMochila());
//
//   }
//   
   
}


