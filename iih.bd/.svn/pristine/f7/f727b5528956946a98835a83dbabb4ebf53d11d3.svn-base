package iih.bd.srv.emrtype.s;

import iih.bd.srv.emrtype.d.MrTpDO;
import iih.bd.srv.emrtype.d.desc.MrTpDODesc;
import iih.bd.srv.emrtype.i.IEmrtypeCudService;
import iih.bd.srv.emrtype.i.IEmrtypeRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗记录类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEmrtypeCudService.class, IEmrtypeRService.class }, binding = Binding.JSONRPC)
public class EmrtypeCrudServiceImpl extends TreeBaseDOService<MrTpDO> implements IEmrtypeCudService, IEmrtypeRService {
	public EmrtypeCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MrTpDODesc.class), IAppFwTempTbl.tmp_iaw_07.name());
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
	protected Validator[] getUpdateValidator(MrTpDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
