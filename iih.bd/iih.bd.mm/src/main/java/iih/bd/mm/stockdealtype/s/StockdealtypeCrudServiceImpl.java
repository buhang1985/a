package iih.bd.mm.stockdealtype.s;

import iih.bd.mm.stockdealtype.d.StockDealTypeDO;
import iih.bd.mm.stockdealtype.d.desc.StockDealTypeDODesc;
import iih.bd.mm.stockdealtype.i.IStockdealtypeCudService;
import iih.bd.mm.stockdealtype.i.IStockdealtypeRService;
import iih.bd.mm.stockdealtype.s.rule.StockdealtypeBeforeDeleteRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 库存交易分类AggDO数据CRUD服务实现
 */
public class StockdealtypeCrudServiceImpl extends BaseDOService<StockDealTypeDO>
		implements IStockdealtypeCudService, IStockdealtypeRService {

	public StockdealtypeCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(StockDealTypeDODesc.class), IAppFwTempTbl.tmp_iaw_21.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteBeforeRule(AroundProcesser<StockDealTypeDO> processer, int versionValidateType) {
		super.addLogicDeleteBeforeRule(processer, versionValidateType);

		processer.addBeforeRule(new StockdealtypeBeforeDeleteRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<StockDealTypeDO> processer, int versionValidateType) {
		super.addRealDeleteBeforeRule(processer, versionValidateType);

		processer.addBeforeRule(new StockdealtypeBeforeDeleteRule());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(StockDealTypeDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
