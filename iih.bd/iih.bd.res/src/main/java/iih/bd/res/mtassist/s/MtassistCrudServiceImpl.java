package iih.bd.res.mtassist.s;

import iih.bd.res.mtassist.d.MtAssistDO;
import iih.bd.res.mtassist.d.MtassistAggDO;
import iih.bd.res.mtassist.d.desc.MtAssistDODesc;
import iih.bd.res.mtassist.i.IMtassistCudService;
import iih.bd.res.mtassist.i.IMtassistRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医技辅AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMtassistCudService.class, IMtassistRService.class }, binding = Binding.JSONRPC)
public class MtassistCrudServiceImpl extends BaseAggService<MtassistAggDO, MtAssistDO>
		implements IMtassistCudService, IMtassistRService {
	public MtassistCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MtAssistDODesc.class), IAppFwTempTbl.tmp_iaw_18.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MtassistAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
