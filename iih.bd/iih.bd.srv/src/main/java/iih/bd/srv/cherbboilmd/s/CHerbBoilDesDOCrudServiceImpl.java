package iih.bd.srv.cherbboilmd.s;

import iih.bd.srv.cherbboilmd.d.CHerbBoilDesDO;
import iih.bd.srv.cherbboilmd.d.desc.CHerbBoilDesDODesc;
import iih.bd.srv.cherbboilmd.i.ICHerbBoilDesDOCudService;
import iih.bd.srv.cherbboilmd.i.ICHerbBoilDesDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗服务中药煎法主实体CRUD服务实现
 */
@Service(serviceInterfaces = { ICHerbBoilDesDOCudService.class,
		ICHerbBoilDesDORService.class }, binding = Binding.JSONRPC)
public class CHerbBoilDesDOCrudServiceImpl extends BaseDOService<CHerbBoilDesDO>
		implements ICHerbBoilDesDOCudService, ICHerbBoilDesDORService {

	public CHerbBoilDesDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(CHerbBoilDesDODesc.class), IAppFwTempTbl.tmp_iaw_15.name());
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
	protected Validator[] getUpdateValidator(CHerbBoilDesDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
