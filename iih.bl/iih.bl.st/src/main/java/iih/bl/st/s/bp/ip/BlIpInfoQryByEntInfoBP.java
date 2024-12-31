package iih.bl.st.s.bp.ip;

import java.util.List;

import iih.bl.pay.dto.d.BlBannerDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 住院患者信息查询banner
 * 
 * @author zhangxin
 * @date 2019年11月26日
 */
public class BlIpInfoQryByEntInfoBP {
	/**
	 * 住院患者信息查询banner
	 * 
	 * @author zhangxin
	 * @date 2019年11月26日
	 * @param inputValue
	 * @param selectCondition
	 * @return
	 * @throws BizException
	 */
	public BlBannerDTO[] exec(String inputValue, String[] selectCondition) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select distinct(t.id_ent),p.id_pat,p.name as name_pat,t.code as code_ent,t.dt_entry as dt_in,e.times_ip,r.id_pripat,r.name as name_pripat,h.id_hp,h.name as name_hp,t.fg_ip ")
				.append("from en_ent t ").append("inner join pi_pat p on p.id_pat = t.id_pat ")
				.append("inner join en_ent_ip e on e.id_ent = t.id_ent ")
				.append("inner join bd_pri_pat r on r.id_pripat = t.id_pripat ")
				.append("left join en_ent_hp n on n.id_ent = t.id_ent and n.fg_maj = 'Y' ")
				.append("left join bd_hp h on h.id_hp = n.id_hp ")
				.append("left outer join pi_pat_card c on c.id_pat = p.id_pat ").append("where t.code_entp = 10 ")
				.append("and t.fg_canc = 'N' ");
		if (selectCondition != null && selectCondition.length > 0) {
			sql.append("and (");
			StringBuffer wheresql = new StringBuffer();
			for (String cond : selectCondition) {
				if ("code_ent".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("t.code like '%").append(inputValue).append("%'");
				} else if ("id_pat".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.id_pat like '%").append(inputValue).append("%'");
				} else if ("code_pat".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.code like '%").append(inputValue).append("%'");
				} else if ("id_code".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.id_code like '%").append(inputValue).append("%'");
				} else if ("barcode_chis".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.barcode_chis like '%").append(inputValue).append("%'");
				} else if ("code_amr_ip".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.code_amr_ip like '%").append(inputValue).append("%'");
				} else if ("patcode".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("c.code like '%").append(inputValue).append("%'");
				}
			}
			sql.append(wheresql.toString());
			sql.append(") ");
		}
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new PatiVisitDO(), "t");// 增加组织隔离
		sql.append(sqlContext);
		sql.append(" order by p.id_pat,e.times_ip desc");
		List<BlBannerDTO> list = (List<BlBannerDTO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(BlBannerDTO.class));
		return list.toArray(new BlBannerDTO[] {});
	}
}
