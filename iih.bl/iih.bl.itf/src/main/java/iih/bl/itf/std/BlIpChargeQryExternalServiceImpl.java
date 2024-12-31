package iih.bl.itf.std;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.itf.std.bp.ipcharge.GetPatDayListBP;
import iih.bl.itf.std.bp.ipcharge.GetPrepaymentBalanceBP;
import iih.bl.itf.std.bp.ipcharge.GetPrepaymentRecordBP;
import iih.bl.itf.std.bp.ipcharge.GetTotalCostInfoBP;
import iih.bl.itf.std.d.ipchargeqry.BlPatDayListDTO;
import iih.bl.itf.std.d.ipchargeqry.BlPrepaymentBalanceDTO;
import iih.bl.itf.std.d.ipchargeqry.BlPrepaymentRecordDTO;
import iih.bl.itf.std.d.ipchargeqry.BlTotalCostInfoDTO;

public class BlIpChargeQryExternalServiceImpl implements
		IBlIpChargeQryExternalService {
	
	@Override
	public BlTotalCostInfoDTO[] getTotalCostInfo(String patCode, Integer times)
			throws BizException {
		// TODO Auto-generated method stub
		BLThirdItfLogger.info("调用住院费用信息查询接口开始：患者编码["+ patCode +"|"+ times +"]");
		GetTotalCostInfoBP newData=new GetTotalCostInfoBP();
		return newData.exec(patCode,times);
	}
	
	@Override
	public BlPrepaymentRecordDTO[] getPrepaymentRecord(String patCode, Integer times)
			throws BizException {
		// TODO Auto-generated method stub
		BLThirdItfLogger.info("调用住院患者预交金信息查询接口开始：患者编码["+ patCode +"|"+ times +"]");
		GetPrepaymentRecordBP newData=new GetPrepaymentRecordBP();
		return newData.exec(patCode,times);
	}

	@Override
	public BlPrepaymentBalanceDTO[] getPrepaymentBalace(String patCode, Integer times) throws BizException {
		// TODO Auto-generated method stub
		BLThirdItfLogger.info("调用住院患者预交金余额查询接口开始：患者编码["+ patCode +"|"+ times +"]");
		GetPrepaymentBalanceBP newData=new GetPrepaymentBalanceBP();
		return newData.exec(patCode,times);
	}
	
	@Override
	public BlPatDayListDTO[] getPatDayList(String patCode, Integer times, String startDate, String endDate) throws BizException {
		// TODO Auto-generated method stub
		BLThirdItfLogger.info("调用住院患者日清单查询接口开始：患者编码["+ patCode +"|"+ times+ "|"+ startDate +"|"+ endDate +"]");
		GetPatDayListBP newData = new GetPatDayListBP();
		return newData.exec(patCode,times,startDate, endDate);
	}

}



