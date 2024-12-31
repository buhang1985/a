package iih.ci.preop.ems.ris;

import java.util.List;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.preop.ems.d.EmsLisViewDTO;
import iih.ci.preop.ems.d.EmsRisViewDTO;
import iih.ci.preop.ems.d.EmsSrvSetViewDTO;
import iih.ci.sdk.database.SqlParamBuilder;
import iih.ci.sdk.database.SqlParamDbUtils;
import iih.ci.sdk.ems.bp.BaseEmsLoadBP;
import iih.ci.sdk.utils.ObjectUtils;
import iih.ci.sdk.utils.OrderEmsPriceUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊预住院申请医疗单加载逻辑
 * @author wangqingzhu
 *
 */
public class EmsRisLoadBP extends BaseEmsLoadBP {

	@Override
	public EmsRstDTO load(CiEnContextDTO ctx, EmsLoadDTO arg) throws BizException {
		EmsRstDTO emsRstDTO = new EmsRstDTO();
		//创建检查医疗单对象
		EmsRisViewDTO emsViewDto=this.emsModelFrom(arg.getCode_or());
		emsViewDto.setStatus(DOStatus.UPDATED);
		emsViewDto.setPri(OrderEmsPriceUtils.CalculatePrice(ctx, emsViewDto.getId_srv(), emsViewDto.getId_srv_items()));
		FArrayList objList = new FArrayList();
		objList.add(emsViewDto);
		emsRstDTO.setDocument(objList);
		return emsRstDTO;
	}

	/**
	 * 根据 医嘱code 加载检查申请单模型数据
	 * @param id_en
	 * @param code_or
	 * @return
	 * @throws BizException
	 */
	protected EmsRisViewDTO emsModelFrom(String code_or) throws BizException{
		SqlParamBuilder sql=new SqlParamBuilder();
		sql.appendSql(" select tsor.id_srv,tsor.name_or as name_srv,tsor.des_or,tsor.sd_srvtp,tsor.code_or, ")
		.appendSql(" (select listagg(orset.id_srvset,',') within group(order by orset.Sortno) Id_srv_items from ci_ts_or_srv_set orset where orset.id_tsor=tsor.id_tsor) as Id_srv_items, ")
		.appendSql(" (select listagg(orset.name_srvset,',') within group(order by orset.Sortno) Name_srv_items from ci_ts_or_srv_set orset where orset.id_tsor=tsor.id_tsor) as Name_srv_items, ")
		.appendSql(" ris.id_pps,ris.sd_pps,ris.name_pps,ris.des_pps,ris.des_sympsign,ris.announcements,srv.fg_set,srv.fg_setradio, srv.id_primd,")
		.appendSql(" tsor.id_di_def as id_diitem,di.name as name_diitem,tsor.sd_su_ts_mp Imp_status ")
		.appendSql(" from ci_ts_or tsor ")
		.appendSql(" left join ci_ts_ap_obs ris on ris.id_tsor=tsor.id_tsor ")
		.appendSql(" left join bd_di_def di on di.id_didef=tsor.id_di_def ")
		.appendSql(" left join bd_srv srv on srv.id_srv=tsor.id_srv ")
		.appendSql(" where tsor.code_or=? ");
		List<EmsRisViewDTO> emsRisViewDtoList= SqlParamDbUtils.Q(sql.appendParam(code_or), EmsRisViewDTO.class);
		if(ObjectUtils.isEmpty(emsRisViewDtoList))throw new BizException("获取检查申请单数据失败！");
		EmsRisViewDTO emsViewDto=emsRisViewDtoList.get(0);
		FArrayList setItemList=this.getEmsRisSetItemList(emsViewDto.getId_srv());
		if(!ObjectUtils.isEmpty(setItemList)){
			for(Object obj:setItemList){
				EmsSrvSetViewDTO item=(EmsSrvSetViewDTO)obj;
				// 临床项目可选标志 = false, 选中标志 = true, 否则，全部 = false
				item.setFg_check(new FBoolean(emsViewDto.getId_srv_items().contains(item.getId_srv())));
				item.setFg_check_def(item.getFg_check_def());
			}
			emsViewDto.setEmsSetItemList(setItemList);
		}
		return emsViewDto;
	}
	
	/**
	 * 加载套内项目
	 * @param id_srv
	 * @param fg_setradio
	 * @return
	 * @throws BizException
	 */
	protected FArrayList getEmsRisSetItemList(String id_srv) throws BizException{
		SqlParamBuilder sbSql = new SqlParamBuilder()
				.appendSql(" select item.id_srv_itm as id_srv,srv.name as name_srv,obs.id_pos,obs.sd_pos, posu.name as name_pos, ")
				.appendSql(" obs.id_body,obs.sd_body,bodyu.name as name_body,item.fg_edit,item.fg_clinical,item.fg_check_def ")
				.appendSql(" from bd_srvset_def item  ")
				.appendSql(" left join bd_srv srv  on srv.id_srv = item.id_srv_itm ")
				.appendSql(" left join bd_srv_obs obs  on obs.id_srv = item.id_srv_itm ")
				.appendSql(" left join bd_udidoc bodyu  on bodyu.id_udidoc = obs.id_body ")
				.appendSql(" left join bd_udidoc posu  on posu.id_udidoc = obs.id_pos ")
				.appendSql(" where item.fg_active='Y' and item.id_srv=? ").appendParam(id_srv);		
		List<EmsSrvSetViewDTO> setItemList= sbSql.Q(EmsSrvSetViewDTO.class);
		if(ObjectUtils.isEmpty(setItemList))return null;
		FArrayList setItemFlist=new FArrayList();
		setItemFlist.addAll(setItemList);	
		return setItemFlist;
	}
}
