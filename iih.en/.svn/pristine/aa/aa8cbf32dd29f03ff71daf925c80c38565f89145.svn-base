package iih.en.pv.inpatient.s;
import iih.en.pv.inpatient.d.EnMobAdmDO;
import iih.en.pv.inpatient.d.desc.EnMobAdmDODesc;
import iih.en.pv.inpatient.i.IEnmobadmdoCudService;
import iih.en.pv.inpatient.i.IEnmobadmdoRService;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.rule.ScLogRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 患者就诊_扩展_移动入科AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnmobadmdoCudService.class,IEnmobadmdoRService.class}, binding=Binding.JSONRPC)
public class EnmobadmdoCrudServiceImpl extends BaseDOService<EnMobAdmDO> implements IEnmobadmdoCudService,IEnmobadmdoRService {
    public EnmobadmdoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnMobAdmDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    
    @Override
    protected void addInsertAfterRule(AroundProcesser<EnMobAdmDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnMobAdmDO>(EuOperTp.INSERT));
    }
    
    @Override
    protected void addUpdateAfterRule(CompareAroundProcesser<EnMobAdmDO> processor, EnMobAdmDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	processor.addAfterRule(new ScLogRule<EnMobAdmDO>(EuOperTp.UPDATE, originvos));
    }
    
    @Override
    protected void addRealDeleteAfterRule(AroundProcesser<EnMobAdmDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	processor.addAfterRule(new ScLogRule<EnMobAdmDO>(EuOperTp.DELETE));
    }
}
