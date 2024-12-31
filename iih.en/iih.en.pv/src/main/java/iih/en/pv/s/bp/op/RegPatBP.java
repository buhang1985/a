package iih.en.pv.s.bp.op;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.i.IEnErCmdService;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.OpRegPiContDTO;
import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.dic.cardtype.i.ICardtypeRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.pat.i.IPiPatCardDOCudService;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者注册BP
 * @author wangjiayao,yank,liubin
 *
 */
public class RegPatBP {
	/**
	 * 挂号+患者注册
	 * @param patDTO 患者信息
	 * @param isSyncPatCa 是否同步患者分类
	 * @return
	 * @throws BizException
	 */
	public OpRegPatDTO regPat(OpRegPatDTO opRegPatDto, FBoolean isSyncPatCa) throws BizException{
		//1.验证患者信息
		this.valideOpRegPat(opRegPatDto);
		//2.获取AggDO
		PatiAggDO agg = getPatAggDO(opRegPatDto);
		//3.设置患者信息
		setPatInfo(agg, opRegPatDto, isSyncPatCa);
		//4.设置患者现地址信息
		setPatAddrInfo(agg, opRegPatDto);
		//5.设置患者医保信息
		setPatHpInfo(agg, opRegPatDto);
		//6.设置患者联系人信息
		setPatContInfo(agg, opRegPatDto);
		//保存患者AggDO
		savePatAggDO(agg, opRegPatDto);
		//7.设置患者面部识别信息
		setPatFaceInfo(agg, opRegPatDto);
		// 换患者处理
		changePatHandle(opRegPatDto);
		return opRegPatDto;
	}
	
