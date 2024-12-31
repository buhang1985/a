package iih.bd.pp.medinsurdrugrec.s;
import iih.bd.pp.medinsurdrugrec.d.MedInsurDrugRecDO;
import iih.bd.pp.medinsurdrugrec.d.desc.MedInsurDrugRecDODesc;
import iih.bd.pp.medinsurdrugrec.i.IMedinsurdrugrecCudService;
import iih.bd.pp.medinsurdrugrec.i.IMedinsurdrugrecRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保药品记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMedinsurdrugrecCudService.class,IMedinsurdrugrecRService.class}, binding=Binding.JSONRPC)
public class MedinsurdrugrecCrudServiceImpl extends BaseDOService<MedInsurDrugRecDO> implements IMedinsurdrugrecCudService,IMedinsurdrugrecRService {
    public MedinsurdrugrecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedInsurDrugRecDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}
