package iih.bl.cg.api.s.bp;

import java.util.List;

import iih.bl.cg.api.d.GetUnpaidParam;
import iih.bl.cg.api.d.UnpaidInfo;
import iih.bl.cg.api.s.bp.qry.GetNotChargeInfosQry;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 用于获取指定患者所有未缴费的医嘱列表（含患者信息）
 * @author wangqingzhu
 *
 */
public class ProcPhoneMzcfNotCharge {

	/**
	 * 用于获取指定患者所有未缴费的医嘱列表（含患者信息）
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public UnpaidInfo[] exec(GetUnpaidParam param) throws BizException{
		DAFacade da = new DAFacade();
		GetNotChargeInfosQry qry=new GetNotChargeInfosQry(param.getPatient_id(),param.getSdate(),param.getEdate());
		List<UnpaidInfo> unpaidInfoList = (List<UnpaidInfo>) da.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(UnpaidInfo.class));
		return unpaidInfoList.toArray(new UnpaidInfo[unpaidInfoList.size()]);
	}
}
