package iih.ci.sdk.ems.bizline;

import java.util.ArrayList;
import java.util.List;

import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ArrayListHandler;

/**
 * 获得单字段值集合数组信息操作BP
 */
public class GetSingleFldValuesBP {
	/**
	 * 获得单字段值集合数组信息
	 * @param sqlstr
	 * @return
	 * @throws BizException
	 */
	public String[] exec(String sqlstr) throws BizException{
		DAFacade dao= new DAFacade();
		List list=(ArrayList)dao.execQuery(sqlstr,new ArrayListHandler());
		if(!ObjectUtils.isEmpty(list)){
			
//			return (String[]) list.toArray((String)Array.newInstance(String.class, 0));
		//	Object[] s=(Object[]) list.toArray();
			List<String> listarr=new ArrayList<String>();
			for (Object o : list) {
				listarr.add(((Object[])o)[0]+"");
			}
			
			return listarr.toArray(new String[0]);
		}
		return null;
	}
}
