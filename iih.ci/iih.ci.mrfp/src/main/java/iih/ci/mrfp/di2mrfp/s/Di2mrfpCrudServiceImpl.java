package iih.ci.mrfp.di2mrfp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.mrfp.di2mrfp.d.CiMrfpDiDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.mrfp.di2mrfp.d.desc.CiMrfpDiDODesc;
import iih.ci.mrfp.di2mrfp.d.Di2mrfpAggDO;
import iih.ci.mrfp.di2mrfp.i.IDi2mrfpCudService;
import iih.ci.mrfp.di2mrfp.i.IDi2mrfpRService;


/**
 * 住院病案首页_诊断AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDi2mrfpCudService.class,IDi2mrfpRService.class}, binding=Binding.JSONRPC)
public class Di2mrfpCrudServiceImpl extends BaseAggService<Di2mrfpAggDO,CiMrfpDiDO> implements IDi2mrfpCudService,IDi2mrfpRService {
    public Di2mrfpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrfpDiDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
