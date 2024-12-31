package iih.bd.mhi.hpdrugdircomp.s;

import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDO;
import iih.bd.mhi.hpdrugdircomp.d.desc.HpDrugDirCompDODesc;
import iih.bd.mhi.hpdrugdircomp.i.IHpdrugdircompCudService;
import iih.bd.mhi.hpdrugdircomp.i.IHpdrugdircompRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 医保产品_药品对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IHpdrugdircompCudService.class,
		IHpdrugdircompRService.class }, binding = Binding.JSONRPC)
public class HpdrugdircompCrudServiceImpl extends BaseDOService<HpDrugDirCompDO>
		implements IHpdrugdircompCudService, IHpdrugdircompRService {
	public HpdrugdircompCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(HpDrugDirCompDODesc.class), IAppFwTempTbl.tmp_iaw_19.name());
	}
}
