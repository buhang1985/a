package iih.bl.cg.blredapply.s;
import iih.bl.cg.blredapply.d.BlRefundApplyDO;
import iih.bl.cg.blredapply.d.desc.BlRefundApplyDODesc;
import iih.bl.cg.blredapply.i.IBlredapplyCudService;
import iih.bl.cg.blredapply.i.IBlredapplyRService;
import iih.bl.cg.blredapply.s.rule.BlRefundApplyInsertBefRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 退费申请单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlredapplyCudService.class,IBlredapplyRService.class}, binding=Binding.JSONRPC)
public class BlredapplyCrudServiceImpl extends BaseDOService<BlRefundApplyDO> implements IBlredapplyCudService,IBlredapplyRService {
    public BlredapplyCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlRefundApplyDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
    
    @SuppressWarnings("unchecked")
   	@Override
       protected void addInsertBeforeRule(AroundProcesser<BlRefundApplyDO> processer) {
       	processer.addBeforeRule(new BlRefundApplyInsertBefRule());
       	super.addInsertBeforeRule(processer);
       }
}
