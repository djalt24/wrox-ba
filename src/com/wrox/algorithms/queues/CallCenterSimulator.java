package com.wrox.algorithms.queues;

import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * A call center simulator illustrating the use of a queue.
 * 
 * @author David Nelson
 *
 */
public class CallCenterSimulator {
	
	/** the number of operators */
	private static int operators = 0;
	
	/** the maximum number of calls in the queue */
	private static int maxCallsInQueue = 0;
	
	/** the maximum simulated duration of a call */
	private static int maxDuration = 0;
	
	/** the maximum simulated interval of a call */
	private static int maxInterval = 0;
		
	/** the current call number */
	private static int currentCallCount = 0;
	
	/** the thread pool */
	private static ScheduledThreadPoolExecutor executor;
	
	/** the call queue */
	private static Queue<Call> callQueue;
	
	/** a random utility for simulation */
	private static Random random = new Random();

	/**
	 * The Program Main.<br>
	 * arg1: number of operators<br>
	 * arg2: max number of calls in queue<br>
	 * arg3: max call duration<br>
	 * arg4: max call interval<br>
	 * @param args the arguments, see method description
	 */
	public static void main(String[] args) {
		assert args != null: "CallCenterSimulator requires arguments";
		
		System.out.println("STARTING CallCenterSimulator");
		for (int i = 0; i < args.length; i++) {
			System.out.println("arg[" + i + "]=" + args[i]);
		}
		
		operators = Integer.valueOf(args[0]);
		maxCallsInQueue = Integer.valueOf(args[1]);
		maxDuration = Integer.valueOf(args[2]);
		maxInterval = Integer.valueOf(args[3]);
		
		System.out.println("Simulator settings: operators=" + operators + ", maxCallsInQueue=" + maxCallsInQueue
				           +", maxDuration=" + maxDuration  + ", maxInterva=" + maxInterval);
		
		// create the call queue
		callQueue = new BlockingQueue<Call>(new ListFifoQueue<Call>(), maxCallsInQueue);
		
		// create n operator runnables
		executor = new ScheduledThreadPoolExecutor(operators);
		
		for (int i = 0; i < operators; i++) {
			executor.schedule(new Operator(i), maxInterval, TimeUnit.SECONDS);
		}
		
		// start simulation of calls
		while(true) {
			int randomDuration = random.nextInt(maxDuration);
			Call call = new Call(randomDuration, ++currentCallCount);
			callQueue.enque(call);
		}		
	}
	
	/**
	 * Representation of a phone call
	 * 
	 * @author David Nelson
	 *
	 */
	private static final class Call {
		
		/** the duration of the call */
		private int callDuration;
		
		/** the call instance number */
		private int callNumber;
		
		/**
		 * Constructor
		 * @param duration the call duration
		 * @param callInstance the call instance
		 */
		public Call(int duration, int callInstance) {
			callDuration = duration;
			callNumber = callInstance;
		}
	}
	
	/**
	 * Representation of an Operator
	 * 
	 * @author David Nelson
	 *
	 */
	private static final class Operator implements Runnable {
		
		/** the operator id */
		private int myId;
		
		/**
		 * Constructor
		 * @param id the id of the operator
		 */
		public Operator(int id) {
			myId = id;
		}

		@Override
		public void run() {
			Call call = callQueue.dequeue();
			System.out.println("Operator id=" + myId + " answering Call number " + call.callNumber + 
					           " which lasts for " + call.callDuration + " seconds");
			executor.schedule(this, call.callDuration, TimeUnit.SECONDS);
		}		
	}
}
