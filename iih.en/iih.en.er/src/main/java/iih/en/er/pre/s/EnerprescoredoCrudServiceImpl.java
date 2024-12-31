package iih.en.er.pre.s;
import iih.en.er.pre.d.EnErPreScoreDO;
import iih.en.er.pre.d.desc.EnErPreScoreDODesc;
import iih.en.er.pre.i.IEnerprescoredoCudService;
import iih.en.er.pre.i.IEnerprescoredoRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 急诊预检_分级AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnerprescoredoCudService.class,IEnerprescoredoRService.class}, binding=Binding.JSONRPC)
public class EnerprescoredoCrudServiceImpl extends BaseDOService<EnErPreScoreDO> implements IEnerprescoredoCudService,IEnerprescoredoRService {
    public EnerprescoredoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnErPreScoreDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}
