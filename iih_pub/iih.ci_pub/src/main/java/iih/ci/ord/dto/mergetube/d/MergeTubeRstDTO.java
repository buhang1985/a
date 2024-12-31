package iih.ci.ord.dto.mergetube.d;

import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
/**
 * 合管后返回的结果
 * @author zhangwq
 * Time 20190426
 */
public class MergeTubeRstDTO extends BaseDTO{
	/**
	 * 医生判断状态，0，是；1，否
	 * @return String
	 */
	public String getDoctorOpt() {
		return ((String) getAttrVal("DoctorOpt"));
	}
	/**
	 * 医生判断状态，0，是；1，否
	 * @param DoctorOpt
	 */
	public void setDoctorOpt(String DoctorOpt) {
		setAttrVal("DoctorOpt", DoctorOpt);
	}
	/**
	 * 合管后的结果状态，0，正常；1，异常
	 * @return String
	 */
	public String getRstStatus() {
		return ((String) getAttrVal("RstStatus"));
	}
	/**
	 * 合管后的结果状态
	 * @param RstStatus
	 */
	public void setRstStatus(String RstStatus) {
		setAttrVal("RstStatus", RstStatus);
	}
	/**
	 * 已经存在的采集费用是全包含还是部分包含
	 * @return FBoolean
	 */
	public FBoolean getAllBeHave() {
		return ((FBoolean) getAttrVal("AllBeHave"));
	}
	/**
	 * 已经存在的采集费用是全包含还是部分包含
	 * @param AllBeHave
	 */
	public void setAllBeHave(FBoolean AllBeHave) {
		setAttrVal("AllBeHave", AllBeHave);
	}
	/**
	 * 已经存在的采集费,医嘱集合
	 * @return FArrayList
	 */
	public FArrayList getBeHasSampcolOrds() {
		return ((FArrayList) getAttrVal("BeHasSampcolOrds"));
	}
	/**
	 * 已经存在的采集费,医嘱集合
	 * @param BeHasSampcolOrds
	 */
	public void setBeHasSampcolOrds(FArrayList BeHasSampcolOrds) {
		setAttrVal("BeHasSampcolOrds", BeHasSampcolOrds);
	}
	/**
	 * 不存在的采集费,医嘱集合
	 * @return FArrayList
	 */
	public FArrayList getNotHasSampcolOrds() {
		return ((FArrayList) getAttrVal("NotHasSampcolOrds"));
	}
	/**
	 * 不存在的采集费,医嘱集合
	 * @param NotHasSampcolOrds
	 */
	public void setNotHasSampcolOrds(FArrayList NotHasSampcolOrds) {
		setAttrVal("NotHasSampcolOrds", NotHasSampcolOrds);
	}
	/**
	 * 容器费
	 * @return FMap
	 */
	public FMap getContpOrds() {
		return ((FMap) getAttrVal("ContpOrds"));
	}
	/**
	 * 容器费
	 * @param ContpOrds
	 */
	public void setContpOrds(FMap ContpOrds) {
		setAttrVal("ContpOrds", ContpOrds);
	}
	/**
	 * 生成的单据
	 * @return FArrayList
	 */
	public FArrayList getCiapplissheet() {
		return ((FArrayList) getAttrVal("Ciapplissheet"));
	}
	/**
	 * 生成的单据
	 * @param Ciapplissheet
	 */
	public void setCiapplissheet(FArrayList Ciapplissheet) {
		setAttrVal("Ciapplissheet", Ciapplissheet);
	}
	/**
	 * 新生成的医嘱主键集合
	 * @return List<CiOrderDO>
	 */
	public List<CiOrderDO> getNewCreateOrders() {
		return ((List<CiOrderDO>) getAttrVal("NewCreateOrders"));
	}
	/**
	 * 新生成的医嘱主键集合
	 * @param newCreateIdOrs
	 */
	public void setNewCreateOrders(List<CiOrderDO> NewCreateOrders) {
		setAttrVal("NewCreateOrders", NewCreateOrders);
	}
}
