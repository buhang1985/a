package iih.ci.pre.obspre.s.bp;

import iih.bd.bc.event.pub.IMpEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.dto.d.PhySignDTO;
import iih.ci.pre.dto.d.EmergPreDTO;
import iih.ci.pre.obspre.d.ObsPreDO;
import iih.ci.pre.obspre.d.ObsPreSrvDO;
import iih.ci.pre.obspre.d.ObspreAggDO;
import iih.ci.pre.obspre.d.desc.ObsPreDODesc;
import iih.ci.pre.obspre.i.IObspreCudService;
import iih.ci.pre.obspre.i.IObspreRService;
import iih.en.pub.IEnFunCodeConst;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.outpatient.d.EuPreObs;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientCudService;
import iih.en.pv.outpatient.i.IOutpatientRService;
import iih.en.que.i.IEnQueOutCmdService;
import iih.mp.mpbd.dto.vstmatch.d.VstmatchparanDTO;
import iih.mp.mpbd.vstrule.d.EnumSexTp;
import iih.mp.nr.i.IMpNrQueryService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;
/**
 * 
 * @author liubin
 *
 */
public class ObsPreBP {
	
	public ObsPreBP(){
		
	}	
	
	/**
	 * 获取预检模板
	 * @param entpCode 就诊类型
	 * @param depId 科室id	 
	 * @return
	 * @throws BizException
	 */
	public EmergPreDTO getPreTpl(String entpCode,String depId) throws BizException{
		EmergPreDTO preDTO = new EmergPreDTO();
		PhySignDTO[] physignDTOs = this.getPhySigns(depId, entpCode);
		if(ArrayUtil.isEmpty(physignDTOs))
			return null;
		FArrayList srvArray= new FArrayList();
		for(PhySignDTO signItem : physignDTOs){
			srvArray.add(signItem);
		}
		preDTO.setSrvarray(srvArray);
		
		return  preDTO;
	}
	/**
	 * 加载预检数据
	 * @param preDTO 预检模板
	 * @return
	 * @throws BizException
	 */
	public EmergPreDTO loadData(EmergPreDTO preDTO) throws BizException{
		//1、查询就诊信息
		
		//2、查询预信息
		
		return preDTO;
	}
	/**
	 * 获取预检信息
	 * @param opRegDTO 就诊登记信息
	 * @param entpCode 模板类型
	 * @return
	 * @throws BizException
	 */
	public EmergPreDTO getPreDTO(OpRegDTO opRegDTO,String entpCode) throws BizException{
		if(opRegDTO==null || StringUtil.isEmptyWithTrim(opRegDTO.getId_ent())){
			throw new BizException("没有有效的挂号记录！");
		}
		EmergPreDTO preDTO = new EmergPreDTO();
		String depId = opRegDTO.getId_dep_reg();

		
		//1、查询体征采集模板信息		
		preDTO = this.getPreTpl(entpCode, depId);
		if(preDTO == null)
			preDTO = new EmergPreDTO();
		
		//2、查询就诊信息
		preDTO.setCode_entp(opRegDTO.getCode_entp());
		preDTO.setId_ent(opRegDTO.getId_ent());
		preDTO.setDt_entry(opRegDTO.getDt_insert());
		preDTO.setId_level_dise(opRegDTO.getId_level_dise());
		preDTO.setSd_level_dise(opRegDTO.getSd_level_dise());		
		preDTO.setId_pat(opRegDTO.getId_pat());
		IOutpatientRService opRServ = ServiceFinder.find(IOutpatientRService.class);
		OutpatientDO[] ops = opRServ.findByAttrValString(OutpatientDO.ID_ENT, opRegDTO.getId_ent());
		if(ArrayUtil.isEmpty(ops))
			throw new BizException("没有找到门诊记录！");
		preDTO.setFg_revisit(new FBoolean(!(FBoolean.TRUE.equals(ops[0].getFg_first()))));
		//3、查询预检表
		
		IObspreRService obspreser=ServiceFinder.find(IObspreRService.class);
		ObspreAggDO[] aggdos=obspreser.find(ObsPreDODesc.TABLE_ALIAS_NAME+".id_ent='"+opRegDTO.getId_ent()+"'", null, FBoolean.TRUE);
		if(!ArrayUtil.isEmpty(aggdos)){
			
			ObspreAggDO aggdo=aggdos[0];
			ObsPreDO obs=aggdo.getParentDO();
			ObsPreSrvDO[] obssrv=aggdos[0].getObsPreSrvDO();
			obsToEmg(preDTO, obs);
		
			if(!ArrayUtil.isEmpty(obssrv)){
				for (ObsPreSrvDO obsPreSrvDO : obssrv) {
					if(preDTO.getSrvarray() == null)
						break;
					for (Object phydo : preDTO.getSrvarray()) {
						PhySignDTO phy=(PhySignDTO) phydo ;
						if(obsPreSrvDO.getId_srv().equals(phy.getId_srv())){
							phy.setVal0(obsPreSrvDO.getVal0());
							phy.setVal1(obsPreSrvDO.getVal1());
							phy.setVal2(obsPreSrvDO.getVal2());
							phy.setVal3(obsPreSrvDO.getVal3());
							phy.setVal4(obsPreSrvDO.getVal4());
							break;
						}
					}
				}
			}
		}
		//预检信息初始化（身高，体重）
		new ObsPreInitBP().exec(preDTO, depId);
		return preDTO;
	}

