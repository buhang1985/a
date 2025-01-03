package iih.en.que.s.event.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.fc.queben.i.IQuebenRService;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.ep.BdQueEP;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PsnDocEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.OpQue4DispDTO;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.bp.OpCallingNumBP;
import iih.en.que.s.bp.op.cmd.benmgr.OpCallingNum4BenMgrBP;
import iih.en.que.s.bp.op.qry.benmgr.GetQue4BenMgrBP;
import iih.en.que.s.bp.op.qry.benmgr.GetSiteEntStats4BenMgrBP;
import iih.sc.scbd.i.IScDaysLotService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * OpQue4DispDTO组装
 * 
 * @author liubin
 *
 */
public class WrapObj2OpQue4DispBP {

	private static final String ADD = "ADD";
	private static final String DEL = "DEL";
	private static final String FZ = "FZ";

	private static final String FG_2 = "2";
	private static final String FG_3 = "3";

	// 普通号
	private static final String REGTP_OP_NORM = "1";
	// 专家号
	private static final String REGTP_OP_EXP = "2";
	
	//当前患者
	private static final String WAIT_STATUS_CUR = "0";
	//候诊患者
	private static final String WAIT_STATUS_WAIT = "1";

	/**
	 * 组装OpQue4DispDTO
	 * 
	 * @param es
	 * @return
	 * @throws BizException
	 */
	public OpQue4DispDTO wrap(OpQue4EsDTO es, String eventType)
			throws BizException {
		this.setEntInfo(es);
		OpQue4DispDTO disp = new OpQue4DispDTO();
		DaysLotDO dayslot = this.getNowDayslot(es);
		FDate curDate = new FDate(dayslot.getDef1());
		boolean isBenQueMgr = EnParamUtils.isBenQueMgr();
		// 设置站点信息
		QueSiteDO site = this.setSiteInfo(disp, es);
		if(dayslot == null || site == null)
			return null;
		EnTrDocSiteInfoDTO siteInfo = new EnTrDocSiteInfoDTO();
		siteInfo.setId_dayslot(dayslot.getId_dayslot());
		siteInfo.setDate(new FDate(dayslot.getDef1()));
		siteInfo.setId_quesite(site.getId_quesite());
		siteInfo.setId_dep(site.getId_dep());
		siteInfo.setId_emp(site.getId_emp());
		siteInfo.setId_queben(site.getId_queben());
		// 设置队列信息
		QueDO[] ques = this.setQueInfo(disp, es,site, siteInfo, isBenQueMgr);
		siteInfo.setId_ques(EnAppUtils.objArray2List(EnAppUtils.getKeyPropArrayFromDO(QueDO.ID_QUE, ques)));
		//组装站点信息
		// 设置医生职称
		this.setDocTitle(disp);
		// 设置当前接诊者序号
		this.setCurAcpt(disp, site, siteInfo);
		// 设置候诊人数
		this.setWaitNum(disp, ques, siteInfo);
		// 设置等待号
		this.setWaitQuenos(disp, ques, site, siteInfo,isBenQueMgr);
		// 设置就诊信息
		this.setEntInfo(disp, es);
		//设置午别id
		disp.setId_dayslot(dayslot.getId_dayslot());
		disp.setDt_regist(curDate);
		//号别简称
		//disp.setShortname_srv(es.getShortname_srv());
		//分诊台id
		disp.setId_queben(site.getId_queben());
		return disp;
	}

