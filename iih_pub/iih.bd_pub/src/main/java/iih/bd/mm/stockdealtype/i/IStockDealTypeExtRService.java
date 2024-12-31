package iih.bd.mm.stockdealtype.i;

import iih.bd.mm.stockdealtype.d.StockDealTypeDO;
import xap.mw.core.data.BizException;

/**
 * 库存交易分类扩展查询服务
 * 
 * @author hao_wu 2018-10-30
 *
 */
public interface IStockDealTypeExtRService {

	/**
	 * 根据编码获取库存交易分类
	 * 
	 * @param code 库存交易分类编码
	 * @return
	 * @throws BizException
	 */
	public abstract StockDealTypeDO findDealTypeByCode(String code) throws BizException;
}
