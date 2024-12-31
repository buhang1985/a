package iih.ci.ord.s.ems.meta;

import java.util.ArrayList;
import java.util.Arrays;

import iih.ci.ord.pub.CiOrdUtils;

/**
 * 默认创建参数集合
 * @author wangqingzhu
 *
 */
public class DefaultCreateParamList extends ArrayList<DefaultCreateParam>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2937471651976072826L;
	
	public DefaultCreateParamList(){}
	
	public DefaultCreateParamList(DefaultCreateParam[] szInfo){
		this.addAll(Arrays.asList(szInfo));
	}

	public DefaultCreateParam[] asArray(){
		return this.toArray(new DefaultCreateParam[size()]);
	}
	
	public String[] asIdSrvArray(){
		StringList listId_srv = new StringList();
		for (DefaultCreateParam p : this){
			String[] szIdSrv = p.asIdSrvArray();
			if(!CiOrdUtils.isEmpty(szIdSrv)){
				listId_srv.add(szIdSrv);
			}
		}
		return listId_srv.asArray();
	}
}
