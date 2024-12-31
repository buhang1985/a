package iih.bl.cg.bp.self;

import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.api.d.ApplyInfo;
import xap.mw.core.data.BizException;

public class GetPatPrescriptionInfoBp {
	/**
	 * 获取检查检验处方信息
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	public ApplyInfo[] exec(String patCode, String patType, String beginTime, String endTime) throws BizException{	
		if(patCode==null)
		{
			throw new BizException("患者编码不能为空！");
		}
		if(patType==null)
		{
			throw new BizException("患者类型不能为空！");
		}
		if(beginTime==null)
		{
			throw new BizException("开始日期不能为空！");
		}
		if(endTime==null)
		{
			throw new BizException("结束日期不能为空！");
		}		
		GetBlOrderBp blOrder= new GetBlOrderBp();
		return blOrder.getApplyForBlOrder(patCode, patType, beginTime, endTime);
	}

}
