package iih.bl.cg.s.bp;

import java.util.List;

import iih.bl.cg.d.BlIpFeeDTO;
import iih.bl.cg.d.BlRefundDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取退费显示明细（住院退补费）
 * 
 * @author wq.li
 * @date 2018年8月19日
 */
public class GetFundeDTOBP {
	/**
	 * 获取退费显示明细（住院退补费）
	 * 
	 * @param feeDto
	 * @return
	 * @date 2018年8月19日
	 * @author wq.li
	 * @throws BizException 
	 */
	public BlIpFeeDTO exec(BlIpFeeDTO feeDto) throws BizException {
		//查询明细信息
		List<BlRefundDTO> fundDtoList=getFundDto(feeDto);
		FArrayList list= new FArrayList();
		if(fundDtoList!=null && fundDtoList.size()!=0){
			for (BlRefundDTO refundDto : fundDtoList) {
				list.add(refundDto);
			}
		}
		feeDto.setRefundlist(list);
		return feeDto;
	}
	
	private List<BlRefundDTO> getFundDto(BlIpFeeDTO feeDto) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append(" select distinct ");
		sql.append(" cg.id_cgip, ");
		sql.append(" cg.id_srv,");
		sql.append(" srv.name name_srv,");
		sql.append(" cg.id_or,");
		sql.append(" ci.name_or,");
		sql.append(" cg.id_dep_or,");
		sql.append(" ordep.name  name_dep_or,");
		sql.append(" cg.id_dep_mp,");
		sql.append(" mpdep.name name_dep_mp,");
		sql.append(" cg.quan,");
		sql.append(" cg.quan_ret,");
		sql.append(" cg. dt_cg");
		sql.append(" from ");
		sql.append(" bl_cg_ip cg");
		sql.append(" LEFT JOIN CI_ORDER ci on ci.id_or=cg.id_or");
		sql.append(" left join bd_srv srv on srv.id_srv=cg.id_srv");
		sql.append(" left join bd_dep ordep on ordep.id_dep=cg.id_dep_or");
		sql.append(" left join bd_dep mpdep on mpdep.id_dep=cg.id_dep_mp");
		sql.append(" where ");
		sql.append(" cg.id_dep_or=? ");
		sql.append(" and nvl(cg.ID_OR,'~')=?  ");
		sql.append(" and cg.ID_SRV=? ");
		sql.append(" and nvl(cg.ID_MM,'~')=? ");
		sql.append(" and cg.PRICE=?  ");
		sql.append(" and cg.SRVU=?  ");
		sql.append(" and nvl(cg.ONLYCODE,'~')=? ");
		sql.append(" and cg.fg_mm=? ");
		sql.append(" and cg.id_ent=?   ");
		sql.append(" and cg.id_pat=?   ");
		sql.append(" and cg.ID_DEP_MP=? ");
		sql.append(" and cg.eu_direct=1 ");
		sql.append(" and cg.fg_refund = 'N' ");
		sql.append(" and cg.fg_st = 'N' ");
		SqlParam param=new SqlParam();
		param.addParam(feeDto.getId_dep_or());
		if(StringUtil.isEmpty(feeDto.getId_or())){
			param.addParam("~");
		}else{
			param.addParam(feeDto.getId_or());
		}
		param.addParam(feeDto.getId_srv());
		param.addParam(StringUtil.isEmpty(feeDto.getId_mm())?"~":feeDto.getId_mm());
		param.addParam(feeDto.getPrice());
		param.addParam(feeDto.getId_srvu());
		param.addParam(StringUtil.isEmpty(feeDto.getOnlycode())?"~":feeDto.getOnlycode());
		param.addParam(feeDto.getFg_mm());
		param.addParam(feeDto.getId_ent());
		param.addParam(feeDto.getId_pat());
		param.addParam(feeDto.getId_dep_mp());
		
		@SuppressWarnings("unchecked")
		List<BlRefundDTO> list1 = (List<BlRefundDTO>) new DAFacade().execQuery(sql.toString(),param, new BeanListHandler(BlRefundDTO.class));
		
		return list1;
	}
}
