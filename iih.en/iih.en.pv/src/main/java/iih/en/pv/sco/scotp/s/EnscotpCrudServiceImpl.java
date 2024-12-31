package iih.en.pv.sco.scotp.s;
import iih.en.pv.sco.scotp.d.EnScoTpDO;
import iih.en.pv.sco.scotp.d.desc.EnScoTpDODesc;
import iih.en.pv.sco.scotp.i.IEnscotpCudService;
import iih.en.pv.sco.scotp.i.IEnscotpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 就诊评分类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnscotpCudService.class,IEnscotpRService.class}, binding=Binding.JSONRPC)
public class EnscotpCrudServiceImpl extends BaseDOService<EnScoTpDO> implements IEnscotpCudService,IEnscotpRService {
    public EnscotpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnScoTpDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
