package iih.bd.pp.medinsurrecdiff.s;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import iih.bd.pp.medinsurrecdiff.d.MedinsurrecdiffAggDO;
import iih.bd.pp.medinsurrecdiff.d.desc.MedInsurRecDiffDODesc;
import iih.bd.pp.medinsurrecdiff.i.IMedinsurrecdiffCudService;
import iih.bd.pp.medinsurrecdiff.i.IMedinsurrecdiffRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保记录差异AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMedinsurrecdiffCudService.class,IMedinsurrecdiffRService.class}, binding=Binding.JSONRPC)
public class MedinsurrecdiffCrudServiceImpl extends BaseAggService<MedinsurrecdiffAggDO,MedInsurRecDiffDO> implements IMedinsurrecdiffCudService,IMedinsurrecdiffRService {
    public MedinsurrecdiffCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedInsurRecDiffDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}
