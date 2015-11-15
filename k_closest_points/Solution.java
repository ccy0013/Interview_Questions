/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Sat Nov 14 16:21:30 2015
 ************************************************************************/

import java.util.PriorityQueue;
import java.util.Comparator;

class Point {
	float x;
	float y;

	Point() {
		x = 0.f;
		y = 0.f;
	}

	Point(float a, float b) {
		x = a;
		y = b;
	}

	public void print() {
		System.out.println( "(" + x + ", " + y + ")" );
	}
}


public class Solution {

	public static float distanceToOrigin(Point pt) {
		return pt.x * pt.x + pt.y * pt.y;
	}

	public static Point[] kCloestPoints( Point[] points, int k) {
		if(points==null || points.length==0 || k==0)	return null;

		PriorityQueue<Point> minHeap = new PriorityQueue<Point>( k, new Comparator<Point>() {

			public int compare(Point p1, Point p2) {
				return (int)(p1.x*p1.x + p1.y*p1.y - p2.x*p2.x - p2.y*p2.y);
			}
		} );

		PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return (int)(p2.x*p2.x + p2.y*p2.y - p1.x*p1.x - p2.y*p2.y);
			}
		});

		for(Point pt : points) {
			if(maxHeap.size()<k) {
				maxHeap.offer(pt);
				minHeap.offer(pt);
			}
			else {
				if(distanceToOrigin(pt) <= distanceToOrigin(maxHeap.peek())) {
					minHeap.remove(maxHeap.poll());
					minHeap.offer(pt);
					maxHeap.offer(pt);
				}
			}
		}

		Point[] array = new Point[k];

		int size = minHeap.size();
		for(int i=0; i<size; i++)
			array[i] = minHeap.poll();

		return array;
	}

	public static void main(String[] args) {
		Point[] points = new Point[10];

		for(int i=0; i<10; i++) {
			points[i] = new Point(i, i);
		}

		Point[] result = kCloestPoints(points, 3);

		for(Point pt : result)
			pt.print();
	}
}
