package iih.sc.apt.out.s;

import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.dto.d.ScAptMtDto;
import iih.sc.apt.out.ci.d.ScAptInfoDTO;
import iih.sc.apt.out.ci.d.ScAptOptEmpDTO;
import iih.sc.apt.out.i.ISc4CiQryService;
import iih.sc.apt.out.i.ISc4PisQryService;
import iih.sc.apt.s.bp.mt.GetMtResListBP;
import iih.sc.apt.s.bp.mt.GetPatMtAptBP;
import iih.sc.apt.s.bp.mt.GetSCAptOptBP;
import iih.sc.apt.s.bp.mt.GetScAptByIdOrsBP;
import iih.sc.apt.s.bp.opt.GetScAptOptByOrIdBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
/**
 * 预约域对外接口统一实现
 * @author renying
 *
 */
@Service(serviceInterfaces = { ISc4PisQryService.class, ISc4CiQryService.class}, binding = Binding.JSONRPC)
public class ScAptOutQryServiceImpl implements ISc4PisQryService, ISc4CiQryService{
	
	/********************ISc4PisQryService***********************/
	/**
	 * 查询医技排班信息
	 * 
	 * @param qryDTO 查询DTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtResDTO[] getMtResList(MtAppQryDTO qryDTO) throws BizException  {
		GetMtResListBP getMtResBp = new GetMtResListBP();
		return getMtResBp.exec(qryDTO);
	}
	
	
	/**
	 * 查询医技预约申请单信息
	 * 
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtAppDTO[] getMtAppList(String patId,String deptId/*MtAppQryDTO qryDTO*/) throws BizException {
		GetPatMtAptBP bp = new GetPatMtAptBP();
		return bp.exec(patId, deptId,null);
	}
	
	/********************ISc4CiQryService***********************/
	
	/**
	 * 
	 * 获取手术安排人员列表
	 * 
	 * @param id_or 医嘱id
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScAptOptEmpDTO[] getSCAptOptEmpList(String id_or) throws BizException {
		GetSCAptOptBP bp = new GetSCAptOptBP();
		return bp.exec(id_or);
	}
	/**
	 * 
	 * 获取手术预约信息
	 * 
	 * @author liubin
	 * 
	 * @param id_or 医嘱id
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScAptInfoDTO getScAptOpt(String id_or) throws BizException {
		return new GetScAptOptByOrIdBP().exec(id_or);
	}
	
	/**
	 * 根据医嘱id批量获取医技预约DO
	 * @param idOrs
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScAptMtDto[] getAptByIdOrs(String[] idOrs) throws BizException {
		GetScAptByIdOrsBP getscaptbyidors = new GetScAptByIdOrsBP();
		return getscaptbyidors.exec(idOrs);
	}
}
