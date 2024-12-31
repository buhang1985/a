package iih.bl.st.blstproxyhp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.st.blstproxyhp.d.desc.BlStProxyhpItmDODesc;
import iih.bl.st.blstproxyhp.d.BlStProxyhpItmDO;
import iih.bl.st.blstproxyhp.i.IBlStProxyhpItmDOCudService;
import iih.bl.st.blstproxyhp.i.IBlStProxyhpItmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 代报结算_门急诊转住院主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlStProxyhpItmDOCudService.class,IBlStProxyhpItmDORService.class}, binding=Binding.JSONRPC)
public class BlStProxyhpItmDOCrudServiceImpl extends BaseDOService<BlStProxyhpItmDO> implements IBlStProxyhpItmDOCudService,IBlStProxyhpItmDORService {

    public BlStProxyhpItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlStProxyhpItmDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

