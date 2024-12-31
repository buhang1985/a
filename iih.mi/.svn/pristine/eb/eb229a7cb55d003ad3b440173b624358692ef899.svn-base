package iih.mi.biz.insureprop.ynyuxiethip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.biz.insureprop.ynyuxiethip.d.desc.MiPropArIpYXNeusoftDODesc;
import iih.mi.biz.insureprop.ynyuxiethip.d.MiPropArIpYXNeusoftDO;
import iih.mi.biz.insureprop.ynyuxiethip.i.IMipropynyuxiethCudService;
import iih.mi.biz.insureprop.ynyuxiethip.i.IMipropynyuxiethRService;


/**
 * 玉溪住院医保分摊AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMipropynyuxiethCudService.class,IMipropynyuxiethRService.class}, binding=Binding.JSONRPC)
public class MipropynyuxiethCrudServiceImpl extends BaseDOService<MiPropArIpYXNeusoftDO> implements IMipropynyuxiethCudService,IMipropynyuxiethRService {
    public MipropynyuxiethCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiPropArIpYXNeusoftDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
}
