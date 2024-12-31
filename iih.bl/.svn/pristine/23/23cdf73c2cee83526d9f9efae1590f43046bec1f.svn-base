package iih.bl.st.blstaroep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.st.blstaroep.d.desc.BlStArOepDODesc;
import iih.bl.st.blstaroep.d.BlStArOepDO;
import iih.bl.st.blstaroep.i.IBlstaroepMDOCudService;
import iih.bl.st.blstaroep.i.IBlstaroepMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 结算应收_门急体AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlstaroepMDOCudService.class,IBlstaroepMDORService.class}, binding=Binding.JSONRPC)
public class BlstaroepMDOCrudServiceImpl extends BaseDOService<BlStArOepDO> implements IBlstaroepMDOCudService,IBlstaroepMDORService {

    public BlstaroepMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlStArOepDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

