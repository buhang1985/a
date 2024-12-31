package iih.ci.ord.s.mtsa;

import java.util.List;

import iih.bd.base.database.DatabaseUtils;
import iih.bd.base.database.SqlConditionsParameter;
import iih.ci.ord.mtsa.IMtSummaryAmountService;
import iih.ci.ord.mtsa.d.MtBizSummaryAmountDTO;
import iih.ci.ord.mtsa.d.MtFilterSummaryQryDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.kernel.SqlParam;

@Service(serviceInterfaces = { IMtSummaryAmountService.class }, binding = Binding.JSONRPC)
public class MtSummaryAmountServiceImpl implements IMtSummaryAmountService {

	@Override
	public MtBizSummaryAmountDTO[] load(MtFilterSummaryQryDTO param) throws BizException {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(param.getId_dep());
		sqlParam.addParam(param.getDt_begin().toStdString());
		sqlParam.addParam(param.getDt_end());
		sqlParam.addParam(param.getId_dep());
		sqlParam.addParam(param.getDt_begin().toStdString());
		sqlParam.addParam(param.getDt_end());
		
		StringBuilder sb = new StringBuilder();
		sb.append("(SELECT '门诊部' Name_summary_item,")
				.append(" COUNT(DISTINCT decode(CGI.ID_OR,'~',CGI.Id_Cgitmoep,CGI.id_or)) Pat_count,")
				.append(" nvl(SUM(CG.EU_DIRECT * CGI.AMT_RATIO),0.00) Amount,'00' Code_entp")
				.append(" FROM BL_CG_OEP CG")
				.append(" JOIN BL_CG_ITM_OEP CGI")
				.append(" ON CG.ID_CGOEP = CGI.ID_CGOEP")
				.append(" WHERE CGI.ID_DEP_MP = ?")
				.append(" AND CG.DT_CG BETWEEN ? AND ?")
				.append(" )")
				.append(" union")
				.append(" ( ")
				.append(" SELECT '住院部' Name_summary_item,")
				.append(" COUNT(DISTINCT decode(CGI.ID_OR,'~',CGI.Id_Cgip,CGI.id_or)) Pat_count,")
				.append(" nvl(SUM(CGI.EU_DIRECT * CGI.AMT_RATIO),0.00) Amount,'10' Code_entp")
				.append(" FROM BL_CG_IP CGI")
				.append(" WHERE CGI.ID_DEP_MP = ?")
				.append(" AND CGI.DT_CG BETWEEN ? AND ?")
				.append(" )");
		
		
		List<MtBizSummaryAmountDTO> rstList = DatabaseUtils.Q(new SqlConditionsParameter(sb.toString(), sqlParam), MtBizSummaryAmountDTO.class) ;

		return rstList != null && rstList.size() > 0?rstList.toArray(new MtBizSummaryAmountDTO[rstList.size()]):null;
	}

