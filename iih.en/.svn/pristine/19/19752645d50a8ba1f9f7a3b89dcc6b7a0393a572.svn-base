package iih.en.comm.ep;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgStayRegistryDTO;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpCudService;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.hpdto.d.IpHpRegistDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.mi.bd.d.InsurKindBaseInfoDTO;
import iih.mi.bd.d.PatCaBaseInfoDTO;
import iih.mi.bd.i.IMiBdQryService;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;


/**
 * 就诊医保计划EP
 *
 */
public class EntHpEP {
	/**
	 * 获取就诊医保集合
	 * @param entIdList 就诊id集合
	 * @return
	 * @throws BizException
	 */
	public EntHpDO[] getEntMajHpList(List<String> entIdList) throws BizException{		
		if(EnValidator.isEmpty(entIdList)){
			return null;
		}
		IEnthpRService rservice = this.getEntHpRServ();
		EntHpDO[] entHpDOArr = rservice.find(EnSqlUtils.getInSqlByIds("id_ent", entIdList), "id_ent ,fg_maj DESC" , FBoolean.FALSE);
        return entHpDOArr;
	}
	/**
	 * 获取就诊医保集合
	 * @param entIdList 就诊id集合
	 * @return
	 * @throws BizException
	 */
	public EntHpDO[] getEntHpList(String entId) throws BizException{		
		IEnthpRService rservice = this.getEntHpRServ();
		String whereStr = String.format("Id_ent='%s'",entId);
		String orderStr = "fg_maj DESC";
		EntHpDO[] entHpDOs = rservice.find(whereStr,orderStr,FBoolean.FALSE);
        return entHpDOs;
	}
	/**
	 * 删除就诊的医保计划
	 * @param entId 就诊id
	 * @throws BizException
	 */
	public void deleteByEntId(String entId) throws BizException{
		EntHpDO[] entHpDOArray = this.getEntHpList(entId);
		if(!EnValidator.isEmpty(entHpDOArray)){
			this.getEntHpCudServ().delete(entHpDOArray);
		}
	}
	
