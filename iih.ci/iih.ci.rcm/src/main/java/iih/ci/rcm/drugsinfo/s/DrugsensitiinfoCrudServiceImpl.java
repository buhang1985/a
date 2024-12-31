package iih.ci.rcm.drugsinfo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.drugsinfo.d.desc.DrugSensitiInfoDODesc;
import iih.ci.rcm.drugsinfo.d.DrugSensitiInfoDO;
import iih.ci.rcm.drugsinfo.i.IDrugsensitiinfoCudService;
import iih.ci.rcm.drugsinfo.i.IDrugsensitiinfoRService;


/**
 * 药敏信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDrugsensitiinfoCudService.class,IDrugsensitiinfoRService.class}, binding=Binding.JSONRPC)
public class DrugsensitiinfoCrudServiceImpl extends BaseDOService<DrugSensitiInfoDO> implements IDrugsensitiinfoCudService,IDrugsensitiinfoRService {
    public DrugsensitiinfoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DrugSensitiInfoDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}
