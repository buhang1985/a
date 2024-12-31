package iih.bd.pp.medinsurtreatrec.s;
import iih.bd.pp.medinsurtreatrec.d.MedInsurTreatRecDO;
import iih.bd.pp.medinsurtreatrec.d.desc.MedInsurTreatRecDODesc;
import iih.bd.pp.medinsurtreatrec.i.IMedinsurtreatrecCudService;
import iih.bd.pp.medinsurtreatrec.i.IMedinsurtreatrecRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保诊疗记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMedinsurtreatrecCudService.class,IMedinsurtreatrecRService.class}, binding=Binding.JSONRPC)
public class MedinsurtreatrecCrudServiceImpl extends BaseDOService<MedInsurTreatRecDO> implements IMedinsurtreatrecCudService,IMedinsurtreatrecRService {
    public MedinsurtreatrecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedInsurTreatRecDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
