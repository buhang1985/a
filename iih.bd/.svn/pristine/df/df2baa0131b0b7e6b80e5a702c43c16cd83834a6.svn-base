package iih.bd.pp.bdcpnca.s;

import iih.bd.pp.bdcpnca.d.BdCpncaDO;
import iih.bd.pp.bdcpnca.d.BdcpncaAggDO;
import iih.bd.pp.bdcpnca.d.desc.BdCpncaDODesc;
import iih.bd.pp.bdcpnca.i.IBdcpncaCudService;
import iih.bd.pp.bdcpnca.i.IBdcpncaRService;
import iih.bd.pp.bdcpnca.s.validator.ProDeleteBdCpncaDOValidator;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 优惠劵_基础数据AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IBdcpncaCudService.class, IBdcpncaRService.class }, binding = Binding.JSONRPC)
public class BdcpncaCrudServiceImpl extends BaseAggService<BdcpncaAggDO, BdCpncaDO> implements IBdcpncaCudService, IBdcpncaRService {

	public BdcpncaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdCpncaDODesc.class), IAppFwTempTbl.tmp_iaw_27.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(BdcpncaAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance(), new ProDeleteBdCpncaDOValidator() };
	}
}
