package iih.mi.inst.bizbase;

import iih.mi.bd.d.HpDTO;
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

public class OepChargeBaseImpl extends InsureBaseImpl{
	
	/** 保存收付款分摊信息（常规流程）
	 * @return 保存得分摊结果
	 * @throws BizException
	 * @date 2018-04-26
	 */
	public FArrayList savePayPropDataOep(OepSettleRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO) throws BizException{
		HpDTO hpDTO= getHpDTO();
		throw new BizException("["+hpDTO.getCode()+"]医保产品必须实现自己的医保分摊数据保存逻辑!");
	}
	/** 获取门诊医保收付款分摊信息
	 * @param hisPropertyDTO
	 * @return 
	 * @throws BizException
	 */
	public FArrayList getHpPropDataOep(HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		HpDTO hpDTO= getHpDTO();
		throw new BizException("["+hpDTO.getCode()+"]医保产品必须实现自己的医保分摊数据查询逻辑!");
	}
	
	/** 存储医保红冲分摊数据
	 * @param hisPropertyDTO
	 * @return
	 * @throws BizException
	 */
	public FArrayList saveBackPropDataOep(HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		HpDTO hpDTO= getHpDTO();
		throw new BizException("["+hpDTO.getCode()+"]医保产品必须实现自己的医保分摊红冲数据保存逻辑!");
	}
	
	/**
	 * 自助机医保后台划价流程
	 * (本流程适用于给自助机提供交易入参模式)
	 * @param inParam 入参
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/02
	 */
	public ResultOutParamDTO<MiOepChargePricingSelfOutParamDTO> oepPricingSelf(MiOepChargePricingSelfInParamDTO inParam) throws BizException{
		HpDTO hpDTO= getHpDTO();
		throw new BizException("["+hpDTO.getCode()+"]医保产品必须实现自己的自助机医保后台划价流程逻辑!");
	}
	
	/**
	 * 自助机医保后台收付款流程
	 * (本流程适用于给自助机提供交易入参模式)
	 * @param inParam 入参
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/02
	 */
	public ResultOutParamDTO<MiOepChargePaySelfOutParamDTO> oepPaySelf(MiOepChargePaySelfInParamDTO inParam) throws BizException{
		HpDTO hpDTO= getHpDTO();
		throw new BizException("["+hpDTO.getCode()+"]医保产品必须实现自己的自助机医保后台收付款流程逻辑!");
	}
	
	/**
	 * 门诊医保公式计算
	 * @param oepSettleRtnValDto 门诊结算信息
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/10
	 */
	public CommonPropDataDTO hpFormulaCalculateOep(OepSettleRtnValDTO oepSettleRtnValDto) throws BizException{
		HpDTO hpDTO= getHpDTO();
		throw new BizException("["+hpDTO.getCode()+"]医保产品必须实现自己的门诊医保公式计算逻辑!");
	}
	
	/**
	 * 获取门诊医保分摊结果
	 * @param dto
	 * @return
	 * @throws BizException
	 * @author ly 2019/12/29
	 */
	public MiPropInfoOutDTO getOepPropData(MiPropInfoInDTO dto) throws BizException{
		return new MiPropInfoOutDTO();
	}
}
