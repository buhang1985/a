package iih.bd.srv.mrpsnpowerdetail.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.mrpsnpowerdetail.d.desc.MrPsnPowerDetailDODesc;
import iih.bd.srv.mrpsnpowerdetail.d.MrPsnPowerDetailDO;
import iih.bd.srv.mrpsnpowerdetail.i.IMrpsnpowerdetailCudService;
import iih.bd.srv.mrpsnpowerdetail.i.IMrpsnpowerdetailRService;


/**
 * 病历人员权限配置明细AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrpsnpowerdetailCudService.class,IMrpsnpowerdetailRService.class}, binding=Binding.JSONRPC)
public class MrpsnpowerdetailCrudServiceImpl extends BaseDOService<MrPsnPowerDetailDO> implements IMrpsnpowerdetailCudService,IMrpsnpowerdetailRService {
    public MrpsnpowerdetailCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrPsnPowerDetailDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}
