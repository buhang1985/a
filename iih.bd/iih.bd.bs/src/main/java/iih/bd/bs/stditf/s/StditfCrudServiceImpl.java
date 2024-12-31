package iih.bd.bs.stditf.s;

import iih.bd.bs.stditf.d.BdStdItfDO;
import iih.bd.bs.stditf.d.desc.BdStdItfDODesc;
import iih.bd.bs.stditf.i.IStditfCudService;
import iih.bd.bs.stditf.i.IStditfRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 基础数据标准接口AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IStditfCudService.class, IStditfRService.class }, binding = Binding.JSONRPC)
public class StditfCrudServiceImpl extends BaseDOService<BdStdItfDO> implements IStditfCudService, IStditfRService {
	public StditfCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdStdItfDODesc.class), IAppFwTempTbl.tmp_iaw_15.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(BdStdItfDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
