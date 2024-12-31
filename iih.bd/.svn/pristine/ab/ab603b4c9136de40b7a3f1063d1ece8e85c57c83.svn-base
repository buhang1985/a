package iih.bd.pp.hp.s;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.d.desc.HPDODesc;
import iih.bd.pp.hp.i.IHpMDOCudService;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.bd.pp.hp.s.validator.HpDOValidator;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保计划主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IHpMDOCudService.class, IHpMDORService.class }, binding = Binding.JSONRPC)
public class HpMDOCrudServiceImpl extends BaseDOService<HPDO> implements IHpMDOCudService, IHpMDORService {

	public HpMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(HPDODesc.class), IAppFwTempTbl.tmp_iaw_05.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate()};
	}

	@Override
	protected Validator[] getUpdateValidator(HPDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate(), new HpDOValidator() };
	}

}
