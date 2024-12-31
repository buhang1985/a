package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.cg.service.i.IBLChargesService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.DischargeDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 获取退院
 * 
 * @author renying
 *
 */
public class GetDisChargeBP {
	public static final String NOT_HAS_VALUE = "无费用";
	public static final String HAS_VALUE = "有费用";

	/**
	 * 获取退院
	 * 
	 * @param patId 患者id
	 * @throws BizException 异常
	 * @return
	 */
	public DischargeDTO[] exec(String patId) throws BizException {
		StringBuilder builder = new StringBuilder();

		builder.append(" select en.id_ent,");
		builder.append("  en.code code_ent,");
		builder.append("  en.id_pat,");
		builder.append("  en.id_dep_phy,");
		builder.append("  en.id_dep_nur,");
		builder.append("  en.dt_acpt,");
		builder.append("  en.code_hpmedkind,");//诊疗类别
		
		builder.append("  hmk.id_hpmedkindah id_hpmedkind,");
		builder.append("  hmk.name name_hpmedkind,");
		builder.append("  acc.amt_prepay,");
		builder.append("  ip.name_bed,");
		builder.append("  ip.id_bed,");
		builder.append("  ip.fg_newborn,");
		builder.append("  ip.num_newborn,");
		builder.append("  en.id_emp_phy,");
		builder.append("  en.id_emp_nur,");
		builder.append("  en.dt_acpt,");
		builder.append("  en.fg_ip,");
		builder.append("  ip.sd_status,");
		builder.append("  en.fg_canc");
		builder.append("  from en_ent en");
		builder.append("  inner join en_ent_ip ip");
		builder.append("  on en.id_ent = ip.id_ent");
		builder.append("  left outer join en_ent_acc acc");
		builder.append("  on en.id_ent = acc.id_ent");
		builder.append("  left join bd_hp_med_kind_ah hmk");
		builder.append("  on en.code_hpmedkind = hmk.code ");
		builder.append("  where en.id_pat = ?");
		builder.append("  and en.fg_canc = 'N'");
		builder.append("  and (en.fg_ip = 'Y' or");
		builder.append("  (en.fg_ip = 'N' and ip.sd_status = ?))");

		SqlParam param = new SqlParam();
		param.addParam(patId);
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN);
		@SuppressWarnings("unchecked")
		List<DischargeDTO> dtoList = (List<DischargeDTO>) new DAFacade().execQuery(builder.toString(), param, new BeanListHandler(DischargeDTO.class));
		if (EnValidator.isEmpty(dtoList)) {
			return null;
		}
		for(DischargeDTO disDTO : dtoList){
			String error_bl = this.checkConsume(disDTO.getId_ent());
			String error_or = this.checkOR(disDTO.getId_ent());
			disDTO.setError_or(error_or);
			disDTO.setError_bl(error_bl);
			this.setDepValue(disDTO);
			this.setPsnValue(disDTO);
			this.getHPValue(disDTO);
		}
		return dtoList.toArray(new DischargeDTO[0]);
	}
	
	/**
	 * 查询患者医保数据
	 * 
	 * @param enhosDTO
	 * @return
	 * @throws BizException
	 */
	private DischargeDTO getHPValue(DischargeDTO disDTO) throws BizException {
		String entID = disDTO.getId_ent();
		IEnthpRService rservice = ServiceFinder.find(IEnthpRService.class);
		EntHpDO[] entHpDOArr = rservice.findByAttrValString(EntHpDO.ID_ENT, entID);

		for (EntHpDO hpDO : entHpDOArr) { // 查询就诊医保
			if (disDTO.getId_ent().equals(hpDO.getId_ent())) {
				if (hpDO.getFg_maj() == FBoolean.TRUE) {
					disDTO.setId_hp(hpDO.getId_hp());
//					enhosDTO.setPrim_name(hpDO.getName_hp());
//					enhosDTO.setId_enthp_prim(hpDO.getId_enthp());

//				} else {
//					enhosDTO.setAuxi_cplan(hpDO.getId_hp());
//					enhosDTO.setAuxi_name(hpDO.getName_hp());
//					enhosDTO.setId_enthp_auxi(hpDO.getId_enthp());
				}
			}
		}
		return disDTO;
	}

	/**
	 * 检查费用
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public String checkConsume(String entId) throws BizException {
		IBLChargesService blservice = ServiceFinder.find(IBLChargesService.class);
		FDouble amount = blservice.GetInpChargesByIdEnt(entId);
		if (amount.compareTo(FDouble.ZERO_DBL) > 0) {
			return HAS_VALUE;
		}
		return NOT_HAS_VALUE;
	}

	/**
	 * 检查医嘱
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public String checkOR(String entId) throws BizException {
		ICiOrdQryService ciservice = ServiceFinder.find(ICiOrdQryService.class);
		String errorMsg = ciservice.canDischarge(entId);
		return errorMsg;
	}

	/**
	 * 设置人员的值
	 * 
	 * @param disChargeDTO
	 * @param udidocs
	 * @throws BizException
	 */
	private void setPsnValue(DischargeDTO disChargeDTO) throws BizException {
		String[] str = new String[] { disChargeDTO.getId_emp_nur(), disChargeDTO.getId_emp_phy() };
		IPsndocMDORService rService = ServiceFinder.find(IPsndocMDORService.class);

		PsnDocDO[] enpsns = rService.findByIds(str, FBoolean.FALSE);
		if (EnValidator.isEmpty(enpsns))
			return;
		for (PsnDocDO psndoc : enpsns) {
			if (psndoc.getId_psndoc().equals(disChargeDTO.getId_emp_nur())) {
				disChargeDTO.setId_emp_nur(psndoc.getId_psndoc());
				disChargeDTO.setName_emp_nur(psndoc.getName());
			}
			if (psndoc.getId_psndoc().equals(disChargeDTO.getId_emp_phy())) {
				disChargeDTO.setId_emp_phy(psndoc.getId_psndoc());
				disChargeDTO.setName_emp_phy(psndoc.getName());
			}
		}
	}

	/**
	 * 设置部门的值
	 * 
	 * @param disChargeDTO
	 * @throws BizException
	 */
	private void setDepValue(DischargeDTO disChargeDTO) throws BizException {
		IDeptRService rService = ServiceFinder.find(IDeptRService.class);
		String[] str = new String[] { disChargeDTO.getId_dep_nur(), disChargeDTO.getId_dep_phy() };
		DeptDO[] depts = rService.findByIds(str, FBoolean.FALSE);
		if (EnValidator.isEmpty(depts))
			return;
		for (DeptDO deptdo : depts) {
			if (!EnValidator.isEmpty(disChargeDTO.getId_dep_nur()) && disChargeDTO.getId_dep_nur().equals(deptdo.getId_dep())) {
				disChargeDTO.setId_dep_nur(deptdo.getId_dep());
				disChargeDTO.setName_dep_nur(deptdo.getName());
			}
			if (!EnValidator.isEmpty(disChargeDTO.getId_dep_phy()) && disChargeDTO.getId_dep_phy().equals(deptdo.getId_dep())) {
				disChargeDTO.setId_dep_phy(deptdo.getId_dep());
				disChargeDTO.setName_dep_phy(deptdo.getName());
			}
		}
	}

}
