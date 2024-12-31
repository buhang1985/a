package iih.ci.sdk.ems.meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱物品列表
 * 
 * @author wangqingzhu
 *
 */
public class OrderSrvMmList extends ArrayList<OrderSrvMmInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderSrvMmList() {
	}

	public OrderSrvMmList(List<OrderSrvMmInfo> ls) {
		this.addAll(ls);
	}

	public OrderSrvMmList(OrderSrvMmList ls) {
		this.addAll(ls);
	}

	public OrderSrvMmList(OrderSrvMmInfo[] szInfo) {
		this.addAll(Arrays.asList(szInfo));
	}

	public OrderSrvMmList(OrdSrvDO[] szInfo) {
		this.append(szInfo);
	}

	public OrderSrvMmList append(OrderSrvMmInfo[] szInfo) {
		if (null != szInfo && szInfo.length > 0) {
			this.addAll(Arrays.asList(szInfo));
		}
		return this;
	}

	public OrderSrvMmList append(OrderSrvMmList ls) {
		if (null != ls && ls.size() > 0) {
			this.addAll(ls);
		}
		return this;
	}

	/**
	 * 转化为对象数组
	 * 
	 * @return
	 */
	public OrderSrvMmInfo[] asArray() {
		return this.toArray(new OrderSrvMmInfo[size()]);
	}

	/**
	 * 获取医疗物品对象集合
	 * 
	 * @return
	 */
	public OrdSrvMmDO[] asOrdSrvMmArray() {
		List<OrdSrvMmDO> tmpMmList = new ArrayList<OrdSrvMmDO>();

		for (OrderSrvMmInfo srvMmInfo : this) {
			if (null != srvMmInfo.getOrderSrvMmInfo()) {
				tmpMmList.add(srvMmInfo.getOrderSrvMmInfo());
			}
		}

		return tmpMmList.size() == 0 ? null : tmpMmList.toArray(new OrdSrvMmDO[tmpMmList.size()]);
	}

	/**
	 * 获取医疗服务对象集合
	 * 
	 * @return
	 */
	public OrdSrvDO[] asOrdSrvArray() {
		List<OrdSrvDO> tmpMmList = new ArrayList<OrdSrvDO>();

		for (OrderSrvMmInfo srvMmInfo : this) {
			if (null != srvMmInfo.getOrderSrvInfo()) {
				tmpMmList.add(srvMmInfo.getOrderSrvInfo());
			}
		}

		return tmpMmList.size() == 0 ? null : tmpMmList.toArray(new OrdSrvDO[tmpMmList.size()]);
	}

	/**
	 * 获取服务id的集合
	 * 
	 * @return
	 */
	public String[] asSrvKeyArray() {
		StringList srvKeyList = new StringList();
		for (OrderSrvMmInfo srvMmInfo : this) {
			srvKeyList.add(srvMmInfo.getOrderSrvInfo().getId_srv());
		}

		return srvKeyList.asArray();
	}

	/**
	 * 追加医嘱服务集合
	 * 
	 * @param szInfo
	 * @return
	 */
	public OrderSrvMmList append(OrdSrvDO[] szInfo) {
		for (OrdSrvDO srvInfo : szInfo) {
			this.add(new OrderSrvMmInfo(srvInfo, null));
		}
		return this;
	}

	/**
	 * 设置逻辑删除标志
	 */
	public void logicDelete() {

		for (OrderSrvMmInfo srvMmInfo : this) {
			if (!ObjectUtils.isEmpty(srvMmInfo.getOrderSrvInfo())) {
				if (!ObjectUtils.isEmpty(srvMmInfo.getOrderSrvInfo().getId_orsrv())) {
					srvMmInfo.getOrderSrvInfo().setStatus(DOStatus.DELETED);
				}

				if (!ObjectUtils.isEmpty(srvMmInfo.getOrderSrvMmInfo())) {
					srvMmInfo.getOrderSrvMmInfo().setStatus(DOStatus.DELETED);
				}
			}
		}

	}

	public OrdSrvDO[] asOrderSrvArray() {
		OrderSrvList orderSrvInfoList = new OrderSrvList();

		for (OrderSrvMmInfo info : this) {
			orderSrvInfoList.add(info.getOrderSrvInfo());
		}
		return orderSrvInfoList.size() > 0 ? orderSrvInfoList.asArray() : null;
	}
	
	/**
	 * 临床项目转化为对象数组
	 * 
	 * @return
	 */
	public OrdSrvDO[] asOrderSrvArray_clinic() {
		OrderSrvList orderSrvInfoList = new OrderSrvList();
		for (OrderSrvMmInfo info : this) {
			if (FBoolean.TRUE.equals(info.getOrderSrvInfo().getFg_or())) {
				orderSrvInfoList.add(info.getOrderSrvInfo());
			}
		}
		return orderSrvInfoList.asArray();
	}

	public OrdSrvMmDO[] asOrderSrvMmArray() {
		List<OrdSrvMmDO> listOrdSrvMmDO = new ArrayList<OrdSrvMmDO>();
		for (OrderSrvMmInfo info : this) {
			if (!ObjectUtils.isEmpty(info.getOrderSrvMmInfo())) {
				listOrdSrvMmDO.add(info.getOrderSrvMmInfo());
			}
		}
		return listOrdSrvMmDO.size() > 0 ? listOrdSrvMmDO.toArray(new OrdSrvMmDO[listOrdSrvMmDO.size()]) : null;
	}
}
