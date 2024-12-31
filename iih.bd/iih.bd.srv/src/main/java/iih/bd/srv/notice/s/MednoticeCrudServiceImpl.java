package iih.bd.srv.notice.s;

import iih.bd.srv.notice.d.MedNoticeDO;
import iih.bd.srv.notice.d.desc.MedNoticeDODesc;
import iih.bd.srv.notice.i.IMednoticeCudService;
import iih.bd.srv.notice.i.IMednoticeRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗注意事项AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMednoticeCudService.class, IMednoticeRService.class }, binding = Binding.JSONRPC)
public class MednoticeCrudServiceImpl extends BaseDOService<MedNoticeDO>
		implements IMednoticeCudService, IMednoticeRService {
	public MednoticeCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MedNoticeDODesc.class), IAppFwTempTbl.tmp_iaw_29.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MedNoticeDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
