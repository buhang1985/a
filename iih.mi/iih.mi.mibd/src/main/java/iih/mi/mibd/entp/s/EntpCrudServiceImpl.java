package iih.mi.mibd.entp.s;

import iih.mi.mibd.entp.d.EnTpDO;
import iih.mi.mibd.entp.d.desc.EnTpDODesc;
import iih.mi.mibd.entp.i.IEntpCudService;
import iih.mi.mibd.entp.i.IEntpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保平台_就诊类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEntpCudService.class, IEntpRService.class }, binding = Binding.JSONRPC)
public class EntpCrudServiceImpl extends BaseDOService<EnTpDO> implements IEntpCudService, IEntpRService {
	public EntpCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EnTpDODesc.class), IAppFwTempTbl.tmp_iaw_03.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(EnTpDO[] oldDOs) {

		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
