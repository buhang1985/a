package iih.ci.preop.ems.treat;

import java.util.List;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.preop.ems.d.EmsSrvSetViewDTO;
import iih.ci.preop.ems.d.EmsTreatViewDTO;
import iih.ci.sdk.database.SqlParamBuilder;
import iih.ci.sdk.database.SqlParamDbUtils;
import iih.ci.sdk.ems.bp.BaseEmsCreateBP;
import iih.ci.sdk.utils.ObjectUtils;
import iih.ci.sdk.utils.OrderEmsPriceUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;

/**
 * 门诊医生站预住院治疗申请创建逻辑
 * @author wangqingzhu
 *
 */
public class EmsTreatCreateBP extends BaseEmsCreateBP {

	@Override
	public EmsRstDTO create(CiEnContextDTO ctx, EmsCrtDTO arg) throws BizException {
		
		EmsRstDTO emsRstDTO = new EmsRstDTO();
		//创建治疗医疗单对象
		EmsTreatViewDTO emsViewDto=this.emsModelFrom(ctx.getId_en(), arg.getId_srv());
		// 设置对象结构的状态为【新建】
		emsViewDto.setStatus(DOStatus.NEW);
		emsViewDto.setPri(OrderEmsPriceUtils.CalculatePrice(ctx, emsViewDto.getId_srv(), emsViewDto.getId_srv_items()));
		FArrayList objList = new FArrayList();
		objList.add(emsViewDto);
		emsRstDTO.setDocument(objList);
		return emsRstDTO ;


	}
	/**
	 * 组装治疗医疗单模型信息
	 * @param id_en
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	protected EmsTreatViewDTO emsModelFrom(String id_en,String id_srv) throws BizException{
		SqlParamBuilder sql=new SqlParamBuilder();
		sql.appendSql(" select srv.id_srv,srv.name as name_srv, srv.sd_srvtp,srv.id_primd,srv.quan_med,srv.id_unit_med,unit.name as name_unit_med,")
		.appendSql(" (select listagg(srvset.id_srv_itm,',') within group(order by srvset.Sortno) Id_srv_items from bd_srvset_def srvset where srvset.id_srv=srv.id_srv) as Id_srv_items, ")
		.appendSql(" (select listagg(itemsrv.name,',') within group(order by srvset.Sortno) Name_srv_items from bd_srvset_def srvset ")
		.appendSql(" left join bd_srv itemsrv on itemsrv.id_srv=srvset.id_srv_itm where srvset.id_srv=srv.id_srv) as Name_srv_items,  ")
		.appendSql(" di.id_di,di.id_didef id_diitem,di.id_didef_code code_diitem,di.id_didef_name name_diitem ")
		.appendSql(" from bd_srv srv ")
		.appendSql(" left join bd_measdoc unit on unit.id_measdoc=srv.id_unit_med ")
		.appendSql(" full join ")
		.appendSql(" (select di.id_en,di.id_di,itm.id_didef,itm.id_didef_code,itm.id_didef_name from ci_di di  ")
		.appendSql(" left join  ci_di_itm itm on itm.id_di=di.id_di where di.fg_sign = 'Y' and di.fg_cancel='N' and itm.fg_majdi='Y' ")
		.appendSql(" and  di.id_en=? and rownum=1 order by dt_di desc ) di on di.id_en=? ")
		.appendSql(" where srv.id_srv=? ");
		List<EmsTreatViewDTO> emsTreatViewDtoList= SqlParamDbUtils.Q(sql.appendParam(id_en).appendParam(id_en).appendParam(id_srv), EmsTreatViewDTO.class);
		if(ObjectUtils.isEmpty(emsTreatViewDtoList))throw new BizException("获取治疗申请单数据失败！");
		return emsTreatViewDtoList.get(0);
	}
}
