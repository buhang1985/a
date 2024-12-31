package iih.bd.fc.que.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.pub.BdFcAppUtils;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueCudService;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 生成队列
 * 
 * @author liubin
 *
 */
public class GenerateQueBP {

	public GenerateQueBP() {
	}

	/**
	 * 
	 * 
	 * @param scTp
	 * @return
	 * @throws BizException
	 */
	public QueDO[] genQue(String scTp) throws BizException {
		if(StringUtil.isEmptyWithTrim(scTp)){
			throw new BizException("生成队列时排班类型不能为空！");
		}
		String queTp;
		String queTpId;
		if (IScDictCodeConst.SD_SCTP_OP.equals(scTp)) { // 门诊排班---->门诊队列
			queTp = IBdFcDictCodeConst.SD_QUETP_EMP;
			queTpId = IBdFcDictCodeConst.ID_QUETP_EMP;
		} else if (IScDictCodeConst.SD_SCTP_MT.equals(scTp)) {// 医技排班---->医技队列
			queTp = IBdFcDictCodeConst.SD_QUETP_MT;
			queTpId = IBdFcDictCodeConst.ID_QUETP_MT;
		}else{
			throw new BizException("排班类型出错！");
		}
		// 1.把排班计划生成队列
		this.createQue(queTp, queTpId);
		// 2.把已经停止或删除的排班计划对应的队列标示为停止
		this.updateWhenPlPauseOrDel(queTp);
		// 3.当计划有启用时，把停用的队列改为启用
		this.updateWhenPlActive(queTp);
		return null;
	}

	/**
	 * 把排班计划生成队列
	 * 
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void createQue(String queTp, String queTpId) throws BizException {
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append("SELECT DISTINCT ");
		sb.append("RES.NAME || '(' || BEN.NAME || ')' AS NAME,");
		sb.append("SPL.ID_SCRES AS ID_SCRES,");
		sb.append("RES.NAME || '(' || BEN.NAME || ')' AS DES,");
		sb.append("SPL.ID_DEP AS ID_DEP,");
		sb.append("SPL.ID_QUEBEN AS ID_QUEBEN,");
		sb.append("RES.SD_SCRESTP AS SD_QUETP ");
		sb.append("FROM SC_PL SPL ");
		sb.append("INNER JOIN SC_RES RES ON SPL.ID_SCRES = RES.ID_SCRES ");
		sb.append("LEFT JOIN BD_DEP DEP ON SPL.ID_DEP = DEP.ID_DEP ");
		sb.append("LEFT JOIN BD_QUE_BEN BEN ON SPL.ID_QUEBEN = BEN.ID_QUEBEN ");
		sb.append("WHERE SPL.ID_SCRES || SPL.ID_DEP || SPL.ID_QUEBEN NOT IN (SELECT BQ.ID_SCRES || BQ.ID_DEP || BQ.ID_QUEBEN FROM BD_QUE BQ WHERE " + EnvContextUtil.processEnvContext("", new QueDO(), "BQ") + ") ");
		sb.append("AND NVL(SPL.ID_QUEBEN,'~') <> '~' ");
		sb.append("AND SPL.FG_ACTIVE = ?");
		param.addParam(FBoolean.TRUE);
		if(IBdFcDictCodeConst.SD_QUETP_EMP.equals(queTp)){
			sb.append("AND SPL.SD_SCTP IN (?, ?) ");
			param.addParam(IScDictCodeConst.SD_SCTP_OP);
			param.addParam(IScDictCodeConst.SD_SCTP_JZ);
		}else if(IBdFcDictCodeConst.SD_QUETP_MT.equals(queTp)){
			sb.append("AND SPL.SD_SCTP= ? ");
			param.addParam(IScDictCodeConst.SD_SCTP_MT);
		}
		sb.append("AND " + EnvContextUtil.processEnvContext("", new ScPlanDO(), "SPL") + " ");
		String sql = sb.toString();
		
		
		List<QueDO> list = getQueDOList(sql, param);
		if (!ListUtil.isEmpty(list)) {
			for (QueDO que : list) {
				if (IScDictCodeConst.SD_SCRESTP_EMP.equals(que.getSd_quetp()) 
						|| IBdFcDictCodeConst.SD_QUETP_MT.equals(queTp)) {
					que.setSd_mode(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
					que.setId_mode(IBdFcDictCodeConst.ID_MODEL_OP_EMP);
				} else {
					que.setSd_mode(IBdFcDictCodeConst.SD_MODEL_OP_TRIAGE);
					que.setId_mode(IBdFcDictCodeConst.ID_MODEL_OP_TRIAGE);
				}
				que.setFg_active(FBoolean.TRUE);
				que.setCode(QueCodeUtils.getNewQueCode());
				que.setSd_quetp(queTp);
				que.setId_quetp(queTpId);
				que.setRatio_first(1);
				que.setRatio_rtn(1);
				que.setId_grp(Context.get().getGroupId());
				que.setId_org(Context.get().getOrgId());
				que.setPycode(CnToPy.getPyFirstCode(que.getName()));
				que.setWbcode(CnToWB.getWBCode(que.getName()));
				que.setMnecode(que.getCode());
				que.setStatus(DOStatus.NEW);
			}
			saveQueDO(list.toArray(new QueDO[0]));
		}
	}
	
	/**
	 * 把已经停止或删除的排班计划对应的队列标示为停止
	 * @throws BizException 
	 */
	private void updateWhenPlPauseOrDel(String queTp) throws BizException{
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append("SELECT BD_QUE.* FROM BD_QUE BD_QUE ");
		sb.append("WHERE BD_QUE.ID_QUE NOT IN ");
		sb.append("( ");
		sb.append("SELECT DISTINCT BQ.ID_QUE ");
		sb.append("FROM BD_QUE BQ ");
		sb.append("INNER JOIN SC_PL SPL ON BQ.ID_SCRES = SPL.ID_SCRES AND BQ.ID_DEP = SPL.ID_DEP AND BQ.ID_QUEBEN = SPL.ID_QUEBEN ");
		sb.append("WHERE BQ.SD_QUETP = ? ");
		param.addParam(queTp);
		sb.append("AND NVL(SPL.ID_QUEBEN,'~') <> '~' ");
		if(IBdFcDictCodeConst.SD_QUETP_EMP.equals(queTp)){
			sb.append("AND SPL.SD_SCTP IN (?, ?) ");
			param.addParam(IScDictCodeConst.SD_SCTP_OP);
			param.addParam(IScDictCodeConst.SD_SCTP_JZ);
		}else if(IBdFcDictCodeConst.SD_QUETP_MT.equals(queTp)){
			sb.append("AND SPL.SD_SCTP= ? ");
			param.addParam(IScDictCodeConst.SD_SCTP_MT);
		}
		sb.append("AND BQ.FG_ACTIVE = ? ");
		param.addParam(FBoolean.TRUE);
		sb.append("AND SPL.FG_ACTIVE = ? ");
		param.addParam(FBoolean.TRUE);
		sb.append("AND " + EnvContextUtil.processEnvContext("", new QueDO(), "BQ") + "");
		sb.append(") ");
		sb.append("AND BD_QUE.SD_QUETP = ? ");
		param.addParam(queTp);
		sb.append("AND BD_QUE.FG_ACTIVE = ? ");
		param.addParam(FBoolean.TRUE);
		sb.append("AND " + EnvContextUtil.processEnvContext("", new QueDO(), "BD_QUE") + "");
		String sql = sb.toString();
		
		List<QueDO> list = getQueDOList(sql, param);
		if(!ListUtil.isEmpty(list)){
			FDateTime curTime = BdFcAppUtils.getServerDateTime();
			for (QueDO queDO : list) {
				queDO.setStatus(DOStatus.UPDATED);
				queDO.setFg_active(FBoolean.FALSE);
				queDO.setDt_endtime(curTime.toString());
			}
			saveQueDO(list.toArray(new QueDO[0]));
		}
	}
	
