package iih.bd.srv.medsrv.s;

import iih.bd.srv.medsrv.d.MedSrvBloodDO;
import iih.bd.srv.medsrv.d.desc.MedSrvBloodDODesc;
import iih.bd.srv.medsrv.i.IMedSrvBloodDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvBloodDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗服务主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IMedSrvBloodDOCudService.class,
		IMedSrvBloodDORService.class }, binding = Binding.JSONRPC)
public class MedSrvBloodDOCrudServiceImpl extends BaseDOService<MedSrvBloodDO>
		implements IMedSrvBloodDOCudService, IMedSrvBloodDORService {

	public MedSrvBloodDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MedSrvBloodDODesc.class), IAppFwTempTbl.tmp_iaw_19.name());
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
	protected Validator[] getUpdateValidator(MedSrvBloodDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