	/**
	 * 获取患者AggDO
	 * 
	 * @param patDTO
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO getPatAggDO(OpRegPatDTO patDTO) throws BizException{
		if(EnValidator.isEmpty(patDTO.getId_pat()))
			return new PatiAggDO();
		IPatiRService serv = ServiceFinder.find(IPatiRService.class);
		PatiAggDO agg = serv.findById(patDTO.getId_pat());
		if(EnValidator.isEmpty(agg))
			throw new BizException("保存患者失败！");
		return agg;
	}
	/**
	 * 保存患者AggDO
	 * 
	 * @param agg
	 * @return
	 * @throws BizException
	 */
	private void savePatAggDO(PatiAggDO agg, OpRegPatDTO opRegPatDto) throws BizException{
		IPatiCudService serv = ServiceFinder.find(IPatiCudService.class);
		PatiAggDO[] aggs = serv.save(new PatiAggDO[]{agg});
		if(EnValidator.isEmpty(aggs))
			throw new BizException("保存患者失败！");
		agg = aggs[0];
		opRegPatDto.setId_pat(agg.getParentDO().getId_pat());
		opRegPatDto.setCode_pat(agg.getParentDO().getCode());
		opRegPatDto.setBarcode_chis(agg.getParentDO().getBarcode_chis());
		if(opRegPatDto.getMore() == null || opRegPatDto.getMore().isEmpty())
			return;
		OpRegPiContDTO regPiCont = (OpRegPiContDTO) opRegPatDto.getMore().get(0);
		PiPatContDO[] patConts =  agg.getPiPatContDO();
		if(EnValidator.isEmpty(patConts))
			return;
		for(PiPatContDO patCont : patConts){
			if(patCont.getSd_conttp().equals(regPiCont.getSd_conttp())){
				regPiCont.setId_pat(patCont.getId_pat());
				regPiCont.setId_patcont(patCont.getId_patcont());
				break;
			}
		}
	}
	/**
	 * 设置患者数据
	 * 
	 * @param agg
	 * @param patDTO
	 * @param isSyncPatCa
	 * @throws BizException 
	 */
	private void setPatInfo(PatiAggDO agg, OpRegPatDTO opRegPatDto, FBoolean isSyncPatCa) throws BizException{
		PatDO pat = agg.getParentDO();
		if(pat == null){
			pat = new PatDO();
			pat.setStatus(DOStatus.NEW);
		}else
			pat.setStatus(DOStatus.UPDATED);
		pat.setCode(opRegPatDto.getCode_pat());
		pat.setMnecode(pat.getCode());
		//实名认证标志
		pat.setFg_realname(opRegPatDto.getFg_realname());
		//chis条码号
		pat.setBarcode_chis(opRegPatDto.getBarcode_chis());
		//照片
		pat.setPhoto(opRegPatDto.getPhoto());
		//姓名
		pat.setName(opRegPatDto.getName_pat());
		pat.setPycode(opRegPatDto.getPycode());
		if(EnValidator.isEmpty(pat.getPycode()))
			pat.setPycode(EnAppUtils.getPyCode(pat.getName()));
		pat.setWbcode(opRegPatDto.getWbcode());
		if(EnValidator.isEmpty(pat.getWbcode()))
			pat.setWbcode(EnAppUtils.getWbCode(pat.getName()));
		pat.setId_grp(EnContextUtils.getGrpId());
		pat.setId_org(EnContextUtils.getOrgId());
		//性别
		pat.setId_sex(opRegPatDto.getId_sex());
		pat.setSd_sex(opRegPatDto.getSd_sex());
		pat.setName_sex(opRegPatDto.getName_sex());
		//出生日期
		pat.setDt_birth(opRegPatDto.getDt_birth());
		//证件
		pat.setId_idtp(opRegPatDto.getId_idtp());
		pat.setSd_idtp(opRegPatDto.getSd_idtp());
		pat.setIdtp_name(opRegPatDto.getName_idtp());
		pat.setId_code(opRegPatDto.getId());
		//婚姻
		pat.setId_marry(opRegPatDto.getId_marry());
		pat.setSd_marry(opRegPatDto.getSd_marry());
		pat.setMarry_name(opRegPatDto.getName_marry());
		//联系方式
		if(!EnValidator.isEmpty(opRegPatDto.getMob())){
		//如果联系方式是固话，清空手机
			if(EnAppUtils.isTel(opRegPatDto.getMob()))
			{
				pat.setMob(null);
				pat.setTel(opRegPatDto.getMob());
			}else
			 pat.setMob(opRegPatDto.getMob());
		}else{
			pat.setMob(null);
			pat.setTel(null);
		}
		if(FBoolean.TRUE.equals(isSyncPatCa)){
			//患者分类
			pat.setId_paticate(opRegPatDto.getId_patca());
			pat.setPaticate_name(opRegPatDto.getName_patca());
			//价格分类
			pat.setId_patpritp(opRegPatDto.getId_pripat());
			pat.setPatpritp_name(opRegPatDto.getName_pripat());
			//信用分类
			pat.setId_patcrettp(opRegPatDto.getId_patcredtp());
			pat.setPatcrettp_name(opRegPatDto.getName_patcredtp());
		}
		// 户籍类型
		pat.setId_srcregiontp(opRegPatDto.getId_srcregiontp());
		pat.setSd_srcregiontp(opRegPatDto.getSd_srcregiontp());
		
		pat.setId_occu(opRegPatDto.getId_occu());
		pat.setSd_occu(opRegPatDto.getSd_occu());
		
		pat.setFg_sync_en(FBoolean.TRUE);
		
		
		//民族
		
		pat.setId_nation(opRegPatDto.getId_nation());
	    pat.setNation_name(opRegPatDto.getName_nation());
		pat.setSd_nation(opRegPatDto.getSd_nation());
		agg.setParentDO(pat);
	}
	
