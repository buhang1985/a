package iih.pi.reg.s.bp.qry;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.dto.d.PiBabyPatFuzyyQueryCondDTO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 新生儿模糊查询sql
 * @author ly
 *
 */
public class PiGetBabyPatIdsByFuzzyQueryCondQry implements ITransQry{

	private PiBabyPatFuzyyQueryCondDTO cond;
	
	public PiGetBabyPatIdsByFuzzyQueryCondQry(PiBabyPatFuzyyQueryCondDTO cond){
		this.cond = cond;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		
		SqlParam param = new SqlParam();
		if(cond.getDt_birth() != null){
			whereSQL.append("and pat.dt_birth = ? ");
			param.addParam(cond.getDt_birth().toString());
		}
		
		if(!StringUtil.isEmpty(cond.getMum_id())){
			whereSQL.append("and cont.contid like ? ");
			param.addParam("%" + cond.getMum_id() + "%");
		}
		
		if(!StringUtil.isEmpty(cond.getMum_tel())){
			whereSQL.append("and cont.conttel like ? ");
			param.addParam("%" + cond.getMum_tel() + "%");
		}
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select distinct pat.id_pat ");
		sqlSb.append("from pi_pat pat ");
		sqlSb.append("inner join pi_pat_cont cont ");
		sqlSb.append("on pat.id_pat = cont.id_pat ");
		sqlSb.append("and cont.sd_fmrole = '"+IPiDictCodeConst.SD_PARENT_MOTHER+"' ");
		sqlSb.append("where 1=1 ");
		
		return sqlSb.toString();
	}
}
