package iih.bd.pp.bdbltpl.s;

import iih.bd.pp.bdbltpl.d.BdBltplItmDO;
import iih.bd.pp.bdbltpl.d.desc.BdBltplItmDODesc;
import iih.bd.pp.bdbltpl.i.IBdBltplItmDOCudService;
import iih.bd.pp.bdbltpl.i.IBdBltplItmDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 自定义费用模板主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IBdBltplItmDOCudService.class, IBdBltplItmDORService.class }, binding = Binding.JSONRPC)
public class BdBltplItmDOCrudServiceImpl extends BaseDOService<BdBltplItmDO>
		implements IBdBltplItmDOCudService, IBdBltplItmDORService {

	public BdBltplItmDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdBltplItmDODesc.class), IAppFwTempTbl.tmp_iaw_26.name());
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
	protected Validator[] getUpdateValidator(BdBltplItmDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
