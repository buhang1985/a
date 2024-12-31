package iih.bl.cg.bp.self;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import iih.bl.cg.api.d.PayRecord;
import iih.bl.cg.bp.self.qry.GetEntPayRecordInfoQry;
/**
 * 获取门诊收费记录处方列表接口
 * @author LIM
 *
 */
public class GetEntPayRecordBp {
	public PayRecord[] exec(String patCode,String code_st)throws BizException{
		if(StringUtil.isEmpty(patCode))
		{
			throw new BizException("患者编码不能为空！");
		}
		if(StringUtil.isEmpty(code_st))
		{
			throw new BizException("结算流水号不能为空！");
		}
		GetEntPayRecordInfoQry qry=new GetEntPayRecordInfoQry(patCode,code_st);
		List<PayRecord> payRecordList = (List<PayRecord>) new DAFacade().execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(PayRecord.class));
		return payRecordList.toArray(new PayRecord[0]);
	}

}