	private void obsToEmg(EmergPreDTO preDTO, ObsPreDO obs) throws BizException{
		preDTO.setFg_chk_eqidemic(obs.getFg_chk_eqidemic());
		preDTO.setChk_note(obs.getChk_note());
		preDTO.setDt_rescue_b(obs.getDt_rescue_b());
		preDTO.setDt_rescue_e(obs.getDt_rescue_e());
		preDTO.setFg_has_eqidarea(obs.getFg_has_eqidarea());
		preDTO.setFg_has_hot(obs.getFg_has_hot());
		preDTO.setFg_has_hot2(obs.getFg_has_hot2());
		preDTO.setId_come_way(obs.getId_come_way());
		IUdidocRService udiservice=ServiceFinder.find(IUdidocRService.class);
		if(obs.getId_come_way()!=null){
		UdidocDO udi=udiservice.findById(obs.getId_come_way());
		if(udi!=null)
			preDTO.setName_come_way(udi.getName());
		}
		//preDTO.setName_come_way(Name_come_way);
		preDTO.setId_obspre(obs.getId_obspre());
		preDTO.setSd_come_way(obs.getSd_come_way());
		preDTO.setSds_companion(obs.getSds_companion());
		preDTO.setIds_companion(obs.getIds_companion());
		preDTO.setFg_has_touchanim(obs.getFg_has_touchanim());
		preDTO.setDt_entry(obs.getDt_entry());
	}
	/**
	 * 保存预检信息
	 * @param preDTO
	 * @return
	 * @throws BizException
	 */
	public EmergPreDTO savePre(EmergPreDTO preDTO,String entpCode) throws BizException{
		//1、保存就诊病情等级和复诊标志
		this.saveOp(preDTO);
		
		//2、保存预检
		saveObsPre(preDTO);
		//3、更新队列优先级
		IEnQueOutCmdService enQueOutService = ServiceFinder.find(IEnQueOutCmdService.class);
		enQueOutService.updateEntLevelPri(preDTO.getId_ent());
		
		return preDTO;
	}

