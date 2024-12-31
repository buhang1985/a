package iih.bd.srv.medusage.s;

import java.util.Arrays;

import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.d.desc.MedUsageDODesc;
import iih.bd.srv.medusage.i.IMedusageCudService;
import iih.bd.srv.medusage.i.IMedusageRService;
import iih.bd.srv.medusage.s.rule.MedUsageUpdateBeforeCompareRule;
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
 * 医疗服务_医疗用法AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMedusageCudService.class, IMedusageRService.class }, binding = Binding.JSONRPC)
public class MedusageCrudServiceImpl extends BaseDOService<MedUsageDO>
		implements IMedusageCudService, IMedusageRService {

	public MedusageCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MedUsageDODesc.class), IAppFwTempTbl.tmp_iaw_20.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), NullValueValidator.createMDNullValueValidator(
				new MedUsageDO().getDODesc(), Arrays.asList(MedUsageDO.NAME, MedUsageDO.CODE)) };
	}

	@Override
	protected Validator[] getUpdateValidator(MedUsageDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate(), NullValueValidator.createMDNullValueValidator(
				new MedUsageDO().getDODesc(), Arrays.asList(MedUsageDO.NAME, MedUsageDO.CODE)) };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<MedUsageDO> processer, MedUsageDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new MedUsageUpdateBeforeCompareRule());
	}

}
