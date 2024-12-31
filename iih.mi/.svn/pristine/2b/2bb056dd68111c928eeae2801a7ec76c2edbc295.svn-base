package iih.mi.mc.mimctactics.s;

import iih.mi.mc.mimctactics.d.MiMcTacticsDO;
import iih.mi.mc.mimctactics.d.MimctacticsAggDO;
import iih.mi.mc.mimctactics.d.desc.MiMcTacticsDODesc;
import iih.mi.mc.mimctactics.i.IMimctacticsCudService;
import iih.mi.mc.mimctactics.i.IMimctacticsRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保策略库AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMimctacticsCudService.class, IMimctacticsRService.class }, binding = Binding.JSONRPC)
public class MimctacticsCrudServiceImpl extends BaseAggService<MimctacticsAggDO, MiMcTacticsDO>
		implements IMimctacticsCudService, IMimctacticsRService {
	public MimctacticsCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MiMcTacticsDODesc.class), IAppFwTempTbl.tmp_iaw_06.name());
	}

	@Override
	protected Validator[] getInsertValidator() {

		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MimctacticsAggDO[] oldDOs) {
		// TODO Auto-generated method stub
		return new Validator[]{ new BDUniqueRuleValidate() };
	}
	
	
}
