package iih.ci.mi.ord.i.meta;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.FArrayList;

/**
 * 
 * @author HUMS
 *
 */
public class OrdIndicRstDTO extends OrdMiBaseDTO{

	private static final long serialVersionUID = 1L;

	/**
	 * 临床医保适应症判定方式
	 * @return String
	 */
	public String getEu_hpjudge() {
		return ((String) getAttrVal("Eu_hpjudge"));
	}
	/**
	 * 临床医保适应症判定方式
	 * @param Eu_hpindicjudge
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
	 * 判断医嘱的医保判断结果
	 * @return String
	 */
	public FArrayList getOrdSrvIndicRstFList() {
		return ((FArrayList) getAttrVal("OrdSrvIndicRstFList"));
	}
	/**
	 * 判断医嘱的医保判断结果
	 * @param IndicOrdSrvRstFList
	 */
	public void setOrdSrvIndicRstFList(FArrayList OrdSrvIndicRstFList) {
		setAttrVal("OrdSrvIndicRstFList", OrdSrvIndicRstFList);
	}
	
	public void addChild(OrdSrvIndicRstDTO ordSrvIndicRst){
		FArrayList ordSrvFList = this.getOrdSrvIndicRstFList();
		if(ordSrvFList == null){
			ordSrvFList = new FArrayList();
			this.setOrdSrvIndicRstFList(ordSrvFList);
		}
		ordSrvFList.add(ordSrvIndicRst);
	}
	
	public List<OrdSrvIndicRstDTO> getOrdSrvIndicRstList(){
		
		List<OrdSrvIndicRstDTO> ordSrvList= new ArrayList<OrdSrvIndicRstDTO>();
		
		FArrayList indicOrdSrvRstFList = getOrdSrvIndicRstFList();
		
		if(indicOrdSrvRstFList != null){
			for(Object obj : indicOrdSrvRstFList){
				OrdSrvIndicRstDTO ordSrvRst = (OrdSrvIndicRstDTO)obj;
				ordSrvList.add(ordSrvRst);
			}
		}
		
		return ordSrvList;
	}
}
