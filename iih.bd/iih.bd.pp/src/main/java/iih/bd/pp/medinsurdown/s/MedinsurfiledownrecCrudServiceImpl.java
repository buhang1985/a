package iih.bd.pp.medinsurdown.s;
import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import iih.bd.pp.medinsurdown.d.desc.MedInsurFileDownRecDODesc;
import iih.bd.pp.medinsurdown.i.IMedinsurfiledownrecCudService;
import iih.bd.pp.medinsurdown.i.IMedinsurfiledownrecRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保目录下载记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMedinsurfiledownrecCudService.class,IMedinsurfiledownrecRService.class}, binding=Binding.JSONRPC)
public class MedinsurfiledownrecCrudServiceImpl extends BaseDOService<MedInsurFileDownRecDO> implements IMedinsurfiledownrecCudService,IMedinsurfiledownrecRService {
    public MedinsurfiledownrecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedInsurFileDownRecDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
}
