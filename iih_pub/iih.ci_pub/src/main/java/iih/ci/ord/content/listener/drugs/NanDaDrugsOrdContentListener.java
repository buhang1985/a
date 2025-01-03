package iih.ci.ord.content.listener.drugs;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
/**
 * 药品医嘱内容拼接基类监听，所有客开医嘱内容，都需要继承这个基类
 * @author zhangwq
 *
 */
public class NanDaDrugsOrdContentListener extends DrugsOrdContentListener {

	/**
	 * 获得表体数据
	 * @param ems
	 * @return
	 */
	protected ArrayList<ArrayList<String>>  getItemInfos(CiEmsDTO ems){
		
		if(ems == null || this.getCiEmsDTO().getEmssrvs() == null) return null;
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		String Quan_total_medu = "";
		FArrayList emssrvs = this.getCiEmsDTO().getEmssrvs();
		
		//指定数字格式保留两位小数
		DecimalFormat df = new DecimalFormat("0.00");
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
				String strName = item.getName_srv();
				
				//添加【商品储存条件】内容
				String storecond = getStoreconds(item.getId_mm());
				if(StringUtils.isNotEmpty(storecond)) {
					strName ="["+storecond+"] "+strName;
				}
				//BY GH 高危药品标识：判断  如果为高危药品  添加红色“高危”二字在名称前
				String highName = "";
				if(FBoolean.TRUE.equals(item.getFg_highrisk())){
					highName ="\\H01\\高危\\N\\";
				}
				 strName = highName+strName;
				if (FBoolean.TRUE.equals(item.getFg_self())) {
					strName += ("(自备)"+(StringUtils.isEmpty(item.getSpec_mm())?"":"["+item.getSpec_mm()+"]"));
				} else {
					strName += ("["+item.getSpec_mm()+"]");
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
					String totalpri="0元    ";
					if(item.getFg_self()==null||!item.getFg_self().booleanValue()) {
						totalpri=df.format(item.getTotal_pri())+"元    ";
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
	 * @code 通过id_mm查询药品的储存条件
	 * @author LiYue
	 * @date 2019年8月27日,上午10:07:14
	 */
    public String getStoreconds(String id_mm) {
		if(StringUtils.isEmpty(id_mm))
			return null;
		String sql = getSql(id_mm);
		MeterialDO bd_mmDo = null;
		try {
			bd_mmDo = (MeterialDO)  new DAFacade().execQuery(sql, new BeanHandler(MeterialDO.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(bd_mmDo==null || StringUtils.isEmpty(bd_mmDo.getId_storeconds()))
		return null;
		
		return bd_mmDo.getId_storeconds().toString();
    }
    
    /**
     * @code  id_mm查询药品的储存条件SQL
     * @author LiYue
     * @date 2019年8月27日,上午10:27:15
     */
	private String getSql(String id_mm) {
		StringBuffer sql = new StringBuffer();
		sql.append("select to_char(listagg(name,',') within group(order by code)) as id_storeconds  from bd_udidoc where (select id_storeconds from bd_mm where id_mm ='"+id_mm+"') like '%'||id_udidoc||'%';");
		return sql.toString();
	} 
	

}
