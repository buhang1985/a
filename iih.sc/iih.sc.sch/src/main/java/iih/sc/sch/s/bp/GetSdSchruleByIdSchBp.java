package iih.sc.sch.s.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**根据排班id 查找预约规则类型编码
 * @author ccj
 *
 */
public class GetSdSchruleByIdSchBp {
	
	/**根据排班id 查找预约规则类型编码
	 * @param id_sch 排班id
	 * @throws BizException
	 */
	public String exec(String id_sch) throws BizException {
		if(StringUtil.isEmpty(id_sch)) return null;
		StringBuffer sb = new StringBuffer();
		SqlParam sqlParam = new SqlParam();
		sb.append("select sc.sd_schrule from ");
		sb.append("(select id_scpl from sc_sch where id_sch = ? and ds = 0) sc_sch ");
		sb.append("inner join sc_pl on sc_sch.id_scpl = sc_pl.id_scpl and sc_pl.ds = 0 ");
		sb.append("inner join sc_apptrule sc on sc.id_apptru =sc_pl.id_apptru and sc.ds=0 ");
		sqlParam.addParam(id_sch);
		List list = (List) new DAFacade().execQuery(sb.toString(),sqlParam,new MapListHandler());
		if(list == null || list.size() == 0) return null;
		Map map = (HashMap)list.get(0);
		return (String)map.get("sd_schrule");
	}
}
