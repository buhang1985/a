package iih.mi.mibd.medtp.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.medtp.d.desc.MedTpDODesc;
import iih.mi.mibd.medtp.d.MedTpDO;
import iih.mi.mibd.medtp.i.IMedtpCudService;
import iih.mi.mibd.medtp.i.IMedtpRService;

/**
 * 医保平台_医疗类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMedtpCudService.class, IMedtpRService.class }, binding = Binding.JSONRPC)
public class MedtpCrudServiceImpl extends BaseDOService<MedTpDO> implements IMedtpCudService, IMedtpRService {
	public MedtpCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MedTpDODesc.class), IAppFwTempTbl.tmp_iaw_02.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(MedTpDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
