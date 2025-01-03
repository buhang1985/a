package iih.ci.mi.ord.i.meta;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.FArrayList;

/**
 * 医保适应症医嘱参数
 * @author HUMS
 *
 */
public class OrdIndicParamDTO extends OrdMiBaseDTO {

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 医保适应症判断方式
	 * @return String
	 */
	public String getEu_hpjudge() {
		return ((String) getAttrVal("Eu_hpjudge"));
	}
	/**
	 * 医保适应症判断方式
	 * @param Eu_hpjudge
	 */
	public void setEu_hpjudge(String Eu_hpjudge) {
		setAttrVal("Eu_hpjudge", Eu_hpjudge);
	}
	
	/**
	 * 判断医嘱的医保判断结果
	 * @return String
	 */
	public String getEu_orhp() {
		return ((String) getAttrVal("Eu_orhp"));
	}
	/**
	 * 判断医嘱的医保判断结果
	 * @param Eu_orhp
	 */
	public void setEu_orhp(String Eu_orhp) {
		setAttrVal("Eu_orhp", Eu_orhp);
	}
	
	/**
	 * 医嘱来源方式类型
	 * @return String
	 */
	public String getEu_orsrcmdtp() {
		return ((String) getAttrVal("Eu_orsrcmdtp"));
	}	
	/**
	 * 医嘱来源方式类型
	 * @param Eu_orsrcmdtp
	 */
	public void setEu_orsrcmdtp(String Eu_orsrcmdtp) {
		setAttrVal("Eu_orsrcmdtp", Eu_orsrcmdtp);
	}
	
	/**
	 * 医保适应症校验参数-医嘱服务项目集合
	 * @return FArrayList
	 */
	public FArrayList getOrdSrvIndicParamFList() {
		return ((FArrayList) getAttrVal("OrdSrvIndicParamFList"));
	}
	/**
	 * 医保适应症校验参数-医嘱服务项目集合
	 * @param OrdSrvIndicParamFList
	 */
	public void setOrdSrvIndicParamFList(FArrayList OrdSrvIndicParamFList) {
		setAttrVal("OrdSrvIndicParamFList", OrdSrvIndicParamFList);
	}
	
	public List<OrdSrvIndicParamDTO> getOrdSrvIndicParamList(){
		
		List<OrdSrvIndicParamDTO> ordSrvList = new ArrayList<OrdSrvIndicParamDTO>();
		FArrayList ordSrvFList = ((FArrayList) getAttrVal("OrdSrvIndicParamFList"));
		
		if(ordSrvFList != null && ordSrvFList.size()>0){
			for(Object obj : ordSrvFList){
				OrdSrvIndicParamDTO ordSrv = (OrdSrvIndicParamDTO)obj;
				ordSrvList.add(ordSrv);
			}
		}
		
		return ordSrvList;
	}
	
	public void addChild(OrdSrvIndicParamDTO ordSrvIndicParam){
		FArrayList ordSrvFList = ((FArrayList) getAttrVal("OrdSrvIndicParamFList"));
		if(ordSrvFList == null){
			ordSrvFList = new FArrayList();
			this.setOrdSrvIndicParamFList(ordSrvFList);
		}
		ordSrvFList.add(ordSrvIndicParam);
	}
	
	/**
	 * 获取服务项目个数
	 * @return
	 */
	public int getChildSzie(){
		FArrayList ordSrvFList = ((FArrayList) getAttrVal("OrdSrvIndicParamFList"));
		if(ordSrvFList == null){
			return 0 ;
		}
		return ordSrvFList.size();
	} 

}
