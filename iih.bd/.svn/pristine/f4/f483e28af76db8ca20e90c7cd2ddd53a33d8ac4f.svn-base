package iih.bd.srv.cherbboilmd.s;

import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.srv.cherbboilmd.d.CherbboilmdAggDO;
import iih.bd.srv.cherbboilmd.d.desc.CHerbBoilMdDODesc;
import iih.bd.srv.cherbboilmd.i.ICherbboilmdCudService;
import iih.bd.srv.cherbboilmd.i.ICherbboilmdRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗服务中药煎法AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ICherbboilmdCudService.class, ICherbboilmdRService.class }, binding = Binding.JSONRPC)
public class CherbboilmdCrudServiceImpl extends BaseAggService<CherbboilmdAggDO, CHerbBoilMdDO>
		implements ICherbboilmdCudService, ICherbboilmdRService {
	public CherbboilmdCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(CHerbBoilMdDODesc.class), IAppFwTempTbl.tmp_iaw_11.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(CherbboilmdAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}
}
