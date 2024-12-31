package iih.bd.srv.srvreact.s;

import iih.bd.srv.srvreact.d.SrvReactDO;
import iih.bd.srv.srvreact.d.SrvreactAggDO;
import iih.bd.srv.srvreact.d.desc.SrvReactDODesc;
import iih.bd.srv.srvreact.i.ISrvreactCudService;
import iih.bd.srv.srvreact.i.ISrvreactRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 服务互斥AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvreactCudService.class, ISrvreactRService.class }, binding = Binding.JSONRPC)
public class SrvreactCrudServiceImpl extends BaseAggService<SrvreactAggDO, SrvReactDO>
		implements ISrvreactCudService, ISrvreactRService {

	public SrvreactCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvReactDODesc.class), IAppFwTempTbl.tmp_iaw_23.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(SrvreactAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