	@Override
	public MtBizSummaryAmountDTO[] loadByEntp(String entp, MtFilterSummaryQryDTO param) throws BizException {
		StringBuilder sb = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		if("00".equals(entp)) {
			sqlParam.addParam(param.getId_dep());
			sqlParam.addParam(param.getDt_begin().toStdString());
			sqlParam.addParam(param.getDt_end());
			
			sb.append(" SELECT CGI.ID_SRV Id_summary_item,")
			  .append(" CGI.NAME_SRV Name_summary_item,")
			  .append(" COUNT(DISTINCT CGI.Id_ent||decode(CGI.ID_OR,'~',CGI.Id_Cgitmoep,CGI.id_or)) Pat_count,")
			  .append(" SUM(CG.EU_DIRECT * CGI.AMT_RATIO) Amount, '00' Code_entp")
			  .append(" FROM BL_CG_OEP CG")
			  .append(" JOIN BL_CG_ITM_OEP CGI")
			  .append(" ON CG.ID_CGOEP = CGI.ID_CGOEP")
			  .append(" WHERE CGI.ID_DEP_MP = ?")
			  .append(" AND CG.DT_CG BETWEEN ? AND ?")
			  .append(" GROUP BY CGI.ID_SRV, CGI.NAME_SRV");
			  
		}
		else if("10".equals(entp)) {
			sqlParam.addParam(param.getId_dep());
			sqlParam.addParam(param.getDt_begin().toStdString());
			sqlParam.addParam(param.getDt_end());
			
			sb.append(" SELECT CGI.ID_SRV Id_summary_item,")
			  .append(" CGI.NAME_SRV Name_summary_item,")
			  .append(" COUNT(DISTINCT CGI.Id_ent||decode(CGI.ID_OR,'~',CGI.Id_Cgip,CGI.id_or)) Pat_count,")
			  .append(" SUM(CGI.EU_DIRECT * CGI.AMT_RATIO) Amount, '10' Code_entp")
			  .append(" FROM BL_CG_IP CGI")
			  .append(" WHERE CGI.ID_DEP_MP = ?")
			  .append(" AND CGI.DT_CG BETWEEN ? AND ?")
			  .append(" GROUP BY CGI.ID_SRV, CGI.NAME_SRV");
		}
		else {
			sqlParam.addParam(param.getId_dep());
			sqlParam.addParam(param.getDt_begin().toStdString());
			sqlParam.addParam(param.getDt_end());
			sqlParam.addParam(param.getId_dep());
			sqlParam.addParam(param.getDt_begin().toStdString());
			sqlParam.addParam(param.getDt_end());
			
		  sb.append("select Id_summary_item,Name_summary_item,sum(pat_count) as pat_count,sum(amount) amount from ((")
		  .append(" SELECT CGI.ID_SRV Id_summary_item,")
		  .append(" CGI.NAME_SRV Name_summary_item,")
		  .append(" COUNT(DISTINCT decode(CGI.ID_OR,'~',CGI.Id_Cgitmoep,CGI.id_or)) Pat_count,")
		  .append(" SUM(CG.EU_DIRECT * CGI.AMT_RATIO) Amount, '00' Code_entp")
		  .append(" FROM BL_CG_OEP CG")
		  .append(" JOIN BL_CG_ITM_OEP CGI")
		  .append(" ON CG.ID_CGOEP = CGI.ID_CGOEP")
		  .append(" WHERE CGI.ID_DEP_MP = ?")
		  .append(" AND CG.DT_CG BETWEEN ? AND ?")
		  .append(" GROUP BY CGI.ID_SRV, CGI.NAME_SRV")
		  .append(" ) union all (")
		  .append(" SELECT CGI.ID_SRV Id_summary_item,")
		  .append(" CGI.NAME_SRV Name_summary_item,")
		  .append(" COUNT(DISTINCT decode(CGI.ID_OR,'~',CGI.Id_Cgip,CGI.id_or)) Pat_count,")
		  .append(" SUM(CGI.EU_DIRECT * CGI.AMT_RATIO) Amount, '10' Code_entp")
		  .append(" FROM BL_CG_IP CGI")
		  .append(" WHERE CGI.ID_DEP_MP = ?")
		  .append(" AND CGI.DT_CG BETWEEN ? AND ?")
		  .append(" GROUP BY CGI.ID_SRV, CGI.NAME_SRV))")
		  .append(" Group by Id_summary_item,Name_summary_item");
		}
	  List<MtBizSummaryAmountDTO> rstList = DatabaseUtils.Q(new SqlConditionsParameter(sb.toString(), sqlParam), MtBizSummaryAmountDTO.class) ;

		return rstList != null && rstList.size() > 0?rstList.toArray(new MtBizSummaryAmountDTO[rstList.size()]):null;
	}

