package iih.pi.reg.s.bp.qry;

import iih.bd.bc.udi.pub.IPiDictCodeConst;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据特定条件模糊查询患者id类
 * @author ly
 *
 */
public class PiGetPatIdBySpecialCondFuzzyQry implements ITransQry{

	private String condType;
	private String condValue;
	
	public PiGetPatIdBySpecialCondFuzzyQry(String condType, String condValue) {
		this.condType = condType;
		this.condValue = condValue;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		
		SqlParam sql = new SqlParam();
		if (!StringUtil.isEmpty(condValue) && !StringUtil.isEmpty(condType)) {
			//条件值统一为小写
			String lowerCondValue = condValue.toLowerCase();
			
			switch (condType) {
				case IPiDictCodeConst.PAT_CONDITION_TYPE_AUTO: //自动
					sql.addParam("%" + lowerCondValue + "%");
					sql.addParam("%" + lowerCondValue + "%");
					sql.addParam("%" + lowerCondValue + "%");
					sql.addParam("%" + lowerCondValue + "%");
					break;
	
				default:
					sql.addParam("%" + lowerCondValue + "%");
					break;
			}
		}
		return sql;
	}

	@Override
	public String getQrySQLStr() {
		
		String SqlStr = " select distinct pat.id_pat "
				+ " from pi_pat pat "
				+ " left join pi_pat_card card on card.id_pat = pat.id_pat "
				+ " left join en_ent ent on ent.id_pat = pat.id_pat "
				+ "	          and ent.fg_ip='Y'"
				+ " left join en_ent_ip ip on ip.id_ent = ent.id_ent "
				+ " where 1=1 "
				+ " and pat.ds = 0 "
				+ " and pat.fg_invd = 'N' ";
		if (!StringUtil.isEmpty(condValue) && !StringUtil.isEmpty(condType)) {
			switch (condType) {
				case IPiDictCodeConst.PAT_CONDITION_TYPE_AUTO: //自动
					SqlStr += " and (lower(pat.code) like ? or lower(card.code) like ? or lower(pat.id_code) like ? or lower(ip.name_bed) like ? ) ";
					break;
				case IPiDictCodeConst.PAT_CONDITION_TYPE_PATCODE: //患者编码
					SqlStr += " and lower(pat.code) like ? ";
					break;
				case IPiDictCodeConst.PAT_CONDITION_TYPE_CARDCODE: //就诊卡号
					SqlStr += " and lower(card.code) like ? ";
					break;
				case IPiDictCodeConst.PAT_CONDITION_TYPE_IDCODE: //证件号码
					SqlStr += " and lower(pat.id_code) like ? ";
					break;
				case IPiDictCodeConst.PAT_CONDITION_TYPE_BEDNO: //床号
					SqlStr += " and lower(ip.name_bed) like ? ";
					break;
			}
		}
		return SqlStr;
	}
}
