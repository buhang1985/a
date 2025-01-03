package iih.bd.pp.bdprewarn.s;

import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.pp.bdprewarn.d.BdprewarnAggDO;
import iih.bd.pp.bdprewarn.d.desc.BdPreWarnDODesc;
import iih.bd.pp.bdprewarn.i.IBdprewarnCudService;
import iih.bd.pp.bdprewarn.i.IBdprewarnRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**S
 * 预交金警告策略AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IBdprewarnCudService.class, IBdprewarnRService.class }, binding = Binding.JSONRPC)
public class BdprewarnCrudServiceImpl extends BaseAggService<BdprewarnAggDO, BdPreWarnDO>
		implements IBdprewarnCudService, IBdprewarnRService {
	public BdprewarnCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdPreWarnDODesc.class), IAppFwTempTbl.tmp_iaw_27.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(BdprewarnAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
