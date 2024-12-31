package iih.bd.mhi.hpentp.s;

import iih.bd.mhi.hpentp.d.HpEnTpDO;
import iih.bd.mhi.hpentp.d.desc.HpEnTpDODesc;
import iih.bd.mhi.hpentp.i.IHpentpCudService;
import iih.bd.mhi.hpentp.i.IHpentpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保产品_就诊类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IHpentpCudService.class, IHpentpRService.class }, binding = Binding.JSONRPC)
public class HpentpCrudServiceImpl extends BaseDOService<HpEnTpDO> implements IHpentpCudService, IHpentpRService {
	public HpentpCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(HpEnTpDODesc.class), IAppFwTempTbl.tmp_iaw_03.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(HpEnTpDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
