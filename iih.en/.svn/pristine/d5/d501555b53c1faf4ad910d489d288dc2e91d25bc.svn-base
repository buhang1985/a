package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.en.comm.validator.EnValidator;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院患者列表 得到患者就诊ID
 * 
 * @author Liu Bin
 *
 */
public class CIGetPatBP{

	/**
	 * 申请转科就诊id列表
	 * 
	 * @param depId
	 * @return
	 * @throws BizException
	 */
	public List<String> applyTranDepPatIds(String depId)  throws BizException {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT DISTINCT EN.ID_ENT ");
		builder.append("FROM EN_ENT EN ");
		builder.append("INNER JOIN CI_ORDER COR ON EN.ID_ENT = COR.ID_EN AND COR.SD_SU_OR IN (?,?) ");
		builder.append("INNER JOIN CI_AP_TRANS AP ON AP.ID_OR = COR.ID_OR AND AP.SD_SU_TRANS = ? AND AP.ID_DEP_TO = ? ");
		builder.append("WHERE EN.FG_IP = 'Y' ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		param.addParam(ICiDictCodeConst.SD_SU_CHECKSTOP);
		param.addParam(ICiDictCodeConst.SD_SU_TRANS_OPEN);
		param.addParam(depId);
		return this.query(sql,param);
	}
	
	
	/**
	 * 出院患者列表
	 * 
	 * @param depId
	 * @return
	 * @throws BizException
	 */
	public List<String> applyDisChargePatIds(String depId)  throws BizException {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT DISTINCT COR.ID_EN ");
		builder.append("FROM CI_AP_OUT AP ");
		builder.append("INNER JOIN CI_ORDER COR ON AP.ID_OR = COR.ID_OR AND COR.SD_SU_OR IN (?,?)  ");
		builder.append("INNER JOIN EN_ENT EN ON COR.ID_EN = EN.ID_ENT AND EN.ID_DEP_PHY = ? AND EN.FG_IP = 'Y' ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		param.addParam(ICiDictCodeConst.SD_SU_CHECKSTOP);
		param.addParam(depId);
		return this.query(sql,param);
	}
	
	/**
	 * 查询患者就诊ID
	 * 
	 * @param sql
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<String> query(String sql,SqlParam param) throws BizException{
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!EnValidator.isEmpty(list)){
			return list;
		}
		return null;
	}
}
