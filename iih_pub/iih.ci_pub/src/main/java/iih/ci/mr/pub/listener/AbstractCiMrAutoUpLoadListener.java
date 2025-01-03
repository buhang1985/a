package iih.ci.mr.pub.listener;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.bd.bc.udi.pub.SuMrConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrCudService;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.cimripbasedto.d.CiMrIPBaseDTO;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.mr.pub.listener.bp.CiMrUpLoadServiceBP;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.dto.d.OpQue4EsDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 执行自动诊毕任务时，门诊病历上传集成平台监听服务
 * @author YanSu
 * @since 2020.07.17
 */
public class AbstractCiMrAutoUpLoadListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 消息校验
		if (!(event.getSourceID().equals(IMrEventConst.EVENT_SOURCE_MR_AUTO_UPLOAD) 
				&& event.getEventType().equals("4440"))) return;
		// 数据获取
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		OpQue4EsDTO eventSourceDTO = (OpQue4EsDTO)bizUserObj.getUserObj();
		if (eventSourceDTO != null) {
			dataUpLoad(eventSourceDTO);
		}
	}
	
	private void dataUpLoad(OpQue4EsDTO paramDTO) throws BizException {
		// 服务定义
		ICiemrRService mrRService = ServiceFinder.find(ICiemrRService.class);
		// 非自动诊毕情况下触发的监听，不进行BS333消息发送操作（前台已有手动诊毕发送流程）
		if (paramDTO.getFg_auto_diagend() == null || !paramDTO.getFg_auto_diagend().booleanValue()) {
			return;
		}
		// 查询患者此次就诊的病历信息
		StringBuilder sbMr = new StringBuilder();
		sbMr.append(" id_ent = '");
		sbMr.append(paramDTO.getId_ent());
		sbMr.append("' and code_entp = '");
		sbMr.append(paramDTO.getCode_entp());
		sbMr.append("' and ds = '0'");
		CiMrDO[] ciMrDOs = mrRService.find(sbMr.toString(), "", FBoolean.FALSE);
		if (ciMrDOs == null || ciMrDOs.length <= 0) {
			return;
		}
		// 取最新修改过的一篇门诊病历上传（如果有多篇门诊病历）
		CiMrDO ciMrDO = sortBySv(ciMrDOs);
		// 查询需要的患者就诊信息，用于提交病历处理
		PatiVisitDO[] patiVisitDOs = getPatiVisitDOs(paramDTO.getId_ent());
		// 将查询到的病历均置为提交状态并保存
		mrSubmit(ciMrDOs, patiVisitDOs[0]);
		// 进入上传流程
		CiMrUpLoadServiceBP upLoadBP = new CiMrUpLoadServiceBP();
		upLoadBP.exec(ciMrDO, "01");
	}
	
	/**
	 * 查询需要的患者就诊信息
	 * @param idEnt 就诊主键
	 * @return 患者就诊信息
	 * @throws BizException
	 */
	private PatiVisitDO[] getPatiVisitDOs(String idEnt) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ent.id_ent, ");
		sb.append("       ent.id_pat, ");
		sb.append("       ent.code_entp, ");
		sb.append("       ent.name_pat, ");
		sb.append("       ent.id_dep_phy, ");
		sb.append("       su.id_user as id_emp_phy, ");
		sb.append("       ent.dt_acpt, ");
		sb.append("       ent.dt_end ");
		sb.append("from en_ent ent ");
		sb.append("left join sys_user su ");
		sb.append("on ent.id_emp_phy = su.id_psn ");
		sb.append("where ent.id_ent = '");
		sb.append(idEnt);
		sb.append("' ");
		
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<PatiVisitDO> patList = 
			(List<PatiVisitDO>) daf.execQuery(sb.toString(), new BeanListHandler(PatiVisitDO.class));
		return patList.toArray(new PatiVisitDO[patList.size()]);
	}
	
	/**
	 * 提交病历处理
	 * @param ciMrDOs 当前所有的门诊病历
	 * @param patiVisitDO 就诊信息
	 * @throws BizException
	 */
	private void mrSubmit(CiMrDO[] ciMrDOs, PatiVisitDO patiVisitDO) throws BizException {
		ICiemrCudService mrCudService = ServiceFinder.find(ICiemrCudService.class);
		List<CiMrDO> mrList = new ArrayList<CiMrDO>();
		
		for (CiMrDO ciMrDO : ciMrDOs) {
			ciMrDO.setId_su_mr(SuMrConst.ID_SUMR_SUBMIT);
			ciMrDO.setSd_su_mr(SuMrConst.SD_SUMR_SUBMIT);
			ciMrDO.setDate_submit(new FDateTime());
			ciMrDO.setId_emp_audit(patiVisitDO.getId_emp_phy());
			ciMrDO.setId_emp_submit(patiVisitDO.getId_emp_phy());
			ciMrDO.setId_submit_dept(patiVisitDO.getId_dep_phy());
			ciMrDO.setStatus(DOStatus.UPDATED);
			mrList.add(ciMrDO);
		}
		mrCudService.save(mrList.toArray(new CiMrDO[mrList.size()]));
	}
	
	/**
	 * 根据sv字段及病历的数据集编码 对病历数据进行排序处理（倒序）
	 * @param ciMrDOs
	 * @return ciMrDO
	 */
	private CiMrDO sortBySv(CiMrDO[] ciMrDOs) throws BizException {
		// 根据查询到的所有病历信息，查询带有数据集编码信息的DTO，用于后续排序
		StringBuilder mrSb = new StringBuilder();
		mrSb.append(" and mr.id_mr in (  ");
		for (CiMrDO ciMrDO : ciMrDOs) {
			mrSb.append("'");
			mrSb.append(ciMrDO.getId_mr());
			mrSb.append("', ");
		}
		String sqlWhere = mrSb.toString().substring(0, mrSb.toString().length() - 2) + ") ";
		
		StringBuilder sb = new StringBuilder();
		sb.append("select mr.id_mr as id_mr, mr.sv as dt_update, bs.code as code_set ");
		sb.append("from ci_mr mr ");
		sb.append("left join bd_mrtp bm ");
		sb.append("on mr.id_mrtp = bm.id_mrtp ");
		sb.append("left join bd_set bs ");
		sb.append("on bm.id_data_set = bs.id_set ");
		sb.append("where 1=1 ");
		sb.append(sqlWhere);
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<CiMrIPBaseDTO> mrIpBaseList = 
			(List<CiMrIPBaseDTO>) daf.execQuery(sb.toString(), new BeanListHandler(CiMrIPBaseDTO.class));
		CiMrIPBaseDTO[] iPBaseDTOs = mrIpBaseList.toArray(new CiMrIPBaseDTO[mrIpBaseList.size()]);
		// 排序：将修改时间为最新的，并且是门急诊病历类型的放在数组第一位
        for (int i = 0; i < iPBaseDTOs.length; i++) {
            for (int j = 0; j < iPBaseDTOs.length - i - 1; j++) {
                if (iPBaseDTOs[j].getDt_update().getMillis() < iPBaseDTOs[j + 1].getDt_update().getMillis()
                		|| !IMrPubConst.DS_MJZBL.equals(iPBaseDTOs[j].getCode_set())) {
                	CiMrIPBaseDTO temp = iPBaseDTOs[j + 1];
                	iPBaseDTOs[j + 1] = iPBaseDTOs[j];
                	iPBaseDTOs[j] = temp;
                }
            }
        }
        // 匹配并返回符合标准的CiMrDO
        for (CiMrDO ciMrDO : ciMrDOs) {
        	if (ciMrDO.getId_mr().equals(iPBaseDTOs[0].getId_mr())) {
        		return ciMrDO;
        	}
        }
        return null;
	}
	
}
