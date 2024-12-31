package iih.bl.hp.hpentcode.s;
import iih.bl.hp.hpentcode.d.HpEntCodeDO;
import iih.bl.hp.hpentcode.d.desc.HpEntCodeDODesc;
import iih.bl.hp.hpentcode.i.IHpentcodeCudService;
import iih.bl.hp.hpentcode.i.IHpentcodeRService;
import iih.bl.hp.hpentcode.s.rule.IpInsertBeforeRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 患者医保登记信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpentcodeCudService.class,IHpentcodeRService.class}, binding=Binding.JSONRPC)
public class HpentcodeCrudServiceImpl extends BaseDOService<HpEntCodeDO> implements IHpentcodeCudService,IHpentcodeRService {
    public HpentcodeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpEntCodeDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @SuppressWarnings("unchecked")
	@Override
    protected void addInsertBeforeRule(AroundProcesser<HpEntCodeDO> processer) {
    	super.addInsertBeforeRule(processer);
    	processer.addBeforeRule(new IpInsertBeforeRule());
    }
}
