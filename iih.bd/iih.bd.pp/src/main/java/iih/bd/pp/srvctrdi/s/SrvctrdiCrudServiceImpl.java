package iih.bd.pp.srvctrdi.s;

import iih.bd.pp.srvctrdi.d.BdHpSrvCtrDiDO;
import iih.bd.pp.srvctrdi.d.desc.BdHpSrvCtrDiDODesc;
import iih.bd.pp.srvctrdi.i.ISrvctrdiCudService;
import iih.bd.pp.srvctrdi.i.ISrvctrdiRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 付款策略_医保计划_服务控制_诊断AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvctrdiCudService.class, ISrvctrdiRService.class }, binding = Binding.JSONRPC)
public class SrvctrdiCrudServiceImpl extends BaseDOService<BdHpSrvCtrDiDO>
		implements ISrvctrdiCudService, ISrvctrdiRService {
	public SrvctrdiCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdHpSrvCtrDiDODesc.class), IAppFwTempTbl.tmp_iaw_25.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(BdHpSrvCtrDiDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
	
}
