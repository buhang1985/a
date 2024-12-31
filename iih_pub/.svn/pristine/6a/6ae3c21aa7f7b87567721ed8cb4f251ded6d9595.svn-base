package iih.ci.mi.ord.i.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.FArrayList;

/**
 * 医嘱特殊病校验结果
 * @author HUMS
 *
 */
public class OrdSpecillRstDTO extends OrdMiBaseDTO{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 特殊病校验服务项目参数集合
	 * @return FArrayList
	 */
	public FArrayList getOrdSrvSpecillRstFList() {
		return ((FArrayList) getAttrVal("OrdSrvSpecillRstFList"));
	}
	/**
	 * 特殊病校验服务项目参数集合
	 * @param Ordsrvs
	 */
	public void setOrdSrvSpecillRstFList(FArrayList OrdSrvSpecillRstFList) {
		setAttrVal("OrdSrvSpecillRstFList", OrdSrvSpecillRstFList);
	}
	
	public List<OrdSrvSpecillRstDTO> getOrdSrvSpecillRstList() {
		
		List<OrdSrvSpecillRstDTO> ordSrvList = new ArrayList<OrdSrvSpecillRstDTO>();
		
		FArrayList ordSrvFList = ((FArrayList) getAttrVal("OrdSrvSpecillRstFList"));
		if(ordSrvFList == null || ordSrvFList.size() == 0){
			return ordSrvList;
		}
		for(Object obj : ordSrvFList){
			OrdSrvSpecillRstDTO ordSrv = (OrdSrvSpecillRstDTO)obj;
			ordSrvList.add(ordSrv);
		}
		
		return ordSrvList;
	}
	
	public Map<String, OrdSrvSpecillRstDTO> getOrdSrvSpecillRstMap() {
		
		Map<String, OrdSrvSpecillRstDTO> ordSrvMmMap = new HashMap<String, OrdSrvSpecillRstDTO>();
		
		FArrayList ordSrvFList = ((FArrayList) getAttrVal("OrdSrvSpecillRstFList"));
		if(ordSrvFList == null || ordSrvFList.size() == 0){
			return ordSrvMmMap;
		}
		for(Object obj : ordSrvFList){
			OrdSrvSpecillRstDTO ordSrv = (OrdSrvSpecillRstDTO)obj;
			ordSrvMmMap.put(ordSrv.getKey(), ordSrv);
		}
		
		return ordSrvMmMap;
	}
	
	/**
	 * 追加子节点
	 * @param ordSrv
	 */
	public void addChild(OrdSrvSpecillRstDTO ordSrv){
		
		FArrayList ordSrvFList = this.getOrdSrvSpecillRstFList();
		if(ordSrvFList == null ){
			ordSrvFList = new FArrayList();
			this.setOrdSrvSpecillRstFList(ordSrvFList);
		}
		ordSrvFList.add(ordSrv);
	}

}
