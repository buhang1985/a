package iih.bl.vv.cpnin.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.vv.cpnin.d.desc.BlCpnInDODesc;
import iih.bl.vv.cpnin.d.BlCpnInDO;
import iih.bl.vv.cpnin.i.ICpninCudService;
import iih.bl.vv.cpnin.i.ICpninRService;


/**
 * 优惠券入库AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICpninCudService.class,ICpninRService.class}, binding=Binding.JSONRPC)
public class CpninCrudServiceImpl extends BaseDOService<BlCpnInDO> implements ICpninCudService,ICpninRService {
    public CpninCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlCpnInDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    @Override
 	protected Validator[] getDeleteValidator() {
 		return new Validator[] {
 				BDReferenceChecker.getInstance()
 		};
 	}
    
}
