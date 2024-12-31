package iih.bd.srv.relmmbagtactics.s;

import iih.bd.srv.relmmbagtactics.d.RelMmBagTacticsDO;
import iih.bd.srv.relmmbagtactics.d.desc.RelMmBagTacticsDODesc;
import iih.bd.srv.relmmbagtactics.i.IRelmmbagtacticsCudService;
import iih.bd.srv.relmmbagtactics.i.IRelmmbagtacticsRService;
import iih.bd.srv.relmmbagtactics.s.bp.RefreshRelMmBagTacticsRelDataBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 药品关联药袋费策略AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IRelmmbagtacticsCudService.class,
		IRelmmbagtacticsRService.class }, binding = Binding.JSONRPC)
public class RelmmbagtacticsCrudServiceImpl extends BaseDOService<RelMmBagTacticsDO>
		implements IRelmmbagtacticsCudService, IRelmmbagtacticsRService {
	public RelmmbagtacticsCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(RelMmBagTacticsDODesc.class), IAppFwTempTbl.tmp_iaw_05.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(RelMmBagTacticsDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	public RelMmBagTacticsDO[] find(String whereStr, String orderStr, FBoolean isLazy) throws BizException {
		RelMmBagTacticsDO[] rtn =  super.find(whereStr, orderStr, isLazy);
		RefreshRelMmBagTacticsRelDataBp bp=new RefreshRelMmBagTacticsRelDataBp();
		bp.exec(rtn);
		return rtn;
	}
}
