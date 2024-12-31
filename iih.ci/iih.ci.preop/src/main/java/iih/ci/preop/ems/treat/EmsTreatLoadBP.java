package iih.ci.preop.ems.treat;

import java.util.List;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.preop.ems.d.EmsTreatViewDTO;
import iih.ci.sdk.database.SqlParamBuilder;
import iih.ci.sdk.database.SqlParamDbUtils;
import iih.ci.sdk.ems.bp.BaseEmsLoadBP;
import iih.ci.sdk.utils.ObjectUtils;
import iih.ci.sdk.utils.OrderEmsPriceUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;

/**
 * 门诊预住院治疗申请单加载逻辑
 * @author wangqingzhu
 *
 */
public class EmsTreatLoadBP extends BaseEmsLoadBP {

	@Override
	public EmsRstDTO load(CiEnContextDTO ctx, EmsLoadDTO arg) throws BizException {
		EmsRstDTO emsRstDTO = new EmsRstDTO();
		//创建检验医疗单对象
		EmsTreatViewDTO emsViewDto=this.emsModelFrom(arg.getCode_or());
		emsViewDto.setStatus(DOStatus.UPDATED);
		emsViewDto.setPri(OrderEmsPriceUtils.CalculatePrice(ctx, emsViewDto.getId_srv(), emsViewDto.getId_srv_items()));
		FArrayList objList = new FArrayList();
		objList.add(emsViewDto);
		emsRstDTO.setDocument(objList);
		return emsRstDTO ;
	}

	/**
	 * 组装治疗医疗单模型信息
	 * @param code_or
	 * @return
	 * @throws BizException
	 */
	protected EmsTreatViewDTO emsModelFrom(String code_or) throws BizException{
		SqlParamBuilder sql=new SqlParamBuilder();
		sql.appendSql(" select tsor.id_srv,tsor.name_or as name_srv,tsor.des_or,tsor.sd_srvtp,tsor.code_or, srv.quan_medu as quan_med,srv.id_medu as id_unit_med ,unit.name as name_unit_med,")
		.appendSql(" (select listagg(orset.id_srvset,',') within group(order by orset.Sortno) Id_srv_items from ci_ts_or_srv_set orset where orset.id_tsor=tsor.id_tsor) as Id_srv_items, ")
		.appendSql(" (select listagg(orset.name_srvset,',') within group(order by orset.Sortno) Name_srv_items from ci_ts_or_srv_set orset where orset.id_tsor=tsor.id_tsor) as Name_srv_items, ")
		.appendSql(" tsor.id_di_def as id_diitem,di.name as name_diitem,tsor.sd_su_ts_mp Imp_status ")
		.appendSql(" from ci_ts_or tsor ")
		.appendSql(" left join ci_ts_or_srv srv on srv.id_srv=tsor.id_srv and srv.id_tsor=tsor.id_tsor ")
		.appendSql(" left join bd_measdoc unit on unit.id_measdoc=srv.id_medu ")
		.appendSql(" left join bd_di_def di on di.id_didef=tsor.id_di_def ")
		.appendSql(" where tsor.code_or=? ");
		List<EmsTreatViewDTO> EmsTreatViewDTOList= SqlParamDbUtils.Q(sql.appendParam(code_or), EmsTreatViewDTO.class);
		if(ObjectUtils.isEmpty(EmsTreatViewDTOList))throw new BizException("获取治疗申请单数据失败！");
		return EmsTreatViewDTOList.get(0);
	}
}
