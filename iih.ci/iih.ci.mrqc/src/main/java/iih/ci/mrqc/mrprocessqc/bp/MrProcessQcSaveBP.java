package iih.ci.mrqc.mrprocessqc.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.dto.d.MrDTO;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mrqc.itmdto.d.ItmDTO;
import iih.ci.mrqc.qaflt.d.QaFltDO;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.qaflt.i.IQafltCudService;
import iih.ci.mrqc.qaflt.i.IQafltRService;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.ci.mrqc.qared.d.QaRecordDO;
import iih.ci.mrqc.qared.i.IQaCudService;
import iih.ci.mrqc.revisionnotice.d.RevisionNoticeDO;
import iih.ci.mrqc.revisionnotice.i.IRevisionnoticeCudService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public class MrProcessQcSaveBP {
	
    /**
     * 保存环节质控缺陷
     * @return
     * @throws BizException
     */
	public boolean saveMrQcProcessItmList(ItmDTO itmDto,QaPatListDTO qaPatListDto, MrDTO mrDto) throws BizException{
		QaFltDO fltDo=new QaFltDO();
		fltDo.setId_org(Context.get().getOrgId());
		fltDo.setId_grp(Context.get().getGroupId());
		fltDo.setId_qa_itm(itmDto.getId_qa_itm());
		fltDo.setId_qa_ty(ICiMrDictCodeConst.ID_EXEC_SEGMENT);
		fltDo.setSd_qa_ty(ICiMrDictCodeConst.SD_EXEC_SEGMENT);
		fltDo.setId_flt_sta(ICiMrDictCodeConst.ID_REFORM);
		fltDo.setSd_flt_sta(ICiMrDictCodeConst.SD_REFORM);
		fltDo.setDt_sbmt(new FDateTime());
		fltDo.setId_sbmt_user(Context.get().getUserId());
		fltDo.setId_sbmt_dept(Context.get().getDeptId());
		fltDo.setRfm_req(itmDto.getReq());
		fltDo.setRfm_des(itmDto.getDrp_des());
		fltDo.setReal_score(itmDto.getReal_score());
		fltDo.setId_ent(qaPatListDto.getId_ent());
		fltDo.setDeduct_scr_times(1);
		//fltDo.setDeduct_scr_times(itmDto.getDeduct_scr_times());
		fltDo.setStatus(DOStatus.NEW);
		if (mrDto!=null) {
			if(null == mrDto.getId_mr()){
				String userId = this.getIdUser(mrDto.getId_treat_doctor());
				fltDo.setId_mr(mrDto.getMrcactm_name());
				fltDo.setId_rfm_user(userId);
				fltDo.setId_rfm_dept(mrDto.getId_dep_pat());
			}else{
				fltDo.setId_mr(mrDto.getId_mr());
				fltDo.setId_rfm_user(mrDto.getId_treat_doctor());
				fltDo.setId_rfm_dept(mrDto.getId_dep_pat());
			}
			
		}else{
			String userId = this.getIdUser(qaPatListDto.getId_emp_phy());
			fltDo.setId_rfm_user(userId);
			fltDo.setId_rfm_dept(qaPatListDto.getId_dep_phy());
		}
		IQafltCudService fltSaveService =ServiceFinder.find(IQafltCudService.class);
		QaFltDO[] resultArr= fltSaveService.save(new QaFltDO[]{fltDo});
		if (resultArr!=null&&resultArr.length>0) {
			return true;
		} else {
			return false;
		}
	}
    /**
     * 保存环节质控缺陷
     * @param qaPatListDto
     * @param qaFltDtos
     * @return
     * @throws BizException
     */
	public String saveMrProcessQcNoticeAndFlt(QaPatListDTO qaPatListDto, QaFltDTO[] qaFltDtos,int deadDays,String des) throws BizException{
		String idRevision="";
		if (qaFltDtos!=null&&qaFltDtos.length>0) {
			Map<String, List<QaFltDTO>> fltmap = new HashMap<String, List<QaFltDTO>>();
			for (QaFltDTO fltDto : qaFltDtos) {
				if (!fltmap.containsKey(fltDto.getId_treat_doctor())) {
					fltmap.put(fltDto.getId_treat_doctor(), new ArrayList<QaFltDTO>());
				}
				fltmap.get(fltDto.getId_treat_doctor()).add(fltDto);
			}
			List<RevisionNoticeDO> noticelist=new ArrayList<RevisionNoticeDO>();
			for (String key : fltmap.keySet()) {
				RevisionNoticeDO notice=new RevisionNoticeDO();
				notice.setId_status(ICiMrDictCodeConst.ID_TO_REFORM);
				notice.setSd_status(ICiMrDictCodeConst.SD_TO_REFORM);
				notice.setId_org(Context.get().getOrgId());
				notice.setId_grp(Context.get().getGroupId());
				notice.setDt_send(new FDateTime());
				notice.setId_exec_doctor(Context.get().getUserId());
				notice.setId_exec_dept(Context.get().getDeptId());
				notice.setRfm_deadline(deadDays);
				notice.setId_ent(qaPatListDto.getId_ent());
				notice.setDes(des);
				notice.setId_qa_ty(ICiMrDictCodeConst.ID_EXEC_SEGMENT);
				notice.setSd_qa_ty(ICiMrDictCodeConst.SD_EXEC_SEGMENT);
				notice.setDt_deadline(new FDateTime().getDateTimeAfter(deadDays));
				notice.setId_rfm_doctor(key);
				QaFltDTO[] tempDoArr = null;
				if(fltmap.get(key) != null){
					List<QaFltDTO> list = fltmap.get(key);
					if(list.size() != 0){
						tempDoArr = new QaFltDTO[list.size()];
						for (int i = 0; i < list.size(); i++) {
							tempDoArr[i] = list.get(i);
						}
					}
				}
				if (tempDoArr!=null&&tempDoArr.length>0) {
					notice.setId_rfm_dept(tempDoArr[0].getId_dep_pat());
				}else{
					notice.setId_rfm_dept(qaPatListDto.getId_dep_phy());
				}
				notice.setStatus(DOStatus.NEW);
				noticelist.add(notice);
			}
			RevisionNoticeDO[] noticeArr=SaveNoticeList(noticelist);
			
			if(noticeArr.length>0){
				List<QaFltDO> qafltlist=new ArrayList<QaFltDO>();
				for (RevisionNoticeDO noticeDo : noticeArr) {
					List<QaFltDTO> fltdtolist=fltmap.get(noticeDo.getId_rfm_doctor());
					for(QaFltDTO fltDto:fltdtolist){
						QaFltDO qafltdo=FindById(fltDto.getId_qaflt());
						if (FBoolean.FALSE.equals(fltDto.getFg_selected())) {
							qafltdo.setId_flt_sta(ICiMrDictCodeConst.ID_POINTS);
							qafltdo.setSd_flt_sta(ICiMrDictCodeConst.ID_POINTS);
						}
						qafltdo.setId_revision(noticeDo.getId_revision());
						qafltdo.setStatus(DOStatus.UPDATED);
						qafltlist.add(qafltdo);
					}
					if(qafltlist.size()!=0){
						UpdateQaFlt(qafltlist.toArray(new QaFltDO[0]));
					}
					//更新病案表 如果是环节就是去更新谁做过环节质控
					UpdateAmr(qaPatListDto.getId_amr(),noticeDo,qaPatListDto);
				}
				if(noticeArr.length == 1){//通知是一条的处理
					QaRecordDO qarecord =new QaRecordDO();
					qarecord.setId_revision(noticeArr[0].getId_revision());
					idRevision=noticeArr[0].getId_revision();
					qarecord.setId_org(Context.get().getOrgId());
					qarecord.setId_grp(Context.get().getGroupId());
					qarecord.setId_qa_ty(ICiMrDictCodeConst.ID_EXEC_SEGMENT);
					qarecord.setSd_qa_ty(ICiMrDictCodeConst.SD_EXEC_SEGMENT);
					qarecord.setDt_plan(new FDateTime());
					qarecord.setId_exec_user(Context.get().getUserId());
					qarecord.setId_exec_dept(Context.get().getDeptId());
					qarecord.setId_ent(qaPatListDto.getId_ent());
					qarecord.setRfm_deadline(deadDays);
					qarecord.setName_divide_level(qaPatListDto.getLevelnew());
					qarecord.setScore_qa_ty(qaPatListDto.getScore_process());
					qarecord.setStatus(DOStatus.NEW);
					qarecord = SaveRecord(qarecord);
					UpdateRevision(qarecord,noticeArr);
				}else{//通知是多条的处理
					QaRecordDO qarecord =new QaRecordDO();
					String Id_revision = "";
					for(int i = 0;i < noticeArr.length ; i++){
						if(i == noticeArr.length - 1){
							Id_revision += noticeArr[i].getId_revision();
						}else{
							Id_revision += noticeArr[i].getId_revision()+",";
						}
					}
					idRevision=Id_revision;
					qarecord.setId_revision(Id_revision);
					qarecord.setId_org(Context.get().getOrgId());
					qarecord.setId_grp(Context.get().getGroupId());
					qarecord.setId_qa_ty(ICiMrDictCodeConst.ID_EXEC_SEGMENT);
					qarecord.setSd_qa_ty(ICiMrDictCodeConst.SD_EXEC_SEGMENT);
					qarecord.setDt_plan(new FDateTime());
					qarecord.setName_divide_level(qaPatListDto.getLevelnew());
					qarecord.setId_exec_user(Context.get().getUserId());
					qarecord.setId_exec_dept(Context.get().getDeptId());
					qarecord.setId_ent(qaPatListDto.getId_ent());
					qarecord.setRfm_deadline(deadDays);
					qarecord.setScore_qa_ty(qaPatListDto.getScore_process());
					qarecord.setStatus(DOStatus.NEW);
					qarecord = SaveRecord(qarecord);
					UpdateRevision(qarecord,noticeArr);
				}
			}
		} else {//没提缺陷
			RevisionNoticeDO notice=new RevisionNoticeDO();
			notice.setId_status(ICiMrDictCodeConst.ID_NOTCHANGE);
			notice.setSd_status(ICiMrDictCodeConst.SD_NOTCHANGE);
			notice.setId_org(Context.get().getOrgId());
			notice.setId_grp(Context.get().getGroupId());
			notice.setDt_send(new FDateTime());
			notice.setStatus(DOStatus.NEW);
			notice.setId_exec_doctor(Context.get().getUserId());
			notice.setId_exec_dept(Context.get().getDeptId());
			notice.setId_ent(qaPatListDto.getId_ent());
			notice.setDes(des);
			notice.setId_qa_ty(ICiMrDictCodeConst.ID_EXEC_SEGMENT);
			notice.setSd_qa_ty(ICiMrDictCodeConst.SD_EXEC_SEGMENT);
			notice.setId_rfm_doctor(qaPatListDto.getId_emp_submit());//整改医生为责任医师
			notice.setId_rfm_dept(qaPatListDto.getId_dep_phy());
			List<RevisionNoticeDO> list  = new ArrayList<RevisionNoticeDO>();
			list.add(notice);
			RevisionNoticeDO[] noticeArr=SaveNoticeList(list);
			QaRecordDO qarecord =new QaRecordDO();
			if(noticeArr.length > 0){
				qarecord.setId_revision(noticeArr[0].getId_revision());
				idRevision=noticeArr[0].getId_revision();
			}else{
				qarecord.setId_revision("");
			}
			qarecord.setId_org(Context.get().getOrgId());
			qarecord.setId_grp(Context.get().getGroupId());
			qarecord.setId_qa_ty(ICiMrDictCodeConst.ID_EXEC_SEGMENT);
			qarecord.setSd_qa_ty(ICiMrDictCodeConst.SD_EXEC_SEGMENT);
			qarecord.setDt_plan(new FDateTime());
			qarecord.setId_exec_user(Context.get().getUserId());
			qarecord.setId_exec_dept(Context.get().getDeptId());
			qarecord.setId_ent(qaPatListDto.getId_ent());
			qarecord.setRfm_deadline(deadDays);
			qarecord.setScore_qa_ty(qaPatListDto.getScore_process());
			qarecord.setStatus(DOStatus.NEW);
			SaveRecord(qarecord);
			UpdateRevision(qarecord,noticeArr);
			//暂存
			RevisionNoticeDO tempDo=new RevisionNoticeDO();
			tempDo.setId_qa_ty(ICiMrDictCodeConst.ID_EXEC_SEGMENT);
			tempDo.setSd_qa_ty(ICiMrDictCodeConst.SD_EXEC_SEGMENT);
			tempDo.setId_exec_doctor(qaPatListDto.getId_emp_phy());
			//更新病案表
			UpdateAmr(qaPatListDto.getId_amr(),tempDo,qaPatListDto);
		}
		return idRevision;
	}
	/**
	 * 保存工作记录
	 * @param qarecord
	 * @throws BizException
	 */
	public QaRecordDO SaveRecord(QaRecordDO qarecord)throws BizException{
		IQaCudService service=ServiceFinder.find(IQaCudService.class);
		return service.save(new QaRecordDO[]{qarecord})[0];
	}
	/**
	 * 保存缺陷
	 * @param qaflt
	 * @throws BizException
	 */
	public void UpdateQaFlt(QaFltDO[] qaflt)throws BizException{
		IQafltCudService service=(IQafltCudService)ServiceFinder.find(IQafltCudService.class.getName());
		service.save(qaflt);
	}
	/**
	 * 保存通知单
	 * @param revnotice
	 * @throws BizException
	 */
	public RevisionNoticeDO SaveNotice(RevisionNoticeDO revnotice)throws BizException{
		IRevisionnoticeCudService service=(IRevisionnoticeCudService)ServiceFinder.find(IRevisionnoticeCudService.class.getName());
		return service.save(new RevisionNoticeDO[]{revnotice})[0];
	}

	/**
	 * 查找缺陷数据
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public QaFltDO FindById(String id)throws BizException{
		IQafltRService service=(IQafltRService)ServiceFinder.find(IQafltRService.class.getName());
		return service.findById(id);
	}
	/**
	 * 修改病案状态  暂时不用
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public void UpdateAmr(String id,RevisionNoticeDO revnotice,QaPatListDTO qaPatListDto)throws BizException{
		if(revnotice.getId_qa_ty().equals(ICiMrDictCodeConst.ID_EXEC_SEGMENT)){//环节质控
			ICiamrRService rservice=(ICiamrRService)ServiceFinder.find(ICiamrRService.class.getName());
			ICiamrCudService cservice=(ICiamrCudService)ServiceFinder.find(ICiamrCudService.class.getName());


			AMrDO amrDO= rservice.findById(id);
			if(amrDO!=null){
				amrDO.setFg_process_qa(FBoolean.TRUE);
				amrDO.setId_emp_process_qa(revnotice.getId_exec_doctor());
				amrDO.setName_divide_level(qaPatListDto.getLevelnew());
				amrDO.setScore_qa_ty(qaPatListDto.getScore_process());
				amrDO.setStatus(DOStatus.UPDATED);
				cservice.save(new AMrDO[] {amrDO});
			}
		}else{
			return;
		}
	}
	/**
	 * 保存通知数据组
	 * @param revnotice
	 * @throws BizException
	 */
	public RevisionNoticeDO[] SaveNoticeList(List<RevisionNoticeDO> noticelist)throws BizException{
		IRevisionnoticeCudService service=(IRevisionnoticeCudService)ServiceFinder.find(IRevisionnoticeCudService.class.getName());
		RevisionNoticeDO[] revnotice=noticelist.toArray(new RevisionNoticeDO[0]);
		return service.save(revnotice);
	}
	/**
	 * 获取患者就诊科室 赋值给 通知表的整改科室
	 * @param revnotice
	 * @throws BizException
	 */
	public String GetdepByIdPsnFromEn(String id_ent)throws BizException{
		
		IPativisitRService service=(IPativisitRService)ServiceFinder.find(IPativisitRService.class.getName());
		PatiVisitDO enDo=service.findById(id_ent);
		return enDo.getId_dep_phy();
	}
	
	
	//根据id_psn 获取 患者id_user
	private String getIdUser(String id_psn) throws BizException{
		IUserRService userService = ServiceFinder.find(IUserRService.class);
		UserDO[] userArr=userService.find("a0.id_psn='"+id_psn+"'", "", FBoolean.FALSE);
		if (userArr.length > 0) {
			return userArr[0].getId_user();
		}else{
			return "~";
		}
	}
	/**
	 * 将记录的主键存入通知中
	 * @param recordDo
	 * @param revisionNoticeDOs
	 * @throws BizException
	 */
	private void UpdateRevision(QaRecordDO recordDo,RevisionNoticeDO[] revisionNoticeDOs) throws BizException{
		List<RevisionNoticeDO> revisionList = new ArrayList<RevisionNoticeDO>();
		for (int i = 0; i < revisionNoticeDOs.length; i++) {
			revisionNoticeDOs[i].setId_qa_record(recordDo.getId_qa());
			revisionNoticeDOs[i].setStatus(DOStatus.UPDATED);
			revisionList.add(revisionNoticeDOs[i]);
		}
		SaveNoticeList(revisionList);
	}


}
