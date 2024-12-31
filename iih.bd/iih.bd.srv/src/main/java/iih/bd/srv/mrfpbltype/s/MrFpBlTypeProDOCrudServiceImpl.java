package iih.bd.srv.mrfpbltype.s;

import iih.bd.srv.mrfpbltype.d.MrFpBlTypeProDO;
import iih.bd.srv.mrfpbltype.d.desc.MrFpBlTypeProDODesc;
import iih.bd.srv.mrfpbltype.i.IMrFpBlTypeProDOCudService;
import iih.bd.srv.mrfpbltype.i.IMrFpBlTypeProDORService;
import iih.bd.srv.mrfpbltype.s.rule.MrFpBlTypeProBeforeInsertOrUpdateRule;
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
 * 病案首页费用分类主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IMrFpBlTypeProDOCudService.class,
		IMrFpBlTypeProDORService.class }, binding = Binding.JSONRPC)
public class MrFpBlTypeProDOCrudServiceImpl extends BaseDOService<MrFpBlTypeProDO>
		implements IMrFpBlTypeProDOCudService, IMrFpBlTypeProDORService {

	public MrFpBlTypeProDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MrFpBlTypeProDODesc.class), IAppFwTempTbl.tmp_iaw_04.name());
	}
	
	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MrFpBlTypeProDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<MrFpBlTypeProDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new MrFpBlTypeProBeforeInsertOrUpdateRule());
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<MrFpBlTypeProDO> processer, MrFpBlTypeProDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new MrFpBlTypeProBeforeInsertOrUpdateRule());
	}
}
