package iih.bd.pp.bdbltpl.s;

import iih.bd.pp.bdbltpl.d.BdBlTplDO;
import iih.bd.pp.bdbltpl.d.BdbltplAggDO;
import iih.bd.pp.bdbltpl.d.desc.BdBlTplDODesc;
import iih.bd.pp.bdbltpl.i.IBdbltplCudService;
import iih.bd.pp.bdbltpl.i.IBdbltplRService;
import iih.bd.pp.bdbltpl.s.rule.ItemCountCheckRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 自定义费用模板AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IBdbltplCudService.class, IBdbltplRService.class }, binding = Binding.JSONRPC)
public class BdbltplCrudServiceImpl extends BaseAggService<BdbltplAggDO, BdBlTplDO>
		implements IBdbltplCudService, IBdbltplRService {
	public BdbltplCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdBlTplDODesc.class), IAppFwTempTbl.tmp_iaw_07.name());
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
	protected Validator[] getUpdateValidator(BdbltplAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<BdbltplAggDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new ItemCountCheckRule<BdbltplAggDO>());
	}
	
	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<BdbltplAggDO> processer, BdbltplAggDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new ItemCountCheckRule<BdbltplAggDO>());
	}
}