	/**
	 * 保存就诊医保
	 * @param regInfo 挂号信息
	 * @throws BizException
	 */
	public EntHpDO[] saveEntHp(RegInfoDTO regInfo) throws BizException{
		if(EnValidator.isEmpty(regInfo.getId_hp())){
			return null;//主医保为空，则返回
		}
		List<EntHpDO> hpList = new ArrayList<EntHpDO>();		
		//主医保
		EntHpDO mainEntHpDO = new EntHpDO();
		mainEntHpDO.setStatus(DOStatus.NEW);
		mainEntHpDO.setId_ent(regInfo.getId_ent());
		mainEntHpDO.setSortno(1);
		mainEntHpDO.setId_hp(regInfo.getId_hp());
		mainEntHpDO.setNo_hp(regInfo.getNo_hp());
		mainEntHpDO.setFg_maj(FBoolean.TRUE);
		mainEntHpDO.setFg_fundpay(regInfo.getFg_hpsettle());//医保基金支付标志，辅医保暂不处理
		mainEntHpDO.setFg_hp_card(regInfo.getFg_hp_card());//是否持卡
		mainEntHpDO.setCode_hppatca(regInfo.getCode_hppatca());//患者医保身份
		mainEntHpDO.setCode_hparea(regInfo.getCode_hparea());//医保统筹区域
		mainEntHpDO.setCode_hpmedkind(regInfo.getCode_hpmedkind());
		mainEntHpDO.setPersonno(regInfo.getPersonno());//个人编号
		if(!EnValidator.isEmpty(regInfo.getCode_hpkind())){
			InsurKindBaseInfoDTO insurKind = getInsurKind(regInfo.getId_hp(), regInfo.getCode_hpkind());
			if(insurKind!=null){
				mainEntHpDO.setId_hpkind(insurKind.getId_insurkind());//险种ID
				mainEntHpDO.setCode_hpkind(insurKind.getCode());//险种编码
			}			
		}
		if(EnValidator.isEmpty(mainEntHpDO.getCode_hpkind())){
			//设置险种、特病
			PiPatCaHpDO patCaHpDO = this.getPatCaHp(regInfo.getId_patca());
			if(patCaHpDO!=null){
				mainEntHpDO.setId_hpkind(patCaHpDO.getId_hpkind());//险种ID
				mainEntHpDO.setCode_hpkind(patCaHpDO.getCode_hpkind());//险种编码
			}
		}
		//设置患者医保身份
		PatCaBaseInfoDTO insurPatCa = getInsurPatCa(regInfo.getId_hp(), regInfo.getCode_hppatca());
		if(insurPatCa != null){
			mainEntHpDO.setCode_hppatca(insurPatCa.getCode());
			mainEntHpDO.setId_hppatca(insurPatCa.getId_patca());
		}
		
		hpList.add(mainEntHpDO);
		
		//辅助医保,需依赖于主医保存在
		if(!EnValidator.isEmpty(regInfo.getId_hp_as())){
			EntHpDO extraEntHpDO = new EntHpDO();
			extraEntHpDO.setStatus(DOStatus.NEW);
			extraEntHpDO.setId_ent(regInfo.getId_ent());
			extraEntHpDO.setSortno(2);
			extraEntHpDO.setId_hp(regInfo.getId_hp_as());
			extraEntHpDO.setNo_hp(regInfo.getNo_hp_as());
			extraEntHpDO.setFg_maj(FBoolean.FALSE);
			hpList.add(extraEntHpDO);
		}
		
		return this.save(hpList.toArray(new EntHpDO[0]));
	}
	/**
	 * 保存就诊医保
	 * @param urgStayRegistry 急诊登记信息
	 * @throws BizException
	 */
	public EntHpDO[] saveEntHp(UrgStayRegistryDTO urgStayRegistry) throws BizException{
		if(EnValidator.isEmpty(urgStayRegistry.getId_hp())){
			return null;//主医保为空，则返回
		}	
		//主医保
		EntHpDO mainEntHpDO = new EntHpDO();
		mainEntHpDO.setStatus(DOStatus.NEW);
		mainEntHpDO.setId_ent(urgStayRegistry.getId_ent());
		mainEntHpDO.setSortno(1);
		mainEntHpDO.setId_hp(urgStayRegistry.getId_hp());
		mainEntHpDO.setNo_hp(urgStayRegistry.getNo_hp());
		mainEntHpDO.setFg_maj(FBoolean.TRUE);
		mainEntHpDO.setFg_fundpay(urgStayRegistry.getFg_fundpay());//医保基金支付标志，辅医保暂不处理
		mainEntHpDO.setFg_hp_card(urgStayRegistry.getFg_hp_card());//是否持卡
		mainEntHpDO.setCode_hppatca(urgStayRegistry.getCode_hppatca());//患者医保身份
		mainEntHpDO.setCode_hparea(urgStayRegistry.getCode_hparea());//医保统筹区域
		mainEntHpDO.setCode_hpkind(urgStayRegistry.getCode_hpkind());
		mainEntHpDO.setPersonno(urgStayRegistry.getPersonno());
		mainEntHpDO.setCode_hpmedkind(urgStayRegistry.getCode_hpmedkind());
		if(!EnValidator.isEmpty(urgStayRegistry.getCode_hpkind())){
			InsurKindBaseInfoDTO insurKind = getInsurKind(urgStayRegistry.getId_hp(), urgStayRegistry.getCode_hpkind());
			if(insurKind!=null){
				mainEntHpDO.setId_hpkind(insurKind.getId_insurkind());//险种ID
				mainEntHpDO.setCode_hpkind(insurKind.getCode());//险种编码
			}			
		}
		if(EnValidator.isEmpty(mainEntHpDO.getCode_hpkind())){
			//设置险种、特病
			PiPatCaHpDO patCaHpDO = this.getPatCaHp(urgStayRegistry.getId_patca());
			if(patCaHpDO!=null){
				mainEntHpDO.setId_hpkind(patCaHpDO.getId_hpkind());//险种ID
				mainEntHpDO.setCode_hpkind(patCaHpDO.getCode_hpkind());//险种编码
			}
		}
		//设置患者医保身份
		PatCaBaseInfoDTO insurPatCa = getInsurPatCa(urgStayRegistry.getId_hp(), urgStayRegistry.getCode_hppatca());
		if(insurPatCa != null){
			mainEntHpDO.setCode_hppatca(insurPatCa.getCode());
			mainEntHpDO.setId_hppatca(insurPatCa.getId_patca());
		}

		return this.save(new EntHpDO[]{ mainEntHpDO });
	}
	/**
	 * 获取患者分类医保计划
	 * @param patCaId 患者分类ID
	 * @throws BizException
	 */
	public PiPatCaHpDO getPatCaHp(String patCaId) throws BizException{
		IPatcatehpRService patCaHpService = ServiceFinder.find(IPatcatehpRService.class);
		PiPatCaHpDO[] patCaHpDOs = patCaHpService.findByAttrValString("Id_patca",patCaId);
		if(EnValidator.isEmpty(patCaHpDOs)){
			return null;
		}
		return patCaHpDOs[0];		
	}
	/**
	 * 登录医保数据
	 * @param entId 就诊id
	 * @param majHpId 主医保计划id
	 * @param majHpNo 主医保计划卡号
	 * @param secHpId 辅医保计划id
	 * @param secHpNo 辅医保计划卡号
	 * @throws BizException
	 */
	public void saveEntHp(String entId,String majHpId,String majHpNo,String secHpId,String secHpNo)throws BizException {
		this.saveEntHp(entId, majHpId, majHpNo, secHpId, secHpNo,FBoolean.FALSE, FBoolean.FALSE);
	}
	/**
	 * 保存就诊医保
	 * @param hosRegDto 
	 * @throws BizException
	 */
	public void saveEntHp(String entId, EnHosRegDTO hosRegDto)throws BizException {
		if(EnValidator.isEmpty(hosRegDto.getPrim_cplan())){
			return;//主医保为空，直接返回
		}
		List<EntHpDO> hpList = new ArrayList<EntHpDO>();		
		//主医保
		EntHpDO mainEntHpDO = new EntHpDO();
		mainEntHpDO.setStatus(DOStatus.NEW);
		mainEntHpDO.setId_ent(entId);
		mainEntHpDO.setSortno(1);
		mainEntHpDO.setId_hp(hosRegDto.getPrim_cplan());
		mainEntHpDO.setNo_hp(hosRegDto.getCode_hp());
		mainEntHpDO.setFg_maj(FBoolean.TRUE);
		mainEntHpDO.setFg_fundpay(FBoolean.TRUE);//医保基金支付标志，辅医保暂不处理
		mainEntHpDO.setFg_hp_card(FBoolean.TRUE);//是否持卡
		mainEntHpDO.setCode_hppatca(hosRegDto.getCode_hppatca());//患者医保身份
		mainEntHpDO.setCode_hparea(hosRegDto.getCode_hparea());//医保统筹区域
		mainEntHpDO.setCode_hpkind(hosRegDto.getCode_hpkind());
		mainEntHpDO.setCode_hpmedkind(hosRegDto.getCode_hpmedkind());
		if(!EnValidator.isEmpty(hosRegDto.getCode_hpkind())){
			InsurKindBaseInfoDTO insurKind = getInsurKind(hosRegDto.getPrim_cplan(), hosRegDto.getCode_hpkind());
			if(insurKind!=null){
				mainEntHpDO.setId_hpkind(insurKind.getId_insurkind());//险种ID
				mainEntHpDO.setCode_hpkind(insurKind.getCode());//险种编码
			}				
		}
		//设置患者医保身份
		PatCaBaseInfoDTO insurPatCa = getInsurPatCa(hosRegDto.getPrim_cplan(), hosRegDto.getCode_hppatca());
		if(insurPatCa != null){
			mainEntHpDO.setCode_hppatca(insurPatCa.getCode());
			mainEntHpDO.setId_hppatca(insurPatCa.getId_patca());
		}
		//设置患者医保的个人编号，fanlq-2018-05-19
		if(!EnValidator.isEmpty(hosRegDto.getPersonno())){
			mainEntHpDO.setPersonno(hosRegDto.getPersonno());
		}
		hpList.add(mainEntHpDO);
		
		//辅助医保,需依赖于主医保存在
		if(!EnValidator.isEmpty(hosRegDto.getId_enthp_auxi())){
			EntHpDO extraEntHpDO = new EntHpDO();
			extraEntHpDO.setStatus(DOStatus.NEW);
			extraEntHpDO.setId_ent(entId);
			extraEntHpDO.setSortno(2);
			extraEntHpDO.setId_hp(hosRegDto.getAuxi_cplan());
			extraEntHpDO.setNo_hp(hosRegDto.getCode_hp2());
			extraEntHpDO.setFg_maj(FBoolean.FALSE);
			hpList.add(extraEntHpDO);
		}
		this.save(hpList.toArray(new EntHpDO[0]));
	}
	/**
	 * 保存就诊医保
	 * 
	 * @param ipHpRegist
	 * @throws BizException
	 */
	public void saveEntHp(IpHpRegistDTO ipHpRegist) throws BizException{
		if(EnValidator.isEmpty(ipHpRegist.getId_hp())){
			return;//主医保为空，直接返回
		}
		List<EntHpDO> hpList = new ArrayList<EntHpDO>();		
		//主医保
		EntHpDO mainEntHpDO = new EntHpDO();
		mainEntHpDO.setStatus(DOStatus.NEW);
		mainEntHpDO.setId_ent(ipHpRegist.getId_ent());
		mainEntHpDO.setSortno(1);
		mainEntHpDO.setId_hp(ipHpRegist.getId_hp());
		mainEntHpDO.setNo_hp(ipHpRegist.getNo_hp());
		mainEntHpDO.setFg_maj(FBoolean.TRUE);
		mainEntHpDO.setFg_fundpay(FBoolean.TRUE);//医保基金支付标志，辅医保暂不处理
		mainEntHpDO.setFg_hp_card(ipHpRegist.getFg_hp_card());//是否持卡
		mainEntHpDO.setCode_hppatca(ipHpRegist.getCode_hppatca());//患者医保身份
		mainEntHpDO.setCode_hparea(ipHpRegist.getCode_hparea());//医保统筹区域
		mainEntHpDO.setCode_hpkind(ipHpRegist.getCode_hpkind());
		mainEntHpDO.setCode_hpmedkind(ipHpRegist.getCode_hpmedkind());
		InsurKindBaseInfoDTO insurKind = getInsurKind(ipHpRegist.getId_hp(), ipHpRegist.getCode_hpkind());
		if(insurKind != null){
			mainEntHpDO.setId_hpkind(insurKind.getId_insurkind());//险种ID
			mainEntHpDO.setCode_hpkind(insurKind.getCode());//险种编码
		}
		//设置患者医保身份
		PatCaBaseInfoDTO insurPatCa = getInsurPatCa(ipHpRegist.getId_hp(), ipHpRegist.getCode_hppatca());
		if(insurPatCa != null){
			mainEntHpDO.setCode_hppatca(insurPatCa.getCode());
			mainEntHpDO.setId_hppatca(insurPatCa.getId_patca());
		}
		//设置患者医保的个人编号，fanlq-2018-05-19
		if(!EnValidator.isEmpty(ipHpRegist.getPersonno())){
			mainEntHpDO.setPersonno(ipHpRegist.getPersonno());
		}
		hpList.add(mainEntHpDO);
		this.save(hpList.toArray(new EntHpDO[0]));
	}
	/**
	 * 登录医保数据
	 * @param entId 就诊id
	 * @param majHpId 主医保计划id
	 * @param majHpNo 主医保计划卡号
	 * @param secHpId 辅医保计划id
	 * @param secHpNo 辅医保计划卡号
	 * @param isHpFundpay 是否医保基金支付
	 * @throws BizException
	 */
	public void saveEntHp(String entId,String majHpId,String majHpNo,String secHpId,String secHpNo,FBoolean isHpFundpay, FBoolean ishpCard)throws BizException {
		if(EnValidator.isEmpty(majHpId)){
			return;//主医保为空，直接返回
		}
		List<EntHpDO> hpList = new ArrayList<EntHpDO>();		
		//主医保
		EntHpDO mainEntHpDO = new EntHpDO();
		mainEntHpDO.setStatus(DOStatus.NEW);
		mainEntHpDO.setId_ent(entId);
		mainEntHpDO.setSortno(1);
		mainEntHpDO.setId_hp(majHpId);
		mainEntHpDO.setNo_hp(majHpNo);
		mainEntHpDO.setFg_maj(FBoolean.TRUE);
		mainEntHpDO.setFg_fundpay(isHpFundpay);//医保基金支付标志，辅医保暂不处理
		mainEntHpDO.setFg_hp_card(ishpCard);
		hpList.add(mainEntHpDO);
		
		//辅助医保,需依赖于主医保存在
		if(!EnValidator.isEmpty(secHpId)){
			EntHpDO extraEntHpDO = new EntHpDO();
			extraEntHpDO.setStatus(DOStatus.NEW);
			extraEntHpDO.setId_ent(entId);
			extraEntHpDO.setSortno(2);
			extraEntHpDO.setId_hp(secHpId);
			extraEntHpDO.setNo_hp(secHpNo);
			extraEntHpDO.setFg_maj(FBoolean.FALSE);
			hpList.add(extraEntHpDO);
		}
		
		this.save(hpList.toArray(new EntHpDO[0]));
	}
	/**
	 * 保存
	 * @param entHpDOArray 就诊医保集合
	 * @throws BizException
	 */
	public EntHpDO[] save(EntHpDO[] entHpDOArray) throws BizException{
		if(EnValidator.isEmpty(entHpDOArray))
			return null;
		return this.getEntHpCudServ().save(entHpDOArray);
	}	
	/**
	 * 获取就诊主医保
	 * @param entIdList 就诊id集合
	 * @return
	 * @throws BizException
	 */
	public EntHpDO getMainEntHp(String entId) throws BizException{		
		String whereStr = String.format("Id_ent='%s' and fg_maj ='Y' ",entId);
		EntHpDO[] entHpDOs = getEntHpRServ().find(whereStr,"",FBoolean.FALSE);
		if(!EnValidator.isEmpty(entHpDOs)){			
			return entHpDOs[0];
		}
		return null;
	}
	/**
	 * 通过就诊ID和医保Id获取就诊医保
	 * 
	 * @param entId
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	public EntHpDO getEntHpById(String entId, String hpId) throws BizException{
		String whereStr = String.format("Id_ent='%s' and id_hp ='%s' ", entId, hpId);
		EntHpDO[] entHpDOs = getEntHpRServ().find(whereStr,"",FBoolean.FALSE);
		if(!EnValidator.isEmpty(entHpDOs)){			
			return entHpDOs[0];
		}
		return null;
	}
	/**
	 * 获取查询操作服务
	 * 
	 * @return
	 */
	public IEnthpRService getEntHpRServ(){
		return ServiceFinder.find(IEnthpRService.class);
	}
	/**
	 * 获取增删改操作服务
	 * 
	 * @return
	 */
	public IEnthpCudService getEntHpCudServ(){
		return ServiceFinder.find(IEnthpCudService.class);
	}
	/**
	 * 根据险种编码查询险种基础信息
	 * 
	 * @param hpId
	 * @param kindCode
	 * @return
	 * @throws BizException
	 */
	public InsurKindBaseInfoDTO getInsurKind(String hpId, String kindCode) throws BizException{
		if(EnValidator.isEmpty(hpId) || EnValidator.isEmpty(kindCode))
			return null;
		IMiBdQryService serv = ServiceFinder.find(IMiBdQryService.class);
		InsurKindBaseInfoDTO[] insurKindBaseInfos = serv.findInsurKindsByCodes(hpId, new String[]{ kindCode });
		if(EnValidator.isEmpty(insurKindBaseInfos))
			return null;
		return insurKindBaseInfos[0];
	}
	/**
	 * 根据患者身份编码查询患者身份基础信息
	 * 
	 * @param hpId
	 * @param kindCode
	 * @return
	 * @throws BizException
	 */
	public PatCaBaseInfoDTO getInsurPatCa(String hpId, String insurPatCa) throws BizException{
		if(EnValidator.isEmpty(hpId) || EnValidator.isEmpty(insurPatCa))
			return null;
		IMiBdQryService serv = ServiceFinder.find(IMiBdQryService.class);
		PatCaBaseInfoDTO[] insurPatCas = serv.findPatsCaByCodes(hpId, new String[]{ insurPatCa });
		if(EnValidator.isEmpty(insurPatCas))
			return null;
		return insurPatCas[0];
	}
}
