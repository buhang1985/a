package iih.ci.ord.s.ems.base;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.cache.BDFreqInfoCache;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.hp.cp.ele.d.HpCpElemOrderDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 临床路径保存基类
 * 
 *
 */
public class BaseCpSaveBP extends BaseEmsSaveBP {
	
	
	/**
	 * 医嘱信息赋值
	 * 
	 * @param ctx
	 * @param medSrv
	 * @param orderListViewDTO
	 * @throws BizException
	 */
	protected void setEmsViewInfo(CiEnContextDTO ctx, MedSrvDO medSrvInfo, EmsDriverInfo driverinfo, OrderListViewDTO orderListViewDTO, String code_or, int index,HpCpElemOrderDO eleord) 
			throws BizException {
		FDateTime dt = CiOrdAppUtils.getServerDateTime();
		orderListViewDTO.setCode_or(code_or);
		orderListViewDTO.setSortno_srv(index);
		orderListViewDTO.setId_srvtp(medSrvInfo.getId_srvtp());// 服务类型ID
		orderListViewDTO.setSd_srvtp(medSrvInfo.getSd_srvtp());// 服务类型编码
		orderListViewDTO.setName_srvtp(medSrvInfo.getSrvtp_name());// 服务类型
		
		orderListViewDTO.setId_srv(medSrvInfo.getId_srv());// 服务ID
		orderListViewDTO.setCode_srv(medSrvInfo.getCode());// 服务编码
		orderListViewDTO.setName_srv(medSrvInfo.getName());// 服务
		orderListViewDTO.setQuan_med( eleord.getDosage() );// 剂量
		orderListViewDTO.setId_unit_med(eleord.getId_cur());// 剂量单位ID
		orderListViewDTO.setName_unit_med(eleord.getId_cur_name());// 剂量单位  todo
		
		if (!CiOrdUtils.isTrue(medSrvInfo.getIsmulexec())) {
			orderListViewDTO.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);// 频次ID
			orderListViewDTO.setName_freq(IBdSrvDictCodeConst.CODE_FREQNUNITCT_ITEM_ONCE);// 频次
			orderListViewDTO.setFreqct(1);// 频次数量
			orderListViewDTO.setSd_frequnitct(IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE);// 频次周期类型编码
			orderListViewDTO.setFg_long(FBoolean.FALSE);// 长临标识
			orderListViewDTO.setFg_long_edit(FBoolean.FALSE);// 长临标识可编辑标识
		} else {
			FreqDefDO freqDefDO = BDFreqInfoCache.GetFreqInfo(eleord.getId_freq());
			if (freqDefDO == null) {
				orderListViewDTO.setId_freq(null);
				orderListViewDTO.setName_freq(null);
				orderListViewDTO.setSd_frequnitct(null);
				orderListViewDTO.setFreqct(null);
				orderListViewDTO.setFg_long(null);// 长临标识
				orderListViewDTO.setFg_long_edit(null);// 长临标识可编辑标识
			}else{
				orderListViewDTO.setId_freq(freqDefDO.getId_freq());
				orderListViewDTO.setName_freq(freqDefDO.getName());
				orderListViewDTO.setSd_frequnitct(freqDefDO.getSd_frequnitct());
				orderListViewDTO.setFreqct(freqDefDO.getFreqct());
				orderListViewDTO.setFg_long(freqDefDO.getFg_long());// 长临标识
				orderListViewDTO.setFg_long_edit(freqDefDO.getFg_long_edit());// 长临标识可编辑标识
			}
		}
		
