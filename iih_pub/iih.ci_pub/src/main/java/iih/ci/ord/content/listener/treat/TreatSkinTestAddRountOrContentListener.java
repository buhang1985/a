package iih.ci.ord.content.listener.treat;

import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.StringUtils;
import iih.ci.ord.content.d.GetSrvExecDose;
import iih.ci.ord.content.d.ICiOrContentConst;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
/**
 * @code 治疗显示用法  (0186801)
 * @author LiYue
 * @date 2020年3月16日,下午5:16:20
 */
public class TreatSkinTestAddRountOrContentListener extends BaseTreatSkinTestOrdContentBListener {

	private String ismuldose;
	private String ismulexec;
	public TreatSkinTestAddRountOrContentListener() {
		String string = "";
		System.out.println(string);
	}
	public void create() throws BizException {
		if(this.getCiEmsDTO()==null || this.getCiEmsDTO().getEmssrvs()==null || this.getCiEmsDTO().getEmssrvs().size()==0){
			return;
		}
		String sd_srvtp = ((CiEmsSrvDTO)this.getCiEmsDTO().getEmssrvs().get(0)).getSd_srvtp();
		if(sd_srvtp != null && sd_srvtp !=""){
			this.getContentdo().setTypeId(sd_srvtp);
		}else{
			this.getContentdo().setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		
		List<String> lst = GetSrvExecDose.exec(this.getCiEmsDTO().getId_srv());
		ismuldose = lst.get(0);
		ismulexec = lst.get(1);
		this.getContentdo().setTitle(getTitle(this.getCiEmsDTO()));
		this.getContentdo().setItemInfos(getItemInfos(this.getCiEmsDTO()));
		this.getContentdo().setTailInfo(getTailInfos(this.getCiEmsDTO()));
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
	 * @throws DAException 
	 */
	protected ArrayList<ArrayList<String>>  getItemInfos(CiEmsDTO ems){
		if(ems == null || ems.getEmssrvs() == null) return null;
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		FArrayList emssrvs = ems.getEmssrvs();
		
		CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(0);
		String StrName = item.getName_srv();
		if( !StringUtils.isNullOrEmpty( ems.getName_route())) {
			StrName+=" ("+ems.getName_route()+")";
		}
		if( !StringUtils.isNullOrEmpty( ems.getNote())) {
			StrName+=" ("+ems.getNote()+")";
		}
		//加急
		String strUrgent = "";
		FBoolean fg_urgent = ems.getFg_urgent();
		ListenerUtils urgentRed = new ListenerUtils();
		if(fg_urgent != null && fg_urgent.booleanValue()){
			// 0178579: 加急改为红色显示  liyue 2019-12-09
			if(urgentRed.GetXH_CIOR0005().booleanValue()) {
				strUrgent = "\\H01\\加急！\\N\\   ";
			}else {
				strUrgent = "加急！   ";//li_cheng  将“加急” 改成  “加急！”   
			}
		}
		arrList.add(strUrgent + StrName);
		
		if (ismuldose != null && ismuldose.equals("Y")) {
			arrList.add((ems.getQuan_medu() == null) ? "" : ems.getQuan_medu().toString());
			arrList.add((ems.getName_unit_med() == null) ? "" : (this.IsNumberic(ems.getName_unit_med().substring(0, 1))?("*"+ems.getName_unit_med()):ems.getName_unit_med()));
		}else{
			arrList.add("");
			arrList.add("");
		}
		String total_pri = "0元";
		if(this.getOrdsrvs()!=null &&  !"0.00".equals(this.calPrice())){
			arrList.add(this.calPrice()+"元");
		}else{
			arrList.add(total_pri);
		}
		list.add(arrList);
		return list;
	}
	
	/**
	 * 获得表尾数据
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	protected ArrayList<String>  getTailInfos(CiEmsDTO ems) throws BizException{
		ArrayList<String> list = new ArrayList<String>();
//		list.add(ems.getName_routedes() == null ? "" : ems.getName_routedes());
		String freq_name = "";
		String days = "";
		if (ismulexec != null && ismulexec.equals("Y")) {
			freq_name=getFreqName(ems.getId_freq());
			freq_name = (freq_name == null) ? "" : freq_name.toString();
			days = (ems.getDays_or() == null) ? "" : "" + ems.getDays_or().toString() + "天";
		}
		list.add(freq_name);
		list.add(days);
		list.add("");
		return list;
	}
	/**
	 * 频次
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	public static String getFreqName(String id_freq)throws BizException{
	    String name = "";
	    if(id_freq==null||id_freq=="") {
		    return null;
	    }
	    StringBuffer sqlsb = new StringBuffer();
	    sqlsb.append(" select name from  bd_freq ");
	    sqlsb.append("  where id_freq = '"+id_freq+"'");
        List<String> list = (List<String>)(new DAFacade()).execQuery(sqlsb.toString(),  new ColumnListHandler());
	    if(list != null && list.size() > 0) {
	    	name = list.get(0);
	    }
        return name;
	}
	
}
