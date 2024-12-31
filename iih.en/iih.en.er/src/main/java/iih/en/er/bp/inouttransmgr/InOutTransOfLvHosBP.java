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
import iih.en.comm.util.EnErUtils;
import iih.en.er.dto.d.EuUrgInOutTransStatus;
import iih.en.er.dto.d.UrgInOutTransMgrDTO;
import iih.en.er.op.d.EnEntOpErDO;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.pv.out.d.EnEvtDTO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 出科
 * 
 * @author liubin
 *
 */
public class InOutTransOfLvHosBP extends InOutTransMgrBaseAbstract implements
		IInOutTransMgr {

	@Override
	protected void handle(UrgInOutTransMgrDTO data) throws BizException {
		if(data.getDt_end() == null)
			data.setDt_end(EnAppUtils.getServerDateTime());
		// 1.获取患者本次预检所有就诊记录
		List<String> list = EnErUtils.getEntIdsByPreId(data.getId_erpre());
		// 2.修改en_ent
		PatiVisitDO pv = updatePv(data);
		// 3.修改en_ent_op
		updateOp(data);
		// 4.修改en_ent_op_er
		EnEntOpErDO oper = updateOper(data);
		// 5.修改en_erpre
		updateErPre(data);
		// 6.释放床位 bd_bed
		releaseBed(data);
		// 7.结束en_ent_dep
		endDep(data, list);
		// 8.结束en_ent_emp
		endEmp(data, list);
		// 9.结束en_ent_bed
		endBed(data, list);
		// 10.插入en_ent_evt
		insertEvt(data);
	}

	/**
	 * 校验
	 */
	@Override
	protected void validate(UrgInOutTransMgrDTO data) throws BizException {
		super.validate(data);
		// 1.是否入科
		if (!EuUrgInOutTransStatus.INDEP.equals(data
				.getEu_urginouttransstatus()))
			throw new BizException("患者未入科！");
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
		pv.setDt_end(data.getDt_end());
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
		op.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
		op.setSd_gowhere(data.getSd_gowhere());
		op.setId_gowhere(data.getId_gowhere());
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
		oper.setSd_gowhere_er(data.getSd_gowhere());
		oper.setId_gowhere_er(data.getId_gowhere());
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
		erPre.setSd_status(IEnDictCodeConst.SD_STATUS_ERPRE_END);
		erPre.setDt_end(data.getDt_end());
		ep.save(new EnErPreDO[]{erPre});
	}

	/**
	 * 釋放床位
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void releaseBed(UrgInOutTransMgrDTO data) throws BizException {
		BedEP ep = new BedEP();
		ep.releaseBedRescue(data.getId_ent(), data.getId_bed(), FBoolean.TRUE);
	}

	/**
	 * 结束en_ent_dep
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void endDep(UrgInOutTransMgrDTO data, List<String> list)
			throws BizException {
		EntDeptEP ep = new EntDeptEP();
		// 结束原科室
		for (String entId : list) {
			ep.endDept(entId, null,
					data.getId_dep_nur_new(), FBoolean.TRUE,
					data.getDt_end());
		}
	}

	/**
	 * 结束en_ent_emp
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void endEmp(UrgInOutTransMgrDTO data, List<String> list)
			throws BizException {
		EntEmpEP ep = new EntEmpEP();
		ep.endOldEmp(list, null,
				data.getDt_end());
	}

	/**
	 * 结束en_ent_bed
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void endBed(UrgInOutTransMgrDTO data, List<String> list)
			throws BizException {
		EntBedEP ep = new EntBedEP();
		for (String entId : list) {
			ep.endUseBed(entId, data.getDt_end());
		}
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
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_TRANSDEP);
		evt.setShort_des("出科");
		evt.setDes(String.format(
				"急诊抢救出科<出科时间：%s ， 病区：%s ， 床号：%s ，医生：%s，护理级别：%s，去向：%s>",
				data.getDt_end(), data.getName_dep_nur_new(),
				data.getName_bed_new(), data.getName_emp_phy_new(),
				data.getName_level_nur_new(), data.getName_gowhere()));
		evt.setDt_evt(data.getDt_end());
		evt.setDt_insert(EnAppUtils.getServerDateTime());
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[] { evt });
	}
}
