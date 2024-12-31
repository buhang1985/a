package iih.mbh.en.patientlable.d;

import java.util.List;

import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 功能条件
 * 此模型请勿手动替换
 */
public class CondParamDTO{
	
	/** 功能编码 */
	private String fun_code;
	/** 功能名称 */
	private String name;
	/** 用法参数串 */
	private String code_params;
	/** 服务类型串 */
	private String sd_srvtps;
	/**皮试标记**/
	private FBoolean fg_skintest;
	/** 开始时间 */
	private FDateTime dt_begin;
	/** 结束时间 */
	private FDateTime dt_end;
	/** 左区间 */
	private Integer left;
	/** 右区间 */
	private Integer right;
	/** 用法集合 */
	private List<String> listroutes;
	/** 服务类型集合 */
	private List<String> listsrvtps;

	/** getter and setter */
	
	public String getFun_code(){
		return this.fun_code;
	}

	public void setFun_code(String fun_code){
		this.fun_code = fun_code;
	}
	
	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getCode_params(){
		return this.code_params;
	}

	public void setCode_params(String code_params){
		this.code_params = code_params;
	}
	
	public String getSd_srvtps(){
		return this.sd_srvtps;
	}

	public void setSd_srvtps(String sd_srvtps){
		this.sd_srvtps = sd_srvtps;
	}
	
	public FBoolean getFg_skintest(){
		return this.fg_skintest;
	}

	public void setFg_skintest(FBoolean fg_skintest){
		this.fg_skintest = fg_skintest;
	}
	
	public FDateTime getDt_begin(){
		return this.dt_begin;
	}

	public void setDt_begin(FDateTime dt_begin){
		this.dt_begin = dt_begin;
	}
	
	public FDateTime getDt_end(){
		return this.dt_end;
	}

	public void setDt_end(FDateTime dt_end){
		this.dt_end = dt_end;
	}
	
	public Integer getLeft(){
		return this.left;
	}

	public void setLeft(Integer left){
		this.left = left;
	}
	
	public Integer getRight(){
		return this.right;
	}

	public void setRight(Integer right){
		this.right = right;
	}
	
	public List<String> getListroutes(){
		return this.listroutes;
	}

	public void setListroutes(List<String> listroutes){
		this.listroutes = listroutes;
	}
	
	public List<String> getListsrvtps(){
		return this.listsrvtps;
	}

	public void setListsrvtps(List<String> listsrvtps){
		this.listsrvtps = listsrvtps;
	}
}