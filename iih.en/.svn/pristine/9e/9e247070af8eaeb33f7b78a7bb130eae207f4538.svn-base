package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.pv.inpatient.dto.d.IpTotalInfoDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetIpTotalInfoBP {
	
	/**
	 * 获取住院工作量
	 * 
	 * @param depId 科室id
	 * @param beginDate 开始时间
	 * @param enDate 结束时间
	 * @return
	 * @throws DAException 
	 * @throws BizException
	 */
	public IpTotalInfoDTO[] exec(String sdDepTp, String depId, FDate beginDate, FDate enDate) throws BizException{
		if ( beginDate == null || enDate == null || beginDate.compareTo(enDate) == 1) {
			return null;
		}
		List<IpTotalInfoDTO> ipTotalInfolist = this.getBaseDate(beginDate, enDate);
		Map<String,Integer> acptmap = this.getInIpNum(beginDate, enDate); 
		Map<String,Integer> leavmap = this.getLeavIpNum(beginDate, enDate); 
		Map<String,Integer> troutmap = this.getTransoutNum(beginDate, enDate); 
		Map<String,Integer> trinmap = this.getTransinNum(beginDate, enDate); 
		List<IpTotalInfoDTO> ipTotalInfoDTOlist = new ArrayList<IpTotalInfoDTO>();
		for(IpTotalInfoDTO ipTotalInfo:ipTotalInfolist){
			IpTotalInfoDTO ipTotalInfoDTO = new IpTotalInfoDTO();
			ipTotalInfoDTO.setId_dtdep(ipTotalInfo.getId_dtdep());
			ipTotalInfoDTO.setId_dep_phy(ipTotalInfo.getId_dep_phy());
			ipTotalInfoDTO.setSd_dep_phy(ipTotalInfo.getSd_dep_phy());
			ipTotalInfoDTO.setName_dep_phy(ipTotalInfo.getName_dep_phy());
			ipTotalInfoDTO.setId_dep_nur(ipTotalInfo.getId_dep_nur());
			ipTotalInfoDTO.setSd_dep_nur(ipTotalInfo.getSd_dep_nur());
			ipTotalInfoDTO.setName_dep_nur(ipTotalInfo.getName_dep_nur());
			int num_acpt = isReturnZero(acptmap, ipTotalInfo.getId_dtdep()) ? 0 : acptmap.get(ipTotalInfo.getId_dtdep());
			int num_leave = isReturnZero(leavmap, ipTotalInfo.getId_dtdep()) ? 0 : leavmap.get(ipTotalInfo.getId_dtdep());
			int num_transout = isReturnZero(troutmap, ipTotalInfo.getId_dtdep()) ? 0 : troutmap.get(ipTotalInfo.getId_dtdep());
			int num_transin = isReturnZero(trinmap, ipTotalInfo.getId_dtdep()) ? 0 : trinmap.get(ipTotalInfo.getId_dtdep());
			ipTotalInfoDTO.setNum_acpt(num_acpt);
			ipTotalInfoDTO.setNum_leave(num_leave);
			ipTotalInfoDTO.setNum_transout(num_transout);
			ipTotalInfoDTO.setNum_transin(num_transin);
			ipTotalInfoDTO.setNum_old(ipTotalInfo.getNum_old());
			ipTotalInfoDTO.setDt_statist(ipTotalInfo.getDt_statist());
			ipTotalInfoDTO.setNum_now(ipTotalInfo.getNum_old()+num_acpt+num_transout-num_transin-num_leave);
			ipTotalInfoDTOlist.add(ipTotalInfoDTO);
		}
		//this.getNumNow(ipTotalInfoDTOlist);
		return ipTotalInfoDTOlist == null || ipTotalInfoDTOlist.size() <= 0 ? null : ipTotalInfoDTOlist.toArray(new IpTotalInfoDTO[]{});
	}
	/***
	 * 获取基本数据
	 * 
	 * @param beginDate
	 * @param enDate
	 * @param ipTotalInfoDTOs
	 * @throws BizException
	 */
	private List<IpTotalInfoDTO> getBaseDate(FDate beginDate, FDate enDate) throws BizException{
		int days = FDate.getDaysBetween(beginDate, enDate);
		List<IpTotalInfoDTO> ipTotalInfolist = new ArrayList<IpTotalInfoDTO>();
		for(int i = 0;i<=days;i++){
			StringBuffer sql = new StringBuffer();
			sql.append("select substr('"+beginDate.getDateAfter(i)+"', 0, 10) || dep.code id_dtdep,");
			sql.append("substr('"+beginDate.getDateAfter(i)+"', 0, 10) dt_statist, ");
			sql.append("dep.id_dep Id_dep_phy, ");
			sql.append("dep.code Sd_dep_phy, " );
			sql.append("dep.name Name_dep_phy, " );
			sql.append("nur.id_dep Id_dep_nur, " );
			sql.append("nur.code Sd_dep_nur, " );
			sql.append("nur.name Name_dep_nur, " );
			sql.append("count(*) Num_old " );
			sql.append("from en_ent ent " );
			sql.append("inner join en_ent_ip ip " );
			sql.append("on ip.id_ent = ent.id_ent and ip.fg_newborn = 'N' " );
			sql.append("inner join bd_dep dep " );
			sql.append("on dep.id_dep = ent.id_dep_phy " );
			sql.append("inner join bd_dep nur " );
			sql.append("on nur.id_dep = ent.id_dep_nur " );
			sql.append("where 1 = 1 " );
			sql.append("and ent.dt_acpt <= '"+beginDate.getDateAfter(i)+"' " );
			sql.append("and ip.sd_status <> '"+IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT+"' " );
			sql.append("and (ent.dt_end >= '"+beginDate.getDateAfter(i)+"' or " );
			sql.append("ent.dt_end is null or ent.dt_end = '~') " );
			sql.append("group by substr('"+beginDate.getDateAfter(i)+"', 0, 10), " );
			sql.append("dep.id_dep, " );
			sql.append("dep.code, " );
			sql.append("dep.name, " );
			sql.append("nur.id_dep, " );
			sql.append("nur.code, " );
			sql.append("nur.name ");
			@SuppressWarnings("unchecked")
			List<IpTotalInfoDTO> list = (List<IpTotalInfoDTO>)new DAFacade().execQuery(sql.toString(), new BeanListHandler(IpTotalInfoDTO.class));
			if(list != null && list.size() > 0){
				for(IpTotalInfoDTO ipTotalInfoDTO:list){
					if(!ipTotalInfolist.contains(ipTotalInfoDTO.getId_dtdep())){
						ipTotalInfolist.add(ipTotalInfoDTO);
					}
				}
			}
			return ipTotalInfolist;
		}
		return null;
	}
	/***
	 * 入院人数
	 * @param beginDate
	 * @param enDate
	 * @return
	 * @throws BizException
	 */
	private Map<String,Integer> getInIpNum(FDate beginDate, FDate enDate) throws BizException{
		Map<String, Integer> map = new HashMap<String, Integer>();
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("select substr(ent.dt_acpt, 0, 10) || dep.code as id_dtdep, " );
		sql.append("count(*) num_acpt " );
		sql.append("from en_ent ent " );
		sql.append("inner join en_ent_ip ip " );
		sql.append("on ent.id_ent = ip.id_ent  and ip.fg_newborn = 'N' " );
		sql.append("inner join bd_dep dep " );
		sql.append("on dep.id_dep = ip.id_dep_phyadm " );
		sql.append("inner join bd_dep nur " );
		sql.append("on nur.id_dep = ip.id_dep_nuradm " );
		sql.append("where ent.fg_canc = '"+FBoolean.FALSE+"' " );
		sql.append("and ip.sd_status <> '"+IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT+"' " );
		sql.append("and ent.dt_acpt >= ? ");
		param.addParam(beginDate + " 00:00:00 ");
		sql.append("and ent.dt_acpt <= ? ");
		param.addParam(enDate + " 23:59:59 ");
		sql.append("group by dep.code, " );
		sql.append("substr(ent.dt_acpt, 0, 10) " );
		@SuppressWarnings("unchecked")
		List<IpTotalInfoDTO> list = (List<IpTotalInfoDTO>)new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(IpTotalInfoDTO.class));
		if(list != null && list.size() > 0){
			for(IpTotalInfoDTO ipTotalInfoDTO : list){
				map.put(ipTotalInfoDTO.getId_dtdep(), ipTotalInfoDTO.getNum_acpt());
			}
		}
		return map;
	}
	/***
	 * 出院人数
	 * @param beginDate
	 * @param enDate
	 * @return
	 * @throws BizException
	 */
	private Map<String,Integer> getLeavIpNum(FDate beginDate, FDate enDate) throws BizException{
		Map<String, Integer> map = new HashMap<String, Integer>();
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("select substr(ent.dt_end, 0, 10) || dep.code as id_dtdep, " );
		sql.append("count(*) num_leave " );
		sql.append("from en_ent ent " );
		sql.append("inner join en_ent_ip ip " );
		sql.append("on ip.id_ent = ent.id_ent  and ip.fg_newborn = 'N' " );
		sql.append("inner join bd_dep dep " );
		sql.append("on dep.id_dep = ip.id_dep_phydisc " );
		sql.append("inner join bd_dep nur " );
		sql.append("on nur.id_dep = ip.id_dep_nurdisc " );
		sql.append("where ent.fg_canc = '"+FBoolean.FALSE+"' " );
		sql.append("and ip.sd_status = '"+IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT+"' " );
		sql.append("and ent.dt_end >= ? ");
		param.addParam(beginDate + " 00:00:00 ");
		sql.append("and ent.dt_end <= ? ");
		param.addParam(enDate + " 23:59:59 ");
		sql.append("group by dep.code, " );
		sql.append("substr(ent.dt_end, 0, 10) " );
		@SuppressWarnings("unchecked")
		List<IpTotalInfoDTO> list = (List<IpTotalInfoDTO>)new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(IpTotalInfoDTO.class));
		if(list != null && list.size() > 0){
			for(IpTotalInfoDTO ipTotalInfoDTO : list){
				map.put(ipTotalInfoDTO.getId_dtdep(), ipTotalInfoDTO.getNum_leave());
			}
		}
		return map;
	}
	/***
	 * 转出人数
	 * @param beginDate
	 * @param enDate
	 * @return
	 * @throws BizException
	 */
	private Map<String,Integer> getTransoutNum(FDate beginDate, FDate enDate) throws BizException{
		Map<String, Integer> map = new HashMap<String, Integer>();
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("select substr(trans.dt_acpt, 0, 10) || dep_from.code as id_dtdep, " );
		sql.append("count(*) num_transout " );
		sql.append("from en_ent ent " );
		sql.append("inner join en_ent_ip ip " );
		sql.append("on ip.id_ent = ent.id_ent and ip.fg_newborn = 'N' " );
		sql.append("inner join en_dep_trans trans " );
		sql.append("on trans.id_ent = ent.id_ent " );
		sql.append("inner join bd_dep dep_from " );
		sql.append("on dep_from.id_dep = trans.id_dep_from " );
		sql.append("inner join bd_dep nur_from " );
		sql.append("on nur_from.id_dep = trans.id_dep_nur_from " );
		sql.append("where ent.fg_canc = '"+FBoolean.FALSE+"' " );
		sql.append("and ip.sd_status <> '"+IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT+"' " );
		sql.append("and trans.eu_trans = '1' " );
		sql.append("and trans.dt_acpt >= ? ");
		param.addParam(beginDate + " 00:00:00 ");
		sql.append("and trans.dt_acpt <= ? ");
		param.addParam(enDate + " 23:59:59 ");
		sql.append("group by dep_from.code,substr(trans.dt_acpt, 0, 10) " );
		@SuppressWarnings("unchecked")
		List<IpTotalInfoDTO> list = (List<IpTotalInfoDTO>)new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(IpTotalInfoDTO.class));
		if(list != null && list.size() > 0){
			for(IpTotalInfoDTO ipTotalInfoDTO : list){
				map.put(ipTotalInfoDTO.getId_dtdep(), ipTotalInfoDTO.getNum_transout());
			}
		}
		return map;
	}
	/***
	 * 转入人数
	 * @param beginDate
	 * @param enDate
	 * @return
	 * @throws BizException
	 */
	private Map<String,Integer> getTransinNum(FDate beginDate, FDate enDate) throws BizException{
		Map<String, Integer> map = new HashMap<String, Integer>();
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("select substr(trans.dt_acpt, 0, 10) || dep_to.code as id_dtdep, " );
		sql.append("count(*) num_transin " );
		sql.append("from en_ent ent " );
		sql.append("inner join en_ent_ip ip " );
		sql.append("on ip.id_ent = ent.id_ent  and ip.fg_newborn = 'N' " );
		sql.append("inner join en_dep_trans trans " );
		sql.append("on trans.id_ent = ent.id_ent " );
		sql.append("inner join bd_dep dep_to " );
		sql.append("on dep_to.id_dep = trans.id_dep_to " );
		sql.append("inner join bd_dep nur_to " );
		sql.append("on nur_to.id_dep = trans.id_dep_nur_to " );
		sql.append("where ent.fg_canc = '"+FBoolean.FALSE+"' " );
		sql.append("and ip.sd_status <> '"+IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT+"' " );
		sql.append("and trans.eu_trans = '1' " );
		sql.append("and trans.dt_acpt >= ? ");
		param.addParam(beginDate + " 00:00:00 ");
		sql.append("and trans.dt_acpt <= ? ");
		param.addParam(enDate + " 23:59:59 ");
		sql.append("group by dep_to.code,substr(trans.dt_acpt, 0, 10) " );
		@SuppressWarnings("unchecked")
		List<IpTotalInfoDTO> list = (List<IpTotalInfoDTO>)new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(IpTotalInfoDTO.class));
		if(list != null && list.size() > 0){
			for(IpTotalInfoDTO ipTotalInfoDTO : list){
				map.put(ipTotalInfoDTO.getId_dtdep(), ipTotalInfoDTO.getNum_transin());
			}
		}
		return map;
	}
	
	/**
	 * 计算现有人数
	 * 
	 * @param ipInfoDTO
	 */
	private void getNumNow(List<IpTotalInfoDTO> ipTotalInfoDTOs) {
		if(ipTotalInfoDTOs != null && ipTotalInfoDTOs.size() > 0){
			for(IpTotalInfoDTO ipInfoDTO : ipTotalInfoDTOs){
				int numNow = 0;
				if (ipInfoDTO.getNum_old() != null) {
					numNow += ipInfoDTO.getNum_old();
				}
				if (ipInfoDTO.getNum_acpt() != null) {
					numNow += ipInfoDTO.getNum_acpt();
				}
				if (ipInfoDTO.getNum_transin() != null) {
					numNow += ipInfoDTO.getNum_transin();
				}
				if (ipInfoDTO.getNum_transout() != null) {
					numNow -= ipInfoDTO.getNum_transout();
				}
				if (ipInfoDTO.getNum_leave() != null) {
					numNow -= ipInfoDTO.getNum_leave();
				}
				ipInfoDTO.setNum_now(numNow);
			}
		}
	}
	/***
	 * 判断是否返回0
	 * @param map
	 * @param enIpClinicDO
	 * @return
	 */
	public boolean isReturnZero(Map<String, Integer> map,String key){
		if(map== null || map.isEmpty() || !map.containsKey(key)){
			return true;
		}else{
			return false;
		}
	}
}
