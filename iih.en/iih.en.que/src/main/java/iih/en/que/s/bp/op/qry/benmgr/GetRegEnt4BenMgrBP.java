package iih.en.que.s.bp.op.qry.benmgr;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.en.que.s.bp.GetAcptEntBP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取挂号患者队列（分诊台管理队列）
 * 
 * @author liubin
 *
 */
public class GetRegEnt4BenMgrBP {
	/**
	 * 获取挂号患者队列
	 * 
	 * @param queSiteDO 
	 * 		医生出诊工作点DO
	 * @param siteInfo 
	 * 		站点信息
	 * @return 
	 * 		候诊队列DTO集合
	 * @throws BizException
	 */	
	public ReceptionQueDTO[] exec(QueSiteDO queSiteDO, EnTrDocSiteInfoDTO siteInfo) throws BizException {
		if (EnValidator.isEmpty(queSiteDO)
				|| siteInfo == null
				|| EnValidator.isEmpty(siteInfo.getId_dayslot())) {
			return null;
		}
		if(siteInfo.getDate() == null)
			siteInfo.setDate(EnAppUtils.getServerDate());
		//1.获取医生出诊队列
		QueDO[] ques = new GetQue4BenMgrBP().getQuesBySiteId(siteInfo);
		if(EnValidator.isEmpty(ques))
			return null;
		
		String[] entIds = this.getRegEntIds(ques, siteInfo);
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
	 * @param date
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	private String[] getRegEntIds(QueDO[] ques, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		Set<String> modeEmpSet = new HashSet<>();
		Set<String> modeTriageSet = new HashSet<>();
		for(QueDO que : ques){
			if (IBdFcDictCodeConst.SD_MODEL_OP_EMP.equals(que.getSd_mode())) {
				modeEmpSet.add(que.getId_que());
			}else
				modeTriageSet.add(que.getId_que());
		}
		Set<String> set = new HashSet<>();
		if(!modeEmpSet.isEmpty()){
			String[] entIds = getModeEmpEntIds(modeEmpSet.toArray(new String[0]), siteInfo);
			if(!EnValidator.isEmpty(entIds)){
				set.addAll(Arrays.asList(entIds));
			}
		}
		if(!modeTriageSet.isEmpty()){
			String[] entIds = getModeTriageEntIds(modeTriageSet.toArray(new String[0]), siteInfo);
			if(!EnValidator.isEmpty(entIds)){
				set.addAll(Arrays.asList(entIds));
			}
		}
		return set.isEmpty()?null : set.toArray(new String[0]);
	}
	/**
	 * 获取分诊台分诊模式候诊患者
	 * 
	 * @param queIds
	 * @param queSiteDO
	 * @param date
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	private String[] getModeTriageEntIds(String[] queIds, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EQ.ID_ENT ");
		sb.append("FROM  EN_ENT_QUE EQ ");
		sb.append("INNER JOIN EN_ENT EN ON EQ.ID_ENT = EN.ID_ENT ");
		sb.append("WHERE EQ.SD_ENTQUE_TP = ? "); 
		sb.append("AND EQ.FG_ACTIVE = ? ");
		sb.append("AND EQ.DT_REGIST = ? ");
		sb.append("AND EQ.ID_DATESLOT = ? ");
		sb.append("AND ( EQ.SD_STATUS_ACPT = ? ");
		sb.append("OR (EQ.SD_STATUS_ACPT = ? AND ISNULL(EQ.ID_QUE_SITE,'~') = '~') ) ");
		sb.append("AND ").append(EnSqlUtils.getOpOrErTpSql("EN", siteInfo.getCode_entp()));
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(FBoolean.TRUE);
		param.addParam(siteInfo.getDate());
		param.addParam(siteInfo.getId_dayslot());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		sb.append(EnSqlUtils.getInSqlByIds("AND EQ.ID_QUE", queIds));
		String sql = sb.toString();
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new String[0]);
		}
		return null;
	}
	/**
	 * 获取医生叫号模式候诊患者
	 * 
	 * @param queIds
	 * @param queSiteDO
	 * @param date
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	private String[] getModeEmpEntIds(String[] queIds, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EQ.ID_ENT ");
		sb.append("FROM  EN_ENT_QUE EQ ");
		sb.append("INNER JOIN EN_ENT EN ON EQ.ID_ENT = EN.ID_ENT ");
		sb.append("WHERE EQ.SD_ENTQUE_TP = ? "); 
		sb.append("AND EQ.FG_ACTIVE = ? ");
		sb.append("AND EQ.DT_REGIST = ? ");
		sb.append("AND EQ.ID_DATESLOT = ? ");
		sb.append("AND EQ.SD_STATUS_ACPT = ? ");
		sb.append("AND ").append(EnSqlUtils.getOpOrErTpSql("EN", siteInfo.getCode_entp()));
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(FBoolean.TRUE);
		param.addParam(siteInfo.getDate());
		param.addParam(siteInfo.getId_dayslot());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		sb.append(EnSqlUtils.getInSqlByIds("AND EQ.ID_QUE", queIds));
		String sql = sb.toString();
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new String[0]);
		}
		return null;
	}
}
