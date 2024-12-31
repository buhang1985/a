package iih.bd.pp.cust.s;

import iih.bd.pp.cust.d.CustCaDO;
import iih.bd.pp.cust.d.desc.CustCaDODesc;
import iih.bd.pp.cust.i.ICustMDOCudService;
import iih.bd.pp.cust.i.ICustMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 付款客户主实体CRUD服务实现
 */
@Service(serviceInterfaces = { ICustMDOCudService.class, ICustMDORService.class }, binding = Binding.JSONRPC)
public class CustMDOCrudServiceImpl extends BaseDOService<CustCaDO> implements ICustMDOCudService, ICustMDORService {

	public CustMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(CustCaDODesc.class), IAppFwTempTbl.tmp_iaw_07.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(CustCaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

}
