package iih.bl.hp.s.bp;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 贫困患者判断类
 * @author ly 2018/07/12
 *
 */
public class IsPoorPatBP {

	/**
	 * 是否贫困患者
	 * @param patIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public FMap exec(String[] patIds) throws BizException{
		
		if(ArrayUtil.isEmpty(patIds))
			return null;
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select pat.id_pat ");
		sqlSb.append("from pi_pat pat ");
		sqlSb.append("inner join bl_hp_pat_poor patpoor ");
		sqlSb.append("on pat.id_code = patpoor.id_code ");
		
		List<Object> poorPatList = (List<Object>)new DAFacade().execQuery(sqlSb.toString(), new ColumnListHandler());
		List<String> judgeList = new ArrayList<String>();
		if(!ListUtil.isEmpty(poorPatList)){
			for (Object patId : poorPatList) {
				judgeList.add(patId.toString());
			}
		}
		
		FMap rtnMap = new FMap();
		for (String patId : patIds) {
			FBoolean fgPoor = judgeList.contains(patId) ? FBoolean.TRUE: FBoolean.FALSE;
			rtnMap.put(patId, fgPoor);
		}
		
		return rtnMap;
	}
}
