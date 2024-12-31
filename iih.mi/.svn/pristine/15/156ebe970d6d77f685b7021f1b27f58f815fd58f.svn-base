package iih.mi.mibd.medorg.s;

import iih.mi.mibd.medorg.d.MedorgDo;
import iih.mi.mibd.medorg.d.desc.MedorgDoDesc;
import iih.mi.mibd.medorg.i.IMedorgCudService;
import iih.mi.mibd.medorg.i.IMedorgRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保平台_医疗机构AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMedorgCudService.class, IMedorgRService.class }, binding = Binding.JSONRPC)
public class MedorgCrudServiceImpl extends BaseDOService<MedorgDo> implements IMedorgCudService, IMedorgRService {
	public MedorgCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MedorgDoDesc.class), IAppFwTempTbl.tmp_iaw_27.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(MedorgDo[] oldDOs) {

		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

}
