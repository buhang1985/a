package iih.ci.ord.content.d;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.utils.ParamUtils;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 拼接手术申请单内容
 *
 */
public class OpTaiCiOrContentFactory  extends BaseCiOrContentFactory implements CiOrContentObjFactory {

	@Override
	public CiOrContentDO create(CiEmsDTO ems) {
		if (ems == null || ems.getEmssrvs() == null || ems.getEmssrvs().size() == 0) {
			return getNullContent(ems);
		}
		CiOrContentDO contentdo = new CiOrContentDO();
		String sd_srvtp = ((CiEmsSrvDTO) ems.getEmssrvs().get(0)).getSd_srvtp();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(sd_srvtp.substring(0, 2));
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}

		contentdo.setTitle(getTitle(ems));
		contentdo.setItemInfos(getItemInfos(ems));
		contentdo.setTailInfo(getTailInfos(ems));
		return contentdo;
	}

	/**
	 * 获得标题数据
	 * 
	 * @param ems
	 * @return
	 */
	private String getTitle(CiEmsDTO ems) {
		return "";
	}

	/**
	 * 获得表体数据
	 * 
	 * @param ems
	 * @return
	 */
	private ArrayList<ArrayList<String>> getItemInfos(CiEmsDTO ems) {
		if (ems == null || ems.getEmssrvs() == null)
			return null;
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		FArrayList emssrvs = ems.getEmssrvs();

		FMap map = ems.getOrapplysheet();

		StringBuffer msgBuffer = new StringBuffer();
		// 加急
		FBoolean fg_urgent = ems.getFg_urgent();
		ListenerUtils urgentRed = new ListenerUtils();
		if (fg_urgent != null && fg_urgent.booleanValue()) {
			// 0178579: 加急改为红色显示 liyue 2019-12-09
			if (urgentRed.GetXH_CIOR0005().booleanValue()) {
				msgBuffer.append("\\H01\\加急！\\N\\   ");
			} else {
				msgBuffer.append("加急！   ");// li_cheng 将“加急” 改成 “加急！”
			}
		}
		msgBuffer.append("拟");
		CiorappsurgeryAggDO consDO = (CiorappsurgeryAggDO) map.get(EmsType.OPER + "");
		if (consDO != null) {
			
			OrdApOpDO ordApOp = consDO.getParentDO();
			if (ems.getDt_begin() != null) {
				msgBuffer.append("于   ");
				String dateStr = ordApOp.getDt_plan().toStdString();
				msgBuffer.append(dateStr.substring(5,7)).append("月").append(dateStr.substring(8,10)).append("日  ").append(dateStr.substring(11,13)).append("时").append(dateStr.substring(14,16)).append("分");
				//msgBuffer.append(ordApOp.getDt_plan().toStdString().substring(0, 10));
			}
			
			if(StringUtils.isNotEmpty(ordApOp.getName_anestp())){
				msgBuffer.append("  在 " + ordApOp.getName_anestp() + " 下");
			}
			
			// 医嘱内容拼接价格 by yzh 2017-11-30 14:26:08
			FDouble total_pri = new FDouble("0");
			for (int i = 0; i < emssrvs.size(); i++) {
				CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
				if (item.getStatus() == DOStatus.DELETED || !item.getFg_or().booleanValue())
					continue;
				//价格：门诊的之前有个mantis0120923 EmsOpsViewModel.cs 449将附加收费标识设为false
				//住院 在iih.ci.ord.s.bp.ems.save.ip.CiOrAggAndRelInfoSaveBP setSugPrimd()中 通过参数控制
				//也就是门诊和住院的手术附加收费标识方案不一致，且住院时先拼接的医嘱内容，后用上面方法判断设置ordsrvdo中的fg_bl,导致数据库结果和页面显示不一致
				//因此住院在这里也需要用该参数控制，不去调整顺序，是考虑到可能影响别的业务顺序
				setSugPrimd(ems.getCode_entp(),ems.getId_srv(),item);
				if (item.getTotal_pri() != null && item.getFg_bl() != null && item.getFg_bl().booleanValue())
					total_pri = total_pri.add(item.getTotal_pri());
				if (i == 0) {
					msgBuffer.append("行 ").append(item.getName_srv());
					if(ordApOp.getName_surgical_site()!=null&&ordApOp.getName_surgical_site().trim().length()>0) {
						msgBuffer.append("  ("+ordApOp.getName_surgical_site()+")");
					}
				} else {
					msgBuffer.append("+" + item.getName_srv());
					if(ordApOp.getName_surgical_site()!=null&&ordApOp.getName_surgical_site().trim().length()>0) {
						msgBuffer.append("  ("+ordApOp.getName_surgical_site()+")");
					}
				}
			}
			
			// 注意事项
			if(StringUtils.isNotEmpty(ordApOp.getAnnouncements())){
				msgBuffer.append(" (" + ordApOp.getAnnouncements()+")");	
			}
			arrList.add(msgBuffer.toString());
			arrList.add(total_pri.toString()+"元");
		}
		list.add(arrList);
		return list;
	}
	/**
	 * 设置手术的收费标识，住院根据参数控制，门诊不走这里，门诊都是false
	 * @param code_entp 就诊类型
	 * @param id_srv_main 主手术服务
	 * @param emsSrvDTO
	 */
	private void setSugPrimd(String code_entp,String id_srv_main,CiEmsSrvDTO emsSrvDTO ) {
		if(code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)||code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS)) {
			// 手术收费策略 获取轻量级参数
			FBoolean sug_pre = FBoolean.TRUE;
			try {
				sug_pre = ParamUtils.GetOrgParamFBooleanValue(ICiOrdCustomSysParamConst.LL_PARAM_SUG_REL);
			} catch (BizException e) {
				;
			}
			if (FBoolean.FALSE.equals(sug_pre)) {
				// 获取是手术的医嘱
				if (IBdSrvDictCodeConst.SD_SRVTP_OP.equals(emsSrvDTO.getSd_srvtp().substring(0, 2))) {
					// SRV表执行科室非当前登录科室的手术 附加手术
						if ((IBdSrvDictCodeConst.SD_SRVTP_OP.equals(emsSrvDTO.getSd_srvtp().substring(0, 2)))
								|| (Context.get().getDeptId().equals(emsSrvDTO.getId_dep())
										&& id_srv_main.equals(emsSrvDTO.getId_srv()))) {//注：这里的条件有点不太理解 不过CiOrAggAndRelInfoSaveBP中就是这条件，这里保持一致
							emsSrvDTO.setId_primd(IBdPrimdCodeConst.ID_PRI_FREE);
							emsSrvDTO.setFg_bl(FBoolean.FALSE);
						}
				}
			}
		}
	}
	/**
	 * 手术预约后会更新ciorder中的dt_begin时间 医嘱内容中的也需要同步更新
	 * @author yzh
	 * @param idor
	 * @param contentor
	 * @param dt
	 * @return
	 */
	public String updContentOr(String contentor, FDateTime dt) {
		return contentor.replaceFirst("\\d{4}-\\d{2}-\\d{2}", dt.getBeginDate().toLocalString());

	}
	/**
	 * 获得表尾数据
	 * 
	 * @param ems
	 * @return
	 */
	private ArrayList<String> getTailInfos(CiEmsDTO ems) {
		ArrayList<String> list = new ArrayList<String>();
		CiorappsurgeryAggDO sugAggDO = (CiorappsurgeryAggDO) ems.getOrapplysheet().get(EmsType.OPER + "");
		String name_routedes = ICiOrContentConst.ChangeToEscapeCharacter(ems.getName_routedes());
		String name_des = StringUtils.trimToEmpty(sugAggDO.getParentDO().getName_des());
		StringBuffer sb = new StringBuffer();
		sb.append(name_routedes);
		if (sb.length() == 0) {
			sb.append(name_des);
		} else if (!StringUtils.isEmpty(name_des)) {
			sb.append("," + name_des);
		}
		list.add(sb.toString());
		return list;
	}
}
