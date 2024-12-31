package iih.ci.ord.content.d;

import java.util.ArrayList;

import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

public class BloodprodPrepareCiOrContentFactory  extends BaseCiOrContentFactory implements CiOrContentObjFactory {

	@Override
	public CiOrContentDO create(CiEmsDTO ems) {
		if (ems == null || ems.getEmssrvs() == null || ems.getEmssrvs().size() == 0) {
			return getNullContent(ems);
		}
		CiOrContentDO contentdo = new CiOrContentDO();
		contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_RISBINGLI);
		contentdo.setTitle(getTitle(ems));
		contentdo.setItemInfos(getItemInfos(ems));
		contentdo.setTailInfo(getTailInfos(ems));
		return contentdo;
	}

	/**
	 * 获得标题数据
	 * 
	 * @param ems
	 * @return
	 */
	private String getTitle(CiEmsDTO ems) {
		return "";
	}

	/**
	 * 获得表体数据
	 * 
	 * @param ems
	 * @return
	 */
	private ArrayList<ArrayList<String>> getItemInfos(CiEmsDTO ems) {
		if (ems == null || ems.getEmssrvs() == null)
			return null;
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		FArrayList emssrvs = ems.getEmssrvs();

		FMap map = ems.getOrapplysheet();

		CiorappbtAggDO aggdo = (CiorappbtAggDO) map.get(EmsType.BT + "");
		String str = "配";
		// 医嘱内容拼接价格 by yzh 2017-11-30 14:15:35
		String total_pri = "0";
		for (int i = 0; i < emssrvs.size(); i++) {
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			if (item.getStatus() == DOStatus.DELETED || (item.getFg_or() != null && !item.getFg_or().booleanValue()))
				continue;
			str += item.getName_srv();
			if(FBoolean.FALSE.equals(item.getFg_set())){
				 str +=item.getQuan_med()+ getName_unit_med(item.getName_unit_med());
			}
			if(item.getTotal_pri() != null){
				total_pri = item.getTotal_pri().toString();
			}
			
		}
		// str += +"ML";
		// 加急
		FBoolean fg_urgent = ems.getFg_urgent();
		ListenerUtils urgentRed = new ListenerUtils();
		if (fg_urgent != null && fg_urgent.booleanValue()) {
			// 0178579: 加急改为红色显示 liyue 2019-12-09
			if (urgentRed.GetXH_CIOR0005().booleanValue()) {
				str = "\\H01\\  加急！\\N\\" + "   " + str;
			} else {
				str = "  加急！" + "   " + str;// li_cheng 将“加急” 改成 “加急！”
			}
		}
		arrList.add(str);
		arrList.add("");
		arrList.add("");
		arrList.add(total_pri+"元");
		list.add(arrList);
		return list;
	}

	/**
	 * 获得表尾数据
	 * @param ems
	 * @return
	 */
	private ArrayList<String>  getTailInfos(CiEmsDTO ems){
		ArrayList<String> list = new ArrayList<String>();
		list.add(ems.getName_routedes());
		list.add("");
		return list;
	}
}
