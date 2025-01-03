package iih.en.er.bp.inouttransmgr;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EnEvtEP;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.EntDeptEP;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.EntOpErEP;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnErUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgInOutTransMgrDTO;
import iih.en.er.op.d.EnEntOpErDO;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.pv.deptrans.d.EnDepTransDO;
import iih.en.pv.deptrans.d.EnEuTrans;
import iih.en.pv.deptrans.i.IEndeptransCudService;
import iih.en.pv.out.d.EnEvtDTO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.enqueue.d.EnQueueDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 急诊流水转抢救
 * 
 * @author liubin
 *
 */
public class InOutTransOfFlowToFstaidBP extends InOutTransMgrBaseAbstract implements
		IInOutTransMgr {

	@Override
	protected void handle(UrgInOutTransMgrDTO data) throws BizException {
		// 1.获取患者本次预检所有就诊记录
		List<String> list = EnErUtils.getEntIdsByPreId(data.getId_erpre());
		// 2.使用床位 bd_bed
		useBed(data);
		// 3.修改en_ent
		PatiVisitDO pv = updatePv(data);
		// 4.修改en_ent_op
		updateOp(data);
		// 5.修改en_ent_que
		updateEnQue(data);
		// 6.修改en_ent_op_er
		EnEntOpErDO oper = updateOper(data);
		// 7.修改en_erpre
		updateErPre(data);
		// 8.插入en_ent_dep
		insertDep(data, list);
		// 9.插入en_ent_emp
		insertEmp(data, list);
		// 10.插入en_ent_bed
		insertBed(data, list);
		// 11.插入en_dep_trans
		insertDepTrans(data);
		// 12.插入en_ent_evt
		insertEvt(data);
	}
	/**
	 * 校验
	 */
	@Override
	protected void validate(UrgInOutTransMgrDTO data) throws BizException {
		super.validate(data);
		// 1.是否入科
		if (!IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(data.getCode_entp()))
			throw new BizException(String.format("该患者不是急诊流水患者[%s]，不能转抢救！", data.getCode_entp()));
	}
	/**
	 * 修改en_ent表
	 * 
	 * @param data
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO updatePv(UrgInOutTransMgrDTO data) throws BizException {
		PvEP pvEP = new PvEP();
		PatiVisitDO pv = pvEP.getPvById(data.getId_ent());
		pv.setStatus(DOStatus.UPDATED);
		pv.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID);//0102-就诊抢救 或 0103-就诊留观
		pv.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_ET_FSTAID);
		pv.setId_dep_nur(data.getId_dep_nur_new());
		pv.setId_emp_phy(data.getId_emp_phy_new());
		if(pv.getDt_acpt() == null)
			pv.setDt_acpt(data.getDt_trans());
		if(pv.getDt_end() != null)
			pv.setDt_end(null);
		pv.setFg_acptvalid(FBoolean.TRUE);
		return pvEP.savePv(pv);
	}
	/**
	 * 修改en_ent_op
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void updateOp(UrgInOutTransMgrDTO data) throws BizException {
		OpEP ep = new OpEP();
		OutpatientDO op = ep.getOpByEntIdWithOutRef(data.getId_ent());
		op.setFg_rescue(FBoolean.TRUE);
		op.setStatus(DOStatus.UPDATED);
		op.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
		ep.save(op);
	}
	/**
	 * 修改en_ent_que
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void updateEnQue(UrgInOutTransMgrDTO data) throws BizException {
		EnQueEP ep = new EnQueEP();
		EnQueueDO[] enQues = ep.getEnQueueByEntId(data.getId_ent());
		if(EnValidator.isEmpty(enQues))
			return;
		for(EnQueueDO enQue : enQues){
			enQue.setStatus(DOStatus.UPDATED);
			enQue.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID);//0102-就诊抢救 或 0103-就诊留观
			enQue.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_ET_FSTAID);
		}
		ep.save(enQues);
	}
	/**
	 * 修改en_ent_op_er
	 * 
	 * @param data
	 * @throws BizException
	 */
	private EnEntOpErDO updateOper(UrgInOutTransMgrDTO data)
			throws BizException {
		EntOpErEP ep = new EntOpErEP();
		EnEntOpErDO oper = ep.getByEntIdWithOutRef(data.getId_ent());
		oper.setStatus(DOStatus.UPDATED);
		oper.setId_bed(data.getId_bed_new());
		oper.setName_bed(data.getName_bed_new());
		oper.setId_level_nur(data.getId_level_nur_new());
		oper.setSd_level_nur(data.getSd_level_nur_new());
		oper.setFg_trans(FBoolean.TRUE);
		return ep.save(new EnEntOpErDO[] { oper })[0];
	}
	/**
	 * 修改en_erpre
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void updateErPre(UrgInOutTransMgrDTO data) throws BizException{
		ErPreEP ep = new ErPreEP();
		EnErPreDO erPre = ep.findById(data.getId_erpre());
		erPre.setStatus(DOStatus.UPDATED);
		erPre.setSd_triage_to(IEnDictCodeConst.SD_TRIAGETO_ERRESCUE);
		ep.save(new EnErPreDO[]{erPre});
	}
	/**
	 * 使用床位
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void useBed(UrgInOutTransMgrDTO data) throws BizException {
		BedEP ep = new BedEP();
		if(!EnValidator.isEmpty(data.getId_bed())){
			//1.释放原床
			ep.releaseBedRescue(data.getId_ent(), data.getId_bed(), FBoolean.TRUE);
		}
		//2.使用新床
		ep.useBed2(data.getId_bed_new());
	}

	/**
	 * 插入en_ent_dep
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void insertDep(UrgInOutTransMgrDTO data, List<String> list) throws BizException {
		EntDeptEP ep = new EntDeptEP();
		//结束原科室
		for(String entId : list){
			ep.endDept(entId, null, data.getId_dep_nur_new(), FBoolean.FALSE, data.getDt_trans());
		}
		ep.insertEntDep(data.getId_dep_nur_new(), data.getId_ent(),
				IEnDictCodeConst.SD_ENTDEPROLE_IA,
				IEnDictCodeConst.ID_ENTDEPROLE_IA, data.getDt_trans());
	}

	/**
	 * 插入en_ent_emp
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void insertEmp(UrgInOutTransMgrDTO data, List<String> list) throws BizException {
		EntEmpEP ep = new EntEmpEP();
		ep.endOldEmp(list, null, data.getDt_trans());
		if (EnValidator.isEmpty(data.getId_emp_phy_new()))
			return;
		ep.addEmp(data.getId_ent(), data.getId_emp_phy_new(),
				IEnDictCodeConst.ID_EMPROLE_DOCTOR,
				IEnDictCodeConst.SD_EMPROLE_DOCTOR, data.getDt_trans());
	}

	/**
	 * 插入en_ent_bed
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void insertBed(UrgInOutTransMgrDTO data, List<String> list) throws BizException {
		EntBedEP ep = new EntBedEP();
		for(String entId : list){
			ep.endUseBed(entId, data.getDt_trans());
		}
		ep.useBed(data.getId_ent(), data.getId_bed_new(),
				data.getName_bed_new(), data.getId_dep_nur_new(),
				data.getDt_trans());
	}
	/**
	 * 插入en_dep_trans
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void insertDepTrans(UrgInOutTransMgrDTO data) throws BizException {
		EnDepTransDO enDepTransDO = new EnDepTransDO();
		enDepTransDO.setId_ent(data.getId_ent());
		enDepTransDO.setId_dep_to(data.getId_dep_phy());
		enDepTransDO.setId_dep_nur_to(data.getId_dep_nur_new());
		enDepTransDO.setId_bed_to(data.getId_bed_new());
		enDepTransDO.setId_dep_from(data.getId_dep_phy());
		enDepTransDO.setId_dep_nur_from(data.getId_dep_nur());
		enDepTransDO.setId_bed_from(data.getId_bed());
		enDepTransDO.setEu_trans(EnEuTrans.ACPT);
		enDepTransDO.setId_or(null);
		enDepTransDO.setDt_apply(data.getDt_trans());
		enDepTransDO.setDt_acpt(data.getDt_trans());
		enDepTransDO.setId_emp_appl(EnContextUtils.getUserId());
		enDepTransDO.setId_emp_acpt(EnContextUtils.getUserId());
		IEndeptransCudService iEndeptransCudService = ServiceFinder.find(IEndeptransCudService.class);
		iEndeptransCudService.insert(new EnDepTransDO[] { enDepTransDO });
	}
	/**
	 * 插入en_ent_evt
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void insertEvt(UrgInOutTransMgrDTO data) throws BizException {
		EnEvtEP ep = new EnEvtEP();
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(data.getId_ent());
		evt.setId_erpre(data.getId_erpre());
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_ERTPCHG);
		evt.setShort_des("急诊流水转抢救");
		evt.setDes(String.format(
				"急诊流水转抢救<时间：%s ， 病区：%s ， 床号：%s ，医生：%s，护理级别：%s>",
				data.getDt_trans(), data.getName_dep_nur_new(),
				data.getName_bed_new(), data.getName_emp_phy_new(),
				data.getName_level_nur_new()));
		evt.setDt_evt(data.getDt_trans());
		evt.setDt_insert(EnAppUtils.getServerDateTime());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		evt.setVal_old(data.getId_dep_nur());
		evt.setVal_new(data.getId_dep_nur_new());
		ep.insertEvt(new EnEvtDTO[] { evt });
	}
}