	private void saveObsPre(EmergPreDTO preDTO)throws BizException {
		IObspreCudService obspreCudser=ServiceFinder.find(IObspreCudService.class);
		ObspreAggDO obsagg=null;
		//是否新增生命体征
		boolean isAddVt = true;
		if(preDTO.getId_obspre()!=null){
			IObspreRService obspreser=ServiceFinder.find(IObspreRService.class);
			obsagg = obspreser.findById(preDTO.getId_obspre());
			if(obsagg  == null){
				throw new BizException("没有找到预检数据！");
			}
			isAddVt = !hasSrvValue(obsagg);
			ObsPreDO predo=obsagg.getParentDO();
			emgToObs(preDTO, predo);
			predo.setStatus(DOStatus.UPDATED);
			List<ObsPreSrvDO> srvlist=new ArrayList<ObsPreSrvDO>();
			if (preDTO.getSrvarray()!=null && !preDTO.getSrvarray().isEmpty()){
				for (Object phydo : preDTO.getSrvarray()) {
					PhySignDTO phy=(PhySignDTO) phydo ;
					boolean isNew = true;
					for (ObsPreSrvDO srv : obsagg.getObsPreSrvDO()) {
						if(srv.getId_srv().equals(phy.getId_srv())){
							this.phySignToObsSrv(phy, srv);
							srv.setStatus(DOStatus.UPDATED);
							isNew = false;
							srvlist.add(srv);
							break;
						}
					}
					if(isNew){
						ObsPreSrvDO srvdo=new ObsPreSrvDO();
						srvdo.setStatus(DOStatus.NEW);
						srvdo.setId_obspre(predo.getId_obspre());
						srvdo.setId_ent(preDTO.getId_ent());
						this.phySignToObsSrv(phy, srvdo);
						srvlist.add(srvdo);
					}
				}
			}
			if(srvlist.size()>0)
				obsagg.setObsPreSrvDO(srvlist.toArray(new ObsPreSrvDO[0]));
		}else{
			obsagg=new ObspreAggDO();
			ObsPreDO predo=new ObsPreDO();
			emgToObs(preDTO, predo);
			List<ObsPreSrvDO> srvlist = new ArrayList<ObsPreSrvDO>();
			if (preDTO.getSrvarray()!=null && !preDTO.getSrvarray().isEmpty()) {
				for (Object phydo : preDTO.getSrvarray()) {
					ObsPreSrvDO srvdo = new ObsPreSrvDO();
					PhySignDTO phy = (PhySignDTO) phydo;
					srvdo.setId_ent(preDTO.getId_ent());
					this.phySignToObsSrv(phy, srvdo);
					srvlist.add(srvdo);

				}
			}
			predo.setStatus(DOStatus.NEW);
			obsagg.setParentDO(predo);
			if(srvlist.size()>0)
				obsagg.setObsPreSrvDO(srvlist.toArray(new ObsPreSrvDO[0]));
			
		}
		ObspreAggDO[] agg = obspreCudser.save(new ObspreAggDO[]{obsagg});
		//发送生命体征事件
		this.invokeMrEvent(agg[0], isAddVt);
	}

	/**
	 * 把EmergPreDTO的数据转换为ObsPreDO
	 * 
	 * @param preDTO
	 * @param obs
	 */
	private void emgToObs(EmergPreDTO preDTO, ObsPreDO obs) {
		obs.setFg_chk_eqidemic(preDTO.getFg_chk_eqidemic());
		obs.setChk_note(preDTO.getChk_note());
		obs.setDt_rescue_b(preDTO.getDt_rescue_b());
		obs.setDt_rescue_e(preDTO.getDt_rescue_e());
		obs.setFg_has_eqidarea(preDTO.getFg_has_eqidarea());
		obs.setFg_has_hot(preDTO.getFg_has_hot());
		obs.setFg_has_hot2(preDTO.getFg_has_hot2());
        obs.setFg_has_touchanim(preDTO.getFg_has_touchanim());
		obs.setId_come_way(preDTO.getId_come_way());
		obs.setId_obspre(preDTO.getId_obspre());
		obs.setSd_come_way(preDTO.getSd_come_way());
		obs.setSds_companion(preDTO.getSds_companion());
		obs.setIds_companion(preDTO.getIds_companion());
		obs.setId_ent(preDTO.getId_ent());
		obs.setDt_entry(preDTO.getDt_entry());
	}
	
