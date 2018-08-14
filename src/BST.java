import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class BST<T extends Comparable<T>> {
	private BSTNode<T> root = null;
	
	public void insert (T item) {
		root = insertHelper(item, root);
	}
	
	private BSTNode<T> insertHelper (T item, BSTNode<T> tree){
		if(tree == null) {
			return new BSTNode<T>(item);
		}
		
		if(item.compareTo(tree.value) < 0) {
			tree.left = insertHelper(item, tree.left);
		} else if(item.compareTo(tree.value) > 0) {
			tree.right = insertHelper(item, tree.right);
		} else {
			throw new IllegalArgumentException();
		}
		
		return tree;
	}
	
	public boolean contains (T item) {
		return containsHelper(item, root);
	}
	
	private boolean containsHelper (T item, BSTNode<T> tree) {
		if(tree == null) {
			return false;
		} else if(item.compareTo(tree.value) < 0) {
			return containsHelper(item, tree.left);
		} else if(item.compareTo(tree.value) > 0) {
			return containsHelper(item, tree.right);
		} else {
			return true;
		} 
	}
	
	public void remove (T item) {
		root = removeHelper(item, root);
	}
	
	private BSTNode<T> removeHelper (T item, BSTNode<T> tree){
		if(tree == null) {
			return tree;
		} else if(item.compareTo(tree.value) < 0) {
			tree.left = removeHelper(item, tree.left);
		} else if(item.compareTo(tree.value) > 0){
			tree.right = removeHelper(item, tree.right);
		} else {
			if(tree.left == null)
				return tree.right;
			
			if(tree.right == null)
				return tree.left;
			
			tree.value = findMax(tree.left);
			tree.left = removeHelper(tree.value, tree.left);
		}
		return tree;
	}
	
	private T findMax(BSTNode<T> tree) {
		if(tree.right == null)
			return tree.value;
		
		return findMax(tree.right);
	}
	
	
	BSTNode<T> maxParent = root;
	private BSTNode<T> findMaxNode(BSTNode<T> tree) {
		if(tree.right == null)
			return tree;
		
		maxParent = tree;
		return findMaxNode(tree.right);
	}
	
	public T findSecondMax() {
		BSTNode<T> maxNode = findMaxNode(root);
		if(maxNode.left != null)
			return findMax(maxNode.left);
		
		return maxParent.value;
	}
	
	public static class BSTNode<T> {
		public T value;
		public BSTNode<T> left;
		public BSTNode<T> right;
		
		public BSTNode(T value) {
			this.value = value;
		}
	}
	
	private class BSTIterator<T> implements Iterator<T> {
		Queue<BSTNode<T>> q = new ArrayDeque<>();
		
		BSTIterator(BSTNode<T> tree) {
			q.add(tree);
		}
		
		@Override
		public boolean hasNext() {
			return !q.isEmpty();
		}

		@Override
		public T next() {
			BSTNode<T> curr = q.poll();
			if(curr.left != null)
				q.add(curr.left);
			if(curr.right != null)
				q.add(curr.right);
			
			return curr.value;
		}
		
	}

	public Iterator<T> BFSIterator() {
		return new BSTIterator<T>(root);
	}
	
	public void print () {
		BTreePrinter.printNode(root);
	}
}
