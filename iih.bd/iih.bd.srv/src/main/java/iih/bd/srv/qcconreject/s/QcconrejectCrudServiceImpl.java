package iih.bd.srv.qcconreject.s;

import iih.bd.srv.qcconreject.d.QcconrejectAggDO;
import iih.bd.srv.qcconreject.d.QcconrejectDO;
import iih.bd.srv.qcconreject.d.desc.QcconrejectDODesc;
import iih.bd.srv.qcconreject.i.IQcconrejectCudService;
import iih.bd.srv.qcconreject.i.IQcconrejectRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IQcconrejectCudService.class, IQcconrejectRService.class }, binding = Binding.JSONRPC)
public class QcconrejectCrudServiceImpl extends BaseAggService<QcconrejectAggDO, QcconrejectDO>
		implements IQcconrejectCudService, IQcconrejectRService {
	public QcconrejectCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(QcconrejectDODesc.class), IAppFwTempTbl.tmp_iaw_28.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(QcconrejectAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
