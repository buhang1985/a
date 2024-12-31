package iih.pi.reg.s.bp.qry;

import iih.bd.bc.udi.pub.IPiDictCodeConst;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据特定条件查询患者id类
 * @author ly
 *
 */
public class PiGetPatIdBySpecialCondQry implements ITransQry{

	private String condType;
	private String condValue;
	
	public PiGetPatIdBySpecialCondQry(String condType, String condValue) {
		this.condType = condType;
		this.condValue = condValue;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		
		SqlParam sql = new SqlParam();
		if (!StringUtil.isEmpty(condValue)) {
			if (!StringUtil.isEmpty(condValue)) {
				switch (condType) {
				case IPiDictCodeConst.PAT_CONDITION_TYPE_AUTO: //自动
					sql.addParam(condValue);
					sql.addParam(condValue);
					sql.addParam(condValue);
					sql.addParam(condValue);
					break;

				default:
					sql.addParam(condValue);
					break;
				}
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
				+ " where 1=1 ";
		if (!StringUtil.isEmpty(condValue)) {
			if (!StringUtil.isEmpty(condType)) {
				switch (condType) {
				case IPiDictCodeConst.PAT_CONDITION_TYPE_AUTO: //自动
					SqlStr += " and (pat.code = ? or card.code = ? or pat.id_code = ? or ip.name_bed = ? ) ";
					break;
				case IPiDictCodeConst.PAT_CONDITION_TYPE_PATCODE: //患者编码
					SqlStr += " and pat.code = ? ";
					break;
				case IPiDictCodeConst.PAT_CONDITION_TYPE_CARDCODE: //就诊卡号
					SqlStr += " and card.code = ? ";
					break;
				case IPiDictCodeConst.PAT_CONDITION_TYPE_IDCODE: //证件号码
					SqlStr += " and pat.id_code = ? ";
					break;
				case IPiDictCodeConst.PAT_CONDITION_TYPE_BEDNO: //床号
					SqlStr += " and ip.name_bed = ? ";
					break;
				}
			}
		}
		return SqlStr;
	}
}
