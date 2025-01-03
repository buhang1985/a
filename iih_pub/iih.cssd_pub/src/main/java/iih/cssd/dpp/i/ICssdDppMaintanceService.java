package iih.cssd.dpp.i;

import iih.cssd.dpbd.instr.d.CssdiNSTRDO;
import iih.cssd.dpp.dfp.d.CssdDfpDO;
import iih.cssd.dpp.dfpcln.d.CssdDfpClnDO;
import iih.cssd.dpp.dfpcln.d.DfpclnAggDO;
import iih.cssd.dpp.dfploss.d.DfpLossDO;
import iih.cssd.dpp.dto.dfpbatch.d.DfpBatchAddDTO;
import iih.cssd.dpp.dto.dfprecalldto.d.DfpRecallDTO;
import iih.cssd.dpp.dto.stz.d.DfpStzDTO;
import iih.cssd.dpp.dto.stz.d.DfpStzItmDTO;
import iih.cssd.dpp.dto.stz.d.RelDTO;
import iih.cssd.dpp.dto.stz.d.StzResultDTO;
import iih.cssd.dpp.stz.d.CssddfpstzDO;
import xap.mw.core.data.BizException;

public interface ICssdDppMaintanceService {

	/**
	 * 生产消毒包保存逻辑
	 * 
	 * @param paramDTO批量增加时DTO
	 * @return 
	 * @throws BizException
	 */
	public abstract String[] saveDfpBatchInfos(DfpBatchAddDTO[] params, DfpStzDTO srlzInfo) throws BizException;

	/**
	 * 删除消毒包
	 * @param id_dfps
	 * @throws BizException
	 */
	public abstract void deleteDfps(String[] id_dfps) throws BizException;

	/**
	 * 消毒包灭菌保存
	 * @param cleanInfo
	 * @param id_dfps
	 * @throws BizException
	 */
	public abstract void srlzSave(DfpStzDTO srlzInfo, String[] id_dfps) throws BizException;

	/**
	 * 消毒包清洗保存
	 * @param cleanInfo
	 * @param id_dfps
	 * @throws BizException
	 */
	public abstract void cleanSave(CssdDfpClnDO cleanInfo, String[] id_dfps) throws BizException;

	/**
	 * 消毒包核包
	 * 
	 * @param basket
	 * @param pkgs
	 * @return
	 * @throws BizException
	 */
	public abstract String saveCheckPkg(CssdiNSTRDO basket, CssdDfpDO[] pkgs) throws BizException;

	/**
	 * 灭菌信息 保存登记
	 * 
	 * @param cssddfpstzDO
	 * @param cssdiNSTRDO
	 * @param basket
	 * @param checkPkg
	 * @throws BizException
	 */
	public abstract void saveRegister(CssddfpstzDO cssddfpstzDO, CssdiNSTRDO cssdiNSTRDO, RelDTO[] basket, RelDTO[] checkPkg) throws BizException;

	/**
	 * 灭菌结果录入
	 * 
	 * @param stzResultDTO
	 * @param cssddfpstzDO
	 * @throws BizException
	 */
	public abstract void saveStrPkgResult(StzResultDTO stzResultDTO, CssddfpstzDO cssddfpstzDO, String no_bar) throws BizException;

	/**
	 * 消毒存储关系绑定
	 * 
	 * @Description: TODO
	 * @author zhy
	 * @Date 2019年4月24日
	 * @param dto
	 * @throws BizException
	 */
	public abstract void saveRelDTO(RelDTO dto) throws BizException;

	/**
	 * 
	 * @Description: 解除消毒篮与消毒包绑定关系
	 * @author zhy
	 * @Date 2019年4月26日
	 * @param dfp
	 * @throws BizException
	 */
	public abstract void removeDfpRel(CssdDfpDO dfp) throws BizException;

	/**
	 * 
	 * @Description: 判断器械子级是否有绑定,如果没有则解除绑定关系
	 * @author zhy
	 * @Date 2019年5月5日
	 * @param instr
	 * @throws BizException
	 */
	public abstract void removeInstrRel(CssdiNSTRDO instr) throws BizException;

	/**
	 * @Description: 根据传递的消毒包id的集合,以及要修改的状态,修改消毒包的状态
	 * @author zhy
	 * @param id_dfps
	 * @param id_status
	 * @param sd_status
	 * @throws BizException
	 */
	public abstract void changeDfpSta(String[] id_dfps, String id_status, String sd_status) throws BizException;

	/**
	 * 清洗绑定
	 * 
	 * @Description: TODO
	 * @author tcj
	 * @Date 2019年5月13日
	 * @param relDTO
	 * @throws BizException
	 */
	public abstract void saveCleanRel(RelDTO relDTO) throws BizException;

	/**
	 * 保存清洗登记信息
	 * 
	 * @author fengjj
	 * @param clnMachineNoBar
	 * @param dfpclnAggDO
	 * @param clnRackInfos
	 * @throws BizException
	 */
	public abstract void saveClnRegInfo(CssdiNSTRDO clnMachine, DfpclnAggDO dfpclnAggDO, CssdiNSTRDO[] clnRackInfos) throws BizException;

	/**
	 * 删除关系
	 * 
	 * @param no_bar
	 * @throws BizException
	 */
	public abstract void delDfpRelData(String id_dfp_rel) throws BizException;

	/**
	 * 保存消毒包报损记录
	 * 
	 * @param param
	 * @throws BizException
	 */
	public abstract void saveDamagereg(DfpLossDO param) throws BizException;

	/**
	 * 删除消毒包报损登记记录
	 * 
	 * @param dfpLossDO
	 * @throws BizException
	 */
	public abstract void delDamageReg(DfpLossDO param) throws BizException;
	
	
	/**
	 * 消毒包撤回
	 * @throws BizException
	 */
	public abstract void saveDfpRecall(DfpRecallDTO[] dfpRecallDTO) throws BizException;

	/**
	 * 消毒包灭菌锅次修改
	 * 
	 * @param params
	 * @throws BizException
	 */
	public abstract void saveStzSortno(DfpStzItmDTO[] params) throws BizException;
}