	/**
	 * 得到站点信息
	 * 
	 * @param disp
	 * @param eventType
	 * @return
	 */
	public String[] toInfomation(OpQue4DispDTO disp, String eventType) {
		if (disp == null)
			return null;
		if (EnValidator.isEmpty(disp.getAddr_board_ben())) {
			return null;
		}
		String flag = IEnEventConst.EVENT_EN_OP_DOC_OFFLINE.equals(eventType) ? DEL
				: ADD;
		if (this.IsOffLine(disp))
			flag = DEL;
		String[] disPlayAddr = disp.getAddr_board_ben().split(",");
		String[] disPlayInfos = new String[disPlayAddr.length];
		for (int i = 0; i < disPlayAddr.length; i++) {
			String res = String.format(
					"%s,%s,%s,%s,[%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s]",
					flag, // 上线\分诊\取消分诊
					FZ, // 固定为FZ
					getString(disPlayAddr[i]), // 屏幕地址
					FG_2, // 2排队、3叫号、4候诊叫号
					getString(disp.getCode_dep()), // 科室编号
					getString(disp.getName_dep()), // 科室名称
					getString(disp.getName_dep_en()), // 科室英文名称
					getString(disp.getCode_doc()), // 医生编号
					getString(disp.getName_doc()), // 医生名称
					getString(disp.getCode_room()), // 诊室号
					getString(disp.getName_room()), // 诊室名称
					getString(disp.getCode_scsrv()), // 出诊类别编号
					getString(disp.getName_srv()), // 出诊类别名称
					getString(disp.getCur_acpt_sortno()), // 当前接诊患者序号
					getString(disp.getWaitnum()), // 等待患者人数
					getString(disp.getWait_quenos()), // 等待号
					getString(disp.getScroll_text())); // 滚动字幕
			disPlayInfos[i] = res;
		}
		return disPlayInfos;

	}
	/**
	 * 得到二次分诊站点信息
	 * 
	 * @param disp
	 * @param eventType
	 * @return
	 */
	public String[] toSecondInfomation(OpQue4DispDTO disp, String eventType) {
		if (disp == null)
			return null;
		String flag = IEnEventConst.EVENT_EN_OP_DOC_OFFLINE.equals(eventType) ? DEL
				: ADD;
		if(this.IsOffLine(disp))
			flag = DEL;
		List<String> list = new LinkedList<>();
		list.add(toDelSecondInfomation(disp));//添加清屏信息
		if(!DEL.equals(flag)){
			if(!EnValidator.isEmpty(disp.getCur_name_pat()))
				list.add(toCurSecondInfomation(disp));
			if(disp.getWait_list()!=null && disp.getWait_list().size() > 0){
				for(Object obj : disp.getWait_list())
					list.add(toWaitSecondInfomation(disp, (EnQueueDO)obj));
			}
		}
		return list.toArray(new String[0]);
	}
	/**
	 * 获取二次分诊清屏信息
	 * 
	 * @param disp
	 * @return
	 */
	private String toDelSecondInfomation(OpQue4DispDTO disp) {
		return String.format(
				"%s,%s,%s,%s,[%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s]",
				DEL, // 上线\分诊\取消分诊
				FZ, // 固定为FZ
				getString(disp.getAddr_board_site()), // 屏幕地址
				FG_2, // 2排队、3叫号、4候诊叫号
				getString(disp.getCode_dep()), // 科室编号
				getString(disp.getName_dep()), // 科室名称
				getString(disp.getName_dep_en()), // 科室英文名称
				getString(disp.getCode_room()), // 诊室号
				getString(disp.getName_room()), // 诊室名称
				getString(disp.getCode_doc()), // 医生编号
				getString(disp.getName_doc()), // 医生名称
				getString(disp.getName_doc_en()), // 医生英文名
				getString(disp.getName_doctitle()), // 医生职称
				getString(disp.getName_doctile_en()), // 医生职称英文
				getString(""), // 患者编码
				getString(""), // 患者姓名
				getString(""), // 等待号
				WAIT_STATUS_CUR, // 患者状态
				getString("")); // 滚动字幕
	}
	/**
	 * 获取二次分诊当前患者信息
	 * 
	 * @param disp
	 * @return
	 */
	private String toCurSecondInfomation(OpQue4DispDTO disp) {
		return String.format(
				"%s,%s,%s,%s,[%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s]",
				ADD, // 上线\分诊\取消分诊
				FZ, // 固定为FZ
				getString(disp.getAddr_board_site()), // 屏幕地址
				FG_2, // 2排队、3叫号、4候诊叫号
				getString(disp.getCode_dep()), // 科室编号
				getString(disp.getName_dep()), // 科室名称
				getString(disp.getName_dep_en()), // 科室英文名称
				getString(disp.getCode_room()), // 诊室号
				getString(disp.getName_room()), // 诊室名称
				getString(disp.getCode_doc()), // 医生编号
				getString(disp.getName_doc()), // 医生名称
				getString(disp.getName_doc_en()), // 医生英文名
				getString(disp.getName_doctitle()), // 医生职称
				getString(disp.getName_doctile_en()), // 医生职称英文
				getString(disp.getCur_barcode_chis()), // 患者编码
				getString(disp.getCur_name_pat()), // 患者姓名
				getString(disp.getCur_acpt_sortno()), // 等待号
				WAIT_STATUS_CUR, // 患者状态
				getString(disp.getScroll_text())); // 滚动字幕
	}
	/**
	 * 获取二次分诊候诊患者信息
	 * 
	 * @param disp
	 * @param enqueue
	 * @return
	 */
	private String toWaitSecondInfomation(OpQue4DispDTO disp, EnQueueDO enqueue) {
		return String.format(
				"%s,%s,%s,%s,[%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s]",
				ADD, // 上线\分诊\取消分诊
				FZ, // 固定为FZ
				getString(disp.getAddr_board_site()), // 屏幕地址
				FG_2, // 2排队、3叫号、4候诊叫号
				getString(disp.getCode_dep()), // 科室编号
				getString(disp.getName_dep()), // 科室名称
				getString(disp.getName_dep_en()), // 科室英文名称
				getString(disp.getCode_room()), // 诊室号
				getString(disp.getName_room()), // 诊室名称
				getString(disp.getCode_doc()), // 医生编号
				getString(disp.getName_doc()), // 医生名称
				getString(disp.getName_doc_en()), // 医生英文名
				getString(disp.getName_doctitle()), // 医生职称
				getString(disp.getName_doctile_en()), // 医生职称英文
				getString(enqueue.getBarcode_chis()), // 患者编码
				getString(enqueue.getName_pat()), // 患者姓名
				getString(enqueue.getTicketno()), // 等待号
				WAIT_STATUS_WAIT, // 患者状态
				getString(disp.getScroll_text())); // 滚动字幕
	}

