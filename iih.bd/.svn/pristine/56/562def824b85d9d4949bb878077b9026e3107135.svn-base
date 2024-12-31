package iih.bd.pp.srvmpayratio.s;

import iih.bd.pp.srvmpayratio.d.SrvMPayRatioDO;
import iih.bd.pp.srvmpayratio.d.desc.SrvMPayRatioDODesc;
import iih.bd.pp.srvmpayratio.i.ISrvmpayratioCudService;
import iih.bd.pp.srvmpayratio.i.ISrvmpayratioRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保计划_服务多支付比例AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvmpayratioCudService.class, ISrvmpayratioRService.class }, binding = Binding.JSONRPC)
public class SrvmpayratioCrudServiceImpl extends BaseDOService<SrvMPayRatioDO>
		implements ISrvmpayratioCudService, ISrvmpayratioRService {
	public SrvmpayratioCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvMPayRatioDODesc.class), IAppFwTempTbl.tmp_iaw_08.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(SrvMPayRatioDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
