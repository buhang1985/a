package iih.mi.biz.insureprop.ruraltmp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.biz.insureprop.ruraltmp.d.desc.MiHpPropRuralIpTmpDODesc;
import iih.mi.biz.insureprop.ruraltmp.d.MiHpPropRuralIpTmpDO;
import iih.mi.biz.insureprop.ruraltmp.i.IMihppropruraliptmpCudService;
import iih.mi.biz.insureprop.ruraltmp.i.IMihppropruraliptmpRService;


/**
 * 医保分摊新农合AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMihppropruraliptmpCudService.class,IMihppropruraliptmpRService.class}, binding=Binding.JSONRPC)
public class MihppropruraliptmpCrudServiceImpl extends BaseDOService<MiHpPropRuralIpTmpDO> implements IMihppropruraliptmpCudService,IMihppropruraliptmpRService {
    public MihppropruraliptmpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiHpPropRuralIpTmpDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}