	/**
	 * 得到叫号信息
	 * 
	 * @param disp
	 * @param eventType
	 * @return
	 */
	public String[] toCallInfomation(OpQue4DispDTO disp, String eventType) {
		if (disp == null)
			return null;
		String flag = null;

		if (IEnEventConst.EVENT_EN_OP_CALLNUM.equals(eventType)
				|| (IEnEventConst.EVENT_EN_OP_DIAGEND.equals(eventType) && disp
						.getWaitnum() > 0)
				|| (IEnEventConst.EVENT_EN_OP_DIAGNOSECONTINUE
						.equals(eventType) && disp.getWaitnum() > 0)) {
			flag = ADD;
		} else if (IEnEventConst.EVENT_EN_OP_CANC_CALLNUM.equals(eventType)) {
			flag = DEL;
		} else if (IEnEventConst.EVENT_EN_OP_DIAGEND.equals(eventType)) {
			flag = DEL;
		} else {
			return null;
		}

		if (this.IsOffLine(disp)) {
			flag = DEL;
		}

		String[] disPlayAddr = disp.getAddr_board_ben().split(",");
		String[] disPlayInfos = new String[disPlayAddr.length];
		for (int i = 0; i < disPlayAddr.length; i++) {
			String res = String
					.format("%s,%s,%s,%s,[%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s]",
							flag, // 叫号为ADD, 取消叫号为DEL
							FZ, // 固定为FZ
							getString(disPlayAddr[i]),// 屏幕地址
							FG_3, // 2排队、3叫号、4候诊叫号
							getString(disp.getCode_dep()), // 科室编号
							getString(disp.getName_dep()), // 科室名称
							getString(disp.getName_dep_en()), // 科室英文名称
							getString(disp.getCode_doc()), // 医生编号
							getString(disp.getName_doc()), // 医生名称
							getString(disp.getCode_room()), // 诊室号
							getString(disp.getName_room()), // 诊室名称
							getString(disp.getCode_scsrv()), // 出诊类别编号
							getString(disp.getName_srv()), // 出诊类别名称
							getString(disp.getTickno()), // 当前接诊患者序号
							getString(disp.getCode_pat()), // 患者编码
							getString(disp.getTimes_op()), // 患者就诊次数
							getString(disp.getName_pat()), // 患者名称 TODO:调用叫号规则
							getString(disp.getLevel_pri()), // 是否优先标志
							getString(disp.getSortno()), // 诊室序号
							getString(disp.getRegtp()), // 呼叫类型
							getString(disp.getScroll_text()), // 滚动字幕
							getString(disp.getName_pat()), // 患者名称
							getString(disp.getAge())); // 患者年龄
			disPlayInfos[i] = res;
		}
		return disPlayInfos;
	}

