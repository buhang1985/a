package iih.ci.sdk.ems.meta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.FArrayList;

/**
 * 字符串列表工具类
 * @author wangqingzhu
 *
 */
public class StringList extends ArrayList<String> {
	private static final long serialVersionUID = 1L;
	
	public StringList(){}
	public StringList(FArrayList objList){
		if(!ObjectUtils.isEmpty(objList)) {
			for (Object o : objList){
				if (!ObjectUtils.isEmpty(o))
					this.add(o.toString());
			}
		}
		
	}
	
	public StringList(Object[] szObj){
		if(!ObjectUtils.isEmpty(szObj)) {
			for (Object o : szObj){
				if (!ObjectUtils.isEmpty(o))
					this.add(o.toString());
			}
		}
		
	}

	public String[] asArray(){
		return this.toArray(new String[size()]);
	}
	
	public static String AsString(String[] szStrObject, String splc){
		StringBuilder sb = new StringBuilder();
		for (String str : szStrObject){
			sb.append(str).append(splc);
		}
		return sb.toString();
	}
	public static String AsString(Collection<String> szStrObject, String splc){
		StringBuilder sb = new StringBuilder();
		for (String str : szStrObject){
			sb.append(str).append(splc);
		}
		return sb.toString();
	}
//	public static String AsString(ArrayList<String> szStrObject, char splc){
//		StringBuilder sb = new StringBuilder();
//		for (String str : szStrObject){
//			sb.append(str).append(splc);
//		}
//		return sb.toString();
//	}
	
	public String toStringWithNO(int index){
		StringBuilder sb = new StringBuilder();
		for(String str : this){
			sb.append(index++).append(str);
		}
		return sb.length() >0? sb.toString():null;
	}
	
	public StringList add(String[] szStr){
		for (String str : szStr){
			this.add(str);
		}
		return this;
	}
	
	public FArrayList toFArrayList() {
		if(ObjectUtils.isEmpty(this)) {
			return null;
		}
		FArrayList rstList = new FArrayList();
		rstList.addAll(this);
		return rstList;
	}
}