	/**
	 * 设置患者现地址信息
	 * @param opRegPatDto
	 * @return
	 * @throws BizException
	 */
	private void setPatAddrInfo(PatiAggDO agg, OpRegPatDTO opRegPatDto) throws BizException{
		PatiAddrDO[] addrDOs = agg.getPatiAddrDO();
		List<PatiAddrDO> patAddrList = new LinkedList<PatiAddrDO>();
		if(!EnValidator.isEmpty(addrDOs))
			Collections.addAll(patAddrList, addrDOs);
		PatiAddrDO addrNow = null;
		int sortno = 0;
		for(PatiAddrDO addr : patAddrList){
			if(IPiDictCodeConst.SD_ADDR_TYPE_NOW.equals(addr.getSd_addrtp())){
				addrNow = addr;
				addrNow.setStatus(DOStatus.UPDATED);
				break;
			}
			if(addr.getSortno() != null && sortno < addr.getSortno())
				sortno = addr.getSortno();
		}
		if(addrNow == null){
			addrNow = new PatiAddrDO();
			addrNow.setId_pat(agg.getParentDO().getId_pat());
			addrNow.setSortno(++sortno);
			addrNow.setStatus(DOStatus.NEW);
			patAddrList.add(addrNow);
		}
		addrNow.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
		addrNow.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		addrNow.setStreet(opRegPatDto.getAddr_pat());
		addrNow.setId_pat(opRegPatDto.getId_pat());
		
		addrNow.setId_admdiv(opRegPatDto.getId_admdiv());
		addrNow.setSd_admdiv(opRegPatDto.getSd_admdiv());
		addrNow.setAdmdiv_name(opRegPatDto.getName_admdiv());
		addrNow.setAdmdiv_fullname(opRegPatDto.getName_admdiv());
		agg.setPatiAddrDO(patAddrList.toArray(new PatiAddrDO[0]));
	}
	/**
	 * 设置患者医保信息
	 * 
	 * @param agg
	 * @param opRegPatDto
	 * @throws BizException
	 */
	private void setPatHpInfo(PatiAggDO agg, OpRegPatDTO opRegPatDto) throws BizException {
		// 如果主医保不存在，则不处理。
		// 没有主医保，也肯定没有辅医保，辅医保依附主医保存在
		if(EnValidator.isEmpty(opRegPatDto.getId_hp()))
			return;
		PiPatHpDO[] patHps = agg.getPiPatHpDO();
		List<PiPatHpDO> patHpList = new LinkedList<PiPatHpDO>();
		if(!EnValidator.isEmpty(patHps))
			Collections.addAll(patHpList, patHps);
		boolean hasMainHp = false;
		boolean hasExtraHp = false;
		boolean hasDeft = false;
		int sortno = 0;
		for(PiPatHpDO patHp : patHpList){
			if(!hasDeft)
				hasDeft = FBoolean.TRUE.equals(patHp.getFg_deft());
			if (opRegPatDto.getId_hp().equals(patHp.getId_hp())) {
				patHp.setNo_hp(opRegPatDto.getNo_hp());
				patHp.setHp_name(opRegPatDto.getName_hp());
				patHp.setStatus(DOStatus.UPDATED);
				hasMainHp = true;
			}else if (!EnValidator.isEmpty(opRegPatDto.getId_hp_sec()) && opRegPatDto.getId_hp_sec().equals(patHp.getId_hp())) {
				patHp.setNo_hp(opRegPatDto.getNo_hp_sec());
				patHp.setHp_name(opRegPatDto.getName_hp_sec());
				patHp.setStatus(DOStatus.UPDATED);
				hasExtraHp = true;
			}
			if(patHp.getSortno() != null && sortno < patHp.getSortno())
				sortno = patHp.getSortno();
		}
		FDateTime currentTime = EnAppUtils.getServerDateTime();
		
		// 没有找到，则新建主医保
		if (!hasMainHp && !EnValidator.isEmpty(opRegPatDto.getId_hp())) {
			PiPatHpDO patHp = new PiPatHpDO();
			patHp.setId_pat(agg.getParentDO().getId_pat());
			patHp.setStatus(DOStatus.NEW);
			patHp.setSortno(++sortno); // 序号
			patHp.setId_hp(opRegPatDto.getId_hp()); // 医保计划
			patHp.setNo_hp(opRegPatDto.getNo_hp()); // 医保号
			patHp.setMode_hp(IPiDictCodeConst.ID_HP_ENABLE);
			// 没有主医保，则此就是主医保
			patHp.setFg_deft(new FBoolean(!hasDeft)); // 默认标志
			patHp.setDt_b(currentTime); // 有效日期开始
			patHp.setFg_act(FBoolean.TRUE); // 启用标志
			patHpList.add(patHp);
		}

		// 新建辅助医保
		if (!hasExtraHp && !EnValidator.isEmpty(opRegPatDto.getId_hp_sec())) {
			PiPatHpDO patHp = new PiPatHpDO();
			patHp.setStatus(DOStatus.NEW);
			patHp.setId_pat(agg.getParentDO().getId_pat());
			patHp.setSortno(++sortno); // 序号
			patHp.setId_hp(opRegPatDto.getId_hp_sec()); // 医保计划
			patHp.setNo_hp(opRegPatDto.getNo_hp_sec()); // 医保号
			patHp.setFg_deft(FBoolean.FALSE); // 默认标志
			patHp.setDt_b(currentTime); // 有效日期开始
			patHp.setFg_act(FBoolean.TRUE); // 启用标志
			patHp.setMode_hp(IPiDictCodeConst.ID_HP_ENABLE);
			patHpList.add(patHp);
		}
		agg.setPiPatHpDO(patHpList.toArray(new PiPatHpDO[0]));
	}
	
