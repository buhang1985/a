package iih.bl.cg.oepfeeitemqry.bp;

import java.util.List;

import iih.bl.cg.dto.d.OepfeeitmqryDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 文件头注释
 * ========================================================================
 * ======
 * 
 * @Filename: OepfeeitmqryBp
 * @Date: 2016/06/30 10:37:15
 * @Compiler: Eclipse luna 4.4.1
 * @author li_pengying
 * @Company: Copyright 2016 by PKU healthcare IT Co.,Ltd.
 * @Description: 门诊费用项目查询节点用接口实现类的方法：通过查询节点来进行门诊费用项目的查询
 *               ==========================
 *               ====================================================
 */
public class OepfeeitmqryBp {

	public OepfeeitmqryDTO[] findByQueryCondsforOepfeeitmqry(String[] conds) throws BizException {
		// TODO Auto-generated method stub
		SqlParam params = new SqlParam();
		if (conds[0] == null && conds[1] == null)
			return null;

		StringBuffer whereSql = new StringBuffer();
		if (conds[0] != null && conds[1] != null) {
			whereSql.append(" and B.dt_cg>=?  and B.dt_cg< ?");
			params.addParam(conds[0] + " 00:00:00");
			params.addParam(conds[1] + " 23:59:59");
		}

		if (conds[2]!= null) {
			whereSql.append(" and A.id_dep_or like ?");
			params.addParam("%"+conds[2]+"%");
		}

		if (conds[3] != null) {
			whereSql.append(" and A.id_dep_mp like ?");
			params.addParam("%"+conds[3]+"%");
		}

		if (conds[4] != null) {
			whereSql.append(" and A.name_srv like ?");
			params.addParam("%"+conds[4]+"%");
		}

		if (conds[5] != null) {
			whereSql.append(" and A.id_grp like ?");
			params.addParam("%"+conds[5]+"%");
		}

		if (conds[6] != null) {
			whereSql.append(" and A.id_org like ?");
			params.addParam("%"+conds[6]+"%");
		}

		StringBuffer strbuf = new StringBuffer();
		strbuf.append(" select id_srv,name_srv,sum(amt) as amtsum,count(*)  as count  from ");
		strbuf.append(" (select  distinct  A.Id_Srv,A.NAME_SRV, A.Id_Cgitmoep,B.Id_Cgoep,  (B.EU_DIRECT*A.AMT) AS AMT,A.ID_DEP_MP,A.ID_DEP_OR,B.Dt_Cg,C.NAME as name_dep_mp,D.NAME as name_dep_or,E.NAME as name_org ");
		strbuf.append(" from  bl_cg_itm_oep A ");
		strbuf.append("  join bl_cg_oep     B  on A.ID_CGOEP=B.ID_CGOEP ");
		strbuf.append(" left join bd_dep  C on A.ID_DEP_MP=C.ID_DEP ");
		strbuf.append(" left join bd_dep D on A.ID_DEP_OR=D.ID_DEP ");
		strbuf.append(" left join bd_org E on A.ID_ORG=E.ID_ORG  where 1=1  ");
		strbuf.append(whereSql);
		strbuf.append("  order by dt_cg asc )X  group by id_srv,name_srv ");

		List<OepfeeitmqryDTO> list = (List<OepfeeitmqryDTO>) new DAFacade().execQuery(strbuf.toString(), params, new BeanListHandler(OepfeeitmqryDTO.class));
		OepfeeitmqryDTO[] ofiqdtos = list.toArray(new OepfeeitmqryDTO[] {});
		TimeService timeService = new TimeServiceImpl();
		FDateTime dateTime = timeService.getUFDateTime();
		String dtnowstr = dateTime.toStdString();
		for (int i = 0; i < ofiqdtos.length; i++) {
			ofiqdtos[i].setDt_print(dtnowstr);
		}
		return ofiqdtos;
	}

}
