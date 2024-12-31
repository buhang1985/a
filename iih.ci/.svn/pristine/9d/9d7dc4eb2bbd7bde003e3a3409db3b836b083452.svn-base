package iih.ci.event.ord.bps.sign.ip.logicbp;

import iih.ci.event.ord.bps.sign.ip.query.IpConCompleteDiaInfoQuery;
import iih.ci.event.ord.bps.sign.ip.query.IpConCompleteDocInfoQuery;
import iih.ci.event.ord.bps.sign.ip.query.IpConCompleteEntInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.mr.cimripbasedto.d.CiMrIPBaseDTO;
import iih.ci.mr.diainfodto.d.DiaInfoDTO;
import iih.ci.ord.cons.dto.d.ConsdocDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 住院会诊完成逻辑处理【BS340】
 * @author zhengqiang
 *
 */
public class IpConCompleteLogicDealWithBP extends CommonParamBP{

	/**
	 * 生成集成平台会诊服务数据信息(BS340)
	 * @param firedto
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BaseDTO[] exec(OrdEventFireDTO firedto) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(firedto.getIdors())) {
			return null;
		}
		//会诊医师信息集合
		FArrayList2 DocList = new FArrayList2();
		//诊断章节集合
		FArrayList DiaList = new FArrayList();
		// 获取BS340主表数据集合
		CiMrIPBaseDTO[] ciMrIPBaseDTOs = this.getCiMrIPBaseDTO(firedto.getIdors());
		//获取子表-医师
		ConsdocDTO[] consdocDTOs = this.getConsdocDTO(firedto.getIdors());
		//获取子表-诊断
		DiaInfoDTO[] diaInfoDTOs = this.getConsdiaDTO(firedto.getIdors());
		for (CiMrIPBaseDTO dto : ciMrIPBaseDTOs) {
			this.setValue(dto);
			//根据主表与子表的共同的主表id进行关联  当一致时 将子表集合添加到主表内
			//1.循环医师信息
			for(ConsdocDTO docDto : consdocDTOs){
				if(!(OrdEventUtil.isEmpty(dto.getId_cimrbase()) && OrdEventUtil.isEmpty(docDto.getId_cimrbase()))
						&& dto.getId_cimrbase().equals(docDto.getId_cimrbase())) {
					DocList.add(docDto);
				}
			}
			//2.循环诊断信息
			for(DiaInfoDTO diaDto : diaInfoDTOs){
				if(!(OrdEventUtil.isEmpty(dto.getId_cimrbase()) && OrdEventUtil.isEmpty(diaDto.getId_cimrbase()))
						&& dto.getId_cimrbase().equals(diaDto.getId_cimrbase())) 
				DiaList.add(diaDto);
			}
			dto.setCons_doc_list(DocList);//设置会诊医生集合
			dto.setLs_dia(DiaList);//设置诊断信息集合
		}
		return ciMrIPBaseDTOs;
	}
	
	/**
	 * 设置值
	 */
	private void setValue(CiMrIPBaseDTO dto) {
		//计算年龄
		if(!OrdEventUtil.isEmpty(dto.getDt_birth())) {
			dto.setAge(AgeCalcUtil.getAge(new FDate(dto.getDt_birth().toString())));
		}
		//就诊次数
		if(OrdEventUtil.isEmpty(dto.getTimes_ip())) {
			dto.setTimes_ip("0");
		}
		//就诊类别
		dto.setCode_entp(getParamCodeEntp(dto.getCode_entp()));
	}
	
	/**
	 * 获取BS340主表数据集合
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private CiMrIPBaseDTO[] getCiMrIPBaseDTO(String id_ors) throws BizException{
		IpConCompleteEntInfoQuery qry = new IpConCompleteEntInfoQuery(id_ors);
		CiMrIPBaseDTO[] rtn = (CiMrIPBaseDTO[])AppFwUtil.getDORstWithDao(qry, CiMrIPBaseDTO.class);
		return rtn;
	}
	
	/**
	 * 子表数据集合-医师信息
	 * @return
	 * @throws BizException
	 */
	private ConsdocDTO[] getConsdocDTO(String id_ors) throws BizException{
		IpConCompleteDocInfoQuery qry = new IpConCompleteDocInfoQuery(id_ors);
		ConsdocDTO[] rtn = (ConsdocDTO[])AppFwUtil.getDORstWithDao(qry, ConsdocDTO.class);
		return rtn;
	}
	
	/**
	 * 子表数据集合-诊断
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private DiaInfoDTO[] getConsdiaDTO(String id_ors) throws BizException{
		IpConCompleteDiaInfoQuery qry = new IpConCompleteDiaInfoQuery(id_ors);
		DiaInfoDTO[] rtn = (DiaInfoDTO[])AppFwUtil.getDORstWithDao(qry, DiaInfoDTO.class);
		return rtn;
	}
	
	private String Getdisys(String id_ors) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(" select  ");
		return strBuilder.toString();
	}
}
