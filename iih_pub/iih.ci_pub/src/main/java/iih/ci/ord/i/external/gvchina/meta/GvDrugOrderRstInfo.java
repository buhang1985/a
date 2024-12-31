package iih.ci.ord.i.external.gvchina.meta;

/**
 * 查询患者在眼科本次就诊的有效药品医嘱信息定义
 * @author wangqingzhu
 *
 */
public class GvDrugOrderRstInfo  extends BaseGvRstInfo{

	
	/**
	 * 包装单位类型
	 */
	private String pkgUnitType;
	
	/**
	 * 规格
	 */
	private String spec;
	/**
	 * 剂量
	 */
	private double medQuan;
	/**
	 * 剂量单位编码
	 */
	private String medUnitCode;
	/**
	 * 剂量单位名称
	 */
	private String medUnitName;
	/**
	 * 用法编码
	 */
	private String routeCode;
	/**
	 * 用法名称
	 */
	private String routeName;
	/**
	 * 频次编码
	 */
	private String freqCode;
	/**
	 * 频次名称
	 */
	private String freqName;
	/**
	 * 总量
	 */
	private double totalQuan;
	/**
	 * 总量单位编码
	 */
	private String totalQuanUnitCode;
	/**
	 * 总量单位名称
	 */
	private String totalQuanUnitName;
	/**
	 * 剂型编码
	 */
	private String dosageCode;
	/**
	 * 剂型名称
	 */
	private String dosageName;
	/**
	 * 用法描述
	 */
	private String routeDes;
	/**
	 * 使用天数
	 */
	private int useDays;
	/**
	 * 开单时间
	 */
	private String effeTime;
	/**
	 * 申请科室
	 */
	private String signDeptCode;
	public String getPkgUnitType() {
		return pkgUnitType;
	}
	public void setPkgUnitType(String pkgUnitType) {
		this.pkgUnitType = pkgUnitType;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public double getMedQuan() {
		return medQuan;
	}
	public void setMedQuan(double medQuan) {
		this.medQuan = medQuan;
	}
	public String getMedUnitCode() {
		return medUnitCode;
	}
	public void setMedUnitCode(String medUnitCode) {
		this.medUnitCode = medUnitCode;
	}
	public String getMedUnitName() {
		return medUnitName;
	}
	public void setMedUnitName(String medUnitName) {
		this.medUnitName = medUnitName;
	}
	public String getRouteCode() {
		return routeCode;
	}
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getFreqCode() {
		return freqCode;
	}
	public void setFreqCode(String freqCode) {
		this.freqCode = freqCode;
	}
	public String getFreqName() {
		return freqName;
	}
	public void setFreqName(String freqName) {
		this.freqName = freqName;
	}
	public double getTotalQuan() {
		return totalQuan;
	}
	public void setTotalQuan(double totalQuan) {
		this.totalQuan = totalQuan;
	}
	public String getTotalQuanUnitCode() {
		return totalQuanUnitCode;
	}
	public void setTotalQuanUnitCode(String totalQuanUnitCode) {
		this.totalQuanUnitCode = totalQuanUnitCode;
	}
	public String getTotalQuanUnitName() {
		return totalQuanUnitName;
	}
	public void setTotalQuanUnitName(String totalQuanUnitName) {
		this.totalQuanUnitName = totalQuanUnitName;
	}
	public String getDosageCode() {
		return dosageCode;
	}
	public void setDosageCode(String dosageCode) {
		this.dosageCode = dosageCode;
	}
	public String getDosageName() {
		return dosageName;
	}
	public void setDosageName(String dosageName) {
		this.dosageName = dosageName;
	}
	public String getRouteDes() {
		return routeDes;
	}
	public void setRouteDes(String routeDes) {
		this.routeDes = routeDes;
	}
	public int getUseDays() {
		return useDays;
	}
	public void setUseDays(int useDays) {
		this.useDays = useDays;
	}
	public String getEffeTime() {
		return effeTime;
	}
	public void setEffeTime(String effeTime) {
		this.effeTime = effeTime;
	}
	public String getSignDeptCode() {
		return signDeptCode;
	}
	public void setSignDeptCode(String signDeptCode) {
		this.signDeptCode = signDeptCode;
	}

}
