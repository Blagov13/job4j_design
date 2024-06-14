package ru.job4j.algo.greedy;

public class GasStation {
   /* Вычислительная сложность 0(n)
    Объем используемой памяти 0(1) */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0;
        int currentTank = 0;
        int startingStation = 0;
        for (int i = 0; i < n; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
            if (currentTank < 0) {
                startingStation = i + 1;
                currentTank = 0;
            }
        }
        if (totalTank >= 0) {
            return startingStation;
        } else {
            return -1;
        }
    }
}
