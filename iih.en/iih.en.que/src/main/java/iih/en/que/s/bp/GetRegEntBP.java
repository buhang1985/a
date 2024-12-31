package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取挂号患者队列
 * 
 * @author liubin
 *
 */
public class GetRegEntBP {
	/**
	 * 获取挂号患者队列
	 * 
	 * @param que 
	 * 		医生出诊队列DO
	 * @param queSiteDO 
	 * 		医生出诊工作点DO
	 * @param siteInfo 
	 * 		当前站点信息
	 * @return 
	 * 		候诊队列DTO集合
	 * @throws BizException
	 */	
	public ReceptionQueDTO[] exec(QueDO que, QueSiteDO queSiteDO, EnTrDocSiteInfoDTO siteInfo) throws BizException {
		if (EnValidator.isEmpty(que)
				|| EnValidator.isEmpty(queSiteDO)
				|| siteInfo == null
				|| EnValidator.isEmpty(siteInfo.getId_dayslot())) {
			return null;
		}
		if(siteInfo.getDate() == null)
			siteInfo.setDate(EnAppUtils.getServerDate());
		String[] entIds = this.getRegEntIds(que, siteInfo);
		if(!EnValidator.isEmpty(entIds)){
			GetAcptEntBP bp = new GetAcptEntBP();
			List<ReceptionQueDTO> list = bp.getNoTriageEnt(entIds);
			if(!EnValidator.isEmpty(list)){
				return list.toArray(new ReceptionQueDTO[0]);
			}
		}
		return null;
	}
	/**
	 * 获取未分诊患者就诊ID
	 * 
	 * @param que
	 * @param siteInfo
	 * @return
	 * @throws BizException
	 */
	private String[] getRegEntIds(QueDO que, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT EN.ID_ENT ");
		sb.append("FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sb.append("INNER JOIN EN_ENT_QUE EQ ON EN.ID_ENT = EQ.ID_ENT ");
		sb.append("WHERE EQ.SD_ENTQUE_TP = ? "); 
		sb.append("AND EQ.FG_ACTIVE = ? ");
		sb.append("AND EQ.DT_REGIST = ? ");
		sb.append("AND EQ.ID_DATESLOT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(FBoolean.TRUE);
		param.addParam(siteInfo.getDate());
		param.addParam(siteInfo.getId_dayslot());
		sb.append("AND EQ.ID_QUE = ? ");
		param.addParam(que.getId_que());
		sb.append("AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		sb.append("AND ").append(EnSqlUtils.getOpOrErTpSql("EN", siteInfo.getCode_entp()));
		if(!IBdFcDictCodeConst.SD_MODEL_OP_EMP.equals(que.getSd_mode())){
			sb.append("AND ( EQ.SD_STATUS_ACPT = ? ");
			sb.append("OR (EQ.SD_STATUS_ACPT = ? AND ISNULL(EQ.ID_QUE_SITE,'~') = '~') ) ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		}else {
			sb.append("AND EQ.SD_STATUS_ACPT = ? ");
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		}
		String sql = sb.toString();
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new String[0]);
		}
		return null;
	}
}
