package iih.bl.pay.blprepay.ep;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 门诊预交金退款类，提供给刘羽用接口
 * @author weijia
 * @author li_pengying
 *
 */
public class SetBlPrePayRefundEp {
	/* *
	 * 预交金退款
	 * */
	public FBoolean setBlPrePayRefund(BlPrePayPatDO blpreppDO) throws BizException{
		//添加红冲数据
		IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
		blpreppDO.setNote("退款");
		TimeService timeService = new TimeServiceImpl();//获取当前服务器时间
		FDateTime dateTime = timeService.getUFDateTime();
		blpreppDO.setDt_pay(dateTime);
		blpreppDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		String id_paymod = blpreppDO.getId_pm();
		switch(id_paymod){
			case IBdPripmCodeConst.ID_PRI_PM_CASH:
				blpreppDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_CREDIT:
				blpreppDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CREDIT);
				break;
			case IBdPripmCodeConst.ID_PRI_PM_CHECK:
				blpreppDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CHECK);
				break;
			case IBdPripmCodeConst.ID_PRI_PM_DEAFT:
				blpreppDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_DEAFT);
				break;
			default:
				blpreppDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
				break;
		}
		blpreppDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAY);
		blpreppDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAY);
		blpreppDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		blpreppDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		blpreppDO.setStatus(DOStatus.NEW);
		payService.save(new BlPrePayPatDO[]{blpreppDO});
		//修改就诊账户信息
		//this.updatePiPatAccInfo(-(blpreppDO.getAmt().doubleValue()), blpreppDO, IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		UpdateAccInfoEp newep=new UpdateAccInfoEp();
		newep.updatePiPatAccInfo(-(blpreppDO.getAmt().doubleValue()), blpreppDO, IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		return FBoolean.TRUE;
	}
}
