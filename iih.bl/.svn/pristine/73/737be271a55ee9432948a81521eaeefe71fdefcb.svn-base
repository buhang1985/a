package iih.bl.st.blstproxyhp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.st.blstproxyhp.d.desc.BlStProxyhpDODesc;
import iih.bl.st.blstproxyhp.d.BlStProxyhpDO;
import iih.bl.st.blstproxyhp.i.IBlstproxyhpMDOCudService;
import iih.bl.st.blstproxyhp.i.IBlstproxyhpMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 代报结算_门急诊转住院主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBlstproxyhpMDOCudService.class,IBlstproxyhpMDORService.class}, binding=Binding.JSONRPC)
public class BlstproxyhpMDOCrudServiceImpl extends BaseDOService<BlStProxyhpDO> implements IBlstproxyhpMDOCudService,IBlstproxyhpMDORService {

    public BlstproxyhpMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlStProxyhpDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

