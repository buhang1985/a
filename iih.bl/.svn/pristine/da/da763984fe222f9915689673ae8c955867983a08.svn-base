package iih.bl.pay.blpayspcl.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.pay.blpayspcl.d.desc.BlPaySpclDODesc;
import iih.bl.pay.blpayspcl.d.BlPaySpclDO;
import iih.bl.pay.blpayspcl.i.IBlpayspclMDOCudService;
import iih.bl.pay.blpayspcl.i.IBlpayspclMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 收付款_专用款主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlpayspclMDOCudService.class,IBlpayspclMDORService.class}, binding=Binding.JSONRPC)
public class BlpayspclMDOCrudServiceImpl extends BaseDOService<BlPaySpclDO> implements IBlpayspclMDOCudService,IBlpayspclMDORService {

    public BlpayspclMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPaySpclDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

