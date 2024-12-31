package iih.bd.res.depcont.s;

import java.util.Arrays;

import iih.bd.res.depcont.d.DepContDO;
import iih.bd.res.depcont.d.desc.DepContDODesc;
import iih.bd.res.depcont.i.IDepcontMDOCudService;
import iih.bd.res.depcont.i.IDepcontMDORService;
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
 * 医技科室对照主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IDepcontMDOCudService.class,
		IDepcontMDORService.class }, binding = Binding.JSONRPC)
public class DepcontMDOCrudServiceImpl extends BaseDOService<DepContDO>
		implements IDepcontMDOCudService, IDepcontMDORService {

	public DepcontMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DepContDODesc.class),
				IAppFwTempTbl.tmp_iaw_26.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {

		return new Validator[] {
				new BDUniqueRuleValidate(),
				NullValueValidator.createMDNullValueValidator(
						new DepContDO().getDODesc(),
						Arrays.asList(DepContDO.NAME, DepContDO.CODE)) };
	}

	@Override
	protected Validator[] getUpdateValidator(DepContDO[] oldDos) {

		return new Validator[] {
				new BDUniqueRuleValidate(),
				NullValueValidator.createMDNullValueValidator(
						new DepContDO().getDODesc(),
						Arrays.asList(DepContDO.NAME, DepContDO.CODE)) };
	}
}
