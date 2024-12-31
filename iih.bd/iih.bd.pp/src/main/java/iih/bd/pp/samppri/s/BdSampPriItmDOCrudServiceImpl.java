package iih.bd.pp.samppri.s;

import iih.bd.pp.s.bp.CommUpdateSrvPriBp;
import iih.bd.pp.samppri.d.BdSampPriItmDO;
import iih.bd.pp.samppri.d.desc.BdSampPriItmDODesc;
import iih.bd.pp.samppri.i.IBdSampPriItmDOCudService;
import iih.bd.pp.samppri.i.IBdSampPriItmDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 标本费用对照主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IBdSampPriItmDOCudService.class,
		IBdSampPriItmDORService.class }, binding = Binding.JSONRPC)
public class BdSampPriItmDOCrudServiceImpl extends BaseDOService<BdSampPriItmDO>
		implements IBdSampPriItmDOCudService, IBdSampPriItmDORService {

	public BdSampPriItmDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdSampPriItmDODesc.class), IAppFwTempTbl.tmp_iaw_09.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	public BdSampPriItmDO[] find(String whereStr, String orderStr, FBoolean isLazy) throws BizException {
		BdSampPriItmDO[] rtn = super.find(whereStr, orderStr, isLazy);
		updatePri(rtn);
		return rtn;
	}

	@Override
	public BdSampPriItmDO[] findByAttrValString(String attr, String value) throws BizException {
		BdSampPriItmDO[] rtn = super.findByAttrValString(attr, value);
		updatePri(rtn);
		return rtn;
	}

	/**
	 * 更新价格信息
	 * 
	 * @param rtn
	 * @throws BizException
	 */
	private void updatePri(BdSampPriItmDO[] rtn) throws BizException {
		CommUpdateSrvPriBp bp = new CommUpdateSrvPriBp();
		bp.exec(rtn, BdSampPriItmDO.ID_SRV, BdSampPriItmDO.PRI_STD);
	}
}
