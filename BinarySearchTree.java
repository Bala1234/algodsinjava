

import java.util.Stack;

/**
 * @author Balasaheb Dabhade
 * @code Below is an functionalities on Binary Search tree
 */
public class BinarySearchTree {
	DNode root = null;

	void insert(int data) {
		DNode itr = root;

		DNode tmp = new DNode(data);
		if (root == null) {
			root = tmp;
			return;
		}

		while (itr != null) {
			if (data < itr.data) {
				if (itr.left == null) {
					itr.left = tmp;
					break;
				}
				itr = itr.left;

			} else {
				if (itr.right == null) {
					itr.right = tmp;
					break;
				}
				itr = itr.right;
			}
		}
	}

	static void levelOrder(BinarySearchTree bst) {
		Stack<DNode> stk = new Stack<>();
		DNode curr = bst.root;
		stk.push(curr);
		curr = curr.left;
		while (curr != null) {
			stk.push(curr);
			curr = curr.left;
		}
		DNode tmp;
		System.out.println(stk);
		System.out.println(curr);

		while (!stk.isEmpty() && (curr == null)) {
			tmp = stk.pop();
			System.out.print(tmp.data + " ");
			curr = tmp.right;
			if (curr != null) {
				stk.push(curr);
				curr = curr.left;
				while (curr != null) {
					stk.push(curr);
					curr = curr.left;
				}
			}
		}
		// System.out.println(stk);
	}

	int getCount(DNode root) {
		if (root == null)
			return 0;
		else
			return 1 + getCount(root.left) + getCount(root.right);
	}

	/**
	 * checks tree equality
	 * 
	 * @param root
	 * @return
	 */
	static boolean areEqual(DNode root1, DNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 != null && root2 != null) {
			return areEqual(root1.left, root2.left)
					&& areEqual(root1.right, root2.right)
					&& (root1.data == root2.data);
		} else
			return false;

	}

	void inorder(DNode ptr) {
		if (ptr == null)
			return;
		inorder(ptr.left);
		System.out.print(ptr.data + " ");
		inorder(ptr.right);
	}

	int maxHeight(DNode ptr) {
		if (ptr == null)
			return 0;
		return 1 + Math.max(maxHeight(ptr.left), maxHeight(ptr.right));
	}

	void deleteTree(DNode ptr) {
		if (ptr == null)
			return;
		deleteTree(ptr.left);
		deleteTree(ptr.right);
		System.out.println("deleteing node" + ptr.data);
		ptr = null;
	}

	void getMirror(DNode ptr) {
		if (ptr == null)
			return;

		getMirror(ptr.right);
		getMirror(ptr.left);
		DNode tt = ptr.left;
		ptr.left = ptr.right;
		ptr.right = tt;

	}

	/**
	 * Given a binary tree, print out all of its root-to-leaf paths one per
	 * line.
	 * 
	 * @param ptr
	 */
	static void leafToRoot(DNode ptr, int[] arr, int size) {
		if (ptr == null)
			return;
		arr[size] = ptr.data;
		size++;

		if (ptr.left == null && ptr.right == null) {
			printArray(arr, size);
		} else {
			leafToRoot(ptr.left, arr, size);
			leafToRoot(ptr.right, arr, size);
		}
	}

	static void printArray(int[] arr, int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	static void printLeafs(DNode ptr) {
		if (ptr == null)
			return;

		if (ptr.left == null && ptr.right == null) {
			System.out.print(ptr.data + " ");
		} else {
			printLeafs(ptr.left);
			printLeafs(ptr.right);
		}
	}

	static int getLeafCount(DNode ptr) {
		if (ptr == null)
			return 0;

		if (ptr.left == null && ptr.right == null) {
			return 1;
		}
		return getLeafCount(ptr.left) + getLeafCount(ptr.right);
	}

	static void inOrderWithOutrecursion(DNode ptr) {

		Stack<DNode> str = new Stack<>();
		str.push(ptr);
		ptr = ptr.left;
		while (true) {
			if (ptr != null) {
				str.push(ptr);
				ptr = ptr.left;
			} else {
				if (str.isEmpty())
					break;
				DNode itm = str.pop();
				System.out.println(itm.data);
				ptr = itm.right;

			}
		}

	}

	public static void main(String[] args) {
		// ITreeTraIterative bst = new ITreeTraIterative();
		// bst.insert(15);
		// bst.insert(25);
		// bst.insert(200);
		// bst.insert(300);
		// bst.insert(700);
		// bst.insert(2500);

		BinarySearchTree bst2 = new BinarySearchTree();
		bst2.insert(20);
		// bst2.insert(25);
		bst2.insert(15);
		bst2.insert(25);
		bst2.insert(23);
		bst2.insert(30);

		printLeafs(bst2.root);
		System.out.println();
		System.out.println(getLeafCount(bst2.root));

		inOrderWithOutrecursion(bst2.root);
		// int arr[] = new int[100];
		// leafToRoot(bst2.root, arr, 0);

		// bst2.inorder(bst2.root);
		// bst2.getMirror(bst2.root);
		// System.out.println();
		// bst2.inorder(bst2.root);
		// System.out.println();
		// bst2.getMirror(bst2.root);
		// System.out.println();
		// bst2.inorder(bst2.root);

		// System.out.println(areEqual(bst.root, bst2.root));

		// System.out.println(bst.maxHeight(bst2.root));
		// bst2.deleteTree(bst2.root);

		// levelOrder(bst);
		// System.out.println();
		// System.out.println(bst.getCount(bst.root));
		// bst.inorder(bst.root);
	}

}
