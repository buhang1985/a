package iih.bd.fc.wf.s;

import iih.bd.fc.wf.d.WfDepDO;
import iih.bd.fc.wf.d.desc.WfDepDODesc;
import iih.bd.fc.wf.i.IWfDepDOCudService;
import iih.bd.fc.wf.i.IWfDepDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 流程配置_医嘱流向主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IWfDepDOCudService.class, IWfDepDORService.class }, binding = Binding.JSONRPC)
public class WfDepDOCrudServiceImpl extends BaseDOService<WfDepDO> implements IWfDepDOCudService, IWfDepDORService {

	public WfDepDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(WfDepDODesc.class), IAppFwTempTbl.tmp_iaw_05.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
