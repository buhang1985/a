package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;

/**
 * 总量参数 DTO数据 
 * 参数：就诊类型code_entp,服务类型sd_srvtp,出院带药标志fg_pres_outp<br/>
 * 	剂量quan_medu，频次主键id_freq,物品标志fg_mm,总量单位id_unit_base,使用天数use_day<br/>
 *  草药付数orders,代煎付数orders_boil,在院执行次数times_mp_in,物品主键id_mm<br/>
 *  医嘱项目来源方式eu_sourcemd
 * 	
 * 
 */
public class QuantumParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	public QuantumParamDTO(){}
	public QuantumParamDTO(CiEmsDTO ems,CiEmsSrvDTO srv){
		//如果是檢查檢驗治疗 则可能是多剂量 这时要取ems order上传来的的quan_medu by yzh 2017-12-02 21:31:37
		if (ems.getSd_srvtp() != null && (ems.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)
				|| ems.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)
				|| ems.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT))){
			this.setQuan_medu(srv.getQuan_med());
		}else{
			this.setQuan_medu(srv.getQuan_med());
		}
		this.setDt_effe(ems.getDt_begin());
		this.setCode_entp(ems.getCode_entp());
		this.setSd_srvtp(srv.getSd_srvtp());
		this.setFg_pres_outp(ems.getFg_pres_outp());
		this.setId_freq(ems.getId_freq());
		this.setFg_mm(srv.getFg_mm());
		this.setId_mm(srv.getId_mm());
		this.setId_unit_sale(srv.getId_unit_sale());
		this.setUse_day(ems.getDays_or());
		this.setOrders(ems.getOrders());
		this.setOrders_boil(ems.getOrders_boil());
		this.setTimes_mp_in(ems.getTimes_mp_in());
	}
	/**
	 * 多次多量功能放开后需要在保存前重新处理ordsrv的总量
	 * @author yzh
	 * @param ems
	 * @param srv
	 */
	public QuantumParamDTO(CiEmsDTO ems,OrdSrvDO srv,boolean fg_set){
		//如果是檢查檢驗治疗 则可能是多剂量 这时要取ems order上传来的的quan_medu by yzh 2017-12-02 21:31:37
//		if (ems.getSd_srvtp() != null && (ems.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)
//				|| ems.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)
//				|| ems.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT))){
//			if(fg_set){
//				this.setQuan_medu(srv.getQuan_medu());
//			}else{
//				this.setQuan_medu(srv.getQuan_medu());
//			}
//		}else{
			this.setQuan_medu(srv.getQuan_medu());
//		}
		this.setDt_effe(ems.getDt_begin());
		this.setCode_entp(ems.getCode_entp());
		this.setSd_srvtp(srv.getSd_srvtp());
		this.setFg_pres_outp(ems.getFg_pres_outp());
		this.setId_freq(ems.getId_freq());
		this.setFg_mm(srv.getFg_mm());
		this.setId_mm(srv.getId_mm());
//		this.setId_unit_sale();
		this.setUse_day(ems.getDays_or());
		this.setOrders(ems.getOrders());
		this.setOrders_boil(ems.getOrders_boil());
		this.setTimes_mp_in(ems.getTimes_mp_in());
	}
	public QuantumParamDTO(CiOrderDO ordo, OrdSrvDO srv) {
		this.setDt_effe(ordo.getDt_effe());
		this.setQuan_medu(srv.getQuan_medu());
//		}
		this.setCode_entp(ordo.getCode_entp());
		this.setSd_srvtp(srv.getSd_srvtp());
		this.setFg_pres_outp(ordo.getFg_pres_outp());
		this.setId_freq(ordo.getId_freq());
		this.setFg_mm(srv.getFg_mm());
		this.setId_mm(srv.getId_mm());
//		this.setId_unit_sale();
		this.setUse_day(ordo.getDays_or());
		this.setOrders(ordo.getOrders());
		this.setOrders_boil(ordo.getOrders_boil());
		this.setTimes_mp_in(ordo.getTimes_mp_in());
	}
	
	/**
	 * 多次多量功能放开后需要在保存前重新处理ordsrv的总量
	 * @author yzh
	 * @param ems
	 * @param srv
	 */
	public QuantumParamDTO(CiOrderDO order,OrdSrvDO srv,boolean fg_set){
		this.setDt_effe(order.getDt_effe());
		this.setQuan_medu(srv.getQuan_medu());
	    //总量开单方式 by yzh 2018年1月25日 14:20:47
		this.setSd_totalopenmode(order.getSd_totalopenmode());
		//多剂量多频次标识
		this.setIsmulexec(order.getIsmulexec());
		this.setIsmuldose(order.getIsmuldose());
		this.setCode_entp(order.getCode_entp());
		this.setSd_srvtp(srv.getSd_srvtp());
		this.setFg_pres_outp(order.getFg_pres_outp());
		this.setId_freq(order.getId_freq());
		this.setFg_mm(srv.getFg_mm());
		this.setId_mm(srv.getId_mm());
		this.setUse_day(order.getDays_or());
		this.setOrders(order.getOrders());
		this.setOrders_boil(order.getOrders_boil());
		this.setTimes_mp_in(order.getTimes_mp_in());
		this.setTimes_cur(order.getTimes_cur());
	}
	
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 出院带药标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}
	/**
	 * 出院带药标志
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	/**
	 * 医学计量
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}
	/**
	 * 医学计量
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 频次id
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次id
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 物品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	/**
	 * 物品标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 总量单位
	 * @return String
	 */
	public String getId_unit_sale() {
		return ((String) getAttrVal("Id_unit_sale"));
	}
	/**
	 * 总量单位
	 * @param Id_unit_sale
	 */
	public void setId_unit_sale(String Id_unit_sale) {
		setAttrVal("Id_unit_sale", Id_unit_sale);
	}
	/**
	 * 使用天数
	 * @return Integer
	 */
	public Integer getUse_day() {
		return ((Integer) getAttrVal("Use_day"));
	}
	/**
	 * 使用天数
	 * @param Use_day
	 */
	public void setUse_day(Integer Use_day) {
		setAttrVal("Use_day", Use_day);
	}
	/**
	 * 草药付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}
	/**
	 * 草药付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 代煎付数
	 * @return Integer
	 */
	public Integer getOrders_boil() {
		return ((Integer) getAttrVal("Orders_boil"));
	}
	/**
	 * 代煎付数
	 * @param Orders_boil
	 */
	public void setOrders_boil(Integer Orders_boil) {
		setAttrVal("Orders_boil", Orders_boil);
	}
	/**
	 * 在院执行次数
	 * @return Integer
	 */
	public Integer getTimes_mp_in() {
		return ((Integer) getAttrVal("Times_mp_in"));
	}
	/**
	 * 在院执行次数
	 * @param Times_mp_in
	 */
	public void setTimes_mp_in(Integer Times_mp_in) {
		setAttrVal("Times_mp_in", Times_mp_in);
	}
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	
	/**
	 * 总量开单方式
	 * @return
	 */
	public String getSd_totalopenmode() {
		return ((String) getAttrVal("Sd_totalopenmode"));
	}	
	/**
	 * 总量开单方式
	 * @param Sd_totalopenmode
	 */
	public void setSd_totalopenmode(String Sd_totalopenmode) {
		setAttrVal("Sd_totalopenmode", Sd_totalopenmode);
	}
	/**
	 * 总次数
	 * @return Integer
	 */
	public Integer getTimes_cur() {
		return ((Integer) getAttrVal("Times_cur"));
	}	
	/**
	 * 总次数
	 * @param Times_cur
	 */
	public void setTimes_cur(Integer Times_cur) {
		setAttrVal("Times_cur", Times_cur);
	}
	/**
	 * 是否多次执行
	 * 
	 * @return FBoolean
	 */
	public FBoolean getIsmulexec() {
		return ((FBoolean) getAttrVal("Ismulexec"));
	}

	/**
	 * 是否多次执行
	 * 
	 * @param Ismulexec
	 */
	public void setIsmulexec(FBoolean Ismulexec) {
		setAttrVal("Ismulexec", Ismulexec);
	}

	/**
	 * 是否多量开单
	 * 
	 * @return FBoolean
	 */
	public FBoolean getIsmuldose() {
		return ((FBoolean) getAttrVal("Ismuldose"));
	}

	/**
	 * 是否多量开单
	 * 
	 * @param Ismuldose
	 */
	public void setIsmuldose(FBoolean Ismuldose) {
		setAttrVal("Ismuldose", Ismuldose);
	}
	/**
	 * 医嘱生效日期
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	/**
	 * 医嘱生效日期
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
}