package iih.ci.mr.cimrstblsec.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrstblsec.d.desc.CiMrSTblSecItmDODesc;
import iih.ci.mr.cimrstblsec.d.CiMrSTblSecItmDO;
import iih.ci.mr.cimrstblsec.i.ICiMrSTblSecItmDOCudService;
import iih.ci.mr.cimrstblsec.i.ICiMrSTblSecItmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床医疗记录智能表格段落主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrSTblSecItmDOCudService.class,ICiMrSTblSecItmDORService.class}, binding=Binding.JSONRPC)
public class CiMrSTblSecItmDOCrudServiceImpl extends BaseDOService<CiMrSTblSecItmDO> implements ICiMrSTblSecItmDOCudService,ICiMrSTblSecItmDORService {

    public CiMrSTblSecItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrSTblSecItmDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

