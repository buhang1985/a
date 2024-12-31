package iih.mi.mibd.medpaytp.s;

import iih.mi.mibd.medpaytp.d.MedPayTpDO;
import iih.mi.mibd.medpaytp.d.desc.MedPayTpDODesc;
import iih.mi.mibd.medpaytp.i.IMedpaytpCudService;
import iih.mi.mibd.medpaytp.i.IMedpaytpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保平台_医疗付款方式AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMedpaytpCudService.class, IMedpaytpRService.class }, binding = Binding.JSONRPC)
public class MedpaytpCrudServiceImpl extends BaseDOService<MedPayTpDO>
		implements IMedpaytpCudService, IMedpaytpRService {
	public MedpaytpCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MedPayTpDODesc.class), IAppFwTempTbl.tmp_iaw_07.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(MedPayTpDO[] oldDOs) {

		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

}
