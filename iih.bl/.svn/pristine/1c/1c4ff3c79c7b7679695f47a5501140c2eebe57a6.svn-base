package iih.bl.st.blpaypatoep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.st.blpaypatoep.d.desc.BlPayPatOepDODesc;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepMDOCudService;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlpaypatoepMDOCudService.class,IBlpaypatoepMDORService.class}, binding=Binding.JSONRPC)
public class BlpaypatoepMDOCrudServiceImpl extends BaseDOService<BlPayPatOepDO> implements IBlpaypatoepMDOCudService,IBlpaypatoepMDORService {

    public BlpaypatoepMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPayPatOepDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

