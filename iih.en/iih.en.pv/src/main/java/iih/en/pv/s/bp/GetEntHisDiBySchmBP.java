package iih.en.pv.s.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnDiQrySchmDTO;
import iih.en.pv.dto.d.EntHisDiDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者的历史就诊诊断记录
 * @author liubin
 *
 */
public class GetEntHisDiBySchmBP {
	/**
	 * 获取患者的历史就诊诊断记录
	 * @param patCode 患者编码
	 * @param qrySchms 查询DTO数组
	 * @return
	 * @throws BizException
	 */
	public EntHisDiDTO[] exec(String patCode,EnDiQrySchmDTO[] qrySchms) throws BizException{
		if(EnValidator.isEmpty(patCode)){
			return null;
		}
		SqlParam param = new SqlParam();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN.ID_ENT AS ID_ENT,");
		sb.append("EN.ID_ENTP AS ID_ENTP,");
		sb.append("EN.CODE_ENTP AS CODE_ENTP,");
		sb.append("EN.DT_ACPT AS DT_ACPT,");
		sb.append("DI.ID_ENTDI AS ID_ENTDI,");
		sb.append("DI.ID_DIDEF_DIS AS ID_DIDEF_DIS,");
		sb.append("DI.NAME_DIDEF_DIS AS NAME_DIDEF_DIS,");
		sb.append("EN.ID_DEP_PHY AS ID_DEP,");
		sb.append("DEP.NAME AS NAME_DEP,");
		sb.append("EN.ID_EMP_PHY AS ID_EMP,");
		sb.append("EMP.NAME AS NAME_EMP ");
		sb.append("FROM EN_ENT EN ");
		sb.append("INNER JOIN PI_PAT PI ON EN.ID_PAT = PI.ID_PAT ");
		sb.append("LEFT JOIN EN_ENT_DI DI ON EN.ID_ENT = DI.ID_ENT ");
		sb.append("LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
		sb.append("LEFT JOIN BD_PSNDOC EMP ON EN.ID_EMP_PHY = EMP.ID_PSNDOC ");
		sb.append("WHERE DI.FG_MAJ = ? ");
		sb.append("AND EN.FG_CANC = ? ");
		sb.append("AND PI.CODE = ? ");
		param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.FALSE);
		param.addParam(patCode);
		sb.append("AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		if (!EnValidator.isEmpty(qrySchms)) {
			sb.append("AND ( ");
			boolean isFirst = true;
			for (EnDiQrySchmDTO qrySchm : qrySchms) {
				if (isFirst) {
					isFirst = false;
				} else {
					sb.append(" OR ");
				}
				sb.append(" ( ");
				sb.append("EN.CODE_ENTP = ? ");
				param.addParam(qrySchm.getCode_entp());
				if(qrySchm.getDt_begin()!=null){
					sb.append("AND EN.DT_ACPT >= ? ");
					param.addParam(qrySchm.getDt_begin());
				}
				if(qrySchm.getDt_end()!=null){
					sb.append("AND EN.DT_ACPT <= ? ");
					param.addParam(qrySchm.getDt_end());
				}
				//TODO：铜陵注掉 国际没有注掉
				//国际也要注释掉 2018-03-12 zhangwq
//				if (!EnValidator.isEmpty(qrySchm.getId_dep())) {
//					sb.append("AND EN.ID_DEP_PHY = ? ");
//					param.addParam(qrySchm.getId_dep());
//				}
//				if (!EnValidator.isEmpty(qrySchm.getId_emp())) {
//					sb.append("AND EN.ID_EMP_PHY = ? ");
//					param.addParam(qrySchm.getId_emp());
//				}
				sb.append(" ) ");
			}
			sb.append(") ");
		}
		sb.append("ORDER BY EN.DT_ACPT DESC ");
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		List<EntHisDiDTO> list = (List<EntHisDiDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(EntHisDiDTO.class));
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new EntHisDiDTO[0]);
		}
		return null;
	}
}
