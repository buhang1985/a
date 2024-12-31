package iih.bd.mhi.hpdrug.s;

import iih.bd.mhi.hpdrug.d.HpDrugDO;
import iih.bd.mhi.hpdrug.d.desc.HpDrugDODesc;
import iih.bd.mhi.hpdrug.i.IHpdrugCudService;
import iih.bd.mhi.hpdrug.i.IHpdrugRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 医保产品_药品AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IHpdrugCudService.class, IHpdrugRService.class }, binding = Binding.JSONRPC)
public class HpdrugCrudServiceImpl extends BaseDOService<HpDrugDO> implements IHpdrugCudService, IHpdrugRService {
	public HpdrugCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(HpDrugDODesc.class), IAppFwTempTbl.tmp_iaw_09.name());
	}
}
