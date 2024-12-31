package iih.bd.mhi.hpstafftp.s;
import iih.bd.mhi.hpstafftp.d.HpStaffTpDO;
import iih.bd.mhi.hpstafftp.d.desc.HpStaffTpDODesc;
import iih.bd.mhi.hpstafftp.i.IHpstafftpCudService;
import iih.bd.mhi.hpstafftp.i.IHpstafftpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保计划医院人员类别AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpstafftpCudService.class,IHpstafftpRService.class}, binding=Binding.JSONRPC)
public class HpstafftpCrudServiceImpl extends BaseDOService<HpStaffTpDO> implements IHpstafftpCudService,IHpstafftpRService {
    public HpstafftpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpStaffTpDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}
