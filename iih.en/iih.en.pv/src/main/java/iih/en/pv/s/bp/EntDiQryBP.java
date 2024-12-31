package iih.en.pv.s.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntHisDiDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 就诊查询BP
 * @author liubin
 *
 */
public class EntDiQryBP {

	/**
	 * 获取患者的历史就诊诊断记录,为医嘱提供
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	public EntHisDiDTO[] getEntHisDiDTO(String patId) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN.ID_ENT AS ID_ENT,");
		sb.append("EN.ID_PAT AS ID_PAT, ");
		sb.append("EN.ID_ENTP AS ID_ENTP,");
		sb.append("EN.CODE_ENTP AS CODE_ENTP,");
		sb.append("EN.DT_ACPT AS DT_ACPT,");
		sb.append("DI.ID_ENTDI AS ID_ENTDI,");
		sb.append("DI.ID_DIDEF_DIS AS ID_DIDEF_DIS,");
		sb.append("DI.NAME_DIDEF_DIS AS NAME_DIDEF_DIS ");
		sb.append("FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_DI DI ON EN.ID_ENT = DI.ID_ENT ");
//		sb.append("WHERE DI.SD_CDSYSTP = ? ");
		sb.append("WHERE DI.FG_MAJ = ? ");
		sb.append("AND EN.FG_CANC = ? ");
		sb.append("AND EN.ID_PAT = ? ");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
//		param.addParam(ICiDictCodeConst.SD_DITP_XY);
		param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.FALSE);
		param.addParam(patId);
		List<EntHisDiDTO> list = (List<EntHisDiDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(EntHisDiDTO.class));
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new EntHisDiDTO[0]);
		}
		return null;
	}	
}
