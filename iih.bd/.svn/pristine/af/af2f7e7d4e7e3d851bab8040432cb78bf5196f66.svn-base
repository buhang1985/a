package iih.bd.srv.qcevent.s;

import iih.bd.srv.qcevent.d.QcEventDO;
import iih.bd.srv.qcevent.d.desc.QcEventDODesc;
import iih.bd.srv.qcevent.i.IQceventCudService;
import iih.bd.srv.qcevent.i.IQceventRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IQceventCudService.class, IQceventRService.class }, binding = Binding.JSONRPC)
public class QceventCrudServiceImpl extends BaseDOService<QcEventDO> implements IQceventCudService, IQceventRService {

	public QceventCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(QcEventDODesc.class), IAppFwTempTbl.tmp_iaw_18.name());
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
	protected Validator[] getUpdateValidator(QcEventDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
