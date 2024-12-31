package iih.bd.pp.bp.pri;

import java.util.Map;

import iih.bd.pp.dto.d.PriceResultDTO;
import xap.mw.core.data.BizException;

/**
 * 计算患者分类价格
 * @author yankan
 *
 */
public class CalcPatPriBP {
	/**
	 * 计算患者分类价格
	 * @param srvId 服务ID
	 * @param pripatId 患者价格分类ID
	 * @return 计算价格结果DTO
	 * @throws BizException
	 * @author yankan
	 */
	public PriceResultDTO exec(String srvId,String pripatId) throws BizException{
		BatchCalcPatPriBP batchCalcBP = new BatchCalcPatPriBP();
		Map<String,PriceResultDTO> resultMap = batchCalcBP.exec(new String[]{srvId},pripatId);
		if(resultMap==null){
			return null;
		}
		return resultMap.get(srvId);
	}
}