	/**
	 * 保存患者联系人
	 * 
	 * @param patId
	 * @param patDTO
	 * @throws BizException 
	 */
	private void setPatContInfo(PatiAggDO agg, OpRegPatDTO opRegPatDto) throws BizException{
		if(opRegPatDto.getMore()==null||opRegPatDto.getMore().isEmpty())
			return;
		OpRegPiContDTO regPiCont = (OpRegPiContDTO) opRegPatDto.getMore().get(0);
		PiPatContDO[] patConts =  agg.getPiPatContDO();
		List<PiPatContDO> patContList = new LinkedList<PiPatContDO>();
		if(!EnValidator.isEmpty(patConts))
			Collections.addAll(patContList, patConts);
		PiPatContDO newPiCont = null;
		Integer sortno = 0;
		for(PiPatContDO patCont : patContList){
			if(patCont.getSd_conttp().equals(regPiCont.getSd_conttp())){
				newPiCont = patCont;
				newPiCont.setStatus(DOStatus.UPDATED);
				break;
			}
			if(patCont.getSortno()!=null && sortno < patCont.getSortno())
				sortno = patCont.getSortno();
		}
		if(newPiCont == null){
			newPiCont = new PiPatContDO();
			newPiCont.setId_pat(agg.getParentDO().getId_pat());
			newPiCont.setStatus(DOStatus.NEW);
			newPiCont.setSortno(sortno);
			patContList.add(newPiCont);
		}
		newPiCont.setSd_conttp(regPiCont.getSd_conttp());
		newPiCont.setId_conttp(regPiCont.getId_conttp());
		newPiCont.setName(regPiCont.getName());
		newPiCont.setConttel(regPiCont.getConttel());
		newPiCont.setContaddr(regPiCont.getContaddr());
		agg.setPiPatContDO(patContList.toArray(new PiPatContDO[0]));
	}
	/**
	 * 保存患者面部识别信息
	 * 
	 * @param patId
	 * @param patDTO
	 * @throws BizException 
	 */
	private void setPatFaceInfo(PatiAggDO agg, OpRegPatDTO opRegPatDto) throws BizException{
		if(EnValidator.isEmpty(opRegPatDto.getFaceid())){
			return;
		}
		
		ICardtypeRService cardtpServicce = ServiceFinder.find(ICardtypeRService.class);
		PiPatCardTpDO[] piPatCardTpDOs = cardtpServicce.find(String.format("sd_patcardtp = '%s'", IPiDictCodeConst.SD_CARD_TYPE_FACEID), null, FBoolean.FALSE);
		if(EnValidator.isEmpty(piPatCardTpDOs) || EnValidator.isEmpty(piPatCardTpDOs[0])){
			return;
		}
		IPiPatCardDORService rService = ServiceFinder.find(IPiPatCardDORService.class);
		PiPatCardDO[] cardDos = rService.find("Code = '" + opRegPatDto.getFaceid() + "' AND  Sd_patcardtp = '" + piPatCardTpDOs[0].getCode() + "' AND FG_ACT = '"+FBoolean.TRUE+"' ", " DT_E DESC ", FBoolean.FALSE);
		if(!EnValidator.isEmpty(cardDos)){
			return;
		}
		IPiPatCardDOCudService service = ServiceFinder.find(IPiPatCardDOCudService.class);
		PiPatCardDO cardDo = new PiPatCardDO();
        cardDo.setStatus(DOStatus.NEW);
        cardDo.setId_pat(agg.getParentDO().getId_pat());
        cardDo.setId_patcardtp(piPatCardTpDOs[0].getId_cardtp());
        cardDo.setSd_patcardtp(piPatCardTpDOs[0].getCode());
        cardDo.setCode(opRegPatDto.getFaceid());
        cardDo.setDt_b(EnAppUtils.getServerDateTime());
        cardDo.setDt_e(new FDateTime("2099-12-31 23:59:59"));
        cardDo.setFg_act(FBoolean.TRUE);
        cardDo.setSortno(1);
        service.save(new PiPatCardDO[] { cardDo });
	}
	/**
	 * 换患者处理
	 * 
	 * @param opRegPatDto
	 * @throws BizException
	 */
	private void changePatHandle(OpRegPatDTO opRegPatDto)throws BizException{
		IEnErCmdService serv = ServiceFinder.find(IEnErCmdService.class);
		serv.changePatHandle(opRegPatDto);
	}
	
	/**
	 * 校验门诊登记DTO是否异常
	 * @param opRegPatDto
	 * @param isSyncPatCa 是否同步患者分类
	 * @throws BizException 
	 */
	private void valideOpRegPat(OpRegPatDTO opRegPatDto) throws BizException{
		if(opRegPatDto == null){
			throw new BizException("患者信息为空");
		}
	}
}
