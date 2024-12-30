package iih.sc.sch.s.bp.qry;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.sch.dto.d.SchInfoDTO;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.dto.d.SchQryDTO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.scp.scplan.d.ScPlanDO;
/**
 * 查找排班信息BP
 * @author renying
 *
 */
public class GetSchInfoBP {

	/**
	 * 查询DTO
	 * @param schQryDTO
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<SchInfoDTO> exec(SchQryDTO schQryDTO, PaginationInfo pageInfo) throws BizException {
		PagingRtnData<SchInfoDTO> schinfoData = new PagingRtnData<SchInfoDTO>();
		PagingServiceImpl<SchInfoDTO> service =new PagingServiceImpl();

		SqlParam param = new SqlParam();
		String sql = getSql(param,schQryDTO);
		schinfoData = service.findByPageInfo(new SchInfoDTO(), pageInfo, sql, "", param);

		return schinfoData;
	}
	
	/**
	 * 查询sql
	 * @param param
	 * @param schQryDTO
	 * @return
	 */
	private String getSql(SqlParam param,SchQryDTO schQryDTO){
		StringBuilder sb = new StringBuilder();
		sb.append("	select  ");
		sb.append("	pl.id_dep,");
		sb.append("	concat(sch.d_sch,dayslot.name) as dt_plan, ");
		sb.append("	pl.id_scsrv,");
		sb.append("	pl.id_scres,");
		sb.append("	pl.id_apptru,");
		sb.append("	pl.name as name_scpl,");
		sb.append("	dep.name as name_dep,");
		sb.append("	srv.name as name_scsrv,");
		sb.append("	res.name as name_scres,");
		sb.append("	rule.name as name_apptru,");
		sb.append("	sch.quan_total,");
		sb.append("	sch.quan_total_used,");
		sb.append("	sch.fg_active,");
		sb.append("	sch.id_sch,");
		sb.append("	sch.d_sch,");
		sb.append(" case when  sch.fg_active = 'Y' then 'N' else 'Y' end as fg_stop");
		sb.append("	from sc_sch sch ");
		sb.append("	inner join sc_pl pl");
		sb.append("	on sch.id_scpl = pl.id_scpl");
		sb.append("	left join  sc_srv srv ");
		sb.append("	on pl.id_scsrv = srv.id_scsrv");
		sb.append("	left join sc_res res ");
		sb.append("	on res.id_scres = pl.id_scres");
		sb.append("	left join sc_apptrule rule");
		sb.append("	on rule.id_apptru = pl.id_apptru");
		sb.append("	left join bd_dep dep");
		sb.append("	on dep.id_dep = pl.id_dep");
		sb.append("	left join bd_dayslot dayslot ");
		sb.append("	on dayslot.id_dayslot = sch.id_dayslot");
		sb.append(" where 1=1 ");
		if(schQryDTO == null)
			return sb.toString();
		if(!StringUtil.isEmpty(schQryDTO.getId_dep())){
			sb.append( "	and pl.id_dep =? ");
			param.addParam(schQryDTO.getId_dep());
		}
		if(!StringUtil.isEmpty(schQryDTO.getId_scres())){	
			sb.append( "	and pl.id_scres = ?");
			param.addParam(schQryDTO.getId_scres());
		}
		if(!StringUtil.isEmpty(schQryDTO.getId_scsrv())){
			sb.append( "	and pl.id_scsrv = ?");
			param.addParam(schQryDTO.getId_scsrv());
		}
		if(schQryDTO.getDt_b()!=null){
			sb.append( "	and sch.d_sch >=?");
			param.addParam(schQryDTO.getDt_b());
		}
		if(schQryDTO.getDt_e() != null){
			sb.append( "	and sch.d_sch<=?");
			param.addParam(schQryDTO.getDt_e());
		}
		if(!StringUtil.isEmpty(schQryDTO.getId_dayslot())){
			sb.append( "	and sch.id_dayslot =?");
			param.addParam(schQryDTO.getId_dayslot());
		}
		if(!StringUtil.isEmpty(schQryDTO.getSd_sctp())){
			sb.append( "	and sch.Sd_sctp =?");
			param.addParam(schQryDTO.getSd_sctp());
		}
		if(!StringUtil.isEmpty(schQryDTO.getName_scpl())){
            sb.append( "    and PL.NAME LIKE ?");
            param.addParam("%" + schQryDTO.getName_scpl() + "%");
        }
		if(FBoolean.TRUE.equals(schQryDTO.getFg_stop())){
            sb.append( "    and sch.fg_active = ?");
            param.addParam( FBoolean.FALSE);
        }
		if(!FBoolean.TRUE.equals(schQryDTO.getFg_stop())){
            sb.append( "    and sch.fg_active = ?");
            param.addParam( FBoolean.TRUE);
        }
		if(schQryDTO.getCode_week()!=null){
			String[] schqry =schQryDTO.getCode_week().split(",");
			sb.append( "    and to_char(to_date(sch.d_sch,'YYYY-MM-DD'),'d') in (");
			for(int i=0;i<schqry.length;i++){
				
				if(i+1==schqry.length){
					sb.append( "  ?  ");
				}else{
					sb.append( "  ?,  ");
				}
				String[] schqry1 = schqry[i].split("0");
				
				if("7".equals(schqry1[1])){
					schqry[i] = "1";
				}else{
					schqry[i] = (Integer.parseInt(schqry1[1])+1)+"";
				}
			}
			sb.append( "    )    " );
			for(int i=0;i<schqry.length;i++){
				param.addParam( schqry[i] );
			}
		}
		
		sb.append(" and pl.eu_edit_tp = ?");
		param.addParam(IScDictCodeConst.EU_EDIT_TP_OTHER);
		
		String schstr = ScGroupControlUtils.getGroupControlFitler(new ScSchDO(),"sch");
		String plstr = ScGroupControlUtils.getGroupControlFitler(new ScPlanDO(),"pl");
		sb.append(" and");
		sb.append(schstr);
		sb.append(" and");
		sb.append(plstr);
		sb.append(" order by  sch.d_sch ,sch.id_dayslot Asc");
		return sb.toString();
		
	}
	

}
