package iih.bd.srv.emrterm.s;

import iih.bd.srv.emrterm.d.EmrTermCaDO;
import iih.bd.srv.emrterm.d.desc.EmrTermCaDODesc;
import iih.bd.srv.emrterm.i.IEmrtermcaMDOCudService;
import iih.bd.srv.emrterm.i.IEmrtermcaMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 病历术语分类主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IEmrtermcaMDOCudService.class, IEmrtermcaMDORService.class }, binding = Binding.JSONRPC)
public class EmrtermcaMDOCrudServiceImpl extends TreeBaseDOService<EmrTermCaDO>
		implements IEmrtermcaMDOCudService, IEmrtermcaMDORService {

	public EmrtermcaMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmrTermCaDODesc.class), IAppFwTempTbl.tmp_iaw_17.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(EmrTermCaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
