package iih.bd.srv.ortpl.s;

import iih.bd.srv.ortpl.d.OrTmplCaDO;
import iih.bd.srv.ortpl.d.desc.OrTmplCaDODesc;
import iih.bd.srv.ortpl.i.IOrtmplcaCudService;
import iih.bd.srv.ortpl.i.IOrtmplcaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医嘱模板分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IOrtmplcaCudService.class, IOrtmplcaRService.class }, binding = Binding.JSONRPC)
public class OrtmplcaCrudServiceImpl extends TreeBaseDOService<OrTmplCaDO>
		implements IOrtmplcaCudService, IOrtmplcaRService {

	public OrtmplcaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(OrTmplCaDODesc.class), IAppFwTempTbl.tmp_iaw_21.name());
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
	protected Validator[] getUpdateValidator(OrTmplCaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
