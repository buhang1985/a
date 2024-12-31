package iih.ci.mr.s.bp.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.kernel.SqlParam;

public class CiMrsignsql implements ITransQry {

	private String id_user;
	private String qryRootNodeDTO;
	private String id_dep;

	/**
	 * 查询DTO构造函数
	 * 
	 * @param Id_user
	 * @throws BizException
	 */
	public CiMrsignsql(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		this.id_user = Context.get().getUserId();
		this.qryRootNodeDTO = this.nodetostring(qryRootNodeDTO);
		//this.id_dep = Context.get().getDeptId();
	}

	/**
	 * 通过传入的QryRootNodeDTO 得到查询条件字符串
	 * 
	 * @param Id_user
	 * @throws BizException
	 */
	private String nodetostring(QryRootNodeDTO qryRootNodeDTO)
			throws BizException {
		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		if (qryRootNodeDTO != null) {
			String sql = service.getQueryStringWithoutDesc(qryRootNodeDTO);
			return sql;
		} else {
			return "1=1";
		}

	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam = new SqlParam();
		rtnParam.addParam(id_user);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}

	/**
	 * 获取主体sql
	 * 
	 * @return
	 */
	private String getSql() {
		StringBuffer SQL_MaxStartDate = new StringBuffer();
		SQL_MaxStartDate.append("INNER JOIN \n");
		SQL_MaxStartDate.append("( \n");
		SQL_MaxStartDate.append("    SELECT \n");
		SQL_MaxStartDate.append("        id_frmins, \n");
		SQL_MaxStartDate.append("        state, \n");
		SQL_MaxStartDate.append("        id_owner, \n");
		SQL_MaxStartDate.append("        MAX(startdate) AS maxstartdate \n");
		SQL_MaxStartDate.append("    FROM \n");
		SQL_MaxStartDate.append("        wf_task \n");
		SQL_MaxStartDate.append("    GROUP BY \n");
		SQL_MaxStartDate.append("        id_frmins, \n");
		SQL_MaxStartDate.append("        state, \n");
		SQL_MaxStartDate.append("        id_owner) m ON ( \n");
		SQL_MaxStartDate.append("    w.id_frmins = m.id_frmins \n");
		SQL_MaxStartDate.append("    AND \n");
		SQL_MaxStartDate.append("    w.state = m.state \n");
		SQL_MaxStartDate.append("    AND \n");
		SQL_MaxStartDate.append("    w.id_owner = m.id_owner \n");
		SQL_MaxStartDate.append("    AND \n");
		SQL_MaxStartDate.append("    w.startdate = m.maxstartdate \n");
		SQL_MaxStartDate.append(") AND c.ds=0");

		String sql = "select "
				+ "CASE w.actiontype "
				+ "WHEN 'Normal' THEN "
				+ "    '常规' "
				+ "WHEN 'Deliver' THEN "
				+ "    '传阅' "
				+ "WHEN 'Deliver' THEN "
				+ "    '单据' "
				+ "WHEN 'Bill' THEN "
				+ "    '传阅' "
				+ "WHEN 'Major' THEN "
				+ "    '主办' "
				+ "WHEN 'Assist' THEN "
				+ "    '协办' "
				+ "END AS actiontype,"

				+ "CASE w.finishtype "
				+ "WHEN 'FinishType_Normal' THEN "
				+ "    '标准' "
				+ "WHEN 'FinishType_Tramsmit' THEN "
				+ "    '转发' "
				+ "WHEN 'FinishType_Reject' THEN "
				+ "    '驳回' "
				+ "WHEN 'FinishType_Deliver' THEN "
				+ "    '阅办' "
				+ "WHEN 'FinishType_SignStart' THEN "
				+ "    '会签开始' "
				+ "WHEN 'FinishType_Countersign' THEN "
				+ "    '会签完成' "
				+ "END AS finishtype,"

				+ "w.id_task, "

				+ "CASE w.state "
				+ "WHEN 'Todo' THEN "
				+ "    '待办' "
				+ "WHEN 'Run' THEN "
				+ "    '运行中' "
				+ "WHEN 'Completed' THEN "
				+ "    '完成' "
				+ "WHEN 'Canceled' THEN "
				+ "    '取消' "
				+ "WHEN 'Suspended' THEN "
				+ "    '挂起' "
				+ "WHEN 'UnRead' THEN "
				+ "    '待阅' "
				+ "WHEN 'Readed' THEN "
				+ "    '已阅' "
				+ "WHEN 'BeforeAddSignSend' THEN "
				+ "    '加签发送' "
				+ "WHEN 'BeforeAddSignCmplt' THEN "
				+ "    '加签完成' "
				+ "WHEN 'BeforeAddSignStop' THEN "
				+ "    '加签停止' "
				+ "END AS state,"
				+ "w.id_owner,w.id_frmins,w.startdate as mr_modifiedtime,"
				+ "CASE w.createtype "
				+ "WHEN 'Normal' THEN "
				+ "    '标准' "
				+ "WHEN 'BeforeAddSign' THEN "
				+ "    '加签' "
				+ "WHEN 'Tramsmit' THEN "
				+ "    '转发' "
				+ "WHEN 'Deliver' THEN "
				+ "    '传阅' "
				+ "WHEN 'Reject' THEN "
				+ "    '驳回' "
				+ "END AS createtype,"

				+ "w.nodeins_name, w.opinion, "
				+ " c.id_mr, c.name as mr_name, c.sign_suggestion as mr_sign_suggestion,c.ID_PAT,"
				+ " b.name as mr_bed_name," + " br.name as reviewtp_name,"
				+ " p.name as pat_name,bdu.name as pat_sex,"
				+ " e.id_ent as id_ent," + " su.name as mr_modifiedby"
				+ " from  wf_task  w"
				+ " join  ci_mr  c  ON(c.id_mr = w.id_frmins)"
				+ " join  ci_amr ca on (c.id_ent=ca.id_ent)"
				+ " join  pi_pat  p ON(c.id_pat = p.id_pat)"
				+ " join  en_ent  e ON (c.id_ent=e .id_ent)"
				+ " join  bd_bed b on(c.id_bed=b.id_bed)"
				+ " join  bd_reviewtp br ON (c.id_reviewtp=br.id_reviewtp)"
				+ " join bd_udidoc  bdu on (p.id_sex=bdu.id_udidoc)"
				+ " join sys_user  su ON(w.id_owner=su.id_user)"
				// djx start
				+ SQL_MaxStartDate.toString()
				// djx end
				+ " where ca.fg_seal='N' and w.id_owner= '" + id_user 
//				+ "' AND  e.ID_DEP_PHY='"
//				+ id_dep + 
				+ "' and " + qryRootNodeDTO;
		return sql;
	}

}
