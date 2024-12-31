package iih.bd.pp.i.external.provide.meta.bl;

/**
 * 药品价格信息
 * 
 * @author ly 2018/01/26
 * @author hao_wu 2018-6-12 从BL移至BD
 */
public class DrugPriceInfo {

	/**
	 * 药品编码
	 */
	private String code;

	/**
	 * 药品名称
	 */
	private String name;

	/**
	 * 药品通用名编码
	 */
	private String approvedCode;

	/**
	 * 药品通用名名称
	 */
	private String approvedName;

	/**
	 * 拼音码
	 */
	private String pyCode;

	/**
	 * 医保编码
	 */
	private String hp_Code;

	/**
	 * 规格
	 */
	private String spec;

	/**
	 * 单位
	 */
	private String name_unit;

	/**
	 * 药品类别
	 */
	private String name_hpsrvtp;

	/**
	 * 单价
	 */
	private Double price;

	/**
	 * 剂型
	 */
	private String name_dosage;

	/**
	 * 生产厂家
	 */
	private String name_sup;

	/**
	 * 厂家
	 */
	private String grade;

	/**
	 * 产地
	 */
	private String place;

	/**
	 * 药品编码
	 * 
	 * @return code 药品编码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 药品编码
	 * 
	 * @param code
	 *            药品编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 药品编码
	 * 
	 * @return name 药品编码
	 */
	public String getName() {
		return name;
	}

	/**
	 * 药品编码
	 * 
	 * @param name
	 *            药品编码
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 药品通用名编码
	 * 
	 * @return 药品通用名编码
	 */
	public String getCode_srv() {
		return approvedCode;
	}

	/**
	 * 药品通用名编码
	 * 
	 * @param approvedCode
	 *            药品通用名编码
	 */
	public void setCode_srv(String approvedCode) {
		this.approvedCode = approvedCode;
	}

	/**
	 * 药品通用名名称
	 * 
	 * @return 药品通用名名称
	 */
	public String getName_srv() {
		return approvedName;
	}

	/**
	 * 药品通用名名称
	 * 
	 * @param approvedName
	 *            药品通用名名称
	 */
	public void setName_srv(String approvedName) {
		this.approvedName = approvedName;
	}

	/**
	 * 拼音码
	 * 
	 * @return 拼音码
	 */
	public String getPyCode() {
		return pyCode;
	}

	/**
	 * 拼音码
	 * 
	 * @param pycode
	 *            拼音码
	 */
	public void setPyCode(String pyCode) {
		this.pyCode = pyCode;
	}

	/**
	 * 医保编码
	 * 
	 * @return 医保编码
	 */
	public String getHp_Code() {
		return hp_Code;
	}

	/**
	 * 医保编码
	 * 
	 * @param hp_code
	 *            医保编码
	 */
	public void setHp_Code(String hp_code) {
		this.hp_Code = hp_code;
	}

	/**
	 * 规格
	 * 
	 * @return spec 规格
	 */
	public String getSpec() {
		return spec;
	}

	/**
	 * 规格
	 * 
	 * @param spec
	 *            规格
	 */
	public void setSpec(String spec) {
		this.spec = spec;
	}

	/**
	 * 单位
	 * 
	 * @return name_unit 单位
	 */
	public String getName_unit() {
		return name_unit;
	}

	/**
	 * 单位
	 * 
	 * @param name_unit
	 *            单位
	 */
	public void setName_unit(String name_unit) {
		this.name_unit = name_unit;
	}

	/**
	 * 药品类别
	 * 
	 * @return name_hpsrvtp 药品类别
	 */
	public String getName_hpsrvtp() {
		return name_hpsrvtp;
	}

	/**
	 * 药品类别
	 * 
	 * @param name_hpsrvtp
	 *            药品类别
	 */
	public void setName_hpsrvtp(String name_hpsrvtp) {
		this.name_hpsrvtp = name_hpsrvtp;
	}

	/**
	 * 单价
	 * 
	 * @return price 单价
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * 单价
	 * 
	 * @param price
	 *            单价
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * 剂型
	 * 
	 * @return name_dosage 剂型
	 */
	public String getName_dosage() {
		return name_dosage;
	}

	/**
	 * 剂型
	 * 
	 * @param name_dosage
	 *            剂型
	 */
	public void setName_dosage(String name_dosage) {
		this.name_dosage = name_dosage;
	}

	/**
	 * 生产厂家
	 * 
	 * @return name_sup 生产厂家
	 */
	public String getName_sup() {
		return name_sup;
	}

	/**
	 * 生产厂家
	 * 
	 * @param name_sup
	 *            生产厂家
	 */
	public void setName_sup(String name_sup) {
		this.name_sup = name_sup;
	}

	/**
	 * 等级
	 * 
	 * @return grade 等级
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 等级
	 * 
	 * @param grade
	 *            等级
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * 产地
	 * 
	 * @return place 产地
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * 产地
	 * 
	 * @param place
	 *            产地
	 */
	public void setPlace(String place) {
		this.place = place;
	}

}
