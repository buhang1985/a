package iih.pi.overview.s.bp.listener;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.i.IMeterialRService;
import iih.bd.pp.dto.d.UnComparSrvOnAccDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.d.desc.PatiVisitDODesc;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.dic.phyind.d.PiPatPhyIndOptDO;
import iih.pi.dic.phyind.i.IPiPatPhyIndOptDORService;
import iih.pi.overview.dto.d.PiPatAl4IpDTO;
import iih.pi.overview.dto.d.PiPatAlPhy4IpDTO;
import iih.pi.overview.dto.d.PiPatPhy4IpDTO;
import iih.pi.overview.overview.d.OverviewAggDO;
import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.d.PiPatDO;
import iih.pi.overview.overview.d.PiPatPhyDO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 *  患者过敏及生理状态集成平台监听器
 *  
 * 
 * @author shaosq
 * @date 2016年9月28日  下午7:25:52
 */
public class PipatAlPhy4IpListener implements IBusinessListener {
	private IUdidocRService udiRSrv= ServiceFinder.find(IUdidocRService.class);
	private IPiPatPhyIndOptDORService phyindoptRSrv = ServiceFinder.find(IPiPatPhyIndOptDORService.class);
	private DAFacade daf = new DAFacade();

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		
		//1、验证事件，是否匹配
		BDCommonEvent bdcEvent = (BDCommonEvent) event;
		if (!OverviewAggDO.class.getName().equals(bdcEvent.getSourceID())) {
			return;
		}
		Object[] objs = (Object[]) bdcEvent.getNewObjs();
		
		if (ArrayUtil.isEmpty(objs)) {
			return;
		}
		if (!(objs[0] instanceof OverviewAggDO)) {
			return;
		}
		
		OverviewAggDO[] pataggdos = new OverviewAggDO[objs.length];
		for (int i = 0; i < objs.length; i++) {
			pataggdos[i] = (OverviewAggDO) objs[i];
		}
		
