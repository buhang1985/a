package iih.bd.res.place.s;

import iih.bd.res.place.d.PlaceDO;
import iih.bd.res.place.d.desc.PlaceDODesc;
import iih.bd.res.place.i.IPlaceCudService;
import iih.bd.res.place.i.IPlaceRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 地点AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IPlaceCudService.class, IPlaceRService.class }, binding = Binding.JSONRPC)
public class PlaceCrudServiceImpl extends TreeBaseDOService<PlaceDO> implements
		IPlaceCudService, IPlaceRService {

	public PlaceCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PlaceDODesc.class),
				IAppFwTempTbl.tmp_iaw_03.name());
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
	protected Validator[] getUpdateValidator(PlaceDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
