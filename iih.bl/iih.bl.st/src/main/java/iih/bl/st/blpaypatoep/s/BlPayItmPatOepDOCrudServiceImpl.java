package iih.bl.st.blpaypatoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.st.blpaypatoep.d.desc.BlPayItmPatOepDODesc;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.i.IBlPayItmPatOepDOCudService;
import iih.bl.st.blpaypatoep.i.IBlPayItmPatOepDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlPayItmPatOepDOCudService.class,IBlPayItmPatOepDORService.class}, binding=Binding.JSONRPC)
public class BlPayItmPatOepDOCrudServiceImpl extends BaseDOService<BlPayItmPatOepDO> implements IBlPayItmPatOepDOCudService,IBlPayItmPatOepDORService {

    public BlPayItmPatOepDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPayItmPatOepDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

