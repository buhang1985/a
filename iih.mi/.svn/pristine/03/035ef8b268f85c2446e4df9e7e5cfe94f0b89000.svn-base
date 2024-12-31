package iih.mi.mibd.drug.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.drug.d.desc.DrugDODesc;
import iih.mi.mibd.drug.d.DrugDO;
import iih.mi.mibd.drug.i.IDrugCudService;
import iih.mi.mibd.drug.i.IDrugRService;


/**
 * 医保平台_药品AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDrugCudService.class,IDrugRService.class}, binding=Binding.JSONRPC)
public class DrugCrudServiceImpl extends BaseDOService<DrugDO> implements IDrugCudService,IDrugRService {
    public DrugCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DrugDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}
