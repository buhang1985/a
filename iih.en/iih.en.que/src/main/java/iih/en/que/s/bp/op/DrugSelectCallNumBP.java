package iih.en.que.s.bp.op;

import java.util.List;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import iih.en.que.s.bp.pharm.GetPharmQueByDepBP;
import iih.en.que.s.event.DrugQueEvent;
import iih.en.que.s.event.bp.WrapObj2DrugQue4EsBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 门诊药房选择叫号
 * 
 * @author fanlq
 *
 */
public class DrugSelectCallNumBP {

	/***
	 * 门诊药房选择叫号
	 * 
	 * @param id_ent
	 * @param Sortno
	 * @throws BizException
	 */
	public FBoolean exec(String id_ent,String Sortno) throws BizException{
		//校验
		EnValidator.validateParam("id_ent", id_ent);
		//获取药房队列
		String depId = EnContextUtils.getDeptId();
		GetPharmQueByDepBP getPharamQueBP = new GetPharmQueByDepBP();
		QueDO queDO = getPharamQueBP.exec(depId);
		if (queDO == null) {
			throw new BizException("科室：" + depId + "的队列不存在");
		}
		QueSiteDO siteDO = this.getQueSite(queDO);
		if (siteDO == null) {
			throw new BizException("药房窗口站点下线或者不存在");
		}
		EnQueueDO[] enQueueDOs = this.getEnqueDO(id_ent,Sortno);
		if(enQueueDOs != null && enQueueDOs.length >0 && !EnValidator.isEmpty(enQueueDOs[0].getId_que_site())){
			this.updateEnQue(enQueueDOs);//修改队列状态
			this.updateCalledEnQue(queDO,siteDO,EnAppUtils.getServerDate(),enQueueDOs[0].getId_ent());//把其他叫号改为过号状态
			//叫号
			//this.invoke(enQueueDOs[0].getId_que_site(), enQueueDOs[0].getId_ent_que(), enQueueDOs[0].getId_pres(), IEnEventConst.EVENT_DRUG_DOSAGE);
			this.invoke(enQueueDOs[0].getId_que_site(), enQueueDOs[0].getId_ent_que(), enQueueDOs[0].getId_pres(), IEnEventConst.EVENT_DRUG_CALLNUM);
			//this.invoke(enQueueDOs[0].getId_que_site(), enQueueDOs[0].getId_ent_que(), enQueueDOs[0].getId_pres(), IEnEventConst.EVENT_DRUG_DISPENSING);
			return FBoolean.TRUE;
		}else if(siteDO != null && !EnValidator.isEmpty(siteDO.getId_quesite())){
			WrapObj2DrugQue4EsBP bp = new WrapObj2DrugQue4EsBP();
			AllQue4EsDTO allQue4EsDTO = bp.exec(siteDO.getId_quesite(), null, null, IEnEventConst.EVENT_DRUG_DOSAGE);
			if(allQue4EsDTO != null){
				allQue4EsDTO.setId_ent(id_ent);
				allQue4EsDTO.setTickno(Sortno);
				this.setPatInfo(allQue4EsDTO);
				DrugQueEvent event = new DrugQueEvent();
				//event.invoke(allQue4EsDTO, IEnEventConst.EVENT_DRUG_DOSAGE);
				event.invoke(allQue4EsDTO, IEnEventConst.EVENT_DRUG_CALLNUM);
				//event.invoke(allQue4EsDTO, IEnEventConst.EVENT_DRUG_DISPENSING);
				return FBoolean.TRUE;
			}
		}
		return FBoolean.FALSE;
	}
	
