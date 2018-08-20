package com.example.diary2.model.structures;

import com.example.diary2.model.DiaryEntry;

public class LatestContentMaxHeap {
	
	private DiaryEntry[] Heap;
	private int size;
	private int maxSize;
	
	public LatestContentMaxHeap(int maxSize) {
		this.maxSize =maxSize;
		this.size = 0;
		this.Heap = new DiaryEntry[this.maxSize+1];
		DiaryEntry diaryEntry = new DiaryEntry();
		diaryEntry.setViewed(Integer.MAX_VALUE);
	}
	
	private int parent(int pos) {
		return pos/2;
	}
	
	private int leftChild(int pos) {
		return 2*pos;
	}
	
	private int rightChild(int pos) {
		return (2*pos)+1;
	}
	
	private boolean isLeaf(int pos) {
		if(pos>=(size/2) && pos <=size) {
			return true;
		}
		return false;
	}
	
	private void swap(int fPos,int sPos) {
		DiaryEntry tmp;
		tmp = Heap[fPos];
		Heap[fPos] = Heap[sPos];
		Heap[sPos] = tmp;
	}
	
	private void maxHeapify(int pos) {
		if(!isLeaf(pos)) {
			if(Heap[pos].getViewed()<Heap[leftChild(pos)].getViewed() || Heap[pos].getViewed()<Heap[rightChild(pos)].getViewed()) {
				if(Heap[leftChild(pos)].getViewed()>Heap[rightChild(pos)].getViewed()) {
					swap(pos,leftChild(pos));
					maxHeapify(leftChild(pos));
				}else {
					swap(pos,rightChild(pos));
					maxHeapify(rightChild(pos));
				}
			}
		}
	}
	
	public void insert(DiaryEntry diaryEntry) {
		Heap[++size] = diaryEntry;
		int current = size;
		while(Heap[current].getViewed()>Heap[parent(current)].getViewed()) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public void maxHeap() {
		for(int pos = size/2;pos>=0;pos--) {
			maxHeapify(pos);
		}
	}
	
	
}
