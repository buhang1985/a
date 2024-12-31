package iih.bd.bc.mkr.s;

import iih.bd.bc.mkr.d.AnatomicOrganDO;
import iih.bd.bc.mkr.d.desc.AnatomicOrganDODesc;
import iih.bd.bc.mkr.i.IAnatomicorgandefCudService;
import iih.bd.bc.mkr.i.IAnatomicorgandefRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 人体器官定义AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IAnatomicorgandefCudService.class,
		IAnatomicorgandefRService.class }, binding = Binding.JSONRPC)
public class AnatomicorgandefCrudServiceImpl extends
		BaseDOService<AnatomicOrganDO> implements IAnatomicorgandefCudService,
		IAnatomicorgandefRService {

	public AnatomicorgandefCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(AnatomicOrganDODesc.class),
				IAppFwTempTbl.tmp_iaw_28.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(AnatomicOrganDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
