package iih.ci.ord.content.listener.drugs;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.d.ICiOrContentConst;
import iih.ci.ord.content.listener.base.BaseOrContentListener;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.content.listener.base.dto.DrugsOrdContentDTO;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;
/**
 * 药品医嘱内容拼接基类监听，所有客开医嘱内容，都需要继承这个基类
 * @author zhangwq
 *
 */
public class DrugsOrdContentListener extends BaseOrContentListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if(!(SourceIdConst.SourceId_DrugsOrdContent.equals(event.getSourceID())&&IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){
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
	 * @throws BizException 
	 */
	protected ArrayList<ArrayList<String>>  getItemInfos(CiEmsDTO ems) throws BizException{
		
		if(ems == null || this.getCiEmsDTO().getEmssrvs() == null) return null;
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		String Quan_total_medu = "";
		FArrayList emssrvs = this.getCiEmsDTO().getEmssrvs();
		//查询药品基本范围 为拼接做准备
		List<DrugsOrdContentDTO> baseDrugRanges = getDrugsOrdContent(emssrvs);
		
		//指定数字格式保留两位小数
		DecimalFormat df = new DecimalFormat("0.00");
		DecimalFormat df2 = new DecimalFormat("0.00000000");
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
		for(int i=0;i <emssrvs.size();i++){
			ArrayList<String> arrList = new ArrayList<String>();
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			if (item.getStatus() == DOStatus.DELETED)
				continue;
			// 删除的 用的不做医嘱内容拼接
			if (item != null && item.getStatus() != DOStatus.DELETED && item.getFg_or() != null
					&& item.getFg_or().booleanValue()) {
				//BY GH 高危药品标识：判断  如果为高危药品  添加红色“高危”二字在名称前
				String highName = "";
				if(FBoolean.TRUE.equals(item.getFg_highrisk())){
					highName+="\\H01\\高危\\N\\";
				}
				// liyue 0176581: 住院医生站开出来医嘱以后需要在最前面显示红色的（基）【南大高新】【何思润】
				String displayName = "";
				if(!StringUtils.isEmpty(item.getId_mm())) {
					for (DrugsOrdContentDTO dto : baseDrugRanges) {
						if( dto !=null && item.getId_mm().equals(dto.getId_mm()) && StringUtils.isNotEmpty(dto.getSd_basedrugrange()) && StringUtils.isNotEmpty(dto.getCTRL1())){
							displayName+="\\H01\\"+dto.getCTRL1()+"\\N\\";
						}
					}
				}
				
				String strName = highName+displayName+item.getName_srv();
				if (FBoolean.TRUE.equals(item.getFg_self())) {
					strName += ("(自备)"+(StringUtils.isEmpty(item.getSpec_mm())?"":"["+item.getSpec_mm()+"]"));
				} else if (FBoolean.TRUE.equals(item.getFg_extdispense())) {
					strName += ("(外配)"+(StringUtils.isEmpty(item.getSpec_mm())?"":"["+item.getSpec_mm()+"]"));
				} else {
					if(item.getSd_nodispense()!=null){
						if ("0".equals(item.getSd_nodispense())) {
							strName += ("(自备)"+(StringUtils.isEmpty(item.getSpec_mm())?"":"["+item.getSpec_mm()+"]"));
						}else if ("1".equals(item.getSd_nodispense())) {
							strName += ("(嘱托)"+(StringUtils.isEmpty(item.getSpec_mm())?"":"["+item.getSpec_mm()+"]"));
						}else if ("2".equals(item.getSd_nodispense())) {
							strName += ("(外配)"+(StringUtils.isEmpty(item.getSpec_mm())?"":"["+item.getSpec_mm()+"]"));
						}
						
					}else{
					strName += ("["+item.getSpec_mm()+"]");
				}
				}
				
				 if(!StringUtils.isEmpty(item.getId_dep_wh())){
						IDeptRService RService= ServiceFinder.find(IDeptRService.class); 
						DeptDO dept = RService.findById(item.getId_dep_wh());
						if (dept!=null) {
							strName += " "+(StringUtils.isEmpty(dept.getName())?"":dept.getName());
						}
				}
				//ly 0140933  性病拼接   门诊，慢病医嘱列表显示       
				String slowName = "";
				if (!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(this.getCiEmsDTO().getCode_entp())) 
				{
					if (ICiDictCodeConst.SD_EXCESSIVE_REASON_CHRONIC.equals(this.getCiEmsDTO().getSd_excessive_reason())) {
						slowName = "\\H01\\[慢性病]\\N\\";
					}
				}
				strName = strUrgent + slowName + strName;
				arrList.add(strName);
				//组装剂量和剂量单位，需要将剂量单位换算为基本包装单位
				if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(this.getCiEmsDTO().getCode_entp())
						||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(this.getCiEmsDTO().getCode_entp())
						||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(this.getCiEmsDTO().getCode_entp())){
					assembleQuanMedu2(item,arrList);
				}else {
				assembleQuanMedu(item,arrList);
				}
				//拼接价格和总量
				if(item.getTotal_pri() != null){
					String totalpri="0"+"元    ";
					if(FBoolean.TRUE.equals(item.getFg_bl())) {
//						totalpri=df2.format(item.getTotal_pri())+"元    ";
						BigDecimal f=new BigDecimal(df2.format(item.getTotal_pri())).setScale(4, BigDecimal.ROUND_HALF_UP);
						totalpri=f.stripTrailingZeros().toPlainString()+"元    ";
					}
					//  类型是门诊，慢病，和出院带药的，显示总量
					if((!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(this.getCiEmsDTO().getCode_entp())
							&&!IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(this.getCiEmsDTO().getCode_entp()))
							||FBoolean.TRUE.equals(this.getCiEmsDTO().getFg_pres_outp())
							||FBoolean.TRUE.equals(this.getCiEmsDTO().getFg_wholepack())
							||(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(this.getCiEmsDTO().getCode_entp())
									&&iih.bd.bc.udi.pub.ICiDictCodeConst.SD_DRUG_DELIVERY_METHOD_PRES_BACK.equals(this.getCiEmsDTO().getSd_drugdeliverymethod()))){//住院退药显示总量
						//模板开立总量 item.getQuan_total_medu()会为NULL  用Quan_total_medu拼接
						
						if(null==item.getQuan_total_medu()) {
							if(item.getQuan_cur() != null){								
							arrList.add(totalpri+getPrettyNumber2(item.getQuan_cur())+getName_unit_med(item.getName_unit_sale()));
							}
						}else {
							arrList.add(totalpri+getPrettyNumber2(item.getQuan_total_medu())+getName_unit_med(item.getName_unit_sale()));
						}
					}else{
						arrList.add(totalpri);
					}
				}else{
					arrList.add("0元");
				}
				list.add(arrList);
			}
		}

		return list;
	}
	/**
	 * 
	 * @code 查询药品基本范围，及设置的显示名称
	 * @author LiYue
	 * @param id_mms
	 * @throws DAException 
	 */
	private List<DrugsOrdContentDTO> getDrugsOrdContent(FArrayList emssrvs) throws DAException {
		if(emssrvs == null && emssrvs.size()<=0) return null;
		
		String id_mms = getId_mms(emssrvs); 
		if(StringUtils.isEmpty(id_mms))return null;
		
		String sql = getDrugMmsSql(id_mms);
		List<DrugsOrdContentDTO> dtos = null;
		dtos = (List<DrugsOrdContentDTO>) new DAFacade().execQuery(sql,null, new BeanListHandler(DrugsOrdContentDTO.class));
		return dtos;
	}
	//筛选出id_mm
	private String getId_mms(FArrayList emssrvs) {
		
		String id_mms = " ";
		for(int i=0;i <emssrvs.size();i++){
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			if(item != null && StringUtils.isNotEmpty(item.getId_mm()))
			{
				id_mms += "'"+item.getId_mm()+"',";
			}
		}
		if(StringUtils.isEmpty(id_mms) || " ".equals(id_mms))return null;
		return id_mms.substring(0, id_mms.length()-1);
	}
	/**
	 * 
	 * @code 查询药品基本范围，显示名称SQL
	 * @author LiYue
	 * @param id_mm
	 */
	private String getDrugMmsSql(String id_mms) {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select a.ctrl1,mm.id_mm,mm.sd_basedrugrange from bd_udidoc a 	");
		strSql.append(" left  join bd_mm mm ON mm.sd_basedrugrange =  a.code    ");
		strSql.append(String.format(" WHERE a.id_udidoclist='@@@@TL40000000000171' AND mm.id_mm in (%s) ", id_mms));
		return strSql.toString();
	}

	/**
	 * 获得表尾数据
	 * 
	 * @param ems
	 * @return
	 */
	protected ArrayList<String> getTailInfos(CiEmsDTO ems) {
		ArrayList<String> list = new ArrayList<String>();
//		list.add(this.getCiEmsDTO().getName_route());
//		list.add(this.getCiEmsDTO().getName_freq());
		String note = "", days = "", propcStr = "";
		String Quan_total_medu = "";
		note = ICiOrContentConst.ChangeToEscapeCharacter(this.getCiEmsDTO().getNote());
		// 非住院的情况下要拼接天数
		if (!(StringUtils.isEmpty(this.getCiEmsDTO().getCode_entp())
				|| this.getCiEmsDTO().getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP))) {
			if(this.getCiEmsDTO().getDays_or()!=null) {
				days = this.getCiEmsDTO().getDays_or() + "天 ";
			}
		}
		// 治疗和预防用药的拼接；适用场景（治疗和预防只存在一个）
		FArrayList emssrvs = this.getCiEmsDTO().getEmssrvs();
		for (int i = 0; i < emssrvs.size(); i++) {
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			if(item.getQuan_total_medu()== null){
				if(item.getQuan_cur() != null){
					Quan_total_medu += getPrettyNumber2(item.getQuan_cur())+item.getName_unit_sale();
				} 
			}else{
				Quan_total_medu += getPrettyNumber2(item.getQuan_total_medu())+item.getName_unit_sale();
			}
			
			if(StringUtils.isNotEmpty(item.getSd_anti()) && !IBdMmDictCodeConst.SD_ANTI_NULL.equals(item.getSd_anti())){
				if (item.getFg_propc() != null && item.getFg_propc().booleanValue()) {
					propcStr = "抗生素预防使用";
					break;
				} else if (item.getFg_propc() != null && !item.getFg_propc().booleanValue()) {
					propcStr = "抗生素治疗使用";
					break;
				}
			}			
		}
		StringBuffer sb = new StringBuffer();
		assemble(sb,this.getCiEmsDTO().getName_route());
		//滴速
		if(!StringUtils.isEmpty(this.getCiEmsDTO().getName_dripspeed())) {
		assemble(sb,this.getCiEmsDTO().getName_freq()+" "+this.getCiEmsDTO().getName_dripspeed());
		}else {
		assemble(sb,this.getCiEmsDTO().getName_freq());
		}
		//note备注 不包含用法要求时 拼接用法要求，包含就不拼接
		if((!StringUtils.isEmpty(this.getCiEmsDTO().getName_routedes()))&&note.indexOf(this.getCiEmsDTO().getName_routedes())!=-1) {
			
		}else {
		assemble(sb,this.getCiEmsDTO().getName_routedes());
		}
		//门诊显示总量，住院不显示
//		if("00".equals(this.getCiEmsDTO().getCode_entp())) {
//			assemble(assemble(sb,days),Quan_total_medu);
//		}else {
//			assemble(sb,days);
//		}
		assemble(sb, days);
		assemble(sb,propcStr);
		//备注
		assemble(sb,note);
		//领药方式
		assemble(sb,this.getDrugRecModel(this.getCiEmsDTO().getFg_pres_outp(),this.getCiEmsDTO().getFg_wholepack()));
		list.add(sb.toString());
		return list;
	}
	/**
	 * 拼接领药方式
	 * @param fg_pres_out
	 * @param fg_wholepack
	 * @return
	 */
	protected String getDrugRecModel(FBoolean fg_pres_out,FBoolean fg_wholepack){
		if(FBoolean.TRUE.equals(fg_pres_out)){
			return "（出院带药）";
		}else if(FBoolean.TRUE.equals(fg_wholepack)){
			return "（在院整领）";
		}else{
			return "";
		}
	}
	/**
	 * 处理金额多余的0
	 * @param number
	 * @return
	 */
	public   String getPrettyNumber2(FDouble number) {  
	    return BigDecimal.valueOf(number.doubleValue())  
	            .stripTrailingZeros().toPlainString();  
	} 
	
}
