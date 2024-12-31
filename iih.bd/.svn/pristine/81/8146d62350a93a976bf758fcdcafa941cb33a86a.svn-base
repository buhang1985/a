package iih.bd.res.goodslocation.s;

import iih.bd.res.goodslocation.d.GoodslocationDO;
import iih.bd.res.goodslocation.d.desc.GoodslocationDODesc;
import iih.bd.res.goodslocation.i.IGoodslocationCudService;
import iih.bd.res.goodslocation.i.IGoodslocationRService;
import iih.bd.res.goodslocation.s.rule.InsertOrUpdateRule;
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
 * 货位AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IGoodslocationCudService.class,
		IGoodslocationRService.class }, binding = Binding.JSONRPC)
public class GoodslocationCrudServiceImpl extends BaseDOService<GoodslocationDO>
		implements IGoodslocationCudService, IGoodslocationRService {

	public GoodslocationCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(GoodslocationDODesc.class), IAppFwTempTbl.tmp_iaw_16.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<GoodslocationDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new InsertOrUpdateRule());
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<GoodslocationDO> processer, GoodslocationDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new InsertOrUpdateRule());
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
	protected Validator[] getUpdateValidator(GoodslocationDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
