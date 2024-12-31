package iih.ci.mr.cimrstblsec.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrstblsec.d.desc.CiMrSTblSecDODesc;
import iih.ci.mr.cimrstblsec.d.CiMrSTblSecDO;
import iih.ci.mr.cimrstblsec.i.ICimrstblsecMDOCudService;
import iih.ci.mr.cimrstblsec.i.ICimrstblsecMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床医疗记录智能表格段落主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICimrstblsecMDOCudService.class,ICimrstblsecMDORService.class}, binding=Binding.JSONRPC)
public class CimrstblsecMDOCrudServiceImpl extends BaseDOService<CiMrSTblSecDO> implements ICimrstblsecMDOCudService,ICimrstblsecMDORService {

    public CimrstblsecMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrSTblSecDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

