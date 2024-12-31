package iih.mi.mibd.medkind.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.medkind.d.desc.MedkindDODesc;
import iih.mi.mibd.medkind.d.MedkindDO;
import iih.mi.mibd.medkind.i.IMedkindCudService;
import iih.mi.mibd.medkind.i.IMedkindRService;

/**
 * 医保平台_医疗类别AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMedkindCudService.class, IMedkindRService.class }, binding = Binding.JSONRPC)
public class MedkindCrudServiceImpl extends BaseDOService<MedkindDO> implements IMedkindCudService, IMedkindRService {
	public MedkindCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MedkindDODesc.class), IAppFwTempTbl.tmp_iaw_26.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(MedkindDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

}
