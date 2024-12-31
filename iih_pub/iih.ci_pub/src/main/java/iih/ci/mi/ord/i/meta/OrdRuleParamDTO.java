package iih.ci.mi.ord.i.meta;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;

public class OrdRuleParamDTO extends OrdMiBaseDTO{
	
	
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
	 * 医嘱天数
	 * @return Integer
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}	
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}	
	/**
	 * 医嘱付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 医嘱生效日期
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	/**
	 * 医嘱生效日期
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	
	/**
	 * 医嘱服务项目
	 * @return FArrayList
	 */
	public FArrayList getOrdSrvRuleParamFList() {
		return ((FArrayList) getAttrVal("OrdSrvRuleParamFList"));
	}	
	/**
	 * 医嘱服务项目
	 * @param OrdSrvMiRuleParamFList
	 */
	public void setOrdSrvRuleParamFList(FArrayList OrdSrvRuleParamFList) {
		setAttrVal("OrdSrvRuleParamFList", OrdSrvRuleParamFList);
	}
	
	public void addChild(OrdSrvRuleParamDTO ordSrvRuleParam){
		FArrayList ordSrvFList = ((FArrayList) getAttrVal("OrdSrvRuleParamFList"));
		if(ordSrvFList == null){
			ordSrvFList = new FArrayList();
			this.setOrdSrvRuleParamFList(ordSrvFList);
		}
		ordSrvFList.add(ordSrvRuleParam);
	}
	
	/**
	 * 医嘱服务项目
	 * @return List<OrdSrvMiRuleParamDTO>
	 */
	public List<OrdSrvRuleParamDTO> getOrdSrvRuleParamList() {
		
		List<OrdSrvRuleParamDTO> ordSrvList = new ArrayList<OrdSrvRuleParamDTO>();
		FArrayList ordSrvFist = ((FArrayList) getAttrVal("OrdSrvRuleParamFList"));
		
		if(ordSrvFist != null && ordSrvFist.size() >0){
			
			for(Object obj : ordSrvFist){
				OrdSrvRuleParamDTO ordSrv = (OrdSrvRuleParamDTO)obj;
				ordSrvList.add(ordSrv);
			}
		}
		
		return ordSrvList;
	}

	public int getChildSzie() {
		FArrayList ordSrvFist = ((FArrayList) getAttrVal("OrdSrvRuleParamFList"));

		if (ordSrvFist == null) {
			return 0;
		}
		return ordSrvFist.size();
	}

}
