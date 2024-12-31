package iih.nm.nit.i;

import iih.nm.nit.dto.nitpsncycdto.d.NitPsnCycDTO;
import iih.nm.nit.nipracfbtmpl.d.NiPracfbTmplItmDO;
import iih.nm.nit.nitpracfb.d.NitPracfbDO;
import iih.nm.nit.nitpractmpl.d.NitPractmplDO;
import iih.nm.nit.nitsro.d.NitSroBchDO;
import iih.nm.nit.nmnitgrppl.d.NmNitGrpPlDO;
import iih.nm.nit.psninfo.d.NitPsnInfoDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;

/**
 * 实习进修公共接口
 * @author lijm
 *
 */
public interface INmNitQueryService {

	/**
	 *  根据生源机构类型查询对应机构所有批次集合
	 * @param id_orgtp
	 * @return
	 * @throws BizException
	 */
	public abstract NitSroBchDO[] findNitSroBchListByIdorgtp(String id_orgtp)throws BizException;
	/**
	 * 查询当前科室带评价实习人员	
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public abstract NitPsnCycDTO[] findNitPsnCycDOs(String id_dep,String dt_begin,String dt_end) throws BizException;
	/**
	 * 根据实习小组查询对应的小组计划
	 * @param id_pracgrp
	 * @return
	 * @throws BizException
	 */
	public abstract NitPsnCycDTO[] findPracPlListByIdpracgrp(String id_pracgrp) throws BizException;
	/**
	 * 查询实习生实习开始结束时间
	 * @param id_dep_nur
	 * @param id_prac_psninfo
	 * @return
	 */
	public abstract NitPracfbDO finDate(String id_dep_nur, String id_prac_psninfo)throws BizException;
	/**
	 * 查询启用的的实习反馈模板
	 * @return
	 * @throws BizException
	 */
	public abstract NiPracfbTmplItmDO[] finFbtmpl()throws BizException;
	/**
	 * 查询实习模板总周数
	 * @return NitPractmplDO[]
	 * @throws BizException
	 */
	public abstract NitPractmplDO[] findTotalWeek() throws BizException; 
	
	/**
	 * 查询实习小组根据队伍id
	 * @param id_nit_grp
	 * @return
	 * @throws BizException
	 */
	public abstract NmNitGrpPlDO[] findPracGrpById(String id_nit_grp) throws BizException;
	
	/**
	 * 过滤实习参与人员
	 * @param id_nit_sro_bch
	 * @return
	 * @throws BizException
	 */
	public abstract NitPsnInfoDO[] findPsnInfoByIdSroBch(String[] id_nit_sro_bch) throws BizException;
}
