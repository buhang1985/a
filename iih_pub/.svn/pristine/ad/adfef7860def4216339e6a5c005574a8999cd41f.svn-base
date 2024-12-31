package iih.mi.mibd.drugorginal.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.drugorginal.d.desc.MiDrugOrginalDODesc;
import iih.mi.mibd.drugorginal.d.MiDrugOrginalDO;
import iih.mi.mibd.drugorginal.i.IDrugorginalCudService;
import iih.mi.mibd.drugorginal.i.IDrugorginalRService;


/**
 * (新)医保药品原始目录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDrugorginalCudService.class,IDrugorginalRService.class}, binding=Binding.JSONRPC)
public class DrugorginalCrudServiceImpl extends BaseDOService<MiDrugOrginalDO> implements IDrugorginalCudService,IDrugorginalRService {
    public DrugorginalCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiDrugOrginalDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}
