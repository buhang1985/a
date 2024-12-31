package iih.ci.mrfp.other2mrfp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.mrfp.other2mrfp.d.CiMrFpOtherDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.mrfp.other2mrfp.d.desc.CiMrFpOtherDODesc;
import iih.ci.mrfp.other2mrfp.d.Other2mrfpAggDO;
import iih.ci.mrfp.other2mrfp.i.IOther2mrfpCudService;
import iih.ci.mrfp.other2mrfp.i.IOther2mrfpRService;


/**
 * 病案首页其他信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOther2mrfpCudService.class,IOther2mrfpRService.class}, binding=Binding.JSONRPC)
public class Other2mrfpCrudServiceImpl extends BaseAggService<Other2mrfpAggDO,CiMrFpOtherDO> implements IOther2mrfpCudService,IOther2mrfpRService {
    public Other2mrfpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpOtherDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
