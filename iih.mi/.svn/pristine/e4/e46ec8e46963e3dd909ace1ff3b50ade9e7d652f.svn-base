package iih.mi.biz.insureprop.rural.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.biz.insureprop.rural.d.desc.MiHpPropArRuralIpDODesc;
import iih.mi.biz.insureprop.rural.d.MiHpPropArRuralIpDO;
import iih.mi.biz.insureprop.rural.i.IMihpproparruralipCudService;
import iih.mi.biz.insureprop.rural.i.IMihpproparruralipRService;


/**
 * 新农合医保分摊最终存储AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMihpproparruralipCudService.class,IMihpproparruralipRService.class}, binding=Binding.JSONRPC)
public class MihpproparruralipCrudServiceImpl extends BaseDOService<MiHpPropArRuralIpDO> implements IMihpproparruralipCudService,IMihpproparruralipRService {
    public MihpproparruralipCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiHpPropArRuralIpDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}
