package iih.bd.mm.stockdealtype.s.bp;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.mm.stockdealtype.d.StockDealTypeDO;
import iih.bd.mm.stockdealtype.i.IStockdealtypeRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据编码获取库存交易分类业务逻辑
 * 
 * @author hao_wu 2018-10-30
 *
 */
public class FindDealTypeByCodeBp {

	public StockDealTypeDO exec(String code) throws BizException {
		if (StringUtils.isEmpty(code)) {
			throw new BizException("库存交易分类不允许为空。");
		}

		IStockdealtypeRService stockdealtypeRService = ServiceFinder.find(IStockdealtypeRService.class);
		StockDealTypeDO[] stockDealTypeDos = stockdealtypeRService.findByAttrValString(StockDealTypeDO.CODE, code);
		if (ArrayUtils.isEmpty(stockDealTypeDos)) {
			String msg = String.format("获取库存交易分类失败，分类编码：%s。", code);
			throw new BizException(msg);
		}
		return stockDealTypeDos[0];
	}

}
