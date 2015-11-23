/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Fri Nov 20 20:10:49 2015
 ************************************************************************/

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Iterator;

class Job {
	public int arrTime;
	public int duration;
	public int lastExecuteTime;
	public int executedTime;

	public Job() {
		arrTime = duration = lastExecuteTime =executedTime = 0;
	}

	public Job(int s, int dur) {
		arrTime = s;
		duration = dur;
		lastExecuteTime = 0;
		executedTime = 0;
	}
}

public class Solution {
	public static double averageWaitingTime(int[] arrival, int[] dur, int q) {

		if(arrival==null || arrival.length<2)	return 0;

		LinkedList<Job> jobQueue = new LinkedList<Job>();

		int time = 0, jobFinished = 0, totalWaitingTime = 0, arrivalFlag = 0;

		while(jobFinished<arrival.length) {
			if(jobQueue.isEmpty()) {
				jobQueue.offerLast(new Job(arrival[0], dur[0]));
				time += arrival[0];
				arrivalFlag++;
			} else {
				Job curJob = jobQueue.pollFirst();

				totalWaitingTime += time - curJob.arrTime;

				time += Math.min(curJob.duration, q);

				for( ; arrivalFlag<arrival.length && arrival[arrivalFlag] <= time; arrivalFlag++) {
					jobQueue.offerLast(new Job(arrival[arrivalFlag], dur[arrivalFlag]));
				}

				// Iterator<Job> itr = jobQueue.iterator();
				// while(itr.hasNext()) {
				// 	Job tempJob = itr.next();
				// 	totalWaitingTime += time - tempJob.arrTime;
				// }

				if(curJob.duration > q) {
					jobQueue.offerLast(new Job(time, curJob.duration - q));
				} else {
					jobFinished++;
				}
			}
		}

		return (float)totalWaitingTime/arrival.length;

		// if (Atime == null || Etime == null || Atime.length != Etime.length)	return 0;
		// int length = Atime.length;
		// Queue<Job> queue = new LinkedList<Job>();
		// int curTime = 0, waitTime = 0;
		// int index = 0;
		// while (!queue.isEmpty() || index < length) {
		// 	if (!queue.isEmpty()) {
		// 		Job cur = queue.poll();
		// 		waitTime += curTime - cur.arrTime;
		// 		curTime += Math.min(cur.duration, q);
		// 		for (; index < length && Atime[index] <= curTime; index++)
		// 			queue.offer(new Job(Atime[index], Etime[index]));
		// 		if (cur.duration > q)
		// 			queue.offer(new Job(curTime, cur.duration - q));
		// 	}
		// 	else {
		// 		queue.offer(new Job(Atime[index], Etime[index]));
		// 		curTime = Atime[index++];
		// 	}
		// }
		// return (float) waitTime / length;
	}

	public static void main(String[] args) {
		int[] arr = {0, 1, 4};
		int[] dur = {5, 2, 3};

		System.out.println("[Arrival Time]: " + Arrays.toString(arr));
		System.out.println("[Duration]: " + Arrays.toString(dur));
		System.out.println("Average Waiting Time: " + averageWaitingTime(arr, dur, 3));
	}
}
