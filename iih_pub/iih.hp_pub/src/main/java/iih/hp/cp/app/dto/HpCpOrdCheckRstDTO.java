package iih.hp.cp.app.dto;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

/**
 * 医嘱与径内医嘱匹配判定结果
 * @author HUMS
 *
 */
public class HpCpOrdCheckRstDTO extends BaseDTO{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱径内外判断结果
	 * CpOrderJudge 0：非径内医嘱，1：径内医嘱；2：匹配到径内已经执行数据；-1：路径无关联
	 * @return String
	 */
	public Integer getEu_uncporjudge() {
		return ((Integer) getAttrVal("Eu_uncporjudge"));
	}
	/**
	 * 医嘱径内外判断结果
	 * @param Eu_uncporjudge
	 */
	public void setEu_uncporjudge(Integer Eu_uncporjudge) {
		setAttrVal("Eu_uncporjudge", Eu_uncporjudge);
	}
	/**
	 * 医嘱径内外判断结果信息
	 * @return
	 */
	public String getJudge_msg() {
		return ((String) getAttrVal("Judge_msg"));
	}
	/**
	 * 医嘱径内外判断结果信息
	 * @param Judge_msg
	 */
	public void setJudge_msg(String Judge_msg) {
		setAttrVal("Judge_msg", Judge_msg);
	}
	/**
	 * 临床路径阶段名称
	 * @return
	 */
	public String getName_stage(){
		return ((String) getAttrVal("Name_stage"));
	}
	/**
	 * 医嘱径内外判断结果信息
	 * @param Name_stage
	 */
	public void setName_stage(String Name_stage){
		setAttrVal("Name_stage", Name_stage);
	}
	
	/**
	 * 匹配的医嘱服务项目
	 * @return String
	 */
	public FArrayList getHpCpOrdSrvs(){
		return ((FArrayList) getAttrVal("HpCpOrdSrvs"));
	}
	/**
	 * 匹配的医嘱服务项目
	 * @param HpCpOrdSrvs
	 */
	public void setHpCpOrdSrvs(FArrayList HpCpOrdSrvs) {
		setAttrVal("HpCpOrdSrvs", HpCpOrdSrvs);
	}

	/**
	 * 匹配的医嘱服务项目list集合
	 * @return
	 */
	public List<HpCpOrdSrvDTO> getHpCpOrdSrvList(){
		
		List<HpCpOrdSrvDTO> hpCprdSrvList = new ArrayList<HpCpOrdSrvDTO>();
		FArrayList hpCpAppOrdSrvs = getHpCpOrdSrvs();
		if(hpCpAppOrdSrvs != null){
			for(Object obj : hpCpAppOrdSrvs){
				HpCpOrdSrvDTO appOrdSrv = (HpCpOrdSrvDTO)obj;
				hpCprdSrvList.add(appOrdSrv);
			}
		}
		
		return  hpCprdSrvList;
	}

	/**
	 * 签署医嘱对象
	 * @return String
	 */
	public HpCpAppOrderDTO getHpCpAppOrder() {
		return ((HpCpAppOrderDTO) getAttrVal("HpCpAppOrder"));
	}
	/**
	 * 签署医嘱对象
	 * @param Eu_uncporjudge
	 */
	public void setHpCpAppOrder(HpCpAppOrderDTO HpCpAppOrder) {
		setAttrVal("HpCpAppOrder", HpCpAppOrder);
	}
}
