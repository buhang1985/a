package iih.en.pv.s.bp.ip.qry;

import java.util.ArrayList;
import java.util.List;

import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.HosRecallQryDTO;
import iih.en.pv.dto.d.LvHosAppDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.bp.ip.LvHosCheckBP;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 
 * 获取住院处出院 患者列表
 * 
 * @author fanlq
 *
 */
public class GetLvHosListByQryDTOBP {

	public LvHosAppDTO[] exec(HosRecallQryDTO recallQryDTO) throws BizException {
		if(EnValidator.isEmpty(recallQryDTO))
			return null;
		LvHosAppDTO[] appDTOArray = null;
		GetLvHosDTOArrayBP lvHosBP = new GetLvHosDTOArrayBP();	
		if(!EnValidator.isEmpty(recallQryDTO.getIp_code())){
			String[] id_ents = getIdEnt(recallQryDTO.getIp_code());
			appDTOArray = lvHosBP.exec(id_ents);
		}else{
			appDTOArray = lvHosBP.exec(recallQryDTO.getId_dep(),recallQryDTO.getId_nur());
		}
		if(EnValidator.isEmpty(appDTOArray))
			return null;
		//设置年龄,从前天移到后台 - zhangpp 2019.05.17
		EnAgeCalcUtil.setDoAges(appDTOArray, "Id_ent", "Age");
		//检查
		LvHosCheckBP checkBP = new LvHosCheckBP();		
		checkBP.exec(appDTOArray);
		return appDTOArray;
	}
	
	private String[] getIdEnt(String code_amr_ip) throws BizException{
		if(!EnValidator.isEmpty(code_amr_ip)){
			List<String> idEntList = new ArrayList<String>();
			StringBuffer sql = new StringBuffer();
			SqlParam param = new SqlParam();
			sql.append("SELECT ENT.ID_DEP_PHY, ");
			sql.append("ENT.ID_DEP_NUR, " );
			sql.append("ENT.ID_ENT " );
			sql.append("FROM EN_ENT ENT " );
			sql.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT " );
			sql.append("WHERE ENT.FG_IP = 'Y' " );
			sql.append("AND PAT.CODE_AMR_IP = ? ");
			param.addParam(code_amr_ip);
			List<PatiVisitDO> dtoList = (List<PatiVisitDO>) new DAFacade()
					.execQuery(sql.toString(), param, new BeanListHandler(
							PatiVisitDO.class));
			if(!EnValidator.isEmpty(dtoList)){
				for(PatiVisitDO ent : dtoList){
					if(!idEntList.contains(ent.getId_ent())){
						idEntList.add(ent.getId_ent());
					}
				}
				if(!EnValidator.isEmpty(idEntList)){
					return idEntList.toArray(new String[]{});
				}
			}
		}
		return null;
	}
	
	
}
