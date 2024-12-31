package iih.bd.pp.incca.s;

import iih.bd.pp.incca.d.IncCaDO;
import iih.bd.pp.incca.d.desc.IncCaDODesc;
import iih.bd.pp.incca.i.IInccaMDOCudService;
import iih.bd.pp.incca.i.IInccaMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 票据分类主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IInccaMDOCudService.class, IInccaMDORService.class }, binding = Binding.JSONRPC)
public class InccaMDOCrudServiceImpl extends BaseDOService<IncCaDO> implements IInccaMDOCudService, IInccaMDORService {

	public InccaMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(IncCaDODesc.class), IAppFwTempTbl.tmp_iaw_07.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(IncCaDO[] oldDOs) {

		return new Validator[] { new BDUniqueRuleValidate() };

	}

	
}
