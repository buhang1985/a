package iih.ci.preop.ems.lis;

import java.util.List;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.preop.ems.d.EmsLisViewDTO;
import iih.ci.preop.ems.d.EmsSrvSetViewDTO;
import iih.ci.sdk.database.SqlParamBuilder;
import iih.ci.sdk.database.SqlParamDbUtils;
import iih.ci.sdk.ems.bp.BaseEmsCreateBP;
import iih.ci.sdk.utils.CiOrdAppUtils;
import iih.ci.sdk.utils.ObjectUtils;
import iih.ci.sdk.utils.OrderEmsPriceUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 检验申请医嘱创建逻辑
 * @author wangqingzhu
 *
 */
public class EmsLisCreateBP extends BaseEmsCreateBP {

	@Override
	public EmsRstDTO create(CiEnContextDTO ctx, EmsCrtDTO arg) throws BizException {
		
		EmsRstDTO emsRstDTO = new EmsRstDTO();
		//创建检验医疗单对象
		EmsLisViewDTO emsViewDto=this.emsModelFrom(ctx.getId_en(), arg.getId_srv());
		emsViewDto.setPri(OrderEmsPriceUtils.CalculatePrice(ctx, emsViewDto.getId_srv(), emsViewDto.getId_srv_items()));
		//设置对象结构的状态为【新建】
		emsViewDto.setStatus(DOStatus.NEW);
		FArrayList objList = new FArrayList();
		objList.add(emsViewDto);
		emsRstDTO.setDocument(objList);
		return emsRstDTO ;
		
		
	}
	/**
	 * 组装检验医疗单模型信息
	 * @param id_en
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public EmsLisViewDTO emsModelFrom(String id_en,String id_srv) throws BizException{
		SqlParamBuilder sql=new SqlParamBuilder();
		sql.appendSql(" select srv.id_srv,srv.name as name_srv, srv.sd_srvtp,srv.id_primd,srv.quan_med,srv.id_unit_med,unit.name as name_unit_med,srv.fg_set,srv.fg_setradio,")
//		.appendSql(" (select listagg(srvset.id_srv_itm,',') within group(order by srvset.Sortno) id_srv_items from bd_srvset_def srvset where srvset.id_srv=srv.id_srv) as id_srv_items, ")
//		.appendSql(" (select listagg(itemsrv.name,',') within group(order by srvset.Sortno) name_srv_items from bd_srvset_def srvset ")
//		.appendSql(" left join bd_srv itemsrv on itemsrv.id_srv=srvset.id_srv_itm where srvset.id_srv=srv.id_srv) as name_srv_items,  ")
		.appendSql(" lab.id_samptp,lab.sd_samptp,labudi.name as name_samptp,lab.id_sampcoltime,samtm.name as name_sampcoltime,di.id_di,di.id_didef id_diitem,di.id_didef_code code_diitem,di.id_didef_name name_diitem ")
		.appendSql(" from bd_srv srv ")
		.appendSql(" left join bd_srv_lab lab on lab.id_srv=srv.id_srv ")
		.appendSql(" left join bd_udidoc labudi on labudi.id_udidoc=lab.id_samptp ")
		.appendSql(" left join bd_sampcol_time samtm on samtm.id_sampcollecttime=lab.id_sampcoltime ")
		.appendSql(" left join bd_measdoc unit on unit.id_measdoc=srv.id_unit_med ")
		.appendSql(" full join ")
		.appendSql(" (select di.id_en,di.id_di,itm.id_didef,itm.id_didef_code,itm.id_didef_name from ci_di di  ")
		.appendSql(" left join  ci_di_itm itm on itm.id_di=di.id_di where di.fg_sign = 'Y' and di.fg_cancel='N' and itm.fg_majdi='Y' ")
		.appendSql(" and  di.id_en=? and rownum=1 order by dt_di desc ) di on di.id_en=? ")
		.appendSql(" where srv.id_srv=? ");
		List<EmsLisViewDTO> emsListViewDtoList= SqlParamDbUtils.Q(sql.appendParam(id_en).appendParam(id_en).appendParam(id_srv), EmsLisViewDTO.class);
		if(ObjectUtils.isEmpty(emsListViewDtoList))throw new BizException("获取检验申请单数据失败！");
		EmsLisViewDTO emsViewDto=emsListViewDtoList.get(0);
		FArrayList setItemList=this.getEmsLisSetItemList(emsViewDto.getId_srv());
		if(!ObjectUtils.isEmpty(setItemList)){
			String id_srv_items="";
			String name_srv_items="";
			for(Object obj:setItemList){
				EmsSrvSetViewDTO item=(EmsSrvSetViewDTO)obj;
				// 临床项目可选标志 = false, 选中标志 = true, 否则，全部 = false
				item.setFg_check(ObjectUtils.isTrue(item.getFg_clinical()) && !ObjectUtils.isTrue(item.getFg_edit())
						? FBoolean.TRUE : FBoolean.FALSE);
				item.setFg_check_def(item.getFg_check_def());
				if(ObjectUtils.isTrue(item.getFg_check_def()) && ObjectUtils.isFalse(emsViewDto.getFg_setradio())){
					item.setFg_check(FBoolean.TRUE);
				}
				if(ObjectUtils.isTrue(item.getFg_check())){
					id_srv_items+=","+item.getId_srv();
					name_srv_items+=","+item.getName_srv();
				}
			}
			emsViewDto.setEmsSetItemList(setItemList);
			if(!ObjectUtils.isEmpty(id_srv_items)){
				emsViewDto.setId_srv_items(id_srv_items.substring(1));
				emsViewDto.setName_srv_items(name_srv_items.substring(1));
			}
		}
		return emsViewDto;
	}

	/**
	 * 创建套内项目
	 * @param id_srv
	 * @param fg_setradio
	 * @return
	 * @throws BizException
	 */
	protected FArrayList getEmsLisSetItemList(String id_srv) throws BizException{
		SqlParamBuilder sbSql = new SqlParamBuilder()
				.appendSql(" select item.id_srv_itm as id_srv,srv.name as name_srv,item.fg_edit,item.fg_clinical,item.fg_check_def ")
				.appendSql(" from bd_srvset_def item  ")
				.appendSql(" left join bd_srv srv  on srv.id_srv = item.id_srv_itm ")
				.appendSql(" where item.fg_active='Y' and item.id_srv=? ").appendParam(id_srv);		
		List<EmsSrvSetViewDTO> setItemList= sbSql.Q(EmsSrvSetViewDTO.class);
		if(ObjectUtils.isEmpty(setItemList))return null;
		FArrayList setItemFlist=new FArrayList();
		setItemFlist.addAll(setItemList);	
		return setItemFlist;
	}
	
}
