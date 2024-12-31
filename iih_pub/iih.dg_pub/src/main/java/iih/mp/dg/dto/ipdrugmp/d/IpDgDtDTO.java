package iih.mp.dg.dto.ipdrugmp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院药品明细（画面用） DTO数据 
 * 
 */
public class IpDgDtDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院药品请领发放明细
	 * @return String
	 */
	public String getId_dgipdt() {
		return ((String) getAttrVal("Id_dgipdt"));
	}
	/**
	 * 住院药品请领发放明细
	 * @param Id_dgipdt
	 */
	public void setId_dgipdt(String Id_dgipdt) {
		setAttrVal("Id_dgipdt", Id_dgipdt);
	}
	/**
	 * 住院药品请领主键
	 * @return String
	 */
	public String getId_dgipap() {
		return ((String) getAttrVal("Id_dgipap"));
	}
	/**
	 * 住院药品请领主键
	 * @param Id_dgipap
	 */
	public void setId_dgipap(String Id_dgipap) {
		setAttrVal("Id_dgipap", Id_dgipap);
	}
	/**
	 * 住院药品发放主键
	 * @return String
	 */
	public String getId_dgipde() {
		return ((String) getAttrVal("Id_dgipde"));
	}
	/**
	 * 住院药品发放主键
	 * @param Id_dgipde
	 */
	public void setId_dgipde(String Id_dgipde) {
		setAttrVal("Id_dgipde", Id_dgipde);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getRownum() {
		return ((String) getAttrVal("Rownum"));
	}
	/**
	 * 序号
	 * @param Rownum
	 */
	public void setRownum(String Rownum) {
		setAttrVal("Rownum", Rownum);
	}
	/**
	 * 请领单号
	 * @return String
	 */
	public String getCode_dgipap() {
		return ((String) getAttrVal("Code_dgipap"));
	}
	/**
	 * 请领单号
	 * @param Code_dgipap
	 */
	public void setCode_dgipap(String Code_dgipap) {
		setAttrVal("Code_dgipap", Code_dgipap);
	}
	/**
	 * 请领状态编码
	 * @return Integer
	 */
	public Integer getSd_dgap() {
		return ((Integer) getAttrVal("Sd_dgap"));
	}
	/**
	 * 请领状态编码
	 * @param Sd_dgap
	 */
	public void setSd_dgap(Integer Sd_dgap) {
		setAttrVal("Sd_dgap", Sd_dgap);
	}
	/**
	 * 请领类型编码
	 * @return String
	 */
	public String getSd_dgtp() {
		return ((String) getAttrVal("Sd_dgtp"));
	}
	/**
	 * 请领类型编码
	 * @param Sd_dgtp
	 */
	public void setSd_dgtp(String Sd_dgtp) {
		setAttrVal("Sd_dgtp", Sd_dgtp);
	}
	/**
	 * 药单类型
	 * @return Integer
	 */
	public Integer getEu_shetp() {
		return ((Integer) getAttrVal("Eu_shetp"));
	}
	/**
	 * 药单类型
	 * @param Eu_shetp
	 */
	public void setEu_shetp(Integer Eu_shetp) {
		setAttrVal("Eu_shetp", Eu_shetp);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 住院档案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院档案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getSex_pat() {
		return ((String) getAttrVal("Sex_pat"));
	}
	/**
	 * 患者性别
	 * @param Sex_pat
	 */
	public void setSex_pat(String Sex_pat) {
		setAttrVal("Sex_pat", Sex_pat);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 费别
	 * @return String
	 */
	public String getName_patica() {
		return ((String) getAttrVal("Name_patica"));
	}
	/**
	 * 费别
	 * @param Name_patica
	 */
	public void setName_patica(String Name_patica) {
		setAttrVal("Name_patica", Name_patica);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public String getName_didef_dis() {
		return ((String) getAttrVal("Name_didef_dis"));
	}
	/**
	 * 诊断
	 * @param Name_didef_dis
	 */
	public void setName_didef_dis(String Name_didef_dis) {
		setAttrVal("Name_didef_dis", Name_didef_dis);
	}
	/**
	 * 婴儿标志
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}
	/**
	 * 婴儿标志
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 婴儿序号
	 * @return Integer
	 */
	public Integer getNo_bb() {
		return ((Integer) getAttrVal("No_bb"));
	}
	/**
	 * 婴儿序号
	 * @param No_bb
	 */
	public void setNo_bb(Integer No_bb) {
		setAttrVal("No_bb", No_bb);
	}
	/**
	 * 在院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}
	/**
	 * 在院标志
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 医嘱主键
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱主键
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 医嘱主键服务主键
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱主键服务主键
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 商品名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 商品名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 医嘱服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 医嘱服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医嘱服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 医嘱服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 医疗服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 医疗服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 处方ID
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方ID
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 处方号
	 * @return String
	 */
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}
	/**
	 * 处方号
	 * @param Code_pres
	 */
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
	}
	/**
	 * 处方类型
	 * @return String
	 */
	public String getName_pres() {
		return ((String) getAttrVal("Name_pres"));
	}
	/**
	 * 处方类型
	 * @param Name_pres
	 */
	public void setName_pres(String Name_pres) {
		setAttrVal("Name_pres", Name_pres);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 频次名称
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 用法id
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法id
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}
	/**
	 * 用法要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 煎法id
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}
	/**
	 * 煎法id
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getName_boil() {
		return ((String) getAttrVal("Name_boil"));
	}
	/**
	 * 煎法
	 * @param Name_boil
	 */
	public void setName_boil(String Name_boil) {
		setAttrVal("Name_boil", Name_boil);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}
	/**
	 * 煎法要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 医疗服务单位
	 * @return String
	 */
	public String getId_unit_srv() {
		return ((String) getAttrVal("Id_unit_srv"));
	}
	/**
	 * 医疗服务单位
	 * @param Id_unit_srv
	 */
	public void setId_unit_srv(String Id_unit_srv) {
		setAttrVal("Id_unit_srv", Id_unit_srv);
	}
	/**
	 * 剂量单位id
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 剂量单位id
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 剂量单位
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 剂量单位
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 剂量
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}
	/**
	 * 剂量
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 医基换算系数
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}
	/**
	 * 医基换算系数
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 数量分子_基本包装
	 * @return Integer
	 */
	public Integer getQuan_num_base() {
		return ((Integer) getAttrVal("Quan_num_base"));
	}
	/**
	 * 数量分子_基本包装
	 * @param Quan_num_base
	 */
	public void setQuan_num_base(Integer Quan_num_base) {
		setAttrVal("Quan_num_base", Quan_num_base);
	}
	/**
	 * 数量分母_基本包装
	 * @return Integer
	 */
	public Integer getQuan_den_base() {
		return ((Integer) getAttrVal("Quan_den_base"));
	}
	/**
	 * 数量分母_基本包装
	 * @param Quan_den_base
	 */
	public void setQuan_den_base(Integer Quan_den_base) {
		setAttrVal("Quan_den_base", Quan_den_base);
	}
	/**
	 * 床旁在途余量
	 * @return FDouble
	 */
	public FDouble getQuan_bed_ap_medu() {
		return ((FDouble) getAttrVal("Quan_bed_ap_medu"));
	}
	/**
	 * 床旁在途余量
	 * @param Quan_bed_ap_medu
	 */
	public void setQuan_bed_ap_medu(FDouble Quan_bed_ap_medu) {
		setAttrVal("Quan_bed_ap_medu", Quan_bed_ap_medu);
	}
	/**
	 * 床旁余量
	 * @return FDouble
	 */
	public FDouble getQuan_bed_medu() {
		return ((FDouble) getAttrVal("Quan_bed_medu"));
	}
	/**
	 * 床旁余量
	 * @param Quan_bed_medu
	 */
	public void setQuan_bed_medu(FDouble Quan_bed_medu) {
		setAttrVal("Quan_bed_medu", Quan_bed_medu);
	}
	/**
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getOrders_or() {
		return ((Integer) getAttrVal("Orders_or"));
	}
	/**
	 * 医嘱付数
	 * @param Orders_or
	 */
	public void setOrders_or(Integer Orders_or) {
		setAttrVal("Orders_or", Orders_or);
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
	 * 加急标志
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标志
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 院内制剂
	 * @return FBoolean
	 */
	public FBoolean getFg_hospital_herbpres() {
		return ((FBoolean) getAttrVal("Fg_hospital_herbpres"));
	}
	/**
	 * 院内制剂
	 * @param Fg_hospital_herbpres
	 */
	public void setFg_hospital_herbpres(FBoolean Fg_hospital_herbpres) {
		setAttrVal("Fg_hospital_herbpres", Fg_hospital_herbpres);
	}
	/**
	 * 高危标识
	 * @return FBoolean
	 */
	public FBoolean getFg_highrisk() {
		return ((FBoolean) getAttrVal("Fg_highrisk"));
	}
	/**
	 * 高危标识
	 * @param Fg_highrisk
	 */
	public void setFg_highrisk(FBoolean Fg_highrisk) {
		setAttrVal("Fg_highrisk", Fg_highrisk);
	}
	/**
	 * otc标识
	 * @return FBoolean
	 */
	public FBoolean getFg_otc() {
		return ((FBoolean) getAttrVal("Fg_otc"));
	}
	/**
	 * otc标识
	 * @param Fg_otc
	 */
	public void setFg_otc(FBoolean Fg_otc) {
		setAttrVal("Fg_otc", Fg_otc);
	}
	/**
	 * 标志
	 * @return String
	 */
	public String getSign() {
		return ((String) getAttrVal("Sign"));
	}
	/**
	 * 标志
	 * @param Sign
	 */
	public void setSign(String Sign) {
		setAttrVal("Sign", Sign);
	}
	/**
	 * 作废标志
	 * @return FBoolean
	 */
	public FBoolean getFg_invalid() {
		return ((FBoolean) getAttrVal("Fg_invalid"));
	}
	/**
	 * 作废标志
	 * @param Fg_invalid
	 */
	public void setFg_invalid(FBoolean Fg_invalid) {
		setAttrVal("Fg_invalid", Fg_invalid);
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
	 * 出院带药(旧版用)
	 * @return FBoolean
	 */
	public FBoolean getFg_out() {
		return ((FBoolean) getAttrVal("Fg_out"));
	}
	/**
	 * 出院带药(旧版用)
	 * @param Fg_out
	 */
	public void setFg_out(FBoolean Fg_out) {
		setAttrVal("Fg_out", Fg_out);
	}
	/**
	 * 是否代煎
	 * @return FBoolean
	 */
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}
	/**
	 * 是否代煎
	 * @param Fg_boil
	 */
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 医技标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ot() {
		return ((FBoolean) getAttrVal("Fg_ot"));
	}
	/**
	 * 医技标识
	 * @param Fg_ot
	 */
	public void setFg_ot(FBoolean Fg_ot) {
		setAttrVal("Fg_ot", Fg_ot);
	}
	/**
	 * 在院整领标识
	 * @return FBoolean
	 */
	public FBoolean getFg_wholepack() {
		return ((FBoolean) getAttrVal("Fg_wholepack"));
	}
	/**
	 * 在院整领标识
	 * @param Fg_wholepack
	 */
	public void setFg_wholepack(FBoolean Fg_wholepack) {
		setAttrVal("Fg_wholepack", Fg_wholepack);
	}
	/**
	 * 与付数无关标识(草药用)
	 * @return FBoolean
	 */
	public FBoolean getFg_nothingwithorders() {
		return ((FBoolean) getAttrVal("Fg_nothingwithorders"));
	}
	/**
	 * 与付数无关标识(草药用)
	 * @param Fg_nothingwithorders
	 */
	public void setFg_nothingwithorders(FBoolean Fg_nothingwithorders) {
		setAttrVal("Fg_nothingwithorders", Fg_nothingwithorders);
	}
	/**
	 * 退药医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or_back() {
		return ((FBoolean) getAttrVal("Fg_or_back"));
	}
	/**
	 * 退药医嘱标识
	 * @param Fg_or_back
	 */
	public void setFg_or_back(FBoolean Fg_or_back) {
		setAttrVal("Fg_or_back", Fg_or_back);
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
	 * 药品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 药品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 药品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 厂商名称
	 * @return String
	 */
	public String getName_sup() {
		return ((String) getAttrVal("Name_sup"));
	}
	/**
	 * 厂商名称
	 * @param Name_sup
	 */
	public void setName_sup(String Name_sup) {
		setAttrVal("Name_sup", Name_sup);
	}
	/**
	 * 药品取整模式
	 * @return String
	 */
	public String getPkuroundmode() {
		return ((String) getAttrVal("Pkuroundmode"));
	}
	/**
	 * 药品取整模式
	 * @param Pkuroundmode
	 */
	public void setPkuroundmode(String Pkuroundmode) {
		setAttrVal("Pkuroundmode", Pkuroundmode);
	}
	/**
	 * 物品类型
	 * @return String
	 */
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}
	/**
	 * 物品类型
	 * @param Id_mmtp
	 */
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	/**
	 * 物品类型编码
	 * @return String
	 */
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}
	/**
	 * 物品类型编码
	 * @param Sd_mmtp
	 */
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}
	/**
	 * 结存主键
	 * @return String
	 */
	public String getId_bl() {
		return ((String) getAttrVal("Id_bl"));
	}
	/**
	 * 结存主键
	 * @param Id_bl
	 */
	public void setId_bl(String Id_bl) {
		setAttrVal("Id_bl", Id_bl);
	}
	/**
	 * 唯一码
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}
	/**
	 * 唯一码
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}
	/**
	 * 物品特性
	 * @return String
	 */
	public String getCharacter() {
		return ((String) getAttrVal("Character"));
	}
	/**
	 * 物品特性
	 * @param Character
	 */
	public void setCharacter(String Character) {
		setAttrVal("Character", Character);
	}
	/**
	 * 批次号
	 * @return String
	 */
	public String getBatchno() {
		return ((String) getAttrVal("Batchno"));
	}
	/**
	 * 批次号
	 * @param Batchno
	 */
	public void setBatchno(String Batchno) {
		setAttrVal("Batchno", Batchno);
	}
	/**
	 * 进价
	 * @return FDouble
	 */
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}
	/**
	 * 进价
	 * @param Pri_act
	 */
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 请领单位id
	 * @return String
	 */
	public String getId_pkgu_ap() {
		return ((String) getAttrVal("Id_pkgu_ap"));
	}
	/**
	 * 请领单位id
	 * @param Id_pkgu_ap
	 */
	public void setId_pkgu_ap(String Id_pkgu_ap) {
		setAttrVal("Id_pkgu_ap", Id_pkgu_ap);
	}
	/**
	 * 请领单位
	 * @return String
	 */
	public String getName_pkgu_ap() {
		return ((String) getAttrVal("Name_pkgu_ap"));
	}
	/**
	 * 请领单位
	 * @param Name_pkgu_ap
	 */
	public void setName_pkgu_ap(String Name_pkgu_ap) {
		setAttrVal("Name_pkgu_ap", Name_pkgu_ap);
	}
	/**
	 * 出库单位
	 * @return String
	 */
	public String getId_pkgu_out() {
		return ((String) getAttrVal("Id_pkgu_out"));
	}
	/**
	 * 出库单位
	 * @param Id_pkgu_out
	 */
	public void setId_pkgu_out(String Id_pkgu_out) {
		setAttrVal("Id_pkgu_out", Id_pkgu_out);
	}
	/**
	 * 出库单位名称
	 * @return String
	 */
	public String getName_pkgu_out() {
		return ((String) getAttrVal("Name_pkgu_out"));
	}
	/**
	 * 出库单位名称
	 * @param Name_pkgu_out
	 */
	public void setName_pkgu_out(String Name_pkgu_out) {
		setAttrVal("Name_pkgu_out", Name_pkgu_out);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getId_pkgu_base() {
		return ((String) getAttrVal("Id_pkgu_base"));
	}
	/**
	 * 基本包装单位
	 * @param Id_pkgu_base
	 */
	public void setId_pkgu_base(String Id_pkgu_base) {
		setAttrVal("Id_pkgu_base", Id_pkgu_base);
	}
	/**
	 * 当前包装单位
	 * @return String
	 */
	public String getId_pkgu_cur() {
		return ((String) getAttrVal("Id_pkgu_cur"));
	}
	/**
	 * 当前包装单位
	 * @param Id_pkgu_cur
	 */
	public void setId_pkgu_cur(String Id_pkgu_cur) {
		setAttrVal("Id_pkgu_cur", Id_pkgu_cur);
	}
	/**
	 * 数量(显示用)
	 * @return String
	 */
	public String getQuan() {
		return ((String) getAttrVal("Quan"));
	}
	/**
	 * 数量(显示用)
	 * @param Quan
	 */
	public void setQuan(String Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 请领量(计算用)
	 * @return FDouble
	 */
	public FDouble getQuan_ap() {
		return ((FDouble) getAttrVal("Quan_ap"));
	}
	/**
	 * 请领量(计算用)
	 * @param Quan_ap
	 */
	public void setQuan_ap(FDouble Quan_ap) {
		setAttrVal("Quan_ap", Quan_ap);
	}
	/**
	 * 数量(出库单位)
	 * @return FDouble
	 */
	public FDouble getQuan_out() {
		return ((FDouble) getAttrVal("Quan_out"));
	}
	/**
	 * 数量(出库单位)
	 * @param Quan_out
	 */
	public void setQuan_out(FDouble Quan_out) {
		setAttrVal("Quan_out", Quan_out);
	}
	/**
	 * 已发药数量
	 * @return FDouble
	 */
	public FDouble getQuan_mp() {
		return ((FDouble) getAttrVal("Quan_mp"));
	}
	/**
	 * 已发药数量
	 * @param Quan_mp
	 */
	public void setQuan_mp(FDouble Quan_mp) {
		setAttrVal("Quan_mp", Quan_mp);
	}
	/**
	 * 库存量
	 * @return FDouble
	 */
	public FDouble getQuan_stock() {
		return ((FDouble) getAttrVal("Quan_stock"));
	}
	/**
	 * 库存量
	 * @param Quan_stock
	 */
	public void setQuan_stock(FDouble Quan_stock) {
		setAttrVal("Quan_stock", Quan_stock);
	}
	/**
	 * 退药数量
	 * @return FDouble
	 */
	public FDouble getQuan_ret() {
		return ((FDouble) getAttrVal("Quan_ret"));
	}
	/**
	 * 退药数量
	 * @param Quan_ret
	 */
	public void setQuan_ret(FDouble Quan_ret) {
		setAttrVal("Quan_ret", Quan_ret);
	}
	/**
	 * 已退药数量
	 * @return FDouble
	 */
	public FDouble getQuan_reted() {
		return ((FDouble) getAttrVal("Quan_reted"));
	}
	/**
	 * 已退药数量
	 * @param Quan_reted
	 */
	public void setQuan_reted(FDouble Quan_reted) {
		setAttrVal("Quan_reted", Quan_reted);
	}
	/**
	 * 付数退数量
	 * @return Integer
	 */
	public Integer getOrders_or_ret() {
		return ((Integer) getAttrVal("Orders_or_ret"));
	}
	/**
	 * 付数退数量
	 * @param Orders_or_ret
	 */
	public void setOrders_or_ret(Integer Orders_or_ret) {
		setAttrVal("Orders_or_ret", Orders_or_ret);
	}
	/**
	 * 付数已退量
	 * @return Integer
	 */
	public Integer getOrders_or_reted() {
		return ((Integer) getAttrVal("Orders_or_reted"));
	}
	/**
	 * 付数已退量
	 * @param Orders_or_reted
	 */
	public void setOrders_or_reted(Integer Orders_or_reted) {
		setAttrVal("Orders_or_reted", Orders_or_reted);
	}
	/**
	 * 换算系数(请领单位)
	 * @return FDouble
	 */
	public FDouble getFactor_ap() {
		return ((FDouble) getAttrVal("Factor_ap"));
	}
	/**
	 * 换算系数(请领单位)
	 * @param Factor_ap
	 */
	public void setFactor_ap(FDouble Factor_ap) {
		setAttrVal("Factor_ap", Factor_ap);
	}
	/**
	 * 换算系数(出库单位)
	 * @return FDouble
	 */
	public FDouble getFactor_out() {
		return ((FDouble) getAttrVal("Factor_out"));
	}
	/**
	 * 换算系数(出库单位)
	 * @param Factor_out
	 */
	public void setFactor_out(FDouble Factor_out) {
		setAttrVal("Factor_out", Factor_out);
	}
	/**
	 * 换算系数
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}
	/**
	 * 换算系数
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 标注金额
	 * @return FDouble
	 */
	public FDouble getAmt_std() {
		return ((FDouble) getAttrVal("Amt_std"));
	}
	/**
	 * 标注金额
	 * @param Amt_std
	 */
	public void setAmt_std(FDouble Amt_std) {
		setAttrVal("Amt_std", Amt_std);
	}
	/**
	 * 煎药费
	 * @return FDouble
	 */
	public FDouble getBoil_fee() {
		return ((FDouble) getAttrVal("Boil_fee"));
	}
	/**
	 * 煎药费
	 * @param Boil_fee
	 */
	public void setBoil_fee(FDouble Boil_fee) {
		setAttrVal("Boil_fee", Boil_fee);
	}
	/**
	 * 患者欠费金额
	 * @return FDouble
	 */
	public FDouble getAmt_lack() {
		return ((FDouble) getAttrVal("Amt_lack"));
	}
	/**
	 * 患者欠费金额
	 * @param Amt_lack
	 */
	public void setAmt_lack(FDouble Amt_lack) {
		setAttrVal("Amt_lack", Amt_lack);
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
	 * 基数药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_base() {
		return ((FBoolean) getAttrVal("Fg_base"));
	}
	/**
	 * 基数药标识
	 * @param Fg_base
	 */
	public void setFg_base(FBoolean Fg_base) {
		setAttrVal("Fg_base", Fg_base);
	}
	/**
	 * 库房
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 库房
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 药库名称
	 * @return String
	 */
	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}
	/**
	 * 药库名称
	 * @param Name_dep_wh
	 */
	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getId_dep_ap() {
		return ((String) getAttrVal("Id_dep_ap"));
	}
	/**
	 * 申请科室
	 * @param Id_dep_ap
	 */
	public void setId_dep_ap(String Id_dep_ap) {
		setAttrVal("Id_dep_ap", Id_dep_ap);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getName_emp_apply() {
		return ((String) getAttrVal("Name_emp_apply"));
	}
	/**
	 * 申请人
	 * @param Name_emp_apply
	 */
	public void setName_emp_apply(String Name_emp_apply) {
		setAttrVal("Name_emp_apply", Name_emp_apply);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDisp_time() {
		return ((FDateTime) getAttrVal("Disp_time"));
	}
	/**
	 * 申请时间
	 * @param Disp_time
	 */
	public void setDisp_time(FDateTime Disp_time) {
		setAttrVal("Disp_time", Disp_time);
	}
	/**
	 * 所在病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 所在病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 开立机构
	 * @return String
	 */
	public String getId_org_or() {
		return ((String) getAttrVal("Id_org_or"));
	}
	/**
	 * 开立机构
	 * @param Id_org_or
	 */
	public void setId_org_or(String Id_org_or) {
		setAttrVal("Id_org_or", Id_org_or);
	}
	/**
	 * 执行机构
	 * @return String
	 */
	public String getId_org_mp() {
		return ((String) getAttrVal("Id_org_mp"));
	}
	/**
	 * 执行机构
	 * @param Id_org_mp
	 */
	public void setId_org_mp(String Id_org_mp) {
		setAttrVal("Id_org_mp", Id_org_mp);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开立科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开立科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立医生姓名
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立医生姓名
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}
	/**
	 * 开立时间
	 * @param Dt_or
	 */
	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}
	/**
	 * 出库单
	 * @return String
	 */
	public String getId_out() {
		return ((String) getAttrVal("Id_out"));
	}
	/**
	 * 出库单
	 * @param Id_out
	 */
	public void setId_out(String Id_out) {
		setAttrVal("Id_out", Id_out);
	}
	/**
	 * 发药状态
	 * @return Integer
	 */
	public Integer getEu_su_mp() {
		return ((Integer) getAttrVal("Eu_su_mp"));
	}
	/**
	 * 发药状态
	 * @param Eu_su_mp
	 */
	public void setEu_su_mp(Integer Eu_su_mp) {
		setAttrVal("Eu_su_mp", Eu_su_mp);
	}
	/**
	 * 发药时间
	 * @return FDateTime
	 */
	public FDateTime getDt_disp_time() {
		return ((FDateTime) getAttrVal("Dt_disp_time"));
	}
	/**
	 * 发药时间
	 * @param Dt_disp_time
	 */
	public void setDt_disp_time(FDateTime Dt_disp_time) {
		setAttrVal("Dt_disp_time", Dt_disp_time);
	}
	/**
	 * 出库人
	 * @return String
	 */
	public String getId_emp_out() {
		return ((String) getAttrVal("Id_emp_out"));
	}
	/**
	 * 出库人
	 * @param Id_emp_out
	 */
	public void setId_emp_out(String Id_emp_out) {
		setAttrVal("Id_emp_out", Id_emp_out);
	}
	/**
	 * 发药人
	 * @return String
	 */
	public String getName_emp_disp() {
		return ((String) getAttrVal("Name_emp_disp"));
	}
	/**
	 * 发药人
	 * @param Name_emp_disp
	 */
	public void setName_emp_disp(String Name_emp_disp) {
		setAttrVal("Name_emp_disp", Name_emp_disp);
	}
	/**
	 * 药单异常类型
	 * @return String
	 */
	public String getId_chktype() {
		return ((String) getAttrVal("Id_chktype"));
	}
	/**
	 * 药单异常类型
	 * @param Id_chktype
	 */
	public void setId_chktype(String Id_chktype) {
		setAttrVal("Id_chktype", Id_chktype);
	}
	/**
	 * 药单异常类型编码
	 * @return String
	 */
	public String getSd_chktype() {
		return ((String) getAttrVal("Sd_chktype"));
	}
	/**
	 * 药单异常类型编码
	 * @param Sd_chktype
	 */
	public void setSd_chktype(String Sd_chktype) {
		setAttrVal("Sd_chktype", Sd_chktype);
	}
	/**
	 * 首日摆药状态
	 * @return String
	 */
	public String getId_fddgipap() {
		return ((String) getAttrVal("Id_fddgipap"));
	}
	/**
	 * 首日摆药状态
	 * @param Id_fddgipap
	 */
	public void setId_fddgipap(String Id_fddgipap) {
		setAttrVal("Id_fddgipap", Id_fddgipap);
	}
	/**
	 * 首日摆药状态编码
	 * @return String
	 */
	public String getSd_fddgipap() {
		return ((String) getAttrVal("Sd_fddgipap"));
	}
	/**
	 * 首日摆药状态编码
	 * @param Sd_fddgipap
	 */
	public void setSd_fddgipap(String Sd_fddgipap) {
		setAttrVal("Sd_fddgipap", Sd_fddgipap);
	}
	/**
	 * 首日不摆标识
	 * @return FBoolean
	 */
	public FBoolean getFg_firstdaynotset() {
		return ((FBoolean) getAttrVal("Fg_firstdaynotset"));
	}
	/**
	 * 首日不摆标识
	 * @param Fg_firstdaynotset
	 */
	public void setFg_firstdaynotset(FBoolean Fg_firstdaynotset) {
		setAttrVal("Fg_firstdaynotset", Fg_firstdaynotset);
	}
	/**
	 * 可转正常标识
	 * @return FBoolean
	 */
	public FBoolean getFg_cantovalid() {
		return ((FBoolean) getAttrVal("Fg_cantovalid"));
	}
	/**
	 * 可转正常标识
	 * @param Fg_cantovalid
	 */
	public void setFg_cantovalid(FBoolean Fg_cantovalid) {
		setAttrVal("Fg_cantovalid", Fg_cantovalid);
	}
	/**
	 * 不摆药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_nodis() {
		return ((FBoolean) getAttrVal("Fg_nodis"));
	}
	/**
	 * 不摆药标识
	 * @param Fg_nodis
	 */
	public void setFg_nodis(FBoolean Fg_nodis) {
		setAttrVal("Fg_nodis", Fg_nodis);
	}
	/**
	 * 病区拒领原因
	 * @return String
	 */
	public String getApreject_reason() {
		return ((String) getAttrVal("Apreject_reason"));
	}
	/**
	 * 病区拒领原因
	 * @param Apreject_reason
	 */
	public void setApreject_reason(String Apreject_reason) {
		setAttrVal("Apreject_reason", Apreject_reason);
	}
	/**
	 * 药房拒摆原因
	 * @return String
	 */
	public String getDereject_reason() {
		return ((String) getAttrVal("Dereject_reason"));
	}
	/**
	 * 药房拒摆原因
	 * @param Dereject_reason
	 */
	public void setDereject_reason(String Dereject_reason) {
		setAttrVal("Dereject_reason", Dereject_reason);
	}
	/**
	 * 拒领护士
	 * @return String
	 */
	public String getId_emp_aprej() {
		return ((String) getAttrVal("Id_emp_aprej"));
	}
	/**
	 * 拒领护士
	 * @param Id_emp_aprej
	 */
	public void setId_emp_aprej(String Id_emp_aprej) {
		setAttrVal("Id_emp_aprej", Id_emp_aprej);
	}
	/**
	 * 拒领护士名称
	 * @return String
	 */
	public String getName_emp_aprej() {
		return ((String) getAttrVal("Name_emp_aprej"));
	}
	/**
	 * 拒领护士名称
	 * @param Name_emp_aprej
	 */
	public void setName_emp_aprej(String Name_emp_aprej) {
		setAttrVal("Name_emp_aprej", Name_emp_aprej);
	}
	/**
	 * 拒摆药师
	 * @return String
	 */
	public String getId_emp_derej() {
		return ((String) getAttrVal("Id_emp_derej"));
	}
	/**
	 * 拒摆药师
	 * @param Id_emp_derej
	 */
	public void setId_emp_derej(String Id_emp_derej) {
		setAttrVal("Id_emp_derej", Id_emp_derej);
	}
	/**
	 * 拒摆药师名称
	 * @return String
	 */
	public String getName_emp_derej() {
		return ((String) getAttrVal("Name_emp_derej"));
	}
	/**
	 * 拒摆药师名称
	 * @param Name_emp_derej
	 */
	public void setName_emp_derej(String Name_emp_derej) {
		setAttrVal("Name_emp_derej", Name_emp_derej);
	}
	/**
	 * 请领处理状态
	 * @return Integer
	 */
	public Integer getEn_opap() {
		return ((Integer) getAttrVal("En_opap"));
	}
	/**
	 * 请领处理状态
	 * @param En_opap
	 */
	public void setEn_opap(Integer En_opap) {
		setAttrVal("En_opap", En_opap);
	}
	/**
	 * 发药处理状态
	 * @return Integer
	 */
	public Integer getEn_opde() {
		return ((Integer) getAttrVal("En_opde"));
	}
	/**
	 * 发药处理状态
	 * @param En_opde
	 */
	public void setEn_opde(Integer En_opde) {
		setAttrVal("En_opde", En_opde);
	}
	/**
	 * 退药处理状态
	 * @return Integer
	 */
	public Integer getEn_opbk() {
		return ((Integer) getAttrVal("En_opbk"));
	}
	/**
	 * 退药处理状态
	 * @param En_opbk
	 */
	public void setEn_opbk(Integer En_opbk) {
		setAttrVal("En_opbk", En_opbk);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 处方执行
	 * @return String
	 */
	public String getId_dgpresst() {
		return ((String) getAttrVal("Id_dgpresst"));
	}
	/**
	 * 处方执行
	 * @param Id_dgpresst
	 */
	public void setId_dgpresst(String Id_dgpresst) {
		setAttrVal("Id_dgpresst", Id_dgpresst);
	}
	/**
	 * 执行计划主键
	 * @return String
	 */
	public String getId_or_pr_srv() {
		return ((String) getAttrVal("Id_or_pr_srv"));
	}
	/**
	 * 执行计划主键
	 * @param Id_or_pr_srv
	 */
	public void setId_or_pr_srv(String Id_or_pr_srv) {
		setAttrVal("Id_or_pr_srv", Id_or_pr_srv);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 执行计划开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_begin() {
		return ((FDateTime) getAttrVal("Dt_mp_begin"));
	}
	/**
	 * 执行计划开始时间
	 * @param Dt_mp_begin
	 */
	public void setDt_mp_begin(FDateTime Dt_mp_begin) {
		setAttrVal("Dt_mp_begin", Dt_mp_begin);
	}
	/**
	 * 执行计划结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_end() {
		return ((FDateTime) getAttrVal("Dt_mp_end"));
	}
	/**
	 * 执行计划结束时间
	 * @param Dt_mp_end
	 */
	public void setDt_mp_end(FDateTime Dt_mp_end) {
		setAttrVal("Dt_mp_end", Dt_mp_end);
	}
	/**
	 * 退药关联主键(刷单退药)
	 * @return String
	 */
	public String getId_relation_key() {
		return ((String) getAttrVal("Id_relation_key"));
	}
	/**
	 * 退药关联主键(刷单退药)
	 * @param Id_relation_key
	 */
	public void setId_relation_key(String Id_relation_key) {
		setAttrVal("Id_relation_key", Id_relation_key);
	}
	/**
	 * 退药原数据主键(特殊退药)
	 * @return String
	 */
	public String getId_dgipdt_ret() {
		return ((String) getAttrVal("Id_dgipdt_ret"));
	}
	/**
	 * 退药原数据主键(特殊退药)
	 * @param Id_dgipdt_ret
	 */
	public void setId_dgipdt_ret(String Id_dgipdt_ret) {
		setAttrVal("Id_dgipdt_ret", Id_dgipdt_ret);
	}
	/**
	 * 退药医嘱主键
	 * @return String
	 */
	public String getId_or_back() {
		return ((String) getAttrVal("Id_or_back"));
	}
	/**
	 * 退药医嘱主键
	 * @param Id_or_back
	 */
	public void setId_or_back(String Id_or_back) {
		setAttrVal("Id_or_back", Id_or_back);
	}
	/**
	 * 退药医嘱执行计划主键
	 * @return String
	 */
	public String getId_or_pr_srv_back() {
		return ((String) getAttrVal("Id_or_pr_srv_back"));
	}
	/**
	 * 退药医嘱执行计划主键
	 * @param Id_or_pr_srv_back
	 */
	public void setId_or_pr_srv_back(String Id_or_pr_srv_back) {
		setAttrVal("Id_or_pr_srv_back", Id_or_pr_srv_back);
	}
	/**
	 * 退药医嘱计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan_back() {
		return ((FDateTime) getAttrVal("Dt_mp_plan_back"));
	}
	/**
	 * 退药医嘱计划执行时间
	 * @param Dt_mp_plan_back
	 */
	public void setDt_mp_plan_back(FDateTime Dt_mp_plan_back) {
		setAttrVal("Dt_mp_plan_back", Dt_mp_plan_back);
	}
	/**
	 * 执行计划状态
	 * @return Integer
	 */
	public Integer getEu_su() {
		return ((Integer) getAttrVal("Eu_su"));
	}
	/**
	 * 执行计划状态
	 * @param Eu_su
	 */
	public void setEu_su(Integer Eu_su) {
		setAttrVal("Eu_su", Eu_su);
	}
	/**
	 * 记账主键
	 * @return String
	 */
	public String getId_ipcg() {
		return ((String) getAttrVal("Id_ipcg"));
	}
	/**
	 * 记账主键
	 * @param Id_ipcg
	 */
	public void setId_ipcg(String Id_ipcg) {
		setAttrVal("Id_ipcg", Id_ipcg);
	}
	/**
	 * 价值分类
	 * @return String
	 */
	public String getId_val() {
		return ((String) getAttrVal("Id_val"));
	}
	/**
	 * 价值分类
	 * @param Id_val
	 */
	public void setId_val(String Id_val) {
		setAttrVal("Id_val", Id_val);
	}
	/**
	 * 价值分类编码
	 * @return String
	 */
	public String getSd_val() {
		return ((String) getAttrVal("Sd_val"));
	}
	/**
	 * 价值分类编码
	 * @param Sd_val
	 */
	public void setSd_val(String Sd_val) {
		setAttrVal("Sd_val", Sd_val);
	}
	/**
	 * 医嘱停止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_stop() {
		return ((FDateTime) getAttrVal("Dt_stop"));
	}
	/**
	 * 医嘱停止时间
	 * @param Dt_stop
	 */
	public void setDt_stop(FDateTime Dt_stop) {
		setAttrVal("Dt_stop", Dt_stop);
	}
	/**
	 * 医嘱停止药房拒摆标识
	 * @return FBoolean
	 */
	public FBoolean getFg_orstop_reject() {
		return ((FBoolean) getAttrVal("Fg_orstop_reject"));
	}
	/**
	 * 医嘱停止药房拒摆标识
	 * @param Fg_orstop_reject
	 */
	public void setFg_orstop_reject(FBoolean Fg_orstop_reject) {
		setAttrVal("Fg_orstop_reject", Fg_orstop_reject);
	}
	/**
	 * 药品减免标记
	 * @return FBoolean
	 */
	public FBoolean getFg_free() {
		return ((FBoolean) getAttrVal("Fg_free"));
	}
	/**
	 * 药品减免标记
	 * @param Fg_free
	 */
	public void setFg_free(FBoolean Fg_free) {
		setAttrVal("Fg_free", Fg_free);
	}
	/**
	 * 药单主键
	 * @return String
	 */
	public String getId_dgshetp() {
		return ((String) getAttrVal("Id_dgshetp"));
	}
	/**
	 * 药单主键
	 * @param Id_dgshetp
	 */
	public void setId_dgshetp(String Id_dgshetp) {
		setAttrVal("Id_dgshetp", Id_dgshetp);
	}
	/**
	 * 药单名称
	 * @return String
	 */
	public String getName_dgshetp() {
		return ((String) getAttrVal("Name_dgshetp"));
	}
	/**
	 * 药单名称
	 * @param Name_dgshetp
	 */
	public void setName_dgshetp(String Name_dgshetp) {
		setAttrVal("Name_dgshetp", Name_dgshetp);
	}
	/**
	 * 药单编码
	 * @return String
	 */
	public String getCode_dgshetp() {
		return ((String) getAttrVal("Code_dgshetp"));
	}
	/**
	 * 药单编码
	 * @param Code_dgshetp
	 */
	public void setCode_dgshetp(String Code_dgshetp) {
		setAttrVal("Code_dgshetp", Code_dgshetp);
	}
	/**
	 * 删除标志
	 * @return Integer
	 */
	public Integer getDs() {
		return ((Integer) getAttrVal("Ds"));
	}
	/**
	 * 删除标志
	 * @param Ds
	 */
	public void setDs(Integer Ds) {
		setAttrVal("Ds", Ds);
	}
	/**
	 * 时间标识
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 时间标识
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
}