package iih.en.er.bp.inouttransmgr;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EnEvtEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.EntDeptEP;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.EntOpErEP;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EuUrgInOutTransStatus;
import iih.en.er.dto.d.UrgInOutTransMgrDTO;
import iih.en.er.op.d.EnEntOpErDO;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.pv.out.d.EnEvtDTO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;

/**
 * 出科召回
 * 
 * @author liubin
 *
 */
public class InOutTransOfReCallBP extends InOutTransMgrBaseAbstract implements
		IInOutTransMgr {

	@Override
	protected void handle(UrgInOutTransMgrDTO data) throws BizException {
		// 1.修改en_ent
		PatiVisitDO pv = updatePv(data);
		// 2.修改en_ent_op
		updateOp(data);
		// 3.修改en_ent_op_er
		EnEntOpErDO oper = updateOper(data);
		// 4.修改en_erpre
		updateErPre(data);
		// 5.使用床位 bd_bed
		useBed(data);
		// 6.插入en_ent_dep
		insertDep(data);
		// 7.插入en_ent_emp
		insertEmp(data);
		// 8.插入en_ent_bed
		insertBed(data);
		// 9.插入en_ent_evt
		insertEvt(data);
	}

	/**
	 * 校验
	 */
	@Override
	protected void validate(UrgInOutTransMgrDTO data) throws BizException {
		super.validate(data);
		// 1.是否入科
		if (!EuUrgInOutTransStatus.OUTDEP.equals(data
				.getEu_urginouttransstatus()))
			throw new BizException("患者未出科，不允许出科召回！");
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
		pv.setId_dep_nur(data.getId_dep_nur_new());
		pv.setId_emp_phy(data.getId_emp_phy_new());
		pv.setDt_end(null);
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
		op.setStatus(DOStatus.UPDATED);
		op.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
		op.setSd_gowhere(null);
		op.setId_gowhere(null);
		ep.save(op);
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
		oper.setSd_gowhere_er(null);
		oper.setId_gowhere_er(null);
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
		erPre.setSd_status(IEnDictCodeConst.SD_STATUS_ERPRE_VISIT);
		erPre.setDt_end(null);
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
		ep.useBed2(data.getId_bed_new());
	}

	/**
	 * 插入en_ent_dep
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void insertDep(UrgInOutTransMgrDTO data) throws BizException {
		EntDeptEP ep = new EntDeptEP();
		ep.insertEntDep(data.getId_dep_phy(), data.getId_ent(),
				IEnDictCodeConst.SD_ENTDEPROLE_DEP,
				IEnDictCodeConst.ID_ENTDEPROLE_DEP, data.getDt_end());
		ep.insertEntDep(data.getId_dep_nur_new(), data.getId_ent(),
				IEnDictCodeConst.SD_ENTDEPROLE_IA,
				IEnDictCodeConst.ID_ENTDEPROLE_IA, data.getDt_end());
	}

	/**
	 * 插入en_ent_emp
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void insertEmp(UrgInOutTransMgrDTO data) throws BizException {
		if (EnValidator.isEmpty(data.getId_emp_phy_new()))
			return;
		EntEmpEP ep = new EntEmpEP();
		ep.addEmp(data.getId_ent(), data.getId_emp_phy_new(),
				IEnDictCodeConst.ID_EMPROLE_DOCTOR,
				IEnDictCodeConst.SD_EMPROLE_DOCTOR, data.getDt_end());
	}

	/**
	 * 插入en_ent_bed
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void insertBed(UrgInOutTransMgrDTO data) throws BizException {
		EntBedEP ep = new EntBedEP();
		ep.useBed(data.getId_ent(), data.getId_bed_new(),
				data.getName_bed_new(), data.getId_dep_nur_new(),
				data.getDt_end());
	}

	/**
	 * 插入en_ent_evt
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void insertEvt(UrgInOutTransMgrDTO data) throws BizException {
		FDateTime now = EnAppUtils.getServerDateTime();
		EnEvtEP ep = new EnEvtEP();
		EnEvtDTO evt = new EnEvtDTO();
		evt.setId_ent(data.getId_ent());
		evt.setId_erpre(data.getId_erpre());
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_ENTERDEP);
		evt.setShort_des("出科召回");
		evt.setDes(String.format(
				"急诊抢救出科召回<出科召回时间：%s ， 病区：%s ， 床号：%s ，医生：%s，护理级别：%s>",
				now, data.getName_dep_nur_new(),
				data.getName_bed_new(), data.getName_emp_phy_new(),
				data.getName_level_nur_new()));
		evt.setDt_evt(now);
		evt.setDt_insert(now);
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[] { evt });
	}
}