		orderListViewDTO.setId_route(eleord.getId_route());// 用法ID
		orderListViewDTO.setName_route(eleord.getId_route_name());// 用法    todo
//		orderListViewDTO.setId_routedes(srvInfo.getId_routedes());// 用法要求ID     todo
//		orderListViewDTO.setName_routedes(srvInfo.getOrtplnitm_routedes_name());// 用法要求        todo
		orderListViewDTO.setId_emp_or(ctx.getId_emp_or());// 开立医生ID
		orderListViewDTO.setName_emp_or(ctx.getName_emp_or());// 开立医生
		orderListViewDTO.setDt_effe(dt);// 开立时间
		orderListViewDTO.setDt_end(null);// 停止时间
	// 	orderListViewDTO.setDays_or(srvInfo.getDays_or() == null ? 1 : srvInfo.getDays_or());// 医嘱天数   //todo
//		orderListViewDTO.setDays_or(1);
		// orderListViewDTO.setTimes_cur(Times_cur);//次数
		orderListViewDTO.setFg_research(FBoolean.FALSE);// 科研标识
		orderListViewDTO.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);// 医嘱状态：开立
		orderListViewDTO.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);// 医嘱状态：开立
		orderListViewDTO.setFg_set(medSrvInfo.getFg_set());// 服务套标识
		orderListViewDTO.setFg_setradio(medSrvInfo.getFg_setradio());
		orderListViewDTO.setFg_urgent(eleord.getFg_urgent());// 加急标识
		orderListViewDTO.setFg_urgent_edit(medSrvInfo.getFg_urgent_ip());//加急可使用标识
		orderListViewDTO.setFg_selfpay(FBoolean.TRUE);// 自费标识
		
		orderListViewDTO.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);//医嘱服务来源方式:医生开立
		orderListViewDTO.setEu_orsrcmdtp(OrSourceFromEnum.IIHCPHELPER);// 医嘱来源方式：医嘱模板
		orderListViewDTO.setIsmuldose(medSrvInfo.getIsmuldose());// 多剂量标识
		orderListViewDTO.setIsmulexec(medSrvInfo.getIsmulexec());// 多次执行标识
		orderListViewDTO.setSd_totalopenmode(medSrvInfo.getSd_totalopenmode());// 总量开单模式
		orderListViewDTO.setEu_blmd(medSrvInfo.getEu_blmd());// 划价方式
		orderListViewDTO.setFg_selfsrv(medSrvInfo.getFg_ctm());// 自定义服务标识
		orderListViewDTO.setFg_use(medSrvInfo.getFg_use_ip());// 住院可使用标识-当前就诊类型
		orderListViewDTO.setId_primd(medSrvInfo.getId_primd());
		orderListViewDTO.setFg_or(medSrvInfo.getFg_or());
		
		// 当前剂量单位和剂量赋值
		orderListViewDTO.setId_medu_cur(orderListViewDTO.getId_unit_med());
		orderListViewDTO.setName_medu_cur(orderListViewDTO.getName_unit_med());
		orderListViewDTO.setQuan_medu_cur(orderListViewDTO.getQuan_med());

		// 医疗单驱动
		orderListViewDTO.setDriverInfo(driverinfo);
		// 医嘱开立方式：默认医嘱列表开立
		orderListViewDTO.setEu_OrderPrescribeModule(OrderPrescribeModuleEnum.HPCPOR);
		//0195340: 临床路径批量执行模式下，后台报错。所以默认为false。
		orderListViewDTO.setFg_pres_outp(FBoolean.FALSE);
		orderListViewDTO.setStatus(DOStatus.NEW);
		
		//取模板配置的执行科室
		orderListViewDTO.setId_dep_mp(eleord.getId_dep_mp());
		orderListViewDTO.setName_dep_mp(eleord.getName_dep_mp());
		
		orderListViewDTO.setId_dep_wh(eleord.getId_dep_wh());
		//领药方式
		orderListViewDTO.setId_drugdeliverymethod(eleord.getId_drug_delivery_method());		
		
		orderListViewDTO.setQuan_cur(eleord.getQuan_cur());
		orderListViewDTO.setId_unit_cur(eleord.getId_unit_cur());
		
		orderListViewDTO.setDes_or(eleord.getDes_or());
		
		orderListViewDTO.setId_nodispense(eleord.getId_nodispense());
		orderListViewDTO.setSd_nodispense(eleord.getSd_nodispense());
		
	}
	
	
	/**
	 * 设置执行科室信息
	 * 
	 * @param ctx
	 * @param medSrv
	 * @param orderListViewDTO
	 * @throws BizException
	 */
	protected void setOrWfDeptInfo(CiEnContextDTO ctx, MedSrvDO medSrv, OrderListViewDTO orderListViewDTO)
			throws BizException {
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, medSrv.getId_srv(), orderListViewDTO.getId_mm(), orderListViewDTO.getId_route(),null,
				orderListViewDTO.getFg_long(),orderListViewDTO.getFg_pres_outp(),orderListViewDTO.getDt_effe());
		if (!CiOrdUtils.isEmpty(wf)) {
			// 非物品没有物资仓库（医嘱模板缺物资流向配置）
			if (FBoolean.TRUE.equals(medSrv.getFg_mm())) {
				orderListViewDTO.setId_dep_wh(wf.getId_dept_wh());// 物资仓库ID
				orderListViewDTO.setName_dep_wh(wf.getName_dept_wh());// 物资仓库
				orderListViewDTO.setFilter_dep_wh(wf.getId_dept_whs());// 物资仓库过滤条件
			}
			//如果模板没有配置执行科室或者配置的科室不在执行流向范围内，则重新取值
			if(StringUtils.isNullOrEmpty(orderListViewDTO.getId_dep_mp()) || !wf.getId_mp_depts().contains(orderListViewDTO.getId_dep_mp())){
				orderListViewDTO.setId_dep_mp(wf.getFirstid_mp_dept());// 执行科室ID
				orderListViewDTO.setName_dep_mp(wf.getFirstname_mp_dept());// 执行科室
				orderListViewDTO.setFilter_dep_mp("1".equals(wf.getMp_source()) ? null : wf.getId_mp_depts());// 执行科室过滤条件
			}
		}
	}
	
	/**
	 * 获取拼装后的EmsSaveDTO
	 * @param view
	 * @param driverInfo
	 * @return
	 */
	protected EmsSaveDTO getEmsSaveDTO(FArrayList doc, EmsDriverInfo driverInfo) {
		EmsSaveDTO save = new EmsSaveDTO();
		save.setDriverInfo(driverInfo);
		save.setDocument(doc);
		return save;
	}

	/**
	 * 设置停止时间，停止人
	 */
	protected void setDt_end(CiEnContextDTO ctx, OrderListViewDTO orderListViewDTO){
		if(FBoolean.TRUE.equals(orderListViewDTO.getFg_long()) && orderListViewDTO.getDays_or() != null){
			orderListViewDTO.setDt_end(orderListViewDTO.getDt_effe().getDateTimeAfter(orderListViewDTO.getDays_or()));
			orderListViewDTO.setFg_stop(FBoolean.TRUE);
			
			orderListViewDTO.setId_emp_stop(ctx.getId_emp_or());
		}
		
		
	}

}
