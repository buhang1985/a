package iih.sc.scp.s.bp;

import java.util.List;

import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scp.scplan.d.ScPlanDO;

/**
 * 医技排班计划树模型列表
 * @author zhouliming
 */
public class GetScPlMtTreeBp {
	
	/**
	 * 医技排班计划树模型列表
	 * @return
	 * @throws DAException
	 */
	public List exec() throws DAException{
		StringBuffer sql = new StringBuffer();
		sql.append("select pl.id_scpl,pl.id_dep,pl.id_scsrv,dep.name as dep_name,srv.name as srv_name ");
		sql.append("from sc_pl pl ");
		sql.append("inner join bd_dep dep on dep.id_dep = pl.id_dep ");
		sql.append("inner join sc_srv srv on srv.id_scsrv = pl.id_scsrv ");
		sql.append("where pl.sd_sctp = '"+IScDictCodeConst.SD_SCTP_MT+"' order by pl.id_dep,pl.id_scsrv");
		String str = ScGroupControlUtils.getGroupControlFitler(new ScPlanDO(), "pl");
		sql.append("and ");
		sql.append(str);
		List list =  (List) new DAFacade().execQuery(sql.toString(), new MapListHandler());
		return list;
	}
}
