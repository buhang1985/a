package iih.bl.cg.s.bp.et;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import iih.bl.cg.dto.d.BlIpCgDTO;
import iih.bl.cg.dto.d.BlIpOrdCgDTO;
import iih.bl.cg.dto.d.BlOrderValuationQueryParamDTO;
import iih.bl.cg.s.bp.ip.GetorderValuationDetailedBp;
import iih.bl.cg.s.bp.qry.GetNotOrderDetailedQry;
import iih.bl.cg.s.bp.qry.GetOpNotOrderDetailedQry;
import iih.bl.cg.s.bp.qry.GetOpOrderDetailedQry;
import iih.bl.cg.s.bp.qry.GetOrderDetailQry;
import iih.bl.cg.s.bp.qry.GetOrderDetailedQry;
import iih.bl.params.BlParams;
import iih.en.pv.out.bl.d.EnMomBabyInfoDTO;
import iih.en.pv.out.i.IEn4BlQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.AgeUtils;
import xap.sie.common.utils.StringUtils;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetETorderValuationDetailedBp extends  GetorderValuationDetailedBp{
	private boolean isHp = false;
	private String id_Hp = null;
	// 是否需要特殊处理医保计划
	private FBoolean fg_spechp = FBoolean.FALSE;
	private String code_entp = null;
	
	private BlOrderValuationQueryParamDTO bQueryParamDTO;
	
	public GetETorderValuationDetailedBp(BlOrderValuationQueryParamDTO bQueryParamDTO)
	{
		this.bQueryParamDTO = bQueryParamDTO;
	}

	/**
	 * 查询急诊留观医嘱计价明细
	 * @param bQueryParamDTO 查询条件
	 * @return
	 * @throws BizException
	 * @author xb 2019/03/04
	 */
	public BlIpOrdCgDTO[] exec() throws BizException {
		paramCheck(this.bQueryParamDTO);
		whereHp(bQueryParamDTO.getId_ent());

		List<BlIpOrdCgDTO> resultDTOs = new ArrayList<BlIpOrdCgDTO>();
		resultDTOs.addAll(getETSysCgItemsInfo());
		resultDTOs.addAll(getETDoctorOrderInfo());

		addHpRelatedField(resultDTOs);// 添加医保相关字段设值

		return resultDTOs.toArray(new BlIpOrdCgDTO[] {});
	}
	
	
	/**
	 * 得到急诊留观非医生医嘱产生的记账信息
	 * @param bQueryParamDTO 查询条件
	 * @return
	 * @throws BizException
	 * @author xb 2019/03/04
	 */
	private List<BlIpOrdCgDTO> getETSysCgItemsInfo() throws BizException {
		List<BlIpOrdCgDTO> resultDTOs = new ArrayList<BlIpOrdCgDTO>();
		if (IsShowNoOrderCg()) {

			List<BlIpOrdCgDTO> NotOrderList = null;
			if (BlParams.BLST0002() == 1) {
				NotOrderList = getOepNotOrdCg();
			} else if (BlParams.BLST0002() == 2) {
				NotOrderList = getIpNotOrdCg();
			}

			if (NotOrderList != null && NotOrderList.size() != 0)
				resultDTOs.addAll(NotOrderList);
		}
		return resultDTOs;
	}
	
	/**
	 * 得到急诊留观医生医嘱产生的记账信息
	 * @param bQueryParamDTO 查询条件
	 * @return
	 * @throws BizException
	 * @author xb 2019/03/04
	 */
	private List<BlIpOrdCgDTO> getETDoctorOrderInfo() throws BizException
	{
		List<BlIpOrdCgDTO> resultDTOs = new ArrayList<BlIpOrdCgDTO>();

		List<BlIpOrdCgDTO> NotOrderList = null;
		if (BlParams.BLST0002() == 1) {
			NotOrderList = getOepDoctorOrderInfo();
		} else if (BlParams.BLST0002() == 2) {
			NotOrderList = getIpDoctorOrderInfo(true);
		}

		if (NotOrderList != null && NotOrderList.size() != 0)
			resultDTOs.addAll(NotOrderList);
		return resultDTOs;
	}

	/**
	 * 得到住院非医生医嘱产生的记账信息
	 * @param bQueryParamDTO 查询条件
	 * @return
	 * @throws BizException
	 * @author xb 2019/03/04
	 */
	private List<BlIpOrdCgDTO> getIpSysCgItemsInfo() throws BizException {
		List<BlIpOrdCgDTO> resultDTOs = new ArrayList<BlIpOrdCgDTO>();
		if (IsShowNoOrderCg()) {
			List<BlIpOrdCgDTO> NotOrderList = getIpNotOrdCg();

			if (NotOrderList != null && NotOrderList.size() != 0)
				resultDTOs.addAll(NotOrderList);
		}
		return resultDTOs;
	}

	
	/**
	 * 判断是否需要展示非医嘱记账信息
	 * @param bQueryParamDTO 查询条件
	 * @return
	 * @throws BizException
	 * @author xb 2019/03/04
	 */
	private boolean IsShowNoOrderCg() {
		boolean bresult = bQueryParamDTO.getDt_or_entry() == null && bQueryParamDTO.getDt_or_end() == null
				&& bQueryParamDTO.getId_or() == null && StringUtil.isEmpty(bQueryParamDTO.getFg_long());
		return bresult;
	}


	/**
	 * 得到住院非医生医嘱产生的记账信息
	 * @param bQueryParamDTO 查询条件
	 * @return
	 * @throws BizException
	 * @author xy.zhou 2018/07/31 xb 2019/03/04
	 */
	public List<BlIpOrdCgDTO> getIpNotOrdCg() throws BizException {
		List<BlIpOrdCgDTO> bIpOrdCgDTOs = new ArrayList<>();
		BlIpCgDTO[] idulDtos = (BlIpCgDTO[]) AppFwUtil
				.getDORstWithDao(new GetNotOrderDetailedQry(bQueryParamDTO), BlIpCgDTO.class);

		bIpOrdCgDTOs.addAll(setNotOrdCg(idulDtos));
		return bIpOrdCgDTOs;
	}

	/**
	 * 得到门诊非医生医嘱产生的记账信息
	 * @param bQueryParamDTO 查询条件
	 * @return
	 * @throws BizException
	 * @author xb 2019/03/04
	 */
	public List<BlIpOrdCgDTO> getOepNotOrdCg() throws BizException {
		List<BlIpOrdCgDTO> bIpOrdCgDTOs = new ArrayList<>();

		BlIpCgDTO[] idulDtos = (BlIpCgDTO[]) AppFwUtil.getDORstWithDao(new GetOpNotOrderDetailedQry(bQueryParamDTO), BlIpCgDTO.class);
		bIpOrdCgDTOs.addAll(setNotOrdCg(idulDtos));
		return bIpOrdCgDTOs;
	}

	
	/**
	 * 得到急诊留观医嘱产生的 （门诊）记账信息 和 未记账信息
	 * @param bQueryParamDTO 查询条件
	 * @return
	 * @throws BizException
	 * @author xy.zhou 2018/07/31 xb 2019/03/04
	 */
	private List<BlIpOrdCgDTO> getOepDoctorOrderInfo() throws BizException
	{
		BlIpOrdCgDTO[] allDoctorOrders = getOnlyDoctorOrderInfo();
		BlIpCgDTO[] allDoctorOrderCgItems = getOepOnlyDoctorOrderCgItems();
		List<BlIpCgDTO> allDoctorOrderItems = new ArrayList<BlIpCgDTO>();
		allDoctorOrderItems.addAll(Arrays.asList(allDoctorOrderCgItems));

		if (!ArrayUtil.isEmpty(allDoctorOrders)) {
			List<BlIpCgDTO> allDoctorOrderUnCgItems = getOnlyDoctorOrderUnCgItems(allDoctorOrders, true);
			if (allDoctorOrderUnCgItems != null) {
				allDoctorOrderItems.addAll(allDoctorOrderUnCgItems);
			}
		}

		List<BlIpOrdCgDTO> resultDTOs = setOrdCg(Arrays.asList(allDoctorOrders), allDoctorOrderItems);
		return resultDTOs;
	}
	
	/**
	 * 得到住院医生医嘱产生的 记账信息 和 未记账信息
	 * @param bQueryParamDTO 查询条件
	 * @return
	 * @throws BizException
	 * @author xy.zhou 2018/07/31 xb 2019/03/04
	 */
	
	private List<BlIpOrdCgDTO> getIpDoctorOrderInfo(Boolean fg_emgstry) throws BizException
	{
		BlIpOrdCgDTO[] allDoctorOrders = getOnlyDoctorOrderInfo();
		BlIpCgDTO[] allDoctorOrderCgItems = getIpOnlyDoctorOrderCgItems();
		List<BlIpCgDTO> allDoctorOrderItems = new ArrayList<BlIpCgDTO>();
		allDoctorOrderItems.addAll(Arrays.asList(allDoctorOrderCgItems));

		if (!ArrayUtil.isEmpty(allDoctorOrders)) {
			List<BlIpCgDTO> allDoctorOrderUnCgItems = getOnlyDoctorOrderUnCgItems(allDoctorOrders ,fg_emgstry);
			if (allDoctorOrderUnCgItems != null) {
				allDoctorOrderItems.addAll(allDoctorOrderUnCgItems);
			}
		}

		List<BlIpOrdCgDTO> resultDTOs = setOrdCg(Arrays.asList(allDoctorOrders), allDoctorOrderItems);
		return resultDTOs;
	}

	/**
	 * 得到住院医生开立的医嘱
	 * @param bQueryParamDTO 查询条件
	 * @return
	 * @throws BizException
	 * @author xy.zhou 2018/07/31 xb 2019/03/04
	 */
	private BlIpOrdCgDTO[] getOnlyDoctorOrderInfo() throws BizException {

		// 获取医嘱信息
		List<String> id_srvs = new ArrayList<String>();
		if(bQueryParamDTO.getId_srv() != null && !bQueryParamDTO.getId_srv().isEmpty())
			id_srvs.add(bQueryParamDTO.getId_srv());
		
		List<String> id_ors = new ArrayList<String>();
		if(bQueryParamDTO.getId_or() != null && !bQueryParamDTO.getId_or().isEmpty())
			id_ors.add(bQueryParamDTO.getId_or());
		BlIpOrdCgDTO[] resultDTOs=(BlIpOrdCgDTO[]) AppFwUtil.getDORstWithDao(new GetOrderDetailQry(
				bQueryParamDTO.getId_ent(),
				bQueryParamDTO.getDt_or_entry(),
				bQueryParamDTO.getDt_or_end(),
				id_ors.toArray(new String[id_ors.size()]),
				bQueryParamDTO.getFg_long(),
				bQueryParamDTO.getId_srvtp(),
				id_srvs.toArray(new String[id_srvs.size()]),
				bQueryParamDTO.getFg_bb(),
				"",
				""),
				BlIpOrdCgDTO.class);

		return resultDTOs;
	}

	/**
	 * 得到住院医生医嘱的记账明细
	 * @param bQueryParamDTO 查询条件
	 * @return
	 * @throws BizException
	 * @author xy.zhou 2018/07/31 xb 2019/03/04
	 */
	private BlIpCgDTO[] getIpOnlyDoctorOrderCgItems() throws BizException {
		// 获取医嘱已记账的费用
		BlIpCgDTO[] resultDTOs = (BlIpCgDTO[]) AppFwUtil
				.getDORstWithDao(new GetOrderDetailedQry(bQueryParamDTO), BlIpCgDTO.class);
		
		return resultDTOs;
	}

	/**
	 * 得到住院医生医嘱的未记账明细
	 * @param bQueryParamDTO 查询条件
	 * @return
	 * @throws BizException
	 * @author xy.zhou 2018/07/31 xb 2019/03/04
	 */
	private List<BlIpCgDTO> getOnlyDoctorOrderUnCgItems(BlIpOrdCgDTO[] allDoctorOrders, Boolean fg_emgstry) throws BizException {

		List<String> selectedOrderIds = new ArrayList<>();
		if (ArrayUtil.isEmpty((bQueryParamDTO.getId_or() == null ? null : bQueryParamDTO.getId_or().split(",")))) {
			for (BlIpOrdCgDTO bOrdCgDTO : allDoctorOrders) {
				selectedOrderIds.add(bOrdCgDTO.getId_or());
			}
		} else {
			selectedOrderIds.addAll(
					Arrays.asList((bQueryParamDTO.getId_or() == null ? null : bQueryParamDTO.getId_or().split(","))));
		}

		List<BlIpCgDTO> resultDTOs = setOrderNotCg(selectedOrderIds.toArray(new String[] {}), 
				bQueryParamDTO.getDt_or_entry(),
				bQueryParamDTO.getDt_or_end(),
				fg_emgstry);

		return resultDTOs;
	}

	
	private BlIpCgDTO[] getOepOnlyDoctorOrderCgItems() throws BizException {

		// 获取医嘱已记账的费用
		BlIpCgDTO[] resultDTOs = (BlIpCgDTO[]) AppFwUtil
				.getDORstWithDao(new GetOpOrderDetailedQry(bQueryParamDTO), BlIpCgDTO.class);
		
		return resultDTOs;
	}
	
	/**
	 * 通过母亲获取婴儿的就诊id
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private String[] getNewBBEnt(String id_ent) throws BizException {
		List<String> bbEnt = new ArrayList<String>();
		IEn4BlQryService ser = ServiceFinder.find(IEn4BlQryService.class);
		EnMomBabyInfoDTO[] babyEnt = ser.getMomBabyInfos(new String[] { id_ent });
		if (!ArrayUtils.isEmpty(babyEnt)) {
			for (EnMomBabyInfoDTO bb : babyEnt) {
				if (!StringUtils.isEmpty(bb.getId_ent_bb())) {
					bbEnt.add(bb.getId_ent_bb());
				}
			}
		}
		return bbEnt.toArray(new String[] {});
	}



}
