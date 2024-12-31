package iih.bd.fc.wf.s;

import iih.bd.fc.wf.d.WfDO;
import iih.bd.fc.wf.d.desc.WfDODesc;
import iih.bd.fc.wf.i.IWfMDOCudService;
import iih.bd.fc.wf.i.IWfMDORService;
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
@Service(serviceInterfaces = { IWfMDOCudService.class, IWfMDORService.class }, binding = Binding.JSONRPC)
public class WfMDOCrudServiceImpl extends BaseDOService<WfDO> implements
		IWfMDOCudService, IWfMDORService {

	public WfMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(WfDODesc.class),
				IAppFwTempTbl.tmp_iaw_07.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
