package iih.bd.srv.qcconreject.s;

import iih.bd.srv.qcconreject.d.QcconrejectDO;
import iih.bd.srv.qcconreject.d.desc.QcconrejectDODesc;
import iih.bd.srv.qcconreject.i.IQcconrejectMDOCudService;
import iih.bd.srv.qcconreject.i.IQcconrejectMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IQcconrejectMDOCudService.class,
		IQcconrejectMDORService.class }, binding = Binding.JSONRPC)
public class QcconrejectMDOCrudServiceImpl extends BaseDOService<QcconrejectDO>
		implements IQcconrejectMDOCudService, IQcconrejectMDORService {

	public QcconrejectMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(QcconrejectDODesc.class), IAppFwTempTbl.tmp_iaw_05.name());
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
	protected Validator[] getUpdateValidator(QcconrejectDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
