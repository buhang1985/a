package iih.bd.pp.priceengine.bp;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.IBdPpMsgConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 设置免费价格
 * @author yankan
 * @since 2017-08-01
 *
 */
public class CalcFreePriceBP {
	/**
	 * 计算价格
	 * @param priceReqDTOs 计价请求集合
	 * @return 计价结果map,[key: 服务ID，value: 服务计价结果DTO]
	 * @throws BizException
	 */
	public Map<String, PriceResultDTO> exec(PriceReqDTO[] priceReqDTOs) throws BizException {
		Map<String, PriceResultDTO> priceRstMap = new HashMap<String, PriceResultDTO>();
		if(ArrayUtils.isNotEmpty(priceReqDTOs)){			
			for(PriceReqDTO reqDTO : priceReqDTOs){
				PriceResultDTO resultDTO = new PriceResultDTO();
				resultDTO.setId_srv(reqDTO.getId_srv());
				resultDTO.setPrice_std(FDouble.ZERO_DBL);//价格为0
				resultDTO.setError_msg(IBdPpMsgConst.MSG_SRV_IS_FREE);
			}
		}
		return priceRstMap;
	}
}
