package iih.bd.mm.mmcawareinfo.s;

import iih.bd.mm.mmcawareinfo.d.MmcawareinfoDO;
import iih.bd.mm.mmcawareinfo.d.desc.MmcawareinfoDODesc;
import iih.bd.mm.mmcawareinfo.i.IMmcawareinfoCudService;
import iih.bd.mm.mmcawareinfo.i.IMmcawareinfoRService;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 组件AggDO数据CRUD服务实现
 */
public class MmcawareinfoCrudServiceImpl extends BaseDOService<MmcawareinfoDO>
		implements IMmcawareinfoCudService, IMmcawareinfoRService {

	public MmcawareinfoCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MmcawareinfoDODesc.class),
				IAppFwTempTbl.tmp_iaw_05.name());

	}
}
