package iih.bd.mm.supplierprotocol.s;

import iih.bd.mm.supplierprotocol.d.SuppierProtocolDO;
import iih.bd.mm.supplierprotocol.d.desc.SuppierProtocolDODesc;
import iih.bd.mm.supplierprotocol.i.ISupplierprotocolMDOCudService;
import iih.bd.mm.supplierprotocol.i.ISupplierprotocolMDORService;
import iih.bd.mm.supplierprotocol.s.rule.SupproMDOAfterInsertOrUpdateRule;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 供应商关系及协议AggDO数据CRUD服务实现
 */
public class SupplierprotocolMDOCrudServiceImpl extends BaseDOService<SuppierProtocolDO>
		implements ISupplierprotocolMDOCudService, ISupplierprotocolMDORService {

	public SupplierprotocolMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SuppierProtocolDODesc.class), IAppFwTempTbl.tmp_iaw_25.name());
	}
	
	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<SuppierProtocolDO> processer, SuppierProtocolDO[] originvos) {
		super.addUpdateAfterRule(processer, originvos);
		processer.addAfterRule(new SupproMDOAfterInsertOrUpdateRule());
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
	protected Validator[] getUpdateValidator(SuppierProtocolDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
	
	
}
