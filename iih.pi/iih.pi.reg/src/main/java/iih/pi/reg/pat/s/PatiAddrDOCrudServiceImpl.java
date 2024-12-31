package iih.pi.reg.pat.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.i.IPatiAddrDOCudService;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.s.bp.PiPatSetAdmdivFullNameBP;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者基本信息主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPatiAddrDOCudService.class,IPatiAddrDORService.class}, binding=Binding.JSONRPC)
public class PatiAddrDOCrudServiceImpl extends BaseDOService<PatiAddrDO> implements IPatiAddrDOCudService,IPatiAddrDORService {

    public PatiAddrDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PatiAddrDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    /*@Override
    public PatiAddrDO[] find(String whereStr, String orderStr, FBoolean isLazy)
    		throws BizException {
    	
    	PatiAddrDO[] result =  super.find(whereStr, orderStr, isLazy);
    	if(result == null)
    		return result;
    	
    	PiPatSetAdmdivFullNameBP bp = new PiPatSetAdmdivFullNameBP();
    	bp.exec(result);
    	return result;
    }
    
    @Override
    public PatiAddrDO findById(String id) throws BizException {
    	
    	PatiAddrDO result = super.findById(id);
    	if(result == null)
    		return result;
    	
    	PiPatSetAdmdivFullNameBP bp = new PiPatSetAdmdivFullNameBP();
    	bp.exec(result);
    	return result;
    }
    
    @Override
    public PatiAddrDO[] findByIds(String[] ids, FBoolean isLazy)
    		throws BizException {
    	
    	PatiAddrDO[] result = super.findByIds(ids, isLazy);
    	if(result == null)
    		return result;
    	
    	PiPatSetAdmdivFullNameBP bp = new PiPatSetAdmdivFullNameBP();
    	bp.exec(result);
    	return result;
    }*/
}

