package iih.bd.fc.ipspectp.s;

import iih.bd.fc.ipspectp.d.BdEnIpSpecDO;
import iih.bd.fc.ipspectp.d.desc.BdEnIpSpecDODesc;
import iih.bd.fc.ipspectp.i.IIpspectpCudService;
import iih.bd.fc.ipspectp.i.IIpspectpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 住院特定类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IIpspectpCudService.class, IIpspectpRService.class }, binding = Binding.JSONRPC)
public class IpspectpCrudServiceImpl extends BaseDOService<BdEnIpSpecDO>
		implements IIpspectpCudService, IIpspectpRService {
	public IpspectpCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdEnIpSpecDODesc.class), IAppFwTempTbl.tmp_iaw_09.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(BdEnIpSpecDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
