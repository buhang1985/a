package iih.bd.pp.pripat.s;

import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.pp.pripat.d.desc.PriPatDODesc;
import iih.bd.pp.pripat.i.IPripatMDOCudService;
import iih.bd.pp.pripat.i.IPripatMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 患者价格分类主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IPripatMDOCudService.class, IPripatMDORService.class }, binding = Binding.JSONRPC)
public class PripatMDOCrudServiceImpl extends BaseDOService<PriPatDO>
		implements IPripatMDOCudService, IPripatMDORService {

	public PripatMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PriPatDODesc.class), IAppFwTempTbl.tmp_iaw_23.name());
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
	protected Validator[] getUpdateValidator(PriPatDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

}
