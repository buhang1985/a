package iih.ci.mr.cideathcert.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.custcfg.billcode.pub.BillCodeGenerateRule;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cideathcert.d.desc.CideathcertDODesc;
import iih.ci.mr.cideathcert.d.CideathcertDO;
import iih.ci.mr.cideathcert.i.ICideathcertCudService;
import iih.ci.mr.cideathcert.i.ICideathcertRService;


/**
 * 死亡诊断证明书AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICideathcertCudService.class,ICideathcertRService.class}, binding=Binding.JSONRPC)
public class CideathcertCrudServiceImpl extends BaseDOService<CideathcertDO> implements ICideathcertCudService,ICideathcertRService {
    public CideathcertCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CideathcertDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
    
    @Override
    protected void addInsertBeforeRule(AroundProcesser<CideathcertDO>processer){
    	super.addInsertBeforeRule(processer);
    	processer.addBeforeRule(new BillCodeGenerateRule<CideathcertDO>());
    }
}
