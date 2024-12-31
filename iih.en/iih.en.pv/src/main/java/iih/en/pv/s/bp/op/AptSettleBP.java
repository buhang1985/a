package iih.en.pv.s.bp.op;

import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceDetailsDTO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCollectionUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.outpatient.i.IOutpatientCudService;
import iih.en.pv.s.bp.op.st.AccountBP;
import iih.en.pv.s.bp.op.st.SettleBP;
import iih.en.pv.s.bp.op.st.SettleNewBP;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.OpAptDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预约结算BP
 * 
 * @author yank
 *
 */
public class AptSettleBP {
	/**
	 * 门诊预约结算
	 * 
	 * @param aptDTO 门诊预约
	 * @return 结算id
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] settleOpApt(OpAptDTO aptDTO, PayInfoDTO payInfo) throws BizException {
		this.validate(aptDTO, payInfo);

		RegInfoDTO regInfo = AptParser.aptToRegDTO(aptDTO);
		// 患者DO
		PatEP patEP = new PatEP();
		PatDO patDO = patEP.getPatById(aptDTO.getId_pat());

		// 1、结算
		String id_cg = null;
		FBoolean isSettled = FBoolean.TRUE.equals(payInfo.getFg_acc()) ? FBoolean.FALSE : FBoolean.TRUE;
		BlIncItmVsTypeDTO[] incDTOs = null;
		if (FBoolean.TRUE.equals(payInfo.getFg_newprice())) {
			// 新结算方式，前台医保划价
			SettleNewBP settleBP = new SettleNewBP();
			if (FBoolean.TRUE.equals(payInfo.getFg_acc())) {
				throw new BizException(IEnMsgConst.ERROR_OP_REG_NEWPRICE_CANNOT_ACCOUNT);// 只记账，按旧的后台划价方式处理
			} else {
				incDTOs = settleBP.settle(patDO.getId_pat(), regInfo, payInfo, EnContextUtils.getPsnId());
				if (!EnValidator.isEmpty(incDTOs)) {
					BlInvoiceDetailsDTO invoiceDTO = (BlInvoiceDetailsDTO)incDTOs[0].getBlInvoiceDetailsDTO().get(0);
					id_cg = invoiceDTO.getId_cgoep();				
					FArrayList invoiceInfo = EnCollectionUtils.toFArrayList(incDTOs);
					regInfo.setInvoiceinfo(invoiceInfo);
					// aptDTO.setInvoiceinfo(invoiceInfo);
				}
			}
		} else {
			// 旧结算方式，后台划价结算
			SettleBP settleBP = new SettleBP();
			if (FBoolean.TRUE.equals(payInfo.getFg_acc())) {
				AccountBP accountBP = new AccountBP();
				id_cg = accountBP.exec(regInfo);// 只记账
				BlInvoiceDetailsDTO invoiceDetailsDTO = new BlInvoiceDetailsDTO();
				invoiceDetailsDTO.setId_cgoep(id_cg);
				BlIncItmVsTypeDTO itmVsTypeDTO = new BlIncItmVsTypeDTO();
				itmVsTypeDTO.setBlInvoiceDetailsDTO(EnAppUtils.doArray2List(invoiceDetailsDTO));
				incDTOs = new BlIncItmVsTypeDTO[]{ itmVsTypeDTO };
			} else {
				String empId = EnContextUtils.getPsnId();// 操作员id
				incDTOs = settleBP.settle(patDO.getId_pat(), regInfo, payInfo, empId);
//				id_cg = incDTOs[0].getId_cgoep();
				if (!EnValidator.isEmpty(incDTOs)) {
					BlInvoiceDetailsDTO invoiceDTO = (BlInvoiceDetailsDTO)incDTOs[0].getBlInvoiceDetailsDTO().get(0);
					id_cg = invoiceDTO.getId_cgoep();	
				}
			}
		}

		// 2、更新记账主键，保存OP
		OpEP opEP = new OpEP();
		OutpatientDO opDO = opEP.getOpByEntId(aptDTO.getId_ent());
		opDO.setId_cg(id_cg);// 记账主键
		opDO.setFg_cg(isSettled);// 已结算标识
		opDO.setStatus(DOStatus.UPDATED);
		IOutpatientCudService opCudService = ServiceFinder.find(IOutpatientCudService.class);
		opCudService.save(new OutpatientDO[] { opDO });

		return incDTOs;
	}

	/**
	 * 验证参数
	 * 
	 * @param aptDTO
	 * @param payInfo
	 * @throws BizException
	 */
	private void validate(OpAptDTO aptDTO, PayInfoDTO payInfo) throws BizException {
		EnValidator.validateParam("预约DTO", aptDTO);
		EnValidator.validateParam("付款信息", payInfo);
	}
}
