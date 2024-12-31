package iih.mi.mibd.region.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.region.d.desc.RegionDODesc;
import iih.mi.mibd.region.d.RegionDO;
import iih.mi.mibd.region.i.IRegionCudService;
import iih.mi.mibd.region.i.IRegionRService;

/**
 * 医保平台_地区AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IRegionCudService.class, IRegionRService.class }, binding = Binding.JSONRPC)
public class RegionCrudServiceImpl extends BaseDOService<RegionDO> implements IRegionCudService, IRegionRService {
	public RegionCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(RegionDODesc.class), IAppFwTempTbl.tmp_iaw_22.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(RegionDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
