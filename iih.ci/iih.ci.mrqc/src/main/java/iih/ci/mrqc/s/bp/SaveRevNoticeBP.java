package iih.ci.mrqc.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mrqc.qaflt.d.QaFltDO;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.qaflt.i.IQafltCudService;
import iih.ci.mrqc.qaflt.i.IQafltRService;
import iih.ci.mrqc.qared.d.QaRecordDO;
import iih.ci.mrqc.qared.i.IQaCudService;
import iih.ci.mrqc.revisionnotice.d.RevisionNoticeDO;
import iih.ci.mrqc.revisionnotice.i.IRevisionnoticeCudService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

public class SaveRevNoticeBP {

	public String SaveRevNotice(RevisionNoticeDO revnotice,QaFltDTO[] qaflt,QaRecordDO qarecord,String id_amr)throws BizException{
		String idRevision="";
		if(null!=qaflt && qaflt.length>0){
		Map<String, List<QaFltDTO>> fltmap = new HashMap<String, List<QaFltDTO>>();
		for (QaFltDTO d : qaflt) {
			if (!fltmap.containsKey(d.getId_emp_submit())) {
				fltmap.put(d.getId_emp_submit(), new ArrayList<QaFltDTO>());
			}
			fltmap.get(d.getId_emp_submit()).add(d);
		}
		List<RevisionNoticeDO> noticelist=new ArrayList<RevisionNoticeDO>();
		
		for (String key : fltmap.keySet()) {
			RevisionNoticeDO notice=new RevisionNoticeDO();
			notice.setId_status(revnotice.getId_status());
			notice.setSd_status(revnotice.getSd_status());
			notice.setId_org(revnotice.getId_org());
			notice.setId_grp(revnotice.getId_grp());
			notice.setDt_send(revnotice.getDt_send());
			notice.setId_exec_doctor(revnotice.getId_exec_doctor());
			notice.setId_exec_dept(revnotice.getId_exec_dept());
			notice.setRfm_deadline(revnotice.getRfm_deadline());
			notice.setId_ent(revnotice.getId_ent());
			notice.setDes(revnotice.getDes());
			notice.setId_qa_ty(revnotice.getId_qa_ty());
			notice.setSd_qa_ty(revnotice.getSd_qa_ty());
			notice.setDt_deadline(revnotice.getDt_deadline());
			notice.setId_rfm_doctor(key);
			notice.setId_rfm_dept(GetdepByIdPsnFromEn(revnotice.getId_ent()));
			notice.setStatus(DOStatus.NEW);
			noticelist.add(notice);
		}

		RevisionNoticeDO[] noticeArr=SaveNoticeList(noticelist);
		if(noticeArr.length>0){
			List<QaFltDO> qafltlist=new ArrayList<QaFltDO>();
			String Id_revision = "";
			for (RevisionNoticeDO noticeDo : noticeArr) {
				List<QaFltDTO> fltdtolist=fltmap.get(noticeDo.getId_rfm_doctor());
				for(QaFltDTO fltDto:fltdtolist){
					QaFltDO qafltdo=FindById(fltDto.getId_qaflt());
					qafltdo.setId_revision(noticeDo.getId_revision());
					qafltdo.setStatus(DOStatus.UPDATED);
					qafltlist.add(qafltdo);
				}
				if(qafltlist.size()!=0){
					UpdateQaFlt(qafltlist.toArray(new QaFltDO[0]));
				}
				//更新病案表 如果是环节就是去更新谁做过环节质控
				UpdateAmr(id_amr,noticeDo);
				Id_revision += noticeDo.getId_revision()+",";
			}
			if(Id_revision.length()>0){
			Id_revision=Id_revision.substring(0, Id_revision.length()-1);
			}
			//保存记录
			qarecord.setId_revision(Id_revision);
			SaveRecord(qarecord);
			idRevision=Id_revision;
			UpdateRevision(qarecord,noticeArr);
		}
		}else{//没提缺陷
			if(null!=revnotice){
				revnotice.setStatus(DOStatus.NEW);
				List<RevisionNoticeDO> noticelist=new ArrayList<RevisionNoticeDO>();
				noticelist.add(revnotice);
				RevisionNoticeDO[] noticeArr=SaveNoticeList(noticelist);
				qarecord.setId_revision(revnotice.getId_revision());
				SaveRecord(qarecord);	
				idRevision=revnotice.getId_revision();
				UpdateRevision(qarecord,noticeArr);
			}
		}
		return idRevision;
//		if(fltmap.size()==1){//所有缺陷只属于一个人 发送一条通知维持原逻辑不变
//			RevisionNoticeDO notice=new RevisionNoticeDO();
//			if(qaflt.length!=0){
//				if(revnotice!=null){
//					//获取保存后的通知单
//					revnotice.setId_rfm_doctor("");
//					revnotice.setId_rfm_dept("");
//					notice=SaveNotice(revnotice);
//					if(notice==null)
//						return FBoolean.FALSE;
//					UpdateAmr(id_amr,notice);
//				}
//				List<QaFltDO> qafltlist=new ArrayList<QaFltDO>();
//				for(QaFltDTO dto : qaflt){
//					QaFltDO qafltdo=FindById(dto.getId_qaflt());
//					qafltdo.setId_revision(notice.getId_revision());
//					qafltdo.setStatus(DOStatus.UPDATED);
//					qafltlist.add(qafltdo);
//				}
//				if(qafltlist.size()!=0){
//					UpdateQaFlt(qafltlist.toArray(new QaFltDO[0]));
//				}
//			}
//			if(qarecord!=null){
//				if(notice.getId_revision()!=null){
//					qarecord.setId_revision(notice.getId_revision());
//				}
//				QaRecordDO rth=Save(qarecord);
//				if(rth==null)
//					return FBoolean.FALSE;
//			}
//			return FBoolean.TRUE;
//		}



	}
	/**
	 * 保存工作记录
	 * @param qarecord
	 * @throws BizException
	 */
	public QaRecordDO SaveRecord(QaRecordDO qarecord)throws BizException{
		IQaCudService service=(IQaCudService)ServiceFinder.find(IQaCudService.class.getName());
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
	public void UpdateAmr(String id,RevisionNoticeDO revnotice)throws BizException{
		if(revnotice.getId_qa_ty().equals(ICiMrDictCodeConst.ID_EXEC_SEGMENT)){//环节质控
			ICiamrRService rservice=(ICiamrRService)ServiceFinder.find(ICiamrRService.class.getName());
			ICiamrCudService cservice=(ICiamrCudService)ServiceFinder.find(ICiamrCudService.class.getName());


			AMrDO amrDO= rservice.findById(id);
			if(amrDO!=null){
				amrDO.setFg_process_qa(FBoolean.TRUE);
				amrDO.setId_emp_process_qa(revnotice.getId_exec_doctor());
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
