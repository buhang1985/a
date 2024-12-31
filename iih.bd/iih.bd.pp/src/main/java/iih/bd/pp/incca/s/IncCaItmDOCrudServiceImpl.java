package iih.bd.pp.incca.s;

import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.incca.d.desc.IncCaItmDODesc;
import iih.bd.pp.incca.i.IIncCaItmDOCudService;
import iih.bd.pp.incca.i.IIncCaItmDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 票据分类主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IIncCaItmDOCudService.class, IIncCaItmDORService.class }, binding = Binding.JSONRPC)
public class IncCaItmDOCrudServiceImpl extends BaseDOService<IncCaItmDO>
		implements IIncCaItmDOCudService, IIncCaItmDORService {

	public IncCaItmDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(IncCaItmDODesc.class), IAppFwTempTbl.tmp_iaw_26.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(IncCaItmDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

}
