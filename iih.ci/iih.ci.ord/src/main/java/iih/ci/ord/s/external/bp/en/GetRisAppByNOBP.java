package iih.ci.ord.s.external.bp.en;

import java.util.List;

import iih.ci.ord.dto.appobsdto.d.AppObsDto;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 通过申请单号，查询检查申请单信息
 * @author zhangwq
 *
 */
public class GetRisAppByNOBP {
	public AppObsDto exec(String no) throws DAException {
		// 组织查询sql字符串
		String sql = new StringBuilder()
				.append(" Select ord.Id_or, ord.Name_or, ord.Content_or, ord.Code_or, ord.Id_en, ord.Id_entp,  ord.id_pat, obs.dt_plan Dt_effe,")
				.append(" ord.Id_emp_sign, ord.Id_dep_sign,  ord.Id_srv, obs.No_ApplyForm Applyno,")
				.append(" ord.Fg_urgent,  ord.Des_or Desc_or  ,srv.Id_dep_mp , dep.name Name_dep_sign, dep1.name Name_dep_mp")
				.append(" From ci_ap_obs obs ").append(" left join ci_order ord on obs.Id_or = ord.Id_or ")
				.append(" left join ci_or_srv srv on srv.id_or = ord.id_or ")
				.append(" left join bd_dep dep on dep.id_dep = ord.id_dep_sign ")
				.append(" left join bd_dep dep1 on dep1.id_dep = srv.Id_dep_mp ")
				.append(" where ord.id_srv = srv.id_srv  and (ord.sd_su_or = '10' or ord.sd_su_or = '20') and obs.Sd_su_obs ='0' and obs.No_ApplyForm = ? ")
				.toString();
		// 增加参数
		SqlParam param = new SqlParam();
		param.addParam(no);

		// 数据库查询并返回
		List<AppObsDto> rstList = (List<AppObsDto>) new DAFacade().execQuery(sql, param,
				new BeanListHandler(AppObsDto.class));
		return rstList != null && rstList.size() > 0 ? rstList.get(0) : null;
	}
}
