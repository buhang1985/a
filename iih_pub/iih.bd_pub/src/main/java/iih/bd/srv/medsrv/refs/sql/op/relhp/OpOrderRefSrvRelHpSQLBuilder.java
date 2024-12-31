package iih.bd.srv.medsrv.refs.sql.op.relhp;

import iih.bd.srv.medsrv.refs.sql.hptype.HptypeDisplay;
import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefSrvSQLBuilder;

/**
 * 门诊医嘱服务参照，关联医保显示医保备注信息的参照
 * @author zhangwq
 *
 */
public class OpOrderRefSrvRelHpSQLBuilder extends OpOrderRefSrvSQLBuilder{

	@Override
	public String getDesField() {
		String hptypeDisplay = HptypeDisplay.getInstance().getHptyDisplay();
		StringBuffer sql = new StringBuffer();
		sql.append("(case " );
		sql.append(String.format("  when hpsrvca.code is null and srv.fg_bl = 'Y' then '%s ' when hptp.name is null and srv.fg_bl = 'Y' then '%s ' else hptp.name end )",hptypeDisplay,hptypeDisplay));
		sql.append("       || CASE  WHEN hpsrvca.rate IS NULL THEN  '' else ' 报销比例：'||CONCAT(TO_CHAR(hpsrvca.rate*100, 'fm9999999990'),'%')||' ' END  " );
		sql.append("       ||srv.des||decode(hpsrvca.des,null,'',' '||hpsrvca.des)||decode(hpsrvca.note,null,'',' '||hpsrvca.note)	" );
		sql.append("        des, " );
		return sql.toString();
	}
}
