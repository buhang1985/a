package iih.bl.cg.bp.self;

import iih.bl.cg.api.d.PrepayTradeRecord;
import iih.bl.cg.bp.self.qry.GetPrePayInfoOepInfoQry;
import java.util.List;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 获取门诊病人预交金交易明细接口
 * @author LIM
 *
 */
public class GetPrePayInfoOepInfoBp {
	
	public PrepayTradeRecord[] exec(String cardNo, String patCode, String beginDate,
			String endDate) throws BizException{	
		if(patCode==null)
		{
			throw new BizException("患者编码不能为空！");
		}
		if(cardNo==null)
		{
			throw new BizException("患者就诊卡号不能为空！");
		}
		if(beginDate==null)
		{
			throw new BizException("开始日期不能为空！");
		}
		if(endDate==null)
		{
			throw new BizException("结束日期不能为空！");
		}		
		GetPrePayInfoOepInfoQry qry=new GetPrePayInfoOepInfoQry(cardNo,patCode,beginDate,endDate );
		List<PrepayTradeRecord> patPrescriptionList = (List<PrepayTradeRecord>) new DAFacade().execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(PrepayTradeRecord.class));
		return patPrescriptionList.toArray(new PrepayTradeRecord[0]);
	}
}
