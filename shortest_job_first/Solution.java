/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Sat Nov 21 16:34:31 2015
 ************************************************************************/

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

class Job {
	public int id;
	public int arrivalTime;
	public int duration;

	public Job() {
		id = arrivalTime = duration = 0;
	}

	public Job(int arr, int dur) {
		arrivalTime = arr;
		duration = dur;
	}
}

public class Solution {
	public static float avgWaitingSJF(int[] arr, int[] dur) {
		if(arr==null || arr.length==0)	return 0;

		PriorityQueue<Job> jobQueue = new PriorityQueue<Job>(arr.length, new Comparator<Job>(){
			public int compare(Job job1, Job job2) {
				if(job1.duration==job2.duration)
					return job1.arrivalTime - job2.arrivalTime;
				return job1.duration - job2.duration;
			}
		});

		int time = 0, jobFinished = 0, jobArrived = 0, totalWaitingTime = 0;

		while(jobFinished<arr.length) {
			if(jobQueue.isEmpty()) {
				time = arr[0];
				for( ; jobArrived<arr.length && arr[jobArrived] <= time; jobArrived++) {
					jobQueue.offer(new Job(arr[jobArrived], dur[jobArrived]));
				}
			} else  {
				Job curJob = jobQueue.poll();

				totalWaitingTime += time - curJob.arrivalTime;

				time += curJob.duration;
				jobFinished++;

				for( ; jobArrived<arr.length && arr[jobArrived]<=time; jobArrived++) {
					jobQueue.offer(new Job(arr[jobArrived], dur[jobArrived]));
				}
			}
		}

		return totalWaitingTime/(float)arr.length;
	}


	public static void main(String[] args) {
		int[] arr1 = {0, 2, 4, 5};
		int[] arr2 = {0, 1, 3, 9};
		int[] dur1 = {7, 4, 1, 4};
		int[] dur2 = {2, 1, 7, 5};

		System.out.println("[Test Case 1]");
		System.out.println("[Arrival Time]: " + Arrays.toString(arr1));
		System.out.println("[Duration]: " + Arrays.toString(dur1));
		System.out.println("Average Waiting Time: " + avgWaitingSJF(arr1, dur1));

		System.out.println("[Test Case 2]");
		System.out.println("[Arrival Time]: " + Arrays.toString(arr2));
		System.out.println("[Duration]: " + Arrays.toString(dur2));
		System.out.println("Average Waiting Time: " + avgWaitingSJF(arr2, dur2));
	}
}
