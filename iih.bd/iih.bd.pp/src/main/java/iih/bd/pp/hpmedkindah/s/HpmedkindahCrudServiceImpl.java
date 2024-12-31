package iih.bd.pp.hpmedkindah.s;

import iih.bd.pp.hpmedkindah.d.HpMedKindAhDO;
import iih.bd.pp.hpmedkindah.d.desc.HpMedKindAhDODesc;
import iih.bd.pp.hpmedkindah.i.IHpmedkindahCudService;
import iih.bd.pp.hpmedkindah.i.IHpmedkindahRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医保计划_医疗类别字典_东软AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IHpmedkindahCudService.class, IHpmedkindahRService.class }, binding = Binding.JSONRPC)
public class HpmedkindahCrudServiceImpl extends BaseDOService<HpMedKindAhDO>
		implements IHpmedkindahCudService, IHpmedkindahRService {
	public HpmedkindahCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(HpMedKindAhDODesc.class), IAppFwTempTbl.tmp_iaw_12.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(HpMedKindAhDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

}
