package iih.mi.itf2.bizflowitf;

import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.OepSettleRtnValDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 门诊医保接口
 * @author LIM
 *
 */
public interface IOepFlowItf {
	/**
	 * 保存医保分摊数据
	 * @param hisPropertyDTO
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList savePayPropDataOep(OepSettleRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO)throws BizException;
	
	/** 
	 * 存储医保分摊红冲数据门诊
	 * @param hisPropertyDTO
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList saveBackPropDataOep(HisPropertyRefHpDTO hisPropertyDTO) throws BizException;
}
