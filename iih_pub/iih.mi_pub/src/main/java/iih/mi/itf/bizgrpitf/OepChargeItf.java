package iih.mi.itf.bizgrpitf;

import iih.mi.biz.common.d.MiPropInfoInDTO;
import iih.mi.biz.common.d.MiPropInfoOutDTO;
import iih.mi.biz.dto.d.CommonPropDataDTO;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.OepSettleRtnValDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePaySelfInParamDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePaySelfOutParamDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePricingSelfInParamDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePricingSelfOutParamDTO;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

public interface OepChargeItf {

	/** 保存收付款分摊信息
	 * @return 保存得分摊结果
	 * @throws BizException
	 * @date 2018-04-26
	 */
	public abstract FArrayList savePayPropDataOep(OepSettleRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO) throws BizException;

	/** 获取门诊医保收付款分摊信息
	 * @param hisPropertyDTO
	 * @return 
	 * @throws BizException
	 */
	public abstract FArrayList getHpPropDataOep(HisPropertyRefHpDTO hisPropertyDTO) throws BizException;

	/** 红冲医保分摊数据
	 * @param hisPropertyDTO his关联数据
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList saveBackPropDataOep(HisPropertyRefHpDTO hisPropertyDTO) throws BizException;

	/**
	 * 自助机医保后台划价流程
	 * (本流程适用于给自助机提供交易入参模式)
	 * @param inParam 入参
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/02
	 */
	public abstract ResultOutParamDTO<MiOepChargePricingSelfOutParamDTO> oepPricingSelf(MiOepChargePricingSelfInParamDTO inParam) throws BizException;
	
	/**
	 * 自助机医保后台收付款流程
	 * (本流程适用于给自助机提供交易入参模式)
	 * @param inParam 入参
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/02
	 */
	public abstract ResultOutParamDTO<MiOepChargePaySelfOutParamDTO> oepPaySelf(MiOepChargePaySelfInParamDTO inParam) throws BizException;
	 
	/**
	 * 门诊医保公式计算
	 * @param oepSettleRtnValDto 门诊结算信息
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/10
	 */
	public abstract CommonPropDataDTO hpFormulaCalculateOep(OepSettleRtnValDTO oepSettleRtnValDto) throws BizException;
 
	/**
	 * 获取门诊医保分摊结果
	 * @param dto
	 * @return
	 * @throws BizException
	 * @author ly 2019/12/29
	 */
	public abstract MiPropInfoOutDTO getOepPropData(MiPropInfoInDTO dto) throws BizException;
}