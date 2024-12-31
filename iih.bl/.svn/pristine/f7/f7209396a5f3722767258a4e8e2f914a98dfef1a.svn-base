package iih.bl.cg.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.bloepdelcostdto.d.BlOepDeLCostDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.i.IBlCgAccountService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊销账保存
 * 
 * @author zhangxin06 2018-9-29
 *
 */
public class BlCgOepReturnSellBp {
	/**
	 * 门诊销账保存
	 * 
	 * @param billdto
	 *            待销账数据
	 * @param id_pat
	 *            患者id
	 * @return BlOepDeLCostDTO 销账成功数据
	 * @throws BizException
	 */
	public BlOepDeLCostDTO[] exec(BlOepDeLCostDTO[] billdto, String id_pat) throws BizException {

		List<BlCgRefundAccountDTO> listcg = new ArrayList<BlCgRefundAccountDTO>();
		for (BlOepDeLCostDTO blStReFundBillDTO : billdto) {

			BlCgRefundAccountDTO cgrefund = new BlCgRefundAccountDTO();
			// 就诊id
			// cgrefund.setId_ent(blStReFundBillDTO.getId_ent());
			// 患者id
			cgrefund.setId_pat(blStReFundBillDTO.getId_pat());
			// 医疗服务id
			// cgrefund.setId_orsrv(blStReFundBillDTO.getId_orsrv());
			// 记账主键
			cgrefund.setId_cg(blStReFundBillDTO.getId_cgitmoep());
			// 数量
			cgrefund.setQuan(blStReFundBillDTO.getQuan());

			listcg.add(cgrefund);

		}
		IBlCgAccountService iBlCgAccountService = ServiceFinder.find(IBlCgAccountService.class);
		BlCgRefundAccountDTO[] refundDtos = listcg.toArray(new BlCgRefundAccountDTO[] {});
		BlCgRefundAccountSetDTO accSetDto = new BlCgRefundAccountSetDTO();
		// 退记账模式
		accSetDto.setEu_rfdmode("1");
		// 是否抛异常 是
		accSetDto.setFg_exception(FBoolean.TRUE);
		// 调用通用记账接口
		BlCgAccountRltDTO refundAccountForOp = iBlCgAccountService.refundAccountForOp(refundDtos, accSetDto);
		if(refundAccountForOp.getFg_success().booleanValue()){
			return billdto;
		}else{
			throw new BizException(refundAccountForOp.getErr_msg());
		}
	}
}
