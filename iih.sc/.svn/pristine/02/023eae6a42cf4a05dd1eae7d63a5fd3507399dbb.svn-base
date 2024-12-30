package iih.sc.scbd.s.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取排班资源对照
 * 
 * @author 
 *
 */
public class GetScSrvRelArrBP {
	/**
	 * 获取排班资源对照展示数据
	 * @author yzh
	 * @param idScSrvRelArr
	 * @return
	 * @throws BizException
	 */
	public ScheduleSrvRelDO[] exec(String[] idScSrvRelArr) throws BizException {
		if (idScSrvRelArr == null || idScSrvRelArr.length == 0)
			return null;
		SqlParam param = new SqlParam();
		String qrySql = getQrySql(idScSrvRelArr, param);
		@SuppressWarnings("unchecked")
		List<ScheduleSrvRelDO> list = (List<ScheduleSrvRelDO>) new DAFacade().execQuery(qrySql, param, new BeanListHandler(ScheduleSrvRelDO.class));
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		// 数据合组
		Map<String, ScheduleSrvRelDO> map = new HashMap<String, ScheduleSrvRelDO>();
		for (ScheduleSrvRelDO scheduleSrvRelDO : list) {
			if (map.containsKey(scheduleSrvRelDO.getId_scsrvrel())) {
				ScheduleSrvRelDO scheduleSrvRelDO2 = map.get(scheduleSrvRelDO.getId_scsrvrel());
				scheduleSrvRelDO2.setName_kinditm(scheduleSrvRelDO2.getName_kinditm() + "," + scheduleSrvRelDO.getName_kinditm());
			} else {
				map.put(scheduleSrvRelDO.getId_scsrvrel(), scheduleSrvRelDO);
			}
		}
		
		ScheduleSrvRelDO[] scheduleSrvRelDOArr = map.values().toArray(new ScheduleSrvRelDO[]{});
		return scheduleSrvRelDOArr;
	}
	
	/**
	 * 获取排班资源对照查询sql
	 * @author yzh
	 * @param idScSrvRelArr
	 * @param param
	 * @return
	 */
	private String getQrySql(String[] idScSrvRelArr, SqlParam param) {
		StringBuffer sqlSb = new StringBuffer();
		sqlSb.append(" select a.id_scsrvrel,c.id_scsrv,b.code as Code_mdsrv,b.name as Name_mdsrv,")
				.append(" b.pri as Pri_mdsrv,d.srvslot,itm.name as name_kinditm ")
				.append(" from sc_srv_rel a")
				.append(" inner join bd_srv b on a.id_mdsrv = b.id_srv")
				.append(" inner join sc_srv c on a.id_scsrv = c.id_scsrv")
				.append(" inner join sc_bdsrv d on d.id_srv = b.id_srv")
				.append(" and d.id_scca = c.id_scca")
				.append(" left join sc_bdsrv_kinditm e on e.id_scbdsrv=d.id_scbdsrv")
				.append(" left join sc_srv_kind_itm itm on itm.id_scsrvkinditm = e.id_scsrvkinditm")
				.append(" where 1=1 ");
		String inStr = ScSqlUtils.getInSqlByIds("a.id_scsrvrel", idScSrvRelArr);
		if(!StringUtil.isEmpty(inStr)){
			sqlSb.append(" and ");
			sqlSb.append(inStr);
		}
		return sqlSb.toString();
	}
}
