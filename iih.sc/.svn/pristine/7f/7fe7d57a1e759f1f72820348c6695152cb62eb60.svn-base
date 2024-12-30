package iih.sc.scp.s.bp;

import iih.bd.res.bed.d.BedAttrDTO;
import iih.sc.apt.dto.d.AptIpDTO;

import java.util.List;

import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取排班计划号位服务项目
 */
public class GetPlTickSrvNameListBp {

	/**
	 * 获取除主服务之外服务项目
	 * @param id_scplweek 周计划id
	 * @param id_scsrv 排班计划服务id
	 * @return list
	 * @throws DAException
	 */
	public List<String> exec(String id_scplweek,String id_scsrv) throws DAException{
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct(srv.name) ");
		sql.append("from SC_PL_WEEK_TICK tick ");
		sql.append("inner join sc_srv srv on srv.id_scsrv = tick.id_scsrv ");
		sql.append("where tick.id_scplweek = ? ");
		sql.append("and tick.id_scsrv != ? ");
		
		SqlParam param = new SqlParam();
		param.addParam(id_scplweek);
		param.addParam(id_scsrv);
		
		List<String> list = (List<String>) new DAFacade().execQuery(sql.toString(),param,new ColumnListHandler());
		if(list == null || list.size() == 0){
			return null;
		}
		return list;
	}
	
}
