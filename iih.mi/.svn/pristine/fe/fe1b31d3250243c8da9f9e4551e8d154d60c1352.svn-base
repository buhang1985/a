package iih.mi.mibd.mis.s;

import iih.mi.mibd.mis.d.MisDO;
import iih.mi.mibd.mis.d.desc.MisDODesc;
import iih.mi.mibd.mis.i.IMisCudService;
import iih.mi.mibd.mis.i.IMisRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保平台_医保系统AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMisCudService.class, IMisRService.class }, binding = Binding.JSONRPC)
public class MisCrudServiceImpl extends BaseDOService<MisDO> implements IMisCudService, IMisRService {
	public MisCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MisDODesc.class), IAppFwTempTbl.tmp_iaw_14.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MisDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

}
