package iih.mi.bd.s.bp;

import java.util.List;

import iih.mi.bd.miudidoclist.d.MiUdidoclistDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.kernel.utils.SqlBuilder;

/**
 *查询该医保计划下已维护的档案类型
 * @author wq.li
 *
 */
public class GetMiUdidiclistInHpIdBP {
	/**
	 * 查询该医保计划下已维护的档案类型
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	public MiUdidoclistDO[] exec(String hpId)throws BizException{
		if(StringUtil.isEmpty(hpId)){
			return null;
		}
		
		StringBuilder sql=new StringBuilder();
		sql.append(" select * from mi_udidoclist ");
		sql.append(" where id_miudidoclist in ( ");
		sql.append(" select id_miudidoclist from mi_udidoclist_use  ");
		sql.append(" where id_hp = ? )");
		
		SqlParam param=new SqlParam();
		param.addParam(hpId);
		
		List<MiUdidoclistDO> list=(List<MiUdidoclistDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(MiUdidoclistDO.class));
		
		return list.toArray(new MiUdidoclistDO[0]);
	}
	
}
