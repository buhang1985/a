package iih.bd.pp.i.external.provide.meta.bl;

/**
 * 诊疗价格信息
 * 
 * @author LIM
 * 
 * @author hao_wu 2018-6-12 从BL移至BD
 *
 */
public class TreatPriceInfo {
	/**
	 * 项目编码
	 */
	private String code;
	/**
	 * 项目名称
	 */
	private String name;

	/**
	 * 拼音码
	 */
	private String pycode;

	/**
	 * 医保编码
	 */
	private String hp_code;

	/**
	 * 单位
	 */
	private String unit_name;
	/**
	 * 单价
	 */
	private double price;
	/**
	 * 医保内容说明
	 */
	private String des;
	/**
	 * 收费依据
	 */
	private String pri_des;
	/**
	 * 生成厂商
	 */
	private String factory_name;

	/**
	 * 价格分类
	 */
	private String pri_pat;

	/**
	 * 注册证号
	 */
	private String apprno;

	/**
	 * 获取项目编码
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置项目编码
	 * 
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取项目名称
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置项目名称
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取拼音码
	 * 
	 * @return the pycode
	 */
	public String getPyCode() {
		return pycode;
	}

	/**
	 * 设置拼音码
	 * 
	 * @param pycode
	 *            the pycode to set
	 */
	public void setPyCode(String pycode) {
		this.pycode = pycode;
	}

	/**
	 * 获取医保编码
	 * 
	 * @return the hp_code
	 */
	public String getHp_Code() {
		return hp_code;
	}

	/**
	 * 设置医保编码
	 * 
	 * @param hp_code
	 *            the hp_code to set
	 */
	public void setHp_Code(String hp_code) {
		this.hp_code = hp_code;
	}

	/**
	 * 获取单位
	 * 
	 * @return the unit_name
	 */
	public String getUnit_name() {
		return unit_name;
	}

	/**
	 * 设置单位
	 * 
	 * @param unit_name
	 *            the unit_name to set
	 */
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	/**
	 * 获取单价
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 设置项单价
	 * 
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 获取医保内容说明
	 * 
	 * @return the des
	 */
	public String getDes() {
		return des;
	}

	/**
	 * 设置医保内容说明
	 * 
	 * @param des
	 *            the des to set
	 */
	public void setDes(String des) {
		this.des = des;
	}

	/**
	 * 获取收费依据
	 * 
	 * @return the pri_des
	 */
	public String getPri_des() {
		return pri_des;
	}

	/**
	 * 设置收费依据
	 * 
	 * @param pri_des
	 *            the pri_des to set
	 */
	public void setPri_des(String pri_des) {
		this.pri_des = pri_des;
	}

	/**
	 * 获取生成厂商
	 * 
	 * @return the factory_name
	 */
	public String getFactory_name() {
		return factory_name;
	}

	/**
	 * 设置生成厂商
	 * 
	 * @param factory_name
	 *            the factory_name to set
	 */
	public void setFactory_name(String factory_name) {
		this.factory_name = factory_name;
	}

	/**
	 * 获取价格分类
	 * 
	 * @return the pri_pat
	 */
	public String getPri_pat() {
		return pri_pat;
	}

	/**
	 * 设置价格分类
	 * 
	 * @param pri_pat
	 *            the pri_pat to set
	 */
	public void setPri_pat(String pri_pat) {
		this.pri_pat = pri_pat;
	}

	/**
	 * 获取注册证号
	 * 
	 * @return the apprno
	 */
	public String getApprno() {
		return apprno;
	}

	/**
	 * 设置注册证号
	 * 
	 * @param apprno
	 *            the apprno to set
	 */
	public void setApprno(String apprno) {
		this.apprno = apprno;
	}

}
