/**
 * Logic / Strategy : Cycle detection (DFS) or Kahn's (BFS) Time: O(V+E) Space:
 * O(V+E)
 * 
 * Strategy: Sink the island (change '1' to '0') using recursion once you find
 * land.
 */

class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] pre : prerequisites) {
			graph.computeIfAbsent(pre[1], k -> new ArrayList<>()).add(pre[0]);
		}
		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(graph, visited, i)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int course) {
		if (visited[course]) {
			return false; // Cycle detected
		}
		if (!graph.containsKey(course)) {
			return true; // No prerequisites
		}
		visited[course] = true;
		for (int next : graph.get(course)) {
			if (!dfs(graph, visited, next)) {
				return false;
			}
		}
		visited[course] = false; // Backtrack
		return true;
	}

	public static void main(String[] args) {
		CourseSchedule cs = new CourseSchedule();
		int numCourses = 2;
		int[][] prerequisites = { { 1, 0 } };
		System.out.println(cs.canFinish(numCourses, prerequisites));
	}

}