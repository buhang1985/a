package iih.ei.itf.eiitfdo.s;

import iih.ei.itf.eiitfdo.d.EiItfDO;
import iih.ei.itf.eiitfdo.d.desc.EiItfDODesc;
import iih.ei.itf.eiitfdo.i.IEiitfdoCudService;
import iih.ei.itf.eiitfdo.i.IEiitfdoRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 接口注册AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEiitfdoCudService.class, IEiitfdoRService.class }, binding = Binding.JSONRPC)
public class EiitfdoCrudServiceImpl extends BaseDOService<EiItfDO> implements IEiitfdoCudService, IEiitfdoRService {
	public EiitfdoCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EiItfDODesc.class), IAppFwTempTbl.tmp_iaw_02.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EiItfDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
