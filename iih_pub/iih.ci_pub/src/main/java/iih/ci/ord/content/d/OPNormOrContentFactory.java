package iih.ci.ord.content.d;

import java.math.BigDecimal;
import java.util.ArrayList;

import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
/**
 * 会诊
 * @author li_zheng
 *
 */
public class OPNormOrContentFactory extends BaseCiOrContentFactory implements CiOrContentObjFactory {
	@Override
	public CiOrContentDO create(CiEmsDTO ems)throws BizException {
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
	 * @throws BizException 
	 */
	private ArrayList<ArrayList<String>>  getItemInfos(CiEmsDTO ems) throws BizException{
		if(ems == null || ems.getEmssrvs() == null) return null;
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		FArrayList emssrvs = ems.getEmssrvs();
		// 加急
		String strUrgent = "";
		FBoolean fg_urgent = ems.getFg_urgent();
		ListenerUtils urgentRed = new ListenerUtils();
		if (fg_urgent != null && fg_urgent.booleanValue()) {
			// 0178579: 加急改为红色显示 liyue 2019-12-09
			if (urgentRed.GetXH_CIOR0005().booleanValue()) {
				strUrgent = "\\H01\\加急！\\N\\   ";
			} else {
				strUrgent = "加急！   ";// li_cheng 将“加急” 改成 “加急！”
			}
		}
		 FMap map= ems.getOrapplysheet();
		 if(map== null){
			throw  new BizException("邀请科室为空"); 
		 }
		 String str = "请";
		 CiorappconsultAggDO consDO = (CiorappconsultAggDO)map.get(EmsType.CONS+"");
		if(consDO != null && consDO.getCiordInviteConsDO() !=null){
			for(int i =0;i<consDO.getCiordInviteConsDO().length;i++){
				if(consDO.getCiordInviteConsDO()[i].getStatus() == DOStatus.DELETED)continue;
				str +=consDO.getCiordInviteConsDO()[i].getName_dep();
				if(consDO.getCiordInviteConsDO()[i].getName_emp() != null){
					str += consDO.getCiordInviteConsDO()[i].getName_emp()+",";	
				}else{
					str +=",";
				}
			}
			arrList.add(strUrgent + str.substring(0, str.lastIndexOf(","))+"会诊");
		}
		//医嘱内容拼接价格 by yzh 2017-11-30 14:23:23
		FDouble total_pri = new FDouble("0");
		if(emssrvs != null && emssrvs.size()>0){
			for (Object object : emssrvs) {
				CiEmsSrvDTO ciemssrv = (CiEmsSrvDTO) object;
				if(ciemssrv.getTotal_pri() != null) total_pri = total_pri.add(ciemssrv.getTotal_pri());
			}
		}
		BigDecimal a=new BigDecimal(total_pri.setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
		arrList.add(a.stripTrailingZeros().toPlainString()+"元");
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
		list.add("");
		list.add("");
		return list;
	}
}
