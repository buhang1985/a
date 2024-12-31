package iih.bl.cg.s.provide.mbh;

import iih.bl.cg.dto.d.DayIpCgInfoDTO;
import iih.bl.params.BlParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 供移动护理，获取住院一日清单费用
 * @author liwq
 * @param id_ent 就诊id
 * @param dt_cg  日期格式：yyyy-MM-dd
 * @throws Exception 
 * @since 2018年3月7日15:01:58
 */
public class GetIpDayCgDTOsBp {

	public DayIpCgInfoDTO[] exec(String id_ent,FDate dt_cg) throws Exception {
		
		List<DayIpCgInfoDTO> list = new ArrayList<DayIpCgInfoDTO>();
		List<DayIpCgInfoDTO> cgDtoList = this.getIpFeeDetailedCgInfo(id_ent, dt_cg);
		if(cgDtoList != null && cgDtoList.size() > 0){
			Map<String,List<DayIpCgInfoDTO>> map = new HashMap<String,List<DayIpCgInfoDTO>>();
			Map<String,MeasDocDO> measMap = this.getMeasdocInfos();
			for(DayIpCgInfoDTO cgInfo : cgDtoList){
				if(StringUtil.isEmpty(cgInfo.getName_inccaitm())){
					continue;
				}
				if(cgInfo.getSrvunitid() != null){
					cgInfo.setName_srvunit(measMap.get(cgInfo.getSrvunitid()).getName());
				}
				FDate date = new FDate(cgInfo.getDt_cg());
				cgInfo.setDt_cg(date.toString());
				List<DayIpCgInfoDTO> cgDtList =map.get(date.toString());
				if(cgDtList == null){
					cgDtList = new ArrayList<DayIpCgInfoDTO>();
					cgDtList.add(cgInfo);
					map.put(date.toString(), cgDtList);
				}else{
					Boolean has = this.setMapMend(cgDtList, cgInfo);
					if(!has){
						cgDtList.add(cgInfo);
					}
				}
				
				if(FBoolean.TRUE.equals(cgInfo.getFg_bb())){
					cgInfo.setFg_bb_name(String.format("婴儿%s", cgInfo.getNo_bb()));
				}
			}
			for(Map.Entry<String, List<DayIpCgInfoDTO>> entry :map.entrySet()){
				list.addAll(entry.getValue());
			}
		}
		return list.toArray(new DayIpCgInfoDTO[]{});
	}

	/**
	 * 查询日清单明细
	 * @param id_ent
	 * @param dt_cg 记账日期
	 * @return
	 * @throws Exception
	 */
	private List<DayIpCgInfoDTO> getIpFeeDetailedCgInfo(String id_ent,FDate dt_cg) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT A2.NAME as Name_inccaitm,A1.NAME_SRV,A1.SPEC,A1.PRICE_ratio as PRICE_RATIO, ")
				.append(" (A1.QUAN * A1.EU_DIRECT) AS QUAN,(A1.AMT_RATIO * A1.EU_DIRECT) AS AMT_RATIO ,A1.DT_CG,A1.SRVU AS Srvunitid, ");
			 //.append(",(case A1.fg_mm when 'Y' then A1.srvu when 'N' then A1.pgku_cur end) as srvu ")
			 //.append("case when a1.fg_bb = 'Y' then '是' else '否' end fg_bb_name, ")
		sql.append("decode(hpsrv.sd_hpsrvtp,'1','甲类','2','乙类','丙类') name_hpsrvtp, ")
			 .append(" a1.fg_bb, a1.no_bb FROM BL_CG_IP A1 ")
			 .append("LEFT JOIN (SELECT B3.ID_SRV, B2.CODE, B2.NAME ")
			 .append("FROM BD_INCCA B1 ")
			 .append("JOIN BD_INCCA_ITM B2 ON B1.ID_INCCA = B2.ID_INCCA ")
			 .append("LEFT JOIN BD_INCCA_ITM_REL B3 ON B2.ID_INCCAITM = B3.ID_INCCAITM ")		
			 .append("WHERE B1.CODE = '12') A2 ON A1.ID_SRV = A2.ID_SRV ");
			 sql.append("join bd_hp_srvorca  hpsrv on  (A1.id_srv = hpsrv.id_srv and A1.fg_mm='N') or (A1.id_mm = hpsrv.id_mm and A1.fg_mm = 'Y') ")
			 .append("JOIN PI_PAT A3 ON A1.ID_PAT = A3.ID_PAT ");
			 
		FBoolean isMerge = BlParams.BLSTIP0005();
		if(FBoolean.TRUE.equals(isMerge)) {
			sql.append(" where (a1.id_ent = '").append(id_ent).append("' or a1.ID_ENT_mom = '").append(id_ent).append("') ");			
		} else {
			sql.append(" where (a1.id_ent = '").append(id_ent).append("') ");
		}
		sql.append("AND a1.DT_CG >= '").append(dt_cg.toString()).append(" 00:00:00' ")
			 .append("AND a1.DT_CG <= '").append(dt_cg.toString()).append(" 23:59:59' ");		
		sql.append("AND a1.FG_ST = 'N' ");
		sql.append("ORDER BY a1.fg_bb,a1.no_bb, A1.DT_CG");	
		
		BeanListHandler beanlist_handler = new BeanListHandler(DayIpCgInfoDTO.class);
		List<DayIpCgInfoDTO> result = (List<DayIpCgInfoDTO>)new DAFacade().execQuery(sql.toString(), beanlist_handler);
		
		return result;
	}
	
	private Boolean setMapMend(List<DayIpCgInfoDTO>  cgDtList,DayIpCgInfoDTO cgInfo){
		for(DayIpCgInfoDTO dto :  cgDtList){
			if(dto.getName_srv().equals(cgInfo.getName_srv()) 
					&& dto.getPrice_ratio().doubleValue() == cgInfo.getPrice_ratio().doubleValue() 
					&& dto.getName_inccaitm().equals(cgInfo.getName_inccaitm())){
				if(dto.getQuan() == null){
					dto.setQuan(cgInfo.getQuan());
				}else{
					dto.setQuan(dto.getQuan().add(cgInfo.getQuan()));
				}
				if(dto.getAmt_ratio() == null){
					dto.setAmt_ratio(cgInfo.getAmt_ratio());
				}else{
					dto.setAmt_ratio(dto.getAmt_ratio().add(cgInfo.getAmt_ratio()));
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取单位信息
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	private Map<String,MeasDocDO> getMeasdocInfos() throws BizException{
		Map<String,MeasDocDO> measMap = new HashMap<String,MeasDocDO>();
		DAFacade dafacade=new DAFacade();
		List<MeasDocDO> measLst=(List<MeasDocDO>)dafacade.execQuery("SELECT ID_MEASDOC,CODE,NAME FROM BD_MEASDOC", new BeanListHandler(MeasDocDO.class));
		if(measLst == null || measLst.size() == 0){
			throw new BizException("单位信息不存在！");
		}
		for(MeasDocDO measDocDO : measLst){
			measMap.put(measDocDO.getId_measdoc(), measDocDO);
		}
		return measMap;
	}	
}
