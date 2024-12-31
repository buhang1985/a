package iih.bd.srv.ems.s;

import iih.bd.srv.ems.d.EmsPrnTmplCaDO;
import iih.bd.srv.ems.d.desc.EmsPrnTmplCaDODesc;
import iih.bd.srv.ems.i.IEmsprntmplcaCudService;
import iih.bd.srv.ems.i.IEmsprntmplcaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗单打印模板管理分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEmsprntmplcaCudService.class, IEmsprntmplcaRService.class }, binding = Binding.JSONRPC)
public class EmsprntmplcaCrudServiceImpl extends TreeBaseDOService<EmsPrnTmplCaDO>
		implements IEmsprntmplcaCudService, IEmsprntmplcaRService {
	public EmsprntmplcaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmsPrnTmplCaDODesc.class), IAppFwTempTbl.tmp_iaw_02.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EmsPrnTmplCaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
