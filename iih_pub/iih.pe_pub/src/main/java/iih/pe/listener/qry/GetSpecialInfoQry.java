package iih.pe.listener.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSpecialInfoQry implements ITransQry {

	String id_pepsnappt,peNormalDepCode;
	public GetSpecialInfoQry(String id_pepsnappt, String peNormalDepCode){
		this.id_pepsnappt = id_pepsnappt;
		this.peNormalDepCode = peNormalDepCode;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		param.addParam(id_pepsnappt);
		param.addParam(id_pepsnappt);
		param.addParam(id_pepsnappt);
		//param.addParam(peNormalDepCode);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("select c.code as Specialinfocode,");//专科编码
		sb.append("    c.name as Name,");//专科名称
		sb.append("    case when g.SUMUP is null then '未见异常' else g.SUMUP end as Fullcontent,");//小结建议完整内容
		sb.append("	   doc.code_doc as Rptdoccode,");//医生编码(报告人)
		sb.append("    doc.name_doc as Rptdocname,");//医生名称
		sb.append("    doc.code_doc as Rvdoccode,");//审核人编码
		sb.append("	doc.name_doc as Rvdocname");//审核人名称
		sb.append("  from pe_wf_perst rst ");
		sb.append(" inner join PE_ITM_PESRVITEM c");
		sb.append("   on rst.ID_PESRVITEM = c.ID_PESRVITEM");
		sb.append(" inner join pe_bd_deptset d                                                             ");
		sb.append("    on c.id_pedeptset = d.id_pedeptset                                                  ");
		sb.append("  left join (select b.id_pedeptset,                                                     ");
		sb.append("                    listagg(b.DIAG, chr(13)) within group(order by b.id_pedeptset) sumup");
		sb.append("               from PE_WF_PERSTDIAGSUGG b                                               ");
		sb.append("              where b.ID_PEPSNAPPT = ?                             ");
		sb.append("                and b.FG_OVAL = 'N'                                                     ");
		sb.append("              group by b.id_pedeptset) g                                                ");
		sb.append("    on d.id_pedeptset = g.id_pedeptset                                                  ");
		sb.append("  left join (select m.ID_PEPSNAPPT,                                                     ");
		sb.append("                    m.ID_PEDEPTSET,                                                     ");
		sb.append("                    m.ID_DOC,                                                           ");
		sb.append("                    m.DT_CHECK,                                                         ");
		sb.append("                    u.name as name_doc,                                                  ");
		sb.append("                    u.code as code_doc                                                  ");
		sb.append("               from PE_WF_PEWFROOM m                                                    ");
		sb.append("               left join sys_user u                                                     ");
		sb.append("                 on m.id_doc = u.id_user                                                ");
		sb.append("              where m.ID_PEPSNAPPT = ?) doc                        ");
		sb.append("    on d.id_pedeptset = doc.id_pedeptset                                                ");
		sb.append(" where rst.ID_PEPSNAPPT = ?                                          ");
		sb.append("   and c.sd_rptpart = '02'                                                              ");
		sb.append(" order by d.SORTNO, c.SORTNO;                                                           ");
		return sb.toString();
	}

}
