package iih.bd.pp.medinsursrvfacrec.s;
import iih.bd.pp.medinsursrvfacrec.d.MedInsurSrvFacRecDO;
import iih.bd.pp.medinsursrvfacrec.d.desc.MedInsurSrvFacRecDODesc;
import iih.bd.pp.medinsursrvfacrec.i.IMedinsursrvfacrecCudService;
import iih.bd.pp.medinsursrvfacrec.i.IMedinsursrvfacrecRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保服务设施记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMedinsursrvfacrecCudService.class,IMedinsursrvfacrecRService.class}, binding=Binding.JSONRPC)
public class MedinsursrvfacrecCrudServiceImpl extends BaseDOService<MedInsurSrvFacRecDO> implements IMedinsursrvfacrecCudService,IMedinsursrvfacrecRService {
    public MedinsursrvfacrecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedInsurSrvFacRecDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
