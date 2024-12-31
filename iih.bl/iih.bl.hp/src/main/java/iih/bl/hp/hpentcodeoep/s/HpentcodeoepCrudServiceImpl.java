package iih.bl.hp.hpentcodeoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.hp.hpentcodeoep.d.desc.HpEntCodeOepDODesc;
import iih.bl.hp.hpentcodeoep.d.HpEntCodeOepDO;
import iih.bl.hp.hpentcodeoep.i.IHpentcodeoepCudService;
import iih.bl.hp.hpentcodeoep.i.IHpentcodeoepRService;


/**
 * 门诊医保挂号登记记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpentcodeoepCudService.class,IHpentcodeoepRService.class}, binding=Binding.JSONRPC)
public class HpentcodeoepCrudServiceImpl extends BaseDOService<HpEntCodeOepDO> implements IHpentcodeoepCudService,IHpentcodeoepRService {
    public HpentcodeoepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpEntCodeOepDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    @SuppressWarnings("unchecked")
	@Override
    protected void addInsertBeforeRule(AroundProcesser<HpEntCodeOepDO> processer) {
    	super.addInsertBeforeRule(processer);
    	processer.addBeforeRule(new OepInsertBeforeRule());
    }
}
