package iih.hp.cp.hpcpimplstatdto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.sys.jdbc.handler.BeanListHandler;


public class HpcpImplStatService {
	//诊疗路径启用状态
	private static final String HPCP_STATUS_ENABLE = "30";
	//匹配人数
	private static final String NUM_TYPE_MATCH = "00";
	//入径人数
	private static final String NUM_TYPE_IN = "01";
	//变异退出人数
	private static final String NUM_TYPE_VAROUT = "02";
	//完成人数
	private static final String NUM_TYPE_COMP = "03";
	//变异人数
	private static final String NUM_TYPE_VAR = "04";
	
	public List<?> fillBeanList(String dateBegin, String dateEnd, String id_dep, String id_cp, String id_grp, String id_org) throws Exception {
		if("null".equals(dateBegin) && "null".equals(dateEnd) && "null".equals(id_dep) && "null".equals(id_cp)) {
			return new ArrayList<HpcpimplStatisticsDTO>();
		}
		
		//诊疗路径获取
		List<HpcpimplStatDTO> hpcpInfos = this.getHpcpInfo(id_cp, id_grp, id_org);
		if(hpcpInfos == null || hpcpInfos.size() <= 0) {
			return new ArrayList<HpcpimplStatisticsDTO>();
		}
		
		List<HpcpimplStatDTO> result = new ArrayList<HpcpimplStatDTO>();
		//路径匹配人数合计
		int allMatchNum = 0;
		for(HpcpimplStatDTO hpcpInfo : hpcpInfos) {
			HpcpimplStatDTO hpcpImplStatDTO = new HpcpimplStatDTO();
			
			//路径主键
			hpcpImplStatDTO.setId_cp(String.valueOf(hpcpInfo.getId_cp()));
			
			//路径名称
			hpcpImplStatDTO.setHp_cp_name(String.valueOf(hpcpInfo.getHp_cp_name()));
			
			// 住院科室
			hpcpImplStatDTO.setDep_name(this.getDepName(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp())));
			
			//路径匹配人数
			Integer matchNum = this.getHpcpMatchNum(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp()), NUM_TYPE_MATCH);
			hpcpImplStatDTO.setMatch_num(matchNum);
			
			allMatchNum += matchNum;
			
			if(matchNum == 0) {
				//入径人数、率
				hpcpImplStatDTO.setInhp_num(0);
				hpcpImplStatDTO.setRate_in("0");
				
				//变异退出人数、率
				hpcpImplStatDTO.setVaout_num(0);
				hpcpImplStatDTO.setRate_vaout("0");
				
				//路径完成人数、率
				hpcpImplStatDTO.setCoout_num(0);
				hpcpImplStatDTO.setRate_coout("0");
				
				//路径变异人数、率
				hpcpImplStatDTO.setVaria_num(0);
				hpcpImplStatDTO.setRate_varia("0");
			} else {
				//入径人数、率
				Integer inhpNum = this.getHpcpMatchNum(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp()), NUM_TYPE_IN);
				hpcpImplStatDTO.setInhp_num(inhpNum);

				if(inhpNum == 0) {
					hpcpImplStatDTO.setRate_in("0");
				} else {
					hpcpImplStatDTO.setRate_in(this.getRate(matchNum, inhpNum).get(0).getRate());
				}
				
