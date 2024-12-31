package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.HosRecallDTO;
import iih.en.pv.dto.d.HosRecallQryDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 住院处出院召回-查询出院记录
 * @author fanlq
 *
 */
public class GetLvDtoForRecallByQryDTOBP {
	/**
	 * 住院处出院召回-查询出院记录
	 * 
	 * @param recallQryDTO
	 *            查询方案
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public HosRecallDTO[] exec(HosRecallQryDTO recallQryDTO) throws BizException {
		if(recallQryDTO == null){
			return null;
		}
		SqlParam param = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ENT.ID_ENT,DEP.NAME AS NAME_DEP,NUR.NAME AS NAME_NUR,");
		sqlBuilder.append("ENT.ID_PAT,ENT.NAME_PAT,ENT.DT_BIRTH_PAT, ENT.FG_ST, ENT.ID_DEP_PHY, ENT.ID_DEP_NUR, ");
		sqlBuilder.append("ENT.DT_END,ENT.SD_SEX_PAT,IP.ID_BED,IP.NAME_BED , IP.CODE_AMR_IP CODE ,IP.FG_NEWBORN, ");
		sqlBuilder.append("DOC.NAME AS Name_emp_recall,IP.DT_DISC AS Dt_recall,");
		sqlBuilder.append("NB.ID_ENT_MOM ");
		sqlBuilder.append("FROM EN_ENT ENT ");
		sqlBuilder.append("INNER JOIN EN_ENT_IP IP ON ENT.ID_ENT=IP.ID_ENT ");
		sqlBuilder.append("LEFT JOIN EN_ENT_NB NB ON NB.ID_ENT_BB = ENT.ID_ENT ");
		sqlBuilder.append("LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = ENT.ID_DEP_PHY ");
		sqlBuilder.append("LEFT JOIN BD_DEP NUR ON NUR.ID_DEP = ENT.ID_DEP_NUR ");
		sqlBuilder.append("LEFT JOIN BD_PSNDOC DOC ON DOC.ID_PSNDOC = IP.ID_EMP_DISC ");
		sqlBuilder.append("WHERE ENT.FG_IP='N' AND IP.SD_STATUS= ? ");// 出院
		sqlBuilder.append("AND ENT.CODE_ENTP <> ? "); //过滤掉预住院患者
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT);
		param.addParam(IEnDictCodeConst.SD_ENTP_IPPRE);

		//1.科室
		if(!EnValidator.isEmpty(recallQryDTO.getId_dep())){
			sqlBuilder.append("AND ENT.ID_DEP_PHY = ? ");
			param.addParam(recallQryDTO.getId_dep());
		}
		//2.病区
		if(!EnValidator.isEmpty(recallQryDTO.getId_nur())){
			sqlBuilder.append("AND ENT.ID_DEP_NUR = ? ");
			param.addParam(recallQryDTO.getId_nur());
		}
		//3.日期
		if(recallQryDTO.getD_begin() != null){
			sqlBuilder.append("AND ENT.DT_END >= ? ");
			param.addParam(recallQryDTO.getD_begin() + " 00:00:00");
		}
		if(recallQryDTO.getD_ent() != null){
			sqlBuilder.append("AND ENT.DT_END <= ? ");
			param.addParam(recallQryDTO.getD_ent() + " 23:59:59");
		}
		//4.患者姓名
		if(!EnValidator.isEmpty(recallQryDTO.getName_pat())){
			sqlBuilder.append("AND ENT.NAME_PAT like  ? ");
			param.addParam("%"+recallQryDTO.getName_pat()+"%");
		}
		//5.住院号
		if(!EnValidator.isEmpty(recallQryDTO.getIp_code())){
			sqlBuilder.append("AND IP.CODE_AMR_IP like ?  ");
			param.addParam("%"+recallQryDTO.getIp_code()+"%");
		}
		
		sqlBuilder.append(" ORDER BY DT_END DESC, IP.ID_BED DESC ");// 按出院时间倒序排列

		List<HosRecallDTO> dtoList = (List<HosRecallDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(HosRecallDTO.class));
		//设置费用标志
		new GetLvDtoForRecallBP().setBlFalg(dtoList);	
		if (dtoList != null) {
			return dtoList.toArray(new HosRecallDTO[0]);
		}
		return null;
	}
}
