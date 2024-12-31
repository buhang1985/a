package iih.bd.mhi.hpstaffinfo.s;
import iih.bd.mhi.hpstaffinfo.d.HpStaffInfoDO;
import iih.bd.mhi.hpstaffinfo.d.desc.HpStaffInfoDODesc;
import iih.bd.mhi.hpstaffinfo.i.IHpstaffinfoCudService;
import iih.bd.mhi.hpstaffinfo.i.IHpstaffinfoRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保计划医院操作员信息上报AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpstaffinfoCudService.class,IHpstaffinfoRService.class}, binding=Binding.JSONRPC)
public class HpstaffinfoCrudServiceImpl extends BaseDOService<HpStaffInfoDO> implements IHpstaffinfoCudService,IHpstaffinfoRService {
    public HpstaffinfoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpStaffInfoDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}
