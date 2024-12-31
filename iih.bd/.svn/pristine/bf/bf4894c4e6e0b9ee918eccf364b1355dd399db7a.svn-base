package iih.bd.srv.routedosage.s;

import iih.bd.srv.routedosage.d.RouteDosageRefDO;
import iih.bd.srv.routedosage.d.desc.RouteDosageRefDODesc;
import iih.bd.srv.routedosage.i.IRoutedosageCudService;
import iih.bd.srv.routedosage.i.IRoutedosageRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗用法与剂型关系AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IRoutedosageCudService.class, IRoutedosageRService.class }, binding = Binding.JSONRPC)
public class RoutedosageCrudServiceImpl extends BaseDOService<RouteDosageRefDO>
		implements IRoutedosageCudService, IRoutedosageRService {

	public RoutedosageCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(RouteDosageRefDODesc.class), IAppFwTempTbl.tmp_iaw_23.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(RouteDosageRefDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
