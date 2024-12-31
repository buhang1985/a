package iih.en.pv.s.bp.op;

import iih.en.comm.ep.OpEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.s.bp.op.st.BatchLoadCgInfoBP;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptOutQryService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.desc.ent.dataobject.EnumDescUtil;
import xap.sys.appfw.orm.desc.ent.dataobject.EnumDescription;

/**
 * 获取患者已挂号列表
 * @author yank
 *
 */
public class GetPatsRegListBP {
	
	/**
	 * 对RegInfoDTO集合进行处理,退号特殊处理
	 * 
	 * @param regInfos
	 * @param withPri
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO[] decorateRegInfo4CancReg(String patId,RegInfoDTO[] regInfos, FBoolean withPri) throws BizException{
		if(EnValidator.isEmpty(regInfos)){
			return null;
		}
		
		//2、加载挂号资源
		this.loadRes(patId,regInfos,FBoolean.FALSE);
		
		//3、加载价格信息
		if(FBoolean.TRUE.equals(withPri)){
			BatchLoadCgInfoBP loadCgBP = new BatchLoadCgInfoBP();
			loadCgBP.exec(regInfos);
		}
		
		//4、加载渠道信息
		this.loadChl(regInfos);
		
		return regInfos;
	}
	/**
	 * 检索患者挂号信息
	 * @param patId 患者id
	 * @param withPri　包含价格信息
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public RegInfoDTO[] exec(String patId, FBoolean withPri) throws BizException{
		//1、查询挂号信息
		GetRegInfoByPatBP getBP =new GetRegInfoByPatBP();
		RegInfoDTO[] regInfos = getBP.exec(patId);
		if(EnValidator.isEmpty(regInfos)){
			return null;
		}
		return this.decorateRegInfo(patId,regInfos, withPri);
	}
	/**
	 * 检索患者挂号信息
	 * @param patId 患者id
	 * @param withPri　包含价格信息
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public RegInfoDTO[] exec(String patId, FBoolean withPri, FDate bDate, FDate eDate) throws BizException{
		//1、查询挂号信息
		GetRegInfoByPatBP getBP =new GetRegInfoByPatBP();
		RegInfoDTO[] regInfos = getBP.exec(patId, bDate, eDate);
		if(EnValidator.isEmpty(regInfos)){
			return null;
		}
		return this.decorateRegInfo(patId,regInfos, withPri);
	}
	/**
	 * 对RegInfoDTO集合进行处理
	 * 
	 * @param regInfos
	 * @param withPri
	 * @return
	 * @throws BizException
	 */
	private RegInfoDTO[] decorateRegInfo(String patId,RegInfoDTO[] regInfos, FBoolean withPri) throws BizException{
		if(EnValidator.isEmpty(regInfos)){
			return null;
		}
		
		//2、加载挂号资源
		this.loadRes(patId,regInfos,withPri);
		
		//3、加载价格信息
		if(FBoolean.TRUE.equals(withPri)){
			BatchLoadCgInfoBP loadCgBP = new BatchLoadCgInfoBP();
			loadCgBP.exec(regInfos);
		}
		
		//4、加载渠道信息
		this.loadChl(regInfos);
		
		return regInfos;
	}
	/**
	 * 加载挂号资源信息
	 * @param regInfos 挂号信息DTO
	 * @throws BizException
	 */
	private void loadRes(String patId,RegInfoDTO[] regInfos,FBoolean withPri) throws BizException{	
		List<RegResDTO> noCgRegResList = new ArrayList<>();
		List<String> schIdList = new ArrayList<String>();
		for(RegInfoDTO regInfo : regInfos){
			if(EnValidator.isEmpty(regInfo.getId_sch())){
				OutpatientDO op = new OpEP().getOpByEntId(regInfo.getId_ent());
				RegResDTO regRes = new RegResDTO();
				regRes.setId_dayslot(regInfo.getId_dayslot());
				regRes.setName_dayslot(regInfo.getDayslot());
				regRes.setD_sch(regInfo.getRegisted_date());
				regRes.setId_scres(op.getId_scres());
				regRes.setId_scsrv(op.getId_scsrv());
				regRes.setId_dep(op.getId_dep_reg());
				regRes.setName_dep(op.getDep_reg_name());
				String name_scpl = !EnValidator.isEmpty(op.getScres_name()) ? op.getScres_name() : op.getDep_reg_name();
				if(!EnValidator.isEmpty(op.getScsrv_name())){
					name_scpl += "(" + op.getScsrv_name() + ")";
				}
				regRes.setName_scpl(name_scpl);
				regInfo.setRegres(name_scpl);
				regInfo.setRegresarray(EnAppUtils.doArray2List(regRes));
				noCgRegResList.add(regRes);	
			}else{
				schIdList.add(regInfo.getId_sch());
			}
		}
		if(!EnValidator.isEmpty(noCgRegResList)){
			IScSchOutQryService schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
			//1.加载挂号资源价格
			schOutQryService.loadResPri(noCgRegResList.toArray(new RegResDTO[0]));
		}
		IScSchOutQryService schService = ServiceFinder.find(IScSchOutQryService.class);
		RegResDTO[] regResArray = schService.getRegResBySch4CanaReg(patId,schIdList.toArray(new String[0]),withPri);
		if(EnValidator.isEmpty(regResArray))return;
		for(RegInfoDTO regInfo : regInfos){
			if(EnValidator.isEmpty(regInfo.getId_sch()))
				continue;
			for(RegResDTO regRes : regResArray){
				if(regRes==null)continue;
				if(regInfo.getId_sch().equals(regRes.getId_sch()) && 
						regInfo.getId_scsrv().equals(regRes.getId_scsrv())){
					regInfo.setRegresarray(EnAppUtils.doArray2List((RegResDTO)regRes.clone()));
					break;
				}
			}
		}
	}

