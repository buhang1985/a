package iih.ci.ord.content.d;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 医嘱内容生成草药生成工厂
 */
public class HerbOrContentFactory extends BaseCiOrContentFactory{

	@Override
	public CiOrContentDO create(CiEmsDTO ems) {
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0){
			return getNullContent(ems);
		}
		CiOrContentDO contentdo=new CiOrContentDO();
		String sd_srvtp = ((CiEmsSrvDTO)ems.getEmssrvs().get(0)).getSd_srvtp();
		if(sd_srvtp != null && sd_srvtp !=""){
			//contentdo.setTypeId(sd_srvtp);
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_HERB);
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
		return Integer2String(ems.getOrders());
	}
	
	/**
	 * 获得表体数据
	 * @param ems
	 * @return
	 */
	private ArrayList<ArrayList<String>>  getItemInfos(CiEmsDTO ems){
		if(ems == null || ems.getEmssrvs() == null) return null;
		ArrayList<ArrayList<String>> list = new	ArrayList<ArrayList<String>>();
		
		FArrayList emssrvs = ems.getEmssrvs();
		String slowName = "";
//		String str = "";
//		String Note = "";
//		ArrayList<String> arrList = new ArrayList<String>();
//		FDouble total_pri = new FDouble("0");
		for(int i=0;i <emssrvs.size();i++){
			//if(i >3) break;
			CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
			//0194663: 草药开立选择超量开单慢性病，表里面写入了，现在需要在医嘱界面拼接红色慢性病标记
			if (i == 0 && ICiDictCodeConst.SD_EXCESSIVE_REASON_CHRONIC.equals(ems.getSd_excessive_reason()) &&
					(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ems.getCode_entp()) ||
							IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(ems.getCode_entp()) ||
							IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(ems.getCode_entp()))) {
				slowName = "\\H01\\[慢性病]\\N\\";
			}else{
				slowName = "";
			}
			//删除的不拼接内容, 非临床项目不拼接
			if(item != null && item.getStatus() != DOStatus.DELETED && 
					item.getFg_or()!=null && item.getFg_or().booleanValue()){
				ArrayList<String>  itemList = new ArrayList<String>();
				
				if (FBoolean.TRUE.equals(item.getFg_self())) {
					itemList.add(slowName + item.getName_srv()+"(自备)");
				} else {
					if(item.getSd_nodispense()!=null){
						if ("0".equals(item.getSd_nodispense())) {
							itemList.add(slowName + item.getName_srv()+"(自备)");
						}else if ("1".equals(item.getSd_nodispense())) {
							itemList.add(slowName + item.getName_srv()+"(嘱托)");
						}else if ("2".equals(item.getSd_nodispense())) {
							itemList.add(slowName + item.getName_srv()+"(外配)");
						}
						
					}else{
						itemList.add(slowName + item.getName_srv());
					}
					
				}
				DecimalFormat df = new DecimalFormat("0.00000000");
				if(item.getQuan_medu_cur()!=null&&item.getName_unit_medu_cur()!=null) {//门诊取ci_or_srv_mm 
					BigDecimal f=new BigDecimal(df.format(item.getQuan_medu_cur())).setScale(4, BigDecimal.ROUND_HALF_UP);
					String quan_med=f.stripTrailingZeros().toPlainString();
					itemList.add(quan_med);
					itemList.add(item.getName_unit_medu_cur());
				}else {//住院取ci_or_srv ，ci_or_srv_mm没存
					BigDecimal f=new BigDecimal(df.format(item.getQuan_med())).setScale(4, BigDecimal.ROUND_HALF_UP);
					String quan_med=f.stripTrailingZeros().toPlainString();
					itemList.add(quan_med);
					itemList.add(item.getName_unit_med());
				}
				
				list.add(itemList);
			}
		}
//		if(str != ""){
//			str = str.substring(0, str.length()-1);
//		}
//		if(ems.getNote() != null && !"".equals(ems.getNote())){
//			Note = ICiOrContentConst.ChangeToEscapeCharacter(ems.getNote());
//		}
//		arrList.add(str+"  "+Note+"  "+"总金额："+this.calPrice(ems));
//		list.add(arrList);
		
		return list;
	}
	
	/**
	 * 获得表尾数据
	 * @param ems
	 * @return
	 */
	private ArrayList<String>  getTailInfos(CiEmsDTO ems){
		ArrayList<String> list = new ArrayList<String>();
		list.add(StringUtils.isEmpty(ems.getName_boil())?"":ems.getName_boil());
		list.add(StringUtils.isEmpty(ems.getName_route())?"":ems.getName_route());
		list.add(StringUtils.isEmpty(ems.getName_freq())?"":ems.getName_freq() + (StringUtils.isEmpty(ems.getName_routedes())?"": ("、(" +ems.getName_routedes()) + ")"));
		list.add(this.calPrice(ems));
		return list;
	}
	
	/**
	 * Integer转换为字符串
	 * @param input
	 * @return
	 */
	private String Integer2String(Integer input){
		if(input==null)return "";
		return input.toString();
	}

	private String calPrice(CiEmsDTO ems) {
			
			Integer orders = ems.getOrders();
			FDouble fOrders = orders == null ? new FDouble(1) : new FDouble(orders);
			
			FDouble totalPri = new FDouble(0);
			if (this.getOrdsrvs() != null && this.getOrdsrvs().length > 0) {
				for(OrdSrvDO ordsrv : this.getOrdsrvs()){
					//临床项目费用
					if(DOStatus.DELETED!=ordsrv.getStatus()&&FBoolean.TRUE.equals(ordsrv.getFg_bl())&&(OrSrvSourceFromEnum.PHYSIAN.equals(ordsrv.getEu_sourcemd())||OrSrvSourceFromEnum.AGENTFROMPRIMD.equals(ordsrv.getEu_sourcemd())
							||OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD.equals(ordsrv.getEu_sourcemd()))&&ordsrv.getSd_srvtp()!=null&&ordsrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
						if(ordsrv.getPri()!=null){
	//						if(FBoolean.TRUE.equals(ordsrv.getFg_nothingwithorders())){
	//							totalPri = totalPri.add(new FDouble(ordsrv.getPri().multiply(ordsrv.getQuan_medu()).doubleValue(),2));
	//						}else{
	//							totalPri = totalPri.add(new FDouble(ordsrv.getPri().multiply(ordsrv.getQuan_medu()).multiply(fOrders).doubleValue(),2));
	//						}
							totalPri = totalPri.add(new FDouble((ordsrv.getPri()==null?new FDouble(0):ordsrv.getPri()).multiply((ordsrv.getQuan_total_medu()==null?new FDouble(0):ordsrv.getQuan_total_medu())).doubleValue(),2));
						}
					}
				}
				//totalPri = totalPri.multiply(fOrders);
			}
			return getPrettyNumber(totalPri);
		}
	
}
