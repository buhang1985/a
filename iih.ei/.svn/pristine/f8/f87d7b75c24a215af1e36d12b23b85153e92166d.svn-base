package iih.ei.itf.eiitfcate.s;

import iih.ei.itf.eiitfcate.d.EiItfCateDO;
import iih.ei.itf.eiitfcate.d.desc.EiItfCateDODesc;
import iih.ei.itf.eiitfcate.d.desc.ItfDocTaskDODesc;
import iih.ei.itf.eiitfcate.i.IEiitfcateCudService;
import iih.ei.itf.eiitfcate.i.IEiitfcateRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 接口分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IEiitfcateCudService.class, IEiitfcateRService.class }, binding = Binding.JSONRPC)
public class EiitfcateCrudServiceImpl extends BaseDOService<EiItfCateDO>
		implements IEiitfcateCudService, IEiitfcateRService {
	public EiitfcateCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EiItfCateDODesc.class), IAppFwTempTbl.tmp_iaw_14.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EiItfCateDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance(new String[] { ItfDocTaskDODesc.TABLE_NAME }) };
	}
}
