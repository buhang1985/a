package iih.en.pv.s.bp.op;

import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceDetailsDTO;
import iih.bl.st.blstoep.d.EnReFundTpEnum;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.OpRegEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnCollectionUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.FDoubleUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.bp.op.st.RefundBP;
import iih.en.pv.s.bp.op.st.SettleNewBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 修改挂号的医保
 * @author yank
 *
 */
public class ChangeOpRegHpBP {
	/**
	 * 修改挂号的医保
	 * @param regInfo 挂号信息
	 * @param payInfo 支付信息
	 * @param sd_pttp 收付款终端类型编码
	 * @throws BizException
	 */
	public RegInfoDTO exec(RegInfoDTO regInfo,PayInfoDTO payInfo) throws BizException{
		EnValidator.validateParam("regInfo", regInfo);
		EnValidator.validateParam("payInfo", payInfo);		
		
		Context.get().setAttribute("ReFundTp", EnReFundTpEnum.ENREFUND_CHANGE);//门诊换号
		
		//1、先退费		
		RefundBP refundBP = new RefundBP();
		FBoolean isRealPay = new FBoolean(this.isRealPay(payInfo));
		refundBP.exec(regInfo.getId_ent(), regInfo.getId_cg(),FBoolean.FALSE, regInfo.getSd_pttp(), isRealPay);
		
		//2、更新就诊信息	
		PvEP pvEP = new PvEP();
		PatiVisitDO pvDO = pvEP.getPvById(regInfo.getId_ent());
		pvDO.setId_patca(regInfo.getId_patca());
		pvDO.setId_pripat(regInfo.getId_pripat());
		pvDO.setId_patcret(regInfo.getId_patcredtp());
		pvDO.setId_hp(regInfo.getId_hp());
		pvDO.setStatus(DOStatus.UPDATED);
		pvEP.savePv(pvDO);
		
		//3、保存hp
		EntHpEP entHpBP = new EntHpEP();
		entHpBP.deleteByEntId(pvDO.getId_ent());//删除原来的医保
		entHpBP.saveEntHp(regInfo);
		
		//4、再重新结算			
		SettleNewBP settleBP = new SettleNewBP();
		BlIncItmVsTypeDTO[] incDTOs = settleBP.settle(regInfo.getId_pat(),regInfo,payInfo,EnContextUtils.getPsnId());
		BlInvoiceDetailsDTO invoiceDTO = (BlInvoiceDetailsDTO)incDTOs[0].getBlInvoiceDetailsDTO().get(0);
		String cgId = invoiceDTO.getId_cgoep();		
		
		//5、更新记账主键，保存OP
		OpEP opEP = new OpEP();
		opEP.updateToSettled(regInfo.getId_ent(), cgId, FBoolean.TRUE);
		
		//6.更新EN_ENT_OP_REG表
		new OpRegEP().saveOpReg(regInfo);
		
		//7、换号成功后返回id_cg，发票信息。--WJY
		regInfo.setId_cg(cgId);
		FArrayList invoiceInfo = null;
		if(!EnValidator.isEmpty(incDTOs)){
			invoiceInfo = EnCollectionUtils.toFArrayList(incDTOs);				
		}
		regInfo.setInvoiceinfo(invoiceInfo);
		return regInfo;
	}
	/**
	 * 是否实交易
	 * 
	 * 如果之前支付方式不为空，且与当前支付方式相同 或者只是找零(实际支付金额为0)，则认为是虚交易，新支付方式中需要加入
	 * 
	 * @param payInfoDTO
	 * @return
	 * @throws BizException
	 */
	private boolean isRealPay(PayInfoDTO payInfoDTO) throws BizException {
		if (!EnValidator.isEmpty(payInfoDTO.getPaystyle_originstyle())) {
			if ((payInfoDTO.getPaystyle_originstyle().equals(payInfoDTO.getPaystyle()) 
					&& !FDoubleUtils.isMoreThanZero(payInfoDTO.getAmt_orig_refund()))
					|| FDoubleUtils.isNullOrZero(payInfoDTO.getRelpay())) {
				return false;
			}
		}
		return true;
	}
}
