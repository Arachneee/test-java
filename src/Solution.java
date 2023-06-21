import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String,User> users = new HashMap<>();

        for (String id : id_list) {
            users.put(id,new User());
        }

        for (String rep : report) {
            String[] userReport = rep.split(" ");

            User now = users.get(userReport[0]);
            if (now.reportId(userReport[1])) {
                User repo = users.get(userReport[1]);
                repo.reported();
            }

        }

        int[] result = new int[id_list.length];

        int i = 0;
        for (String key:users.keySet()) {
            System.out.println(key);
            int mailCount = 0;
            for (String repo:users.get(key).reportSet) {
                if (users.get(repo).isStoped(k))
                    mailCount += 1;
            }
            result[i++] = mailCount;
        }

        return result;
    }
}
class User {
    int reportCount;
    public Set<String> reportSet = new HashSet<>();

    public void User() {
        reportCount = 0;
    }

    public void reported() {
        reportCount += 1;
    }

    public boolean isStoped(int k) {
        return reportCount >= k;
    }

    public boolean reportId(String name) {
        boolean success = true;
        if (reportSet.contains(name))
            success = false;
        reportSet.add(name);
        return success;
    }
}