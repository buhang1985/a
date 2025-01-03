package iih.ci.ord.content.listener.treat;

import java.util.ArrayList;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.content.d.ICiOrContentConst;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;

/**
 * 医嘱内容生成皮试类生成工厂(多次执行，多剂量显示频次剂量)
 */
public class TreatSkinTestOrContentListener extends BaseTreatSkinTestOrdContentBListener {

	/**
	 * 获得表体数据
	 * @param ems
	 * @return
	 * @throws DAException 
	 */
	protected ArrayList<ArrayList<String>>  getItemInfos(CiEmsDTO ems) {
		if(ems == null || ems.getEmssrvs() == null) return null;
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		FArrayList emssrvs = ems.getEmssrvs();

		//加急标志
		String strUrgent = "";
		FBoolean fg_urgent = ems.getFg_urgent();
		ListenerUtils urgentRed = new ListenerUtils();
		if(fg_urgent != null && fg_urgent.booleanValue()){
			// 0178579: 加急改为红色显示  liyue 2019-12-09
			if(urgentRed.GetXH_CIOR0005().booleanValue()) {
				strUrgent = "\\H01\\   加急！\\N\\   ";
			}else {
				strUrgent = "加急！   ";//li_cheng  将“加急” 改成  “加急！”   
			}
		}
		CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(0);
		if( StringUtils.isNullOrEmpty( ems.getNote())) {
			arrList.add(strUrgent + item.getName_srv());
		}else {
			arrList.add(strUrgent + item.getName_srv()+"  ("+ems.getNote()+")");
		}
		String Quan_medu = (ems.getQuan_medu() == null) ? "" : ems.getQuan_medu().toString();
		String Name_unit_med = (ems.getName_unit_med() == null) ? "" : (this.IsNumberic(ems.getName_unit_med().substring(0, 1))?("*"+ems.getName_unit_med()):ems.getName_unit_med());
		arrList.add((Quan_medu+Name_unit_med));
		list.add(arrList);
		return list;
	}
	
	/**
	 * 获得表尾数据
	 * @param ems
	 * @return
	 */
	protected ArrayList<String>  getTailInfos(CiEmsDTO ems){
		ArrayList<String> list = new ArrayList<String>();
		String note = "";
		String freq_name = "";
		String days = "";
		note = ICiOrContentConst.ChangeToEscapeCharacter(this.getCiEmsDTO().getNote());
		freq_name = (ems.getName_freq() == null) ? "" : ems.getName_freq().toString();
		days = (ems.getDays_or() == null) ? "" : "" + ems.getDays_or().toString() + "天";
		
		list.add(freq_name);
		list.add(days);
		list.add("");
		return list;
	}

	
	protected StringBuffer assemble(StringBuffer sb,String str){
		if(StringUtils.isNullOrEmpty(str)){
			return sb;
		}
		sb.append(sb.length()==0?str:"，"+str);
		return sb;
	}
}
