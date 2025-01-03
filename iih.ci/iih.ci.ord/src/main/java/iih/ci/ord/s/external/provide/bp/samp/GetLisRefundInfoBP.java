package iih.ci.ord.s.external.provide.bp.samp;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetLisRefundInfoBP {
	
	/**
	 * 根据申请单号返回检验合管可退费的标本费和采集费医嘱ids
	 * 采集费部分退不能保证对，但是所有的保证对
	 * @param applynos
	 * @return
	 * @throws BizException
	 */
	public List<String> exec(String[] applynos)throws BizException{
		if(CiOrdUtils.isEmpty(applynos)) {
			return null;
		}
		//数据转换 由数组变为申请单字符串
		String applynoString = getapplynos(applynos);
		if (CiOrdUtils.isEmpty(applynoString)) {//防止String[] 不是空，但内容为空，转换后则为空
			return null;
		}
		//1.标本费
		//1.1查询就诊ids 防止多个
		String id_ents=getIdEnt(applynoString);
		//1.2查询可退的标本费
		String specimenIdOrs=getSpecimensRefundIdors(applynoString,id_ents);
		
		//2.采集费-当退所有的 就都返回，当退一部分时，返其中某一个
		//2.1查询本次就诊下所要退采集费的医嘱
		List<CiOrderDO> partList=getPartRefunDos(applynoString,id_ents);
		//2.2构建map集合 srv:idor1,idor2
		FMap partFMap=new FMap();
		partFMap=constractFMap(partList,partFMap);
		//2.3获取srv
		String srvString=getSrvString(partList);
		//2.4查询本次就诊是否有除了上面map包含的之外的医嘱
		List<CiOrderDO> otherDos=getOtherSampDos(srvString,id_ents,applynoString);
		//2.5构建map集合 srv:idor1,idor2
		FMap otherFMap=new FMap();
		otherFMap=constractFMap(otherDos, otherFMap);
		//2.6 other的map集合中的srv 要是在part中出现 则返回part中的一个idor,要是没有出现 则将part中的srv对应的idors全部返回
		String sampIdOrs=getSampIdOrs(partFMap,otherFMap);
		
		//3.拼接标本费和采集费idors
		String allString=concatString(specimenIdOrs,sampIdOrs);
		List<String> list=CiOrdUtils.isEmpty(allString)?null:Arrays.asList(allString.split(CiOrdUtils.COMMA_STR));
		return list;
	}
	private String getSampIdOrs(FMap partFMap,FMap otherFMap)throws BizException{
		if(CiOrdUtils.isEmpty(partFMap)) {
			return null;
		}
		if(CiOrdUtils.isEmpty(otherFMap)) {//other整体都没有
			return getSampIdByFmap(partFMap);
		}
		//other不为空 判断other是不是有在部分内的(有的可能在part中 有的可能没有)
		return getSamIdByFmap(partFMap,otherFMap);
	}
	private String getSamIdByFmap(FMap partFMap,FMap otherFMap)throws BizException{
		String idorString="";
		for (Entry<String, Object> other : otherFMap.entrySet()) {
			for(Entry<String, Object> part : partFMap.entrySet()) {
				if(!CiOrdUtils.isEmpty(other.getKey())&&!CiOrdUtils.isEmpty(part.getKey())) {
					if (other.getKey().equals(part.getKey())) {//part中包含了other的
						String[] valueString=part.getValue().toString().split(CiOrdUtils.COMMA_STR);
						idorString+=(valueString[0]+CiOrdUtils.COMMA_STR);//返回一个即可
						continue;
					}
					//没有包含 返所有
					idorString+=part.getValue().toString()+CiOrdUtils.COMMA_STR;
				}
			}
		}
		if (idorString.length() > 0) {
			idorString = idorString.substring(0, idorString.length() - 1);
		}
		return idorString;
	}
	private String getSampIdByFmap(FMap map)throws BizException{
		if(CiOrdUtils.isEmpty(map)) {
			return null;
		}
		String idorString="";
		for (Entry<String, Object> entry : map.entrySet()) {
			idorString+=entry.getValue()+CiOrdUtils.COMMA_STR;
		}
		if (idorString.length() > 0) {
			idorString = idorString.substring(0, idorString.length() - 1);
		}
		return idorString;
	}
	/**
	 * 获取srv
	 * @param list
	 * @return
	 * @throws BizException
	 */
	private String getSrvString(List<CiOrderDO> list)throws BizException{
		if(CiOrdUtils.isEmpty(list)) {
			return null;
		}
		String idors="";
		for(CiOrderDO ciOrderDO:list) {
			if(!CiOrdUtils.isEmpty(ciOrderDO)&&!CiOrdUtils.isEmpty(ciOrderDO.getId_srv())) {
				if(!idors.contains(ciOrderDO.getId_srv())) {//去重
					idors += "'"+ciOrderDO.getId_srv().toString()+"'"+ CiOrdUtils.COMMA_STR;
				}
			}
		}
		if (idors.length() > 0) {
			idors = idors.substring(0, idors.length() - 1);
		}
		return idors;
	}
	/**
	 * 构建map集合
	 * @param list
	 * @param fMap
	 * @return
	 * @throws BizException
	 */
	private FMap constractFMap(List<CiOrderDO> list,FMap fMap)throws BizException{
		if(CiOrdUtils.isEmpty(list)) {
			return null;
		}
		for(CiOrderDO order:list) {
			if(!CiOrdUtils.isEmpty(order.getId_srv()) && !CiOrdUtils.isEmpty(order.getId_or())) {
				if(fMap.containsKey(order.getId_srv())){
					String ors=fMap.get(order.getId_srv())+CiOrdUtils.COMMA_STR+order.getId_or();
					fMap.put(order.getId_srv(), ors);
				}else{
					fMap.put(order.getId_srv(), order.getId_or());
				}
			}
		}
		return fMap;
	}
	private String concatString(String specimenIdOrs,String sampIdOrs)throws BizException{
		if(CiOrdUtils.isEmpty(specimenIdOrs)&&CiOrdUtils.isEmpty(sampIdOrs)) {
			return null;
		}
		if(!CiOrdUtils.isEmpty(specimenIdOrs)) {
			if(CiOrdUtils.isEmpty(sampIdOrs)) {
				return specimenIdOrs;
			}else {
				return specimenIdOrs+CiOrdUtils.COMMA_STR+sampIdOrs;
			}
		}else {
			if(!CiOrdUtils.isEmpty(sampIdOrs)) {
				return sampIdOrs;
			}
		}
		return null;
	}
	/**
	 * 查询本次就诊是否有除了上面map包含的之外的医嘱
	 * @param id_ents
	 * @return
	 * @throws BizException
	 */
	private List<CiOrderDO> getOtherSampDos(String srvString,String id_ents,String applyno)throws BizException{
		if(CiOrdUtils.isEmpty(id_ents)) {
			return null;
		}
		String sqlString=getOtherSampleSql(srvString,id_ents,applyno);
		@SuppressWarnings("unchecked")
		List<CiOrderDO> list = (List<CiOrderDO>)new DAFacade().execQuery(sqlString.toString(),new BeanListHandler(CiOrderDO.class));
		return list;
	} 
	/**
	 * 查询本次就诊是否有除了上面map包含的之外的医嘱sql
	 * @param applynoString
	 * @param id_ents
	 * @return
	 * @throws BizException
	 */
	private String getOtherSampleSql(String srvString,String id_ents,String applyno)throws BizException{
		StringBuilder stringBuilder=new StringBuilder();
	    stringBuilder.append(" select ");
		stringBuilder.append(" a.id_srv,c.id_or ");
		stringBuilder.append(" from bd_samp_pri_itm a  ");
		stringBuilder.append(" left join bd_samp_pri b on b.id_samp_pri=a.id_samp_pri ");
		stringBuilder.append(" left join ci_order c on c.id_srv=b.id_srv ");
		stringBuilder.append(" where a.id_srv in ("+srvString+")and c.id_en in ("+id_ents+") ");
		stringBuilder.append(" and c.applyno not in ("+applyno+") ");
		return stringBuilder.toString();
	}
	private List<CiOrderDO> getPartRefunDos(String applynoString,String id_ents)throws BizException{
		if(CiOrdUtils.isEmpty(applynoString)||CiOrdUtils.isEmpty(id_ents)) {
			return null;
		}
		String sqlString=getPartRefundDosSql(applynoString,id_ents);
		@SuppressWarnings("unchecked")
		List<CiOrderDO> list = (List<CiOrderDO>)new DAFacade().execQuery(sqlString.toString(),new BeanListHandler(CiOrderDO.class));
		return list;
	}
	/**
	 * 查询本次就诊下所要退采集费的医嘱sql
	 * @param applynoString
	 * @param id_ents
	 * @return
	 * @throws BizException
	 */
	private String getPartRefundDosSql(String applynoString,String id_ents)throws BizException{
		StringBuilder stringBuilder=new StringBuilder();
	    stringBuilder.append(" select distinct ");
	    stringBuilder.append(" d.id_srv, ");
		stringBuilder.append(" d.id_or ");
		stringBuilder.append(" from ci_order a ");
		stringBuilder.append(" inner join bd_samp_pri b on a.id_srv=b.id_srv and b.ds=0 and b.id_org = a.id_org ");
		stringBuilder.append(" inner join bd_samp_pri_itm c on c.id_samp_pri=b.id_samp_pri and c.ds=0 ");
		stringBuilder.append(" inner join ci_order d on d.id_srv=c.id_srv ");
		stringBuilder.append(" where c.eu_pritp='1' ");
		stringBuilder.append(" and d.fg_canc = 'N' ");
		stringBuilder.append(" and a.sd_su_bl ='1' ");
		stringBuilder.append(" and a.id_en in ("+id_ents+")");
	    stringBuilder.append(" and d.id_en in ("+id_ents+")");
		stringBuilder.append(" and a.id_or<>d.id_or");
		stringBuilder.append(" and a.applyno in ("+applynoString+")");
		return stringBuilder.toString();
	}
	/**
	 * 标本费
	 * @param applynos
	 * @param id_ents
	 * @return
	 * @throws BizException
	 */
	private String getSpecimensRefundIdors(String applynos,String id_ents) throws BizException{
		if(CiOrdUtils.isEmpty(applynos)||CiOrdUtils.isEmpty(id_ents)) {
			return null;
		}
		String specimensSql = getSpecimensRefundIdorsSql(applynos,id_ents);
		@SuppressWarnings("unchecked")
		List<CiOrderDO> list = (List<CiOrderDO>)new DAFacade().execQuery(specimensSql.toString(),new BeanListHandler(CiOrderDO.class));
		String idorString="";
		if(!CiOrdUtils.isEmpty(list)) {
			for(CiOrderDO ciOrderDO:list) {
				if(!CiOrdUtils.isEmpty(ciOrderDO)&&!CiOrdUtils.isEmpty(ciOrderDO.getId_or())) {
					idorString += ciOrderDO.getId_or().toString()+ CiOrdUtils.COMMA_STR;
				}
			}
		}
		if (idorString.length() > 0) {
			idorString = idorString.substring(0, idorString.length() - 1);
		}
		return idorString;
	}
	/**
	 * 标本费sql查询
	 * @param applynos
	 * @param id_ents
	 * @return
	 * @throws BizException
	 */
	private String getSpecimensRefundIdorsSql(String applynos,String id_ents)throws BizException{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select distinct rel.id_relor as id_or");
		stringBuilder.append("   from ci_app_lis_or lisor ");
		stringBuilder.append("  inner join ci_app_dirive_or_rel rel ");
		stringBuilder.append("     on lisor.id_ciapplissheet = rel.id_app ");
		stringBuilder.append("  inner join ci_order c ");
		stringBuilder.append("     on c.id_or = rel.id_relor ");
		stringBuilder.append("  where id_ciapplissheet not in ");
		stringBuilder.append("        (select b.id_ciapplissheet ");
		stringBuilder.append("           from ci_order a ");
		stringBuilder.append("           left join ci_app_lis_or b ");
		stringBuilder.append("             on b.id_or = a.id_or ");
		stringBuilder.append("          where b.id_ciapplissheet in ");
		stringBuilder.append("                (select id_ciapplissheet ");
		stringBuilder.append("                   from ci_app_lis_or sublis ");
		stringBuilder.append("                  inner join ci_order subor ");
		stringBuilder.append("                     on sublis.id_or = subor.id_or ");
		stringBuilder.append("                  where subor.applyno in ("+applynos+")) ");
		stringBuilder.append("            and a.applyno not in ("+applynos+") ");
		stringBuilder.append("            and a.sd_su_bl = 1) ");
		stringBuilder.append("    and c.id_en in("+id_ents+") ");
		stringBuilder.append("    and id_ciapplissheet in ");
		stringBuilder.append("        (select id_ciapplissheet ");
		stringBuilder.append("           from ci_app_lis_or sublis ");
		stringBuilder.append("          inner join ci_order subor ");
		stringBuilder.append("             on sublis.id_or = subor.id_or ");
		stringBuilder.append("          where subor.applyno in ("+applynos+")) ");
		stringBuilder.append("    and c.sd_su_bl = 1 ");
		return  stringBuilder.toString();
	}
	/**
	 * 获得医嘱id_or，以，隔开
	 * 
	 * @param refund4IpEsDTOs
	 * @return
	 */
	private String getapplynos(String[] strings) throws BizException{
		String idors = "";
		for (String string : strings) {
			if(!CiOrdUtils.isEmpty(string)) {
				idors += "'"+string+"'"+ CiOrdUtils.COMMA_STR;
			}
		}
		if (idors.length() > 0) {
			idors = idors.substring(0, idors.length() - 1);
		}
		return idors;
	}
	/**
	 * 获取就诊id拼接串 有引号的
	 * @param applynoString
	 * @return
	 * @throws BizException
	 */
	private String getIdEnt(String applynoString)throws BizException{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select distinct ");
		stringBuilder.append(" a.id_en as id_en ");
		stringBuilder.append(" from ci_order a ");
		stringBuilder.append(" where a.applyno in ("+applynoString+")");
		@SuppressWarnings("unchecked")
		List<CiOrderDO> list = (List<CiOrderDO>)new DAFacade().execQuery(stringBuilder.toString(),new BeanListHandler(CiOrderDO.class));
		String ident="";
		if(!CiOrdUtils.isEmpty(list)) {
			for(CiOrderDO ciOrderDO:list) {
				if(!CiOrdUtils.isEmpty(ciOrderDO)&&!CiOrdUtils.isEmpty(ciOrderDO.getId_en())) {
					ident +="'"+ciOrderDO.getId_en().toString()+"'"+ CiOrdUtils.COMMA_STR;
				}
			}
		}
		if (ident.length() > 0) {
			ident = ident.substring(0, ident.length() - 1);
		}
		return ident;
	}
}
