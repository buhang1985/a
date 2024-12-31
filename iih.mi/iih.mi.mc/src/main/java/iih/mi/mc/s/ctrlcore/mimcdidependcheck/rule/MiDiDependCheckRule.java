package iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule;

import iih.mi.constant.IMiMcCheckConst;
import iih.mi.itf2.util.MiParamUtil;
import iih.mi.mc.dto.mimcdidependrule.d.MiMcDiDependInParamDTO;
import iih.mi.mc.dto.mimcdidependrule.d.MiMcDiDependOutParamDTO;
import iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp.MiCheckDiDependNoMedBP;
import iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp.MiCheckExcessDiDependBP;
import iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp.MiCheckInDicDiDependBP;
import iih.mi.mc.s.ctrlcore.mimcdidependcheck.rule.bp.MiCheckSpecillDiDependBP;
import iih.mi.mc.s.ctrlcore.rule.MiMcCheckRule;
import iih.mi.mc.s.util.MiBaseInfoUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 诊断依赖性校验(住院、急诊留观不校验特殊病、超量开药)
 * 
 * @author LIM
 * @since 2019-10-09
 */
public class MiDiDependCheckRule extends MiMcCheckRule{
	/**
	 * 诊断依赖性校验
	 * 
	 * @param inParamDTO
	 *            入参
	 * @return
	 * @throws BizException
	 */
	public MiMcDiDependOutParamDTO[] exec(MiMcDiDependInParamDTO inParamDTO) throws BizException {
		List<MiMcDiDependOutParamDTO> outParamDTOList = new ArrayList<MiMcDiDependOutParamDTO>();
		// 1.参数校验
		FBoolean bSucess = this.validData(inParamDTO);
		if (FBoolean.FALSE.equals(bSucess))
			return outParamDTOList.toArray(new MiMcDiDependOutParamDTO[outParamDTOList.size()]);
		//2.获取参数
		int orderMode = MiParamUtil.MHIR0001();// 获取医生站开单模式：0：采用病种模式；1:诊断模式
		String idEnt = inParamDTO.getId_ent(); // 就诊id
		String idHp = inParamDTO.getId_hp(); // 医保计划id
		String codeEntp = inParamDTO.getCode_entp();// 就诊类型
		String[] diIds = (String[]) inParamDTO.getDeldiids().toArray(new String[]{});// 删除诊断
		String[] diIdsAll = (String[]) inParamDTO.getAlldiids().toArray(new String[]{});// 全部诊断
		String[] idDisSur =new String[]{};//剩余诊断信息
		for(int i=0;i<diIdsAll.length;i++){
			if(!ArrayUtils.contains(diIds,diIdsAll[i])){
				idDisSur=insertArray(idDisSur,diIdsAll[i]);
			}
		}
		//3.获取医保规则所对应策略
		HashMap<String,String> ruleMap=this.getCheckRule(idHp, codeEntp, IMiMcCheckConst.ID_MIMC_TACTICS_DIDEPEND);
		if(ruleMap==null){
			return outParamDTOList.toArray(new MiMcDiDependOutParamDTO[outParamDTOList.size()]);
		}
		//4.适应症依赖判断
		if(ruleMap.containsKey(IMiMcCheckConst.ID_MIMC_TACTICS_DIDEPEND_INDICATION))
			this.checkInDicDiDepend(idEnt, idHp, codeEntp, diIds, idDisSur, outParamDTOList);

		if (orderMode == 1 && ruleMap.containsKey(IMiMcCheckConst.ID_MIMC_TACTICS_DIDEPEND_SPEC)) {
			//5.特殊病依赖
			this.checkSpecillDiDepend(idEnt, idHp, diIds, idDisSur, outParamDTOList);
			//6.特殊病诊断判断是否存在非药品类医嘱
			this.checkDiDependNoMed(idEnt, idHp, diIds, idDisSur, outParamDTOList);
		}
		//7.超量开药依赖
		if(ruleMap.containsKey(IMiMcCheckConst.ID_MIMC_TACTICS_DIDEPEND_EXCESSMED))
			this.checkExcessDiDepend(idEnt, idHp, diIds, idDisSur, outParamDTOList);
		return outParamDTOList.toArray(new MiMcDiDependOutParamDTO[outParamDTOList.size()]);
	}
	
