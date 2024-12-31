package iih.bl.pay.blpaypat.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blprepay.ep.BlPreayPMamtOepDOEp;
import iih.bl.pay.blprepay.ep.UpdateAccInfoEp;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptCudService;
import iih.bl.pay.s.ep.PrepayPatRcptEP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class OpAbolishBp {
	/*
	 * 门诊作废预交金数据，目前只供门诊的使用，
	 * */
	public void execAbolishInfo(BlPrePayPatDO blPayPatDO, BlPrePayPatDO abolishDO,String payType) 
			throws BizException{
		//主要业务：  1.修改所作废的预交金数据 、添加一条作废数据     2.修改患者预交金收退款总额      3.修改患者账户余额，将患者账户金额中减去所作废数据的收款金额
		
		// 1.修改所作废的预交金数据 blPayPatDO   、新增一条作废数据  abolishDO，分别保存 ，两条数据的金额一致 方向相反
		this.updateBlPayPatInfo(blPayPatDO, abolishDO, payType);
		
		//作废票据
		this.abolishRcpt(blPayPatDO);
		
		//2.修改患者预交金收退款总额
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType)){
			BlPreayPMamtOepDOEp  ep  = new  BlPreayPMamtOepDOEp();
			ep.updateBlPayMamtOepInfo(blPayPatDO.getId_pat(), BookRtnDirectEnum.RETURNS, blPayPatDO.getAmt(), blPayPatDO.getId_pm(), blPayPatDO.getSd_pm());//原来的写错了，应该是传入退费方向即-1
		}
		//3. 修改账户余额，将患者账户金额中减去所作废数据的收款金额
		UpdateAccInfoEp newep=new UpdateAccInfoEp();
		newep.updatePiPatAccInfo(-(blPayPatDO.getAmt().doubleValue()), blPayPatDO, payType);
	}
	
	/**
	 * 作废票据
	 * @param blPayPatDO
	 * @throws BizException 
	 */
	private void abolishRcpt(BlPrePayPatDO blPayPatDO) throws BizException{

		if(blPayPatDO==null){
			return ;
		}
		
		//查询原票据信息
		PrepayPatRcptEP rcptEp=new PrepayPatRcptEP();
		BlPrepayPatRcptDO oldRcptDo = rcptEp.findLastRcptByPrepayId(blPayPatDO.getId_paypat());
		if(oldRcptDo==null){
			throw new BizException("未找到该预交金对应的票据信息");
		}
		
		//作废原票据
		oldRcptDo.setStatus(DOStatus.UPDATED);
		oldRcptDo.setFg_rep_return(FBoolean.TRUE);
		oldRcptDo.setDt_return(new FDateTime());
		oldRcptDo.setId_emp_return(Context.get().getStuffId());
		oldRcptDo.setNote("作废");
		
		IPrepaypatrcptCudService rcptCudService=ServiceFinder.find(IPrepaypatrcptCudService.class);
		rcptCudService.save(new BlPrepayPatRcptDO[]{oldRcptDo});
		
	}
	
	/*
	 * 修改所选中的预交金元数据，添加一条作废数据，回写作废标志，并保存这两条数据
	 * */
	private void updateBlPayPatInfo(BlPrePayPatDO blPayPatDO, BlPrePayPatDO abolishDO,String payType) 
			throws BizException{
		IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
		
		//添加作废数据，修改元数据
		blPayPatDO.setNote("作废");
		blPayPatDO.setFg_canc(FBoolean.TRUE);  //已经取消
		blPayPatDO.setDt_canc(new FDateTime());
		blPayPatDO.setStatus(DOStatus.UPDATED);
		
		abolishDO.setAmt(blPayPatDO.getAmt());
		abolishDO.setId_par(blPayPatDO.getId_paypat());
		abolishDO.setId_ent(blPayPatDO.getId_ent());
		abolishDO.setNote("作废"+blPayPatDO.getCode_rep());
		abolishDO.setFg_rep_return(FBoolean.TRUE);
		abolishDO.setDt_pay(new FDateTime());
		abolishDO.setEu_direct(BookRtnDirectEnum.RETURNS);//方向为退
		abolishDO.setId_pat(blPayPatDO.getId_pat());
		abolishDO.setId_enttp(blPayPatDO.getId_enttp());
		abolishDO.setCode_enttp(blPayPatDO.getCode_enttp());
		abolishDO.setSd_pm(blPayPatDO.getSd_pm());
		abolishDO.setId_pm(blPayPatDO.getId_pm());
		abolishDO.setId_bank(blPayPatDO.getId_bank());
		abolishDO.setBankno(blPayPatDO.getBankno());
		abolishDO.setPaymodenode(blPayPatDO.getPaymodenode());
		abolishDO.setId_enttp(payType);
//		abolishDO.setId_paytp(blPayPatDO.getId_paytp());
//		abolishDO.setSd_paytp(blPayPatDO.getSd_paytp());
		abolishDO.setSd_pttp(blPayPatDO.getSd_pttp());
		abolishDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAY);
		abolishDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
		abolishDO.setStatus(DOStatus.NEW);
		payService.save(new BlPrePayPatDO[]{blPayPatDO,abolishDO});	
	} 

}
