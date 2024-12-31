package iih.bl.pay.blpaypat.bp.ip;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blprepay.ep.UpdateAccInfoEp;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.pi.acc.account.i.IPatAccServiceExt;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院预交金退费
 * @author li_pengying
 * @since  2017-06-22
 */

public class RefundPrepayIpBp {
	
	/**
	 *  住院预交金退款
	 * @param blPrePayPatDO 原来的要退的那条预交金数据
	 * @param blPayPatItemDTO  从前台界面带过来的信息
	 * @return
	 * @throws BizException
	 */
	public FBoolean execRefundIpInfo(BlPrePayPatDO blPrePayPatDO,BlPayPatItemDTO blPayPatItemDTO) 
			throws BizException{
		//主要业余有  1.插入一条退款预交金数据,为其各个字段赋值，并找到其对应的收款数据 回写已退标志 及其他字段 ，保存要退的那条元数据和新增的退款数据   ，  2.修改就诊账户余额
		
		//  1.插入一条退款预交金数据,为其各个字段赋值， 保存要退的那条元数据和新增的退款数据  
		// 1.1组装一条新的退款预交金数据
		BlPrePayPatDO blPrePayInfo = this.assembleNewIpRefundData(blPrePayPatDO, blPayPatItemDTO);
		
		//1.2并找到其对应的原来那条元数据   回写已退标志 、取消人、取消时间字段
		blPrePayPatDO.setFg_canc(FBoolean.TRUE);
		blPrePayPatDO.setDt_canc(AppUtils.getServerDateTime());
		blPrePayPatDO.setId_emp_canc(Context.get().getStuffId());
		blPrePayPatDO.setNote("已退费");
		blPrePayPatDO.setStatus(DOStatus.UPDATED);
		
		//1.3 分别保存两条数据
		IBlpaypatCudService cudService = ServiceFinder.find(IBlpaypatCudService.class);
		BlPrePayPatDO[]  blPrePayPatDOArr =cudService.save(new BlPrePayPatDO[]{blPrePayInfo,blPrePayPatDO});
		if(blPrePayPatDOArr == null || blPrePayPatDOArr.length == 0){
			throw new BizException("保存新增预交金数据失败！");
		}
		
		//2.修改就诊账户余额     ：账户信息修改
		UpdateAccInfoEp newep=new UpdateAccInfoEp();
		newep.updatePiPatAccInfo((blPayPatItemDTO.getAmt().multiply(BookRtnDirectEnum.RETURNS).doubleValue()), blPrePayPatDO, IBdFcDictCodeConst.ID_CODE_ENTP_IP);
		
		return FBoolean.TRUE;
	}
	
	/**
	 * 插入一条退款预交金数据，组装数据
	 * @param blPrePayPatDO ：要退的那条元数据
	 * @param blPayPatItemDTO  从前台带过来的信息
	 * @return
	 * @throws BizException
	 */
	private BlPrePayPatDO  assembleNewIpRefundData(BlPrePayPatDO blPrePayPatDO,BlPayPatItemDTO blPayPatItemDTO) throws BizException{
		//1.插入一条退款预交金数据，组装数据
				BlPrePayPatDO blPrePayInfo = new BlPrePayPatDO();
				blPrePayInfo.setId_grp(Context.get().getGroupId());
				blPrePayInfo.setId_org(Context.get().getOrgId());
				blPrePayInfo.setId_emp_pay(Context.get().getStuffId());
				blPrePayInfo.setId_dep_pay(Context.get().getDeptId());
				blPrePayInfo.setId_org_pay(Context.get().getOrgId());
				blPrePayInfo.setDt_pay(AppUtils.getServerDateTime());
				blPrePayInfo.setAmt(blPayPatItemDTO.getAmt());
				blPrePayInfo.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAY);
				blPrePayInfo.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
				blPrePayInfo.setId_par(blPrePayPatDO.getId_paypat());
				blPrePayInfo.setEu_direct(BookRtnDirectEnum.RETURNS);
				blPrePayInfo.setId_pat(blPrePayPatDO.getId_pat());
				blPrePayInfo.setSd_pm(blPayPatItemDTO.getPaymod_code());
				blPrePayInfo.setId_pm(blPayPatItemDTO.getId_paymod());
				switch(blPayPatItemDTO.getId_paymod()){
					case IBdPripmCodeConst.ID_PRI_PM_CREDIT:
						blPrePayInfo.setId_bank(blPayPatItemDTO.getId_bank());
						blPrePayInfo.setBankno(blPayPatItemDTO.getBankno());
						blPrePayInfo.setPaymodenode(blPayPatItemDTO.getPaymodeno());
						break;
					case IBdPripmCodeConst.ID_PRI_PM_CHECK:
						blPrePayInfo.setId_bank(blPayPatItemDTO.getId_bank());
						blPrePayInfo.setBankno(blPayPatItemDTO.getBankno());
						blPrePayInfo.setPaymodenode(blPayPatItemDTO.getPaymodeno());
						break;
					case IBdPripmCodeConst.ID_PRI_PM_DEAFT:
						blPrePayInfo.setId_bank(blPayPatItemDTO.getId_bank());
						blPrePayInfo.setBankno(blPayPatItemDTO.getBankno());
						blPrePayInfo.setPaymodenode(blPayPatItemDTO.getPaymodeno());
						break;
					default:
						break;
				}
				blPrePayInfo.setId_ent(blPrePayPatDO.getId_ent());
				blPrePayInfo.setId_enttp(blPrePayPatDO.getId_enttp());//就诊类型id
				blPrePayInfo.setCode_enttp(blPrePayPatDO.getCode_enttp());
				blPrePayInfo.setFg_canc(FBoolean.FALSE);
				blPrePayInfo.setFg_cc(FBoolean.FALSE);
				blPrePayInfo.setId_incca(null);
				blPrePayInfo.setCode_rep(blPrePayPatDO.getCode_rep());
				blPrePayInfo.setId_par(blPrePayPatDO.getId_paypat());
				blPrePayInfo.setFg_rep_return(FBoolean.TRUE);
				blPrePayInfo.setDt_return(AppUtils.getServerDateTime());
				blPrePayInfo.setId_emp_return(Context.get().getStuffId());
				blPrePayInfo.setNote("作废：" + blPrePayPatDO.getCode_rep());
				blPrePayInfo.setSd_pttp(blPrePayPatDO.getSd_pttp());
				blPrePayInfo.setStatus(DOStatus.NEW);//数据状态为新增
				
				return   blPrePayInfo ;
	}
	
}
