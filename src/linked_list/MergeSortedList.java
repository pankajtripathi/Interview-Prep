package linked_list;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pankajtripathi
 * */
public class MergeSortedList {
	public static void main(String[] args) {
		List<Integer> list1=new LinkedList<>();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		List<Integer> list2=new LinkedList<>();
		list2.add(2);
		list2.add(4);
		list2.add(6);
		list2.add(8);
		list2.add(10);
		List<Integer> resList=mergeList(list1,list2);
		System.out.println("Merged List:\n");
		for(Integer num:resList)
			System.out.print(num+"  ");
	}

	private static List<Integer> mergeList(List<Integer> list1,
			List<Integer> list2) {
		int indexL=0,indexR=0,indexRes=0;
		int maxSize=list1.size()+list2.size();
		List<Integer> resList=new LinkedList<>();

		while(indexRes!=maxSize){
			//till both list are empty
			if(indexL<list1.size() && indexR<list2.size()){
				if(list1.get(indexL)<=list2.get(indexR)){
					resList.add(indexRes, list1.get(indexL));
					indexL++;
					indexRes++;
				}
				else{
					resList.add(indexRes, list2.get(indexR));
					indexR++;
					indexRes++;
				}
			}
			//if there are no elements in second list
			else if(indexL<list1.size()){
				resList.add(indexRes, list1.get(indexL));
				indexL++;
				indexRes++;
			}
			//if there are no elements in first list
			else if(indexR<list2.size()){
				resList.add(indexRes, list2.get(indexR));
				indexR++;
				indexRes++;
			}
		}
		return resList;
	}
}