	/**
	 * 设置队列信息
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private QueDO[] setQueInfo(OpQue4DispDTO disp, OpQue4EsDTO es, QueSiteDO site, EnTrDocSiteInfoDTO siteInfo ,boolean isBenQueMgr)
			throws BizException {
		BdQueEP ep = new BdQueEP();
		QueDO[] ques = null;
		if(isBenQueMgr){
			//分诊台队列管理模式
			ques= new GetQue4BenMgrBP().getQuesBySiteId(siteInfo);
		}else{
			//医生队列管理模式
			if (EnValidator.isEmpty(es.getId_que()))
				return null;
			QueDO que = ep.getQueById(es.getId_que());
			if (que == null)
				return null;
			ques = new QueDO[]{que};
		}
		if (ques == null || ques.length <= 0)
			return null;
		if(ques.length == 1 && ques[0] != null){ 
			disp.setAddr_board_ben(ques[0].getAddr_board_ben());
			disp.setId_dep(ques[0].getId_dep());
			disp.setCode_dep(ques[0].getCode_dep());
			disp.setName_dep(ques[0].getName_dep());
			disp.setId_scsrv(ques[0].getId_scsrv());
			disp.setCode_scsrv(ques[0].getCode_scsrv());
			disp.setName_srv(ques[0].getName_scsrv());
			if(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP.equals(ques[0].getSd_srvtp())
					|| IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_SPECIAL.equals(ques[0].getSd_srvtp())){
				// 专家
				disp.setRegtp(REGTP_OP_EXP);
			}else{
				// 普通
				disp.setRegtp(REGTP_OP_NORM);
			}
		}else{
			IQuebenRService benRservice = ServiceFinder.find(IQuebenRService.class);
			if(!EnValidator.isEmpty(site.getId_queben())){
				QueBenDO bendo = benRservice.findById(site.getId_queben());
				disp.setAddr_board_ben(bendo.getAddr_board());
			}
			disp.setId_dep(site.getId_dep());
			disp.setName_dep(site.getDep_name());
			disp.setCode_dep(site.getDep_code());
			disp.setId_scsrv(ques[0].getId_scsrv());
			disp.setCode_scsrv(ques[0].getCode_scsrv());
			disp.setName_srv(ques[0].getName_scsrv());
			if(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP.equals(ques[0].getSd_srvtp())
					|| IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_SPECIAL.equals(ques[0].getSd_srvtp())){
				// 专家
				disp.setRegtp(REGTP_OP_EXP);
			}else{
				// 普通
				disp.setRegtp(REGTP_OP_NORM);
			}
		}
		return (QueDO[]) ques.clone();
	}

	/**
	 * 设置站点信息
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private QueSiteDO setSiteInfo(OpQue4DispDTO disp, OpQue4EsDTO es)
			throws BizException {
		if (EnValidator.isEmpty(es.getId_que_site()))
			return null;
		BdSiteEP ep = new BdSiteEP();
		QueSiteDO site = ep.getSiteById(es.getId_que_site());
		if (site == null)
			return null;
		if (site.getShortname() == null) {
			disp.setCode_room(site.getName());
		} else {
			disp.setCode_room(site.getShortname());
		}
		disp.setName_room(site.getName());
		disp.setAddr_board_site(site.getAddr_board());
		disp.setSite_status(site.getEu_pause());
		if (site.getId_emp() != null) {
			disp.setId_doc(site.getId_emp());
			disp.setCode_doc(site.getEmp_code());
			disp.setName_doc(site.getEmp_name());
		} else {
			if(!EnValidator.isEmpty(es.getId_doc()) && !EnValidator.isEmpty(es.getCode_doc())  && !EnValidator.isEmpty(es.getName_doc())){
				disp.setId_doc(es.getId_doc());
				disp.setCode_doc(es.getCode_doc());
				disp.setName_doc(es.getName_doc());
			}else if(!EnValidator.isEmpty(es.getId_doc())){
				disp.setId_doc(es.getId_doc());
				PsnDocEP psnEp = new PsnDocEP();
				PsnDocDO psnDocDO = psnEp.getPsnById(es.getId_doc());
				if(psnDocDO != null){
					disp.setCode_doc(psnDocDO.getCode());
					disp.setName_doc(psnDocDO.getName());
				}
			}
		}
		return (QueSiteDO) site.clone();
	}

	/**
	 * 设置就诊信息
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private void setEntInfo(OpQue4DispDTO disp, OpQue4EsDTO es)
			throws BizException {
		if (EnValidator.isEmpty(es.getId_ent()))
			return;
		OpEP opEP = new OpEP();
		OutpatientDO op = opEP.getOpByEntIdWithOutRef(es.getId_ent());
		if (op != null) {
			disp.setId_scsrv(op.getId_scsrv());
			disp.setCode_scsrv(op.getScsrv_code());
			disp.setName_srv(op.getScsrv_name());
			disp.setTimes_op(op.getTimes_op());
		}
		EnQueEP queEP = new EnQueEP();
		EnQueueDO[] enques = queEP.getEnQueueByEntId(es.getId_ent(),
				IBdFcDictCodeConst.SD_QUETP_EMP);
		if (!EnValidator.isEmpty(enques)) {
			EnQueueDO enque = enques[0];
			disp.setId_ent(enque.getId_ent());
			disp.setTickno(enque.getSortno());
			disp.setSortno(enque.getSortno());
			disp.setLevel_pri(((enque.getLevel_pri() == null || enque
					.getLevel_pri() == 0) ? 0 : 1) + "");
		}
		PvEP pvEP = new PvEP();
		PatiVisitDO ent = pvEP.getPvById(es.getId_ent());
		if (ent != null) {
			disp.setId_ent(ent.getId_ent());
			disp.setName_pat(ent.getName_pat());
			disp.setCode_pat(ent.getCode_pat());
			disp.setDt_birth_pat(ent.getDt_birth_pat());
			disp.setAge(getString(EnAppUtils.getAge(ent.getDt_birth_pat())));
		}
	}

	/**
	 * 设置当前接诊者序号
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private void setCurAcpt(OpQue4DispDTO disp,QueSiteDO site, EnTrDocSiteInfoDTO siteInfo) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EQ.SORTNO AS CUR_ACPT_SORTNO, ");
		sb.append("EQ.NAME_PAT AS CUR_NAME_PAT,OP.SD_SVRTP AS CUR_SD_SRVTP, ");
		sb.append("SCSRV.SHORTNAME AS SHORTNAME_SRV,");
		sb.append("PAT.BARCODE_CHIS AS CUR_BARCODE_CHIS ");
		sb.append("FROM EN_ENT_OP OP ");
		sb.append("INNER JOIN EN_ENT_QUE EQ ON OP.ID_ENT = EQ.ID_ENT ");
		sb.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT = EQ.ID_PAT ");
		sb.append("INNER JOIN SC_SRV SCSRV ON SCSRV.ID_SCSRV = OP.ID_SCSRV ");
		sb.append("WHERE OP.SD_STATUS = ? ");
		sb.append("AND EQ.DT_REGIST = ? ");
		sb.append("AND EQ.ID_DATESLOT = ? ");
		sb.append("AND EQ.ID_QUE_SITE = ? ");
		sb.append("ORDER BY EQ.DT_ACPT DESC ");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
		param.addParam(siteInfo.getDate());
		param.addParam(siteInfo.getId_dayslot());
		param.addParam(site.getId_quesite());
		List<OpQue4DispDTO> list = (List<OpQue4DispDTO>) new DAFacade()
				.execQuery(sql, param, new BeanListHandler(OpQue4DispDTO.class));
		if (!EnValidator.isEmpty(list)) {
			OpQue4DispDTO opQue4Disp = list.get(0);
			disp.setCur_acpt_sortno(opQue4Disp.getCur_acpt_sortno());
			disp.setCur_barcode_chis(opQue4Disp.getCur_barcode_chis());
			disp.setCur_name_pat(opQue4Disp.getCur_name_pat());
			disp.setCur_sd_srvtp(opQue4Disp.getCur_sd_srvtp());
			disp.setShortname_srv(opQue4Disp.getShortname_srv());
		}
	}

	/**
	 * 设置医生职称
	 * 
	 * @param disp
	 * @throws DAException
	 */
	private void setDocTitle(OpQue4DispDTO disp) throws DAException {
		if (!this.isSecond(disp))
			return;
		if (EnValidator.isEmpty(disp.getId_doc()))
			return;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT BD_UDIDOC.NAME AS NAME_DOCTITLE, ");
		sb.append("RES.DES Doc_desc  ");
		sb.append("FROM BD_PSNDOC BD_PSNDOC ");
		
		sb.append("INNER JOIN BD_UDIDOC BD_UDIDOC ON BD_PSNDOC.ID_EMPTITLE = BD_UDIDOC.ID_UDIDOC ");
		sb.append("LEFT JOIN SC_RES RES ");
		sb.append("ON RES.ID_EMP = BD_PSNDOC.ID_PSNDOC ");
		sb.append("WHERE BD_PSNDOC.ID_PSNDOC = ? ");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(disp.getId_doc());
		List<OpQue4DispDTO> list = (List<OpQue4DispDTO>) new DAFacade()
				.execQuery(sql, param, new BeanListHandler(OpQue4DispDTO.class));
		if (!EnValidator.isEmpty(list)){
			disp.setName_doctitle(list.get(0).getName_doctitle());
			disp.setDoc_desc(list.get(0).getDoc_desc());
		}
	}

