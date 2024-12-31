package iih.ci.ord.s.external.provide.bp.bl;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 获取疾病专归原因
 * 原类位置移动到对外目录目录
 *
 */
public class GetIPOutReasonBP {
	
	public String exe(String id_ent) throws BizException {
		
		String sql="select case when sd_outtp=5 then '05' else b.def2 end def2" + 
				"  from ci_order a " + 
				"  left join ci_ap_out b on a.id_or=b.id_or " + 
				" where a.id_en = '"+id_ent+"' " + 
				"   and a.fg_sign = 'Y' " + 
				"   and a.fg_canc = 'N' " + 
				"   and (a.sd_srvtp = '1202' or a.sd_srvtp='1203')  " + 
				" order by a.dt_effe desc ";
		
		    DAFacade fa=new DAFacade();
			List<String>  result=(List<String> )fa.execQuery(sql, new ColumnListHandler("def2"));
			if(result!=null&&result.size()>0) {
				return result.get(0);
			}

		return null;
	}

}
