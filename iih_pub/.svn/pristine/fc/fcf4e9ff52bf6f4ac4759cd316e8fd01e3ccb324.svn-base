package iih.mbh.nm.d;

import java.util.List;

import xap.sys.appfw.orm.model.agg.BaseAggDO;

public class TreeNode<T extends BaseAggDO> {
	private String id;
	private String parentId;
	private TreeNode<T> parent;
	private List<TreeNode<T>> children;
	private String name;
	private int level;
	private boolean isLeaf;
	private T nodeData;

	public TreeNode(String id, String parentId, String name, T nodeData, TreeNode<T> parent) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.nodeData = nodeData;
		this.parent = parent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<TreeNode<T>> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode<T>> children) {
		this.children = children;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public void setNodeData(T data) {
		this.nodeData = data;
	}

	public T getNodeData() {
		return this.nodeData;
	}
}
