package iih.ci.ord.content.d;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;

public class NurseNsgreedCiOrContentFactory extends BaseCiOrContentFactory {
	
	@Override
	public CiOrContentDO create(CiEmsDTO ems) {
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0){
			return getNullContent(ems);
		}
		CiOrContentDO contentdo=new CiOrContentDO();
		contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_NURSENSGREED);
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
		FDouble total_pri = new FDouble("0");
		for(int i=0;i <emssrvs.size();i++){
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			if(item.getStatus() == DOStatus.DELETED || !item.getFg_or().booleanValue())continue;
			arrList.add(item.getName_srv());
			//医嘱内容拼接价格 by yzh 2017-11-30 14:32:08
			total_pri = total_pri.add(item.getTotal_pri()==null?new FDouble("0"):item.getTotal_pri());
			/*arrList.add(item.getName_route());  
			arrList.add(item.getName_routedes());*/
		}
		arrList.add(total_pri+"");
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
		StringBuffer quanMeduStr = new StringBuffer();
		StringBuffer note = new StringBuffer();
		//频次为非持续或者非once的需要把频次和用量拼接在医嘱内容中
		/*if(ems.getId_freq()!=null&&(!ems.getId_freq().equals(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ALWAYS)
				&&!ems.getId_freq().equals(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE))){
			quanMeduStr = ems.getQuan_medu()+ems.getName_unit_med()+"，"+ems.getName_freq()+"，"+ems.getName_route();
		}
		*/
		if(ems.getQuan_medu()!=null&&ems.getName_unit_med()!=null){
			quanMeduStr.append(ems.getQuan_medu()+ems.getName_unit_med());
		}
		this.assemble(quanMeduStr, ems.getName_freq());
		this.assemble(quanMeduStr, ems.getName_route());
		
		if(!StringUtils.isEmpty(ems.getDes_or())){
			note.append(ems.getDes_or());
		}else if(!StringUtils.isEmpty(ems.getNote())){
			note.append(ems.getNote());
		}
		StringBuffer sb = new StringBuffer();
		 sb.append(quanMeduStr);
		if(sb.length()==0){
			sb.append(note);
		}else if(!StringUtils.isEmpty(note)){
			sb.append(","+note);
		}
		list.add(sb.toString());
		return list;
	}
}

