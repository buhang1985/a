package iih.bd.fc.mdwfconfig.s;
import java.util.List;

import iih.bd.fc.mdwfconfig.d.MdWfCaDO;
import iih.bd.fc.mdwfconfig.d.MdWfDO;
import iih.bd.fc.mdwfconfig.d.MdwfconfigAggDO;
import iih.bd.fc.mdwfconfig.d.desc.MdWfCaDODesc;
import iih.bd.fc.mdwfconfig.i.IMdwfconfigCudService;
import iih.bd.fc.mdwfconfig.i.IMdwfconfigRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMdwfconfigCudService.class,IMdwfconfigRService.class}, binding=Binding.JSONRPC)
public class MdwfconfigCrudServiceImpl extends BaseAggService<MdwfconfigAggDO,MdWfCaDO> implements IMdwfconfigCudService,IMdwfconfigRService {

    public MdwfconfigCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MdWfCaDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
  //查找医嘱流向分类  
    public MdWfCaDO[] getMdWfCa(String cond, String orderBy) throws DAException
    {
		
		DAFacade dao = new DAFacade();
		
		
		
		List<MdWfCaDO> result = (List<MdWfCaDO>)dao.findByCond(MdWfCaDO.class, cond, orderBy);
		if (result == null) {
			return null;
		} else {
			return result.toArray(new MdWfCaDO[result.size()]);
		}
    }
    //医嘱流向
    
    public MdWfDO[] getMdWf(String cond, String orderBy) throws DAException
    {
		
		DAFacade dao = new DAFacade();
		
		
		
		List<MdWfDO> result = (List<MdWfDO>)dao.findByCond(MdWfDO.class, cond, orderBy);
		if (result == null) {
			return null;
		} else {
			return result.toArray(new MdWfDO[result.size()]);
		}
    }
}

