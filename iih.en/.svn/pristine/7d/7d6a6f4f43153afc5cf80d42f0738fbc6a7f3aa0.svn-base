package iih.en.pv.s.bp.ippre.qry;

import java.util.List;

import iih.en.pv.inpatient.dto.d.EnIppreTransHosDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/***
 * 查询预住院转住院患者信息
 * @author zhangpp
 *
 */
public class GetIppreTransHosBP {

	/**
	 * 获取患者信息
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnIppreTransHosDTO exec(String entId) throws BizException{
		
		if (StringUtil.isEmptyWithTrim(entId)) {
			return new EnIppreTransHosDTO();
		}
		//获取EnIppreTransHosDTO数据
		EnIppreTransHosDTO dto = this.getTransHosDto(entId);
		//设置年龄
		this.setAge(dto);
		return dto;
	}

	/**
	 * 获取DTO数据
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private EnIppreTransHosDTO getTransHosDto(String entId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" select ent.id_ent, ");
		sqlBuilder.append(" ippre.sd_status, ");
		sqlBuilder.append(" pat.name as name_pat, ");
		sqlBuilder.append(" pat.id_pat, ");
		sqlBuilder.append(" sex.code as sd_sex_pat, ");
		sqlBuilder.append(" sex.name as sex_pat, ");
		sqlBuilder.append(" pat.dt_birth, ");
		sqlBuilder.append(" ip.id_bed as id_bed_old, ");
		sqlBuilder.append(" ip.name_bed as name_bed_old, ");
		sqlBuilder.append(" ent.id_dep_phy, ");//目标科室（当前科室）
		sqlBuilder.append(" dep1.code as sd_dep_phy, ");
		sqlBuilder.append(" dep1.name as name_dep_phy, ");
		sqlBuilder.append(" ent.id_dep_nur, ");//目标病区
		sqlBuilder.append(" dep2.code as sd_dep_nur, ");
		sqlBuilder.append(" dep2.name as name_dep_nur, ");
		sqlBuilder.append(" ippre.id_dep_phy as id_ippre_phy, ");//预住院科室（原计划实际要入院的科室）
		sqlBuilder.append(" dep3.code as sd_ippre_phy, ");
		sqlBuilder.append(" dep3.name as name_ippre_phy, ");
		sqlBuilder.append(" ippre.id_dep_ward as id_ippre_nur, ");//预住院病区
		sqlBuilder.append(" dep4.code as sd_ippre_nur ");
		sqlBuilder.append(" dep4.name as name_ippre_nur ");
		sqlBuilder.append(" from en_ent ent ");
		sqlBuilder.append(" inner join en_ent_ip ip on ent.id_ent = ip.id_ent ");
		sqlBuilder.append(" inner join en_ippre ippre on ent.id_ent = ippre.id_ent ");
		sqlBuilder.append(" inner join pi_pat pat on pat.id_pat = ent.id_pat ");
		sqlBuilder.append(" left join bd_udidoc sex on sex.id_udidoc = pat.id_sex ");
		sqlBuilder.append(" left join en_ent_bed bed on bed.id_ent = ent.id_ent ");
		sqlBuilder.append(" left join bd_dep dep1 on dep1.id_dep = ent.id_dep_phy ");
		sqlBuilder.append(" left join bd_dep dep2 on dep2.id_dep = ent.id_dep_nur ");
		sqlBuilder.append(" left join bd_dep dep3 on dep3.id_dep = ippre.id_dep_phy ");
		sqlBuilder.append(" left join bd_dep dep4 on dep4.id_dep = ippre.id_dep_ward ");
		sqlBuilder.append(" where ");
		sqlBuilder.append(" ent.id_ent = '");
		sqlBuilder.append(entId);
		sqlBuilder.append("' and  ippre.sd_status = '2' and ip.fg_ippre = 'Y' ");
		
		@SuppressWarnings("unchecked")
		List<EnIppreTransHosDTO> list = (List<EnIppreTransHosDTO>) new DAFacade().execQuery(sqlBuilder.toString(), new BeanListHandler(EnIppreTransHosDTO.class));
		
		return (EnIppreTransHosDTO) (ListUtil.isEmpty(list) ? new EnIppreTransHosDTO() : list.toArray()[0]);
	}
	
	/**
	 * 获取年龄
	 * @param dto
	 */
	private void setAge(EnIppreTransHosDTO dto){
		
		if (dto != null) {
			dto.setAge_pat(AgeCalcUtil.getAge(dto.getDt_birth()));
		}
	}
}
