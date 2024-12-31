package iih.mi.bd.s.bp;

import java.util.List;

import iih.mi.bd.miudidoclist.d.MiUdidoclistDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取该医保计划下未维护的医保档案类型
 * 
 * @author wq.li
 *
 */
public class GetMiUdidiclistNotInHpIdBP {
	/**
	 * 获取该医保计划下未维护的医保档案类型
	 * 
	 * @param hpId
	 * @return
	 * @throws BizException 
	 */
	public MiUdidoclistDO[] exec(String hpId) throws BizException {
		if(StringUtil.isEmpty(hpId)){
			return null;
		}
		
		StringBuilder sql=new StringBuilder();
		sql.append(" select * from mi_udidoclist ");
		sql.append(" where id_miudidoclist not in ( ");
		sql.append(" select id_miudidoclist from mi_udidoclist_use  ");
		sql.append(" where id_hp = ? )");
		
		SqlParam param=new SqlParam();
		param.addParam(hpId);
		
		List<MiUdidoclistDO> list=(List<MiUdidoclistDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(MiUdidoclistDO.class));
		
		return list.toArray(new MiUdidoclistDO[0]);
	}
}