				//变异退出人数、率
				Integer variOutNum = this.getHpcpMatchNum(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp()), NUM_TYPE_VAROUT);
				hpcpImplStatDTO.setVaout_num(variOutNum);

				if(variOutNum == 0) {
					hpcpImplStatDTO.setRate_vaout("0");
				} else {
					hpcpImplStatDTO.setRate_vaout(this.getRate(inhpNum, variOutNum).get(0).getRate());
				}
				
				//路径完成人数、率
				Integer compNum = this.getHpcpMatchNum(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp()), NUM_TYPE_COMP);
				hpcpImplStatDTO.setCoout_num(compNum);

				if(compNum == 0) {
					hpcpImplStatDTO.setRate_coout("0");
				} else {
					hpcpImplStatDTO.setRate_coout(this.getRate(inhpNum, compNum).get(0).getRate());
				}
				
				//路径变异人数、率
				Integer variNum = this.getHpcpMatchNum(dateBegin, dateEnd, id_dep, String.valueOf(hpcpInfo.getId_cp()), NUM_TYPE_VAR);
				hpcpImplStatDTO.setVaria_num(variNum);

				if(variNum == 0) {
					hpcpImplStatDTO.setRate_varia("0");
				} else {
					hpcpImplStatDTO.setRate_varia(this.getRate(inhpNum, variNum).get(0).getRate());
				}
			}
			
			result.add(hpcpImplStatDTO);
		}
		
		List<HpcpimplStatisticsDTO> statisticsList = new ArrayList<>();
		HpcpimplStatisticsDTO statistics = new HpcpimplStatisticsDTO();
		statistics.setHpcpimplStatList(result);
		statistics.setAllMatchNum(allMatchNum);
		statisticsList.add(statistics);
		return statisticsList;
	}

	private Integer getHpcpMatchNum(String dateBegin, String dateEnd,
			String id_dep, String id_cp, String numType) throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select APP.ID_CPAPP ");
		strSql.append(" from HP_CP_APP APP ");
		strSql.append(" inner join EN_ENT ENT on APP.Id_Ent = ENT.Id_Ent ");
		strSql.append(" inner join EN_ENT_IP ENTIP on ENT.Id_Ent = ENTIP.Id_Ent ");
		strSql.append(" where ENT.code_entp = '10' and ENT.Fg_Canc = 'N' and ENT.Fg_ip = 'N' ");
		if(!StringUtils.isBlank(dateBegin) && !"null".equals(dateBegin) && !"".equals(dateBegin.trim())) {
			strSql.append(" and ENT.Dt_End >= '" + dateBegin + "' ");
		}
		if(!StringUtils.isBlank(dateEnd) && !"null".equals(dateEnd) && !"".equals(dateEnd.trim())) {
			strSql.append(" and ENT.Dt_End <= '" + dateEnd + "' ");
		}
		if(!StringUtils.isBlank(id_dep) && !"null".equals(id_dep) && !"".equals(id_dep.trim())) {
			strSql.append(" and ENTIP.Id_Dep_Phydisc = '" + id_dep + "' ");
		}
		strSql.append(" and APP.Id_Cp = '" + id_cp + "' ");
		if(numType.equals(NUM_TYPE_IN)) {
			strSql.append(" and APP.Sd_Status in (1, 2, 3) ");
		} else if(numType.equals(NUM_TYPE_VAROUT)) {
			strSql.append(" and APP.Sd_Status = 2 ");
		} else if(numType.equals(NUM_TYPE_COMP)) {
			strSql.append(" and APP.Sd_Status = 3 ");
		} else if(numType.equals(NUM_TYPE_VAR)) {
			strSql.append(" and APP.Fg_Alter = 'Y' ");
		}
		
		List<HpcpimplStatDTO> result = this.getResultBySql(strSql.toString());
		
		if(result != null && result.size() >= 0) {
			return result.size();
		}
		
		return 0;
	}

	private String getDepName(String dateBegin, String dateEnd, String id_dep,
			String id_cp) throws Exception {
		StringBuffer strSql = new StringBuffer();
		if(StringUtils.isBlank(id_dep) || "null".equals(id_dep) || "".equals(id_dep.trim())) {
			strSql.append(" select BD_DEP.name dep_name ");
			strSql.append(" from HP_CP_APP APP ");
			strSql.append(" inner join EN_ENT ENT on APP.Id_Ent = ENT.Id_Ent ");
			strSql.append(" inner join EN_ENT_IP ENTIP on ENTIP.Id_Ent = ENT.Id_Ent ");
			strSql.append(" left outer join BD_DEP on ENTIP.Id_Dep_Phydisc = BD_DEP.Id_Dep ");
			strSql.append(" where ENT.code_entp = '10' and ENT.Fg_Canc = 'N' and ENT.Fg_ip = 'N' ");
            if(!StringUtils.isBlank(dateBegin) && !"null".equals(dateBegin) && !"".equals(dateBegin.trim())) {
				strSql.append(" and ENT.Dt_End >= '" + dateBegin + "' ");
			}
            if(!StringUtils.isBlank(dateEnd) && !"null".equals(dateEnd) && !"".equals(dateEnd.trim())) {
				strSql.append(" and ENT.Dt_End <= '" + dateEnd + "' ");
			}
			strSql.append(" and APP.Id_Cp = '" + id_cp + "' ");
			strSql.append(" and BD_DEP.name is not null ");
		} else {
			strSql.append(" select name dep_name from BD_DEP where id_dep = '" + id_dep + "' ");
		}
		
		List<HpcpimplStatDTO> result = this.getResultBySql(strSql.toString());
		
		if(result != null && result.size() >= 0) {
			return String.valueOf(result.get(0).getDep_name());
		}
		return null;
	}

	private List<HpcpimplStatDTO> getHpcpInfo(String id_cp, String id_grp, String id_org) throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select id_cp, name hp_cp_name");
		strSql.append(" from HP_CP ");
		strSql.append(" where sd_status = '" + HPCP_STATUS_ENABLE + "' ");
		strSql.append(" and id_grp = '" + id_grp + "' ");
		strSql.append(" and id_org = '" + id_org + "' ");
		strSql.append(" and ds = 0 ");
		if(!StringUtils.isBlank(id_cp) && !"null".equals(id_cp) && !"".equals(id_cp.trim())) {
			strSql.append(" and id_cp = '" + id_cp + "' ");
		}
		strSql.append(" order by code ");
		
		return this.getResultBySql(strSql.toString());
	}
	
	private List<HpcpimplStatDTO> getRate(Integer rateDeno, Integer rateMole) throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select  to_char(round(" + String.valueOf(rateMole) + "/" + String.valueOf(rateDeno) + " * 100, 2),  'FM999.00') || '%' rate " );
		strSql.append(" from HP_CP ");
		
		return this.getResultBySql(strSql.toString());
	}
	
	@SuppressWarnings("unchecked")
	private List<HpcpimplStatDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(HpcpimplStatDTO.class);
		List<HpcpimplStatDTO> result = (List<HpcpimplStatDTO>)beanlist_handler.processRs(cached_rs);

		sql_rdr.destroy(); // add by QYS at 2016.4.20
		
		if(result == null || result.size() <= 0) {
			return null;
		}
		
		return result;
	}
}
