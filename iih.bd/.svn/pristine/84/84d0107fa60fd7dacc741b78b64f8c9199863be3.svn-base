package iih.bd.pp.cust.s;

import iih.bd.pp.cust.d.CustAggDO;
import iih.bd.pp.cust.d.CustCaDO;
import iih.bd.pp.cust.d.desc.CustCaDODesc;
import iih.bd.pp.cust.i.ICustCudService;
import iih.bd.pp.cust.i.ICustRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 付款客户AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ICustCudService.class, ICustRService.class }, binding = Binding.JSONRPC)
public class CustCrudServiceImpl extends BaseAggService<CustAggDO, CustCaDO> implements ICustCudService, ICustRService {

	public CustCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(CustCaDODesc.class), IAppFwTempTbl.tmp_iaw_14.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(CustAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate(),
				// 子DO删除校验
				AggBDReferenceChecker.getInstance(true, false, true) };
	}

}