	/**
	 * 当计划有启用时，把停用的队列改为启用
	 * @throws BizException 
	 */
	private void updateWhenPlActive(String queTp) throws BizException{
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append("SELECT BD_QUE.* FROM BD_QUE BD_QUE ");
		sb.append("WHERE BD_QUE.ID_QUE IN ");
		sb.append("( ");
		sb.append("SELECT DISTINCT BQ.ID_QUE ");
		sb.append("FROM BD_QUE BQ ");
		sb.append("INNER JOIN SC_PL SPL ON BQ.ID_SCRES = SPL.ID_SCRES AND BQ.ID_DEP = SPL.ID_DEP AND BQ.ID_QUEBEN = SPL.ID_QUEBEN ");
		sb.append("WHERE BQ.SD_QUETP = ? ");
		param.addParam(queTp);
		sb.append("AND NVL(SPL.ID_QUEBEN,'~') <> '~' ");
		if(IBdFcDictCodeConst.SD_QUETP_EMP.equals(queTp)){
			sb.append("AND SPL.SD_SCTP IN (?, ?) ");
			param.addParam(IScDictCodeConst.SD_SCTP_OP);
			param.addParam(IScDictCodeConst.SD_SCTP_JZ);
		}else if(IBdFcDictCodeConst.SD_QUETP_MT.equals(queTp)){
			sb.append("AND SPL.SD_SCTP= ? ");
			param.addParam(IScDictCodeConst.SD_SCTP_MT);
		}
		sb.append("AND BQ.FG_ACTIVE = ? ");
		param.addParam(FBoolean.FALSE);
		sb.append("AND SPL.FG_ACTIVE = ? ");
		param.addParam(FBoolean.TRUE);
		sb.append("AND " + EnvContextUtil.processEnvContext("", new QueDO(), "BQ") + "");
		sb.append(") ");
		String sql = sb.toString();
		List<QueDO> list = getQueDOList(sql, param);
		if(!ListUtil.isEmpty(list)){
			FDateTime curTime = BdFcAppUtils.getServerDateTime();
			for (QueDO queDO : list) {
				queDO.setStatus(DOStatus.UPDATED);
				queDO.setFg_active(FBoolean.TRUE);
			}
			saveQueDO(list.toArray(new QueDO[0]));
		}
	}
	
	/**
	 * 根据sql语句得到QueDO集合
	 * 
	 * @param sql
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private List<QueDO> getQueDOList(String sql, SqlParam param) throws BizException{
		return (List<QueDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(QueDO.class));
	}
	/**
	 * 保存QueDO集合
	 * 
	 * @param ques
	 * @return
	 * @throws BizException
	 */
	private QueDO[] saveQueDO(QueDO[] ques) throws BizException{
		return ServiceFinder.find(IQueCudService.class).save(ques);
	}
}
