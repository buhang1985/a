package iih.bd.bc.cdsys.s;

import java.util.Arrays;

import iih.bd.bc.cdsys.d.MedCdSystemDO;
import iih.bd.bc.cdsys.d.desc.MedCdSystemDODesc;
import iih.bd.bc.cdsys.i.ICdsysCudService;
import iih.bd.bc.cdsys.i.ICdsysRService;
import iih.bd.bc.cdsys.s.rule.DiCdSysAfterDisableRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.NullValueValidator;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗编码标准AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ICdsysCudService.class, ICdsysRService.class }, binding = Binding.JSONRPC)
public class CdsysCrudServiceImpl extends BaseDOService<MedCdSystemDO> implements ICdsysCudService, ICdsysRService {

	public CdsysCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MedCdSystemDODesc.class), IAppFwTempTbl.tmp_iaw_07.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), NullValueValidator.createMDNullValueValidator(
				new MedCdSystemDO().getDODesc(), Arrays.asList(MedCdSystemDO.NAME, MedCdSystemDO.CODE)) };
	}

	@Override
	protected Validator[] getUpdateValidator(MedCdSystemDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate(), NullValueValidator.createMDNullValueValidator(
				new MedCdSystemDO().getDODesc(), Arrays.asList(MedCdSystemDO.NAME, MedCdSystemDO.CODE)) };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<MedCdSystemDO> processor, MedCdSystemDO[] originvos) {
		super.addUpdateAfterRule(processor, originvos);
		processor.addAfterRule(new DiCdSysAfterDisableRule());
	}
}
