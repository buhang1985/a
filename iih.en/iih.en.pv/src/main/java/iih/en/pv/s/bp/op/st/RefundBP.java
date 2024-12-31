package iih.en.pv.s.bp.op.st;

import iih.bl.cg.service.d.BL_Register_RefundDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCancelSettlement;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.st.blstoep.d.EnReFundTpEnum;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 退费
 * @author yank
 * @since 2015-12-08
 *
 */
public class RefundBP {
	/**
	 * 退费
	 * 可以重收
	 * @param entId 就诊id
	 * @param cgId 记账主键
	 * @param needRecharge 是否重收,(挂号发票重打时设置为TRUE，否则为FALSE)
	 * @param sd_pttp 收付款终端类型编码
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] exec(String entId,String cgId,FBoolean needRecharge, String sd_pttp, FBoolean fgRealpay) throws BizException{
		BL_Register_RefundDTO refundDTO = new BL_Register_RefundDTO();
		refundDTO.setId_ent(entId);
		refundDTO.setId_cgoep(cgId);
		refundDTO.setAllRefundAndAllCharge(needRecharge);
		refundDTO.setSd_pttp(sd_pttp);
		refundDTO.setPrintRedInc(FBoolean.FALSE);//不打印红冲发票
		
		ConstructOprBP constructBP = new ConstructOprBP();
		OperatorInfoDTO oprDTO = constructBP.exec();
		//如果组织参数SC0320 取消预约退款记录使用退款人不为空则取参数所选退款操作人
		String id_emp = EnParamUtils.getScCancAptRefundOperator();
		if(!EnValidator.isEmpty(id_emp)){
			oprDTO.setId_emp(id_emp);
		}
		if(Context.get().getAttribute("ReFundTp") != null)
			oprDTO.setEu_enrefundtp((String)(Context.get().getAttribute("ReFundTp")));
		else
			oprDTO.setEu_enrefundtp(EnReFundTpEnum.ENREFUND_CANCEL);
		
		IBLCancelSettlement blCancelService = ServiceFinder.find(IBLCancelSettlement.class);
		return blCancelService.Register_RefundAndSettlement(refundDTO, oprDTO, fgRealpay);
	}
}
