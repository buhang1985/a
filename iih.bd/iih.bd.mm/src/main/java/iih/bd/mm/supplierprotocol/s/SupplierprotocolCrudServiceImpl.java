package iih.bd.mm.supplierprotocol.s;

import iih.bd.mm.supplierprotocol.d.SuppierProtocolDO;
import iih.bd.mm.supplierprotocol.d.SupplierprotocolAggDO;
import iih.bd.mm.supplierprotocol.d.desc.SuppierProtocolDODesc;
import iih.bd.mm.supplierprotocol.i.ISupplierprotocolCudService;
import iih.bd.mm.supplierprotocol.i.ISupplierprotocolRService;
import iih.bd.mm.supplierprotocol.s.rule.SupproAggAfterDeleteRule;
import iih.bd.mm.supplierprotocol.s.rule.SupproAggAfterInsertOrUpdateRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 组件AggDO数据CRUD服务实现
 */
public class SupplierprotocolCrudServiceImpl extends BaseAggService<SupplierprotocolAggDO, SuppierProtocolDO>
		implements ISupplierprotocolCudService, ISupplierprotocolRService {

	public SupplierprotocolCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SuppierProtocolDODesc.class), IAppFwTempTbl.tmp_iaw_07.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(SupplierprotocolAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<SupplierprotocolAggDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new SupproAggAfterInsertOrUpdateRule());
	}

	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<SupplierprotocolAggDO> processer, SupplierprotocolAggDO[] originvos) {
		super.addUpdateAfterRule(processer, originvos);
		processer.addAfterRule(new SupproAggAfterInsertOrUpdateRule());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteAfterRule(AroundProcesser<SupplierprotocolAggDO> processer) {
		super.addLogicDeleteAfterRule(processer);
		processer.addAfterRule(new SupproAggAfterDeleteRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteAfterRule(AroundProcesser<SupplierprotocolAggDO> processer) {
		super.addRealDeleteAfterRule(processer);
		processer.addAfterRule(new SupproAggAfterDeleteRule());
	}
}
