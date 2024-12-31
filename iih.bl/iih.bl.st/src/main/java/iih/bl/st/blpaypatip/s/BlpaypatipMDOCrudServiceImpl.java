package iih.bl.st.blpaypatip.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.st.blpaypatip.d.desc.BlPayPatIpDODesc;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipMDOCudService;
import iih.bl.st.blpaypatip.i.IBlpaypatipMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 住院患者结算收付款主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlpaypatipMDOCudService.class,IBlpaypatipMDORService.class}, binding=Binding.JSONRPC)
public class BlpaypatipMDOCrudServiceImpl extends BaseDOService<BlPayPatIpDO> implements IBlpaypatipMDOCudService,IBlpaypatipMDORService {

    public BlpaypatipMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPayPatIpDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

