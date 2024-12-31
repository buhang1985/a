package iih.pi.reg.pat.s;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.s.rule.CreatePatAccRule;
import iih.pi.reg.pat.s.rule.PatChangedRecordRule;
import iih.pi.reg.pat.s.rule.SyncEnPatInfoRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 患者基本信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IPatiMDOCudService.class, IPatiMDORService.class }, binding = Binding.JSONRPC)
public class PatiMDOCrudServiceImpl extends BaseDOService<PatDO> implements IPatiMDOCudService, IPatiMDORService {

	public PatiMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PatDODesc.class), IAppFwTempTbl.tmp_iaw_24.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance(new String[] { "pi_pat_hist" }) };
	}

	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<PatDO> processor, PatDO[] originvos) {
		super.addUpdateAfterRule(processor, originvos);
		processor.addAfterRule(new PatChangedRecordRule<PatDO>());
		processor.addAfterRule(new SyncEnPatInfoRule<PatDO>());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<PatDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new CreatePatAccRule<PatDO>());
	}
}
