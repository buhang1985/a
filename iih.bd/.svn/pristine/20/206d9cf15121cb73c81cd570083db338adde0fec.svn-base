package iih.bd.pp.bp.pri;

import java.util.Map;

import iih.bd.pp.dto.d.PriceResultDTO;
import xap.mw.core.data.BizException;

/**
 * 计算标准价格
 * @author yankan
 *
 */
public class CalcStdPriBP {
	/**
	 * 计算标准价格
	 * @param srvId 服务ID
	 * @return 计价结果DTO
	 * @throws BizException
	 * @author yankan
	 */
	public PriceResultDTO exec(String srvId) throws BizException{
		BatchCalcStdPriBP batchCalcBP = new BatchCalcStdPriBP();
		Map<String,PriceResultDTO> resultMap = batchCalcBP.exec(new String[]{srvId});
		if(resultMap==null){
			return null;
		}
		return resultMap.get(srvId);
	}
}
