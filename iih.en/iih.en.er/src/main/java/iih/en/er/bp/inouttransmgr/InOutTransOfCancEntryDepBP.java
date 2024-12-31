package iih.en.er.bp.inouttransmgr;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EnEvtEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.EntDeptEP;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.EntOpErEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnErUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EuUrgInOutTransStatus;
import iih.en.er.dto.d.UrgInOutTransMgrDTO;
import iih.en.er.op.d.EnEntOpErDO;
import iih.en.pv.deptrans.d.EnDepTransDO;
import iih.en.pv.deptrans.i.IEndeptransCudService;
import iih.en.pv.deptrans.i.IEndeptransRService;
import iih.en.pv.out.d.EnEvtDTO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消入科
 * 
 * @author liubin
 *
 */
public class InOutTransOfCancEntryDepBP extends InOutTransMgrBaseAbstract
		implements IInOutTransMgr {

	@Override
	protected void handle(UrgInOutTransMgrDTO data) throws BizException {
		// 1.释放床位 bd_bed
		releaseBed(data);
		// 2.修改en_ent
		PatiVisitDO pv = updatePv(data);
		// 3.修改en_ent_op
		updateOp(data);
		// 4.修改en_ent_op_er
		EnEntOpErDO oper = updateOper(data);
		// 5.删除en_ent_dep
		delDep(data);
		// 6.删除en_ent_emp
		delEmp(data);
		// 7.删除en_ent_bed
		delBed(data);
		// 8.删除en_dep_trans
		delDepTrans(data);
		// 9.插入en_ent_evt
		insertEvt(data);
	}
	/**
	 * 校验
	 */
	@Override
	protected void validate(UrgInOutTransMgrDTO data) throws BizException {
		super.validate(data);
		//1.是否入科
		if (!EuUrgInOutTransStatus.INDEP
				.equals(data.getEu_urginouttransstatus()))
			throw new BizException("患者未入科，不能取消入科！");
		//2.校验医嘱
		ICiOrdQryService ciservice = ServiceFinder.find(ICiOrdQryService.class);
		String errorMsg = ciservice.canDischarge(data.getId_ent());
		if(!EnValidator.isEmpty(errorMsg)){
			throw new BizException("该患者存在有效医嘱,不能取消入科!");
		}
		//3.挂号记录校验
		if(hasMoreRegist(data)){
			throw new BizException("该患者本次预检有多条有效挂号记录，请退号后再取消入科");
		}
		
	}
	/**
	 * 本次预检是否存在多次挂号记录
	 * 
	 * @param data
	 * @return
	 * @throws BizException
	 */
	private boolean hasMoreRegist(UrgInOutTransMgrDTO data) throws BizException {
		List<String> list = EnErUtils.getEntIdsByPreId(data.getId_ent());
		return EnValidator.isEmpty(list) && list.size() > 1;
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
		pv.setId_dep_nur(null);
		pv.setDt_acpt(null);
		pv.setFg_acptvalid(FBoolean.FALSE);
		pv.setId_emp_phy(null);
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
		op.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);
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
		oper.setId_bed(null);
		oper.setId_level_nur(null);
		oper.setSd_level_nur(null);
		return ep.save(new EnEntOpErDO[] { oper })[0];
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
	 * 删除en_ent_dep
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void delDep(UrgInOutTransMgrDTO data) throws BizException {
		EntDeptEP ep = new EntDeptEP();
		ep.deleteEntDepByEntIds(new String[]{data.getId_ent()});
	}

	/**
	 * 删除en_ent_emp
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void delEmp(UrgInOutTransMgrDTO data) throws BizException {
		if (EnValidator.isEmpty(data.getId_emp_phy_new()))
			return;
		EntEmpEP ep = new EntEmpEP();
		ep.deleteEnEmpByEntId(data.getId_ent());
	}

	/**
	 * 删除en_ent_bed
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void delBed(UrgInOutTransMgrDTO data) throws BizException {
		EntBedEP ep = new EntBedEP();
		ep.deleteEnBedByEntIds(new String[] {data.getId_ent()});
	}
	/**
	 * 删除en_dep_trans
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void delDepTrans(UrgInOutTransMgrDTO data) throws BizException {
		IEndeptransRService iEndeptransRService = ServiceFinder.find(IEndeptransRService.class);
		EnDepTransDO[]  enDepTransDOs = iEndeptransRService.findByAttrValString(EnDepTransDO.ID_ENT, data.getId_ent());
		if(EnValidator.isEmpty(enDepTransDOs))
			return;
		IEndeptransCudService iEndeptransCudService = ServiceFinder.find(IEndeptransCudService.class);
		iEndeptransCudService.delete(enDepTransDOs);
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
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_CHANELENTRY);
		evt.setShort_des("取消入科");
		evt.setDes(String.format(
				"急诊取消入科<取消入科时间：%s ， 病区：%s ， 床号：%s ，医生：%s，护理级别：%s>",
				now, data.getName_dep_nur_new(),
				data.getName_bed_new(), data.getName_emp_phy_new(),
				data.getName_level_nur_new()));
		evt.setDt_evt(now);
		evt.setDt_insert(now);
		evt.setId_emp_rec(EnContextUtils.getPsnId());
		ep.insertEvt(new EnEvtDTO[] { evt });
	}
}
