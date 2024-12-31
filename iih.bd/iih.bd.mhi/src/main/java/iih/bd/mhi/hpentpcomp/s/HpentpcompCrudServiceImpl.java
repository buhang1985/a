package iih.bd.mhi.hpentpcomp.s;

import iih.bd.mhi.hpentpcomp.d.HpEntpCompDO;
import iih.bd.mhi.hpentpcomp.d.desc.HpEntpCompDODesc;
import iih.bd.mhi.hpentpcomp.i.IHpentpcompCudService;
import iih.bd.mhi.hpentpcomp.i.IHpentpcompRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保产品就诊类型对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IHpentpcompCudService.class, IHpentpcompRService.class }, binding = Binding.JSONRPC)
public class HpentpcompCrudServiceImpl extends BaseDOService<HpEntpCompDO>
		implements IHpentpcompCudService, IHpentpcompRService {
	public HpentpcompCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(HpEntpCompDODesc.class), IAppFwTempTbl.tmp_iaw_15.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(HpEntpCompDO[] oldDOs) {

		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
