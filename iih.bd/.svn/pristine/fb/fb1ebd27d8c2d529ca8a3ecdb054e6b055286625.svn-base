package iih.bd.srv.qcmraddrule.s;

import iih.bd.srv.qcmraddrule.d.QcmraddruleDO;
import iih.bd.srv.qcmraddrule.d.desc.QcmraddruleDODesc;
import iih.bd.srv.qcmraddrule.i.IQcmraddruleMDOCudService;
import iih.bd.srv.qcmraddrule.i.IQcmraddruleMDORService;
import iih.bd.srv.qcmraddrule.s.rule.QcmraddruleDOItemDataValidateRule;
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
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IQcmraddruleMDOCudService.class,
		IQcmraddruleMDORService.class }, binding = Binding.JSONRPC)
public class QcmraddruleMDOCrudServiceImpl extends BaseDOService<QcmraddruleDO>
		implements IQcmraddruleMDOCudService, IQcmraddruleMDORService {

	public QcmraddruleMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(QcmraddruleDODesc.class), IAppFwTempTbl.tmp_iaw_17.name());
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
	protected Validator[] getUpdateValidator(QcmraddruleDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<QcmraddruleDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new QcmraddruleDOItemDataValidateRule());
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<QcmraddruleDO> processer, QcmraddruleDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new QcmraddruleDOItemDataValidateRule());
	}
}
