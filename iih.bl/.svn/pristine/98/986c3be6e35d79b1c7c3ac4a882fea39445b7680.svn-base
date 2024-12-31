package iih.bl.pay.blprepay.ep;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.bp.op.PrepayPatOpBp;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.en.pv.i.IEnOutCmdService;
import iih.pi.acc.account.i.IPatAccServiceExt;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class UpdateAccInfoEp {
	/*
	 * 修改用户账户余额
	 * */
	public void updatePiPatAccInfo(double amt,BlPrePayPatDO blPayPatDO, String payType) 
			throws BizException{
		
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType))
		{
			//pi_pat_acc.prepay add amt
			IPatAccServiceExt accDService = ServiceFinder.find(IPatAccServiceExt.class);
			accDService.updatePatPrepay(blPayPatDO.getId_pat(), new FDouble(amt));
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)){
			IEnOutCmdService accDService = ServiceFinder.find(IEnOutCmdService.class);
			accDService.recharge(blPayPatDO.getId_ent(), new FDouble(amt));
		}
		else if(IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS.equals(payType))
		{
			if(BlParams.BLST0002().equals(BlParamValueConst.BLST0002_OP))
			{
				IPatAccServiceExt accDService = ServiceFinder.find(IPatAccServiceExt.class);
				accDService.updatePatETPrePay(blPayPatDO.getId_pat(), new FDouble(amt));
			}
			else if(BlParams.BLST0002().equals(BlParamValueConst.BLST0002_IP))
			{
				IEnOutCmdService accDService = ServiceFinder.find(IEnOutCmdService.class);
				accDService.recharge(blPayPatDO.getId_ent(), new FDouble(amt));
			}
		}
	}
	
	public void updatePiPatAccInfoForSettlement(double amt,BlPrePayPatDO blPayPatDO, String payType) 
			throws BizException{
		
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType))
		{
			//pi_pat_acc.prepay add amt
			IPatAccServiceExt accDService = ServiceFinder.find(IPatAccServiceExt.class);
			accDService.updatePatPrepay(blPayPatDO.getId_pat(), new FDouble(amt));
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)){
			IEnOutCmdService accDService = ServiceFinder.find(IEnOutCmdService.class);
			accDService.recharge(blPayPatDO.getId_ent(), new FDouble(amt));
		}
		else if(IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS.equals(payType))
		{
			if(BlParams.BLST0002().equals(BlParamValueConst.BLST0002_OP))
			{
				IPatAccServiceExt accDService = ServiceFinder.find(IPatAccServiceExt.class);
				accDService.etPay(blPayPatDO.getId_pat(), new FDouble(amt), FBoolean.FALSE);
			}
			else if(BlParams.BLST0002().equals(BlParamValueConst.BLST0002_IP))
			{
				IEnOutCmdService accDService = ServiceFinder.find(IEnOutCmdService.class);
				accDService.recharge(blPayPatDO.getId_ent(), new FDouble(amt));
			}
		}
	}
}
