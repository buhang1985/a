package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageQueSiteDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 得到分诊台的队列和站点信息信息
 * 
 * @author liu bin
 */
@Deprecated
public class GetOpTriQueSiteBP {

	/**
	 * 得到分诊台的队列和站点信息信息
	 * 
	 * @param date
	 * 		日期
	 * @param dayslotId
	 * 		日期分组
	 * @param benId
	 * 		分诊台ID
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public TriageQueSiteDTO[] exec(String dayslotId,String benId)throws BizException {		
		if (EnValidator.isEmpty(dayslotId)|| EnValidator.isEmpty(benId)) {
			return null;
		}
		FDate date = EnAppUtils.getServerDate();
		List<TriageQueSiteDTO> resList = new ArrayList<TriageQueSiteDTO>();
		//查找队列
		TriageQueSiteDTO[] ques = this.getTriQue(date, dayslotId, benId);
		//查找工作点
		TriageQueSiteDTO[] sites = this.getTriSite(date, dayslotId, benId);
		
		if(!EnValidator.isEmpty(ques)){
			//查找 队列的未分诊数，分诊数和候诊数
			TriageQueSiteDTO[] quesNum = this.getTriQueNum(date, dayslotId, benId);
			for(TriageQueSiteDTO que:ques){
				que.setNotriagenum(0);
				que.setTriagenum(0);
				que.setWaitnum(0);
				if(!EnValidator.isEmpty(quesNum)){
					for(TriageQueSiteDTO queNum : quesNum){
						if(que.getId_que().equals(queNum.getId_que())){
							que.setNotriagenum(queNum.getNotriagenum());
							que.setTriagenum(queNum.getTriagenum());
							que.setWaitnum(queNum.getWaitnum());
							break;
						}
					}
				}
				resList.add(que);
			}
		}
		if(!EnValidator.isEmpty(sites)){
			//查找 工作站的分诊数和候诊数
			TriageQueSiteDTO[] sitesNum = this.getTriSiteNum(date, dayslotId, benId);
			for(TriageQueSiteDTO site:sites){
				site.setNotriagenum(0);
				site.setTriagenum(0);
				site.setWaitnum(0);
				if(!EnValidator.isEmpty(sitesNum)){
					for(TriageQueSiteDTO siteNum : sitesNum){
						if(site.getId_quesite().equals(siteNum.getId_quesite())){
							site.setTriagenum(siteNum.getTriagenum());
							site.setWaitnum(siteNum.getWaitnum());
							break;
						}
					}
				}
				resList.add(site);
			}
		}
		if(!EnValidator.isEmpty(resList)){
			return resList.toArray(new TriageQueSiteDTO[0]);
		}
		return null;
	}
	
	/**
	 * 得到分诊台的队列
	 * 
	 * @param date
	 * @param dayslotId
	 * @param benId
	 * @return
	 * @throws BizException 
	 */
	private TriageQueSiteDTO[] getTriQue(FDate date,String dayslotId,String benId) throws BizException{
		StringBuilder builder  = new StringBuilder();
		builder.append("SELECT DISTINCT BQ.ID_QUE,BQ.NAME AS NAME_QUE,BQ.ID_QUEBEN AS ID_BEN,BQ.ID_DEP,");
		builder.append("SR.ID_EMP,BP.NAME AS EMP_NAME,BQ.ID_SCRES,SR.NAME AS NAME_RES ");
		builder.append("FROM BD_QUE BQ ");
		builder.append("INNER JOIN SC_RES SR ON BQ.ID_SCRES = SR.ID_SCRES ");
		builder.append("INNER JOIN SC_PL SPL ON BQ.ID_DEP = SPL.ID_DEP AND BQ.ID_SCRES = SPL.ID_SCRES ");
		builder.append("INNER JOIN SC_SCH SH ON SH.ID_SCPL = SPL.ID_SCPL ");
		builder.append("LEFT JOIN BD_PSNDOC BP ON SR.ID_EMP = BP.ID_PSNDOC ");
		builder.append("WHERE BQ.ID_QUEBEN = ? ");
		builder.append("AND BQ.FG_ACTIVE = ? ");
		builder.append("AND BQ.SD_QUETP = ? ");
		builder.append("AND SH.D_SCH = ? ");
		builder.append("AND SH.ID_DAYSLOT = ? ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(benId);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(date);
		param.addParam(dayslotId);
		@SuppressWarnings("unchecked")
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new TriageQueSiteDTO[0]);
		}
		return null;
	}
	
	/**
	 *  查找 队列的未分诊数，分诊数和候诊数
	 * 
	 * @param date
	 * @param dayslotId
	 * @param benId
	 * @return
	 * @throws BizException 
	 */
	private TriageQueSiteDTO[] getTriQueNum(FDate date,String dayslotId,String benId) throws BizException{
		StringBuilder builder  = new StringBuilder();
		builder.append("SELECT EQ.ID_QUE AS ID_QUE,");
		builder.append("SUM(CASE WHEN EQ.SD_STATUS_ACPT = '0'AND ISNULL(EQ.ID_QUE_SITE,'~') = '~'THEN 1 ELSE 0 END) AS NOTRIAGENUM, ");
		builder.append("SUM(CASE WHEN ISNULL(EQ.ID_QUE_SITE,'~')<>'~' THEN 1 ELSE 0 END） AS TRIAGENUM, ");
		builder.append("SUM(CASE WHEN ISNULL(EQ.ID_QUE_SITE,'~')<>'~' AND  EQ.SD_STATUS_ACPT<>'3' THEN 1 ELSE 0 END） AS WAITNUM ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("WHERE EQ.DT_REGIST = ? AND EQ.ID_DATESLOT = ? AND EQ.SD_STATUS_ACPT<> ? AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append("GROUP BY EQ.ID_QUE ");
		builder.append("HAVING EQ.ID_QUE IN ");
		builder.append("(SELECT ID_QUE FROM BD_QUE QUE WHERE QUE.ID_QUEBEN = ? AND QUE.FG_ACTIVE = 'Y')");
		SqlParam param = new SqlParam();
		param.addParam(date);
		param.addParam(dayslotId);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(benId);
		String sql = builder.toString();
		@SuppressWarnings("unchecked")
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new TriageQueSiteDTO[0]);
		}
		return null;
	}
	
	/**
	 * 得到工作站
	 * 
	 * @param date
	 * @param dayslotId
	 * @param benId
	 * @return
	 * @throws BizException 
	 */
	public TriageQueSiteDTO[] getTriSite(FDate date,String dayslotId,String benId) throws BizException{
		StringBuilder builder  = new StringBuilder();
		SqlParam param = new SqlParam();
		//是否是分诊台管理队列
		boolean isBenQueMgr = EnParamUtils.isBenQueMgr();
		if(isBenQueMgr){
			builder.append("SELECT BS.ID_QUESITE,BS.NAME AS NAME_QUESITE,BQ.ID_QUE,BS.ID_QUEBEN AS ID_BEN,BQ.ID_DEP,BS.ID_EMP,BP.NAME AS EMP_NAME,BS.EU_PAUSE,BQ.SD_MODE,BS.APPLY_MAX ");
			builder.append("FROM BD_QUE_SITE BS ");
			builder.append("LEFT JOIN EN_QUE_EMP EMP ON BS.ID_EMP = EMP.ID_EMP AND EMP.ID_DAYSLOT = ? AND EMP.FG_ACTIVE = ? AND EMP.D_QUE = ? ");
			builder.append("LEFT JOIN BD_QUE BQ ON EMP.ID_QUE = BQ.ID_QUE ");
			builder.append("LEFT JOIN BD_PSNDOC BP ON BS.ID_EMP = BP.ID_PSNDOC ");
			builder.append("WHERE BS.ID_QUEBEN = ? ");
			builder.append("AND BS.SD_QUESITETP = ? ");
			builder.append("AND BS.FG_ACTIVE = ? ");
			param.addParam(dayslotId);
			param.addParam(FBoolean.TRUE);
			param.addParam(date);
			param.addParam(benId);
			param.addParam(IBdFcDictCodeConst.SD_QUESITETP_OP);
			param.addParam(FBoolean.TRUE);
		}else{
			builder.append("SELECT BS.ID_QUESITE,BS.NAME AS NAME_QUESITE,BS.ID_QUE,BS.ID_QUEBEN AS ID_BEN,BQ.ID_DEP,BS.ID_EMP,BP.NAME AS EMP_NAME,BS.EU_PAUSE,BQ.SD_MODE,BS.APPLY_MAX ");
			builder.append("FROM BD_QUE_SITE BS ");
			builder.append("LEFT JOIN BD_QUE BQ ON BS.ID_QUE = BQ.ID_QUE ");
			builder.append("LEFT JOIN BD_PSNDOC BP ON BS.ID_EMP = BP.ID_PSNDOC ");
			builder.append("WHERE BS.ID_QUEBEN = ? ");
			builder.append("AND BS.SD_QUESITETP = ? ");
			builder.append("AND BS.FG_ACTIVE = ? ");
			param.addParam(benId);
			param.addParam(IBdFcDictCodeConst.SD_QUESITETP_OP);
			param.addParam(FBoolean.TRUE);
		}
		String sql = builder.toString();
		@SuppressWarnings("unchecked")
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new TriageQueSiteDTO[0]);
		}
		return null;
	}
	
	/**
	 * 查找 工作站的分诊数和候诊数
	 * 
	 * @param date
	 * @param dayslotId
	 * @param benId
	 * @return
	 * @throws BizException 
	 */
	private TriageQueSiteDTO[] getTriSiteNum(FDate date,String dayslotId,String benId) throws BizException{
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT EQ.ID_QUE_SITE AS ID_QUESITE,");
		builder.append("COUNT(EQ.ID_ENT_QUE） AS TRIAGENUM, ");
		builder.append("SUM(CASE WHEN EQ.SD_STATUS_ACPT='3' THEN 0 ELSE 1 END） AS WAITNUM ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("WHERE EQ.DT_REGIST = ? AND EQ.ID_DATESLOT = ? AND EQ.SD_STATUS_ACPT<> ? AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append("GROUP BY EQ.ID_QUE_SITE ");
		builder.append("HAVING EQ.ID_QUE_SITE IN ");
		builder.append("(SELECT QS.ID_QUESITE FROM BD_QUE_SITE QS WHERE QS.ID_QUEBEN = ? AND QS.SD_QUESITETP = ?)");
		SqlParam param = new SqlParam();
		param.addParam(date);
		param.addParam(dayslotId);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(benId);
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_OP);
		String sql = builder.toString();
		@SuppressWarnings("unchecked")
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new TriageQueSiteDTO[0]);
		}
		return null;
	}
}
