package iih.bd.srv.emreditor.s;

import iih.bd.srv.emreditor.d.EmrEditorDO;
import iih.bd.srv.emreditor.d.desc.EmrEditorDODesc;
import iih.bd.srv.emreditor.i.IEmreditorCudService;
import iih.bd.srv.emreditor.i.IEmreditorRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗服务_医疗记录编辑器AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEmreditorCudService.class, IEmreditorRService.class }, binding = Binding.JSONRPC)
public class EmreditorCrudServiceImpl extends BaseDOService<EmrEditorDO>
		implements IEmreditorCudService, IEmreditorRService {

	public EmreditorCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmrEditorDODesc.class), IAppFwTempTbl.tmp_iaw_10.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EmrEditorDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
