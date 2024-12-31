package iih.ci.ord.s.external.provide.bp.samp;

import java.util.List;

import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 获取标本费采集费医嘱ids 
 * @author F
 *
 * @date 2019年12月2日下午2:43:47
 *
 * @classpath iih.ci.ord.s.external.provide.bp.samp.GetOpSampInfoBP
 */
public class GetSampInfoBP {

	/**
	 * 主入口 返回数据结构{[applyno1:标1,标2,采1,采2],[applyno2:标6,标5]} 有idor就拼接 没有就不拼接
	 * @param applynos
	 * @return
	 * @throws BizException
	 */
	public FMap exec(String[] applynos)throws BizException{
		if(CiOrdUtils.isEmpty(applynos)) {
			return null;
		}
		//数据转换 由数组变为申请单字符串
		String applynoString = getIdOrs(applynos);
		if (CiOrdUtils.isEmpty(applynoString)) {//防止String[] 不是空，但内容为空，转换后则为空
			return null;
		}
		OrdBizLogger.info(null, "获取标本费采集费入参:"+applynoString.toString());
		//获取标本费集合
		List<CiOrderDO>  specimens = getSpecimensIdors(applynoString);
		//获取采集费集合
		List<CiOrderDO> collects = getCollectIdors(applynoString);
		FMap fMap=new FMap();
		//标本费集合构造map结构
		constractFMap(specimens,fMap);
		//采集费集合构造map结构
		constractFMap(collects, fMap);
		OrdBizLogger.info(null, "标本费采集费FMap:"+fMap.toString());
		return fMap;
	}
	/**
	 * 获取标本费集合
	 * @param applynos
	 * @return
	 */
	private List<CiOrderDO> getSpecimensIdors(String applynos) throws BizException{
		if(CiOrdUtils.isEmpty(applynos)) {
			return null;
		}
		String specimensSql = getSpecimensSql(applynos);
		@SuppressWarnings("unchecked")
		List<CiOrderDO> list = (List<CiOrderDO>)new DAFacade().execQuery(specimensSql.toString(),new BeanListHandler(CiOrderDO.class));
		OrdBizLogger.info(null, "获取标本费sql:"+specimensSql);
		return list;
	}
	/**
	 * 获取查询标本费idors的sql
	 * @return
	 * @throws BizException
	 */
	private String getSpecimensSql(String applynos)throws BizException{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" a.applyno, ");//申请单号
		stringBuilder.append(" c.id_relor as id_or ");//标本费医嘱idor
		stringBuilder.append(" from ci_order a ");
		stringBuilder.append(" left join ci_app_lis_or b on b.id_or=a.id_or ");
		stringBuilder.append(" left join ci_app_dirive_or_rel c on c.id_app=b.id_ciapplissheet ");
		stringBuilder.append(" where a.applyno in ("+applynos+") ");
		return stringBuilder.toString();
	}
	/**
	 * 获取采集费集合
	 * @param applynos
	 * @return
	 */
	private List<CiOrderDO> getCollectIdors(String applynos) throws BizException{
		if(CiOrdUtils.isEmpty(applynos)) {
			return null;
		}
		String collectsSql = getCollectSql(applynos);
		@SuppressWarnings("unchecked")
		List<CiOrderDO> list = (List<CiOrderDO>)new DAFacade().execQuery(collectsSql.toString(),new BeanListHandler(CiOrderDO.class));
		OrdBizLogger.info(null, "获取采集费sql:"+collectsSql);
		return list;
	}
	/**
	 * 获取查询采集费idors的sql
	 * @return
	 * @throws BizException
	 */
	private String getCollectSql(String applynos) throws BizException{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select distinct ");
		stringBuilder.append(" a.applyno, ");//申请单号
		stringBuilder.append(" d.id_or ");//采集费医嘱idor
		stringBuilder.append(" from ci_order a ");
		stringBuilder.append(" inner join bd_samp_pri b on a.id_srv=b.id_srv and b.ds=0 and b.id_org = a.id_org ");
		stringBuilder.append(" inner join bd_samp_pri_itm c on c.id_samp_pri=b.id_samp_pri and c.ds=0 ");
		stringBuilder.append(" inner join ci_order d on d.id_srv=c.id_srv ");
		stringBuilder.append(" where c.eu_pritp='1' ");
		stringBuilder.append(" and d.fg_sign='Y' ");
		stringBuilder.append(" and d.fg_canc = 'N' ");
		stringBuilder.append(" and d.sd_su_bl <>'2' ");
		stringBuilder.append(" and a.id_en=d.id_en ");
		stringBuilder.append(" and a.id_or<>d.id_or ");
		stringBuilder.append(" and a.applyno in ("+applynos+") ");
		return stringBuilder.toString();
	}
	/**
	 * 构造map集合
	 * @param list
	 * @return
	 * @throws BizException
	 */
	private FMap constractFMap(List<CiOrderDO> list,FMap fMap)throws BizException{
		if(CiOrdUtils.isEmpty(list)) {
			return null;
		}
		for(CiOrderDO order:list) {
			if(!CiOrdUtils.isEmpty(order.getApplyno()) && !CiOrdUtils.isEmpty(order.getId_or())) {
				if(fMap.containsKey(order.getApplyno())){
					String ors=fMap.get(order.getApplyno())+CiOrdUtils.COMMA_STR+order.getId_or();
					fMap.put(order.getApplyno(), ors);
				}else{
					fMap.put(order.getApplyno(), order.getId_or());
				}
			}
		}
		return fMap;
	}
	/**
	 * 获得医嘱id_or，以，隔开
	 * 
	 * @param refund4IpEsDTOs
	 * @return
	 */
	private String getIdOrs(String[] strings) {
		String idors = "";
		for (String string : strings) {
			if(!CiOrdUtils.isEmpty(string)) {
				idors += "'"+string+"'"+ OrdEventUtil.COMMA_STR;
			}
		}
		if (idors.length() > 0) {
			idors = idors.substring(0, idors.length() - 1);
		}
		return idors;
	}
}
