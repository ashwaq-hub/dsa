/**
 * Logic / Strategy : BFS with a Queue and len(q) loop Time: O(n) Space: O(n)
 *
 * Strategy: Use a Queue and a nested loop for the "level size."
 */

class LevelOrder {

	/**
	 * Returns a list of lists, where each inner list represents the values of the
	 * nodes in the same level of the binary tree. The outer list is ordered by the
	 * level of the nodes, from top to bottom. The inner lists are ordered from left
	 * to right. If the binary tree is empty, an empty list is returned.
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				level.add(node.val);
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			res.add(level);
		}
		return res;
	}

	public static void main(String args[]) {
		LevelOrder lo = new LevelOrder();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(lo.levelOrder(root)); // Output: [[1], [2, 3], [4, 5]]
	}
}