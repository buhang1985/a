package iih.ci.mrfp.pat2mrfp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrfp.pat2mrfp.d.desc.CiMrFpPatDODesc;
import iih.ci.mrfp.pat2mrfp.d.CiMrFpPatDO;
import iih.ci.mrfp.pat2mrfp.i.IPat2mrfpCudService;
import iih.ci.mrfp.pat2mrfp.i.IPat2mrfpRService;


/**
 * 病案首页患者信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPat2mrfpCudService.class,IPat2mrfpRService.class}, binding=Binding.JSONRPC)
public class Pat2mrfpCrudServiceImpl extends BaseDOService<CiMrFpPatDO> implements IPat2mrfpCudService,IPat2mrfpRService {
    public Pat2mrfpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpPatDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}
