package iih.bl.cg.s.bp.ip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.MapUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.dto.alwaysor.d.BlCgAlwaysOrCgInfoDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.i.IBlCgAccountPackService;
import iih.bl.comm.IBlCgFuncConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 持续医嘱停止时退记账
 * @author ly 2020/03/12
 *
 */
public class BlCgRefundAlwaysOrBP {

	/**
	 * 持续医嘱停止时退记账
	 * @param cgDtos 持续医嘱记账信息
	 * @throws BizException
	 */
	public void exec(BlCgAlwaysOrCgInfoDTO[] cgDtos) throws BizException{
		
		if(ArrayUtil.isEmpty(cgDtos))
			return;
		
		//查询记账数据及可退数量
		List<String> cgIdList = new ArrayList<String>();
		for (BlCgAlwaysOrCgInfoDTO cgDto : cgDtos) {
			cgIdList.addAll(Arrays.asList(cgDto.getId_cgips().split(",")));
		}
		
		Map<String, BlCgIpDO> cgMap = this.getCgData(cgIdList);
		
		List<BlCgRefundAccountDTO> refundList = new ArrayList<BlCgRefundAccountDTO>();
		
		for (BlCgAlwaysOrCgInfoDTO cgDto : cgDtos) {
			
			FDouble quanRet = cgDto.getRet_quan();
			String[] cgIds = cgDto.getId_cgips().split(",");
			for (String cgId : cgIds) {
				
				if(quanRet.compareTo(FDouble.ZERO_DBL) <= 0)
					break;
				
				BlCgIpDO cgDO = cgMap.get(cgId);
				FDouble canQuan = cgDO.getQuan().sub(cgDO.getQuan_ret());
				
				BlCgRefundAccountDTO redAccDto = new BlCgRefundAccountDTO();
				redAccDto.setId_ent(cgDto.getId_ent());
				redAccDto.setId_pat(cgDO.getId_pat());
				redAccDto.setId_cg(cgId);
				
				if(quanRet.compareTo(canQuan) >= 0){
					redAccDto.setQuan(canQuan);
				}else{
					redAccDto.setQuan(quanRet);
				}
				quanRet = quanRet.sub(canQuan);
				
				refundList.add(redAccDto);
			}
		}
		
		if(refundList.size() == 0)
			return;
		
		IBlCgAccountPackService cgService = ServiceFinder.find(IBlCgAccountPackService.class);
		BlCgRefundAccountSetDTO refundSet = new BlCgRefundAccountSetDTO();
		refundSet.setSrcfunc_des(IBlCgFuncConst.FUNC_IPOR_DOCTORSTATION);
		refundSet.setEu_rfdmode(RefundModeEnum.CG_KEY);

		cgService.refundAccountForIpFlow(refundList.toArray(new BlCgRefundAccountDTO[0]), refundSet);
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, BlCgIpDO> getCgData(List<String> cgIdList) throws BizException {
		
		DAFacade daf = new DAFacade();
		String sql = "select id_cgip,id_pat,quan,quan_ret from bl_cg_ip where  ";
		sql += SqlUtils.getInSqlByIds("id_cgip", cgIdList);
		sql += " order by dt_cg desc ";
		
		List<BlCgIpDO> cgDOList = (List<BlCgIpDO>)daf.execQuery(sql, new BeanListHandler(BlCgIpDO.class));
		return MapUtils.convertListToMap(cgDOList, BlCgIpDO.ID_CGIP);
	}
}
