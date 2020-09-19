package level2;

import java.util.LinkedList;
import java.util.Queue;

public class level2_truck {
    public static void main(String[] args) {
        System.out.println(new level2_truck().solution(5, 12, new int[]{3, 4, 10, 5, 7}));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        LinkedList<Truck> wait = new LinkedList<>();
        LinkedList<Truck> onBridge = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            wait.add(new Truck(truck_weights[i], 0));
        }

        int nowWeight = 0;
        while (!wait.isEmpty()) {

            if (nowWeight + wait.peek().weight <= weight) {
                answer++;
                Truck truck = wait.poll();
                int truckWeight = truck.weight;
                nowWeight += truckWeight;
                onBridge.add(truck);
                for (Truck t : onBridge) {
                    t.location++;
                }
            } else {
                Truck poll = onBridge.poll();
                int firstTruckLocation = bridge_length - poll.location;
                for (Truck t : onBridge) {
                    t.location += firstTruckLocation;
                }
                answer += firstTruckLocation;
                nowWeight -= poll.weight;
            }
        }

        if (!onBridge.isEmpty()) {
            answer += bridge_length;
        }
        return answer;
    }
}

class Truck {
    int weight;
    int location;

    public Truck(int weight, int location) {
        this.weight = weight;
        this.location = location;
    }
}