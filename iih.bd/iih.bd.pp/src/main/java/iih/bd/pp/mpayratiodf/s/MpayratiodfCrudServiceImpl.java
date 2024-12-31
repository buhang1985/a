package iih.bd.pp.mpayratiodf.s;

import iih.bd.pp.mpayratiodf.d.MPayRatioDfDO;
import iih.bd.pp.mpayratiodf.d.desc.MPayRatioDfDODesc;
import iih.bd.pp.mpayratiodf.i.IMpayratiodfCudService;
import iih.bd.pp.mpayratiodf.i.IMpayratiodfRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保计划_多支付比例字典AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMpayratiodfCudService.class, IMpayratiodfRService.class }, binding = Binding.JSONRPC)
public class MpayratiodfCrudServiceImpl extends BaseDOService<MPayRatioDfDO>
		implements IMpayratiodfCudService, IMpayratiodfRService {
	public MpayratiodfCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MPayRatioDfDODesc.class), IAppFwTempTbl.tmp_iaw_03.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MPayRatioDfDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
