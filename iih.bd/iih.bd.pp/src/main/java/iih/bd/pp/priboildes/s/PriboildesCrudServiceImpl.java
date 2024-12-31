package iih.bd.pp.priboildes.s;

import iih.bd.pp.priboildes.d.BdPriBoilDesDO;
import iih.bd.pp.priboildes.d.desc.BdPriBoilDesDODesc;
import iih.bd.pp.priboildes.i.IPriboildesCudService;
import iih.bd.pp.priboildes.i.IPriboildesRService;
import iih.bd.pp.s.bp.CommUpdateSrvPriBp;
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
 * 煎法要求费用对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IPriboildesCudService.class, IPriboildesRService.class }, binding = Binding.JSONRPC)
public class PriboildesCrudServiceImpl extends BaseDOService<BdPriBoilDesDO>
		implements IPriboildesCudService, IPriboildesRService {
	public PriboildesCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdPriBoilDesDODesc.class), IAppFwTempTbl.tmp_iaw_15.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(BdPriBoilDesDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	public BdPriBoilDesDO[] find(String whereStr, String orderStr, FBoolean isLazy) throws BizException {
		BdPriBoilDesDO[] rtn = super.find(whereStr, orderStr, isLazy);
		updatePri(rtn);
		return rtn;
	}

	@Override
	public BdPriBoilDesDO[] findByAttrValString(String attr, String value) throws BizException {
		BdPriBoilDesDO[] rtn = super.findByAttrValString(attr, value);
		updatePri(rtn);
		return rtn;
	}

	/**
	 * 更新价格信息
	 * 
	 * @param rtn
	 * @throws BizException
	 */
	private void updatePri(BdPriBoilDesDO[] rtn) throws BizException {
		CommUpdateSrvPriBp bp = new CommUpdateSrvPriBp();
		bp.exec(rtn, BdPriBoilDesDO.ID_SRV, BdPriBoilDesDO.PRI_STD);
	}
}
