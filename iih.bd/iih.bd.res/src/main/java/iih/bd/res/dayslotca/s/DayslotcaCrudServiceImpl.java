package iih.bd.res.dayslotca.s;

import iih.bd.res.dayslotca.d.DaysLotcaDO;
import iih.bd.res.dayslotca.d.desc.DaysLotcaDODesc;
import iih.bd.res.dayslotca.i.IDayslotcaCudService;
import iih.bd.res.dayslotca.i.IDayslotcaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 日期分组分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IDayslotcaCudService.class,
		IDayslotcaRService.class }, binding = Binding.JSONRPC)
public class DayslotcaCrudServiceImpl extends BaseDOService<DaysLotcaDO>
		implements IDayslotcaCudService, IDayslotcaRService {

	public DayslotcaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DaysLotcaDODesc.class),
				IAppFwTempTbl.tmp_iaw_13.name());
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
	protected Validator[] getUpdateValidator(DaysLotcaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
