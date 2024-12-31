package iih.bl.cg.bp.self;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import iih.bl.cg.api.d.PayRecord;
import iih.bl.cg.bp.self.qry.GetPayRecordInfoQry;
/**
 * 获取门诊交费交易信息
 * @author LIM
 *
 */
public class GetPayRecordInfoBp {

	public PayRecord[] exec(String patCode, String beginTime, String endTime) throws BizException{
		if(StringUtil.isEmpty(patCode))
		{
			throw new BizException("患者编码不能为空！");
		}
		if(StringUtil.isEmpty(beginTime))
		{
			throw new BizException("开始时间不能为空！");
		}	
		if(StringUtil.isEmpty(endTime))
		{
			throw new BizException("结束时间不能为空！");
		}
		GetPayRecordInfoQry qry = new GetPayRecordInfoQry(patCode,beginTime,endTime);
		List<PayRecord> payRecordList= (List<PayRecord>) new DAFacade().execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(PayRecord.class)); 
		return payRecordList.toArray(new PayRecord[0]) ;
		
	}
}
