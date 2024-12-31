package iih.pe.pbd.qry.refs;

import iih.pe.pbd.qry.d.QryDO;
import iih.pe.pbd.qrycond.d.QryCondDO;
import iih.pe.comm.utils.PeEnvContextUtil;

import java.util.ArrayList;
import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;
/**
 * 查询明细
 * 
 * @author liujh_2017年10月17日09:39:01
 *
 */
@SuppressWarnings("serial")
public class QryCondItmRefsModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {

		return new String[] { QryDO.CODE, QryDO.NAME, };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { QryDO.ID_QRY, QryDO.DES };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "值" };
	}

	@Override
	public String getPkFieldCode() {
		 return QryDO.ID_QRY;
	}

	@Override
	public String getRefCodeField() {
		return QryDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return QryDO.NAME;
	}
	
	@Override
	public String getTableName() {
		return new QryDO().getTableName();
	}
	
	@Override
	public String getRefSql() {
		StringBuffer refSql = new StringBuffer();
		refSql.append("  select                                            ");
		refSql.append("  pe_pbd_qyr.code,                                  ");
		refSql.append("  pe_pbd_qyr.name,                                  ");
		refSql.append("  pe_pbd_qyr.id_qry,                                ");
		refSql.append("  pe_pbd_qyr.des                                    ");
		refSql.append("  from                                              ");
		refSql.append("  (                                                 ");
		refSql.append("         (                                          ");
		refSql.append("              select dep.id_dep as id_qry,          ");  //执行科室                        
		refSql.append("              dep.name,                             ");           
		refSql.append("              dep.code,                             ");           
		refSql.append("              'PE_DEP' des                          ");           
		refSql.append("              from BD_DEP dep                       ");                
		refSql.append("              where dep.fg_pe = 'Y'                 ");
		refSql.append("          )                                         ");
		refSql.append("          union all                                 "); //项目
		refSql.append("         (                                          ");  
		refSql.append("              select                                ");
		refSql.append("              pitm.id_pitm as id_qry,               ");
		refSql.append("              pitm.name, pitm.code,                 ");
		refSql.append("              'PE_PITM' des                         ");
		refSql.append("              from PE_PITM pitm                     ");
		refSql.append("          )                                         ");
		refSql.append("          union all                                 "); //项目结论
		refSql.append("          (                                         ");
		refSql.append("              select                                ");
		refSql.append("              diag.id_pitm_diag as id_qry,          ");                    
		refSql.append("              diag.name,                            ");           
		refSql.append("              diag.code,                            ");           
		refSql.append("              'PE_PITM_DIAG' des                    ");           
		refSql.append("              from PE_PITM_DIAG diag                ");
		refSql.append("          )                                         ");
		refSql.append("          union all                                 "); //小项结果
		refSql.append("          (                                         ");
		refSql.append("              select                                ");
		refSql.append("              rst.id_pitm_rst as id_qry,            ");                      
		refSql.append("              rst.name,                             ");           
		refSql.append("              rst.code,                             ");           
		refSql.append("              'PE_PITM_RST' des                     ");           
		refSql.append("              from PE_PITM_RST rst                  ");
		refSql.append("          )                                         ");                     
		refSql.append("          union all                                 "); //建议
		refSql.append("          (                                         ");
		refSql.append("              select sugg.id_pitm_sugg as id_qry,   ");               
		refSql.append("              sugg.name,                            ");           
		refSql.append("              sugg.code,                            ");           
		refSql.append("              'PE_PITM_SUGG' des                    ");           
		refSql.append("              from PE_PITM_SUGG sugg                ");
		refSql.append("          )                                         ");
		refSql.append("          union all                                 "); //小项
		refSql.append("          (                                         ");
		refSql.append("              select chkitm.id_pitm_chk,            ");
		refSql.append("              chkitm.name,                          ");
		refSql.append("              chkitm.code,                          ");
		refSql.append("              'PE_PITM_CHK' des                     ");
		refSql.append("              from PE_PITM_CHK chkitm               ");
		refSql.append("          )                                         ");
		refSql.append("                                                    ");
		refSql.append("  ) pe_pbd_qyr                                      ");
		refSql.append("  where 1 = 1                                       ");                
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : whereList) {
				refSql.append(" and (").append(where).append(") ");
			}
		}

		List<String> orderList = this.getOrderPart();
		if (orderList.size() > 0) {
			refSql.append(" order by ");
			for (int i = 0; i < orderList.size(); i++) {
				String order = orderList.get(i);
				refSql.append((i == 0 ? "" : ",") + order);
			}
		}
		return refSql.toString();
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new QryDO(), false));
		return super.getWherePart();
	}

}
