package iih.bd.srv.srvdc.s;

import iih.bd.srv.srvdc.d.FixedChargePkgDO;
import iih.bd.srv.srvdc.d.SrvdcAggDO;
import iih.bd.srv.srvdc.d.desc.FixedChargePkgDODesc;
import iih.bd.srv.srvdc.i.ISrvdcCudService;
import iih.bd.srv.srvdc.i.ISrvdcRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗服务固定收费包AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvdcCudService.class, ISrvdcRService.class }, binding = Binding.JSONRPC)
public class SrvdcCrudServiceImpl extends BaseAggService<SrvdcAggDO, FixedChargePkgDO>
		implements ISrvdcCudService, ISrvdcRService {
	public SrvdcCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(FixedChargePkgDODesc.class), IAppFwTempTbl.tmp_iaw_22.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(SrvdcAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}
}
