package iih.ci.rcm.drugallergy.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.drugallergy.d.desc.DrugallergyDODesc;
import iih.ci.rcm.drugallergy.d.DrugallergyDO;
import iih.ci.rcm.drugallergy.i.IDrugallergyCudService;
import iih.ci.rcm.drugallergy.i.IDrugallergyRService;


/**
 * 药敏详情AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDrugallergyCudService.class,IDrugallergyRService.class}, binding=Binding.JSONRPC)
public class DrugallergyCrudServiceImpl extends BaseDOService<DrugallergyDO> implements IDrugallergyCudService,IDrugallergyRService {
    public DrugallergyCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DrugallergyDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
