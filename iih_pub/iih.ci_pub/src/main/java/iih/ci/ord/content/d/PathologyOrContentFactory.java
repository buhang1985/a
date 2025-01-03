package iih.ci.ord.content.d;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class PathologyOrContentFactory  extends BaseCiOrContentFactory  implements CiOrContentObjFactory {

	@Override
	public CiOrContentDO create(CiEmsDTO ems) {
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0){
			return getNullContent(ems);
		}
		CiOrContentDO contentdo=new CiOrContentDO();
		String sd_srvtp = ((CiEmsSrvDTO)ems.getEmssrvs().get(0)).getSd_srvtp();
		if(sd_srvtp != null && sd_srvtp !=""){
			contentdo.setTypeId(sd_srvtp);
		}else{
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
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
		String total_pri = "0";
		String name_srvs="";
		for(int i=0;i <emssrvs.size();i++){
			
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			if( item != null ||item.getStatus() != DOStatus.DELETED && item.getFg_or().booleanValue()){
				boolean pri_flag = true;
				//name_srvs= ems.getName();
				if (FBoolean.TRUE.equals(item.getFg_self())) {
					name_srvs= ems.getName() +  "(自备)";
				} else {
					if(item.getSd_nodispense()!=null){
						if ("0".equals(item.getSd_nodispense())) {
							name_srvs= ems.getName() +"(自备)";
						}else if ("1".equals(item.getSd_nodispense())) {
							name_srvs= ems.getName() +"(嘱托)";
						}else if ("2".equals(item.getSd_nodispense())) {
							name_srvs= ems.getName() +"(外配)";
						}
						
					}else{
						name_srvs= ems.getName();
					}
					
				}
				//name_srvs+=(item.getName_srv()+" ");
				//医嘱内容拼接价格 by yzh 2017-11-30 13:53:36
				//DecimalFormat df = new DecimalFormat("#.00");
				if(item.getFg_set() != null && item.getFg_set().equals(FBoolean.TRUE)){
					if(item.getTotal_pri() != null){
						total_pri = item.getTotal_pri().compareTo(new FDouble("0"))<=0?"0":item.getTotal_pri().toString();
					}
					pri_flag = false;
				}else{
					if(pri_flag){
						if(item.getTotal_pri() != null){
							total_pri = item.getTotal_pri().compareTo(new FDouble("0"))<=0?"0":item.getTotal_pri().toString();
						}
					}
				}
				
			}	
		}

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
		arrList.add(strUrgent + name_srvs);
		
		if(this.getOrdsrvs()!=null){
			arrList.add(this.calPrice()+"元");
		}else{
			arrList.add(total_pri+"元");
		}
		
		arrList.add("");
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
		list.add("");
		return list;
	}
}
