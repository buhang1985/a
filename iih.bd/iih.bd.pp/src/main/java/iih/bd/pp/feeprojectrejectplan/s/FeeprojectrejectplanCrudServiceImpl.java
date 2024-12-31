package iih.bd.pp.feeprojectrejectplan.s;

import iih.bd.pp.feeprojectrejectplan.d.ExclusiveMasterDO;
import iih.bd.pp.feeprojectrejectplan.d.FeeprojectrejectplanAggDO;
import iih.bd.pp.feeprojectrejectplan.d.desc.ExclusiveMasterDODesc;
import iih.bd.pp.feeprojectrejectplan.i.IFeeprojectrejectplanCudService;
import iih.bd.pp.feeprojectrejectplan.i.IFeeprojectrejectplanRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 收费项目排斥方案AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IFeeprojectrejectplanCudService.class,
		IFeeprojectrejectplanRService.class }, binding = Binding.JSONRPC)
public class FeeprojectrejectplanCrudServiceImpl extends BaseAggService<FeeprojectrejectplanAggDO, ExclusiveMasterDO>
		implements IFeeprojectrejectplanCudService, IFeeprojectrejectplanRService {
	public FeeprojectrejectplanCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(ExclusiveMasterDODesc.class), IAppFwTempTbl.tmp_iaw_22.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(FeeprojectrejectplanAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
