package iih.bd.pp.priusg.s;

import iih.bd.pp.priusg.d.PriUsgDO;
import iih.bd.pp.priusg.d.desc.PriUsgDODesc;
import iih.bd.pp.priusg.i.IPriusgCudService;
import iih.bd.pp.priusg.i.IPriusgRService;
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
 * 用法下费用对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IPriusgCudService.class, IPriusgRService.class }, binding = Binding.JSONRPC)
public class PriusgCrudServiceImpl extends BaseDOService<PriUsgDO> implements IPriusgCudService, IPriusgRService {

	public PriusgCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PriUsgDODesc.class), IAppFwTempTbl.tmp_iaw_22.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(PriUsgDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	public PriUsgDO[] find(String whereStr, String orderStr, FBoolean isLazy) throws BizException {
		PriUsgDO[] rtn = super.find(whereStr, orderStr, isLazy);
		updatePri(rtn);
		return rtn;
	}

	@Override
	public PriUsgDO[] findByAttrValString(String attr, String value) throws BizException {
		PriUsgDO[] rtn = super.findByAttrValString(attr, value);
		updatePri(rtn);
		return rtn;
	}

	/**
	 * 更新价格信息
	 * 
	 * @param rtn
	 * @throws BizException
	 */
	private void updatePri(PriUsgDO[] rtn) throws BizException {
		CommUpdateSrvPriBp bp = new CommUpdateSrvPriBp();
		bp.exec(rtn, PriUsgDO.ID_SRV, PriUsgDO.PRI_STD);
	}
}
