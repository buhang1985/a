package iih.ci.ord.content.d;

import java.util.ArrayList;

import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;

public class BloodProdUseCiOrContentFactory  extends BaseCiOrContentFactory implements CiOrContentObjFactory {

	@Override
	public CiOrContentDO create(CiEmsDTO ems) {
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0){
			return getNullContent(ems);
		}
		CiOrContentDO contentdo=new CiOrContentDO();
		contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		contentdo.setTitle(getTitle(ems));
		contentdo.setItemInfos(getItemInfos(ems));
		contentdo.setTailInfo(getTailInfos(ems));
		return contentdo;
	}
	
	/**
	 * 获得标题数据
	 * @param ems
	 * @return
	 */
	private String getTitle(CiEmsDTO ems){
		return "";
	}
	
	/**
	 * 获得表体数据
	 * @param ems
	 * @return
	 */
	private ArrayList<ArrayList<String>>  getItemInfos(CiEmsDTO ems){
		if(ems == null || ems.getEmssrvs() == null) return null;
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		FArrayList emssrvs = ems.getEmssrvs();
		FMap  map = ems.getOrapplysheet();
		OrdAppBtUseDO userDO =  (OrdAppBtUseDO)map.get(EmsType.BTUSE+"");
		ListenerUtils urgentRed = new ListenerUtils();
		String strUrgent = "";
		if (ems.getFg_urgent() != null && ems.getFg_urgent().booleanValue()) {
			// 0178579: 加急改为红色显示 liyue 2019-12-09
			if (urgentRed.GetXH_CIOR0005().booleanValue()) {
				strUrgent = "\\H01\\加急！\\N\\   ";
			} else {
				strUrgent = "加急！   ";
			}
		}
		for(int i=0;i <emssrvs.size();i++){
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			if(item.getStatus() == DOStatus.DELETED || !item.getFg_or().booleanValue())continue;
			arrList.add(strUrgent+"输"+item.getName_srv()+item.getQuan_med().toDouble()+getName_unit_med(item.getName_unit_med()));
			//医嘱内容拼接价格 by yzh 2017-11-30 14:13:06
			if(item.getTotal_pri() != null){
				arrList.add(item.getTotal_pri().toString()+"元");
			}else{
				arrList.add("0元");
			}
			//arrList.add(item.getQuan_med().toDouble()+""); //todo 
			//arrList.add(item.getName_unit_med());
		}
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
		list.add(ICiOrContentConst.ChangeToEscapeCharacter(ems.getName_routedes()));
		list.add("");
		return list;
	}
}

