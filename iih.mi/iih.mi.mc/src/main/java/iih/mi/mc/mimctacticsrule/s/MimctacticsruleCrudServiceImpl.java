package iih.mi.mc.mimctacticsrule.s;

import iih.mi.mc.mimctacticsrule.d.MiMcTacticsRuleDO;
import iih.mi.mc.mimctacticsrule.d.desc.MiMcTacticsRuleDODesc;
import iih.mi.mc.mimctacticsrule.i.IMimctacticsruleCudService;
import iih.mi.mc.mimctacticsrule.i.IMimctacticsruleRService;
import iih.mi.mc.s.util.MiParamSaveUtil;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 医保规则AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMimctacticsruleCudService.class,
		IMimctacticsruleRService.class }, binding = Binding.JSONRPC)
public class MimctacticsruleCrudServiceImpl extends BaseDOService<MiMcTacticsRuleDO>
		implements IMimctacticsruleCudService, IMimctacticsruleRService {
	public MimctacticsruleCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MiMcTacticsRuleDODesc.class), IAppFwTempTbl.tmp_iaw_26.name());
	}

	
}
