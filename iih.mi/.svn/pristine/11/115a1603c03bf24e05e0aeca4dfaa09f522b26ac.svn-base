package iih.mi.mibd.treat.s;

import iih.mi.mibd.treat.d.TreatDO;
import iih.mi.mibd.treat.d.desc.TreatDODesc;
import iih.mi.mibd.treat.i.ITreatCudService;
import iih.mi.mibd.treat.i.ITreatRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 医保平台_诊疗项目AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ITreatCudService.class, ITreatRService.class }, binding = Binding.JSONRPC)
public class TreatCrudServiceImpl extends BaseDOService<TreatDO> implements ITreatCudService, ITreatRService {
	public TreatCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(TreatDODesc.class), IAppFwTempTbl.tmp_iaw_11.name());
	}
}
