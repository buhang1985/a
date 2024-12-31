package iih.bl.pay.blprepay.ep;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存收预交金数据
 * @author li_pengying
 *
 */
public class BlPrepayPatDOEp {
	
	
	/**
	 * 保存收预交金数据
	 * @param blPayPatItemDTO  从前台界面传入的相关信息，包括患者banner信息、操作员信息。票据号、账户金额及余额、录入的收\退金额 支付方式等
	 * @param blPayPatDO  新插入的一条预交金数据
	 * @param payType     支付类型：取门诊预交金或者住院预交金
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO[] insertBlPayPatInfo(BlPayPatItemDTO blPayPatItemDTO,BlPrePayPatDO blPayPatDO, String payType)
			throws BizException{
        // 1、组装数据   2. 保存数据
		
		//1.组装数据
		BlPrePayPatDO  saveDO  = this.assembleData(blPayPatItemDTO, blPayPatDO, payType) ;
		//2.保存数据
		IBlpaypatCudService cudService = ServiceFinder.find(IBlpaypatCudService.class);
		BlPrePayPatDO[] blPrePayPatDO = cudService.save(new BlPrePayPatDO[]{saveDO});
		if(blPrePayPatDO == null || blPrePayPatDO.length == 0){
			throw new BizException("保存新增预交金数据失败！");
		}
		
		return blPrePayPatDO;
	}
	
	private BlPrePayPatDO  assembleData(BlPayPatItemDTO blPayPatItemDTO,BlPrePayPatDO blPayPatDO, String payType)
    {
		blPayPatDO.setCode_rep(blPayPatItemDTO.getCode_rep());//票据编号
		blPayPatDO.setAmt(blPayPatItemDTO.getAmt());//录入金额
		String id_paymod = blPayPatItemDTO.getId_paymod();
		blPayPatDO.setId_pm(id_paymod);//收款方式
		switch(id_paymod){
			case IBdPripmCodeConst.ID_PRI_PM_CASH:
				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
				break;
			case IBdPripmCodeConst.ID_PRI_PM_CREDIT:
				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
				blPayPatDO.setBankno(blPayPatItemDTO.getBankno());
				blPayPatDO.setPaymodenode(blPayPatItemDTO.getPaymodeno());
				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CREDIT);
				break;
			case IBdPripmCodeConst.ID_PRI_PM_CHECK:
				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
				blPayPatDO.setBankno(blPayPatItemDTO.getBankno());
				blPayPatDO.setPaymodenode(blPayPatItemDTO.getPaymodeno());
				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CHECK);
				break;
			case IBdPripmCodeConst.ID_PRI_PM_DEAFT:
				blPayPatDO.setId_bank(blPayPatItemDTO.getId_bank());
				blPayPatDO.setBankno(blPayPatItemDTO.getBankno());
				blPayPatDO.setPaymodenode(blPayPatItemDTO.getPaymodeno());
				blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_DEAFT);
				break;
			default:
				break;
		}
		blPayPatDO.setDt_pay(new FDateTime());
		//blPayPatDO.setFg_st(FBoolean.FALSE);//结算标志
		blPayPatDO.setCode_incca(this.getRepCodeByCCTP(payType));//票据类型编码
		blPayPatDO.setId_incca(this.getRepIdByCCTP(payType));//票据类型ID
		blPayPatDO.setEu_direct(BookRtnDirectEnum.CHARGE);//收退款方向
		blPayPatDO.setFg_canc(FBoolean.FALSE);
		blPayPatDO.setId_enttp(payType);//结账类型id
		if (IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(payType)) {
			blPayPatDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		} else if (IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(payType)) {
			blPayPatDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		} else if (IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS.equals(payType)) {
			blPayPatDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS);
		}
		blPayPatDO.setStatus(DOStatus.NEW);//数据状态为新增
		return    blPayPatDO;
	}
	
	/*
	 * 通过业务类型取得票据分类编号
	 * */
	public String getRepCodeByCCTP(String SD_CCTP_ID){
		if (IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(SD_CCTP_ID)) {
			return IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT;
		} else if (IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(SD_CCTP_ID)) {
			return IBdInccaCodeConst.CODE_INHOS_DEPOSIT;
		} else if (IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS.equals(SD_CCTP_ID)) {
			return IBdInccaCodeConst.CODE_ET_INVOICE;
		}
		return null;
	}

	/*
	 * 通过业务类型取得票据分类ID
	 * */
	public  String getRepIdByCCTP(String SD_CCTP_ID){
		if (IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(SD_CCTP_ID)) {
			return IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT;
		} else if (IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(SD_CCTP_ID)) {
			return IBdInccaCodeConst.ID_INHOS_DEPOSIT;
		} else if (IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS.equals(SD_CCTP_ID)) {
			return IBdInccaCodeConst.ID_ET_INVOICE;
		}
		return null;
	}

	
	
}