	/**
	 * 适应症依赖判断
	 * @param idEnt 就诊id
	 * @param idHp 医保id
	 * @param codeEntp 就诊类型
	 * @param diIds  删除诊断id数组
	 * @param idDisSur 剩余诊断id数组
	 * @param outParamDTOList 校验结果
	 * @return
	 * @throws BizException 
	 */
	private void checkInDicDiDepend(String idEnt, String idHp,String codeEntp,String[] diIds,String[] idDisSur,List<MiMcDiDependOutParamDTO> outParamDTOList) throws BizException{
		// 2.获取是都是全保内
		FBoolean bInHPAll = MiBaseInfoUtil.getPatAllhp(idEnt);
		// 3.如果不是全保内判断适应症
		if (FBoolean.FALSE.equals(bInHPAll)) {
			// 1.适应症依赖判断
			MiCheckInDicDiDependBP checkInDicDiDependBP = new MiCheckInDicDiDependBP();
			List<MiMcDiDependOutParamDTO> miMcDiDependOutParamDTOList = checkInDicDiDependBP.exec(idEnt, idHp,codeEntp, diIds, idDisSur);
			if(!ListUtil.isEmpty(miMcDiDependOutParamDTOList))
				outParamDTOList.addAll(miMcDiDependOutParamDTOList);
		}
	}
	
	/**
	 * 特殊病依赖校验
	 * @param idEnt 就诊id
	 * @param idHp 医保id
	 * @param diIds  删除诊断id数组
	 * @param idDisSur 剩余诊断id数组
	 * @param outParamDTOList 校验结果
	 * @return
	 * @throws BizException 
	 */
	private void checkSpecillDiDepend(String idEnt, String idHp,String[] diIds,String[] idDisSur,List<MiMcDiDependOutParamDTO> outParamDTOList) throws BizException{
		MiCheckSpecillDiDependBP checkSpecillDiDependBP = new MiCheckSpecillDiDependBP();
		List<MiMcDiDependOutParamDTO> diDependSpecDTOList = checkSpecillDiDependBP.exec(idEnt,idHp,diIds, idDisSur);
		if (!ListUtil.isEmpty(diDependSpecDTOList))
			outParamDTOList.addAll(diDependSpecDTOList);
	}
	
	/**
	 * 特殊病诊断判断是否存在非药品类医嘱
	 * @param idEnt 就诊id
	 * @param idHp 医保id
	 * @param diIds  删除诊断id数组
	 * @param idDisSur 剩余诊断id数组
	 * @param outParamDTOList 校验结果
	 * @return
	 * @throws BizException 
	 */
	private void checkDiDependNoMed(String idEnt, String idHp,String[] diIds,String[] idDisSur,List<MiMcDiDependOutParamDTO> outParamDTOList) throws BizException{
		MiCheckDiDependNoMedBP checkDiDependNoMedBP = new MiCheckDiDependNoMedBP();
		List<MiMcDiDependOutParamDTO> diDependNoMedDTOList = checkDiDependNoMedBP.exec(idEnt,idHp, diIds, idDisSur);
		if (!ListUtil.isEmpty(diDependNoMedDTOList))
			outParamDTOList.addAll(diDependNoMedDTOList);
	}
	
	/**
	 * 超量开药依赖
	 * @param idEnt 就诊id
	 * @param idHp 医保id
	 * @param diIds  删除诊断id数组
	 * @param idDisSur 剩余诊断id数组
	 * @param outParamDTOList 校验结果
	 * @return
	 * @throws BizException 
	 */
	private void checkExcessDiDepend(String idEnt, String idHp,String[] diIds,String[] idDisSur,List<MiMcDiDependOutParamDTO> outParamDTOList) throws BizException{
		 MiCheckExcessDiDependBP checkExcessDiDependBP =new MiCheckExcessDiDependBP();
		 List<MiMcDiDependOutParamDTO> diDependExcessDTOList=checkExcessDiDependBP.exec(idEnt, idHp,diIds,idDisSur);
		 if(!ListUtil.isEmpty(diDependExcessDTOList))
			 outParamDTOList.addAll(diDependExcessDTOList);
	}
	
	/**
	 * 参数校验
	 * 
	 * @param inParamDTO
	 * @return
	 */
	private FBoolean validData(MiMcDiDependInParamDTO inParamDTO) {
		if (inParamDTO == null)
			return FBoolean.FALSE;
		if (StringUtil.isEmpty(inParamDTO.getId_ent()))
			return FBoolean.FALSE;
		if (StringUtil.isEmpty(inParamDTO.getId_hp()))
			return FBoolean.FALSE;
		if (StringUtil.isEmpty(inParamDTO.getCode_entp()))
			return FBoolean.FALSE;
		if (inParamDTO.getDeldiids() == null || inParamDTO.getDeldiids().size() <= 0)
			return FBoolean.FALSE;
		if (inParamDTO.getAlldiids() == null || inParamDTO.getAlldiids().size() <= 0)
			return FBoolean.FALSE;
		return FBoolean.TRUE;
	}
	
	/**
	 * 数组追加元素
	 * 
	 * @param arr
	 * @param str
	 * @return
	 */
	private static String[] insertArray(String[] arr, String str) {
		int size = arr.length;
		String[] tmp = new String[size + 1];
		System.arraycopy(arr, 0, tmp, 0, size);
		tmp[size] = str;
		return tmp;
	}
}
