package iih.sc.sch.dto.d;

import java.util.ArrayList;
import java.util.List;

import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchEmpDO;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
/**
 * 排班生成结果
 * @author yank
 *
 */
public class PlanGenResult {
	//需删除的排班key集合
	private List<SchKey> willDelSchKeyList;
	//排班信息
	private List<ScSchDO> schDOList; 
	//排班渠道
	private List<ScSchChlDO> schChlDOList;
	//排班人员
	private List<ScSchEmpDO> schEmpDOList;
	//排班就诊
	private List<ScSchEnDO> schEnDOList;
	//排班号段
	private List<ScSchTicksDO> schTicksDOList;
	//排班号位
	private List<ScSchTickDO> schTickDOList;
	//排班服务 
	private List<ScSchOptsrvDO> scSchOptsrvDOList;
	/**
	 * 构造函数
	 */
	public PlanGenResult(){
		this.willDelSchKeyList = new ArrayList<SchKey>();
		this.schDOList=new ArrayList<ScSchDO>();
		this.schChlDOList = new ArrayList<ScSchChlDO>();
		this.schEnDOList = new ArrayList<ScSchEnDO>();
		this.schEmpDOList = new ArrayList<ScSchEmpDO>();
		this.schTicksDOList = new ArrayList<ScSchTicksDO>();
		this.schTickDOList = new ArrayList<ScSchTickDO>();
		this.scSchOptsrvDOList = new ArrayList<ScSchOptsrvDO>();
	}
	
	/**
	 * 添加
	 * @param result 结果对象
	 */
	public void append(PlanGenResult result){
		if(result==null)return;
		
		this.willDelSchKeyList.addAll(result.getWillDelSchKeyList());
		this.schDOList.addAll(result.getSchDOList());
		this.schChlDOList.addAll(result.getSchChlDOList());
		this.schEnDOList.addAll(result.getSchEnDOList());
		this.schEmpDOList.addAll(result.getSchEmpDOList());
		this.schTicksDOList.addAll(result.getSchTicksDOList());
		this.schTickDOList.addAll(result.getSchTickDOList());
		this.scSchOptsrvDOList.addAll(result.getscSchOptsrvDOList());
	}
	public List<SchKey> getWillDelSchKeyList() {
		return willDelSchKeyList;
	}

	public void setWillDelSchKeyList(List<SchKey> willDelSchKeyList) {
		this.willDelSchKeyList = willDelSchKeyList;
	}
	/**
	 * @return the schDOList
	 */
	public List<ScSchDO> getSchDOList() {
		return schDOList;
	}
	/**
	 * @param schDOList the schDOList to set
	 */
	public void setSchDOList(List<ScSchDO> schDOList) {
		this.schDOList = schDOList;
	}
	/**
	 * @return the schChlDOList
	 */
	public List<ScSchChlDO> getSchChlDOList() {
		return schChlDOList;
	}
	/**
	 * @param schChlDOList the schChlDOList to set
	 */
	public void setSchChlDOList(List<ScSchChlDO> schChlDOList) {
		this.schChlDOList = schChlDOList;
	}
	/**
	 * @return the schEmpDOList
	 */
	public List<ScSchEmpDO> getSchEmpDOList() {
		return schEmpDOList;
	}
	/**
	 * @param schEmpDOList the schEmpDOList to set
	 */
	public void setSchEmpDOList(List<ScSchEmpDO> schEmpDOList) {
		this.schEmpDOList = schEmpDOList;
	}
	/**
	 * @return the schEnDOList
	 */
	public List<ScSchEnDO> getSchEnDOList() {
		return schEnDOList;
	}
	/**
	 * @param schEnDOList the schEnDOList to set
	 */
	public void setSchEnDOList(List<ScSchEnDO> schEnDOList) {
		this.schEnDOList = schEnDOList;
	}
	/**
	 * @return the schTicksDOList
	 */
	public List<ScSchTicksDO> getSchTicksDOList() {
		return schTicksDOList;
	}
	/**
	 * @param schTicksDOList the schTicksDOList to set
	 */
	public void setSchTicksDOList(List<ScSchTicksDO> schTicksDOList) {
		this.schTicksDOList = schTicksDOList;
	}
	/**
	 * @return the schTickDOList
	 */
	public List<ScSchTickDO> getSchTickDOList() {
		return schTickDOList;
	}
	/**
	 * @param schTickDOList the schTickDOList to set
	 */
	public void setSchTickDOList(List<ScSchTickDO> schTickDOList) {
		this.schTickDOList = schTickDOList;
	}
	public List<ScSchOptsrvDO> getscSchOptsrvDOList() {
		return scSchOptsrvDOList;
	}
	public void setscSchOptsrvDOList(List<ScSchOptsrvDO> scSchOptsrvDOList) {
		this.scSchOptsrvDOList = scSchOptsrvDOList;
	}
}
