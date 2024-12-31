package iih.mi.mibd.patca.s;

import iih.mi.mibd.patca.d.PatcaDo;
import iih.mi.mibd.patca.d.desc.PatcaDoDesc;
import iih.mi.mibd.patca.i.IPatcaCudService;
import iih.mi.mibd.patca.i.IPatcaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保平台_患者身份AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IPatcaCudService.class, IPatcaRService.class }, binding = Binding.JSONRPC)
public class PatcaCrudServiceImpl extends BaseDOService<PatcaDo> implements IPatcaCudService, IPatcaRService {
	public PatcaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PatcaDoDesc.class), IAppFwTempTbl.tmp_iaw_16.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(PatcaDo[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