		//事件触发通知集成平台
		try{
			this.invokeIpEvent(pataggdos[0],event);
		}catch(Exception ex){
			//xap.mw.runtime.msys.logging.
		}
	}

	 
	/**
	 * 触发集成平台事件
	 * @param event 
	 * 
	 * @param pataggdos
	 * @throws BizException
	 * @throws ParseException 
	 */
	private void invokeIpEvent(OverviewAggDO patiAggDO, IBusinessEvent event) throws BizException, ParseException {
		PiPatAlPhy4IpDTO pipatmsgDTO = new PiPatAlPhy4IpDTO();
		PiPatDO patDo = patiAggDO.getParentDO();
		// 患者住院判断
		IPativisitRService enService = ServiceFinder.find(IPativisitRService.class);
		String tn = PatiVisitDODesc.TABLE_ALIAS_NAME;
		// 未结算，未退诊，接诊有效
		String whereSql = getCol(tn, "id_pat") + " = '" + patDo.getId_pat()
				+ "' and " + getCol(tn, "fg_st") + " = 'N' and "
				+ getCol(tn, "fg_canc") + " = 'N' and "
				+ getCol(tn, "fg_acptvalid") + " = 'Y' and "
				+ getCol(tn, "code_entp") + " = '"
				+ IBdFcDictCodeConst.SD_CODE_ENTP_IP + "'";

		PatiVisitDO[] enDos = enService.find(whereSql, "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(enDos)){
			pipatmsgDTO.setRegionid(IPiDictCodeConst.DOMAIN_ID_MZ);
			if(patDo.getCode_amr_oep() ==null || patDo.getCode_amr_oep().isEmpty()){
				pipatmsgDTO.setPatientseqnum(patDo.getCode());//在无门诊病案号（就诊号）前先用code 代替
			}else
			{
				pipatmsgDTO.setPatientseqnum(patDo.getCode_amr_oep());//就诊号
			}
			SetVisitDataOnOP(pipatmsgDTO,patDo);
		}
		else{
			pipatmsgDTO.setRegionid(IPiDictCodeConst.DOMAIN_ID_ZY);
			pipatmsgDTO.setPatientseqnum(patDo.getCode_amr_ip());//就诊号
			SetVisitDataOnIP(pipatmsgDTO,patDo);
		}
		pipatmsgDTO.setIe_patientid(patDo.getCode());//患者编码
		

		pipatmsgDTO.setName(patDo.getName());//姓名	
		pipatmsgDTO.setAge(AgeCalcUtil.getAge(patDo.getDt_birth()) );//年龄
		pipatmsgDTO.setSexid(patDo.getSd_sex());//性别
		//dfa = new SimpleDateFormat("yyyyMMdd");
		//pipatmsgDTO.setBirthdaydate(dfa.format(patDo.getDt_birth()==null?new Date():
			                         //dfa.parse(patDo.getDt_birth().toString())));//生日
		
		if (patDo.getDt_birth() != null) {
			pipatmsgDTO.setBirthdaydate(patDo.getDt_birth().toString(TimeZone.getDefault(), new SimpleDateFormat("yyyyMMdd")));
		}
		
		//dfa = new SimpleDateFormat("yyyyMMddhhmm");
		//pipatmsgDTO.setReportdate(dfa.format(dfa.parse(new FDate().toString())));//记录时间
		pipatmsgDTO.setReportdate(new FDateTime().toString(TimeZone.getDefault(), new SimpleDateFormat("yyyyMMddHHmmss")));
		PsndocAggDO psndo = ServiceFinder.find(IPsndocRService.class).findById(Context.get().getStuffId());
		if(psndo!=null){
			pipatmsgDTO.setReportdoctor_code(psndo.getParentDO().getCode());//接诊医生编码
			pipatmsgDTO.setReportdoctor_name(psndo.getParentDO().getName());//接诊医生名称
		}
		DeptDO deptdo = ServiceFinder.find(IDeptRService.class).findById(Context.get().getDeptId());
		if(deptdo!=null){
			pipatmsgDTO.setDeptcode(deptdo.getCode());//接诊科室编码
			pipatmsgDTO.setDeptname(deptdo.getName());//接诊科室名称
		}
		OrgDO orgdo = ServiceFinder.find(IOrgRService.class).findById(Context.get().getOrgId());
		if(orgdo!=null){
			pipatmsgDTO.setOrgcode(orgdo.getOrgcode());//医疗机构编码
			pipatmsgDTO.setOrgname(orgdo.getName());//医疗机构名称
		}
		//设置患者过敏史信息
		setPatAlInfo(patiAggDO, pipatmsgDTO);
		
		//设置患者生理状况信息
		setPatPhyInfo(patiAggDO, pipatmsgDTO);
		
		//组装发送的数据
		BusinessEvent bizEvent = null;
		DomainBusinessUserObj buo = null;
		if(pipatmsgDTO.getRegionid().equals(IPiDictCodeConst.DOMAIN_ID_MZ)){
			buo= new DomainBusinessUserObj(pipatmsgDTO, BusiType.MZ,"0","0");
		}			
		else {
			pipatmsgDTO.setRegionid(IPiDictCodeConst.DOMAIN_ID_MZ);//域id都传01
			buo= new DomainBusinessUserObj(pipatmsgDTO, BusiType.ZY,"0","0");
		}


		 pipatmsgDTO.setMessagetype("new");
		 
		 MsgObj mbx = new MsgObj();
		 mbx.setInteractionCode("new");
		 
		 if(deptdo!=null){
			mbx.setApplyUnitId(deptdo.getCode());// 第四位申请科室遍码
		 }
		 buo.setMsgObj(mbx);
		 
		switch(event.getEventType()){
			case IEventType.TYPE_INSERT_AFTER:
				 bizEvent = new BusinessEvent(OverviewAggDO.class.getName(),IEventType.TYPE_INSERT_AFTER,buo);
				 break;
			case IEventType.TYPE_UPDATE_AFTER:
				 bizEvent = new BusinessEvent(OverviewAggDO.class.getName(),IEventType.TYPE_UPDATE_AFTER,buo);
				 break;
			case IEventType.TYPE_DELETE_AFTER:
				 bizEvent = new BusinessEvent(OverviewAggDO.class.getName(),IEventType.TYPE_DELETE_AFTER,buo);
				 break;
		    default:
				 bizEvent = new BusinessEvent(OverviewAggDO.class.getName(),IEventType.TYPE_UPDATE_AFTER,buo);
				 break;
		}
	
		// 触发集成平台事件
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}
	
	private void SetVisitDataOnIP(PiPatAlPhy4IpDTO pipatmsgDTO,PiPatDO patDo) throws DAException {
		String sb = SetIPQryString(patDo);		
		List<PiPatAlPhy4IpDTO> list  = (List<PiPatAlPhy4IpDTO>)new DAFacade().execQuery(sb,null, new BeanListHandler(PiPatAlPhy4IpDTO.class));
		if(list != null&&list.size()>0){
			int max = list.get(0).getVisittimes();
			int time = 0;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVisittimes()>=max){
					max =list.get(i).getVisittimes();
					time = i;					
				}				
			}
			pipatmsgDTO.setBedno(list.get(time).getBedno());
			pipatmsgDTO.setWardcode(list.get(time).getWardcode());
			pipatmsgDTO.setWardname(list.get(time).getWardname());
			pipatmsgDTO.setVisittimes(list.get(time).getVisittimes());
			pipatmsgDTO.setVisittypecode("03");
			pipatmsgDTO.setVisittypename("住院");
			pipatmsgDTO.setVisitordno(list.get(time).getVisitordno());
		}			
		
	}

	private String SetIPQryString(PiPatDO patDo) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select ip.times_ip  visitTimes, ent.code visitordno,entp.code visitTypeCode,entp.name visitTypeName,   ");
		sb.append("  	ip.name_bed bedno, dep.name  wardname,dep.code  wardcode  ");
		sb.append("  	from en_ent ent ");
		sb.append(" inner join en_ent_ip ip on ip.id_ent = ent.id_ent ");
		sb.append(" left join bd_entp entp on entp.id_entp = ent.id_entp ");
		sb.append(" left join pi_pat pat on pat.id_pat = ent.id_pat ");
		sb.append(" left join bd_dep dep on dep.id_dep = ip.id_dep_nuradm ");
		if(patDo != null)
			sb.append("    where pat.id_pat = '"+patDo.getId_pat()+"' ");
		//sb.append(" group by entp.code, ent.code,entp.name ");
		return sb.toString();
	}


	private void SetVisitDataOnOP(PiPatAlPhy4IpDTO pipatmsgDTO,PiPatDO patDo) throws DAException {
		String sb = SetOPQryString(patDo);		
		List<PiPatAlPhy4IpDTO> list  = (List<PiPatAlPhy4IpDTO>)new DAFacade().execQuery(sb,null, new BeanListHandler(PiPatAlPhy4IpDTO.class));
		if(list != null&&list.size()>0){
			int max = list.get(0).getVisittimes();
			int time = 0;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getVisittimes()>=max){
					max =list.get(i).getVisittimes();
					time = i;					
				}				
			}
			pipatmsgDTO.setVisittimes(list.get(time).getVisittimes());
			pipatmsgDTO.setVisittypecode("01");
			pipatmsgDTO.setVisittypename("门诊");
			pipatmsgDTO.setVisitordno(list.get(time).getVisitordno());			
		}			
	}


	private String SetOPQryString(PiPatDO patDo) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select op.times_op  visitTimes, ent.code visitordno,entp.code visitTypeCode,entp.name visitTypeName ");
		sb.append("  	from en_ent ent ");
		sb.append(" inner join en_ent_op op on op.id_ent = ent.id_ent ");
		sb.append(" left join bd_entp entp on entp.id_entp = ent.id_entp ");
		sb.append(" left join pi_pat pat on pat.id_pat = ent.id_pat ");
		if(patDo != null)
			sb.append("    where pat.id_pat = '"+patDo.getId_pat()+"' ");
		//sb.append(" group by entp.code, ent.code,entp.name ");
		return sb.toString();
	}


	/**
	 * 设置患者过敏史信息
	 * 
	 * @param patiAggDO
	 * @param pipatmsgDTO
	 * @throws BizException
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	private void setPatAlInfo(OverviewAggDO patiAggDO,
			PiPatAlPhy4IpDTO pipatmsgDTO) throws BizException, ParseException {
		FArrayList2 allist = new FArrayList2();	

		PiPatAlDO[] pials = patiAggDO.getPiPatAlDO();
		//PiPatFhDO[] pifhs = patiAggDO.getPiPatFhDO();
		
		if(!ArrayUtil.isEmpty(pials)){
			for(PiPatAlDO aldo : pials){
				PiPatAl4IpDTO pialdto = new PiPatAl4IpDTO();
				if(!StringUtil.isEmpty(aldo.getId_or())){
					pialdto.setOr_code(getOr_codeBySql(aldo.getId_or()));
				}
				pialdto.setIe_patalid(aldo.getId_patal());
				pialdto.setGm_sl_code("02");//过敏/生理状态编码
				//dfa = new SimpleDateFormat("yyyyMMddhhmm");
				//pialdto.setGm_starttime(dfa.format(aldo.getDt_act()==null?new FDate():dfa.parse(aldo.getDt_act().toString())));//过敏开始时间
				
				if(aldo.getDt_act()!=null){
					pialdto.setGm_starttime(aldo.getDt_act().toString(TimeZone.getDefault(), new SimpleDateFormat("yyyyMMddHHmm")));
				}
				/*if(!ArrayUtil.isEmpty(pifhs)){
					pialdto.setGm_is_jzs("1");//是否家族史
					pialdto.setGm_is_jzs_code(pifhs[0].getDidef_code());//是否家族史编码
				}else{*/
					pialdto.setGm_is_jzs("0");//是否家族史
					pialdto.setGm_is_jzs_code("09");//是否家族史编码
				//}
				
				//过敏诊断 
				if(!StringUtil.isEmpty(aldo.getId_alcla())){
					UdidocDO aldegdo =udiRSrv.findById(aldo.getId_alcla());
					if(aldegdo!=null){
						pialdto.setGm_diag_code(StringUtil.isEmpty(aldegdo.getCode_ie())?aldegdo.getCode():aldegdo.getCode_ie());
						pialdto.setGm_diag_name(aldegdo.getName());
					}
				}
				
				//过敏原 && 过敏类型
				if(!StringUtil.isEmpty(aldo.getId_mm())){
					pialdto.setGm_type_code("01");
					pialdto.setGm_type_name("药品");
					MeterialAggDO mmdo  = ServiceFinder.find(IMeterialRService.class).findById(aldo.getId_mm());
					if(mmdo!=null){
						pialdto.setGm_gmy_code(mmdo.getParentDO().getCode());
						pialdto.setGm_gmy_name(mmdo.getParentDO().getName());
					}
				}else{
					pialdto.setGm_type_code("02");
					pialdto.setGm_type_name("非药品");
					
					if(StringUtil.isEmpty(aldo.getDes_alcla())){
						pialdto.setGm_gmy_name(pialdto.getGm_diag_name());
					}else{
						pialdto.setGm_gmy_name(aldo.getDes_alcla());
					}
				}
				//严重程度
				if(!StringUtil.isEmpty(aldo.getId_aldeg())){
					UdidocDO aldegdo =udiRSrv.findById(aldo.getId_aldeg());
					if(aldegdo!=null){
						pialdto.setGm_gmyz_code(StringUtil.isEmpty(aldegdo.getCode_ie())?aldegdo.getCode():aldegdo.getCode_ie());
						pialdto.setGm_gmyz_name(aldegdo.getName());
					}
				}
				//过敏类型--过敏分类
