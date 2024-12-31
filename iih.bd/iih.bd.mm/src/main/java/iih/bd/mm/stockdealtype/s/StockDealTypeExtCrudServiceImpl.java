package iih.bd.mm.stockdealtype.s;

import iih.bd.mm.stockdealtype.d.StockDealTypeDO;
import iih.bd.mm.stockdealtype.i.IStockDealTypeExtCudService;
import iih.bd.mm.stockdealtype.i.IStockDealTypeExtRService;
import iih.bd.mm.stockdealtype.s.bp.FindDealTypeByCodeBp;
import xap.mw.core.data.BizException;

/**
 * 库存交易分类扩展服务
 * 
 * @author hao_wu 2018-10-30
 *
 */
public class StockDealTypeExtCrudServiceImpl implements IStockDealTypeExtCudService, IStockDealTypeExtRService {

	@Override
	public StockDealTypeDO findDealTypeByCode(String code) throws BizException {
		FindDealTypeByCodeBp bp = new FindDealTypeByCodeBp();
		StockDealTypeDO stockDealTypeDo = bp.exec(code);
		return stockDealTypeDo;
	}

}
