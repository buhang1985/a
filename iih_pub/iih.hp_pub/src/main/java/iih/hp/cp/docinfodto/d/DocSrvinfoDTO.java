package iih.hp.cp.docinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱医疗服务 DTO数据 
 * 
 */
public class DocSrvinfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊疗计划元素ID
	 * @return String
	 */
	public String getId_ele() {
		return ((String) getAttrVal("Id_ele"));
	}
	/**
	 * 诊疗计划元素ID
	 * @param Id_ele
	 */
	public void setId_ele(String Id_ele) {
		setAttrVal("Id_ele", Id_ele);
	}
	/**
	 * 医疗服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 医疗物品ID
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 医疗物品ID
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 医疗服务类型(IIH字典)
	 * @return String
	 */
	public String getOr_srv_tp_iih() {
		return ((String) getAttrVal("Or_srv_tp_iih"));
	}
	/**
	 * 医疗服务类型(IIH字典)
	 * @param Or_srv_tp_iih
	 */
	public void setOr_srv_tp_iih(String Or_srv_tp_iih) {
		setAttrVal("Or_srv_tp_iih", Or_srv_tp_iih);
	}
	/**
	 * 医疗服务类型(外部对照)
	 * @return String
	 */
	public String getOr_srv_tp_tgt() {
		return ((String) getAttrVal("Or_srv_tp_tgt"));
	}
	/**
	 * 医疗服务类型(外部对照)
	 * @param Or_srv_tp_tgt
	 */
	public void setOr_srv_tp_tgt(String Or_srv_tp_tgt) {
		setAttrVal("Or_srv_tp_tgt", Or_srv_tp_tgt);
	}
	/**
	 * 医疗服务类型编码(IIH字典)
	 * @return String
	 */
	public String getOr_sd_srv_tp_iih() {
		return ((String) getAttrVal("Or_sd_srv_tp_iih"));
	}
	/**
	 * 医疗服务类型编码(IIH字典)
	 * @param Or_sd_srv_tp_iih
	 */
	public void setOr_sd_srv_tp_iih(String Or_sd_srv_tp_iih) {
		setAttrVal("Or_sd_srv_tp_iih", Or_sd_srv_tp_iih);
	}
	/**
	 * 医疗服务类型编码(外部对照)
	 * @return String
	 */
	public String getOr_sd_srv_tp_tgt() {
		return ((String) getAttrVal("Or_sd_srv_tp_tgt"));
	}
	/**
	 * 医疗服务类型编码(外部对照)
	 * @param Or_sd_srv_tp_tgt
	 */
	public void setOr_sd_srv_tp_tgt(String Or_sd_srv_tp_tgt) {
		setAttrVal("Or_sd_srv_tp_tgt", Or_sd_srv_tp_tgt);
	}
	/**
	 * 医疗服务名称(IIH字典)
	 * @return String
	 */
	public String getSrv_name_iih() {
		return ((String) getAttrVal("Srv_name_iih"));
	}
	/**
	 * 医疗服务名称(IIH字典)
	 * @param Srv_name_iih
	 */
	public void setSrv_name_iih(String Srv_name_iih) {
		setAttrVal("Srv_name_iih", Srv_name_iih);
	}
	/**
	 * 医疗服务名称(外部对照)
	 * @return String
	 */
	public String getSrv_name_tgt() {
		return ((String) getAttrVal("Srv_name_tgt"));
	}
	/**
	 * 医疗服务名称(外部对照)
	 * @param Srv_name_tgt
	 */
	public void setSrv_name_tgt(String Srv_name_tgt) {
		setAttrVal("Srv_name_tgt", Srv_name_tgt);
	}
	/**
	 * 医疗服务编码(IIH字典)
	 * @return String
	 */
	public String getSrv_code_iih() {
		return ((String) getAttrVal("Srv_code_iih"));
	}
	/**
	 * 医疗服务编码(IIH字典)
	 * @param Srv_code_iih
	 */
	public void setSrv_code_iih(String Srv_code_iih) {
		setAttrVal("Srv_code_iih", Srv_code_iih);
	}
	/**
	 * 医疗服务编码(外部对照)
	 * @return String
	 */
	public String getSrv_code_tgt() {
		return ((String) getAttrVal("Srv_code_tgt"));
	}
	/**
	 * 医疗服务编码(外部对照)
	 * @param Srv_code_tgt
	 */
	public void setSrv_code_tgt(String Srv_code_tgt) {
		setAttrVal("Srv_code_tgt", Srv_code_tgt);
	}
	/**
	 * 单次剂量
	 * @return FDouble
	 */
	public FDouble getDosage() {
		return ((FDouble) getAttrVal("Dosage"));
	}
	/**
	 * 单次剂量
	 * @param Dosage
	 */
	public void setDosage(FDouble Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	/**
	 * 剂量单位(IIH字典)
	 * @return String
	 */
	public String getDosage_units_iih() {
		return ((String) getAttrVal("Dosage_units_iih"));
	}
	/**
	 * 剂量单位(IIH字典)
	 * @param Dosage_units_iih
	 */
	public void setDosage_units_iih(String Dosage_units_iih) {
		setAttrVal("Dosage_units_iih", Dosage_units_iih);
	}
	/**
	 * 剂量单位(外部对照)
	 * @return String
	 */
	public String getDosage_units_tgt() {
		return ((String) getAttrVal("Dosage_units_tgt"));
	}
	/**
	 * 剂量单位(外部对照)
	 * @param Dosage_units_tgt
	 */
	public void setDosage_units_tgt(String Dosage_units_tgt) {
		setAttrVal("Dosage_units_tgt", Dosage_units_tgt);
	}
	/**
	 * 医疗服务明细
	 * @return FArrayList
	 */
	public FArrayList getRefeleitems() {
		return ((FArrayList) getAttrVal("Refeleitems"));
	}
	/**
	 * 医疗服务明细
	 * @param Refeleitems
	 */
	public void setRefeleitems(FArrayList Refeleitems) {
		setAttrVal("Refeleitems", Refeleitems);
	}
	/**
	 * 诊疗计划应用ID
	 * @return FArrayList
	 */
	public FArrayList getId_cpapp() {
		return ((FArrayList) getAttrVal("Id_cpapp"));
	}
	/**
	 * 诊疗计划应用ID
	 * @param Id_cpapp
	 */
	public void setId_cpapp(FArrayList Id_cpapp) {
		setAttrVal("Id_cpapp", Id_cpapp);
	}
	/**
	 * 径内医嘱区分
	 * @return Integer
	 */
	public Integer getEu_uncporjudge() {
		return ((Integer) getAttrVal("Eu_uncporjudge"));
	}
	/**
	 * 径内医嘱区分
	 * @param Eu_uncporjudge
	 */
	public void setEu_uncporjudge(Integer Eu_uncporjudge) {
		setAttrVal("Eu_uncporjudge", Eu_uncporjudge);
	}
	/**
	 * 径外医嘱使用原因
	 * @return String
	 */
	public String getReason_uncporuse() {
		return ((String) getAttrVal("Reason_uncporuse"));
	}
	/**
	 * 径外医嘱使用原因
	 * @param Reason_uncporuse
	 */
	public void setReason_uncporuse(String Reason_uncporuse) {
		setAttrVal("Reason_uncporuse", Reason_uncporuse);
	}
	/**
	 * 用法ID
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法ID
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 在院整领
	 * @return FBoolean
	 */
	public FBoolean getFg_wholepack() {
		return ((FBoolean) getAttrVal("Fg_wholepack"));
	}
	/**
	 * 在院整领
	 * @param Fg_wholepack
	 */
	public void setFg_wholepack(FBoolean Fg_wholepack) {
		setAttrVal("Fg_wholepack", Fg_wholepack);
	}
	/**
	 * 出院带药
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}
	/**
	 * 出院带药
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	/**
	 * 总量_当前包装
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}
	/**
	 * 总量_当前包装
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	/**
	 * 总量单位ID_当前包装
	 * @return String
	 */
	public String getId_unit_cur() {
		return ((String) getAttrVal("Id_unit_cur"));
	}
	/**
	 * 总量单位ID_当前包装
	 * @param Id_unit_cur
	 */
	public void setId_unit_cur(String Id_unit_cur) {
		setAttrVal("Id_unit_cur", Id_unit_cur);
	}
	/**
	 * 领药方式ID
	 * @return String
	 */
	public String getId_drug_delivery_method() {
		return ((String) getAttrVal("Id_drug_delivery_method"));
	}
	/**
	 * 领药方式ID
	 * @param Id_drug_delivery_method
	 */
	public void setId_drug_delivery_method(String Id_drug_delivery_method) {
		setAttrVal("Id_drug_delivery_method", Id_drug_delivery_method);
	}
	/**
	 * 领药方式SD
	 * @return String
	 */
	public String getSd_drug_delivery_method() {
		return ((String) getAttrVal("Sd_drug_delivery_method"));
	}
	/**
	 * 领药方式SD
	 * @param Sd_drug_delivery_method
	 */
	public void setSd_drug_delivery_method(String Sd_drug_delivery_method) {
		setAttrVal("Sd_drug_delivery_method", Sd_drug_delivery_method);
	}
	
	/**
	 * 领药方式名称
	 * @return String
	 */
	public String getName_drug_delivery_method() {
		return ((String) getAttrVal("Name_drug_delivery_method"));
	}
	/**
	 * 领药方式名称
	 * @param Name_drug_delivery_method
	 */
	public void setName_drug_delivery_method(String Name_drug_delivery_method) {
		setAttrVal("Name_drug_delivery_method", Name_drug_delivery_method);
	}
	
	
	
	
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 *  
	 * @param Dt_end
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	

	 public String getId_nodispense() {
			return ((String) getAttrVal("Id_nodispense"));
		}	
		public void setId_nodispense(String Id_nodispense) {
			setAttrVal("Id_nodispense", Id_nodispense);
		}
		public String getSd_nodispense() {
			return ((String) getAttrVal("Sd_nodispense"));
		}	
		public void setSd_nodispense(String Sd_nodispense) {
			setAttrVal("Sd_nodispense", Sd_nodispense);
		}
		public String getId_dep_mp() {
			return ((String) getAttrVal("Id_dep_mp"));
		}	
		public void setId_dep_mp(String Id_dep_mp) {
			setAttrVal("Id_dep_mp", Id_dep_mp);
		}
		public String getId_dep_wh() {
			return ((String) getAttrVal("Id_dep_wh"));
		}	
		public void setId_dep_wh(String Id_dep_wh) {
			setAttrVal("Id_dep_wh", Id_dep_wh);
		}
		public String getSpec() {
			return ((String) getAttrVal("Spec"));
		}	
		public void setSpec(String Spec) {
			setAttrVal("Spec", Spec);
		}
		public String getDes_or() {
			return ((String) getAttrVal("Des_or"));
		}	
		public void setDes_or(String Des_or) {
			setAttrVal("Des_or", Des_or);
		}
		public FBoolean getFg_active() {
			return ((FBoolean) getAttrVal("Fg_active"));
		}	
		public void setFg_active(FBoolean Fg_active) {
			setAttrVal("Fg_active", Fg_active);
		}
		
		public String getName_nodispense() {
			return ((String) getAttrVal("Name_nodispense"));
		}	
		public void setName_nodispense(String Name_nodispense) {
			setAttrVal("Name_nodispense", Name_nodispense);
		}
		public String getName_dep_mp() {
			return ((String) getAttrVal("Name_dep_mp"));
		}	
		public void setName_dep_mp(String Name_dep_mp) {
			setAttrVal("Name_dep_mp", Name_dep_mp);
		}
		public String getName_dep_wh() {
			return ((String) getAttrVal("Name_dep_wh"));
		}	
		public void setName_dep_wh(String Name_dep_wh) {
			setAttrVal("Name_dep_wh", Name_dep_wh);
		}
	
		/**
		 * 医嘱排序号
		 * @return Integer
		 */
		public Integer getSortno() {
			return ((Integer) getAttrVal("Sortno"));
		}
		/**
		 * 医嘱排序号
		 * @param Sortno
		 */
		public void setSortno(Integer Sortno) {
			setAttrVal("Sortno", Sortno);
		}
		
		/**
		 * 是否皮试
		 * @return FBoolean
		 */
		public FBoolean getFg_skin() {
			return ((FBoolean) getAttrVal("Fg_skin"));
		}
		/**
		 * 是否皮试
		 * @param Fg_skin
		 */
		public void setFg_skin(FBoolean Fg_skin) {
			setAttrVal("Fg_skin", Fg_skin);
		}
		/**
		 * 医嘱天数
		 * @return Integer
		 */
		public Integer getDays_or() {
			return ((Integer) getAttrVal("Days_or"));
		}	
		/**
		 * 医嘱天数
		 * @param Days_or
		 */
		public void setDays_or(Integer Days_or) {
			setAttrVal("Days_or", Days_or);
		}
	
}