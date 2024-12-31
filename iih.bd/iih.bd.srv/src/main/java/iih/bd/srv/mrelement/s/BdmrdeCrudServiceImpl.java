package iih.bd.srv.mrelement.s;

import iih.bd.srv.mrelement.d.BdmrdeAggDO;
import iih.bd.srv.mrelement.d.MrElementDO;
import iih.bd.srv.mrelement.d.desc.MrElementDODesc;
import iih.bd.srv.mrelement.i.IBdmrdeCudService;
import iih.bd.srv.mrelement.i.IBdmrdeRService;
import iih.bd.srv.mrelement.s.validator.BdmrdeValidator;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IBdmrdeCudService.class, IBdmrdeRService.class }, binding = Binding.JSONRPC)
public class BdmrdeCrudServiceImpl extends BaseAggService<BdmrdeAggDO, MrElementDO>
		implements IBdmrdeCudService, IBdmrdeRService {

	public BdmrdeCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MrElementDODesc.class), IAppFwTempTbl.tmp_iaw_19.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), new BdmrdeValidator()};
	}

	@Override
	protected Validator[] getUpdateValidator(BdmrdeAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate(), new BdmrdeValidator()};
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}
    
}
