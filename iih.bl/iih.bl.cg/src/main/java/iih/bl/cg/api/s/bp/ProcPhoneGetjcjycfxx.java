package iih.bl.cg.api.s.bp;


import java.util.List;

import iih.bl.cg.api.d.InsPresInfo;
import iih.bl.cg.api.s.bp.qry.GetRisLisInfosQry;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取检查检验处方信息
 * @author wangqingzhu
 *
 */
public class ProcPhoneGetjcjycfxx {

	/**
	 * 获取检查检验处方信息
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	public InsPresInfo[] exec(String patId,Integer opTimes,String[] applyNos) throws BizException{			
		GetRisLisInfosQry qry=new GetRisLisInfosQry(patId,opTimes,applyNos);
		List<InsPresInfo> insPresInfoList = (List<InsPresInfo>) new DAFacade().execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(InsPresInfo.class));
		return insPresInfoList.toArray(new InsPresInfo[0]);
	}
}
