package iih.mp.nr.dto.mpwardprint.d;

/**
 * 病区打印参数
 * 
 */
public class MpPrnParamDTO {

	/** 患者ID串 */
	private String id_ents;
	/** 开始时间 */
	private String rel_begin;
	/** 结束时间 */
	private String rel_end;
	/** 长临 */
	private String eu_long;
	/** 打印状态 */
	private String eu_print;
	/** 用法ID */
	private String id_routes;
	/** 毒麻标识 */
	private String fg_pois;
	/** 日次多张卡 */
	private String fg_unfold;
	/** 是否特殊频次 */
	private String fg_fre;
	/** 非特殊频次 */
	private String no_spec_fre;
	/** 服务类型 */
	private String sd_srvtps;
	/** 单据分类id */
	private String id_prnca;

	/** getter and setter */

	public String getId_ents() {
		return this.id_ents;
	}

	public void setId_ents(String id_ents) {
		this.id_ents = id_ents;
	}

	public String getRel_begin() {
		return this.rel_begin;
	}

	public void setRel_begin(String rel_begin) {
		this.rel_begin = rel_begin;
	}

	public String getRel_end() {
		return this.rel_end;
	}

	public void setRel_end(String rel_end) {
		this.rel_end = rel_end;
	}

	public String getEu_long() {
		return this.eu_long;
	}

	public void setEu_long(String eu_long) {
		this.eu_long = eu_long;
	}

	public String getEu_print() {
		return this.eu_print;
	}

	public void setEu_print(String eu_print) {
		this.eu_print = eu_print;
	}

	public String getId_routes() {
		return this.id_routes;
	}

	public void setId_routes(String id_routes) {
		this.id_routes = id_routes;
	}

	public String getFg_pois() {
		return this.fg_pois;
	}

	public void setFg_pois(String fg_pois) {
		this.fg_pois = fg_pois;
	}

	public String getFg_unfold() {
		return this.fg_unfold;
	}

	public void setFg_unfold(String fg_unfold) {
		this.fg_unfold = fg_unfold;
	}

	public String getFg_fre() {
		return this.fg_fre;
	}

	public void setFg_fre(String fg_fre) {
		this.fg_fre = fg_fre;
	}

	public String getNo_spec_fre() {
		return this.no_spec_fre;
	}

	public void setNo_spec_fre(String no_spec_fre) {
		this.no_spec_fre = no_spec_fre;
	}

	public String getSd_srvtps() {
		return this.sd_srvtps;
	}

	public void setSd_srvtps(String sd_srvtps) {
		this.sd_srvtps = sd_srvtps;
	}

	public String getId_prnca() {
		return id_prnca;
	}

	public void setId_prnca(String id_prnca) {
		this.id_prnca = id_prnca;
	}

}