	/**
	 * 设置候诊人数
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private void setWaitNum(OpQue4DispDTO disp, QueDO[] ques, EnTrDocSiteInfoDTO siteInfo) throws BizException {
		Integer res = 0;
		if(!EnValidator.isEmpty(ques)){
			GetSiteEntStats4BenMgrBP bp = new GetSiteEntStats4BenMgrBP();
			res = bp.getWaitCount(EnAppUtils.getKeyPropArrayFromDO(QueDO.ID_QUE, ques), siteInfo);
		}
		disp.setWaitnum(res);
	}

	/**
	 * 设置候诊号
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private void setWaitQuenos(OpQue4DispDTO disp, QueDO[] ques, QueSiteDO site,
			EnTrDocSiteInfoDTO siteInfo, boolean isBenQueMgr) throws BizException {
		EnQueueDO[] queues = new EnQueueDO[]{};
		if(isBenQueMgr){
			//分诊台管理队列模式
			OpCallingNum4BenMgrBP mrbp = new OpCallingNum4BenMgrBP();
			queues = mrbp.getCallEntQues(ques, site, siteInfo);
		}else{
			if(ques == null || ques.length <= 0){
				queues = null;
			}else{
				OpCallingNumBP bp = new OpCallingNumBP();
				queues = bp.getCallEntQues(ques[0], site, siteInfo);
			}
		}
		this.setWaitQuenos4EnQue(disp,queues,site);
	}

	/****
	 * 设置候诊号，根据就诊队列DO数组
	 * @param disp
	 * @param queues
	 * @param site
	 * @throws BizException 
	 */
	private void setWaitQuenos4EnQue(OpQue4DispDTO disp,EnQueueDO[] queues,QueSiteDO site) throws BizException{
		if (EnValidator.isEmpty(queues))
			return;
		boolean isFirst = true;
		String waitQuenos = "";
		int temp = 0;
		int call_num = site.getCall_num() == null ? 0 : site.getCall_num() - 1;
		FArrayList waitList = new FArrayList();
		Boolean isOnDisAfterAll = EnParamUtils.isOnDisplayAfterCall();
		OpQue4DispDTO[] srvInfoDTOs = this.getSrvInfo(queues);
		for (EnQueueDO queue : queues) {
			if(isOnDisAfterAll){
				if (queue.getSortno_called() == null
						|| queue.getSortno_called() <= 0)
					continue;
				}
			if (IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(queue
					.getSd_status_acpt())) {
				// 如果有叫号患者，把当前号设为叫号患者
				disp.setCur_barcode_chis(queue.getBarcode_chis());
				disp.setCur_name_pat(queue.getName_pat());
				disp.setCur_acpt_sortno(queue.getSortno());
				if(!EnValidator.isEmpty(srvInfoDTOs)){
					for(OpQue4DispDTO srvInfoDTO : srvInfoDTOs){
						if(queue.getId_ent().equals(srvInfoDTO.getId_ent())){
							disp.setCur_sd_srvtp(srvInfoDTO.getCur_sd_srvtp());
							disp.setShortname_srv(srvInfoDTO.getShortname_srv());
						}
					}
				}
				continue;
			}
			if (temp < call_num) {
				if (isFirst) {
					waitQuenos += queue.getSortno();
					isFirst = false;
				} else {
					waitQuenos = waitQuenos + "、" + queue.getSortno();
				}
				waitList.add(queue);
				call_num++;
			}
		}
		disp.setWait_list(waitList);
		disp.setWait_quenos(waitQuenos);
	}

