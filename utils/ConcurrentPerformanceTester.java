package utils;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public class ConcurrentPerformanceTester<P, Q, R> {

    private final String testName;
    private final Function<P, R> testMethod1;
    private final BiFunction<P, Q, R> testMethod2;
    private final P[] input1;
    private final Q[] input2;
    private final R[] expectedOutput;
    private final int threadCount;
    private final int iterationsPerThread;

    // For Function<P,R>
    public ConcurrentPerformanceTester(String testName, Function<P, R> testMethod,
                                       P input[], R expectedOutput[],
                                       int threadCount, int iterationsPerThread) {
        this.testName = testName;
        this.testMethod1 = testMethod;
        this.testMethod2 = null;
        this.input1 = input;
        this.input2 = null;
        this.expectedOutput = expectedOutput;
        this.threadCount = threadCount;
        this.iterationsPerThread = iterationsPerThread;
    }

    // For BiFunction<P,Q,R>
    public ConcurrentPerformanceTester(String testName, BiFunction<P, Q, R> testMethod,
                                       P input1[], Q input2[], R expectedOutput[],
                                       int threadCount, int iterationsPerThread) {
        this.testName = testName;
        this.testMethod1 = null;
        this.testMethod2 = testMethod;
        this.input1 = input1;
        this.input2 = input2;
        this.expectedOutput = expectedOutput;
        this.threadCount = threadCount;
        this.iterationsPerThread = iterationsPerThread;
    }

    // ✅ Unified executor for both test types
    private R[] executeOnce() {
        List<R> result = new ArrayList<R>();
        if (testMethod1 != null) {
            for ( P input : input1)
            {
                result.add(testMethod1.apply(input));
            }
        }
        else if (testMethod2 != null){
            int size = Math.min(input1.length, input2.length);
            for (int i = 0; i < size; i++) {
                result.add(testMethod2.apply(input1[i], input2[i]));
            }
        } 
        else throw new IllegalStateException("No test method provided!");

        return (R[]) result.toArray((R[]) new Object[result.size()]);
    }

    // ✅ Single-threaded test
    public void runTest(int iterations) {
        System.out.println("===== Running Test: " + testName + " =====");
        Runtime runtime = Runtime.getRuntime();

        // Warm-up (JIT optimization)
        for (int i = 0; i < 100; i++) executeOnce();

        runtime.gc();
        long beforeMem = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        R[] lastResult = null;
        for (int i = 0; i < iterations; i++) lastResult = executeOnce();

        long end = System.nanoTime();
        long afterMem = runtime.totalMemory() - runtime.freeMemory();

        double elapsed = (end - start) / 1_000_000.0;
        long memUsed = afterMem - beforeMem;

        System.out.println("Time taken: " + elapsed + " ms for " + iterations + " iterations");
        System.out.println("Memory used: " + memUsed + " bytes");
        for (int i =0; i < lastResult.length;i++){
            System.out.println("Test Case "+(i+1)+" Output: " + lastResult[i]);
        }
        

        if (expectedOutput != null) {
            int i = 0;
            boolean correct = true;
            for (R r : expectedOutput)
            {
                
                if (!r.equals(lastResult[i]))
                {
                    correct = false;
                    break;
                }
                i++;
            }
            System.out.println("Output match: " + (correct ? "True" : "False"));
        }
        System.out.println("====================================\n");
    }

    // ✅ Multi-threaded test
    public void runTestUsingThreads() {
        System.out.println("===== Running Concurrent Test: " + testName + " =====");
        System.out.println("Threads: " + threadCount + " | Iterations per thread: " + iterationsPerThread);

        Runtime runtime = Runtime.getRuntime();
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < 100; i++) executeOnce(); // Warm-up

        runtime.gc();
        long beforeMem = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        List<Callable<R[]>> tasks = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            tasks.add(() -> {
                R[] lastResult = null;
                for (int j = 0; j < iterationsPerThread; j++) lastResult = executeOnce();
                return lastResult;
            });
        }

        List<R[]> results = new ArrayList<>();
        try {
            List<Future<R[]>> futures = executor.invokeAll(tasks);
            for (Future<R[]> f : futures) results.add(f.get());
        } catch (Exception e) {
            throw new RuntimeException("Test failed", e);
        } finally {
            executor.shutdown();
        }

        long end = System.nanoTime();
        long afterMem = runtime.totalMemory() - runtime.freeMemory();

        double elapsed = (end - start) / 1_000_000.0;
        long memUsed = afterMem - beforeMem;

        System.out.println("Time taken: " + elapsed + " ms (total for all threads)");
        System.out.println("Memory used: " + memUsed + " bytes");
        if (!results.isEmpty()) System.out.println("Sample Output: " + results.get(0));

        if (expectedOutput != null) {
            boolean allMatch = results.stream().allMatch(r -> expectedOutput.equals(r));
            System.out.println("Output match: " + (allMatch ? " All matched" : " Mismatch found"));
        }

        System.out.println("====================================\n");
    }

    public void runTestShortOutput() {
        System.out.println("===== Running Test: " + testName + " =====");

        R[] lastResult = null;
        lastResult = executeOnce();
        

        if (expectedOutput != null) {
            int i = 0;
            boolean correct = true;
            for (R r : expectedOutput)
            {
                
                if (!r.equals(lastResult[i]))
                {
                    correct = false;
                    break;
                }
                i++;
            }
            System.out.println("Output match: " + (correct ? "True" : "False"));
        }
        System.out.println("====================================\n");
    }

    public void runPerformanceTest(int iterations)
    {
        System.out.println("===== Running Test: " + testName + " =====");
        Runtime runtime = Runtime.getRuntime();

        // Warm-up (JIT optimization)
        for (int i = 0; i < 100; i++) executeOnce();

        runtime.gc();
        long beforeMem = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        R[] lastResult = null;
        for (int i = 0; i < iterations; i++) lastResult = executeOnce();

        long end = System.nanoTime();
        long afterMem = runtime.totalMemory() - runtime.freeMemory();

        double elapsed = (end - start) / 1_000_000.0;
        long memUsed = afterMem - beforeMem;

        System.out.println("Time taken: " + elapsed + " ms for " + iterations + " iterations");
        System.out.println("Memory used: " + memUsed + " bytes");
    }
}
