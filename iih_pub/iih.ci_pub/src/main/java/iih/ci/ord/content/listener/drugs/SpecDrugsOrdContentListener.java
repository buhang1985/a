package iih.ci.ord.content.listener.drugs;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.content.d.ICiOrContentConst;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;
/**
 * 药品医嘱内容拼接基类监听，名称、规格、剂量、途径、频次、自备药标识、嘱托  
 * @author liyue 
 *
 */
public class SpecDrugsOrdContentListener extends DrugsOrdContentListener {

	//0174970: 改医嘱确认界面样式，删除金额，顺序按照名称、规格、剂量、途径、频次、嘱托顺序
	boolean fg_self = false;
	/**
	 * 获得表体数据
	 * @param ems
	 * @return
	 */
	protected ArrayList<ArrayList<String>> getItemInfos(CiEmsDTO ems) {

		if (ems == null || this.getCiEmsDTO().getEmssrvs() == null)
			return null;
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		String Quan_total_medu = "";
		FArrayList emssrvs = this.getCiEmsDTO().getEmssrvs();

		// 指定数字格式保留两位小数
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
		for (int i = 0; i < emssrvs.size(); i++) {
			ArrayList<String> arrList = new ArrayList<String>();
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			if (item.getStatus() == DOStatus.DELETED)
				continue;
			// 删除的 用的不做医嘱内容拼接
			if (item != null && item.getStatus() != DOStatus.DELETED && item.getFg_or() != null
					&& item.getFg_or().booleanValue()) {
				String strName = item.getName_srv();
				String spec = "";
				// 服务类型为【010103注射类药品、010104溶媒、010105皮试液】的药品在医嘱单中拼接规格内容
				if (item.getSd_srvtp().startsWith("010103") || item.getSd_srvtp().startsWith("010104")
						|| item.getSd_srvtp().startsWith("010105"))
					spec = item.getSpec_mm();
				if (StringUtils.isNotEmpty(spec)) {
					strName = strName + "[" + spec + "] ";
				}
				// BY GH 高危药品标识：判断 如果为高危药品 添加红色“高危”二字在名称前
				String highName = "";
				if (FBoolean.TRUE.equals(item.getFg_highrisk())) {
					highName = "\\H01\\高危\\N\\";
				}
				strName = highName + strName;

				// ly 0140933 性病拼接 门诊，慢病医嘱列表显示
				String slowName = "";
				if (!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(this.getCiEmsDTO().getCode_entp())
						&& !IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(this.getCiEmsDTO().getCode_entp())) {
					// 0182281: 【工单】--门急诊医生站---超量开单原因----选择后需要在医嘱上有对应红色字体标识;liyuelong 2020/4/27,可维护可配置
					String str=getVisiable(this.getCiEmsDTO().getId_excessive_reason());
					if(StringUtils.isNotEmpty(str)){
						slowName = "\\H01\\["+str+"]\\N\\";
					}
				}
				strName = strUrgent + slowName + strName;
				arrList.add(strName);
				// 组装剂量和剂量单位，需要将剂量单位换算为基本包装单位
				if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(this.getCiEmsDTO().getCode_entp())
						|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(this.getCiEmsDTO().getCode_entp())
						|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(this.getCiEmsDTO().getCode_entp())) {
					assembleQuanMedu2(item, arrList);
				} else {
					assembleQuanMedu(item, arrList);
				}

				// 自备药标识
				if (item.getFg_self() != null && item.getFg_self().booleanValue()) {
					fg_self = true;
				}


				// 拼接总量
				// 类型是门诊，慢病，和出院带药的，显示总量
//				if ((!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(this.getCiEmsDTO().getCode_entp())
//						&& !IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(this.getCiEmsDTO().getCode_entp()))
//						|| FBoolean.TRUE.equals(this.getCiEmsDTO().getFg_pres_outp())
//						|| FBoolean.TRUE.equals(this.getCiEmsDTO().getFg_wholepack())) {
//					// 模板开立总量 item.getQuan_total_medu()会为NULL 用Quan_total_medu拼接
//
//					if (null == item.getQuan_total_medu()) {
//						if (item.getQuan_cur() != null) {
//							arrList.add(getPrettyNumber2(item.getQuan_cur()) + item.getName_unit_sale());
//						}
//					} else {
//						arrList.add(getPrettyNumber2(item.getQuan_total_medu()) + item.getName_unit_sale());
//					}
//				}
					//拼接价格和总量
					if(item.getTotal_pri() != null){
						DecimalFormat df2 = new DecimalFormat("0.00000000");
						String totalpri="0元    ";
						if(FBoolean.TRUE.equals(item.getFg_bl())) {
//							totalpri=df2.format(item.getTotal_pri())+"元    ";
							BigDecimal f=new BigDecimal(df2.format(item.getTotal_pri())).setScale(4, BigDecimal.ROUND_HALF_UP);
							totalpri=f.stripTrailingZeros().toPlainString()+"元    ";
						}
						//  类型是门诊，慢病，和出院带药的，显示总量
						if((!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(this.getCiEmsDTO().getCode_entp())
								&&!IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(this.getCiEmsDTO().getCode_entp()))
								||FBoolean.TRUE.equals(this.getCiEmsDTO().getFg_pres_outp())
								||FBoolean.TRUE.equals(this.getCiEmsDTO().getFg_wholepack())){
							//模板开立总量 item.getQuan_total_medu()会为NULL  用Quan_total_medu拼接
							
							if(null==item.getQuan_total_medu()) {
								if(item.getQuan_cur() != null){								
								arrList.add(totalpri+getPrettyNumber2(item.getQuan_cur())+item.getName_unit_sale());
								}
							}else {
								arrList.add(totalpri+getPrettyNumber2(item.getQuan_total_medu())+item.getName_unit_sale());
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
			days = this.getCiEmsDTO().getDays_or() + "天 ";
			;
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
		//自备药
		if(fg_self) {
			assemble(sb,"(自备)");
		}
		//清空自备药标志
		fg_self = false;
		//note备注 不包含用法要求时 拼接用法要求，包含就不拼接
		if((!StringUtils.isEmpty(this.getCiEmsDTO().getName_routedes()))&&note.indexOf(this.getCiEmsDTO().getName_routedes())!=-1) {
			
		}else {
		assemble(sb,this.getCiEmsDTO().getName_routedes());
		}

		assemble(sb,propcStr);
		//备注
		assemble(sb,note);
		//领药方式
		assemble(sb,this.getDrugRecModel(this.getCiEmsDTO().getFg_pres_outp(),this.getCiEmsDTO().getFg_wholepack()));
		list.add(sb.toString());
		return list;
	}
	public String getVisiable(String id_excessive_reason){
		if(StringUtils.isNotEmpty(id_excessive_reason)){
			try {
				UdidocDO udi=ServiceFinder.find(IUdidocRService.class).findById(id_excessive_reason);
				if(udi!=null) {
					String val=udi.getCtrl5();// 获取显示符号
					if(StringUtils.isNotEmpty(val)){
						return val;
					}
				}
			} catch (BizException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
