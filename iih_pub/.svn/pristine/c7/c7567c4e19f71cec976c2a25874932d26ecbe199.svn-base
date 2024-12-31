package iih.ci.ord.copy.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
/**
 * 医嘱复制数据对象
 * @author zhangwq
 *
 */
public class OrderCopyDTO  extends BaseDTO{
	/**
	 * 成功标志
	 * @return
	 */
	public FBoolean getIsSuccess() {
		return ((FBoolean) getAttrVal("IsSuccess"));
	}
	/**
	 * 成功标志
	 * @param 真假值
	 */
	public void setIsSuccess(FBoolean IsSuccess) {
		setAttrVal("IsSuccess", IsSuccess);
	}
	/**
	 * 信息
	 * @return
	 */
	public String getMessageInfo() {
		return ((String) getAttrVal("MessageInfo"));
	}
	/**
	 * 信息
	 * @param 信息
	 */
	public void setMessageInfo(String MessageInfo) {
		setAttrVal("MessageInfo", MessageInfo);
	} 
	/**
	 * 医嘱
	 * @return CiOrderDO
	 */
	public CiOrderDO getCiOrderDO() {
		return ((CiOrderDO) getAttrVal("CiOrderDO"));
	}
	/**
	 * 医嘱
	 * @param CiOrderDO
	 */
	public void setCiOrderDO(CiOrderDO CiOrderDO) {
		setAttrVal("CiOrderDO", CiOrderDO);
	}
	/**
	 * 服务项目
	 * @return OrdSrvDO
	 */
	public List<OrdSrvDO> getOrdSrvDO() {
		return ((List<OrdSrvDO>) getAttrVal("OrdSrvDO"));
	}
	/**
	 * 服务项目
	 * @param OrdSrvDO
	 */
	public void setOrdSrvDO(List<OrdSrvDO> OrdSrvDO) {
		setAttrVal("OrdSrvDO", OrdSrvDO);
	}
	/**
	 * 医嘱服务服务套
	 * @return OrdSrvSetDO
	 */
	public List<OrdSrvSetDO> getOrdSrvSetDO() {
		return ((List<OrdSrvSetDO>) getAttrVal("OrdSrvSetDO"));
	}
	/**
	 * 医嘱服务服务套
	 * @param OrdSrvSetDO
	 */
	public void setOrdSrvSetDO(List<OrdSrvSetDO> OrdSrvSetDO) {
		setAttrVal("OrdSrvSetDO", OrdSrvSetDO);
	}
	/**
	 * 复制的源对象
	 * @return CiorderAggDO
	 */
	public CiorderAggDO getSourceCiorderAggDO() {
		return ((CiorderAggDO) getAttrVal("SourceCiorderAggDO"));
	}
	/**
	 * 复制的源对象
	 * @param CiorderAggDO
	 */
	public void setSourceCiorderAggDO(CiorderAggDO SourceCiorderAggDO) {
		setAttrVal("SourceCiorderAggDO", SourceCiorderAggDO);
	}
	/**
	 * OrdSrvDO 新旧主键键值对
	 * @return CiorderAggDO
	 */
	public Map<String,String> getMapIdorsrv() {
		return ((Map<String,String>) getAttrVal("MapIdorsrv"));
	}
	/**
	 * OrdSrvDO 新旧主键键值对
	 * @param HashMap<String,String>
	 */
	public void setMapIdorsrv(Map<String,String> MapIdorsrv) {
		setAttrVal("MapIdorsrv", MapIdorsrv);
	}

}
