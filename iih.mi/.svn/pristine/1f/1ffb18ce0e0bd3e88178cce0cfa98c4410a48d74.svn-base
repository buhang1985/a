package iih.mi.biz.insureprop.ynyuxiethoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.biz.insureprop.ynyuxiethoep.d.desc.MiPropArOepYXNeusoftDODesc;
import iih.mi.biz.insureprop.ynyuxiethoep.d.MiPropArOepYXNeusoftDO;
import iih.mi.biz.insureprop.ynyuxiethoep.i.IMoepropynyuxiethCudService;
import iih.mi.biz.insureprop.ynyuxiethoep.i.IMoepropynyuxiethRService;


/**
 * 玉溪门诊医保分摊AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMoepropynyuxiethCudService.class,IMoepropynyuxiethRService.class}, binding=Binding.JSONRPC)
public class MoepropynyuxiethCrudServiceImpl extends BaseDOService<MiPropArOepYXNeusoftDO> implements IMoepropynyuxiethCudService,IMoepropynyuxiethRService {
    public MoepropynyuxiethCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiPropArOepYXNeusoftDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
}
