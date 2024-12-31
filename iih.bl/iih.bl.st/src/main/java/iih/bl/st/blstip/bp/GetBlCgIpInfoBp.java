package iih.bl.st.blstip.bp;

import iih.bl.params.BlParams;
import iih.bl.st.blcgipdto.d.BlCgIpDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;

import java.util.List;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 对患者进行后台划价记账，根据诊断id、科室id和结束时间获取记账信息
 * 
 * @author liwenqiang
 *
 */
public class GetBlCgIpInfoBp {
	/**
	 * 对患者进行后台划价记账，根据诊断id、科室id和结束时间获取记账信息
	 * 
	 * @param id_ent
	 * @param id_dep
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlCgIpDTO[] exec(String entId, String depId, FDateTime endDt)
			throws BizException {
		// 获取BLSTIP0005 是否母婴合并结算参数 by liwq 2017-9-23 16:23:53
		// 查询合计金额
		StringBuilder sql = new StringBuilder();
		sql.append(" select sum(amt_pat*eu_direct) amt_pat,sum(amt_hp*eu_direct) amt_hp,sum(amt_std*eu_direct) amt_std, ");
		sql.append(" sum(amt*eu_direct) amt,sum(amt_ratio*eu_direct) amt_ratio from bl_cg_ip a0 where  ");
		sql.append(this.getSqlParam(entId, depId, endDt));

		List<BlCgIpDTO> list = (List<BlCgIpDTO>) new DAFacade().execQuery(
				sql.toString(), new BeanListHandler(BlCgIpDTO.class));

		if (list.get(0).getAmt() == null || list.get(0).getAmt_ratio() == null)
			return null;
		return list.toArray(new BlCgIpDTO[] {});

	}

	public String getSqlParam(String id_ent, String id_dep, FDateTime dt_end)
			throws BizException {
		StringBuffer sqlQur = new StringBuffer();
		// 获取BLSTIP0005 是否母婴合并结算参数 by liwq 2017-9-23 16:23:53
		FBoolean isMerge =  BlParams.BLSTIP0005();
		IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO enNewBorn = enService.getNewbornDO(id_ent);
		if (FBoolean.TRUE.equals(isMerge)) {
			if (enNewBorn != null)
				sqlQur.append(" a0.FG_ST = 'N' ").append(" AND (a0.ID_ENT = '")
						.append(enNewBorn.getId_ent_mom())
						.append("' or a0.id_ent_mom = '")
						.append(enNewBorn.getId_ent_mom()).append("') ");
			else
				sqlQur.append(" a0.FG_ST = 'N' ").append(" AND (a0.ID_ENT = '")
						.append(id_ent).append("' or a0.id_ent_mom = '")
						.append(id_ent).append("') ");
		} else {
			sqlQur.append(" a0.FG_ST = 'N' ").append(" AND (a0.ID_ENT = '")
					.append(id_ent).append("') ");
		}

		// 判断如果id_dep为*则查找所有科室的就诊,否则查找单科室的就诊数据
		if (!StringUtils.isBlank(id_dep) && !"*".equals(id_dep)) {
			sqlQur.append(" AND a0.ID_DEP_OR = '").append(id_dep).append("' ");
		}
		String dt_end_str = dt_end.getDate().getDateAfter(1).toString()
				+ " 00:00:00";
		sqlQur.append(" AND a0.DT_CG < '").append(dt_end_str).append("' ");
		return sqlQur.toString();
	}
}
