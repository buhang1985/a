package iih.nm.nom.wardprint;

import iih.nm.nom.dto.ComfirmStatusEnum;
import iih.nm.nom.dto.NomWkitmDO;
import iih.nm.nom.dto.NomwkitmappDTO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetNomwkitmappDTOBp {

	/**
	 * @throws BizException
	 * 
	 */
	public List<NomwkitmappDTO> exec(String Id_dep_nur, String dt_begin, String dt_end, String fg_sum, String fg_comfirm) throws BizException {

		// 1校验参数
		if (StringUtil.isEmptyWithTrim(dt_begin) || StringUtil.isEmptyWithTrim(dt_end)) {
			return null;
		}
		FDate dt_b = new FDate(dt_begin);
		FDate dt_e = new FDate(dt_end);
		FBoolean f_fg_sum = new FBoolean(fg_sum);
		Integer int_comfirm = new Integer(fg_comfirm);
		// 2.获取所有工作量项目
		List<NomWkitmDO> nomWkitmDOs = getNomWkitmDOs();

		// 3.设置工作项目
		Map<String, NomwkitmappDTO> map = setNomwkitmappDTO(nomWkitmDOs);

		// 4.将科室与合计科室Id拆分
		List<String> id_dep_nurs = getIdSumDeps(Id_dep_nur);

		// 5,查询指定科室和日期段的记录
		List<NomwkitmappDTO> rtnItms = getNomWkitmAppItmDOs(id_dep_nurs, dt_b, dt_e, f_fg_sum, int_comfirm);

		// 6.统计护理工作量项目
		List<NomwkitmappDTO> dtos = statisticsItms(map, rtnItms);

		// 7根据分组调整记录
		List<NomwkitmappDTO> encapsulationData = this.encapsulationData(dtos);
		if (ListUtil.isEmpty(encapsulationData)) {
			return null;
		}
		return encapsulationData;
	}

	/**
	 * 获取项目工作量
	 * 
	 * @return
	 * @throws BizException
	 */
	private List<NomWkitmDO> getNomWkitmDOs() throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select a.*,doc.name as Name_wkitm_grp  from NM_NOM_WKITM a ");
		sql.append(" left join bd_udidoc doc on doc.id_udidoc = a.id_wkitm_grp ");
		sql.append(" where a.fg_print='Y'  and  a.itm_type='0'                  ");
		sql.append(" order by sortno                                            ");
		@SuppressWarnings("unchecked")
		List<NomWkitmDO> nomWkitmDO = (List<NomWkitmDO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(NomWkitmDO.class));
		return nomWkitmDO;
	}

	/**
	 * 设置护理工作量
	 * 
	 * @param nomWkitmDOs
	 * @return
	 */
	private Map<String, NomwkitmappDTO> setNomwkitmappDTO(List<NomWkitmDO> nomWkitmDOs) {

		Map<String, NomwkitmappDTO> map = new LinkedHashMap<String, NomwkitmappDTO>();
		for (NomWkitmDO nomWkitmDO : nomWkitmDOs) {
			NomwkitmappDTO nomwkitmappDTO = new NomwkitmappDTO();
			nomwkitmappDTO.setName_nom_wkitm(nomWkitmDO.getName());
			nomwkitmappDTO.setName_wkitm_grp(nomWkitmDO.getName_wkitm_grp());
			nomwkitmappDTO.setCo("0");
			nomwkitmappDTO.setCount(0);
			nomwkitmappDTO.setId_wkitm_grp(nomWkitmDO.getId_wkitm_grp());
			nomwkitmappDTO.setSortno(nomWkitmDO.getSortno());
			String psnType = nomWkitmDO.getPsn_type() == null ? "" : nomWkitmDO.getPsn_type().toString();
			nomwkitmappDTO.setPsn_type(psnType);
			map.put(nomWkitmDO.getId_nom_wkitm(), nomwkitmappDTO);
		}
		return map;
	}

	private List<String> getIdSumDeps(String id_dep_nur) {

		List<String> id_dep_nurs = new ArrayList<String>();
		if (StringUtils.isBlank(id_dep_nur)) {
			return id_dep_nurs;
		} else {
			String[] id_deps = id_dep_nur.split(",");
			CollectionUtils.addAll(id_dep_nurs, id_deps);
		}
		return id_dep_nurs;
	}

	/**
	 * 封装数据
	 * 
	 * @return
	 */
	private List<NomwkitmappDTO> encapsulationData(List<NomwkitmappDTO> list) {
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		List<Integer> integers = new ArrayList<>();
		List<NomwkitmappDTO> encapsulationData = new ArrayList<>();

		/*
		 * for (NomwkitmappDTO item : list) { item.setCo(item.getCount()+""); }
		 */

		for (int i = 0; i < list.size(); i++) {
			NomwkitmappDTO min = list.get(i);
			String coung = min.getCount() + "";
			// if("1".equals(min.getPsn_type())){
			// if(!StringUtil.isEmptyWithTrim(min.getCtrl1())){
			// List<String> idents = new ArrayList<String>();
			// String[] id_ents = min.getCtrl1().split(",");
			// for (String entID : id_ents) {
			// if(!idents.contains(entID)){
			// idents.add(entID);
			// }
			// }
			// coung = idents.size()+"";
			// }
			// }
			// min.setCo(min.getCount() + "");
			NomwkitmappDTO max = null;
			for (int j = i + 1; j < list.size(); j++) {
				max = list.get(j);
				if (max != null) {
					if (min.getId_wkitm_grp() != null && min.getId_wkitm_grp() != "~" && min.getId_wkitm_grp().equals(max.getId_wkitm_grp())) {
						// String min_name = min.getName_nom_wkitm();
						// String max_name = max.getName_nom_wkitm();
						// String namg = min_name + "/" + max_name;
						Integer max_count = max.getCount();
						coung += ("  |  " + max_count);
						// String coung = min_count + " | " + max_count;
						// min.setName_nom_wkitm(max.getName_wkitm_grp());
						// min.setCo(coung);
						integers.add(max.getSortno());
						// break;
					}
				}

			}
			min.setName_nom_wkitm(StringUtil.isEmptyWithTrim(min.getName_wkitm_grp()) ? min.getName_nom_wkitm() : min.getName_wkitm_grp());
			min.setCo(coung);
		}

		for (NomwkitmappDTO item : list) {
			if (!integers.contains(item.getSortno())) {
				encapsulationData.add(item);
			}
		}
		if (ListUtil.isEmpty(encapsulationData)) {
			return null;
		}
		return encapsulationData;
	}

	/**
	 * 根据科室id和月份 查询NomWkitmAppDO
	 * 
	 * @return
	 * @throws DAException
	 */
	private List<NomwkitmappDTO> getNomWkitmAppItmDOs(List<String> Id_dep_nurs, FDate dt_b, FDate dt_e, FBoolean fg_sum, Integer fg_comfirm) throws DAException {
		SqlParam param = new SqlParam();
		StringBuilder sql = this.getSql(Id_dep_nurs, fg_sum, fg_comfirm);

		if (CollectionUtils.isNotEmpty(Id_dep_nurs)) {
			for (String id_nur_dep : Id_dep_nurs) {
				param.addParam(id_nur_dep);
			}
		}
		param.addParam(dt_b);
		param.addParam(dt_e);
		if (CollectionUtils.isNotEmpty(Id_dep_nurs)) {
			for (String id_nur_dep : Id_dep_nurs) {
				param.addParam(id_nur_dep);
			}
		}
		param.addParam(dt_b);
		@SuppressWarnings("unchecked")
		List<NomwkitmappDTO> list = (List<NomwkitmappDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(NomwkitmappDTO.class));
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		return list;
	}

	/**
	 * 统计护理工作项目
	 * 
	 * @param map
	 * @param appItmDOs
	 */
	private List<NomwkitmappDTO> statisticsItms(Map<String, NomwkitmappDTO> map, List<NomwkitmappDTO> appItmDOs) {

		if (CollectionUtils.isNotEmpty(appItmDOs)) {
			for (NomwkitmappDTO nomWkitmAppItmDO : appItmDOs) {
				if (map.containsKey(nomWkitmAppItmDO.getName_nom_wkitm())) {
					NomwkitmappDTO nomwkitmappDTO = map.get(nomWkitmAppItmDO.getName_nom_wkitm());
					nomwkitmappDTO.setCount(nomWkitmAppItmDO.getCount());
				}
			}
		}
		List<NomwkitmappDTO> dtos = new ArrayList<NomwkitmappDTO>();
		CollectionUtils.addAll(dtos, map.values().iterator());
		return dtos;
	}

	/**
	 * 获取sql
	 * 
	 * @return
	 */
	private StringBuilder getSql(List<String> id_dep_nurs, FBoolean fg_sum, Integer fg_comfirm) {

		StringBuilder sql = new StringBuilder();
		sql.append(" select sum(a.count) as count,a.id_nom_wkitm as Name_nom_wkitm,a.sortno  from ( select wkitm.id_nom_wkitm,itm.count,wkitm.sortno from NM_NOM_WKITM_APP app ");
		sql.append(" inner join NM_NOM_WKITM_APP_ITM itm on itm.id_nom_wkitm_app=app.id_nom_wkitm_app                                                ");
		sql.append(" inner join NM_NOM_WKITM wkitm on wkitm.id_nom_wkitm=itm.id_nom_wkitm                                                            ");
		if (CollectionUtils.isEmpty(id_dep_nurs) && fg_sum.isValue()) {
			sql.append(" left join (select distinct nurdep.attri_depart  ,nurdep.fg_sum from nom_wkitm_nurdep nurdep ) b on b.attri_depart=app.id_dep_nur ");
			sql.append(" left join nom_wkitm_nurdep dep on dep.id_dep=app.id_dep_nur                                                                      ");
		}
		sql.append(" where 1=1                                                                                                                       ");
		sql.append(" and wkitm.name<>'起初在院人数'                                                                                                  ");
		sql.append(" and itm.count!=0                                                                                                                ");
		if (CollectionUtils.isNotEmpty(id_dep_nurs)) {
			String tempSql = "";
			for (String id_dep_nur : id_dep_nurs) {
				tempSql += (tempSql.length() == 0 ? "" : ",") + "?";
			}
			sql.append(" and app.id_dep_nur in (" + tempSql + "  )                                                                                                           ");
		} else if (CollectionUtils.isEmpty(id_dep_nurs) && fg_sum.isValue()) {
			sql.append("  and (b.fg_sum='Y' or dep.fg_sum is null or dep.fg_sum <>'Y')                                                                                      ");
		}
		sql.append(" and app.dt_month>=?                                                                                                             ");
		sql.append(" and app.dt_month<=?                                                                                                             ");
		sql.append(" and wkitm.fg_print='Y'                                                                                                              ");
		if (fg_comfirm.intValue() == ComfirmStatusEnum.COMFIRMED) {
			sql.append(" and app.fg_comfirm='Y'                                                                                                           ");
		} else if (fg_comfirm.intValue() == ComfirmStatusEnum.UNCOMFIRM) {
			sql.append(" and (app.fg_comfirm is null  or app.fg_comfirm='N' )                                                                          ");
		}
		sql.append(" union all                                                                                                                       ");
		sql.append("  select wkitm.id_nom_wkitm,itm.count,wkitm.sortno  from NM_NOM_WKITM_APP app                                                    ");
		sql.append(" inner join NM_NOM_WKITM_APP_ITM itm on itm.id_nom_wkitm_app=app.id_nom_wkitm_app                                                ");
		sql.append(" inner join NM_NOM_WKITM wkitm on wkitm.id_nom_wkitm=itm.id_nom_wkitm                                                            ");
		if (CollectionUtils.isEmpty(id_dep_nurs) && fg_sum.isValue()) {
			sql.append(" left join (select distinct nurdep.attri_depart  ,nurdep.fg_sum from nom_wkitm_nurdep nurdep ) b on b.attri_depart=app.id_dep_nur ");
			sql.append(" left join nom_wkitm_nurdep dep on dep.id_dep=app.id_dep_nur                                                                      ");
		}
		sql.append(" where 1=1                                                                                                                       ");
		sql.append(" and wkitm.name='起初在院人数'                                                                                                   ");
		if (CollectionUtils.isNotEmpty(id_dep_nurs)) {
			String tempSql = "";
			for (String id_dep_nur : id_dep_nurs) {
				tempSql += (tempSql.length() == 0 ? "" : ",") + "?";
			}
			sql.append(" and app.id_dep_nur in (" + tempSql + "  )                                                                                                            ");
		} else if (CollectionUtils.isEmpty(id_dep_nurs) && fg_sum.isValue()) {
			sql.append("  and (b.fg_sum='Y' or dep.fg_sum is null or dep.fg_sum <>'Y')                                                                                      ");
		}
		sql.append(" and wkitm.fg_print='Y'                                                                                                              ");
		if (fg_comfirm.intValue() == ComfirmStatusEnum.COMFIRMED) {
			sql.append(" and app.fg_comfirm='Y'                                                                                                           ");
		} else if (fg_comfirm.intValue() == ComfirmStatusEnum.UNCOMFIRM) {
			sql.append(" and (app.fg_comfirm is null  or app.fg_comfirm='N' )                                                                          ");
		}
		sql.append(" and app.dt_month=?  ) a                                                                                                         ");
		sql.append(" group by a.id_nom_wkitm,a.sortno  order by a.sortno                                                                             ");
		return sql;
	}
}
