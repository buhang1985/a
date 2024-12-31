package iih.bl.st.s.bp;

import java.util.List;

import iih.bl.st.dto.blipchargechk.d.BlIpChargeChkOrdDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院费用核对医嘱信息查询类
 * @author ly 2017/10/10
 *
 */
public class GetBlIpChargeChkOrdBP {

	/**
	 * 住院费用核对查询医嘱信息
	 * @param qryRootNodeDTO 查询方案
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlIpChargeChkOrdDTO[] exec(QryRootNodeDTO qryRootNodeDTO, String entId) throws BizException{
		
		if(StringUtil.isEmpty(entId))
			throw new BizException("住院费用核对医嘱查询服务：入参就诊id为空");
		
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		String qryCond = "";
		if (qryRootNodeDTO != null) {
			qryCond = service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
 		
 		//处理baby
		String entWhere = "('" + entId +"'";
 		List<String> bIds = this.getBabyEntIds(entId);
 		if(!ListUtil.isEmpty(bIds)){
 			for (String id : bIds) {
 				entWhere += ",'" + id +"'";
			}
 		}
		entWhere += ")";
 		
		String sql = this.getSql(qryCond, entWhere);
 		
 		
 		DAFacade daf = new DAFacade();
 		List<BlIpChargeChkOrdDTO> rlt = (List<BlIpChargeChkOrdDTO>)daf.execQuery(
 				sql, new BeanListHandler(BlIpChargeChkOrdDTO.class));
 		
		if(ListUtil.isEmpty(rlt))
			return null;
 		
		return rlt.toArray(new BlIpChargeChkOrdDTO[rlt.size()]);
	}
	
	/**
	 * 查询sql
	 * @param qryCond
	 * @param entWhere
	 * @return
	 */
	private String getSql(String qryCond,String entWhere){
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("ord.id_or,");
		sqlSb.append("ord.content_or,");
		sqlSb.append("case when ord.fg_long = 'Y' then '长期' else '临时' end fg_long,");
		sqlSb.append("doc.name name_su_or,");
		sqlSb.append("doc2.name name_su_bl,");
		sqlSb.append("ord.dt_effe,");
		sqlSb.append("ord.dt_end,");
		sqlSb.append("psn.name name_emp_or,");
		sqlSb.append("nvl((select sum(ip.amt * ip.eu_direct) from bl_cg_ip ip where ip.id_or = ord.id_or),0.00) sum_amt ");
		sqlSb.append("from ci_order ord ");
		sqlSb.append("left join bd_psndoc psn ");
		sqlSb.append("on ord.id_emp_or = psn.id_psndoc ");
		sqlSb.append("left join bd_udidoc doc ");
		sqlSb.append("on ord.id_su_or = doc.id_udidoc ");
		sqlSb.append("left join bd_udidoc doc2 ");
		sqlSb.append("on ord.id_su_bl = doc2.id_udidoc ");
		sqlSb.append("where ord.id_en in " + entWhere);
		sqlSb.append(" and ord.sd_su_or > '10' ");//护士核对之后的
		if (!StringUtil.isEmpty(qryCond)) {
			sqlSb.append(" and " + qryCond);
		}
		
		sqlSb.append(" order by ord.dt_effe ");
		return sqlSb.toString();
	}
	
	/**
	 * 获取baby就诊id
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<String> getBabyEntIds(String entId)throws BizException{
		
		String sql = "select id_ent_bb from en_ent_nb where id_ent_mom = ? ";
		DAFacade daf = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(entId);
		
		List<String> rlt = (List<String>)daf.execQuery(sql, param, new ColumnListHandler());
		return rlt;
	}
}