	/***
	 * 获取药房队列
	 * 
	 * @param id_ent
	 * @param Sortno
	 * @return
	 * @throws BizException
	 */
	private EnQueueDO[] getEnqueDO(String id_ent,String Sortno) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct que.* ");
		sql.append("from en_ent_que que " );
		sql.append("where que.id_ent = ? " );
		sql.append("and que.sortno = ? " );
		sql.append("and que.sd_entque_tp = ? " );
		sql.append("and que.code_entp = ? ");
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		param.addParam(Sortno);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_PHARMACY);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		@SuppressWarnings("unchecked")
		List<EnQueueDO> list = (List<EnQueueDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(EnQueueDO.class));
		return list != null && list.size() >0 ? list.toArray(new EnQueueDO[0]): null;
	}

	/**
	 * 触发事件
	 * 
	 * @param queId
	 * @param siteId
	 * @param entId
	 * @throws BizException 
	 */
	private void invoke(String quesiteId,String entqueId,String presids,String event) throws BizException{
		DrugQueEvent bp = new DrugQueEvent();
		bp.exec(quesiteId, entqueId, presids, event);
	}
	
	/***
	 * 获取计算机登录的站点信息
	 * 
	 * @param queDO
	 * @return
	 * @throws BizException
	 */
	private QueSiteDO getQueSite(QueDO queDO) throws BizException{
		String id_pc = EnContextUtils.getRealPcId();
		StringBuffer sql = new StringBuffer();
		sql.append("select * from bd_que_site bqs ");
		sql.append("where bqs.sd_quesitetp = ? " );
		sql.append("and bqs.fg_active = ? " );
		sql.append("and bqs.eu_pause in （?,?） " );
		sql.append("and bqs.id_pc = ? " );
		sql.append("and bqs.id_que = ? ");
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_SENDM);
		param.addParam(FBoolean.TRUE);
		param.addParam(PauseEnum.ONLINE);
		param.addParam(PauseEnum.PAUSE);
		param.addParam(id_pc);
		param.addParam(queDO.getId_que());
		@SuppressWarnings("unchecked")
		List<QueSiteDO> list = (List<QueSiteDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(QueSiteDO.class));
		return list != null && list.size() >0 ? list.toArray(new QueSiteDO[0])[0]: null;
	} 

	/***
	 * 设置叫号患者信息
	 * 
	 * @param allQue4EsDTO
	 * @return
	 * @throws BizException
	 */
	private AllQue4EsDTO setPatInfo(AllQue4EsDTO allQue4EsDTO) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select pat.name as Name_pat, ");
		sql.append("pat.code as Code_pat " );
		sql.append("from en_ent ent " );
		sql.append("inner join pi_pat pat on pat.id_pat = ent.id_pat ");
		sql.append("where ent.id_ent = ? ");
		SqlParam param = new SqlParam();
		param.addParam(allQue4EsDTO.getId_ent());
		@SuppressWarnings("unchecked")
		List<AllQue4EsDTO> list = (List<AllQue4EsDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(AllQue4EsDTO.class));
		if(list != null && list.size() > 0){
			AllQue4EsDTO[] dtos = list.toArray(new AllQue4EsDTO[0]);
			allQue4EsDTO.setName_pat(dtos[0].getName_pat());
			allQue4EsDTO.setCode_pat(dtos[0].getCode_pat());
		}
		return allQue4EsDTO;
	}
	/**
	 * @Description:选择叫号改变队列状态，配药和发药不改
	 * @param enQueueDOs
	 * @throws BizException 
	 */
	private void updateEnQue(EnQueueDO[] enQueueDOs) throws BizException{
		for(EnQueueDO enQueueDO : enQueueDOs){
			if(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_UNACCEPT.equals(enQueueDO.getSd_status_acpt()) || 
				IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALL.equals(enQueueDO.getSd_status_acpt()) ||
				  IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALLBUTNOTCOME.equals(enQueueDO.getSd_status_acpt())){
				enQueueDO.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALL);
				enQueueDO.setStatus(DOStatus.UPDATED);
			}
		}
		new EnQueEP().save(enQueueDOs);
	}
	
	/***
	 * @Description:把其他叫号状态改为过号
	 * @param enQueueDOs
	 * @throws BizException 
	 */
	private void updateCalledEnQue(QueDO que, QueSiteDO queSite, FDate date, String id_ent) throws BizException{
		EnQueueDO[] queues = this.getCallingEnt(que,queSite,date);
		if(!EnValidator.isEmpty(queues)){
			for(EnQueueDO enque : queues){
				if(!id_ent.equals(enque.getId_ent())){
					enque.setStatus(DOStatus.UPDATED);
					enque.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALLBUTNOTCOME);
					//1.2发送过号事件
					this.invoke(queSite.getId_quesite(),enque.getId_ent_que(),enque.getId_pres(),IEnEventConst.EVENT_DRUG_CALLNOARRIVAL );
				}
			}
			new EnQueEP().save(queues);
		}
	}
	
	/**
	 * 获取要叫号患者
	 * 
	 * @param que
	 * 		出诊队列
	 * @param queSite
	 * 		出诊站点
	 * @param date
	 * 		当前日期
	 * @param dayslotId
	 * 		当前时间分组ID
	 * @return
	 * @throws BizException 
	 */
	public EnQueueDO[] getCallingEnt(QueDO que, QueSiteDO queSite, FDate date) throws BizException{
		EnQueEP enQueEP = new EnQueEP();
		String whereStr = String.format("%s.ID_QUE = '%s' AND %s.ID_QUE_SITE='%s' AND %s.SD_STATUS_ACPT = '%s' "
				+ "AND %s.dt_acpt >= '%s' AND %s.dt_acpt <= '%s' AND %s.sd_entque_tp = '%s' AND %s.FG_ACTIVE = '%s'",
				EnQueueDODesc.TABLE_ALIAS_NAME, que.getId_que(),
				EnQueueDODesc.TABLE_ALIAS_NAME, queSite.getId_quesite(),
				EnQueueDODesc.TABLE_ALIAS_NAME, IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALL,
				EnQueueDODesc.TABLE_ALIAS_NAME, date,
				EnQueueDODesc.TABLE_ALIAS_NAME, date.getDateAfter(1),
				EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_PHARMACY,
				EnQueueDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		String orderStr = String.format(" %s.SORTNO_CALLED ", EnQueueDODesc.TABLE_ALIAS_NAME);
		EnQueueDO[] enQueues = enQueEP.getEnQueueByWhereStr(whereStr, orderStr);
		if (EnValidator.isEmpty(enQueues)) {
			return null;
		}
		String[] entIds =  EnAppUtils.getKeyPropArrayFromDO("Id_ent", enQueues);
		if (EnValidator.isEmpty(entIds)) {
			return null;
		}
		String str = String.format(" %s.ID_QUE = '%s' AND %s.ID_QUE_SITE='%s' AND " + EnSqlUtils.getInSqlByIds("ID_ENT", entIds) 
				+ " AND %s.SD_STATUS_ACPT IN ('%s', '%s', '%s') AND %s.dt_acpt >= '%s' "
				+ " AND %s.dt_acpt <= '%s' AND %s.sd_entque_tp = '%s' AND %s.FG_ACTIVE = '%s' ",
				EnQueueDODesc.TABLE_ALIAS_NAME, que.getId_que(),
				EnQueueDODesc.TABLE_ALIAS_NAME, queSite.getId_quesite(),
				EnQueueDODesc.TABLE_ALIAS_NAME, IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_UNACCEPT,
				IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_PREPARE, IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALL,
				EnQueueDODesc.TABLE_ALIAS_NAME, date,
				EnQueueDODesc.TABLE_ALIAS_NAME, date.getDateAfter(1),
				EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_PHARMACY,
				EnQueueDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		return enQueEP.getEnQueueByWhereStr(str, "");
	}
}
