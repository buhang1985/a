package iih.sc.sch.s.bp;

import iih.sc.comm.ScValidator;
import iih.sc.sch.reg.dto.d.EuLoadPriceMod;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.RelSrvDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 加载挂号资源价格
 * 批量处理，提高性能
 * @author yank
 *
 */
public class LoadResPriceBP {
	/**
	 * 加载挂号资源价格
	 * @param resDTO 挂号资源DTO
	 * @return
	 * @throws BizException
	 */
	public RegResDTO[] exec(RegResDTO[] resDTOs) throws BizException {
		return exec(resDTOs, null);
	}
	/**
	 * 加载挂号资源价格
	 * @param resDTO 挂号资源DTO
	 * @param priPatId 患者价格分类
	 * @return
	 * @throws BizException
	 */
	public RegResDTO[] exec(RegResDTO[] resDTOs, String priPatId) throws BizException {
		if (ArrayUtil.isEmpty(resDTOs))
			return null;
		List<String> scSrvIdList = new ArrayList<String>();
		for (RegResDTO resDTO : resDTOs) {
			if (!scSrvIdList.contains(resDTO.getId_scsrv())) {
				scSrvIdList.add(resDTO.getId_scsrv());
			}
		}
		String loadPriceMod = ScValidator.isEmptyIgnoreBlank(priPatId) ? EuLoadPriceMod.STDPRICE : EuLoadPriceMod.PATPRICE;
		GetScSrvRelSrvListBP getRelSrvBP = new GetScSrvRelSrvListBP();
		Map<String, List<RelSrvDTO>> scSrvMap = getRelSrvBP.exec(scSrvIdList.toArray(new String[0]), loadPriceMod, priPatId);
		BindResAndSrvBP bindBP = new BindResAndSrvBP();
		for (RegResDTO resDTO : resDTOs) {
			if(scSrvMap ==null || !scSrvMap.containsKey(resDTO.getId_scsrv())|| ListUtil.isEmpty(scSrvMap.get(resDTO.getId_scsrv())) ){
				throw new BizException("门急诊服务[" +getScSRvName(resDTO.getId_scsrv())+"_"+resDTO.getId_scsrv()+"]维护错误,请去<门急诊服务维护>节点维护");
			}
			bindBP.exec(resDTO, scSrvMap.get(resDTO.getId_scsrv()));
		}
		return resDTOs;
	}
	/**
	 * 根据排班服务id获取排班服务名称
	 * 
	 * @param scSrvId
	 * @return
	 * @throws BizException
	 */
	private String getScSRvName(String scSrvId)throws BizException {
		if(ScValidator.isEmptyIgnoreBlank(scSrvId))
			throw new BizException("门急诊排班服务Id不能为空！");
		String sql = "SELECT SCSRV.NAME FROM SC_SRV SCSRV WHERE SCSRV.ID_SCSRV = ? AND SCSRV.FG_ACTIVE = 'Y'";
		SqlParam param = new SqlParam();
		param.addParam(scSrvId);
		List<String> names = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(ListUtil.isEmpty(names))
			throw new BizException(String.format("未找到门急诊排班服务[%S]信息!", scSrvId));
		return names.get(0);
	}
}