	/**
	 * 是否需要二次分诊
	 * 
	 * @param disp
	 * @return
	 */
	public boolean isSecond(OpQue4DispDTO disp) {
		if (disp == null
				|| EnValidator.isEmpty(disp.getAddr_board_ben())
				|| EnValidator.isEmpty(disp.getAddr_board_site()))
			return false;
		String[] benAddr = disp.getAddr_board_ben().split(",");
		return !Arrays.asList(benAddr).contains( disp .getAddr_board_site());
	}

	private static String getString(Object obj) {
		if (obj == null)
			return "";
		return obj.toString();
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	private FDateTime getNowTime() {
		return EnAppUtils.getServerDateTime();
	}

	/**
	 * 获取日期分组
	 * 
	 * @return
	 * @throws BizException
	 */
	private DaysLotDO getNowDayslot(OpQue4EsDTO es) throws BizException {
		String codeScTp = null;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(es.getCode_entp()) || 
				IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(es.getCode_entp()) || 
				IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(es.getCode_entp()) ||
				IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(es.getCode_entp())) {
			codeScTp = IScDictCodeConst.SD_SCTP_JZ;
		}else{
			codeScTp = IScDictCodeConst.SD_SCTP_OP;
		}
		IScDaysLotService serv = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO dayslot = serv.getNowDaysLotCross(codeScTp, FBoolean.TRUE);
		return dayslot;
	}
	
