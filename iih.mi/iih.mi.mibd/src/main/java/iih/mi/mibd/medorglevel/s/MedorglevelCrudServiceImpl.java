package iih.mi.mibd.medorglevel.s;

import iih.mi.mibd.medorglevel.d.MedOrgLevelDO;
import iih.mi.mibd.medorglevel.d.desc.MedOrgLevelDODesc;
import iih.mi.mibd.medorglevel.i.IMedorglevelCudService;
import iih.mi.mibd.medorglevel.i.IMedorglevelRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保平台_医疗机构级别AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMedorglevelCudService.class, IMedorglevelRService.class }, binding = Binding.JSONRPC)
public class MedorglevelCrudServiceImpl extends BaseDOService<MedOrgLevelDO>
		implements IMedorglevelCudService, IMedorglevelRService {
	public MedorglevelCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MedOrgLevelDODesc.class), IAppFwTempTbl.tmp_iaw_13.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(MedOrgLevelDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
