class CgTreeGraphPract {
	
	public class CgTreeNode<T> {
		public CgTreeNode left;
		public CgTreeNode right;
		public T data;
		
		public CgTreeNode(T t) {
			this.data = t	
		}
	}


	public boolean isBalanced(CgTreeNode root) {
		if (root == null) {
			return true;
		}

		int height = checkHeight(root);

		return height != -1
	}

	public int checkHeight(CgTreeNode root) {
		if (root == null) {
			return 0;
		}

		int heightLeft = checkHeight(root.left);
		int heightRight = checkHeight(root.right);

	

		if ( heightLeft == -1 || heightRight == -1 || Math.abs(heightLeft - heightRight) > 1 ) {
			return -1
		}

		return heightLeft > heightRight ? heightLeft + 1 : heightRight + 1;
	}

}
