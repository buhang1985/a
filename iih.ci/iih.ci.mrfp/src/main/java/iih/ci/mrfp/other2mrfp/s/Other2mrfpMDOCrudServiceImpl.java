package iih.ci.mrfp.other2mrfp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrfp.other2mrfp.d.desc.CiMrFpOtherDODesc;
import iih.ci.mrfp.other2mrfp.d.CiMrFpOtherDO;
import iih.ci.mrfp.other2mrfp.i.IOther2mrfpMDOCudService;
import iih.ci.mrfp.other2mrfp.i.IOther2mrfpMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病案首页其他信息主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOther2mrfpMDOCudService.class,IOther2mrfpMDORService.class}, binding=Binding.JSONRPC)
public class Other2mrfpMDOCrudServiceImpl extends BaseDOService<CiMrFpOtherDO> implements IOther2mrfpMDOCudService,IOther2mrfpMDORService {

    public Other2mrfpMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpOtherDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

