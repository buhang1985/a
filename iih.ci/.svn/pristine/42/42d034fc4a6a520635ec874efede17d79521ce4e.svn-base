package iih.ci.mrqc.s;


import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.i.IMrPigeonholeUpdateAffair;

public class MrPigeonholeUpdateAffair implements IMrPigeonholeUpdateAffair {

	@Override
	/**
	 * 病历召回自动归档时，同步更新文书和病案状态
	 */
	public void updateStateWhenAutoPigeonhole() throws DAException{
		// TODO Auto-generated method stub
		DAFacade daf = new DAFacade(); 
		
		FDate fDate = new FDate();		
		String time_out = fDate.toLocalString();
		String sqlStr= null;
		
		
		sqlStr = getSql4UpdateMr(time_out);
		daf.execUpdate(sqlStr);//更新ci_mr，文书改为提交状态
		
		sqlStr = getSql4UpdateAmr(time_out);
		daf.execUpdate(sqlStr);//更新ci_amr，病案改为贵归档状态
		
		sqlStr = getSql4UpdateRecall(time_out);
	    
		daf.execUpdate(sqlStr);
	}
	
	/**
	 * 获取更新ci_mr的语句
	 * @param time_out
	 * @return
	 */
	private String getSql4UpdateMr(String time_out)
	{
		StringBuilder sql = new StringBuilder();
		sql.append("update mr set mr.id_su_mr = '");
		sql.append(ICiMrDictCodeConst.ID_SU_MR_SUBMIT);
		sql.append("', mr.sd_su_mr= '");
		sql.append(ICiMrDictCodeConst.SD_SU_MR_SUBMIT);
		sql.append("' from ci_mr mr ,ci_mr_recall recall where mr.id_ent = recall.id_ent and recall.dt_end < '");
		sql.append(time_out);
	    sql.append("' and ");
	    sql.append(" recall.id_state = '");
	    sql.append(ICiMrDictCodeConst.ID_CIMRRECALL_STATUS_AUDIT);
	    sql.append("' and mr.ds = '0'");
	    return sql.toString();
		
	}

	/**
	 * 获取更新ci_amr的语句
	 * @param time_out
	 * @return
	 */
	private String getSql4UpdateAmr(String time_out)
	{

		StringBuilder sql = new StringBuilder();
		sql.append("update mr set mr.id_su_mr = '");
		sql.append(ICiMrDictCodeConst.ID_SU_MR_SUBMIT);
		sql.append("', mr.sd_su_mr= '");
		sql.append(ICiMrDictCodeConst.SD_SU_MR_SUBMIT);
		sql.append("' from ci_amr mr ,ci_mr_recall recall where mr.id_ent = recall.id_ent and recall.dt_end < '");
		sql.append(time_out);
	    sql.append("' and ");
	    sql.append(" recall.id_state = '");
	    sql.append(ICiMrDictCodeConst.ID_CIMRRECALL_STATUS_AUDIT);
	    sql.append("' and mr.ds = '0'");
	    return sql.toString();
		
	}
	
	private String getSql4UpdateRecall(String time_out)
	{
		StringBuilder sql = new StringBuilder();	
		sql.append("update ci_mr_recall  set id_state = '");
		sql.append(ICiMrDictCodeConst.ID_CIMRRECALL_STATUS_PIGEONHOLE);
		sql.append( "' ,sd_state ='");
		sql.append(ICiMrDictCodeConst.SD_CIMRRECALL_STATUS_PIGEONHOLE);
	    sql.append("' where ci_mr_recall.dt_end < '");
	    sql.append(time_out);
	    sql.append("' and ");
	    sql.append(" id_state = '");
	    sql.append(ICiMrDictCodeConst.ID_CIMRRECALL_STATUS_AUDIT);
	    sql.append("'");
	    return sql.toString();
	}
}