	/**
	 * 把PhySignDTO的数据转换为ObsPreSrvDO
	 * 
	 * @param phySign
	 * @param srvdo
	 */
	private void phySignToObsSrv(PhySignDTO phy, ObsPreSrvDO srvdo){
		if(srvdo.getId_srv()==null){
			srvdo.setId_srv(phy.getId_srv());
		}
		srvdo.setVal0(phy.getVal0());
		srvdo.setVal1(phy.getVal1());
		srvdo.setVal2(phy.getVal2());
		srvdo.setVal3(phy.getVal3());
		srvdo.setVal4(phy.getVal4());
	}
	/**
	 * 保存就诊病情等级和复诊标志
	 * 
	 * @param preDTO
	 * @throws BizException 
	 */
	private void saveOp(EmergPreDTO preDTO) throws BizException{
		String entId = preDTO.getId_ent();
		IOutpatientRService opRServ = ServiceFinder.find(IOutpatientRService.class);
		OutpatientDO[] ops = opRServ.findByAttrValString(OutpatientDO.ID_ENT, entId);
		if(ArrayUtil.isEmpty(ops))
			throw new BizException("没有找到门诊记录！");
		ops[0].setStatus(DOStatus.UPDATED);
		ops[0].setId_level_dise(preDTO.getId_level_dise());
		ops[0].setSd_level_dise(preDTO.getSd_level_dise());
		ops[0].setFg_first(new FBoolean(!(FBoolean.TRUE.equals(preDTO.getFg_revisit()))));
		ops[0].setEu_preobs(EuPreObs.ALREADYPREOBS);
		IOutpatientCudService opCudServ = ServiceFinder.find(IOutpatientCudService.class);
		opCudServ.save(new OutpatientDO[]{ ops[0] });
	}
	/**
	 * 获取预检模板
	 * 
	 * @return
	 * @throws BizException
	 */
	private PhySignDTO[] getPhySigns(String depId, String entpCode) throws BizException {
		VstmatchparanDTO vstmatchparanDTO = new VstmatchparanDTO();
		depId = StringUtil.isEmptyWithTrim(depId)?Context.get().getDeptId(): depId;
		vstmatchparanDTO.setId_dep(depId);
		vstmatchparanDTO.setFg_newborn(FBoolean.FALSE);
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(entpCode)){
			vstmatchparanDTO.setFun_code(IEnFunCodeConst.FUN_CODE_OPPREEXAM);
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(entpCode)){
			vstmatchparanDTO.setFun_code(IEnFunCodeConst.FUN_CODE_URGPREEXAM);
		}
		vstmatchparanDTO.setEu_sex(EnumSexTp.GENERAL);
		vstmatchparanDTO.setCode_entp(entpCode);
		IMpNrQueryService serv = ServiceFinder.find(IMpNrQueryService.class);
		return serv.getPhySignDTOInfo(vstmatchparanDTO);
	}
	/**
	 * 是否存在生命体征值
	 * 
	 * @param agg
	 * @return
	 */
	private boolean hasSrvValue(ObspreAggDO agg){
		if(agg == null || ArrayUtil.isEmpty(agg.getObsPreSrvDO()))
			return false;
		ObsPreSrvDO[] srvs = agg.getObsPreSrvDO();
		for(ObsPreSrvDO srv : srvs){
			if(!StringUtil.isEmptyWithTrim(srv.getVal0()))
				return true;
		}
		return false;
	}
	
	/**
	 * 发送生命体征事件
	 * 
	 * @param agg
	 * @throws BizException
	 */
	private void invokeMrEvent(ObspreAggDO agg, boolean isAddVt)
			throws BizException {
		if (agg == null)
			return;
		if (isAddVt && !hasSrvValue(agg))
			return;
		EventDispatcher.fireEvent(new BusinessEvent(
				IMpEventConst.EVENT_MP_VS_LISTENING,
				isAddVt ? IMpEventConst.EVENT_MP_NEW
						: IMpEventConst.EVENT_MP_UPDATE, agg.getObsPreSrvDO()));
	}
}
