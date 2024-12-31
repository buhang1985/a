package iih.bd.srv.mrfpbltype.s;

import iih.bd.srv.mrfpbltype.d.MrFpBlTypeDO;
import iih.bd.srv.mrfpbltype.d.desc.MrFpBlTypeDODesc;
import iih.bd.srv.mrfpbltype.i.IMrfpbltypeMDOCudService;
import iih.bd.srv.mrfpbltype.i.IMrfpbltypeMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 病案首页费用分类主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IMrfpbltypeMDOCudService.class,
		IMrfpbltypeMDORService.class }, binding = Binding.JSONRPC)
public class MrfpbltypeMDOCrudServiceImpl extends TreeBaseDOService<MrFpBlTypeDO>
		implements IMrfpbltypeMDOCudService, IMrfpbltypeMDORService {

	public MrfpbltypeMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MrFpBlTypeDODesc.class), IAppFwTempTbl.tmp_iaw_19.name());
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
	protected Validator[] getUpdateValidator(MrFpBlTypeDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
