package iih.en.er.bp.inouttransmgr;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EnEvtEP;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.EntDeptEP;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.EntOpErEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnErUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EuUrgInOutTransStatus;
import iih.en.er.dto.d.UrgInOutTransMgrDTO;
import iih.en.er.op.d.EnEntOpErDO;
import iih.en.pv.deptrans.d.EnDepTransDO;
import iih.en.pv.deptrans.d.EnEuTrans;
import iih.en.pv.deptrans.i.IEndeptransCudService;
import iih.en.pv.out.d.EnEvtDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 转科
 * 
 * @author liubin
 *
 */
public class InOutTransOfTransDepBP extends InOutTransMgrBaseAbstract implements
		IInOutTransMgr {

	@Override
	protected void handle(UrgInOutTransMgrDTO data) throws BizException {
		// 1.获取患者本次预检所有就诊记录
		List<String> list = EnErUtils.getEntIdsByPreId(data.getId_erpre());
		// 2.使用床位 bd_bed
		useBed(data);
		// 3.修改en_ent
		PatiVisitDO pv = updatePv(data);
		// 4.修改en_ent_op_er
		EnEntOpErDO oper = updateOper(data);
		// 5.插入en_ent_dep
		insertDep(data, list);
		// 6.插入en_ent_emp
		insertEmp(data, list);
		// 7.插入en_ent_bed
		insertBed(data, list);
		// 8.插入en_dep_trans
		insertDepTrans(data);
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
		pv.setId_dep_nur(data.getId_dep_nur_new());
		pv.setId_emp_phy(data.getId_emp_phy_new());
		return pvEP.savePv(pv);
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
		return ep.save(new EnEntOpErDO[] { oper })[0];
	}

	/**
	 * 使用床位
	 * 
	 * @param data
	 * @throws BizException
	 */
	private void useBed(UrgInOutTransMgrDTO data) throws BizException {
		BedEP ep = new BedEP();
		//1.释放原床
		ep.releaseBedRescue(data.getId_ent(), data.getId_bed(), FBoolean.TRUE);
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
			ep.endDept(entId, IEnDictCodeConst.SD_ENTDEPROLE_IA, data.getId_dep_nur_new(), FBoolean.FALSE, data.getDt_trans());
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
		evt.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_TRANSDEP);
		evt.setShort_des("转科");
		evt.setDes(String.format(
				"急诊抢救转科<转科时间：%s ， 病区：%s ， 床号：%s ，医生：%s，护理级别：%s>",
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
