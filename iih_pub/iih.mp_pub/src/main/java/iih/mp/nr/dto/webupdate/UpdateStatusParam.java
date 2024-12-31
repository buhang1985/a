package iih.mp.nr.dto.webupdate;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 更新医嘱状态入参
 * @Description:
 * @author: huang_junhao@founder.com.cn
 * @version：2019年5月21日 下午7:59:23 创建
 */
@XmlRootElement(name = "param")
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateStatusParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱编码
	 */
	private String code_or;
	
	/**
	 * 计划执行时间
	 */
	private String dt_mp_plan;

	/**
	 * 执行状态
	 */
	private String code_status;
	
	/**
	 * 执行人
	 */
	private String code_emp_exec;
	
	/**
	 * 执行科室
	 */
	private String code_dep_exec;
	
	/**
	 * 执行时间
	 */
	private String dt_exec;

	public String getCode_or() {
		return code_or;
	}

	public void setCode_or(String code_or) {
		this.code_or = code_or;
	}

	public String getDt_mp_plan() {
		return dt_mp_plan;
	}

	public void setDt_mp_plan(String dt_mp_plan) {
		this.dt_mp_plan = dt_mp_plan;
	}

	public String getCode_status() {
		return code_status;
	}

	public void setCode_status(String code_status) {
		this.code_status = code_status;
	}

	public String getCode_emp_exec() {
		return code_emp_exec;
	}

	public void setCode_emp_exec(String code_emp_exec) {
		this.code_emp_exec = code_emp_exec;
	}

	public String getCode_dep_exec() {
		return code_dep_exec;
	}

	public void setCode_dep_exec(String code_dep_exec) {
		this.code_dep_exec = code_dep_exec;
	}

	public String getDt_exec() {
		return dt_exec;
	}

	public void setDt_exec(String dt_exec) {
		this.dt_exec = dt_exec;
	}
}
