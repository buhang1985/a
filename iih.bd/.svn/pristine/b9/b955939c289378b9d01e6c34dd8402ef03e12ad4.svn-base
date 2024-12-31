package iih.bd.srv.qcmraddrule.s;

import iih.bd.srv.qcmraddrule.d.QcmraddruleAggDO;
import iih.bd.srv.qcmraddrule.d.QcmraddruleDO;
import iih.bd.srv.qcmraddrule.d.desc.QcmraddruleDODesc;
import iih.bd.srv.qcmraddrule.i.IQcmraddruleCudService;
import iih.bd.srv.qcmraddrule.i.IQcmraddruleRService;
import iih.bd.srv.qcmraddrule.s.validator.QcmraddruleAggDOItemDataValidate;
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
@Service(serviceInterfaces = { IQcmraddruleCudService.class, IQcmraddruleRService.class }, binding = Binding.JSONRPC)
public class QcmraddruleCrudServiceImpl extends BaseAggService<QcmraddruleAggDO, QcmraddruleDO>
		implements IQcmraddruleCudService, IQcmraddruleRService {
	public QcmraddruleCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(QcmraddruleDODesc.class), IAppFwTempTbl.tmp_iaw_21.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), new QcmraddruleAggDOItemDataValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(QcmraddruleAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate(), new QcmraddruleAggDOItemDataValidate() };
	}
}
