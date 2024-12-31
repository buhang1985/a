package iih.bd.res.bed.s;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.d.desc.BdbedDesc;
import iih.bd.res.bed.i.IBedMDOCudService;
import iih.bd.res.bed.i.IBedMDORService;
import iih.bd.res.bed.s.rule.BedNameChangedRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 床位管理主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IBedMDOCudService.class, IBedMDORService.class }, binding = Binding.JSONRPC)
public class BedMDOCrudServiceImpl extends BaseDOService<Bdbed> implements IBedMDOCudService, IBedMDORService {

	public BedMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdbedDesc.class), IAppFwTempTbl.tmp_iaw_09.name());
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
	protected Validator[] getUpdateValidator(Bdbed[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<Bdbed> processor, Bdbed[] originvos) {
		super.addUpdateAfterRule(processor, originvos);
		processor.addAfterRule(new BedNameChangedRule<Bdbed>());
	}
}