	@Override
	public MtBizSummaryAmountDTO[] loadBySrv(String entp, String id_srv, MtFilterSummaryQryDTO param) throws BizException {
		StringBuilder sb = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		if("00".equals(entp)) {
			sqlParam.addParam(param.getId_dep());
			sqlParam.addParam(param.getDt_begin().toStdString());
			sqlParam.addParam(param.getDt_end());
			sqlParam.addParam(id_srv);
			
			sb.append(" SELECT PI.NAME name_summary_item,PI.CODE Id_summary_item,CG.EU_DIRECT * CGI.AMT_STD amount, '00' Code_entp")
			.append(" FROM BL_CG_OEP CG")
			.append(" JOIN BL_CG_ITM_OEP CGI ON CG.ID_CGOEP = CGI.ID_CGOEP")
			.append(" JOIN PI_PAT PI ON CGI.ID_PAT = PI.ID_PAT")
			.append(" WHERE CGI.ID_DEP_MP = ?")
			.append(" AND CG.DT_CG BETWEEN ? AND ?")
			.append(" AND CGI.ID_SRV = ? order by pi.name ");
		}
		else if ("10".equals(entp)) {
			sqlParam.addParam(param.getId_dep());
			sqlParam.addParam(param.getDt_begin().toStdString());
			sqlParam.addParam(param.getDt_end());
			sqlParam.addParam(id_srv);
			
			sb.append(" SELECT PI.NAME name_summary_item,PI.CODE_AMR_IP Id_summary_item,CGI.EU_DIRECT * CGI.AMT_STD amount, '10' Code_entp")
			.append(" FROM BL_CG_IP CGI")
			.append(" JOIN PI_PAT PI ON CGI.ID_PAT = PI.ID_PAT")
			.append(" WHERE CGI.ID_DEP_MP = ?")
			.append(" AND CGI.DT_CG BETWEEN ? AND ?")
			.append(" AND cgi.id_srv = ? order by pi.name ");
		}
		else {
			sqlParam.addParam(param.getId_dep());
			sqlParam.addParam(param.getDt_begin().toStdString());
			sqlParam.addParam(param.getDt_end());
			sqlParam.addParam(id_srv);
			sqlParam.addParam(param.getId_dep());
			sqlParam.addParam(param.getDt_begin().toStdString());
			sqlParam.addParam(param.getDt_end());
			sqlParam.addParam(id_srv);
			
			sb.append(" select * from ((SELECT PI.NAME name_summary_item,PI.CODE Id_summary_item,CG.EU_DIRECT * CGI.AMT_STD amount, '00' Code_entp")
			.append(" FROM BL_CG_OEP CG")
			.append(" JOIN BL_CG_ITM_OEP CGI ON CG.ID_CGOEP = CGI.ID_CGOEP")
			.append(" JOIN PI_PAT PI ON CGI.ID_PAT = PI.ID_PAT")
			.append(" WHERE CGI.ID_DEP_MP = ?")
			.append(" AND CG.DT_CG BETWEEN ? AND ?")
			.append(" AND CGI.ID_SRV = ?")
			.append(" ) union all(")
			.append(" SELECT PI.NAME name_summary_item,PI.CODE_AMR_IP Id_summary_item,CGI.EU_DIRECT * CGI.AMT_STD amount, '10' Code_entp")
			.append(" FROM BL_CG_IP CGI")
			.append(" JOIN PI_PAT PI ON CGI.ID_PAT = PI.ID_PAT")
			.append(" WHERE CGI.ID_DEP_MP = ?")
			.append(" AND CGI.DT_CG BETWEEN ? AND ?")
			.append(" AND cgi.id_srv = ?)) order by name_summary_item,code_entp");
		}
		
		if(sb.length() == 0) {
			return null;
		}
		List<MtBizSummaryAmountDTO> rstList = DatabaseUtils.Q(new SqlConditionsParameter(sb.toString(), sqlParam), MtBizSummaryAmountDTO.class) ;

		return rstList != null && rstList.size() > 0?rstList.toArray(new MtBizSummaryAmountDTO[rstList.size()]):null;
	}

}
