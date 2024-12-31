package iih.bd.mm.stockdealtype.s.rule;

import iih.bd.mm.stockdealtype.d.StockDealTypeDO;
import iih.bd.mm.stockdealtype.s.bp.StockDealtpDeBeforeBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 库存交易分类删除前规则
 * 
 * @author hao_wu
 *
 */
public class StockdealtypeBeforeDeleteRule implements IRule<StockDealTypeDO> {

	@Override
	public void process(StockDealTypeDO... stockDealTypeDOS) throws BizException {
		StockDealtpDeBeforeBp bp = new StockDealtpDeBeforeBp();
		bp.exec(stockDealTypeDOS);
	}
}
