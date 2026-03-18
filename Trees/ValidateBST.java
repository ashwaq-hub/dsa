/**
 * Logic / Strategy : DFS with (min, max) bounds Time: O(n) Space: O(h)
 */

class ValidateBST {

	/**
	 * Returns true if the binary search tree rooted at root is a valid BST. A valid
	 * BST is one where each node has a value greater than or equal to its left
	 * child and less than or equal to its right child, and where all nodes satisfy
	 * this condition.
	 * 
	 * @param root the root of the binary search tree
	 * @return true if the binary search tree is a valid BST, false otherwise
	 */
	public boolean isValidBST(TreeNode root) {
		return dfs(root, null, null);
	}

	/**
	 * Recursively checks if a binary search tree rooted at node is a valid BST. The
	 * tree rooted at node is a valid BST if all nodes in the tree satisfy the
	 * following condition: the value of each node is greater than or equal to its
	 * left child and less than or equal to its right child. The function also takes
	 * two bounds, min and max, which are used to check if the value of each node is
	 * within the valid range. If either min or max is null, it is ignored in the
	 * check.
	 * 
	 * @param node the root of the binary search tree
	 * @param min  the minimum valid value for all nodes in the tree
	 * @param max  the maximum valid value for all nodes in the tree
	 * @return true if the binary search tree is a valid BST, false otherwise
	 */
	private boolean dfs(TreeNode node, Integer min, Integer max) {
		if (node == null)
			return true;
		if ((min != null && node.val <= min) || (max != null && node.val >= max))
			return false;
		return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
	}

	public static void main(String args[]) {
		ValidateBST vb = new ValidateBST();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(vb.isValidBST(root)); // Output: true
	}
}