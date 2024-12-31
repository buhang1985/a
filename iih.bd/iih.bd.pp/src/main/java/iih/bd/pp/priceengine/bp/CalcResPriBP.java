package iih.bd.pp.priceengine.bp;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import xap.mw.core.data.BizException;

/**
 * 计算物品计价
 * 需调用物品的服务，跟执行科室和库存有关，在具体使用时确定最终价格
 * @author yankan
 * @since 2017-07-26
 *
 */
public class CalcResPriBP {
	/**
	 * 计算价格
	 * 
	 * @param priceReqDTOs 计价请求集合
	 * @return 计价结果map,[key: 服务ID，value: 服务计价结果DTO]
	 * @throws BizException
	 */
	public Map<String, PriceResultDTO> exec(PriceReqDTO[] priceReqDTOs) throws BizException {
		Map<String, PriceResultDTO> priceRstMap = new HashMap<String, PriceResultDTO>();
		
//		//需要物品ID、执行科室ID、单位
//		IMaterialStockService stockService = ServiceFinder.find(IMaterialStockService.class);
//		stockService.getMaterialStocks(priceReqDTOs);
		
		//固定价物品
//		iih.mm.itf.material.i.IMaterialBaseInfoService.getMaterialPrice(String id_mm, String req_unit_id)
		if(ArrayUtils.isNotEmpty(priceReqDTOs)){			
			for(PriceReqDTO reqDTO : priceReqDTOs){
				PriceResultDTO resultDTO = new PriceResultDTO();
				resultDTO.setId_srv(reqDTO.getId_srv());
				resultDTO.setPrice_std(null);//
			}
		}
		return priceRstMap;
	}
}
