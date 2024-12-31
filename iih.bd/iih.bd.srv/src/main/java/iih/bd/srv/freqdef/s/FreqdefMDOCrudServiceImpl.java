package iih.bd.srv.freqdef.s;

import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.desc.FreqDefDODesc;
import iih.bd.srv.freqdef.i.IFreqdefMDOCudService;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bd.srv.freqdef.s.rule.FreqdefFiledValueChangCheckRule;
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
 * 医嘱频次定义主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IFreqdefMDOCudService.class, IFreqdefMDORService.class }, binding = Binding.JSONRPC)
public class FreqdefMDOCrudServiceImpl extends BaseDOService<FreqDefDO>
		implements IFreqdefMDOCudService, IFreqdefMDORService {

	public FreqdefMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(FreqDefDODesc.class), IAppFwTempTbl.tmp_iaw_26.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(FreqDefDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<FreqDefDO> processer, FreqDefDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new FreqdefFiledValueChangCheckRule());
	}
}