	/**
	 * 加载渠道信息
	 * 
	 * @param regInfos
	 * @throws BizException
	 */
	private void loadChl(RegInfoDTO[] regInfos) throws BizException {
		List<String> entIdList = new ArrayList<String>();
		for (RegInfoDTO regInfo : regInfos) {
			entIdList.add(regInfo.getId_ent());
		}
		// 1、获取就诊的预约渠道
		IScAptOutQryService aptQryService = ServiceFinder.find(IScAptOutQryService.class);
		OpAptDTO[] opAptDTOs = aptQryService.getOpAptChlList(entIdList.toArray(new String[0]));
		int length = opAptDTOs == null ? 0 : opAptDTOs.length;
		Map<String, OpAptDTO> chlMap = new HashMap<String, OpAptDTO>();
		if (length > 0) {
			OpAptDTO temp = null;
			for (int i = 0; i < length; i++) {
				temp = opAptDTOs[i];
				if (temp == null)
					continue;
				if (!chlMap.containsKey(temp.getId_ent())) {
					chlMap.put(temp.getId_ent(), temp);
				}
			}
		}
		
		// 2、渠道赋值
		Map<Object, EnumDescription> regTpMap = EnumDescUtil.getValue_EnumDescriptionMap(EuRegTp.class);
		for (RegInfoDTO regInfo : regInfos) {
			String chlName = chlMap.containsKey(regInfo.getId_ent()) ? chlMap.get(regInfo.getId_ent()).getName_scchl()
					: null;
			setChlName(regInfo, chlName, regInfo.getEu_regtp(), regTpMap);
		}
	}

	/**
	 * 设置渠道名称
	 * 
	 * @param regInfo 挂号信息
	 * @param chlName 渠道名称
	 * @param euRegTp 挂号类型
	 * @param regTpMap 挂号枚举类型集合
	 */
	private void setChlName(RegInfoDTO regInfo, String chlName, String euRegTp, Map<Object, EnumDescription> regTpMap) {
		// 如果渠道为空，则取挂号类型名称
		if (EnValidator.isEmpty(chlName)) {
			if (!EnValidator.isEmpty(euRegTp) && regTpMap.containsKey(euRegTp)) {
				chlName = regTpMap.get(euRegTp).getName();
			}
		}
		regInfo.setName_chl(chlName);
	}
}
