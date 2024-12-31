package iih.ci.mrqc.spotcheck.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.spotcheck.d.desc.CiAmrSpotCheckRecordDODesc;
import iih.ci.mrqc.spotcheck.d.CiAmrSpotCheckRecordDO;
import iih.ci.mrqc.spotcheck.i.ISpotcheckCudService;
import iih.ci.mrqc.spotcheck.i.ISpotcheckRService;


/**
 * 门诊病历抽查AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISpotcheckCudService.class,ISpotcheckRService.class}, binding=Binding.JSONRPC)
public class SpotcheckCrudServiceImpl extends BaseDOService<CiAmrSpotCheckRecordDO> implements ISpotcheckCudService,ISpotcheckRService {
    public SpotcheckCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAmrSpotCheckRecordDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
