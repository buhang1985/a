package iih.pi.reg.s.bp.qry;

import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 患者模糊查询sql
 * @author ly
 *
 */
public class PiGetPatIdsByFuzzyQueryCondQry implements ITransQry{

	private PiPatFuzyyQueryCondDTO cond;
	
	public PiGetPatIdsByFuzzyQueryCondQry(PiPatFuzyyQueryCondDTO cond){
		this.cond = cond;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		
		SqlParam param = new SqlParam();
		if(!StringUtil.isEmpty(cond.getPat_code())){
			
			whereSQL.append("and pat.code = ? ");
			param.addParam(cond.getPat_code());
		}
		
		if(!StringUtil.isEmpty(cond.getPat_name())){
			
			whereSQL.append("and pat.name like ? ");
			param.addParam("%" + cond.getPat_name() + "%");
		}
		
		if(!StringUtil.isEmpty(cond.getCard_code())){
			whereSQL.append("and card.code = ? ");
			param.addParam(cond.getCard_code());
		}
		
		if(!StringUtil.isEmpty(this.cond.getCard_code()) && !StringUtil.isEmpty(cond.getSd_patcardtp())){
			whereSQL.append("and card.sd_patcardtp = ? ");
			param.addParam(cond.getSd_patcardtp());
		}
		
		if(!StringUtil.isEmpty(cond.getCode_amr_oep())){
			whereSQL.append("and pat.code_amr_oep = ? ");
			param.addParam(cond.getCode_amr_oep());
		}
		
		if(!StringUtil.isEmpty(cond.getCode_amr_ip())){
			whereSQL.append("and pat.code_amr_ip = ? ");
			param.addParam(cond.getCode_amr_ip());
		}
		
		if(!StringUtil.isEmpty(cond.getId_code())){
			whereSQL.append("and pat.id_code = ? ");
			param.addParam(cond.getId_code());
		}
		
		if(!StringUtil.isEmpty(cond.getTel_pat())){
			whereSQL.append("and (pat.tel = ? or pat.mob = ? ) ");
			param.addParam(cond.getTel_pat());
			param.addParam(cond.getTel_pat());
		}
		
		if(!StringUtil.isEmpty(cond.getTel_connect())){
			whereSQL.append("and cont.conttel = ? ");
			param.addParam(cond.getTel_connect());
		}
		
		if(!StringUtil.isEmpty(cond.getBarcode_chis())){
			whereSQL.append("and pat.barcode_chis = ? ");
			param.addParam(cond.getBarcode_chis());
		}
		
		whereSQL.append("and pat.fg_invd = 'N' ");
		
		//whereSQL.append(" order by pat.code ");
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select distinct pat.id_pat ");
		sqlSb.append("from pi_pat pat ");
		
		if(!StringUtil.isEmpty(this.cond.getCard_code())){
			sqlSb.append("left join pi_pat_card card ");
			sqlSb.append("on pat.id_pat = card.id_pat ");
		}
		
		if(!StringUtil.isEmpty(this.cond.getTel_connect())){
			sqlSb.append("left join pi_pat_cont cont ");
			sqlSb.append("on pat.id_pat = cont.id_pat ");
		}
		sqlSb.append("where 1=1 ");
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new PatDO(), "pat");//增加组织隔离
		sqlSb.append(sqlContext);   
		
		
		return sqlSb.toString();
	}	
}
