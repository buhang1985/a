package iih.bd.pp.prisrv.s;

import iih.bd.pp.prisrv.d.PriSrvDO;
import iih.bd.pp.prisrv.d.desc.PriSrvDODesc;
import iih.bd.pp.prisrv.i.IPrisrvCudService;
import iih.bd.pp.prisrv.i.IPrisrvRService;
import iih.bd.pp.prisrv.s.rule.CheckPriSrvDoUniqueRule;
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
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IPrisrvCudService.class, IPrisrvRService.class }, binding = Binding.JSONRPC)
public class PrisrvCrudServiceImpl extends BaseDOService<PriSrvDO> implements IPrisrvCudService, IPrisrvRService {

	public PrisrvCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PriSrvDODesc.class), IAppFwTempTbl.tmp_iaw_02.name());
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
	protected Validator[] getUpdateValidator(PriSrvDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<PriSrvDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new CheckPriSrvDoUniqueRule());
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<PriSrvDO> processer, PriSrvDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new CheckPriSrvDoUniqueRule());
	}
}
