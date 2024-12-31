package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpBasicDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取门诊基本信息
 * 
 * @author liubin
 *
 */
public class GetOpBasicInfoBP {
	/**
	 * 获取门诊基本信息
	 * @param entId 就诊ID
	 * @return 门诊基本信息DTO
	 * 
	 * @throws BizException
	 */
	public OpBasicDTO getInfo(String entId) throws BizException{
		if(EnValidator.isEmpty(entId)) {
			Logger.error(this + ":entId为空！");
			return null;
		}
		return setInfo(entId);
	}
	
	private OpBasicDTO setInfo(String entId) throws DAException{
		if(EnValidator.isEmpty(entId))
			return null;
		SqlParam param = new SqlParam();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN.ID_ENT AS ID_ENT, ");
		sb.append("EN.CODE AS CODE_ENT,");
		sb.append("EN.ID_PAT AS ID_PAT,");
		sb.append("pat.code AS code_pat,");// add by zhengcm 2018-03-19
		sb.append("pat.id_idtp AS Id_idtp,");
		sb.append("pat.sd_idtp AS Sd_idtp,");
		sb.append("pat.id_code AS Id_code,");
		sb.append("concat(area.fullname ,addr.street) AS Addr,");
		sb.append("EN.NAME_PAT AS NAME_PAT,");
		sb.append("EN.DT_BIRTH_PAT AS DT_BIRTH_PAT,");
		sb.append("EN.SD_SEX_PAT AS SD_SEX,");
		sb.append("EN.SD_MARI_PAT AS SD_MARI_PAT,");
		sb.append("EN.TELNO_PAT AS TELNO_PAT,");
		sb.append("EN.ID_DEP_PHY AS ID_DEP_PHY,");
		sb.append("EN.ID_EMP_PHY AS ID_EMP_PHY,");
		sb.append("EN.ID_HP AS ID_HP,");
		sb.append("EN.ID_PATCA AS ID_PATCA,");
		sb.append("EN.ID_PRIPAT AS ID_PRIPAT,");
		sb.append("EN.ID_PATCRET AS ID_PATCRET,");
		sb.append("EN.DT_ENTRY AS DT_ENTRY,");
		sb.append("DEP.NAME AS NAME_DEP_PHY,");
		sb.append("EMP.NAME AS NAME_EMP_PHY,");
		sb.append("HP.NAME AS NAME_HP,");
		sb.append("PATCA.NAME AS NAME_PATCA,");
		sb.append("PATPRI.NAME AS NAME_PRIPAT,");
		sb.append("PATCRET.NAME AS NAME_PATCRET,");
		sb.append("SEX.NAME AS NAME_SEX,");
		sb.append("MARI.NAME AS NAME_MARI_PAT,");
		sb.append("OP.CODE_AMR_OEP AS CODE_AMR_OEP, ");
		sb.append("OP.TIMES_OP AS TIMES_OP, ");
		sb.append("OP.SD_STATUS AS SD_STATUS, ");
		sb.append("ENHP.NO_HP AS NO_HP, ");
		sb.append("(case when EN.CODE_ENTP='00' then '01' when EN.CODE_ENTP='10' then '03' end) AS CATEGORY_CODE, ");//就诊类型编码
		sb.append("BD.NAME AS CATEGORY_NAME, ");//就诊类型名称
		sb.append("EN.CODE AS serialno  ");//流水号
		sb.append("FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		// add by zhengcm 2018-03-19
		sb.append("inner join pi_pat pat on pat.id_pat = en.id_pat ");
		sb.append("left join pi_pat_addr addr on addr.id_pat = pat.id_pat and addr.sd_addrtp = ? ");
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		sb.append("left join bd_adminarea area on area.id_adminarea = addr.id_admdiv ");
		sb.append("LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
		sb.append("LEFT JOIN BD_PSNDOC EMP ON EN.ID_EMP_PHY = EMP.ID_PSNDOC ");
		sb.append("LEFT JOIN BD_HP HP ON EN.ID_HP = HP.ID_HP ");
		sb.append("LEFT JOIN EN_ENT_HP ENHP ON EN.ID_ENT = ENHP.ID_ENT ");
		sb.append("LEFT JOIN PI_PAT_CA PATCA ON EN.ID_PATCA = PATCA.ID_PATCA ");
		sb.append("LEFT JOIN BD_PRI_PAT PATPRI ON EN.ID_PRIPAT = PATPRI.ID_PRIPAT ");
		sb.append("LEFT JOIN PI_PAT_CRET PATCRET ON EN.ID_PATCRET = PATCRET.ID_PATCRET ");
		sb.append("LEFT JOIN BD_UDIDOC SEX ON EN.ID_SEX_PAT = SEX.ID_UDIDOC ");
		sb.append("LEFT JOIN BD_UDIDOC MARI ON EN.ID_MARI_PAT = MARI.ID_UDIDOC ");
		sb.append("LEFT JOIN BD_ENTP BD ON EN.CODE_ENTP = BD.CODE ");
		sb.append("WHERE EN.ID_ENT = ? ");
		param.addParam(entId);
		
		@SuppressWarnings("unchecked")
		List<OpBasicDTO> list = (List<OpBasicDTO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(OpBasicDTO.class));
		if(!EnValidator.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}
}
