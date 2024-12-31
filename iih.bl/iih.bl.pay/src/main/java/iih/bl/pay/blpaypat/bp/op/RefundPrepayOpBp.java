package iih.bl.pay.blpaypat.bp.op;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blprepay.ep.BlPreayPMamtOepDOEp;
import iih.bl.pay.blprepay.ep.UpdateAccInfoEp;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊预交金退款
 * @author li_pengying
 *
 */
public class RefundPrepayOpBp {
	
	/**
	 * 门诊预交金退款,门诊类型
	 * @param blPayPatItemDTO ，从前台界面带过来的显示数据用dto
	 * @param id_pat          患者主键id_pat
	 * @param sd_pttp          收付款终端类型，从前台界面传入
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO execRefundOpInfo(BlPayPatItemDTO blPayPatItemDTO,String id_pat,String sd_pttp) 
			throws BizException{
		//主要业务：  1.新增一条退款预交金数据：由方向、备注来体现    ，并保存       2.修改患者预交金收退款总额表    3.修改患者账户pipatacc的余额
		
		//1.新增一条退款预交金数据,并为各个字段赋值：由方向、备注来体现    ，并保存     
		BlPrePayPatDO   blPayPatDO =this.assemleNewOpRefundData(blPayPatItemDTO, id_pat, sd_pttp);
		IBlpaypatCudService cudService = ServiceFinder.find(IBlpaypatCudService.class);
		BlPrePayPatDO[] blPrePayPatDO = cudService.save(new BlPrePayPatDO[]{blPayPatDO});
		if(blPrePayPatDO == null || blPrePayPatDO.length == 0){
			throw new BizException("保存预交金数据失败！");
		}
		/*IBLInvoiceService incService = (IBLInvoiceService)ServiceFinder.find(IBLInvoiceService.class);
		incService.NextInvoiceNoUpdateCurNo(blPayPatDO.getId_emp_pay(), IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT);*/
		
		IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
		incService.nextInvoiceNo(blPayPatDO.getId_emp_pay(), Context.get().getClientHost(), IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT);
		
		// 2.修改患者预交金收退款总额表        ：修改患者预交金收退款总额
		BlPreayPMamtOepDOEp  ep  = new  BlPreayPMamtOepDOEp();
		ep.updateBlPayMamtOepInfo(blPayPatDO.getId_pat(), BookRtnDirectEnum.RETURNS, blPayPatDO.getAmt(), blPayPatDO.getId_pm(), blPayPatDO.getSd_pm()); //退的时候    方向传退即-1
		
		
		//3.修改患者账户pipatacc的余额     账户信息修改
		UpdateAccInfoEp newep=new UpdateAccInfoEp();
		newep.updatePiPatAccInfo((blPayPatItemDTO.getAmt().multiply(BookRtnDirectEnum.RETURNS).doubleValue()), blPayPatDO, IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		return blPrePayPatDO[0];
	}
	
	/**
	 * 新增一条退款预交金数据,并为各个字段赋值：由方向、备注来体现    ，并保存     
	 * @param blPayPatItemDTO
	 * @param id_pat
	 * @param sd_pttp
	 * @return
	 * @throws BizException
	 */
	private BlPrePayPatDO  assemleNewOpRefundData(BlPayPatItemDTO blPayPatItemDTO,String id_pat,String sd_pttp) throws BizException{
		BlPrePayPatDO   blPayPatDO=new BlPrePayPatDO();
		blPayPatDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAY);
		blPayPatDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAY);
		blPayPatDO.setSd_pm(blPayPatItemDTO.getPaymod_code());
		blPayPatDO.setId_pm(blPayPatItemDTO.getId_paymod());
		switch(blPayPatItemDTO.getId_paymod()){
			case IBdPripmCodeConst.ID_PRI_PM_CREDIT:
				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
				blPayPatDO.setBankno(blPayPatItemDTO.getBankno());
				blPayPatDO.setPaymodenode(blPayPatItemDTO.getPaymodeno());
				break;
			case IBdPripmCodeConst.ID_PRI_PM_CHECK:
				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
				blPayPatDO.setBankno(blPayPatItemDTO.getBankno());
				blPayPatDO.setPaymodenode(blPayPatItemDTO.getPaymodeno());
				break;
			case IBdPripmCodeConst.ID_PRI_PM_DEAFT:
				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
				blPayPatDO.setBankno(blPayPatItemDTO.getBankno());
				blPayPatDO.setPaymodenode(blPayPatItemDTO.getPaymodeno());
				break;
			default:
				break;
		}
		blPayPatDO.setId_pat(id_pat);
		blPayPatDO.setId_org(Context.get().getOrgId());
		blPayPatDO.setId_grp(Context.get().getGroupId());
		blPayPatDO.setId_org_pay(Context.get().getStuffId());
		blPayPatDO.setId_dep_pay(Context.get().getDeptId());
		blPayPatDO.setId_emp_pay(Context.get().getStuffId());
		blPayPatDO.setAmt(blPayPatItemDTO.getAmt());//退款金额
    	blPayPatDO.setFg_canc(FBoolean.FALSE);
		blPayPatDO.setFg_cc(FBoolean.FALSE);
		blPayPatDO.setId_incca(null);
		blPayPatDO.setCode_rep(blPayPatItemDTO.getCode_rep());//退款时也保存上收据号
		blPayPatDO.setId_par(null);
		blPayPatDO.setEu_direct(BookRtnDirectEnum.RETURNS);//收退款方向为退
		blPayPatDO.setNote("门诊预交金退款");
		FDateTime dateTime = AppUtils.getServerDateTime();   //获取当前服务器时间
		blPayPatDO.setDt_pay(dateTime);
		blPayPatDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);//就诊类型id
		blPayPatDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		blPayPatDO.setSd_pttp(sd_pttp);
		blPayPatDO.setStatus(DOStatus.NEW);//数据状态为新增
		
		return   blPayPatDO ;
	}
}
