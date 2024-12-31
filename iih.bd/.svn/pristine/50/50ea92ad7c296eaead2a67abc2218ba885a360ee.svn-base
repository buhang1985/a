package iih.bd.fc.quesite.s;

import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.d.desc.QueSiteDODesc;
import iih.bd.fc.quesite.i.IQuesiteCudService;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.bd.fc.quesite.s.rule.CheckErrorDataRule;
import iih.bd.fc.quesite.s.rule.PharmacyUniqueRule;
import iih.bd.fc.quesite.s.rule.QueSiteDelteCheckRule;
import iih.bd.fc.quesite.s.rule.QueSiteRule;
import iih.bd.fc.quesite.s.rule.WriteSiteStateChangeRecordRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 队列工作点AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IQuesiteCudService.class, IQuesiteRService.class }, binding = Binding.JSONRPC)
public class QuesiteCrudServiceImpl extends BaseDOService<QueSiteDO> implements IQuesiteCudService, IQuesiteRService {
	public QuesiteCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(QueSiteDODesc.class), IAppFwTempTbl.tmp_iaw_23.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<QueSiteDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new QueSiteRule());
		processer.addBeforeRule(new PharmacyUniqueRule());
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<QueSiteDO> processer, QueSiteDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new QueSiteRule());
		processer.addBeforeRule(new CheckErrorDataRule());
		processer.addBeforeRule(new WriteSiteStateChangeRecordRule());
		processer.addBeforeRule(new PharmacyUniqueRule());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(QueSiteDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
	
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<QueSiteDO> processer, int versionValidateType) {
		super.addRealDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new QueSiteDelteCheckRule());
	}
}
