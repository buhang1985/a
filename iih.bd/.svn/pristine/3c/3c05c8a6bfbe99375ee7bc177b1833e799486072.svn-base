package iih.bd.srv.dividelevel.s;

import iih.bd.srv.dividelevel.d.DivideLevelDO;
import iih.bd.srv.dividelevel.d.desc.DivideLevelDODesc;
import iih.bd.srv.dividelevel.i.IDividelevelCudService;
import iih.bd.srv.dividelevel.i.IDividelevelRService;
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
@Service(serviceInterfaces = { IDividelevelCudService.class, IDividelevelRService.class }, binding = Binding.JSONRPC)
public class DividelevelCrudServiceImpl extends BaseDOService<DivideLevelDO>
		implements IDividelevelCudService, IDividelevelRService {

	public DividelevelCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DivideLevelDODesc.class), IAppFwTempTbl.tmp_iaw_13.name());
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
	protected Validator[] getUpdateValidator(DivideLevelDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