//				if(!StringUtil.isEmpty(aldo.getId_alcla())){
//					UdidocDO alclado =udiRSrv.findById(aldo.getId_alcla());
//					if(alclado!=null){
//						pialdto.setGm_type_code(StringUtil.isEmpty(alclado.getCode_ie())?alclado.getCode():alclado.getCode_ie());
//						pialdto.setGm_type_name(alclado.getName());
//					}
//				}
				
				allist.add(pialdto);
			}
		}
		pipatmsgDTO.setId_pials(allist);
	}
	
	
	/**
	 *  设置患者生理信息
	 * 
	 * @param patiAggDO
	 * @param pipatmsgDTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void setPatPhyInfo(OverviewAggDO patiAggDO,
			PiPatAlPhy4IpDTO pipatmsgDTO) throws BizException {
		FArrayList2 phylist = new FArrayList2();	
		PiPatPhyDO[] piphys = patiAggDO.getPiPatPhyDO();
		if(!ArrayUtil.isEmpty(piphys)){
			for(PiPatPhyDO phydo : piphys){
				PiPatPhy4IpDTO piphydto = new PiPatPhy4IpDTO();
				piphydto.setIe_patphyid(phydo.getId_patphy());
				piphydto.setSl_gm_code("01");
				if(!StringUtil.isEmpty(phydo.getId_patphyindopt())){
					PiPatPhyIndOptDO phyindo =phyindoptRSrv.findById(phydo.getId_patphyindopt());
					if(phyindo!=null){
						piphydto.setSl_code(phyindo.getCode());
						piphydto.setSl_name(phyindo.getName());
					}
				}
				phylist.add(piphydto);
			}
		}
		pipatmsgDTO.setId_piphys(phylist);
	}
	
	private String getCol(String table,String column){
		return table + "." + column;
	}
	
	private String getOr_codeBySql(String id_or) {
		
		try {
			String sql = "select code_or from ci_order where id_or = '" + id_or + "'";
			String or_code = (String)daf.execQuery(sql, new ColumnHandler());
			return or_code;
		}
		catch(Exception e) {
			return "医嘱号获取失败";
		}
		
	}
}
