package iih.ci.ord.orderchangeprn.d;

import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.xapformula.vo.pub.formulaset.function.DateTime;

/**
 * 医嘱变更单医嘱信息
 * @author zhangwq
 *
 */
public class OrdChangeOrderInfoDTO {
	/**
	 * 服务名称
	 */
	private String name_srv;
	/**
	 * 剂量
	 */
	private Double quan_med;
	/**
	 * 剂量单位
	 */
	private String name_unit_med;
	/**
	 * 用法
	 */
	private String name_route;
	/**
	 * 频次
	 */
	private String name_freq;
	/**
	 * 执行时间
	 */
	private DateTime dt_exec;
	/**
	 * 备注
	 */
	private String note;
	/**
	 * 开始时间
	 */
	private FDateTime dt_effe;
	/**
	 * 停止时间
	 */
	private FDateTime dt_stop;
	public FDateTime getDt_stop() {
		return dt_stop;
	}
	public void setDt_stop(FDateTime dt_stop) {
		this.dt_stop = dt_stop;
	}
	public String getName_srv() {
		return name_srv;
	}
	public void setName_srv(String name_srv) {
		this.name_srv = name_srv;
	}
	public Double getQuan_med() {
		return quan_med;
	}
	public void setQuan_med(Double quan_med) {
		this.quan_med = quan_med;
	}
	public String getName_unit_med() {
		return name_unit_med;
	}
	public void setName_unit_med(String name_unit_med) {
		this.name_unit_med = name_unit_med;
	}
	public String getName_route() {
		return name_route;
	}
	public void setName_route(String name_route) {
		this.name_route = name_route;
	}
	public String getName_freq() {
		return name_freq;
	}
	public void setName_freq(String name_freq) {
		this.name_freq = name_freq;
	}
	public DateTime getDt_exec() {
		return dt_exec;
	}
	public void setDt_exec(DateTime dt_exec) {
		this.dt_exec = dt_exec;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public FDateTime getDt_effe() {
		return dt_effe;
	}
	public void setDt_effe(FDateTime dt_effe) {
		this.dt_effe = dt_effe;
	}
}
