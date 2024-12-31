package iih.bd.srv.mrtplstream.s;

import java.util.List;

import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.bd.srv.mrtplstream.i.IMrtplstreamReplaceService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取替换的病历模板流
 */
@Service(serviceInterfaces={IMrtplstreamReplaceService.class}, binding=Binding.JSONRPC)
public class MrtplstreamReplaceServiceImpl implements IMrtplstreamReplaceService {

	@Override
	public EmrTplStreamDO[] getMrtplStream(String Id_basemrtpl, String sd_su_mrptl)
			throws BizException {
		if(Id_basemrtpl==null||sd_su_mrptl==null) return null;
		
		String sql= "select * from BD_MRTPL_FS where id_mrtpl in("
	             	+"select id_mrtpl from bd_mrtpl where sd_su_mrptl='"+sd_su_mrptl
				    +"' and id_basemrtpl='"+Id_basemrtpl+"')";
				List<EmrTplStreamDO> list= (List<EmrTplStreamDO>)new DAFacade().execQuery(sql, new BeanListHandler(EmrTplStreamDO.class));
				if(list.size()>0) return list.toArray(new EmrTplStreamDO[0]);
		return null;
	}

}
