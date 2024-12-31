package iih.bl.itf.pe;

import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import iih.bl.st.dto.bloeppecustcharge.d.BlOepPeCustInputDTO;
import iih.bl.st.dto.refundcheck.d.RefundCheckDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface IBlPeChargeService {

	/**
	 * 调入第三方个人体检费用
	 * 
	 * @param patId
	 *            患者id
	 * @return 门诊费用信息
	 * @author ly 2018/08/27
	 */
	public abstract BlOepChargeInputDTO[] getPeFeeInfo(String patId, String peCode) throws BizException;

	/**
	 * 调入第三方团检费用
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract  BlOepChargeInputDTO[] getPeCustFeeInfo(BlOepPeCustInputDTO[] dto) throws BizException;
	/**
	 * 体检收退费回写
	 * 
	 * @param stoepDo
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean peChargeReturn(BlcgoepAggDO[] blcgoepAggDOs,FBoolean fgCharge) throws BizException;

	/**
	 * 团检收退费回写
	 * 
	 * @param stoepDo
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean peCustChargeReturn(BlcgoepAggDO[] blcgoepAggDOs,FBoolean fgCharge) throws BizException;
	/**
	 * 获取待结算的团检流水号
	 * @param id_cust
	 * @return
	 * @throws BizException
	 */
	public abstract BlOepPeCustInputDTO[] getCustPeChargeInput(String id_cust) throws BizException;
	
	/**
	 * 体检退费校验
	 * @param checkDto
	 * @return
	 * @throws BizException
	 */
	public abstract RefundCheckDTO[] peRefundCheck(RefundCheckDTO[] checkDto) throws BizException;
}
