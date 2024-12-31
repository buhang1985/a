package iih.bd.srv.medsrv.validate;

import java.util.ArrayList;
import java.util.List;

public class BDErrorInfo {
	
	public final static String PaddingString = "    ";
	public final static String OffsetString = "  ";
	public final static String NextLineString = "\n";
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		BDErrorInfo o = new BDErrorInfo(this.id_item,this.name_item);
		for (BDErrorInfo b : this.subItems){
			o.subItems.add((BDErrorInfo) b.clone());
		}
	    o.descList.addAll(this.descList);
		return o;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descList == null) ? 0 : descList.hashCode());
		result = prime * result + ((id_item == null) ? 0 : id_item.hashCode());
		result = prime * result + ((name_item == null) ? 0 : name_item.hashCode());
		result = prime * result + ((subItems == null) ? 0 : subItems.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BDErrorInfo other = (BDErrorInfo) obj;
		if (descList == null) {
			if (other.descList != null)
				return false;
		} else if (!descList.equals(other.descList))
			return false;
		if (id_item == null) {
			if (other.id_item != null)
				return false;
		} else if (!id_item.equals(other.id_item))
			return false;
		if (name_item == null) {
			if (other.name_item != null)
				return false;
		} else if (!name_item.equals(other.name_item))
			return false;
		if (subItems == null) {
			if (other.subItems != null)
				return false;
		} else if (!subItems.equals(other.subItems))
			return false;
		return true;
	}
	private String id_item;
	private String name_item;
	private List<String> descList = new ArrayList<String>();
	private List<BDErrorInfo> subItems = new ArrayList<BDErrorInfo>();
	
	public BDErrorInfo(String id_item, String name_item) {
		super();
		this.id_item = id_item;
		this.name_item = name_item;
	}
	
	
	public String getId_item() {
		return id_item;
	}
	public void setId_item(String id_item) {
		this.id_item = id_item;
	}
	public String getName_item() {
		return name_item;
	}
	public void setName_item(String name_item) {
		this.name_item = name_item;
	}
	public List<String> getDescList() {
		return descList;
	}
	public List<BDErrorInfo> getSubItems() {
		return subItems;
	}
	
	public String toErrorString(){
		StringBuilder sb = new StringBuilder();
		
		for (String msg : this.getDescList()){
			sb.append(msg).append(";");
		}
		
		return sb.toString();
	}
	
	public String toReportString(String pds){
		if (this.descList.size() == 0&&this.getSubItems().size() == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		
		sb
		.append(pds)
		.append(this.id_item==null?"未知 id":this.id_item)
		.append(OffsetString)
		.append(this.name_item==null?"未知 name":this.name_item)
		.append(NextLineString)
		.append(pds)
		.append(PaddingString)
		.append(OffsetString)
		.append("问题：")
		.append(NextLineString);
		int index = 1;
		for (String msg : this.descList){
			sb
			.append(pds)
			.append(PaddingString).append(PaddingString)
			.append(OffsetString)
			.append(index++).append(". ")
			.append(msg)
			.append(NextLineString);
		}
		if (this.subItems.size() > 0){
		sb
		.append(pds)
		.append(PaddingString)
		.append(OffsetString)
		.append("子项目：")
		.append(NextLineString);
		
		for (BDErrorInfo info : this.subItems ){
			sb.append(info.toReportString(PaddingString+OffsetString));
		}
		}
		
		return sb.toString();
	}
	
}
