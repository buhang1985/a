package iih.bd.srv.emrterm.s;

import iih.bd.srv.emrterm.d.EmrEtCompRelDO;
import iih.bd.srv.emrterm.d.EmrEvent4TermDO;
import iih.bd.srv.emrterm.d.desc.EmrEvent4TermDODesc;
import iih.bd.srv.emrterm.i.IEmretcomprelCudService;
import iih.bd.srv.emrterm.i.IEmretcomprelRService;
import iih.bd.srv.emrterm.i.IEmrevent4termCudService;
import iih.bd.srv.emrterm.i.IEmrevent4termRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 病历辅助录入病历事件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEmrevent4termCudService.class,
		IEmrevent4termRService.class }, binding = Binding.JSONRPC)
public class Emrevent4termCrudServiceImpl extends TreeBaseDOService<EmrEvent4TermDO>
		implements IEmrevent4termCudService, IEmrevent4termRService {

	public Emrevent4termCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmrEvent4TermDODesc.class), IAppFwTempTbl.tmp_iaw_08.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteAfterRule(AroundProcesser<EmrEvent4TermDO> processor) {
		super.addLogicDeleteAfterRule(processor);
		processor.addAfterRule(new IRule<EmrEvent4TermDO>() {
			@Override
			public void process(EmrEvent4TermDO... dos) throws BizException {
				for (EmrEvent4TermDO emrEvent4TermDO : dos) {
					processAfterDelete(emrEvent4TermDO);
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteAfterRule(AroundProcesser<EmrEvent4TermDO> processor) {
		super.addRealDeleteAfterRule(processor);
		processor.addAfterRule(new IRule<EmrEvent4TermDO>() {
			@Override
			public void process(EmrEvent4TermDO... dos) throws BizException {
				for (EmrEvent4TermDO emrEvent4TermDO : dos) {
					processAfterDelete(emrEvent4TermDO);
				}
			}
		});
	}

	protected void processAfterDelete(EmrEvent4TermDO emrEvent4TermDO) throws BizException {
		IEmretcomprelRService emretcomprelRService = ServiceFinder.find(IEmretcomprelRService.class);
		IEmretcomprelCudService emretcomprelcCudService = ServiceFinder.find(IEmretcomprelCudService.class);
		EmrEtCompRelDO[] result = emretcomprelRService
				.find(String.format("a0.id_mraet = '%s'", emrEvent4TermDO.getId_mraet()), "", FBoolean.FALSE);
		emretcomprelcCudService.delete(result);
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(EmrEvent4TermDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance(new String[] { new EmrEtCompRelDO().getTableName() }) };
	}
}
