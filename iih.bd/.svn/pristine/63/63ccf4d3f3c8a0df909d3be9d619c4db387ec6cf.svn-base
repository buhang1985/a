package iih.bd.srv.srvspecantiexpert.s;
import iih.bd.srv.srvspecantiexpert.d.SrvSpecAntiExpertDO;
import iih.bd.srv.srvspecantiexpert.d.desc.SrvSpecAntiExpertDODesc;
import iih.bd.srv.srvspecantiexpert.i.ISrvspecantiexpertCudService;
import iih.bd.srv.srvspecantiexpert.i.ISrvspecantiexpertRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;


/**
 * 医疗服务_特殊使用级抗菌药专家AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvspecantiexpertCudService.class,ISrvspecantiexpertRService.class}, binding=Binding.JSONRPC)
public class SrvspecantiexpertCrudServiceImpl extends BaseDOService<SrvSpecAntiExpertDO> implements ISrvspecantiexpertCudService,ISrvspecantiexpertRService {
    public SrvspecantiexpertCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvSpecAntiExpertDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
    public SrvSpecAntiExpertDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO, String orderStr, FBoolean isLazy)
    		throws BizException {
    	// TODO Auto-generated method stub
    	IPsndocMDORService psndocMDORService = ServiceFinder.find(IPsndocMDORService.class);
    	PsnDocDO[] psnDocs = psndocMDORService.findByQCond(qryRootNodeDTO, "", FBoolean.FALSE);
    	String[] id = new String[psnDocs.length];
    	for (int i = 0; i < psnDocs.length; i++) {
			id[i] = psnDocs[i].getId_psndoc();
			
		}
    	ISrvspecantiexpertRService srvspecantiexpertRService = ServiceFinder.find(ISrvspecantiexpertRService.class);
    	return srvspecantiexpertRService.findByAttrValStrings("Id_psndoc", id);
    	//return super.findByQCond(qryRootNodeDTO, orderStr, isLazy);
    }
}
