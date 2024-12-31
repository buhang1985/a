package iih.ei.itf.eiitfcateitm.s;

import iih.ei.itf.eiitfcateitm.d.ItfCateItmDO;
import iih.ei.itf.eiitfcateitm.d.desc.ItfCateItmDODesc;
import iih.ei.itf.eiitfcateitm.i.IEiitfcateitmCudService;
import iih.ei.itf.eiitfcateitm.i.IEiitfcateitmRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 接口分类项目AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEiitfcateitmCudService.class, IEiitfcateitmRService.class }, binding = Binding.JSONRPC)
public class EiitfcateitmCrudServiceImpl extends BaseDOService<ItfCateItmDO>
		implements IEiitfcateitmCudService, IEiitfcateitmRService {
	public EiitfcateitmCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(ItfCateItmDODesc.class), IAppFwTempTbl.tmp_iaw_15.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(ItfCateItmDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
