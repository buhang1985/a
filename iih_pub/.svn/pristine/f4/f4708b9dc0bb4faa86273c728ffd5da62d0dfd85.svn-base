package iih.ci.ord.i.external.obtain.meta.hp;

import org.apache.commons.lang3.StringUtils;

import iih.bd.pp.srvctrdi.d.BdHpSrvCtrDiDO;
import iih.ci.ord.i.common.b.BaseXapJsonSerialization;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床医调用费用进行医保校验返回结果
 * 
 * @author HUMS
 *
 */
public class HpVerifyRstDTO extends BaseXapJsonSerialization {

	private static final long serialVersionUID = 1L;

	// 获取医保目录类型key值，id_srv+id_mm
	public String getKey() {
		
		return this.getId_srv() + StringUtils.trimToEmpty(this.getId_mm());
	}

	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}

	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}

	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}

	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}

	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}

	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}

	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}

	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}

	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}

	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}

	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}

	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}

	public String getEu_hpsrvctrtp() {
		return ((String) getAttrVal("Eu_hpsrvctrtp"));
	}

	public void setEu_hpsrvctrtp(String Eu_hpsrvctrtp) {
		setAttrVal("Eu_hpsrvctrtp", Eu_hpsrvctrtp);
	}

	public FBoolean getFg_indic() {
		return ((FBoolean) getAttrVal("Fg_indic"));
	}

	public void setFg_indic(FBoolean Fg_indic) {
		setAttrVal("Fg_indic", Fg_indic);
	}

	/**
	 * 医保限制条件
	 * @return
	 */
	public String getDes_dilimit() {
		//return ((String) getAttrVal("Des_dilimit"));
		
		String des_dilimit = ((String) getAttrVal("Des_dilimit"));
		
		StringBuffer desBuffer = new StringBuffer();
		
		if(StringUtils.isNotEmpty(des_dilimit)){
			
			desBuffer.append(des_dilimit);
			
			if(this.getHpSrvCtrDiList() != null && this.getHpSrvCtrDiList().size() > 0){
				desBuffer.append("缺少诊断 ：");
				
				FArrayList hpSrvCtrDiList = this.getHpSrvCtrDiList();
				for(int i = 0;i<hpSrvCtrDiList.size();i++){
					BdHpSrvCtrDiDO dido  =  (BdHpSrvCtrDiDO)hpSrvCtrDiList.get(i);
					desBuffer.append(dido.getDi_def_name()).append("["+dido.getDi_def_code()+"]；").append(" ");
				}
			}
		}
		
		return desBuffer.toString();
	}

	/**
	 * 诊断限制提示信息
	 * @param Des_dilimit
	 */
	public void setDes_dilimit(String Des_dilimit) {		
		setAttrVal("Des_dilimit", Des_dilimit);
	}

	public String getDes_hislimit() {
		return ((String) getAttrVal("Des_hislimit"));
	}

	public void setDes_hislimit(String Des_hislimit) {
		setAttrVal("Des_hislimit", Des_hislimit);
	}

	public String getDes_hplimit() {
		return ((String) getAttrVal("Des_hplimit"));
	}

	public void setDes_hplimit(String Des_hplimit) {
		setAttrVal("Des_hplimit", Des_hplimit);
	}
	
	/**
	 * 获取医保限定诊断集合
	 * (BdHpSrvCtrDiDO对象集合)
	 * @return
	 */
	public FArrayList getHpSrvCtrDiList(){
		return ((FArrayList)getAttrVal("Hpsrvctrdi_list"));
	}
	/**
	 * 设置医保限定诊断集合(BdHpSrvCtrDiDO对象集合)
	 * @param mutiPayRatioList
	 */
	public void setHpSrvCtrDiList(FArrayList hpSrvCtrDiList){
		setAttrVal("Hpsrvctrdi_list",hpSrvCtrDiList);
	}

}
