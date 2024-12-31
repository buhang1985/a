package iih.bd.pp.bdprewarn.s;

import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.pp.bdprewarn.d.desc.BdPreWarnDODesc;
import iih.bd.pp.bdprewarn.i.IBdprewarnMDOCudService;
import iih.bd.pp.bdprewarn.i.IBdprewarnMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 预交金警告策略主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IBdprewarnMDOCudService.class, IBdprewarnMDORService.class }, binding = Binding.JSONRPC)
public class BdprewarnMDOCrudServiceImpl extends BaseDOService<BdPreWarnDO>
		implements IBdprewarnMDOCudService, IBdprewarnMDORService {

	public BdprewarnMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdPreWarnDODesc.class), IAppFwTempTbl.tmp_iaw_03.name());
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
	protected Validator[] getUpdateValidator(BdPreWarnDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
