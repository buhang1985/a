package iih.bd.srv.medformula.s;

import iih.bd.srv.medformula.d.MedformulaDO;
import iih.bd.srv.medformula.d.desc.MedformulaDODesc;
import iih.bd.srv.medformula.i.IMedformulaCudService;
import iih.bd.srv.medformula.i.IMedformulaRService;
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
@Service(serviceInterfaces = { IMedformulaCudService.class, IMedformulaRService.class }, binding = Binding.JSONRPC)
public class MedformulaCrudServiceImpl extends BaseDOService<MedformulaDO>
		implements IMedformulaCudService, IMedformulaRService {
	public MedformulaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MedformulaDODesc.class), IAppFwTempTbl.tmp_iaw_13.name());
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
	protected Validator[] getUpdateValidator(MedformulaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
