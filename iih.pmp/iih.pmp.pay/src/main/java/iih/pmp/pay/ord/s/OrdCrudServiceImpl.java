package iih.pmp.pay.ord.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import iih.pmp.pay.ord.d.desc.OrdDODesc;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.i.IOrdCudService;
import iih.pmp.pay.ord.i.IOrdRService;
import iih.pmp.pay.s.bp.validate.OrderVidator;


/**
 * 订单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrdCudService.class,IOrdRService.class}, binding=Binding.JSONRPC)
public class OrdCrudServiceImpl extends BaseDOService<OrdDO> implements IOrdCudService,IOrdRService {
    public OrdCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new OrderVidator(), new BDUniqueRuleValidate() };
	}

}
