package iih.bd.srv.diagcate.s;

import iih.bd.srv.diagcate.d.DiCateItemDO;
import iih.bd.srv.diagcate.d.desc.DiCateItemDODesc;
import iih.bd.srv.diagcate.i.IDiCateItemDOCudService;
import iih.bd.srv.diagcate.i.IDiCateItemDORService;
import iih.bd.srv.diagcate.s.rule.DiCateItemAfterDeleteRule;
import iih.bd.srv.diagcate.s.rule.DiCateItemAfterInsertRule;
import iih.bd.srv.diagcate.s.rule.DiCateItemAfterUpdateRule;
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
 * 疾病诊断分类主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IDiCateItemDOCudService.class, IDiCateItemDORService.class }, binding = Binding.JSONRPC)
public class DiCateItemDOCrudServiceImpl extends BaseDOService<DiCateItemDO>
		implements IDiCateItemDOCudService, IDiCateItemDORService {

	public DiCateItemDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DiCateItemDODesc.class), IAppFwTempTbl.tmp_iaw_19.name());
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
	protected Validator[] getUpdateValidator(DiCateItemDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<DiCateItemDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new DiCateItemAfterInsertRule());
	}
	
	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<DiCateItemDO> processor, DiCateItemDO[] originvos) {
		super.addUpdateAfterRule(processor, originvos);
		processor.addAfterRule(new DiCateItemAfterUpdateRule());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteAfterRule(AroundProcesser<DiCateItemDO> processor) {
		super.addLogicDeleteAfterRule(processor);
		processor.addAfterRule(new DiCateItemAfterDeleteRule());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteAfterRule(AroundProcesser<DiCateItemDO> processor) {
		super.addRealDeleteAfterRule(processor);
		processor.addAfterRule(new DiCateItemAfterDeleteRule());
	}
}
