package iih.bd.srv.srvskintestrel.s;

import iih.bd.srv.srvskintestrel.d.SrvSkinTestRelDO;
import iih.bd.srv.srvskintestrel.d.desc.SrvSkinTestRelDODesc;
import iih.bd.srv.srvskintestrel.i.ISrvskintestrelCudService;
import iih.bd.srv.srvskintestrel.i.ISrvskintestrelRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗服务_过敏分类和皮试项目对照关系AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvskintestrelCudService.class,
		ISrvskintestrelRService.class }, binding = Binding.JSONRPC)
public class SrvskintestrelCrudServiceImpl extends BaseDOService<SrvSkinTestRelDO>
		implements ISrvskintestrelCudService, ISrvskintestrelRService {
	public SrvskintestrelCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvSkinTestRelDODesc.class), IAppFwTempTbl.tmp_iaw_12.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(SrvSkinTestRelDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
