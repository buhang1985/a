package iih.bd.mhi.hpsrvselfpayfree.s;

import iih.bd.mhi.hpsrvselfpayfree.d.HpSrvSelfPayFreeDO;
import iih.bd.mhi.hpsrvselfpayfree.d.desc.HpSrvSelfPayFreeDODesc;
import iih.bd.mhi.hpsrvselfpayfree.i.IHpsrvselfpayfreeCudService;
import iih.bd.mhi.hpsrvselfpayfree.i.IHpsrvselfpayfreeRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保计划自付部分减免AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IHpsrvselfpayfreeCudService.class,
		IHpsrvselfpayfreeRService.class }, binding = Binding.JSONRPC)
public class HpsrvselfpayfreeCrudServiceImpl extends BaseDOService<HpSrvSelfPayFreeDO>
		implements IHpsrvselfpayfreeCudService, IHpsrvselfpayfreeRService {
	public HpsrvselfpayfreeCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(HpSrvSelfPayFreeDODesc.class), IAppFwTempTbl.tmp_iaw_10.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(HpSrvSelfPayFreeDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
