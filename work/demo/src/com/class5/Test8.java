package com.class5;

abstract class SortInt{
	
	private int[] value;
	
	protected abstract void sorting(); // 추상 메소드

	public void sort(int[] value){
		this.value = value;
		
		sorting();
	}
	
	public int length(){
		if(value == null)
			return 0;
		return value.length;
	}
	
	protected final int compare(int i, int j){
		if( value[i] == value[j]){
			return 0;
		}else if ( value[i] > value[j]){
			return 1;
		}else{
			return -1;
		}
	}
	
	protected final void swap(int i, int j){
		int temp;
		
		temp = value[i];
		value[i] = value[j];
		value[j] = temp;
		
	}
	
	public void print(){
		if(value == null){
			return;
		}
		
		for(int n : value){
			System.out.printf("%4d",n);
		}
		System.out.println();
	}
}

class SelectionSort extends SortInt{
	@Override
	protected void sorting() {
		for(int i=0; i<length()-1; i++){
			for(int j=i+1; j<length(); j++){
				
				if( compare(i, j) > 0){
					swap(i, j);
				}
			}
		}
	}
}

class InsertionSort extends SortInt{
	@Override
	protected void sorting() {
		for(int i=1; i<length(); i++){
			int aux = i-1;
			int curIndex = i;
			
			while( aux >= 0 && compare( aux, curIndex) >0){
				swap(aux+1, aux);
				curIndex =aux;
				aux--;
			}
			//swap(aux+1,curIndex);
		}
	}
}

class BubbleSort extends SortInt{
	@Override
	protected void sorting() {
		for(int i=1; i<length(); i++){
			for(int j=0; j<length()-i; j++){
				if( compare(j, j+1) > 0){
					swap(j,j+1);
				}
			}
		}
	}
}

public class Test8 {

	public static void main(String[] args) {

		int[] value = { 23,41,52,32,12};
		/*SelectionSort ss = new SelectionSort();
		ss.sort(value);
		ss.print();*/
		
	/*	InsertionSort is = new InsertionSort();
		is.sort(value);
		is.print();*/
		
		BubbleSort bs = new BubbleSort();
		bs.sort(value);
		bs.print();
	}

}
