package iih.bd.srv.emrterm.s;

import iih.bd.srv.emrterm.d.EmrTermDO;
import iih.bd.srv.emrterm.d.desc.EmrTermDODesc;
import iih.bd.srv.emrterm.i.IEmrtermCudService;
import iih.bd.srv.emrterm.i.IEmrtermRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 病历术语AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEmrtermCudService.class, IEmrtermRService.class }, binding = Binding.JSONRPC)
public class EmrtermCrudServiceImpl extends BaseDOService<EmrTermDO> implements IEmrtermCudService, IEmrtermRService {
	public EmrtermCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmrTermDODesc.class), IAppFwTempTbl.tmp_iaw_24.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(EmrTermDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
