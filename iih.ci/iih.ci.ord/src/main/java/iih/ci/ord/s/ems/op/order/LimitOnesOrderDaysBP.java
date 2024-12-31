package iih.ci.ord.s.ems.op.order;

import java.util.List;

import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 
 * @author dzm
 * 2018-09-05
 * 限制同一人同一个药品的处方，不能超30天的数量，比如某人某药品开了30天，此后24天内此人不能再开此药
 *
 */
public class LimitOnesOrderDaysBP {
	
	public String exec(String[] id_srvs,String id_pat) throws BizException{
		if(id_srvs==null || id_srvs.length<1 || id_pat==null || id_pat=="")
			return "";
		String rst="";
		CiOrderDO[] ciorders = filterCiOrders(getHistryOrders(id_srvs,id_pat));
		if(ciorders!=null && ciorders.length>0){
			for(int i=0;i<ciorders.length;i++){
				FDate dt_entry = ciorders[i].getDt_entry().getDate();
				//int days = FDate.getDaysBetween(dt_entry, CiOrdAppUtils.getServerDateTime().getDate());
				int days = DateTimeUtils.getNatDaysBetween(dt_entry,CiOrdAppUtils.getServerDateTime().getDate());
				//医嘱超过30天且验证时间在开立时间24天内，则不能签署
				if(days<=24){
					rst+="开立过的服务[" + ciorders[i].getName_or() + "]的天数超过30天，请在"+ dt_entry.getDateAfter(24) +"之后再开立医嘱中的药品！\r\n";
				}
			}
		}
		return rst;
	}	
	
	/**
	 * 查询限制范围的sqlstr
	 * @param id_ors 医嘱ids
	 * @param id_pat 患者id
	 * @return
	 */
	private String getQueryStr(String[] id_srvs,String id_pat){
		
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer.append(" select c.id_or,c.days_or,c.dt_entry,cs.name name_or from ci_order c");
		queryBuffer.append(" left join ci_or_srv cs on c.id_or=cs.id_or");
		queryBuffer.append(" where c.id_pat='" + id_pat + "' ");
		queryBuffer.append(" and c.fg_sign='Y' ");
		queryBuffer.append(" and c.fg_canc='N' ");
		queryBuffer.append(" and c.fg_canc='N' ");
		queryBuffer.append(" and c.days_or>=30 ");
		//已记账
		queryBuffer.append(" and cs.sd_su_bl='" + ICiDictCodeConst.SD_SU_BL_ACCOUNT +"' ");
		//服务类型为西药
		queryBuffer.append(" and cs.sd_srvtp like '" + IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG +"%' ");
		//服务类型不能为注射类药品和溶媒
		queryBuffer.append(" and cs.sd_srvtp not in('" + IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX +"','" + IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_DSY + "') ");	
		//同类型
		queryBuffer.append(" and cs.id_srv in(");
		String id_orsStr = "";
		for(int i=0;i<id_srvs.length;i++){
			id_orsStr += "'" + id_srvs[i] + "' ,";
		}
		queryBuffer.append(id_orsStr.substring(0, id_orsStr.length()-1) +")");
		return queryBuffer.toString();
	}
	
	/**
	 * 有多条day_or>30天且name_or相同的，取离当前日期最近的一条
	 * @param c
	 * @return
	 */
	public CiOrderDO[] filterCiOrders(CiOrderDO[] c){
		FMap f = new FMap();
		for(int i=0;i<c.length;i++){
			if(f.containsKey(c[i].getName_or())){
				CiOrderDO ord = (CiOrderDO)f.get(c[i].getName_or());
				if(ord.getDt_entry().before(c[i].getDt_entry())){
					f.put(c[i].getName_or(), c[i]);
				}
			}else{
				f.put(c[i].getName_or(), c[i]);
			}
		}
		return f.values().toArray(new CiOrderDO[f.size()]);
	}
	
	/**
	 * 获取该患者已开立医嘱
	 * @param id_ors 医嘱ids
	 * @param id_pat 患者id
	 * @return
	 * @throws DAException
	 */
	public CiOrderDO[] getHistryOrders(String[] id_srvs,String id_pat) throws DAException{
		DAFacade df = new DAFacade();
		List<CiOrderDO> result = (List<CiOrderDO>)df.execQuery(getQueryStr(id_srvs,id_pat), new BeanListHandler(CiOrderDO.class));
		return 	result.toArray(new CiOrderDO[result.size()]);	
	}
	
	
}
