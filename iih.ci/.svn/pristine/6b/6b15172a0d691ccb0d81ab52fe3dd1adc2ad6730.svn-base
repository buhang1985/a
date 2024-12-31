package iih.ci.mr.cimracrecords.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimracrecords.d.desc.CiMrACOtherDODesc;
import iih.ci.mr.cimracrecords.d.CiMrACOtherDO;
import iih.ci.mr.cimracrecords.i.ICiMrACOtherDOCudService;
import iih.ci.mr.cimracrecords.i.ICiMrACOtherDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 产程数据记录主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrACOtherDOCudService.class,ICiMrACOtherDORService.class}, binding=Binding.JSONRPC)
public class CiMrACOtherDOCrudServiceImpl extends BaseDOService<CiMrACOtherDO> implements ICiMrACOtherDOCudService,ICiMrACOtherDORService {

    public CiMrACOtherDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrACOtherDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

