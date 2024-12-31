package iih.pi.dic.patcatehp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.dic.patcatehp.d.desc.PiPatCaHpDODesc;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpCudService;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;


/**
 * 患者分类医保计划AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPatcatehpCudService.class,IPatcatehpRService.class}, binding=Binding.JSONRPC)
public class PatcatehpCrudServiceImpl extends BaseDOService<PiPatCaHpDO> implements IPatcatehpCudService,IPatcatehpRService {
    public PatcatehpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatCaHpDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
}
