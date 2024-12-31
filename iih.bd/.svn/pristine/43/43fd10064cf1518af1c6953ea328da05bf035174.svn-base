package iih.bd.pp.bdbltpl.s;

import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import iih.bd.pp.bdbltpl.d.desc.BdBlTplDODesc;
import iih.bd.pp.bdbltpl.i.IBdbltplMDOCudService;
import iih.bd.pp.bdbltpl.i.IBdbltplMDORService;
import iih.bd.pp.bdbltpl.s.rule.ItemCountCheckRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 自定义费用模板主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IBdbltplMDOCudService.class, IBdbltplMDORService.class }, binding = Binding.JSONRPC)
public class BdbltplMDOCrudServiceImpl extends BaseDOService<BdBlTplDO>
		implements IBdbltplMDOCudService, IBdbltplMDORService {

	public BdbltplMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdBlTplDODesc.class), IAppFwTempTbl.tmp_iaw_15.name());
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
	protected Validator[] getUpdateValidator(BdBlTplDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<BdBlTplDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new ItemCountCheckRule<BdBlTplDO>());
	}
	
	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<BdBlTplDO> processer, BdBlTplDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new ItemCountCheckRule<BdBlTplDO>());
	}
}
