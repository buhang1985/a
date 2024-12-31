package iih.en.ip.s.bp.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.ip.dto.d.EnIpDepInfoDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 入科查询服务2
 * 
 * @author li.wm
 *
 */
public class GetEnIpDepInfoDTOBP2 {
	/**
	 * 根据病区查找入科数据
	 * @param id_dep_nur
	 * @return
	 * @throws BizException
	 */
	public EnIpDepInfoDTO[] exec(String id_dep_nur) throws BizException{
		if(EnValidator.isEmpty(id_dep_nur))
		{
			throw new BizException("病区为空,请检查参数设置");
		}
		//根据病区id检索信息，并对EnDepDTO中的数据进行赋值
		StringBuffer sqlSb = new StringBuffer();
		sqlSb.append("SELECT ENT.CODE CODE, ENT.ID_PAT, ENT.ID_ENT ID_ENT,IP.ID_INPATIENT ID_IP, ENT.NAME_PAT NAME_PAT, ");
		sqlSb.append(" ENT.DT_ENTRY DT_ENTRY,IP.ID_BED ID_BED, BED.NAME BED_NAME,IP.ID_BED ID_BED_OLD,IP.code_amr_ip, ");
		sqlSb.append(" BP.NAME AS NAME_EMP_OPAPPLY,");
		sqlSb.append(" ENT.ID_DEP_NUR ID_DEP_NUR, ENT.ID_DEP_PHY ID_DEP_PHY,DEP.NAME AS NAME_DEP_PHY,ENT.DT_ACPT,"
			   	+ "ENT.DT_BIRTH_PAT DT_BIRTH_PAT,ENT.SD_SEX_PAT AS SEX_PAT, BED.SD_BEDSEXLIMIT AS SD_BEDSEX,BED.Sd_bedtp ");
		sqlSb.append(" FROM EN_ENT ENT ");
		sqlSb.append(" INNER JOIN EN_ENT_IP IP ON ENT.ID_ENT =IP.ID_ENT  ");
		sqlSb.append(" LEFT JOIN BD_PSNDOC BP ON BP.ID_PSNDOC = IP.ID_EMP_OPAPPLY");
		sqlSb.append(" LEFT JOIN BD_BED BED ON BED.ID_BED =IP.ID_BED  ");
		sqlSb.append(" LEFT JOIN BD_DEP DEP ON ENT.ID_DEP_PHY = DEP.ID_DEP ");
		sqlSb.append(" WHERE ENT.ID_DEP_NUR =? ");
		sqlSb.append(" AND IP.SD_STATUS = ? ");
		sqlSb.append(" ORDER BY DT_ENTRY DESC");
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_dep_nur);
		sqlParam.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN);//住院入科
		
		@SuppressWarnings("unchecked")
		List<EnIpDepInfoDTO> result = (List<EnIpDepInfoDTO>)new DAFacade().execQuery(
				sqlSb.toString(), sqlParam, new BeanListHandler(EnIpDepInfoDTO.class));

		if (result == null){
			return null;
		}
		else{
			//设置年龄，从前台改到后台 - 张沛沛 2019.05.17
			EnAgeCalcUtil.setDoAges(result.toArray(new EnIpDepInfoDTO[]{}), "Id_ent", "Age_pat");
			return result.toArray(new EnIpDepInfoDTO[result.size()]);
		}
	}
}
