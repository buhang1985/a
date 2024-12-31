package iih.bl.st.s.bp.out;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.st.dto.blipauditstatus.d.BlIpAuditStatusDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取患者住院费用审核状态
 * @author ly 2020/01/02
 *
 */
public class GetIpAuditStatusBP {
	
	/**
	 * 获取患者住院费用审核状态
	 * @param entIds 就诊id数组
	 * @return 审核状态
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlIpAuditStatusDTO[] exec(String[] entIds) throws BizException {
		
		if(ArrayUtil.isEmpty(entIds)){
			throw new BizException("获取患者住院费用审核状态入参为空");
		}
		
		DAFacade daf = new DAFacade();
		String sql = "select id_ent,fg_pass_clinic,fg_pass_hp from bl_audit_ip where fg_active = 'Y' and ";
		sql += SqlUtils.getInSqlByIds("id_ent", entIds);
		
		List<BlIpAuditStatusDTO> auditList = (List<BlIpAuditStatusDTO>)daf.execQuery(sql, new BeanListHandler(BlIpAuditStatusDTO.class));
		if(auditList == null){
			auditList = new ArrayList<BlIpAuditStatusDTO>();
		}
		
		// 组装返回值
		List<BlIpAuditStatusDTO> rltList = new ArrayList<BlIpAuditStatusDTO>();
		for (String entId : entIds) {
			
			BlIpAuditStatusDTO statusDto = new BlIpAuditStatusDTO();
			statusDto.setId_ent(entId);
			statusDto.setFg_pass_clinic(FBoolean.FALSE);
			statusDto.setFg_pass_hp(FBoolean.FALSE);
			
			for (BlIpAuditStatusDTO blIpAuditStatusDTO : auditList) {
				
				if(blIpAuditStatusDTO.getId_ent().equals(entId)){
					statusDto.setFg_pass_clinic(blIpAuditStatusDTO.getFg_pass_clinic());
					statusDto.setFg_pass_hp(blIpAuditStatusDTO.getFg_pass_hp());
					break;
				}
			}
			rltList.add(statusDto);
		}
		
		return rltList.toArray(new BlIpAuditStatusDTO[0]);
	}
}
