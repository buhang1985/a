package iih.mi.mibd.drugdircomp.s;

import iih.mi.mibd.drugdircomp.d.DrugdircompDO;
import iih.mi.mibd.drugdircomp.d.desc.DrugdircompDODesc;
import iih.mi.mibd.drugdircomp.i.IDrugdircompCudService;
import iih.mi.mibd.drugdircomp.i.IDrugdircompRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 医保平台_药品对照AggDO数据CRUD服务实现
 * 
 * @author hexx
 */
@Service(serviceInterfaces={IDrugdircompCudService.class,IDrugdircompRService.class}, binding=Binding.JSONRPC)
public class DrugdircompCrudServiceImpl extends BaseDOService<DrugdircompDO> implements IDrugdircompCudService,IDrugdircompRService {
	
    public DrugdircompCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DrugdircompDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
}
