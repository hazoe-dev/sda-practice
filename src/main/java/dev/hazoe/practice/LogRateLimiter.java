package dev.hazoe.practice;

import java.util.*;

public class LogRateLimiter {
    public static List<String> findViolatedUsers(List<String> logs) {
        List<String> violatedUsers = new ArrayList<>();

        Map<String, List<Integer>> users = new HashMap<>();

        //parse logs
        for (String log : logs) {
            String[] parts = log.split(" ");
            String user = parts[0];
            int time = Integer.parseInt(parts[1]);

            users.computeIfAbsent(user, k-> new ArrayList<>())
                    .add(time);
        }

        //check each user
        for (String user : users.keySet()){
            List<Integer> times = users.get(user);
            Collections.sort(times);

            int left = 0;
            for (int right = 0; right < times.size(); right++){
                while (times.get(right)-times.get(left) >=60){
                    left++;
                }
                if(right -left + 1 > 3){
                    violatedUsers.add(user);
                }
            }
        }

        return violatedUsers;
    }
}
