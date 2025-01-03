package iih.ci.mi.ord.i.meta;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.FArrayList;

public class OrdSpecillParamDTO extends  OrdMiBaseDTO{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 特殊病校验服务项目参数集合
	 * @return FArrayList
	 */
	public FArrayList getOrdSrvSpecillParamFList() {
		return ((FArrayList) getAttrVal("OrdSrvSpecillParamFList"));
	}
	/**
	 * 特殊病校验服务项目参数集合
	 * @param Ordsrvs
	 */
	public void setOrdSrvSpecillParamFList(FArrayList OrdSrvSpecillParamFList) {
		setAttrVal("OrdSrvSpecillParamFList", OrdSrvSpecillParamFList);
	}
	
	public List<OrdSrvSpecillParamDTO> getOrdSrvSpecillParamList() {
		
		List<OrdSrvSpecillParamDTO> ordSrvList = new ArrayList<OrdSrvSpecillParamDTO>();
		
		FArrayList ordSrvFList = ((FArrayList) getAttrVal("OrdSrvSpecillParamFList"));
		if(ordSrvFList == null || ordSrvFList.size() == 0){
			return ordSrvList;
		}
		for(Object obj : ordSrvFList){
			OrdSrvSpecillParamDTO ordSrv = (OrdSrvSpecillParamDTO)obj;
			ordSrvList.add(ordSrv);
		}
		
		return ordSrvList;
	}
	
	public void addChild(OrdSrvSpecillParamDTO ordSrv){
		
		FArrayList ordSrvFList = this.getOrdSrvSpecillParamFList();
		if(ordSrvFList == null ){
			ordSrvFList = new FArrayList();
			this.setOrdSrvSpecillParamFList(ordSrvFList);
		}
		ordSrvFList.add(ordSrv);
	}
	
	public int getChildSzie() {
		FArrayList ordSrvFist = this.getOrdSrvSpecillParamFList();

		if (ordSrvFist == null) {
			return 0;
		}
		return ordSrvFist.size();
	}
}