	/**
	 * 离线后状态全都是DEL
	 * @param disp
	 * @return
	 */
	private Boolean IsOffLine(OpQue4DispDTO disp){
		if(disp.getSite_status() !=null && PauseEnum.OFFLINE.toString().equals(disp.getSite_status())){
			return true;
		}
		return false;
	}
	/**
	 * 设置就诊信息
	 * 
	 * @param queId
	 * @return
	 * @throws BizException 
	 */
	private OpQue4EsDTO setEntInfo(OpQue4EsDTO es) throws BizException{
		if(es == null)
			es = new OpQue4EsDTO();
		EnLogUtil logUtil =EnLogUtil.getInstance() ;
		if(!EnValidator.isEmpty(es.getId_ent())){
			StringBuilder sb  = new StringBuilder();
			sb.append("SELECT EN.ID_ENT,");
			sb.append("EN.ID_EMP_PHY AS ID_DOC,");
			sb.append("EN.ID_PAT,");
			sb.append("EN.NAME_PAT,");
			sb.append("EN.ID_DEP_PHY,");
			sb.append("EN.DT_BIRTH_PAT,");
			sb.append("OP.ID_SCSRV,");
			sb.append("OP.TICKETNO AS TICKNO,");
			sb.append("EMP.CODE AS CODE_DOC,");
			sb.append("EMP.NAME AS NAME_DOC,");
			sb.append("DEP.CODE AS CODE_DEP,");
			sb.append("DEP.NAME AS NAME_DEP, ");
			sb.append("SCSRV.CODE AS CODE_SCSRV,");
			sb.append("SCSRV.NAME AS NAME_SRV, ");
			sb.append("SCSRV.SHORTNAME AS SHORTNAME_SRV ");
			sb.append("FROM EN_ENT EN ");
			sb.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
			sb.append("LEFT JOIN BD_PSNDOC EMP ON EN.ID_EMP_PHY = EMP.ID_PSNDOC ");
			sb.append("LEFT JOIN BD_DEP DEP ON EN.ID_DEP_PHY = DEP.ID_DEP ");
			sb.append("LEFT JOIN SC_SRV SCSRV ON OP.ID_SCSRV = SCSRV.ID_SCSRV ");
			sb.append("WHERE EN.ID_ENT = ? ");   
		    String sql = sb.toString();
		    SqlParam param = new SqlParam();
		    param.addParam(es.getId_ent());
		    List<OpQue4EsDTO> list = (List<OpQue4EsDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(OpQue4EsDTO.class)); 
			if (!EnValidator.isEmpty(list)) {
				OpQue4EsDTO e = list.get(0);
				es.setId_ent(es.getId_ent());
				es.setId_doc(e.getId_doc());
				es.setCode_doc(e.getCode_doc());
				es.setName_doc(e.getName_doc());
				es.setId_pat(e.getId_pat());
				es.setName_pat(e.getName_pat());
				es.setId_dep(e.getId_dep());
				es.setCode_dep(e.getCode_dep());
				es.setName_dep(e.getName_dep());
				es.setId_scsrv(e.getId_scsrv());
				es.setCode_scsrv(e.getCode_scsrv());
				es.setName_srv(e.getName_srv());
				es.setShortname_srv(e.getShortname_srv());
				es.setTickno(e.getTickno());
				es.setDt_birth_pat(e.getDt_birth_pat());
				es.setAge(getString(EnAppUtils.getAge(es.getDt_birth_pat())));
			}
		}else {
			logUtil.logInfo("Id_ent为空！");
		}
		return es;
	}
	/***
	 * @Description:获取队列的服务信息
	 * @param queues
	 * @return
	 * @throws BizException
	 */
	private OpQue4DispDTO[] getSrvInfo(EnQueueDO[] queues) throws BizException{
		if(EnValidator.isEmpty(queues))
			return null;
		List<String> id_ents = new ArrayList<String>();
		for(EnQueueDO que : queues){
			if(!id_ents.contains(que.getId_ent())){
				id_ents.add(que.getId_ent());
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT OP.ID_ENT,");
		sb.append("OP.SD_SVRTP AS CUR_SD_SRVTP, ");
		sb.append("SCSRV.SHORTNAME AS SHORTNAME_SRV ");
		sb.append("FROM EN_ENT_OP OP ");
		sb.append("INNER JOIN SC_SRV SCSRV ON SCSRV.ID_SCSRV = OP.ID_SCSRV ");
		sb.append("WHERE  "+SqlUtils.getInSqlByIds("OP.ID_ENT", id_ents));
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		List<OpQue4DispDTO> list = (List<OpQue4DispDTO>) new DAFacade()
				.execQuery(sql, new BeanListHandler(OpQue4DispDTO.class));
		return EnValidator.isEmpty(list) ? null:list.toArray(new OpQue4DispDTO[]{} );
	}
}
