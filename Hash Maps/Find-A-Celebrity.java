/*
Suppose you are at a party with n people (labeled from 0 to n - 1), and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her, but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information about whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n). There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.


Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
Output: 1
Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.

         0 1 2
person0:[1,1,0] person0 knows person0,person1
person1:[0,1,0] person1 knows person1
person2:[1,1,1] person2 knows person0,person1,person2
         x y z

         x(column0): person0 is known by person0,person2
         y(column1): person1 is known by person0,person1,person2
         z(column2): person2 is known by person2

         Requirement: the celebrity must have a row sum of 1 and column sum of n
*/

public int findCelebrity(int n) {
  Map<Integer, Integer> row = new HashMap<>();
  Map<Integer, Integer> column = new HashMap<>();

  for(int i = 0; i < n; ++i) {
    for(int j = 0; j < n; ++j) {
      if(knows(i, j)) {
        row.put(i, row.getOrDefault(i, 0) + 1);
        column.put(j, row.getOrDefault(j, 0) + 1);
      }
      if(knows(j, i)) {
        row.put(j, row.getOrDefault(j, 0) + 1);
        column.put(i, row.getOrDefault(i, 0) + 1);
      }
    }
  }

  int result = -1;
  for(int i = 0; i < n; ++i) {
    if(row.get(i) == n && column.get(i) == 1) {
      result = i;
      break;
    }
  }
  return result;
}
