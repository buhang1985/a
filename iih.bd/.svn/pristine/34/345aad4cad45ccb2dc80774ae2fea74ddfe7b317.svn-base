package iih.bd.pp.pripat.s;

import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.pp.pripat.d.desc.PriPatDODesc;
import iih.bd.pp.pripat.i.IPripatCudService;
import iih.bd.pp.pripat.i.IPripatRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 患者价格分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IPripatCudService.class, IPripatRService.class }, binding = Binding.JSONRPC)
public class PripatCrudServiceImpl extends BaseAggService<PripatAggDO, PriPatDO>
		implements IPripatCudService, IPripatRService {

	public PripatCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PriPatDODesc.class), IAppFwTempTbl.tmp_iaw_25.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(PripatAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}
}
