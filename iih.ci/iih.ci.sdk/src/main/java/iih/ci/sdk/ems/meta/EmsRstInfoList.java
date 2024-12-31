package iih.ci.sdk.ems.meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import iih.ci.ord.i.meta.EmsRstDTO;


/**
 * 医疗单返回结果列表对象
 * @author wangqingzhu
 *
 */
public class EmsRstInfoList extends ArrayList<EmsRstDTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmsRstInfoList(){}
	
	public EmsRstInfoList(Collection<EmsRstDTO> c){
		this.addAll(c);
	}
	
	public EmsRstInfoList(EmsRstDTO[] szInfo){
		this.addAll(Arrays.asList(szInfo));
	}
	
	/**
	 * 从简单数组集合对象加载信息
	 * @param szInfo
	 * @return
	 */
	public int fromArray(EmsRstDTO[] szInfo){
		this.addAll(Arrays.asList(szInfo));
		return size();
	}
	
	/**
	 * 转化为简单数组集合对象
	 * @return
	 */
	public EmsRstDTO[] asArray(){
		if(size() == 0){
			return null;
		}
		return this.toArray(new EmsRstDTO[this.size()]);
	}
	
	public EmsRstInfoList append(EmsRstDTO[] szInfo){
		this.addAll(Arrays.asList(szInfo));
		return this;
	}

}
