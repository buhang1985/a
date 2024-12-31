package iih.bd.srv.srvrtctl.s.bp;

import java.util.List;

import iih.bd.srv.srvrtempref.d.SrvRtEmpRefDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetPsnMsgBP {
	public SrvRtEmpRefDO GetPsnMsg(String id) throws BizException{
		String sql=		"select t.id_emptitle,\n" + 
						"       t.humantype as id_humantype,\n" + 
						"       t1.code       as sd_emptitle,\n" + 
						"       t1.name       as title_name,\n" + 
						"       t2.code       as sd_humantype,\n" + 
						"       t2.name       as humantype_name\n" + 
						"  from BD_PSNDOC t\n" + 
						"  left join bd_udidoc t1\n" + 
						"    on t.id_emptitle = t1.id_udidoc\n" + 
						"  left join bd_udidoc t2\n" + 
						"    on t.humantype = t2.id_udidoc\n" + 
						" where t.id_psndoc = '"+id+"'";
		List<SrvRtEmpRefDO> list= (List<SrvRtEmpRefDO>)new DAFacade().execQuery(sql, new BeanListHandler(SrvRtEmpRefDO.class));
		return list.get(0);

	}

}
