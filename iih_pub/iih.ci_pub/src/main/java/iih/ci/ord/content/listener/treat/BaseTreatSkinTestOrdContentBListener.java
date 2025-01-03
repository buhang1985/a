package iih.ci.ord.content.listener.treat;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.d.ICiOrContentConst;
import iih.ci.ord.content.listener.base.BaseOrContentListener;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.jdbc.facade.DAException;
/**
 * 诊疗类，皮试类医嘱内容拼接基类监听，所有客开医嘱内容，都需要继承这个基类
 * @author liyue
 *
 */
public class BaseTreatSkinTestOrdContentBListener extends BaseOrContentListener {
	private String ismuldose;
	private String ismulexec;
	
	public void doAction(IBusinessEvent event) throws BizException {
		if(!(SourceIdConst.SourceId_TreatSkinTestOrdContent.equals(event.getSourceID())&&IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){
			return;
		}
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(ArrayUtils.isEmpty(newObjs))return;
		this.setContentdo((CiOrContentDO)newObjs[0]);
		this.setCiEmsDTO((CiEmsDTO)newObjs[1]);
		this.setOrdsrvs((OrdSrvDO[])newObjs[2]);
		doYourAction(event);
	}
	/**
	 * 处理自己的业务
	 * @param event
	 * @throws BizException
	 */
	@Override
	public void doYourAction(IBusinessEvent event) throws BizException {
		create();
	}
	public void create() throws BizException {
		if(this.getCiEmsDTO()==null || this.getCiEmsDTO().getEmssrvs()==null || this.getCiEmsDTO().getEmssrvs().size()==0){
			return;
		}
		String sd_srvtp = ((CiEmsSrvDTO)this.getCiEmsDTO().getEmssrvs().get(0)).getSd_srvtp();
		if(sd_srvtp != null && sd_srvtp !=""){
			this.getContentdo().setTypeId(getSrvtpl(sd_srvtp));
		}else{
			this.getContentdo().setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		this.getContentdo().setTitle(getTitle(this.getCiEmsDTO()));
		this.getContentdo().setItemInfos(getItemInfos(this.getCiEmsDTO()));
		this.getContentdo().setTailInfo(getTailInfos(this.getCiEmsDTO()));
	}
	
	//服务分类
	protected String getSrvtpl(String sd_srvtp) {
		return sd_srvtp;
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
	protected ArrayList<ArrayList<String>>  getItemInfos(CiEmsDTO ems) throws BizException{
		if(ems == null || ems.getEmssrvs() == null) return null;
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		FArrayList emssrvs = ems.getEmssrvs();
		FBoolean fg_urgent = ems.getFg_urgent();
		String strUrgent = "";
		if(fg_urgent != null && fg_urgent.booleanValue()){
			strUrgent = "加急！   ";
		}
	
		CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(0);
		if( StringUtils.isEmpty( ems.getNote())) {
			arrList.add(strUrgent + item.getName_srv());
		}else {
			arrList.add(strUrgent + item.getName_srv()+"  ("+ems.getNote()+")");
		}
		
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
	 */
	protected ArrayList<String>  getTailInfos(CiEmsDTO ems)throws BizException{
		ArrayList<String> list = new ArrayList<String>();
		String freq_name = "";
		String days = "";
		if (ismulexec != null && ismulexec.equals("Y")) {
			freq_name = (ems.getName_freq() == null) ? "" : ems.getName_freq().toString();
			days = (ems.getDays_or() == null) ? "" : "" + ems.getDays_or().toString() + "天";
		}
		list.add(freq_name);
		list.add(days);
		list.add("");
		return list;
	}

	
}
