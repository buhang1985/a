package iih.bd.srv.mrctmca.s;

import java.util.List;

import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.srv.mrctmca.i.IMrcactmPrintservice;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 病历打印服务
 */
@Service(serviceInterfaces={IMrcactmPrintservice.class}, binding=Binding.JSONRPC)
public class IMrcactmPrintserviceImpl implements IMrcactmPrintservice{

	@Override
	public MrCtmCaDO[] getMrctmcaDO(String identp) throws BizException {
		if(identp==null)
			return null;
		 String sql= "(select  bmc.ID_MRCACTM , bmc.name , bmc .id_entp,bmc.CODE  from  BD_MRCA_CTM  bmc"
				+" where code_entp like '"+identp+"')"
				+" union all"
				+" (select   '%'  as  ID_MRCACTM ,  '全部'  as  name,   '~'  as  code_entp,'0' as code  from dual)"
				+" order by code";
			
			List<MrCtmCaDO> list= (List<MrCtmCaDO>)new DAFacade().execQuery(sql, new BeanListHandler(MrCtmCaDO.class));
			if(list.size()>0) return list.toArray(new MrCtmCaDO[0]);
		    return null;
	}

}
