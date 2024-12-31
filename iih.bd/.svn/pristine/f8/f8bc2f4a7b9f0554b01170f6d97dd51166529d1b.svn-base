package iih.bd.srv.itmfst.s;

import iih.bd.srv.itmfst.d.ItmFstDO;
import iih.bd.srv.itmfst.d.desc.ItmFstDODesc;
import iih.bd.srv.itmfst.i.IItmfstCudService;
import iih.bd.srv.itmfst.i.IItmfstRService;
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
@Service(serviceInterfaces = { IItmfstCudService.class, IItmfstRService.class }, binding = Binding.JSONRPC)
public class ItmfstCrudServiceImpl extends BaseDOService<ItmFstDO> implements IItmfstCudService, IItmfstRService {

	public ItmfstCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(ItmFstDODesc.class), IAppFwTempTbl.tmp_iaw_11.name());
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
	protected Validator[] getUpdateValidator(ItmFstDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
