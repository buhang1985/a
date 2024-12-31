package iih.bd.srv.srvdc.s;

import iih.bd.srv.srvdc.d.FixedChargePkgDO;
import iih.bd.srv.srvdc.d.desc.FixedChargePkgDODesc;
import iih.bd.srv.srvdc.i.ISrvdcMDOCudService;
import iih.bd.srv.srvdc.i.ISrvdcMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗服务固定收费包主实体CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvdcMDOCudService.class, ISrvdcMDORService.class }, binding = Binding.JSONRPC)
public class SrvdcMDOCrudServiceImpl extends BaseDOService<FixedChargePkgDO>
		implements ISrvdcMDOCudService, ISrvdcMDORService {

	public SrvdcMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(FixedChargePkgDODesc.class), IAppFwTempTbl.tmp_iaw_13.name());
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
	protected Validator[] getUpdateValidator(FixedChargePkgDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
