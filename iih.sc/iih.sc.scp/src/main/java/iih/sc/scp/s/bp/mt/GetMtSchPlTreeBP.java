package iih.sc.scp.s.bp.mt;

import java.util.List;

import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scp.dto.d.MtSchPlTreeDTO;
import iih.sc.scp.scplan.d.EuEditTp;
import iih.sc.scp.scplan.d.desc.ScPlanDODesc;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取医技排班计划树
 * @author 
 *
 */
public class GetMtSchPlTreeBP {
	/**
	 * 获取医技排班计划树
	 * @param depId 科室id
	 * @return MtSchPlTreeDTO数组
	 * @throws BizException
	 */
	public MtSchPlTreeDTO[] exec(String depId, String sctp) throws BizException {
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append("SELECT DISTINCT ");
		sb.append("SC_PL.ID_DEP||'_'||SC_PL.ID_SCSRV AS ID,");
		sb.append("SC_PL.ID_SCSRV AS ID_SCSRV,");
		sb.append("SC_SRV.CODE AS CODE_SCRSV,");
		sb.append("SC_SRV.NAME AS NAME_SCSRV,");
		sb.append("SC_SRV.NOTE AS NOTE,");
		sb.append("SC_PL.ID_DEP AS ID_DEP,");
		sb.append("BD_DEP.CODE AS CODE_DEP,");
		sb.append("BD_DEP.NAME AS NAME_DEP ");
		sb.append("FROM SC_PL SC_PL ");
		sb.append("INNER JOIN SC_SRV SC_SRV ON SC_PL.ID_SCSRV = SC_SRV.ID_SCSRV ");
		sb.append("INNER JOIN BD_DEP BD_DEP ON SC_PL.ID_DEP = BD_DEP.ID_DEP ");
		sb.append("WHERE 1=1 ");
		sb.append(" AND ").append(ScGroupControlUtils.getGroupControlFitler(new ScPlanDODesc(), "SC_PL"));
		sb.append(" AND SC_PL.SD_SCTP = ? ");
		param.addParam(sctp);
		sb.append("AND SC_PL.EU_EDIT_TP = ? ");
		param.addParam(EuEditTp.COMMON);
		if(!ScValidator.isEmptyIgnoreBlank(depId)){
			sb.append("AND SC_PL.ID_DEP = ?");
			param.addParam(depId);
		}
		String sql = sb.toString();
		List<MtSchPlTreeDTO> list = (List<MtSchPlTreeDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(MtSchPlTreeDTO.class));
		if(!ListUtil.isEmpty(list))
			return list.toArray(new MtSchPlTreeDTO[0]);
		return null;
	}
}
