package iih.bd.srv.srvrtctlcate.s;

import iih.bd.srv.srvrtctlcate.d.SrvRtCtlCateDO;
import iih.bd.srv.srvrtctlcate.d.desc.SrvRtCtlCateDODesc;
import iih.bd.srv.srvrtctlcate.i.ISrvrtctlcateCudService;
import iih.bd.srv.srvrtctlcate.i.ISrvrtctlcateRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 服务项目开立权限分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvrtctlcateCudService.class, ISrvrtctlcateRService.class }, binding = Binding.JSONRPC)
public class SrvrtctlcateCrudServiceImpl extends BaseDOService<SrvRtCtlCateDO>
		implements ISrvrtctlcateCudService, ISrvrtctlcateRService {

	public SrvrtctlcateCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvRtCtlCateDODesc.class), IAppFwTempTbl.tmp_iaw_16.name());
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
	protected Validator[] getUpdateValidator(SrvRtCtlCateDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
