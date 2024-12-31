package iih.bd.srv.srvreact.s;

import java.util.Arrays;

import iih.bd.srv.srvreact.d.SrvReactDO;
import iih.bd.srv.srvreact.d.desc.SrvReactDODesc;
import iih.bd.srv.srvreact.i.ISrvreactMDOCudService;
import iih.bd.srv.srvreact.i.ISrvreactMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.NullValueValidator;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 服务互斥主实体CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvreactMDOCudService.class, ISrvreactMDORService.class }, binding = Binding.JSONRPC)
public class SrvreactMDOCrudServiceImpl extends BaseDOService<SrvReactDO>
		implements ISrvreactMDOCudService, ISrvreactMDORService {

	public SrvreactMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvReactDODesc.class), IAppFwTempTbl.tmp_iaw_14.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), NullValueValidator.createMDNullValueValidator(
				new SrvReactDO().getDODesc(), Arrays.asList(SrvReactDO.NAME, SrvReactDO.CODE)) };
	}

	@Override
	protected Validator[] getUpdateValidator(SrvReactDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate(), NullValueValidator.createMDNullValueValidator(
				new SrvReactDO().getDODesc(), Arrays.asList(SrvReactDO.NAME, SrvReactDO.CODE)) };
	}

}
